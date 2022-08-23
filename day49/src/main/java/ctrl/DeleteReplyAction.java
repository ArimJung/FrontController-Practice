package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.ReplyVO;

public class DeleteReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		ReplyVO rVO=new ReplyVO();
		BoardDAO rDAO=new BoardDAO();
		
		rVO.setRid(Integer.parseInt(request.getParameter("rid")));
		if(rDAO.deleteR(rVO)) {
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		else {
			System.out.println("deleteR 오류");
		}
		return forward;
	}

}
