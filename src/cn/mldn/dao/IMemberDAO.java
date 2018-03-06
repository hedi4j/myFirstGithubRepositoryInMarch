package cn.mldn.dao;

import java.sql.SQLException;
import java.util.Date;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vo.Member;

public interface IMemberDAO extends IBaseDAO<String, Member> {
	/**
	 * 进行最后一次登录日期的更新处理操作
	 * @param id 要更新的用户编号
	 * @param date 当前日期
	 * @return 更新成功返回true
	 * @throws SQLException SQL
	 */
	public boolean doUpdateLastdate(String id,Date date) throws SQLException ;
	/**
	 * 进行locktime字段的修改处理操作，如果没有锁定则locktime字段的内容必须为null
	 * @param id 要修改的用户id
	 * @param date 当前的锁定的时间
	 * @return 修改成功返回true
	 * @throws SQLException JDBC
	 */
	public boolean doUpdateLocktime(String id,Date date) throws SQLException ;
	/**
	 * 进行登录失败次数的修改处理操作
	 * @param id 用户id
	 * @param trycount 最新的登录失败次数
	 * @return 修改成功返回true，否则返回false
	 * @throws SQLException JDBC
	 */
	public boolean doUpdateTrycount(String id,Integer trycount) throws SQLException ;
}
