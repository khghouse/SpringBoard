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
		
		// 답글쓰기일 경우 seq를 구한다.
		if(((String) param.get("mode")).equals("R"))
		{
			int seq = boardDao.selectBoardSeq(param);
			param.put("seq", seq);
		}
		
		// 게시글 계층구조 등록
		param.put("no", no);
		int resultFlag = boardDao.insertBoardHierarchy(param);
		
		// 게시글 패스워드 등록 *** 로그인 기능을 붙인다면 수정 필요 ***
		boardDao.insertBoardPwd(param);
		
		if(resultFlag == 1)
		{
			returnMsg = "등록되었습니다.";
		}
		
		return returnMsg;
	}

	@Override
	public RSMap selectBoardDetailProcess(ParamMap param) throws Exception
	{
		RSMap boardMap = new RSMap();
		
		// 조회수 증가
		boardDao.updateViewCnt(param);
		
		// 게시글 상세 정보
		boardMap = boardDao.selectBoardDetail(param);
		
		return boardMap;
	}
}
