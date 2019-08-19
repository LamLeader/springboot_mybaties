package com.angular.test;

import java.util.LinkedList;

/**
 * 泛型
 * @author 12484
 *
 */
public class Pair {
   Object first;
   Object second;
	public Pair(Object first, Object second) {
		super();
		this.first = first;
		this.second = second;
	}
	public Object getFirst() {
		return first;
	}
	public void setFirst(Object first) {
		this.first = first;
	}
	public Object getSecond() {
		return second;
	}
	public void setSecond(Object second) {
		this.second = second;
	}
   
	/**
	 * 栈
	 * @param args
	 */
	 public void showStack(){
		
		 
	 }
	public static void main(String[] args) {
		Pair minMax=new Pair(1,100);
		
		Integer a=(Integer) minMax.getFirst();
		Integer b=(Integer) minMax.getSecond();
		
		Pair kv =new Pair("我在","你在");
		
		String c=(String) kv.getFirst();
		String d=(String) kv.getSecond();
		
		System.out.println("a:"+a+",b:"+b+",c:"+c+",d:"+d);
		
		
	}
  
}
