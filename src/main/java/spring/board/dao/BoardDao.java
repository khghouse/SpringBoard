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
	
	/**
	 * 2018-11-16 게시글 패스워드 등록
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public void insertBoardPwd(ParamMap param) throws Exception;
	
	/**
	 * 2018-11-18 게시글 조회수 증가
	 * @param param
	 * @throws Exception
	 */
	public void updateViewCnt(ParamMap param) throws Exception;
	
	/**
	 * 2018-11-18 게시글 상세보기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public RSMap selectBoardDetail(ParamMap param) throws Exception;
	
	/**
	 * 2018-11-18 게시글 SEQ 조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int selectBoardSeq(ParamMap param) throws Exception;
}
