package och01;
//get은
/*request.setCharacterEncoding("utf-8"); 사용 해줘도 한글 안깨짐
post는 사용해야함.

멀티미디어 시에는 무조건 post 사용.*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Board
 */
@WebServlet("/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String title = request.getParameter("title") ;
		String writer = request.getParameter("writer") ;
		String content = request.getParameter("content") ;
		Date date= new Date();
		
		response.setContentType("text/html;charset=utf-8");  
		PrintWriter out = response.getWriter(); // **공식 : 화면에 뿌려주고 싶은것 
		out.println("<html><body>"); // 공식  
		out.println("<h1>게시판</h1>");
		out.println("제목: "+title+"<p>");
		out.println("작성자: "+writer+"<p>");
		out.println("작성일: "+date+"<p>"); //변수 선언시 date 사용.
		//out.println("작성일: "+new Date()+"<p>"); 변수 선언 안하고 그냥 new Date();해도됨.
		out.println("내용: <br><pre>"+content+"<pre>"); //<pre> 텍스트 </pre> - 소스에 표시한 공백이 그대로 표시됨. 프로그램 소스를 표시할 때 유용함
		out.println("</body></html>"); //공식
		out.close();
		doGet(request, response);
	}

}
