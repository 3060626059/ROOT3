package root;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.tool.xtool;

/**
 * Servlet implementation class index2
 */
@WebServlet("/index2")
public class index2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		byte[] xbyte = xtool.x读取文本(new File("C:\\Users\\lenovo\\Desktop\\AppProjects\\项目 05-28_搬移\\ROOT3\\WebRoot\\New.html"));
		response.addHeader("Content-Length", xbyte.length+"");
		response.getOutputStream().write(xbyte);
		response.flushBuffer();
		xtool.x响应信息(response);
		
		
		File x任意类型=new File("C:\\Users\\lenovo\\Desktop\\root_tool.源码.解压.复制.jar");
			String xTypeValues = getServletContext().getMimeType(x任意类型.toString());
			System.out.println("任意路径文件的 Mime 类型:    "+xTypeValues);
			//getServletContext().get
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
