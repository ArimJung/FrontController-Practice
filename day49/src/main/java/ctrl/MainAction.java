package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardSet;
import board.BoardVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request.setCharacterEncoding("UTF-8");  // 필터가 있기 때문에 작성하지 않아도 됨
		// response.setCharacterEncoding("UTF-8");
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		String paramCnt=request.getParameter("cnt");
		if(paramCnt==null || paramCnt.equals("")) {
			bVO.setCnt(2);
		}
		else {
			bVO.setCnt(Integer.parseInt(paramCnt));
		}

		ArrayList<BoardSet> datas = bDAO.selectAll(bVO);
		request.setAttribute("datas", datas);
		request.setAttribute("cnt", bVO.getCnt());
		
		ActionForward forward = new ActionForward();
		forward.setPath("/main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}

/*
ArrayList<BoardSet> datas=bDAO.selectAll(bVO);
request.setAttribute("datas", datas);
request.setAttribute("cnt", bVO.getCnt());
pageContext.forward("main.jsp");
*/