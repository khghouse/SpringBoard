package spring.main.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController
{
	@RequestMapping("/index.do")
	public String main(HttpServletRequest request, Model model) throws Exception
	{
		String returnView = "/main/index";
		
		return returnView;
	}
}
