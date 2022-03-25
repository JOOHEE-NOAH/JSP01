package och01;
//get은
/*request.setCharacterEncoding("utf-8"); 사용 해줘도 한글 안깨짐
post는 사용해야함.

멀티미디어 시에는 무조건 post 사용.*/
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
public class Add3 extends HttpServlet { //class로 받아도 상관없음
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
								//request는 주로 파라메터 값을 가져올때 사용
		int sum = 0;
		for(int i = 1; i<=num ; i++) {
			sum += i;
		}
		//나는 한글을 이용할거에요.라는 뜻. **공식처럼 외우기
		//request.setCharacterEncoding("utf-8");  get에서는 안써줘도 한글 안깨짐
		response.setContentType("text/html;charset=utf-8");  //공식-> out으로 출력되는 것들은 전부 사용자 browser에 보여주는 객체
		PrintWriter out = response.getWriter(); // **공식 : 화면에 뿌려주고 싶은것 보여주려 할때는 response사용(응답전송)
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
