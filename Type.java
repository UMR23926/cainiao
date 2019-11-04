package com.example.project;

import java.util.Random;

public class Type{
	
	public static int getPokeValue(int poke) {
		// ���˿�ֵΪ52ʱ,��С��
		if (poke == 52) {
			return 16;
		}
		// ���˿�ֵΪ53ʱ���Ǵ���
		if (poke == 53) {
			return 17;
		}
		// ��������·�����Ӧ��ֵ(3,4,5,6,7,8,9,10,11(J),12(Q),13(K),14(A),15(2))
		return poke / 4 + 3;
	}
	
	
	public static int getPokeType(int[] pokes){
		int len = pokes.length;
		// ��������Ϊ1ʱ,����
		if (len == 1) {
			return PokeType.danpai;
		}
		// ��������Ϊ2ʱ,�����Ƕ��ƺͻ��
		if (len == 2) {
			if (pokes[0] == 53 && pokes[1] == 52) {
				return PokeType.huojian;
			}
			if (getPokeValue(pokes[0]) == getPokeValue(pokes[1])) {
				return PokeType.duipai;
			}
		}
		// ������Ϊ3ʱ,ֻ��������˳
		if (len == 3) {
			if (getPokeValue(pokes[0]) == getPokeValue(pokes[1])
					&& getPokeValue(pokes[2]) == getPokeValue(pokes[1])) {
				return PokeType.sanzhang;
			}
		}
		// ������Ϊ4ʱ,����������һ��ը��
		if (len == 4) {
			int firstCount = getPokeCount(pokes, pokes[0]);
			if (firstCount == 3 || getPokeCount(pokes, pokes[1]) == 3) {
				return PokeType.sandaiyi;
			}
			if (firstCount == 4) {
				return PokeType.zhadan;
			}
		}
		// ����������5ʱ,�ж��ǲ��ǵ�˳
		if (len >= 5) {
			if (shunzi(pokes)) {
				return PokeType.danshun;
			}

		}
		// ������Ϊ6ʱ,�Ĵ���
		if (len == 6) {
			boolean have4 = false;
			boolean have1 = false;
			for (int i = 0; i < len; i++) {
				int c = getPokeCount(pokes, pokes[i]);
				if (c == 4) {
					have4 = true;
				}
				if (c == 1) {
					have1 = true;
				}
			}

			if (have4 && have1) {
				return PokeType.sidaier;
			}
		}
		// ���������ڵ���6ʱ,�ȼ���ǲ���˫˳����˳
		if (len >= 6) {
			// ˫˳
			boolean shuangshunflag = true;
			for (int i = 0; i < len; i++) {
				if (getPokeCount(pokes, pokes[i]) != 2) {
					shuangshunflag = false;
					break;
				}
			}
			if (shuangshunflag) {
				int[] tempPokes = new int[len / 2];
				for (int i = 0; i < len / 2; i++) {
					tempPokes[i] = pokes[i * 2];
				}
				if (shunzi(tempPokes)) {
					return PokeType.shuangshun;
				}
			}
			System.out.println("shuangshun:" + shuangshunflag);
			// ��˳
			boolean sanshunflag = true;
			for (int i = 0; i < len; i++) {
				if (getPokeCount(pokes, pokes[i]) != 3) {
					sanshunflag = false;
					break;
				}
			}
			if (sanshunflag) {
				int[] tempPokes = new int[len / 3];
				for (int i = 0; i < len / 3; i++) {
					tempPokes[i] = pokes[i * 3];
				}
				if (shunzi(tempPokes)) {
					return PokeType.sanshun;
				}
			}

		}

		/*// ���������ڵ���8,���ܹ���4����ʱ,�ж��ǲ��Ƿɻ�
		if (len >= 8 && len % 4 == 0) {
			UniqInt ui = new UniqInt();
			int have1 = 0;
			for (int i = 0; i < pokes.length; i++) {
				int c = getPokeCount(pokes, pokes[i]);
				if (c == 3) {
					ui.addInt(pokes[i]);
				} else if (c == 1) {
					have1++;
				}
			}
			if (ui.size() == have1) {
				int[] tempArray = ui.getArray();
				sort(tempArray);
				if (shunzi(tempArray)) {
					return PokeType.feiji;
				}
			}

		}*/
		// ������ǿ�֪����,���ش�����
		return PokeType.error;

	}
	
	
	
	// ͳ��һ������ֵͬ���Ƴ��ֵĴ���
		public static int getPokeCount(int[] pokes, int poke) {
			int count = 0;
			for (int i = 0; i < pokes.length; i++) {
				if (getPokeValue(pokes[i]) == getPokeValue(poke)) {
					count++;
				}
			}
			return count;
		}
		
		//�ж��Ƿ���˳��
		public static boolean shunzi(int[] pokes) {
			int start = getPokeValue(pokes[0]);
			// ˳���в��ܰ���2,king
			if (start >= 15) {
				return false;
			}
			int next;
			for (int i = 1; i < pokes.length; i++) {
				next = getPokeValue(pokes[i]);
				if (start - next != 1) {
					return false;
				}
				start = next;
			}
			return true;
		}
		
		
		
		// ��pokes���дӴ�С����ð������
		public static void sort(int[] pokes) {
			for (int i = 0; i < pokes.length; i++) {
				for (int j = i + 1; j < pokes.length; j++) {
					if (pokes[i] < pokes[j]) {
						int temp = pokes[i];
						pokes[i] = pokes[j];
						pokes[j] = temp;
					}
				}
			}
		}

}
