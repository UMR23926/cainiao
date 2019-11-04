package com.example.project;

import java.util.ArrayList;

 public class Card{
	    public static void main(String[] args){
	    //1.准备牌
	    //定义一个存储54张牌的ArrayList集合，泛型使用String
	    ArrayList<String>poker =new ArrayList<String>();
	    //定义两个数组，一个数组存储牌的花色，一个数组存储牌的序号
	    String[] colors = {"♥","♦","♣","♠"};
	    String[] numbers = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};
	    //先把大王和小王存储到poker集合中
	 
	    //循环嵌套遍历两个数组，组装52张牌
	    for(String number : numbers){
	        for (String color : colors){
	            //System.out.println(color + numbers);
	            //把组装好的牌存储到poker集合中
	            poker.add(color + number);
	        }
	        poker.add("大王"+"53");
		    poker.add("小王"+"54");
	    }
 
 
//定义4个集合，存储4个玩家的牌和底牌
 ArrayList<String> player1 = new ArrayList<String>();
 ArrayList<String> player2 = new ArrayList<String>();
 ArrayList<String> player3 = new ArrayList<String>();
 ArrayList<String> player4 = new ArrayList<String>();
 ArrayList<String> dipai = new ArrayList<String>();

 //遍历poker集合，获取每一张牌,给 4个玩家轮流发牌(两副牌）
 int t=2;
 while((t-1)>=0){
 for(int i = 0;i<poker.size();i++){
     //获取每一张牌
     String p =poker.get(i);
     //轮流发牌
     if(i>=51){
         //给底牌发牌
         dipai.add(p);
      }
     else if(i%4==0){
         player1.add(p);
     }
     else if (i%4==1){
         player2.add(p);
     }
     else if(i%4==2){
         player3.add(p);
     }
     else if(i%4==2){
         player3.add(p);
     }
 }}
}}