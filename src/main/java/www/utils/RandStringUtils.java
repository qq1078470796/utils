package www.utils;

import java.util.Random;
/**
 * 随机一个指定数量的纯数字串工具类
 * @author haoxinyu
 *
 */
public class RandStringUtils {
	public static String getCode(int num){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			sb = sb.append( getRandomString());
		}
		return sb.toString();
	}
	
	public static int getRandomString(){
		Random r = new Random();
		int num = r.nextInt(9);
		return num;
	}
	
	public static String getPhones(String[] arr){
		String str = "";
		if (arr!=null&&arr.length >0) {
			for (int i = 0; i < arr.length; i++) {
				str = str + arr[i] + ",";
			}
		}
		return str.substring(0,str.length()-1);
	}

	public static void main(String[] args) {
        int randomString = getRandomString();
        String code = getCode(10);
        System.out.println(randomString);
        System.out.println(code);
    }

}
