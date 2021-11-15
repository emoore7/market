package chapter7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chap7FilterServlet1
 */
@WebServlet("/chap7/filter/servlet2")
public class Chap7FilterServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<<servlet1 호출 >>");
		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>여기는 Servlet2 입니다.</h>");
		out.print("<p>필터는 지정된 경로로 들어오는 요청과 나가는 응답에만 동작함</p>");
		
		// 필터에서 html의 나머지 태그등를 출력하고 있는 구조이므로
		// 서블릿에서 output stream을 닫으면 안됨
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
