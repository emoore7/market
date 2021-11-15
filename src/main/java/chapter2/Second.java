package chapter2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/second", name="two")
public class Second extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Second 서블릿의 doGet() 메서드 호출!");
	}

	
//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//클라이언트가 어떤 방식으로 요청하더라도 service 메서드가 호출됨
		// 클라이언트가 GET 방식으로 요청했다는 건 컨텐트를 전달 받기만 하기 위함이고
		// 클라이언트가 POST 방식으로 요청했다는 건 컨텐트를 생성 하기 위함임
		// 실제로 개발할때는 service()메서드를 오버라이딩하지 않고
		// 사용자의 요청 방식에 맞는 처리를 할 수 있는 다른 메서드를 오버라이딩함
//		System.out.println("Second 서블릿의 service() 메서드 호출!");
//	}

}
