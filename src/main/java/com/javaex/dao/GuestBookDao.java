package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	public List<GuestBookVo> getList(){
		return sqlsession.selectList("guestbook.selectList");
	}
	
	public int insert(GuestBookVo vo) {
		return sqlsession.insert("guestbook.insertGuest", vo);
	}
	public int delete(GuestBookVo vo) {
		return sqlsession.delete("guestbook.deleteGuest", vo);
	}
	/*
	public int insert(GuestBookVo vo) {
		getConnection();
		StringBuffer sb = new StringBuffer();
		int cnt = 0;
		
		sb.append("INSERT INTO GUESTBOOK( ");
		sb.append("						NO, ");
		sb.append("						NAME, ");
		sb.append("						PASSWORD, ");
		sb.append("						CONTENT, ");
		sb.append("						REG_DATE) ");
		sb.append("VALUES ( ");
		sb.append(" 					seq_guestbook_no.nextval, ");
		sb.append("						?, ");
		sb.append("						?, ");
		sb.append("						?, ");
		sb.append("						SYSDATE)");
		
		String sql = sb.toString();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getName());
			pstm.setString(2, vo.getPassword());
			pstm.setString(3, vo.getContent());
			rs = pstm.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		cnt++;
		return cnt;
	}

	public int delete(GuestBookVo vo) {
		getConnection();
		StringBuffer sb = new StringBuffer();
		int cnt = 0;
		
		sb.append("DELETE FROM GUESTBOOK ");
		sb.append("WHERE NO = ? ");
		sb.append("AND PASSWORD = ? ");
		
		
		String sql = sb.toString();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, vo.getNo());
			pstm.setString(2, vo.getPassword());
			rs = pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		cnt++;
		return cnt;
	}
	*/
}
