package spring.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.board.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService
{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<HashMap<String, String>> selectBoardList(HashMap<String, String> param) throws Exception
	{
		return boardDao.selectBoardList(param);
	}
}
