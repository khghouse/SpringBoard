package spring.board.dao;

import java.util.List;

import spring.com.collections.ParamMap;
import spring.com.collections.RSMap;

public interface BoardDao
{
	/**
	 * 2018-11-13 게시판 리스트 조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<RSMap> selectBoardList(ParamMap param) throws Exception;
	
	/**
	 * 2018-11-13 게시글 등록
	 * @param param
	 * @throws Exception
	 */
	public int insertBoardList(ParamMap param) throws Exception;
	
	/**
	 * 2018-11-13 게시글 계층구조 등록
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int insertBoardHierarchy(ParamMap param) throws Exception;
}
