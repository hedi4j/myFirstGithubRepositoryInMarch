package cn.mldn.service.front.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cn.mldn.dao.IActionDAO;
import cn.mldn.dao.IMemberDAO;
import cn.mldn.dao.IMemberLogsDAO;
import cn.mldn.dao.IRoleDAO;
import cn.mldn.exception.login.MemberLockedException;
import cn.mldn.exception.login.MemberNotExistsException;
import cn.mldn.exception.login.PasswordValidateException;
import cn.mldn.service.front.IMemberServiceFront;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.vo.Member;
import cn.mldn.vo.MemberLogs;

public class MemberServiceFrontImpl extends AbstractService implements IMemberServiceFront {
	private static final int MAX_TRYCOUNT = 3 ;	// 最大的可实验次数
	private static final int MAX_UNLOCK_HOURS = 2 ;	// 最大的解锁小时
	
	@Override
	public Map<String, Object> login(String mid) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>() ;	// 保存所有的处理结果
		IMemberDAO memberDAO = Factory.getDAOInstance("member.dao") ;
		Member selectMember = memberDAO.findById(mid) ; // 根据用户编号查询出用户信息
		if (selectMember == null) {	// 用户信息不存在，不存在直接抛出异常
			throw new MemberNotExistsException("用户“"+mid+"”不存在！") ;
		}	
		
		if (selectMember.getLocked().equals(1)) {
			throw new MemberLockedException("用户“"+mid+"”已经被锁定，无法登录！") ;
		}
		map.put("name", selectMember.getName()) ;
		map.put("lastdate", selectMember.getLastdate()) ;
		
		IRoleDAO roleDAO = Factory.getDAOInstance("role.dao") ;
		IActionDAO actionDAO = Factory.getDAOInstance("action.dao") ;
		map.put("allRoles", roleDAO.findAllByMember(mid)) ;
		map.put("allActions", actionDAO.findAllByMember(mid)) ;
		
		IMemberLogsDAO memberLogsDAO = Factory.getDAOInstance("memberlogs.dao") ;
		Date currentDate = new Date() ;	// 获得当前时间，这个时间用于更新最后一次登录日期时间以及登录日志增加
		if (memberDAO.doUpdateLastdate(mid, currentDate)) { 
			MemberLogs logs = new MemberLogs() ;
			logs.setMid(mid);
			logs.setLogintime(currentDate); 
			memberLogsDAO.doCreate(logs) ;
		}
			
		return map ;
	}
	
	
	@Override
	public Map<String, Object> login(Member member) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>() ;	// 保存所有的处理结果
		IMemberDAO memberDAO = Factory.getDAOInstance("member.dao") ;
		boolean flag = false ;	// 保存登录成功的标记信息
		Member selectMember = memberDAO.findById(member.getMid()) ; // 根据用户编号查询出用户信息
		if (selectMember == null) {	// 用户信息不存在，不存在直接抛出异常
			throw new MemberNotExistsException("用户“"+member.getMid()+"”不存在！") ;
		}	
		// 后面为用户名存在的业务处理，应该首先进行锁定时间存在的检测  lpl为什么先检测locktime，后检测locked
		if (selectMember.getLocktime() != null) {	// 现在用户有被锁定的嫌疑
			long currentTime = System.currentTimeMillis() ;
			long lockTime = selectMember.getLocktime().getTime() ;
			if (TimeUnit.HOURS.convert((currentTime - lockTime), TimeUnit.MILLISECONDS) < MAX_UNLOCK_HOURS) {
				throw new MemberLockedException("用户“"+member.getMid()+"”登录失败次数过多，暂时锁定！") ;
			}
			// System.out.println("*********** 待解锁时间：" + (currentTime - lockTime));
		}
		
		
		if (selectMember.getLocked().equals(1)) {
			throw new MemberLockedException("用户“"+member.getMid()+"”已经被锁定，无法登录！") ;
		}
		if (member.getPassword().equals(selectMember.getPassword())) {	// 登录成功，密码正确
			flag = true ;	// 登录成功了
			map.put("name", selectMember.getName()) ;
			map.put("lastdate", selectMember.getLastdate()) ;
			memberDAO.doUpdateLocktime(member.getMid(), null) ;
			memberDAO.doUpdateTrycount(member.getMid(), 0) ; 
			
			IRoleDAO roleDAO = Factory.getDAOInstance("role.dao") ;
			IActionDAO actionDAO = Factory.getDAOInstance("action.dao") ;
			map.put("allRoles", roleDAO.findAllByMember(member.getMid())) ;
			map.put("allActions", actionDAO.findAllByMember(member.getMid())) ;
			
			IMemberLogsDAO memberLogsDAO = Factory.getDAOInstance("memberlogs.dao") ;
			Date currentDate = new Date() ;	// 获得当前时间，这个时间用于更新最后一次登录日期时间以及登录日志增加
			if (memberDAO.doUpdateLastdate(member.getMid(), currentDate)) { 
				MemberLogs logs = new MemberLogs() ;
				logs.setMid(member.getMid());
				logs.setLogintime(currentDate); 
				memberLogsDAO.doCreate(logs) ;
			}
			
		} else {	// 密码设置错误，应该做一个加法处理
			int trycount = selectMember.getTrycount() + 1 ;
			if (trycount > MAX_TRYCOUNT) {	// 应该设置锁定的时间
				memberDAO.doUpdateLocktime(member.getMid(), new Date()) ;	// 当前为锁定时间
			} else {	// 设置尝试的次数更新
				memberDAO.doUpdateTrycount(member.getMid(), trycount) ;
			}
			throw new PasswordValidateException("登录密码错误！") ;
		}
		map.put("flag", flag) ;
		return map ;
	}

}
