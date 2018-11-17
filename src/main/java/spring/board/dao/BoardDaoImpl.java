package spring.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import spring.com.collections.ParamMap;
import spring.com.collections.RSMap;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class BoardDaoImpl extends SqlMapClientDaoSupport implements BoardDao
{
	@Autowired
	public BoardDaoImpl(SqlMapClient sqlMapClient)
	{
		super();
		setSqlMapClient(sqlMapClient);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RSMap> selectBoardList(ParamMap param) throws Exception
	{
		return getSqlMapClient().queryForList("Board.selectBoardList", param);
	}

	@Override
	public int insertBoardList(ParamMap param) throws Exception
	{
		return (Integer) getSqlMapClientTemplate().insert("Board.insertBoardList", param);
	}

	@Override
	public int insertBoardHierarchy(ParamMap param) throws Exception
	{
		return (Integer) getSqlMapClientTemplate().update("Board.insertBoardHierarchy", param);
	}

	@Override
	public void insertBoardPwd(ParamMap param) throws Exception
	{
		getSqlMapClientTemplate().insert("Board.insertBoardPwd", param);
	}
}
