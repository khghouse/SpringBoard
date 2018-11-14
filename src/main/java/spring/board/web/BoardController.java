package spring.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.lang.StringUtils;

import spring.board.service.BoardService;
import spring.com.collections.ParamMap;
import spring.com.collections.RSMap;

@Controller
@RequestMapping("/board")
public class BoardController
{
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board.do")
	public String board(HttpServletRequest request, Model model) throws Exception
	{
		String returnView = "/board/boardList";
		String boardId = StringUtils.defaultIfEmpty(request.getParameter("board_id"), "");
		String mode = StringUtils.defaultIfEmpty(request.getParameter("mode"), "L");
		String scriptMessage = "";
		
		ParamMap param = new ParamMap();
		param.setRequest(request);
		
		List<RSMap> boardList = null;
		
		if(mode.equals("I")) // insert
		{
			// 게시글 등록 프로세스
			scriptMessage = boardService.insertBoardProcess(param);
			mode = "L";
		}
		if(mode.equals("L")) // select list
		{
			boardList = boardService.selectBoardList(param);
			model.addAttribute("userRegYn", boardList.get(0).get("USER_REG_YN"));
			model.addAttribute("boardList", boardList);
		}
		
		model.addAttribute("scriptMessage", scriptMessage);
		model.addAttribute("boardId", boardId);
		
		return returnView;
	}
	
	@RequestMapping("/boardForm.do")
	public String boardReg(HttpServletRequest request, Model model) throws Exception
	{
		String returnView = "";
		String boardId = StringUtils.defaultIfEmpty(request.getParameter("board_id"), "");
		String mode = StringUtils.defaultIfEmpty(request.getParameter("mode"), "");
		
		if(mode.equals("I"))
		{
			returnView = "/board/boardReg";
		}
		else if(mode.equals("U"))
		{
			returnView = "/board/boardMod";
		}
		
		model.addAttribute("boardId", boardId);
		
		return returnView;
	}
}
