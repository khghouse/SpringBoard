package spring.board.dao;

import java.util.HashMap;
import java.util.List;

public interface BoardDao
{
	public List<HashMap<String, String>> selectBoardList(HashMap<String, String> param) throws Exception;
}
