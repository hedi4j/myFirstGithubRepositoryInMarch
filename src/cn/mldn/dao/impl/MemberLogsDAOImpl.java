package cn.mldn.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IMemberLogsDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vo.MemberLogs;

public class MemberLogsDAOImpl extends AbstractDAO implements IMemberLogsDAO  {

	@Override
	public boolean doCreate(MemberLogs vo) throws SQLException {
		String sql = "INSERT INTO member_logs(mid,logintime) VALUES (?,?)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, vo.getMid()); 
		super.pstmt.setTimestamp(2, new java.sql.Timestamp(vo.getLogintime().getTime()));
		return super.pstmt.executeUpdate() > 0 ;
	}

	@Override
	public boolean doEdit(MemberLogs vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MemberLogs findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberLogs> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberLogs> findAll(Long currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberLogs> findSplit(String column, String keyWord, Long currentPage, Integer lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getSplitCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	} 

	

}
