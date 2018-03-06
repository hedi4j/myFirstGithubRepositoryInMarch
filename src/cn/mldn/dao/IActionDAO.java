package cn.mldn.dao;

import java.sql.SQLException;
import java.util.Set;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vo.Action;

public interface IActionDAO extends IBaseDAO<String, Action> {
	/**
	 * 根据用户的名称获取对应的所有权限编号
	 * @param mid 用户编号
	 * @return 权限编号集合
	 * @throws SQLException JDBC
	 */
	public Set<String> findAllByMember(String mid) throws SQLException ;
}
