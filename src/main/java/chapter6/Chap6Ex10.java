package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chap6Ex10
 */
@WebServlet("/chap6/ex10")
public class Chap6Ex10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward 메서드를 사용하면 제어가 완전히 다른 서블릿, JSP로 넘어가기 때문에
		// 이 서블릿에서 아래의 output stream으로 결과를 response를 하는 건 무시 됨
		// 그러나 여기서 output stream을 사용하고 있으므로 반드시 close 해줘야 함
		// forward 메서드 호출 후에  close해야 함
		response.setContentType("text/plain;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<< 첫 번째 서블릿의 실행 결과>>");
		//제어를 받을 다응ㅁ 서블릿 또는 JSP의 경로
		RequestDispatcher rd = request.getRequestDispatcher("/chap6/ex11");
		
		rd.forward(request, response);
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
