package com.example.project;

public interface PokeType{
	int danpai=1;
	int duipai=2;
	int sanzhang=3;
	int sandaiyi=4;
	int danshun=5;
	int shuangshun=6;
	int sanshun=7;
	int feiji=8;
	int sidaier=9;
	int zhadan=10;
	int huojian=11;
	int error=12;
	
	int dirH=0;
	int dirV=1;
}
/*
 * 规则
 * 1、所有数字只出现一次

2、相同数字的牌出现两次

3、相同数字的牌出现三次

4、相同数字的牌出现四次

5、不可能出现的情况：相同数字的牌出现大于四次或小于1次。

其中，在以上的1、2、3、4中又可能分为多种情况，比如
在1中，虽然相同数字最多只出现一次，但不能因此就断定它是单张，
它也有可能是双王（这里假定大小王的数字不相同）或单顺；
在2中，出现两次的情况下，又进一步分为：
对子和双顺两种情况；
在3中，出现三次的情况下，可能有以下牌型：
单三张，三带一，三顺或飞机；
在4中，出现4个相同数字牌的时候，可能有以下牌型：炸弹和四带二。*/
