package spring.board.service;

import java.util.HashMap;
import java.util.List;

public interface BoardService
{
	public List<HashMap<String, String>> selectBoardList(HashMap<String, String> param) throws Exception;
}
