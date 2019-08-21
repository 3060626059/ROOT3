package root;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.tool.dowloadS;

/**
 * Servlet implementation class 超兽武装
 *
 *@WebServlet("/超兽武装")
 **/
@WebServlet(name = "超兽武装" ,urlPatterns = {"/超兽武装","/cswz"})
public class 超兽武装 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public 超兽武装() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException {
		
		Enumeration<String> x_Parameter = request.getParameterNames();
		boolean x_参数_exists = x_Parameter.hasMoreElements();
		// true 是视频请求
		// false 是网页请求
		if (x_参数_exists) {
			// x0 = 视频请求
			// x3 = 网页请求
			switch (x_Parameter.nextElement()) {
				case "x0":
					String x_keyL = request.getParameter("x0");
					File x_file = new File(x_map.get(x_keyL));
					try {
						dowloadS.x_传输流(request, response, x_file);
					} catch (Exception e) {
						e.printStackTrace();
					}
				break;
				
				case "x5":
					String x_values = request.getParameter("x5");
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");
					byte[] xbyte = 
							x_html_index(x_html_video_值_处理(x_values))
							.toString().
							getBytes();	
					response.addHeader("Content-Length", xbyte.length + "");
					response.getOutputStream().write(xbyte);
					response.flushBuffer();
				break;
				
				default:
				break;
			}
			
			
		} else {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			byte[] xbyte = x_html_index(x_html_video_值_处理("超兽武装之仁者无敌- 1  平行宇宙")).toString().getBytes();	
			response.addHeader("Content-Length", xbyte.length + "");
			response.getOutputStream().write(xbyte);
			response.flushBuffer();
		}
		
		
	}
	private StringBuilder x_html_index(StringBuilder x_values) {
		StringBuilder x_str = new StringBuilder();
		x_str.append("<!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"UTF-8\">" + 
				"<title>超兽武装 仁者无敌 勇者无惧 在线观看</title>" + 
				"</head>" + 
				"<body>" + 
				x_values+
				x_html_href+
				"</body>" + 
				"</html>");
		
		return x_str;
	}
	private StringBuilder x_html_video_值_处理(String x_values) {
		StringBuilder x_str = new StringBuilder();
		x_str.append("<br>	" + 
				"<video controls autoplay=\"true\">" + 
				"<source src=\"?x0="+x_values+"\" type=\"video/mp4\">" + 
				"</video>" + 
				"<br>");
		return x_str;
	}
	
	
	static HashMap<String, String> x_map = new HashMap<String, String>();
	static Set<String> x_key =null;
	static StringBuilder x_html_index = new StringBuilder();
	static StringBuilder x_html_href = new StringBuilder();
	static {
		x_map.put("超兽武装之仁者无敌- 1  平行宇宙", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 01.mp4");
		x_map.put("超兽武装之仁者无敌- 2  玄易大师", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 02.mp4");
		x_map.put("超兽武装之仁者无敌- 3  狮王超兽", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 03.mp4");
		x_map.put("超兽武装之仁者无敌- 4  使命召唤", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 04.mp4");
		x_map.put("超兽武装之仁者无敌- 5  冥王复活", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 05.mp4");
		x_map.put("超兽武装之仁者无敌- 6  使命轮回", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 06.mp4");
		x_map.put("超兽武装之仁者无敌- 7  第二平行宇宙", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 07.mp4");
		x_map.put("超兽武装之仁者无敌- 8  蝎王超兽", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 08.mp4");
		x_map.put("超兽武装之仁者无敌- 9  热血交融", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 09.mp4");
		x_map.put("超兽武装之仁者无敌- 10  往事如烟", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 10.mp4");
		x_map.put("超兽武装之仁者无敌- 11  超兽神二合体", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 11.mp4");
		x_map.put("超兽武装之仁者无敌- 12  第三平行宇宙", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 12.mp4");
		x_map.put("超兽武装之仁者无敌- 13  泰雷诀", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 13.mp4");
		x_map.put("超兽武装之仁者无敌- 14  鲸鲨超兽", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 14.mp4");
		x_map.put("超兽武装之仁者无敌- 15  凤凰重生", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 15.mp4");
		x_map.put("超兽武装之仁者无敌- 16  超兽神三合体", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 16.mp4");
		x_map.put("超兽武装之仁者无敌- 17  穿山甲超兽", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 17.mp4");
		x_map.put("超兽武装之仁者无敌- 18  金象超兽", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 18.mp4");
		x_map.put("超兽武装之仁者无敌- 19  云蝠战队", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 19.mp4");
		x_map.put("超兽武装之仁者无敌- 20  超兽神四合体", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 20.mp4");
		x_map.put("超兽武装之仁者无敌- 21  第四平行宇宙", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 21.mp4");
		x_map.put("超兽武装之仁者无敌- 22  公平决斗", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 22.mp4");
		x_map.put("超兽武装之仁者无敌- 23  致命威胁", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 23.mp4");
		x_map.put("超兽武装之仁者无敌- 24  元空间", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 24.mp4");
		x_map.put("超兽武装之仁者无敌- 25  巨能云蝠阵", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 25.mp4");
		x_map.put("超兽武装之仁者无敌- 26  叛变", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 26.mp4");
		x_map.put("超兽武装之仁者无敌- 27  虫洞", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 27.mp4");
		x_map.put("超兽武装之仁者无敌- 28  强者之旅", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 28.mp4");
		x_map.put("超兽武装之仁者无敌- 29  冥之界", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 29.mp4");
		x_map.put("超兽武装之仁者无敌- 30  正邪对立", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 30.mp4");
		x_map.put("超兽武装之仁者无敌- 31  飘萍身世", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 31.mp4");
		x_map.put("超兽武装之仁者无敌- 32  决战", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 32.mp4");
		x_map.put("超兽武装之仁者无敌- 33  冥王归来", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 33.mp4");
		x_map.put("超兽武装之勇者无惧- 1  玄冥黑洞", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 34.mp4");
		x_map.put("超兽武装之勇者无惧- 2  奇点", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 35.mp4");
		x_map.put("超兽武装之勇者无惧- 3  风耀的仇恨", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 36.mp4");
		x_map.put("超兽武装之勇者无惧- 4  叛逆之路", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 37.mp4");
		x_map.put("超兽武装之勇者无惧- 5  风影之死", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 38.mp4");
		x_map.put("超兽武装之勇者无惧- 6  冲出黑洞", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 39.mp4");
		x_map.put("超兽武装之勇者无惧- 7  宿敌", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 40.mp4");
		x_map.put("超兽武装之勇者无惧- 8  狼族", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 41.mp4");
		x_map.put("超兽武装之勇者无惧- 9  再见玄武号", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 42.mp4");
		x_map.put("超兽武装之勇者无惧- 10  冥王之瞳", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 43.mp4");
		x_map.put("超兽武装之勇者无惧- 11  嗜血的世界", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 44.mp4");
		x_map.put("超兽武装之勇者无惧- 12  龙戬之殇", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 45.mp4");
		x_map.put("超兽武装之勇者无惧- 13  与敌共武", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 46.mp4");
		x_map.put("超兽武装之勇者无惧- 14  元正长老", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 47.mp4");
		x_map.put("超兽武装之勇者无惧- 15  放弃", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 48.mp4");
		x_map.put("超兽武装之勇者无惧- 16  少年夜凌云", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 49.mp4");
		x_map.put("超兽武装之勇者无惧- 17  挑战", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 50.mp4");
		x_map.put("超兽武装之勇者无惧- 18  双雄对决", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 51.mp4");
		x_map.put("超兽武装之勇者无惧- 19  强者的觉悟", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 52.mp4");
		x_map.put("超兽武装之勇者无惧- 20  智者归来", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 53.mp4");
		x_map.put("超兽武装之勇者无惧- 21  分手", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 54.mp4");
		x_map.put("超兽武装之勇者无惧- 22  第七宇宙", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 55.mp4");
		x_map.put("超兽武装之勇者无惧- 23  凤凰族", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 56.mp4");
		x_map.put("超兽武装之勇者无惧- 24  和谈", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 57.mp4");
		x_map.put("超兽武装之勇者无惧- 25  劫后重生", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 58.mp4");
		x_map.put("超兽武装之勇者无惧- 26  大战前夕", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 59.mp4");
		x_map.put("超兽武装之勇者无惧- 27  惊天阴谋", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 60.mp4");
		x_map.put("超兽武装之勇者无惧- 28  Baboo之死", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 61.mp4");
		x_map.put("超兽武装之勇者无惧- 29  拯救风影", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 62.mp4");
		x_map.put("超兽武装之勇者无惧- 30  绝地封印", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 63.mp4");
		x_map.put("超兽武装之勇者无惧- 31  信念之火", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 64.mp4");
		x_map.put("超兽武装之勇者无惧- 32  终极合体", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 65.mp4");
		x_map.put("超兽武装之勇者无惧- 33  使命轮回", "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 66.mp4");
		
		x_html_href.append("<div scrollshow=\"true\"><div><ul>");
		x_html_href.append("<li><a>1</a><a href=\"?x5=超兽武装之仁者无敌- 1  平行宇宙\" title=\"超兽武装之仁者无敌- 1  平行宇宙\">\"超兽武装之仁者无敌- 1  平行宇宙\"</a></li>");
		x_html_href.append("<li><a>2</a><a href=\"?x5=超兽武装之仁者无敌- 2  玄易大师\" title=\"超兽武装之仁者无敌- 2  玄易大师\">\"超兽武装之仁者无敌- 2  玄易大师\"</a></li>");
		x_html_href.append("<li><a>3</a><a href=\"?x5=超兽武装之仁者无敌- 3  狮王超兽\" title=\"超兽武装之仁者无敌- 3  狮王超兽\">\"超兽武装之仁者无敌- 3  狮王超兽\"</a></li>");
		x_html_href.append("<li><a>4</a><a href=\"?x5=超兽武装之仁者无敌- 4  使命召唤\" title=\"超兽武装之仁者无敌- 4  使命召唤\">\"超兽武装之仁者无敌- 4  使命召唤\"</a></li>");
		x_html_href.append("<li><a>5</a><a href=\"?x5=超兽武装之仁者无敌- 5  冥王复活\" title=\"超兽武装之仁者无敌- 5  冥王复活\">\"超兽武装之仁者无敌- 5  冥王复活\"</a></li>");
		x_html_href.append("<li><a>6</a><a href=\"?x5=超兽武装之仁者无敌- 6  使命轮回\" title=\"超兽武装之仁者无敌- 6  使命轮回\">\"超兽武装之仁者无敌- 6  使命轮回\"</a></li>");
		x_html_href.append("<li><a>7</a><a href=\"?x5=超兽武装之仁者无敌- 7  第二平行宇宙\" title=\"超兽武装之仁者无敌- 7  第二平行宇宙\">\"超兽武装之仁者无敌- 7  第二平行宇宙\"</a></li>");
		x_html_href.append("<li><a>8</a><a href=\"?x5=超兽武装之仁者无敌- 8  蝎王超兽\" title=\"超兽武装之仁者无敌- 8  蝎王超兽\">\"超兽武装之仁者无敌- 8  蝎王超兽\"</a></li>");
		x_html_href.append("<li><a>9</a><a href=\"?x5=超兽武装之仁者无敌- 9  热血交融\" title=\"超兽武装之仁者无敌- 9  热血交融\">\"超兽武装之仁者无敌- 9  热血交融\"</a></li>");
		x_html_href.append("<li><a>10</a><a href=\"?x5=超兽武装之仁者无敌- 10  往事如烟\" title=\"超兽武装之仁者无敌- 10  往事如烟\">\"超兽武装之仁者无敌- 10  往事如烟\"</a></li>");
		x_html_href.append("<li><a>11</a><a href=\"?x5=超兽武装之仁者无敌- 11  超兽神二合体\" title=\"超兽武装之仁者无敌- 11  超兽神二合体\">\"超兽武装之仁者无敌- 11  超兽神二合体\"</a></li>");
		x_html_href.append("<li><a>12</a><a href=\"?x5=超兽武装之仁者无敌- 12  第三平行宇宙\" title=\"超兽武装之仁者无敌- 12  第三平行宇宙\">\"超兽武装之仁者无敌- 12  第三平行宇宙\"</a></li>");
		x_html_href.append("<li><a>13</a><a href=\"?x5=超兽武装之仁者无敌- 13  泰雷诀\" title=\"超兽武装之仁者无敌- 13  泰雷诀\">\"超兽武装之仁者无敌- 13  泰雷诀\"</a></li>");
		x_html_href.append("<li><a>14</a><a href=\"?x5=超兽武装之仁者无敌- 14  鲸鲨超兽\" title=\"超兽武装之仁者无敌- 14  鲸鲨超兽\">\"超兽武装之仁者无敌- 14  鲸鲨超兽\"</a></li>");
		x_html_href.append("<li><a>15</a><a href=\"?x5=超兽武装之仁者无敌- 15  凤凰重生\" title=\"超兽武装之仁者无敌- 15  凤凰重生\">\"超兽武装之仁者无敌- 15  凤凰重生\"</a></li>");
		x_html_href.append("<li><a>16</a><a href=\"?x5=超兽武装之仁者无敌- 16  超兽神三合体\" title=\"超兽武装之仁者无敌- 16  超兽神三合体\">\"超兽武装之仁者无敌- 16  超兽神三合体\"</a></li>");
		x_html_href.append("<li><a>17</a><a href=\"?x5=超兽武装之仁者无敌- 17  穿山甲超兽\" title=\"超兽武装之仁者无敌- 17  穿山甲超兽\">\"超兽武装之仁者无敌- 17  穿山甲超兽\"</a></li>");
		x_html_href.append("<li><a>18</a><a href=\"?x5=超兽武装之仁者无敌- 18  金象超兽\" title=\"超兽武装之仁者无敌- 18  金象超兽\">\"超兽武装之仁者无敌- 18  金象超兽\"</a></li>");
		x_html_href.append("<li><a>19</a><a href=\"?x5=超兽武装之仁者无敌- 19  云蝠战队\" title=\"超兽武装之仁者无敌- 19  云蝠战队\">\"超兽武装之仁者无敌- 19  云蝠战队\"</a></li>");
		x_html_href.append("<li><a>20</a><a href=\"?x5=超兽武装之仁者无敌- 20  超兽神四合体\" title=\"超兽武装之仁者无敌- 20  超兽神四合体\">\"超兽武装之仁者无敌- 20  超兽神四合体\"</a></li>");
		x_html_href.append("<li><a>21</a><a href=\"?x5=超兽武装之仁者无敌- 21  第四平行宇宙\" title=\"超兽武装之仁者无敌- 21  第四平行宇宙\">\"超兽武装之仁者无敌- 21  第四平行宇宙\"</a></li>");
		x_html_href.append("<li><a>22</a><a href=\"?x5=超兽武装之仁者无敌- 22  公平决斗\" title=\"超兽武装之仁者无敌- 22  公平决斗\">\"超兽武装之仁者无敌- 22  公平决斗\"</a></li>");
		x_html_href.append("<li><a>23</a><a href=\"?x5=超兽武装之仁者无敌- 23  致命威胁\" title=\"超兽武装之仁者无敌- 23  致命威胁\">\"超兽武装之仁者无敌- 23  致命威胁\"</a></li>");
		x_html_href.append("<li><a>24</a><a href=\"?x5=超兽武装之仁者无敌- 24  元空间\" title=\"超兽武装之仁者无敌- 24  元空间\">\"超兽武装之仁者无敌- 24  元空间\"</a></li>");
		x_html_href.append("<li><a>25</a><a href=\"?x5=超兽武装之仁者无敌- 25  巨能云蝠阵\" title=\"超兽武装之仁者无敌- 25  巨能云蝠阵\">\"超兽武装之仁者无敌- 25  巨能云蝠阵\"</a></li>");
		x_html_href.append("<li><a>26</a><a href=\"?x5=超兽武装之仁者无敌- 26  叛变\" title=\"超兽武装之仁者无敌- 26  叛变\">\"超兽武装之仁者无敌- 26  叛变\"</a></li>");
		x_html_href.append("<li><a>27</a><a href=\"?x5=超兽武装之仁者无敌- 27  虫洞\" title=\"超兽武装之仁者无敌- 27  虫洞\">\"超兽武装之仁者无敌- 27  虫洞\"</a></li>");
		x_html_href.append("<li><a>28</a><a href=\"?x5=超兽武装之仁者无敌- 28  强者之旅\" title=\"超兽武装之仁者无敌- 28  强者之旅\">\"超兽武装之仁者无敌- 28  强者之旅\"</a></li>");
		x_html_href.append("<li><a>29</a><a href=\"?x5=超兽武装之仁者无敌- 29  冥之界\" title=\"超兽武装之仁者无敌- 29  冥之界\">\"超兽武装之仁者无敌- 29  冥之界\"</a></li>");
		x_html_href.append("<li><a>30</a><a href=\"?x5=超兽武装之仁者无敌- 30  正邪对立\" title=\"超兽武装之仁者无敌- 30  正邪对立\">\"超兽武装之仁者无敌- 30  正邪对立\"</a></li>");
		x_html_href.append("<li><a>31</a><a href=\"?x5=超兽武装之仁者无敌- 31  飘萍身世\" title=\"超兽武装之仁者无敌- 31  飘萍身世\">\"超兽武装之仁者无敌- 31  飘萍身世\"</a></li>");
		x_html_href.append("<li><a>32</a><a href=\"?x5=超兽武装之仁者无敌- 32  决战\" title=\"超兽武装之仁者无敌- 32  决战\">\"超兽武装之仁者无敌- 32  决战\"</a></li>");
		x_html_href.append("<li><a>33</a><a href=\"?x5=超兽武装之仁者无敌- 33  冥王归来\" title=\"超兽武装之仁者无敌- 33  冥王归来\">\"超兽武装之仁者无敌- 33  冥王归来\"</a></li>");
		x_html_href.append("<li><a>1</a><a href=\"?x5=超兽武装之勇者无惧- 1  玄冥黑洞\" title=\"超兽武装之勇者无惧- 1  玄冥黑洞\">\"超兽武装之勇者无惧- 1  玄冥黑洞\"</a></li>");
		x_html_href.append("<li><a>2</a><a href=\"?x5=超兽武装之勇者无惧- 2  奇点\" title=\"超兽武装之勇者无惧- 2  奇点\">\"超兽武装之勇者无惧- 2  奇点\"</a></li>");
		x_html_href.append("<li><a>3</a><a href=\"?x5=超兽武装之勇者无惧- 3  风耀的仇恨\" title=\"超兽武装之勇者无惧- 3  风耀的仇恨\">\"超兽武装之勇者无惧- 3  风耀的仇恨\"</a></li>");
		x_html_href.append("<li><a>4</a><a href=\"?x5=超兽武装之勇者无惧- 4  叛逆之路\" title=\"超兽武装之勇者无惧- 4  叛逆之路\">\"超兽武装之勇者无惧- 4  叛逆之路\"</a></li>");
		x_html_href.append("<li><a>5</a><a href=\"?x5=超兽武装之勇者无惧- 5  风影之死\" title=\"超兽武装之勇者无惧- 5  风影之死\">\"超兽武装之勇者无惧- 5  风影之死\"</a></li>");
		x_html_href.append("<li><a>6</a><a href=\"?x5=超兽武装之勇者无惧- 6  冲出黑洞\" title=\"超兽武装之勇者无惧- 6  冲出黑洞\">\"超兽武装之勇者无惧- 6  冲出黑洞\"</a></li>");
		x_html_href.append("<li><a>7</a><a href=\"?x5=超兽武装之勇者无惧- 7  宿敌\" title=\"超兽武装之勇者无惧- 7  宿敌\">\"超兽武装之勇者无惧- 7  宿敌\"</a></li>");
		x_html_href.append("<li><a>8</a><a href=\"?x5=超兽武装之勇者无惧- 8  狼族\" title=\"超兽武装之勇者无惧- 8  狼族\">\"超兽武装之勇者无惧- 8  狼族\"</a></li>");
		x_html_href.append("<li><a>9</a><a href=\"?x5=超兽武装之勇者无惧- 9  再见玄武号\" title=\"超兽武装之勇者无惧- 9  再见玄武号\">\"超兽武装之勇者无惧- 9  再见玄武号\"</a></li>");
		x_html_href.append("<li><a>10</a><a href=\"?x5=超兽武装之勇者无惧- 10  冥王之瞳\" title=\"超兽武装之勇者无惧- 10  冥王之瞳\">\"超兽武装之勇者无惧- 10  冥王之瞳\"</a></li>");
		x_html_href.append("<li><a>11</a><a href=\"?x5=超兽武装之勇者无惧- 11  嗜血的世界\" title=\"超兽武装之勇者无惧- 11  嗜血的世界\">\"超兽武装之勇者无惧- 11  嗜血的世界\"</a></li>");
		x_html_href.append("<li><a>12</a><a href=\"?x5=超兽武装之勇者无惧- 12  龙戬之殇\" title=\"超兽武装之勇者无惧- 12  龙戬之殇\">\"超兽武装之勇者无惧- 12  龙戬之殇\"</a></li>");
		x_html_href.append("<li><a>13</a><a href=\"?x5=超兽武装之勇者无惧- 13  与敌共武\" title=\"超兽武装之勇者无惧- 13  与敌共武\">\"超兽武装之勇者无惧- 13  与敌共武\"</a></li>");
		x_html_href.append("<li><a>14</a><a href=\"?x5=超兽武装之勇者无惧- 14  元正长老\" title=\"超兽武装之勇者无惧- 14  元正长老\">\"超兽武装之勇者无惧- 14  元正长老\"</a></li>");
		x_html_href.append("<li><a>15</a><a href=\"?x5=超兽武装之勇者无惧- 15  放弃\" title=\"超兽武装之勇者无惧- 15  放弃\">\"超兽武装之勇者无惧- 15  放弃\"</a></li>");
		x_html_href.append("<li><a>16</a><a href=\"?x5=超兽武装之勇者无惧- 16  少年夜凌云\" title=\"超兽武装之勇者无惧- 16  少年夜凌云\">\"超兽武装之勇者无惧- 16  少年夜凌云\"</a></li>");
		x_html_href.append("<li><a>17</a><a href=\"?x5=超兽武装之勇者无惧- 17  挑战\" title=\"超兽武装之勇者无惧- 17  挑战\">\"超兽武装之勇者无惧- 17  挑战\"</a></li>");
		x_html_href.append("<li><a>18</a><a href=\"?x5=超兽武装之勇者无惧- 18  双雄对决\" title=\"超兽武装之勇者无惧- 18  双雄对决\">\"超兽武装之勇者无惧- 18  双雄对决\"</a></li>");
		x_html_href.append("<li><a>19</a><a href=\"?x5=超兽武装之勇者无惧- 19  强者的觉悟\" title=\"超兽武装之勇者无惧- 19  强者的觉悟\">\"超兽武装之勇者无惧- 19  强者的觉悟\"</a></li>");
		x_html_href.append("<li><a>20</a><a href=\"?x5=超兽武装之勇者无惧- 20  智者归来\" title=\"超兽武装之勇者无惧- 20  智者归来\">\"超兽武装之勇者无惧- 20  智者归来\"</a></li>");
		x_html_href.append("<li><a>21</a><a href=\"?x5=超兽武装之勇者无惧- 21  分手\" title=\"超兽武装之勇者无惧- 21  分手\">\"超兽武装之勇者无惧- 21  分手\"</a></li>");
		x_html_href.append("<li><a>22</a><a href=\"?x5=超兽武装之勇者无惧- 22  第七宇宙\" title=\"超兽武装之勇者无惧- 22  第七宇宙\">\"超兽武装之勇者无惧- 22  第七宇宙\"</a></li>");
		x_html_href.append("<li><a>23</a><a href=\"?x5=超兽武装之勇者无惧- 23  凤凰族\" title=\"超兽武装之勇者无惧- 23  凤凰族\">\"超兽武装之勇者无惧- 23  凤凰族\"</a></li>");
		x_html_href.append("<li><a>24</a><a href=\"?x5=超兽武装之勇者无惧- 24  和谈\" title=\"超兽武装之勇者无惧- 24  和谈\">\"超兽武装之勇者无惧- 24  和谈\"</a></li>");
		x_html_href.append("<li><a>25</a><a href=\"?x5=超兽武装之勇者无惧- 25  劫后重生\" title=\"超兽武装之勇者无惧- 25  劫后重生\">\"超兽武装之勇者无惧- 25  劫后重生\"</a></li>");
		x_html_href.append("<li><a>26</a><a href=\"?x5=超兽武装之勇者无惧- 26  大战前夕\" title=\"超兽武装之勇者无惧- 26  大战前夕\">\"超兽武装之勇者无惧- 26  大战前夕\"</a></li>");
		x_html_href.append("<li><a>27</a><a href=\"?x5=超兽武装之勇者无惧- 27  惊天阴谋\" title=\"超兽武装之勇者无惧- 27  惊天阴谋\">\"超兽武装之勇者无惧- 27  惊天阴谋\"</a></li>");
		x_html_href.append("<li><a>28</a><a href=\"?x5=超兽武装之勇者无惧- 28  Baboo之死\" title=\"超兽武装之勇者无惧- 28  Baboo之死\">\"超兽武装之勇者无惧- 28  Baboo之死\"</a></li>");
		x_html_href.append("<li><a>29</a><a href=\"?x5=超兽武装之勇者无惧- 29  拯救风影\" title=\"超兽武装之勇者无惧- 29  拯救风影\">\"超兽武装之勇者无惧- 29  拯救风影\"</a></li>");
		x_html_href.append("<li><a>30</a><a href=\"?x5=超兽武装之勇者无惧- 30  绝地封印\" title=\"超兽武装之勇者无惧- 30  绝地封印\">\"超兽武装之勇者无惧- 30  绝地封印\"</a></li>");
		x_html_href.append("<li><a>31</a><a href=\"?x5=超兽武装之勇者无惧- 31  信念之火\" title=\"超兽武装之勇者无惧- 31  信念之火\">\"超兽武装之勇者无惧- 31  信念之火\"</a></li>");
		x_html_href.append("<li><a>32</a><a href=\"?x5=超兽武装之勇者无惧- 32  终极合体\" title=\"超兽武装之勇者无惧- 32  终极合体\">\"超兽武装之勇者无惧- 32  终极合体\"</a></li>");
		x_html_href.append("<li><a>33</a><a href=\"?x5=超兽武装之勇者无惧- 33  使命轮回\" title=\"超兽武装之勇者无惧- 33  使命轮回\">\"超兽武装之勇者无惧- 33  使命轮回\"</a></li>");
		
		x_key=x_map.keySet();
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		/*
		 * // 数据格式生产 // String xString="《超兽武装之仁者无敌》" + "《超兽武装之勇者无惧》";
		 * 
		 * String[] x_集数 = new String[] { "1 平行宇宙", "2 玄易大师", "3 狮王超兽", "4 使命召唤",
		 * "5 冥王复活", "6 使命轮回", "7 第二平行宇宙", "8 蝎王超兽", "9 热血交融", "10 往事如烟", "11 超兽神二合体",
		 * "12 第三平行宇宙", "13 泰雷诀", "14 鲸鲨超兽", "15 凤凰重生", "16 超兽神三合体", "17 穿山甲超兽",
		 * "18 金象超兽", "19 云蝠战队", "20 超兽神四合体", "21 第四平行宇宙", "22 公平决斗", "23 致命威胁",
		 * "24 元空间", "25 巨能云蝠阵", "26 叛变", "27 虫洞", "28 强者之旅", "29 冥之界", "30 正邪对立",
		 * "31 飘萍身世", "32 决战", "33 冥王归来", "34 玄冥黑洞", "35 奇点", "36 风耀的仇恨", "37 叛逆之路",
		 * "38 风影之死", "39 冲出黑洞", "40 宿敌", "41 狼族", "42 再见玄武号", "43 冥王之瞳", "44 嗜血的世界",
		 * "45 龙戬之殇", "46 与敌共武", "47 元正长老", "48 放弃", "49 少年夜凌云", "50 挑战", "51 双雄对决",
		 * "52 强者的觉悟", "53 智者归来", "54 分手", "55 第七宇宙", "56 凤凰族", "57 和谈", "58 劫后重生",
		 * "59 大战前夕", "60 惊天阴谋", "61 Baboo之死", "62 拯救风影", "63 绝地封印", "64 信念之火",
		 * "65 终极合体", "66 使命轮回" };
		 * 
		 * String[] x_路径 = new String[] { "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 01.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 02.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 03.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 04.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 05.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 06.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 07.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 08.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 09.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 10.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 11.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 12.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 13.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 14.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 15.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 16.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 17.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 18.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 19.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 20.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 21.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 22.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 23.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 24.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 25.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 26.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 27.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 28.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 29.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 30.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 31.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 32.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 33.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 34.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 35.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 36.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 37.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 38.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 39.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 40.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 41.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 42.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 43.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 44.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 45.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 46.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 47.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 48.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 49.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 50.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 51.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 52.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 53.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 54.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 55.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 56.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 57.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 58.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 59.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 60.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 61.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 62.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 63.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 64.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 65.mp4",
		 * "D:\\视频\\超兽武装\\超兽武装 - RevEvolution 66.mp4" };
		 * 
		 * int x_V = 1;
		 * 
		 * for (int i = 0; i < x_集数.length; i++) { String x_集数s = x_集数[i]; x_集数s =
		 * x_集数s.substring(x_集数s.indexOf(" "));
		 * 
		 * // String x_路径s = null; // x_路径s = x_路径[i];
		 * 
		 * String x_部序 = null;
		 * 
		 * if (i < 33) { x_部序 = "超兽武装之仁者无敌"; } else { x_部序 = "超兽武装之勇者无惧"; if (i == 33) {
		 * x_V = 1; } }
		 * 
		 * // StringBuilder v=new
		 * StringBuilder().append(x_部序+"-"+x_集数s+"=\""+x_路径s+"\"");
		 * 
		 * String x_key = "\"" + x_部序 + "- " + x_V + " " + x_集数s + "\""; String x_keyL =
		 * "\"?x5=" + x_部序 + "- " + x_V + " " + x_集数s + "\""; // String x_values = "\""
		 * + x_路径s.replace("\\", "\\\\") + "\"";
		 * 
		 * // StringBuilder v_map=new //
		 * StringBuilder().append("x_map.put("+x_key+","+x_values+");"); StringBuilder
		 * v_html = new StringBuilder().append("x_html_href.append(\"<li><a>" + x_V +
		 * "</a>" + "<a href=" + x_keyL.replace("\"", "\\\"") + " title=" +
		 * x_key.replace("\"", "\\\"") + ">" + x_key.replace("\"", "\\\"") + "</a>" +
		 * "</li>" + "\");");
		 * 
		 * System.out.println(v_html);
		 * 
		 * x_V++; }
		 * 
		 */}
	
}
