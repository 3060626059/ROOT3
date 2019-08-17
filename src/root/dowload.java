package root;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.tool.dowloadS;


/**
 * 把完整下载代码集在一个类,供必要时参考
 * 复制过来的代码比我自己写的还多
 * 不好翻译,不过这个下载功能算是完善了
 */
@WebServlet("/dowload")
public class dowload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public dowload() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException {
		// 待传输文件
		File xfile = new File("C:\\Users\\lenovo\\Desktop\\2017_com.tencent.tmgp.sgame_h9389_1.45.1.23_60f6b2.apk");
		
		// 这需要设置传输文件的路径即可,其它不用管
		
		dowloadS.x_下载_传输流(request, response, xfile);
		
	}		
}
 
 







