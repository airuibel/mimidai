package com.mimidai.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtils {
	/**
	 * 去除用户通讯录手机号中的‘-’、‘ ’和‘+86’
	 * @param phoneNum
	 * @return
	 */
	public static String getRightPhone(String phoneNum) {
		if (StringUtils.isBlank(phoneNum)) {
			return "";
		}
		if (phoneNum.length() < 4) {
			return phoneNum;
		}
		phoneNum = phoneNum.trim();
		if(phoneNum.substring(0, 3).equals("+86")){
			phoneNum = phoneNum.substring(3);
		}
		phoneNum = phoneNum.replaceAll("-", "");
		phoneNum = phoneNum.replaceAll("\\s", "");
		return phoneNum;
	}
	
	/**
	 * 是否正常的通讯录名称
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isWrongName(String name) {
		Pattern pattern = Pattern.compile("(\\\\x[a-fA-F0-9]{2})+");
		Matcher matcher = pattern.matcher(name);
		boolean b = matcher.matches();
		return b;
	}
	
	public static String replaceWrongWord(String name) {
		
		String regex = "(\\\\x[a-fA-F0-9]{2})+";
		String regex1 = "([^\u4e00-\u9fa5\\da-zA-Z])+";
		String regex2 = "([\u4e00-\u9fa5\\da-zA-Z])+";
		
		name = name.replaceAll(regex, "");
		name = name.replaceAll(regex1, "");
		
		Matcher matcher = Pattern.compile(regex2, Pattern.UNIX_LINES).matcher(name);
		String str = "";
		if(matcher.find()){
			if(matcher.groupCount() > 0) {
				for (int i = 0; i < matcher.groupCount(); i++) {
					str += matcher.group(i);	
				}
			}
		}
		return str;
	}
	
	/**
	 * 手机号验证
	 * 
	 * @param  str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) { 
		Pattern p = null;
		Matcher m = null;
		boolean b = false; 
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches(); 
		return b;
	}
	/**
	 * 电话号码验证
	 * 
	 * @param  str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) { 
		Pattern p1 = null,p2 = null;
		Matcher m = null;
		boolean b = false;  
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
		if(str.length() >9)
		{	m = p1.matcher(str);
 		    b = m.matches();  
		}else{
			m = p2.matcher(str);
 			b = m.matches(); 
		}  
		return b;
	}
	
	public static boolean isPhoneOrMobile(String str){
		if(isMobile(str) || isPhone(str)){
			return true;
		}else{
			return false;
		}
	}
	
//	public static void main(String[] args) {
//		System.out.println(replaceWrongWord("\\xAAA王小二18632156680\\x561"));
//	}
}
