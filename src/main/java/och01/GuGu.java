package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuGu
 */
@WebServlet("/GuGu")
public class GuGu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuGu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num")) ;

		//나는 한글을 이용할거에요.라는 뜻. **공식처럼 외우기
		//request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8");  
		PrintWriter out = response.getWriter(); // **공식 : 화면에 뿌려주고 싶은것 
		out.println("<html><body>"); // 공식  
		out.println("<h1>구구단</h1>");
		for(int i = 1; i<=9 ; i++) {
		out.println(num + "*" +i+ "=" +(num*i)+"<br>");
		}
		out.println("</body></html>"); //공식
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
