package och01;

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
		//out.println("<h1>게시판</h1>");
		out.println("제목: <p>"+title);
		out.println("작성자: <p>"+writer);
		out.println("작성일: <p>"+date);
		out.println("내용: <p>"+content);
		out.println("</body></html>"); //공식
		out.close();
		doGet(request, response);
	}

}
