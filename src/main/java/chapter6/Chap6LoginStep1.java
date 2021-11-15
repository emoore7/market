package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 로그인 요청을 최초로 받는 서블릿이자 파라미털르 확인한느 서블릿
@WebServlet("/chap6/login/step1")
public class Chap6LoginStep1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터를 확인하는 코드
		
		String userID = request.getParameter("id");
		String userPW = request.getParameter("pw");
		
		if(userID != null && userPW != null) {
		// 문자열 앞 뒤 공배 제거
			userID = userID.trim();
			userPW = userPW.trim();
		}
		if((userID == null || userPW == null) || (userID.isEmpty() || userPW.isEmpty())) {
			//로그인에 필요한 파라미터를 전달하지 않았다면 BAD_Request 응답
			//response.setStatus(400);
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.print("브라우저의 뒤로 가기 버튼을 눌러 ID 또는 PW를 입력하세요.");
			
			out.close();
			
			return;
		}
		
		// 로그인에 필요한 파라미터를 전달했다면 다음 서블릿으로 forward
		RequestDispatcher rd = request.getRequestDispatcher("/chap6/login/step2");
		rd.forward(request, response);
		
		
		
		// 로그인에 필요한
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
