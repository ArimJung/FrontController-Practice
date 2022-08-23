package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

public class InsertMemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		MemberVO mVO = new MemberVO();
		MemberDAO mDAO = new MemberDAO();

		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		mVO.setMname(request.getParameter("mname"));
		
		if(mDAO.insert(mVO)) {
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		else {
			System.out.println("insertM 오류");
		}
		return forward;
	}
}
/*
if(mDAO.insert(mVO)){
out.println("<script>alert('회원가입 완료!');opener.parent.location.reload();window.close();</script>");
}
else{
out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
}
*/