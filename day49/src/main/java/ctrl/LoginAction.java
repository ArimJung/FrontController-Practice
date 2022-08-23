package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberVO mVO = new MemberVO();
		MemberDAO mDAO = new MemberDAO();
		
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		
		mDAO.selectOne(mVO);
		
			HttpSession session=request.getSession();
			session.setAttribute("mid", mVO.getMid());
			
			ActionForward forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);

			return forward;
	
	}

}
/*
		mVO=mDAO.selectOne(mVO);
		if(mVO!=null){
			session.setAttribute("mid", mVO.getMid());
			response.sendRedirect("ctrlB.jsp?action=main");
		}
		else{
			out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
*/
