package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;

public class DeleteBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		BoardVO bVO=new BoardVO();
		BoardDAO bDAO=new BoardDAO();
		
		bVO.setBid(Integer.parseInt(request.getParameter("bid")));
		if(bDAO.delete(bVO)) {
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		else {
			System.out.println("deleteB 오류");
		}
		
		return forward;
	}

}
/*
 * 	if(bDAO.delete(bVO)){
			response.sendRedirect("ctrlB.jsp?action=main");
		}
		else{
			throw new Exception("deleteB 오류");
		}
 */
