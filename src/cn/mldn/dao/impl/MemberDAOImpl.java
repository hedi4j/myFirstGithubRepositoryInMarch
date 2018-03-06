package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IMemberDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vo.Member;

public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {
	@Override
	public boolean doUpdateLastdate(String id, Date date) throws SQLException {
		String sql = "UPDATE member SET lastdate=? WHERE mid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
		super.pstmt.setString(2, id);
		return super.pstmt.executeUpdate() > 0 ; 
	}
	
	@Override
	public boolean doUpdateLocktime(String id, Date date) throws SQLException {
		String sql = "UPDATE member SET locktime=? WHERE mid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		if (date == null) {	// 该解锁了
			super.pstmt.setNull(1, Types.NULL);
		} else {
			super.pstmt.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
		}
		super.pstmt.setString(2, id);
		return super.pstmt.executeUpdate() > 0 ; 
	}
	@Override
	public boolean doUpdateTrycount(String id, Integer trycount) throws SQLException {
		String sql = "UPDATE member SET trycount=? WHERE mid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setInt(1, trycount);
		super.pstmt.setString(2, id);
		return super.pstmt.executeUpdate() > 0 ;
	}
	
	@Override
	public boolean doCreate(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(Member vo) throws SQLException {
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
	public Member findById(String id) throws SQLException {
		Member vo = null ;
		String sql = "SELECT mid,name,password,lastdate,locked,trycount,locktime FROM member WHERE mid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, id);
		ResultSet rs = super.pstmt.executeQuery() ;
		if (rs.next()) {
			vo = new Member() ;
			vo.setMid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setPassword(rs.getString(3));
			vo.setLastdate(rs.getTimestamp(4));
			vo.setLocked(rs.getInt(5));
			vo.setTrycount(rs.getInt(6));
			vo.setLocktime(rs.getTimestamp(7)); 
		}
		return vo;
	}

	@Override
	public List<Member> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll(Long currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findSplit(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
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
