package com.example.ruangong_login;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Collections;
 
public class Rule {
 
	int a[] = new int[54];
	Random rand = new Random();
	List<Card> localCard = new ArrayList<Card>();
	List<Card> leftCard = new ArrayList<Card>();
	List<Card> rightCard = new ArrayList<Card>();
	List<Card> lastThreeCard = new ArrayList<Card>();
	/**
	 * @param 测试纸牌算法
	 * 纸牌已排序
	 */
	public static void main(String[] args) {
		Rule r = new Rule();
		r.test();
	}
	
	public void test() {
		createCardList();
		System.out.println("start sort lists");
		sortListByCardValue(localCard);
		sortListByCardValue(leftCard);
		sortListByCardValue(rightCard);
		sortListByCardValue(lastThreeCard);
		sortList(localCard);
		sortList(leftCard);
		sortList(rightCard);
		sortList(lastThreeCard);
		printCardList(localCard);
		printCardList(leftCard);
		printCardList(rightCard);
		printCardList(lastThreeCard);
	}
	//洗牌
	public void createCardList() {
		for (int i = 0; i< 54; i++) {
			a[i] = i;
		}	
		for (int i = 0; i< 54; i++) {
			int r = rand.nextInt(54);
			int temp;
			temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		for (int i = 0; i< 17; i++) {
			Card c = new Card(a[i]);
			localCard.add(c);
		}
		for (int i = 0; i< 17; i++) {
			Card c = new Card(a[i+17]);
			leftCard.add(c);
		}
		for (int i = 0; i< 17; i++) {
			Card c = new Card(a[i+34]);
			rightCard.add(c);
		}		
		for (int i = 0; i< 3; i++) {
			Card c = new Card(a[i+51]);
			lastThreeCard.add(c);
		}	
	}
	//排序
	public void sortList(List<Card> list) {
		Comparator<Card> c = new Comparator<Card>() {
			
			@Override
			public int compare(Card c1, Card c2) {
				if(c1.value > c2.value) return 1;
				else if(c1.value == c2.value) return 0;
				else return -1;
			}
		};
		Collections.sort(list, c);
	}
	public void sortListByCardValue(List<Card> list) {
		Comparator<Card> c = new Comparator<Card>() {
			
			@Override
			public int compare(Card c1, Card c2) {
				if(c1.cardValue > c2.cardValue) return 1;
				else if(c1.cardValue == c2.cardValue) return 0;
				else return -1;
			}
		};
		Collections.sort(list, c);
	}
 
	public void printCardList(List<Card> list) {
		System.out.printf("%2d: ",list.size());
		for (Card c : list) {
			int value = c.value;
			if(value == 10) {
				System.out.printf(" J ");
			} else if(value == 11) {
				System.out.printf(" Q ");
			} else if(value == 12) {
				System.out.printf(" K ");
			} else if(value == 13) {
				System.out.printf(" A ");
			} else if(value == 49) {
				System.out.printf(" 2 ");
			} else if(value == 52) {
				System.out.printf("小王");
			} else if(value == 53) {
				System.out.printf("大王");
			} else {
				System.out.printf("%2d ", c.value + 1);
			}
			
		}
		System.out.println(" ");
	}
	public void print(List<Card> list) {
		for (int i = 0; i< list.size(); i++) {
			Card c = list.get(i);
			System.out.print(c.value+" ");
		}
		System.out.println(" ");
		for (int i = 0; i< list.size(); i++) {
			Card c = list.get(i);
			System.out.print(c.cardValue+" ");
		}
		System.out.println(" ");
	}
	//判断是否相同，num为个数
	//已测
	public Boolean isSame(List<Card> cardList) {
		int q;
		int p;
		for(int i = 1; i < cardList.size() ; i++) {
			p = cardList.get(i-1).value;
			q = cardList.get(i).value;
			if(q != p) return false;
		}
		return true;
	}
	//判断是否连对，num为连对个数
	//已测
	public Boolean isLiandui(List<Card> cardList) {
		int q;
		int p;
		//0 1 2 3 4 5 6 7 8 9
		//1 3 5 7 9
		for(int i = 1; i < cardList.size(); i = i + 2) {
			p = cardList.get(i-1).value;
			q = cardList.get(i).value;	
			if(q != p) return false;
			if (i == (cardList.size() - 1)) {
				return true;
			}
			else if (q != (cardList.get(i+1).value - 1)) {
				return false;
			}
		}
		
		return true;
	}
	//是否为顺子
	public Boolean isShunZi(List<Card> cardList) {
		
		int p;
		int q;
		int num = cardList.size();
		
		if(num < 5) return false;
		for(int i = 1; i < num; i++) {
			p = cardList.get(i-1).value;
			q = cardList.get(i).value;
			if(p != q-1) return false;
		}
		
		return true;
	}
	//是否为王炸
	public Boolean isWangZha(List<Card> cardList) {	
		if(cardList.get(0).value == 52 && cardList.get(1).value == 53) return true;
		return false;
	}
	//是否为炸弹
	public Boolean isBoom(List<Card> cardList) {
		int q;
		int p;
		int num = cardList.size();
		
		for(int i = 1; i < num; i++) {
			p = cardList.get(i-1).value;
			q = cardList.get(i).value;	
			if (p!=q) {
				return false;
			}
		}
		return true;
	}
	//判断是否为3带   3 4 5
	public Boolean isSanDai(List<Card> cardList) {
		int p, q, k;
		int num = cardList.size();
		
		for(int i = 1; i < num-1; i++) {
			p = cardList.get(i-1).value;
			q = cardList.get(i).value;	
			k = cardList.get(i+1).value;
			if (p==q && q==k) {
				return true;
			}
		}
		return false;
	}
	/*
	 * 先找出所有的三张，
	 * 三张个数大于等于2，
	 * 如果剩下的牌张数为0，打出，
	 * 如果剩下牌数等于三张个数 ，打出，
	 * 如果剩下牌数等于三张个数两倍，打出，
	 * 其他不符合规则 
	 */
	public Boolean isFeiji(List<Card> cardList) {
		
		List<Card> threelist = new ArrayList<Card>();
		List<Card> otherlist = new ArrayList<Card>(cardList);
		Card c1, c2, c3;
		int num = cardList.size();
		
		for(int i = 0; i < num-2; i++) {
			c1 = cardList.get(i);
			c2 = cardList.get(i+1);	
			c3 = cardList.get(i+2);
			if (c1.value == c2.value &&  c2.value == c3.value) {
				threelist.add(c1);
				threelist.add(c2);
				threelist.add(c3);
				otherlist.remove(c1);
				otherlist.remove(c2);
				otherlist.remove(c3);
				i = i + 2;
			}
		}
		
		int numOfThree = threelist.size() / 3;
		int numOfOtherList = otherlist.size();
		
		if (numOfThree < 2) {
			return false;
		}
		if (numOfOtherList == 0 || numOfThree == numOfOtherList) {
			return true;
		}
		
		if ((numOfOtherList / 2) == numOfThree) {
			for(int i = 1; i < numOfOtherList; i += 2) {
				int p = otherlist.get(i-1).value;
				int q = otherlist.get(i).value;
				if(q != p) return false;
			}
			cardList.removeAll(cardList);
			for(Card c : threelist) {
				cardList.add(c);
			}
			for(Card c : otherlist) {
				cardList.add(c);
			}
			threelist.removeAll(threelist);
			otherlist.removeAll(otherlist);
			return true;
		} else {
			return false;
		}
	}
	//单个O，对子O，三带O，连对O，顺子O，飞机，炸弹O，王炸O
}