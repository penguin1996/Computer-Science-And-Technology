package src.com.FOUR;

import java.util.*;

public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			char[] ch = str.toCharArray();
			Map<Character,Integer> map = new TreeMap<>();
			//遍历字符数组，统计每个字符出现的次数并存放在Map中（key：字符；value：出现次数）。
			for (int i = 0; i < ch.length; i++) {
				Integer freq = map.get(ch[i]);
				map.put(ch[i], (freq==null)?1:freq+1);
			}
			int number = Integer.MAX_VALUE;
			//list存放出现次数最少的字符
			ArrayList<Character> list = new ArrayList<>();
			//找出出现最少的字符
			for (int i = 0; i < ch.length; i++) {
				if(map.get(ch[i]) < number){
					number = map.get(ch[i]);
					list.clear();
					list.add(ch[i]);
				}else if(map.get(ch[i]) == number){
					list.add(ch[i]);
				}
			}
			//删除
			for (char c : list) {
				str = str.replace(String.valueOf(c), "");
			}
			System.out.println(str);
		}
		sc.close();

		ArrayList arrayList;
		LinkedList linkedList;
		StringBuilder stringBuilder;
		StringBuffer stringBuffer;
	}
}