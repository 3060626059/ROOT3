package root;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.root.Range;
import root.tool.dowloadS;
import root.tool.xtool;

/**
 * Servlet implementation class index
 */
@WebServlet("/in")
// 访问路径设置成 / 则无法访问静态资源
public class index extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Full range marker.
	 */
	protected static final ArrayList<Range> FULL = new ArrayList<>();
	
	
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
			byte[] xbyte = xtool.x读取文本(new File(
			                "C:\\Users\\lenovo\\Desktop\\AppProjects\\项目 05-28_搬移\\ROOT3\\WebRoot\\NewFile.html"));
			response.addHeader("Content-Length", xbyte.length + "");
			response.getOutputStream().write(xbyte);
			response.flushBuffer();
			xtool.x响应信息(response);
			xtool.x请求信息(request);
			
		} else {
			switch (xParameter.nextElement()) {
				
				case "x0":
					// 视频请求
					File x_文件 = new File("D:\\视频\\超兽武装\\超兽武装 - RevEvolution 35.mp4");
					try {
						dowloadS.x_传输流(request, response, x_文件);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// x_传输文件流(request, response, x_文件);
					// x文件下载段_传输视频(request, response);
				// 怎么串
				break;
				case "x2":
					xtool.x404_回复(response);
					//x_下载_传输文件流(request, response, x_文件);
				break;
				case "x4":
					xtool.x404_回复(response);
				break;
				default:
					xtool.x404_回复(response);
				break;
			}
		}
		
	}
	
	public index() {
		super();
	}
		
}
