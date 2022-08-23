package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.ReplyVO;

public class InsertReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		ReplyVO bVO=new ReplyVO();
		BoardDAO bDAO=new BoardDAO();
		
		bVO.setMid(request.getParameter("mid"));
		bVO.setMid(request.getParameter("bid"));
		bVO.setRmsg(request.getParameter("rmsg"));
		
		if(bDAO.insertR(bVO)) {
			forward.setPath("/main.jsp");
			forward.setRedirect(true);
		}
		else {
			System.out.println("insertR 오류");
		}
		
		return forward;
	}

	
}
