package com.angular.test;

import java.util.Random;

/**
 * 红包随机算法
 * @author 12484
 *
 */
public class RandomRedPacket {
	 private int leftMoney;
	    private int leftNum;
	    private Random rnd;
	    public RandomRedPacket(int total, int num){
	        this.leftMoney = total;
	        this.leftNum = num;
	        this.rnd = new Random();
	    }
	    public synchronized double nextMoney(){
	        if(this.leftNum<=0){
	            throw new IllegalStateException();
	
	        }
	        if(this.leftNum==1){
	            return this.leftMoney;
	        }
	        double max = this.leftMoney/this.leftNum*2d;
	        double money = (rnd.nextDouble()*max);
	        money = Math.max(1, money);
	        this.leftMoney -= money;
	        this.leftNum --;
	        return money;
	    }
	    
	    public static void main(String[] args) {
	    	 int num=5;
	    	 RandomRedPacket tick=new RandomRedPacket(10,num);
	    	 for (int i = 0; i < num; i++) {
	    		 System.out.println("第"+i+"个人得："+tick.nextMoney());
			}
	    	
		}
}
