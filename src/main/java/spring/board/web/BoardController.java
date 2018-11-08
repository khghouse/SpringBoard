package spring.board.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController
{
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/boardList.do")
	public String boardList(HttpServletRequest request, Model model) throws Exception
	{
		String returnView = "/board/boardList";
		
		HashMap<String, String> param = new HashMap<String, String>();
		List<HashMap<String, String>> boardList = boardService.selectBoardList(param);
		
		model.addAttribute("boardList", boardList);
		
		return returnView;
	}
}
