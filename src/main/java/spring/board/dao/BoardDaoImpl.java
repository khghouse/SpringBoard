package spring.board.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

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
	public List<HashMap<String, String>> selectBoardList(HashMap<String, String> param) throws Exception
	{
		return getSqlMapClient().queryForList("Board.selectBoardList", param);
	}
}
