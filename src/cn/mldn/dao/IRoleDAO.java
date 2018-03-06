package cn.mldn.dao;

import java.sql.SQLException;
import java.util.Set;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vo.Role;

public interface IRoleDAO extends IBaseDAO<String, Role> {
	/**
	 * 根据用户编号查询出该用户对应的所有的角色编号信息
	 * @param mid 用户编号
	 * @return 该用户的所有角色数据
	 * @throws SQLException JDBC
	 */
	public Set<String> findAllByMember(String mid) throws SQLException ;
}
