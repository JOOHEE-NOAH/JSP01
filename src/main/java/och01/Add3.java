package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//목표: 1부터의 누적값 전달
		int num = Integer.parseInt(request.getParameter("num")) ; //request로 가져온것은 숫자여도 text형식이므로 parsing해줘야 한다.
		int sum = 0;
		for(int i = 1; i<=num ; i++) {
			sum += i;
		}
		//나는 한글을 이용할거에요.라는 뜻. **공식처럼 외우기
		//request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8");  
		PrintWriter out = response.getWriter(); // **공식 : 화면에 뿌려주고 싶은것 
		out.println("<html><body>"); // 공식  
		//out.println("<h1>1부터 "+num+"까지 합계</h1>");
		out.printf("<h1>1부터 %d까지 합계</h1>", num);
		out.println(sum);
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
