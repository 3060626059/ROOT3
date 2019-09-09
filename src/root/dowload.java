package root;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import root.tool.dowloadS;
import root.tool.xtool;


/**
 * 把完整下载代码集在一个类,供必要时参考
 * 复制过来的代码比我自己写的还多
 * 不好翻译,不过这个下载功能算是完善了
 */
@WebServlet(name = "dowload",urlPatterns = {"/dowload","/dow"})
public class dowload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @param 待读取的文件绝对形式路径
	 * @return 返回 json对象形式的结果
	 */
	public static JSONObject x_json_raed(File file) {
		FileInputStream x_filejson;
		String xstr = "";
		try {
			x_filejson = new FileInputStream(file);
			int x_index = x_filejson.available();
			byte[] xbyte = new byte[x_index];
			x_filejson.read(xbyte);
			x_filejson.close();
			xstr = new String(xbyte,"UTF-8");
		} catch (IOException e) {
			return null;
		}
		return JSONObject.parseObject(xstr);
	}
	
	/**
	 * 储存数据的集合
	 */
	protected static HashMap<String, String> x_hashMap = new HashMap<String, String>(89);	
	static {
		// 初始化 HashMap,填充 值!
		File x_Files = new File("C:\\Users\\lenovo\\Desktop\\config.json");
		JSONObject x_jsonO = x_json_raed(x_Files);
		JSONArray x_jsonO_FILES = x_jsonO.getJSONArray("FILES");
		for (int i = 0; i < x_jsonO_FILES.size(); i++) {
			JSONObject x_jsonO_FILE = x_jsonO_FILES.getJSONObject(i);
			String x_valuse = x_jsonO_FILE.getString("FILE");
			File x_File = new File(x_valuse);
			// 父级路径的名字+文件名字
			String x_key=x_File.getParentFile().getName()+
					      x_File.getName();
			x_hashMap.put(x_key, x_valuse);
		}
	}
	
	/**
	 * @return  读取hashmap,将结果组成网页模板 <br><a href="./servlet及参数">名字</a><br><br>,返回数据
	 */
	public static StringBuilder x_HashMap_to_HTML() {
		// 网页模板 <br><a href="./servlet及参数">名字</a><br><br>
		// 请求模板 ./dowload?xValuse=(类型值) 请求网页_文件信息显示网页
		//               ./dowload?xDowload=(文件信息) 下载文件
		// 仅需要用 ./dowload?xDowload=
		// 最终模板 <br><a href="./dowload?xDowload=">名字</a><br><br>
		// 由于是不同的servlet一起协同,所以需要 当前环境 ./  + servlet 才能正确访问
		// 修改 在主页中有类型美化脚本,在Java代码中修改调用
		// 我只是想看看,对未来会造成难维护,会修改
		// 这种在 java 代码中的 HTML模块,修改很不友好,
		// 设计一个专门负责 HTML模块的对象,在这个对象中修改较好
		// 就不会动了不该动的代码
		
		
		StringBuilder x_s=new StringBuilder();
		Set<String> x_hashMap_keySet = x_hashMap.keySet();
		for (String x_keyL : x_hashMap_keySet) {
			File xFile=new File(x_hashMap.get(x_keyL));
			String xName=xFile.getName();
			x_s.append("<br><a href=\"./dowload?xDowload="+x_keyL+"\">"+xName+"</a><br><br>");
		}
		return x_s;
	}

	
	/**
	 * @param 根据所给的键从 hashMap 中取值
	 * @return 文件绝对形式路径
	 */
	public static File x_HashMap_get_FILE(String x_keyString) {
		String x_valuse = x_hashMap.get(x_keyString);
		if (x_valuse==null) {
			throw new NullPointerException("HashMap 中找不到该键 "+x_keyString+" !");
		}
		if (new File(x_valuse).exists()==false) {
			throw new NullPointerException(x_keyString+" : 键所对应的文件已经不存在!");
		}
		return new File(x_valuse);
	}
	
	
	/**
	 * 参数范围:
	 * ?xValuse=(类型值) 请求网页_文件信息显示网页
	 * ?xDowload=(文件信息) 下载文件
	 * 
	 * 
	 */
	public dowload() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException {
		
		
		// 处理携带参数的请求
		// 获取所有带参数的请求
		Enumeration<String> x_Parameter = request.getParameterNames();
		if (x_Parameter.hasMoreElements()) {
			switch (x_Parameter.nextElement()) {
				case "xValuse":
					try {
						xtool.x_HTML_to_Byte_to_Response(x_HashMap_to_HTML(), response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				/*
				 * getbytes 没有指定编码会使用系统的 GBK编码,在浏览器以 UTF-8进行解码
				 * 会乱码
				 * response.setCharacterEncoding("utf-8");
				 * response.setContentType("text/html;charset=utf-8"); byte[] xbyte
				 * =x_HashMap_to_HTML().toString().getBytes();
				 * response.addHeader("Content-Length", xbyte.length + "");
				 * response.getOutputStream().write(xbyte); response.flushBuffer();
				 */
				break;
				
				case "xDowload":
					String x_parameter_参数 = request.getParameter("xDowload");
					File x_File=x_HashMap_get_FILE(x_parameter_参数);
					dowloadS.x_下载_传输流(request, response, x_File);
				break;
				
				default:
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>下面是就代码,不想改旧代码
		
		// 待传输文件
		File xfile = new File("C:\\Users\\lenovo\\Desktop\\2017_com.tencent.tmgp.sgame_h9389_1.45.1.23_60f6b2.apk");
		
		// 这需要设置传输文件的路径即可,其它不用管
		
		dowloadS.x_下载_传输流(request, response, xfile);
		
	}	
}
 
 







