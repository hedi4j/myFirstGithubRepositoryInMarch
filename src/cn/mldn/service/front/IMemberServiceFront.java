package cn.mldn.service.front;

import java.util.Map;

import cn.mldn.vo.Member;

public interface IMemberServiceFront {
	/**
	 * 免登录的用户信息获取操作，需要获取name、lastdate、allRoles、allActions
	 * @param mid
	 * @return 返回的内容包含有如下数据：<br>
	 * <li>1、key = name、value = 该用户的真实姓名。</li>
	 * <li>2、key = lastdate、value = 用户最后一次登录日期时间；<li>
	 * <li>3、key = allRoles、value = 用户对应的所有角色，Set集合；</li>
	 * <li>4、key = allActions、value = 用户对应的所有权限，Set集合；</li>
	 * @throws Exception 抛出状态的处理异常
	 */
	public Map<String,Object> login(String mid) throws Exception ;
	/**
	 * 实现用户的登录处理操作，该操作要执行如下的几步：<br>
	 * <li>1、调用IMemberDAO.findById()方法根据用户名查找用户的信息，随后进行密码比对，如果密码正确则表示登录成功；</li>
	 * <li>2、当登录成功之后应该根据用户编号获得用户对应的角色与权限数据信息；</li>
	 * @param member 包含有用户登录名（mid）与密码（password）两个重要的信息
	 * @return 返回的内容包含有如下数据：<br>
	 * <li>1、key = flag、value = 登录成功或失败的信息。</li>
	 * <li>2、key = name、value = 该用户的真实姓名。</li>
	 * <li>3、key = lastdate、value = 用户最后一次登录日期时间；<li>
	 * <li>4、key = allRoles、value = 用户对应的所有角色，Set集合；</li>
	 * <li>5、key = allActions、value = 用户对应的所有权限，Set集合；</li>
	 * @throws Exception 抛出状态的处理异常
	 */
	public Map<String,Object> login(Member member) throws Exception ;
}
