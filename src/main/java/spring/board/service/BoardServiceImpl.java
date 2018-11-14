package spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.board.dao.BoardDao;
import spring.com.collections.ParamMap;
import spring.com.collections.RSMap;

@Service
public class BoardServiceImpl implements BoardService
{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<RSMap> selectBoardList(ParamMap param) throws Exception
	{
		return boardDao.selectBoardList(param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String insertBoardProcess(ParamMap param) throws Exception
	{
		String returnMsg = "";
		
		// 게시글 등록
		int no = boardDao.insertBoardList(param);
		
		// 게시글 계층구조 등록
		param.put("no", no);
		int resultFlag = boardDao.insertBoardHierarchy(param);
		
		if(resultFlag == 1)
		{
			returnMsg = "등록되었습니다.";
		}
		
		return returnMsg;
	}
}
