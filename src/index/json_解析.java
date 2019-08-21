package index;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class json_解析 {
	
	/**
	 * key : FILES,FILE
	 * valuse : 数组,数据
	 * 
	 * 仅生成!
	 * 
	 */
	public json_解析() {
		// 生成样板数据
		
		JSONArray x_array = new JSONArray();
		for (int i = 0; i < 3; i++) {
			JSONObject x_object = new JSONObject();
			x_object.put("FILE", "C:\\Users\\lenovo\\Desktop\\阿里巴巴Java开发手册终极版v1.3.0.pdf");
			x_array.add(x_object);
		}
		
		JSONObject x_大_object = new JSONObject();
		x_大_object.put("FILES", x_array);
		
		
		//对数据进行格式化 / Format,好看些!
		String x_data = JSON.toJSONString(
				x_大_object);
		System.out.println(x_data);
	}
	/**
	 * @param 读取文件,解析json信息,打印
	 */
	public json_解析(int x_int)
	{
		File x_File=new File("C:\\Users\\lenovo\\Desktop\\mom.json");
		System.out.println(json_raed(x_File));		
	}
	
	/**
	 * @param 文件的绝对形式路径
	 * @return 返回 (内容转成) jsonObject,当前写法不怎么好,能用就行.
	 */
	public static JSONObject json_raed(File file) {
			FileInputStream x_filejson;
			String xstr="";
			try {
				x_filejson = new FileInputStream(file);
				int x_index=x_filejson.available();
				byte[] xbyte=new byte[x_index];
				x_filejson.read(xbyte);
				x_filejson.close();
				xstr=new String(xbyte);
			} catch (IOException e) {
				return null;
			}		
			return JSONObject.parseObject(xstr);
	}
	
	public static void main(String[] args) {
		json_解析 x=new json_解析();
		json_解析 x2=new json_解析(0);
	}
	
}
