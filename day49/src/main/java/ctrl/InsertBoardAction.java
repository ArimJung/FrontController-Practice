package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;

public class InsertBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		BoardVO bVO=new BoardVO();
		BoardDAO bDAO=new BoardDAO();
		
		bVO.setMid(request.getParameter("mid"));
		bVO.setMsg(request.getParameter("msg"));
		
		if(bDAO.insert(bVO)) {
			forward.setPath("main.do");
			forward.setRedirect(false);
		}
		else {
			System.out.println("insertB 오류");
		}
		
		return forward;
	}

	
}
/*	if(bDAO.insert(bVO)){
response.sendRedirect("ctrlB.jsp?action=main");
}
else{
throw new Exception("insertB 오류");
}
*/
