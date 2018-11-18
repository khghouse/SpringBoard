package spring.board.service;

import java.util.List;

import spring.com.collections.ParamMap;
import spring.com.collections.RSMap;

public interface BoardService
{
	/**
	 * 2018-11-13 게시판 리스트 조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<RSMap> selectBoardList(ParamMap param) throws Exception;
	
	/**
	 * 2018-11-13 게시글 등록 프로세스
	 * @param param
	 * @throws Exception
	 */
	public String insertBoardProcess(ParamMap param) throws Exception;
	
	/**
	 * 2018-11-18 게시글 상세보기 프로세스
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public RSMap selectBoardDetailProcess(ParamMap param) throws Exception;
}
