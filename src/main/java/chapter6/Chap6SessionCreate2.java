package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Chap6SessionCreate2
 */
@WebServlet("/chap6/session/create2")
public class Chap6SessionCreate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6SessionCreate2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		// 이 클라이언트의 세션이 만들어져 있으면
		// 만들어진 세션을 반환 , 그렇지 않으면 또는 유효 기간이 지난 세션이면 새롭게 만들어 반환
		HttpSession session = request.getSession();
		
		if(session == null) {
			// 이 클라이언트 세션을 가져오지 못했을 때
			out.print("<p>세션 없음</p>");
		} else {
			out.print("<p>세션 있음</p>");
			
			if(session.isNew()) {
				out.print("<p>세션이 새로 만들어짐</p>");
				
				// 세션이 만들어질때 기본 30분 유지
				//
				session.setMaxInactiveInterval(10800);
			} else {
				out.print("<p>기존에 만들어졌던 세션임</p>");
			}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
