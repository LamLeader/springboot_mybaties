package com.angular.test;

import java.util.Arrays;

public class Test {
	
	/**
	 * String 拼接
	 * @param str1
	 * @param str2
	 * @param str3
	 * @return
	 */
  	public static  String returnStr(String str1,String str2,String str3,String strS){
		strS="字符串拼接";
		strS+=str1+str2+str3;
	   return strS;
	}
  	/**
  	 * returnStrBuff 追加 允许对字符进行修改而不改变 变量地址  适用于多线程 
  	 * @param str1
  	 * @param str2
  	 * @param str3
  	 * @param strS
  	 * @return
  	 */
  	public static  StringBuffer returnStrBuff(String str1,String str2,String str3){
	  StringBuffer	strBuff=new StringBuffer();
	   strBuff.append(str1);
	   strBuff.append(str2);
	   strBuff.append(str3);
	   return strBuff;
	}
  	/**
  	 * StringBuilder 追加   允许对字符进行修改而不改变 变量地址  适用于单线程 
  	 * @param str1
  	 * @param str2
  	 * @param str3
  	 * @param strS
  	 * @return
  	 */
  	public static  StringBuilder returnStrBuilddle(String str1,String str2,String str3){
	  StringBuilder	strBuff=new StringBuilder();
	   strBuff.append(str1);
	   strBuff.append(str2);
	   strBuff.append(str3);
	   return strBuff;
	}
  	
  	
      public static void main(String[] args) {
		
    	 System.out.println("returnStr:"+Test.returnStr("123", "456", "789", "str"));
    	 System.out.println("returnStrBuff:"+Test.returnStrBuff("123", "456","str"));
    	 System.out.println("returnStrBuilddle:"+Test.returnStrBuilddle("123", "456","str"));
         
    	 int[] arr = {4, 9, 3, 6, -10,0};
    	 Arrays.sort(arr);
    	 System.out.println("排序："+Arrays.toString(arr));
    	
    	  
	}
       
}
