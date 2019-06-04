package www.utils;

import java.io.IOException;  
import java.io.UnsupportedEncodingException;  
import java.net.URLEncoder;  
import org.apache.http.HttpResponse;  
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.impl.client.HttpClients;  
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
  
/**
 * 图灵机器人api封装工作类
 * @author haoxinyu
 *
 */
public class TulingApiProcess {  
    /** 
     * 调用图灵机器人api接口，获取智能回复内容 
     * @param content 
     * @return 
     */  
	public static int TLCOUNT=0;
	public static String API_KEY="6e65efcbc27f4021ba301d0955a22ecc";
    public static String getTulingResult(String content,String userId){  
        /** 此处为图灵api接口 */  
        String apiUrl = "http://www.tuling123.com/openapi/api?key=KEYS&info=";  
        apiUrl=apiUrl.replace("KEYS", API_KEY);
        System.out.println(apiUrl);
        String param = "";  
        try {  
            param = apiUrl+URLEncoder.encode(content,"utf-8")+"&userid="+URLEncoder.encode(userId,"utf-8");  
        } catch (UnsupportedEncodingException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        } //将参数转为url编码  
          
        /** 发出httpget请求 */  
        HttpGet request = new HttpGet(param);  
        String result = "";  
        try {  
            HttpResponse response = HttpClients.createDefault().execute(request);  
            if(response.getStatusLine().getStatusCode()==200){  
                result = EntityUtils.toString(response.getEntity());  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        /** 请求失败处理 */  
        if(null==result){  
            return "你说的太高深了，但是你可以回复1可以获取图文信息；\n" + "回复2可以获取图片信息；\n" + "回复3可以听一首歌；\n" + "回复其他可以跟机器人交流；\n" + "回复‘引导’再次调出本界面";  
        }  
          
        try {  
            JSONObject json = JSONObject.fromObject(result);  
            //以code=100000为例，参考图灵机器人api文档  
            if(100000==json.getInt("code")){  
                result = json.getString("text");  
            }
            if(200000==json.getInt("code")){  
                result = json.getString("url");  
            }
        } catch (JSONException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        TLCOUNT++;
        return result;  
    } 
    public static void main(String[] args) {
    	System.out.println(TulingApiProcess.getTulingResult("你好", "1"));
    	
	}
    
}  