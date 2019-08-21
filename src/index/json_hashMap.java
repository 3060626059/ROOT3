package index;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class json_hashMap {
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
			xstr = new String(xbyte);
		} catch (IOException e) {
			return null;
		}
		return JSONObject.parseObject(xstr);
	}
	
	/**
	 * 数据储存集合
	 */
	protected static HashMap<String, String> x_hashMap = new HashMap<String, String>(89);	
	static {
		// 初始化 HashMap,填充 值!
		File x_Files = new File("C:\\Users\\lenovo\\Desktop\\mom.json");
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
		// 请求模板 ?xValuse=(类型值) 请求网页_文件信息显示网页
		//               ?xDowload=(文件信息) 下载文件
		// 仅需要用 ?xDowload=
		
		StringBuilder x_s=new StringBuilder();
		Set<String> x_hashMap_keySet = x_hashMap.keySet();
		for (String x_keyL : x_hashMap_keySet) {
			File xFile=new File(x_hashMap.get(x_keyL));
			String xName=xFile.getName();
			x_s.append("<br><a href=\"./");
			x_s.append("?xDowload="+x_keyL);// Servlet+请求参数
			x_s.append( "\">");
			x_s.append(xName);// 名字
			x_s.append("</a><br><br>");
		}
		return x_s;
	}
	
	public static void main(String[] args) {
		String x_valuse = x_hashMap.get("无中生有");
		System.out.println("  "+x_valuse);
		if (x_valuse==null) {
			throw new NullPointerException("在 x_hashMap 不存在这个键 : "+"无中生有");
		}
		// json_hashMap json_hashMap=new json_hashMap(); 
		// System.out.println(x_HashMap_to_HTML());
	}
	
}
