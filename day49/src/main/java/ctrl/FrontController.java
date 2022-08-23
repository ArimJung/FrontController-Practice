package ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet({"*.do"}) // *.do 요청을 수행하면 해당 어노테이션에 의해 FC로 오게됨!!
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() { // 기본 생성자가 반드시 필요 >> 
    	// FrontController fc= new FrontController(); xxx 뉴를 하지 않아도 메서드를 사용하고 있었다
    	// 객체화를 하지 않았는데, 매서드를 사용할 수 있었다.?
    	// 서블릿 컨테이너(==객체를 관리하는 것) == 웹 서버 == 톰캣이 서블릿을 객체화 해주고 있었음!!
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response); 
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 추출
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String command = uri.substring(cp.length());
		//System.out.println(uri); // /day49/index.do
		//System.out.println(cp); 	// /day49
		System.out.println(command);
		
		// 요청 보냄
		ActionForward forward=null;
		if(command.equals("/main.do")) {
			// 메인보여주는 C불러와...
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/insert.do")) {
			try {
				forward = new InsertMemberAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/logout.do")) {
			try {
				forward = new LogoutAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/login.do")) {
			try {
				forward = new LoginAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/insertB.do")) {
			try {
				forward = new InsertBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/insertR.do")) {
			try {
				forward = new InsertReplyAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/deleteB.do")) {
			try {
				forward = new DeleteBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/deleteR.do")) {
			try {
				forward = new DeleteReplyAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		if(forward==null) {
			forward=new ActionForward();
			forward.setPath("error/error.jsp");
			forward.setRedirect(false);
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
		try {
			dispatcher.forward(request, response);
			// : 타겟페이지(인자)로 request, response 객체를 전달하는 메서드
			// : 제어권을 넘겨줌 -> 클라이언트가 응답을 확인할 수 있음
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		*/
		
		// 권장 x
		if(forward!=null) {
			//디스패쳐 만들어서 타겟페이지로 이동
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		PrintWriter out = response.getWriter();
		out.println("<script>alert('요청처리실패!');history.go(-1);</script>");
		
	}
	
}
