package root;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.tool.xtool;

/**
 * Servlet implementation class index 问题 不知道如何解决 / 路径下没办法读取 js ,css 文件 但是 tomcat
 * 404 却能加载 js , css 文件
 */
@WebServlet(name = "index", urlPatterns = { "/", "/in", "/index" })
// 访问路径设置成 / 则无法访问静态资源
public class index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException {
		doGet(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException {
		
		Enumeration<String> xParameter = request.getParameterNames();
		// 没有携带参数
		if (!xParameter.hasMoreElements()) {
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			// byte[] xbyte = xtool.x读取文本(new File(
			// "C:\\Users\\lenovo\\Desktop\\AppProjects\\项目
			// 05-28_搬移\\ROOT3\\WebRoot\\NewFile.html"));
			// 使用发布后项目内的资源文件
			// 而不是开发时的指定路径
			
			File x_HTML = new File(getServletContext().getRealPath(""), "NewFile.html");
			// File x_HTML1 = new File("C:\\Users\\lenovo\\Desktop\\AppProjects\\项目 05-28_搬移\\ROOT3\\WebRoot\\", "NewFile.html");
			
			try {
				xtool.x_HTML_to_Byte_to_Response(x_HTML, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			switch (xParameter.nextElement()) {
				
				case "x0":
					
					// 异步请求 返回所有servlet的入口信息
					StringBuilder x_info = xtool.x_servlet_urlPatterns_扫描_to_HTML(request);
					try {
						xtool.x_HTML_to_Byte_to_Response(x_info, response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					// 视频请求
					// File x_文件 = new File("D:\\视频\\超兽武装\\超兽武装 - RevEvolution 35.mp4");
					// try {
						// dowloadS.x_传输流(request, response, x_文件);
					// } catch (Exception e) {
					// 	e.printStackTrace();
					// }
				break;
				case "x2":
					xtool.x404_回复(response);
				break;
			}
		}
		
	}
	
	public index() {
		super();
	}
	
}
