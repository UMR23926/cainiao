package com.example.ruangong_login;


public class Card {
	int value;//���ƴ�С
	int cardValue;//�������:0-107
	boolean isChoose;
	//A 1 14 27 40 54 67 80 93
	//2 2 15 28 41 55 68 81 94
	//С�� 52 105
	//���� 53 106
	public Card(int cardValue) {
		this.cardValue = cardValue;
		this.isChoose = false;
		//AֵΪ 13
		//С2ֵΪ 49 
		//��С��ֵΪ52,53;
		if (cardValue == 0 || cardValue == 13 || cardValue == 26 || cardValue == 39) {
			this.value = 13;
		} else if (cardValue == 1 || cardValue == 14 || cardValue == 27 || cardValue == 40) {
			this.value = 49;
		} else if (cardValue == 52 || cardValue == 53) {
			this.value = cardValue;
		} else {
			this.value = cardValue % 13;
		}
	}
	
	public int getValue() {
		return value;
	}
 
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getCardValue() {
		return cardValue;
	}
	
	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}
 
	public boolean isChoose() {
		return isChoose;
	}
 
	public void setChoose(boolean isChoose) {
		this.isChoose = isChoose;
	}
	
}