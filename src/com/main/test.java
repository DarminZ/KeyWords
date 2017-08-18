package com.main;

import java.util.ArrayList;
import java.util.HashMap;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String,Object>>();
		
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object>hashMap = new HashMap<String, Object>();
			hashMap.put("count", i);
			arrayList.add(hashMap);
		}
		
		
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i).get("count"));
		}
		
		arrayList.remove(2);
		System.out.print(arrayList.size());
		System.out.print(arrayList.get(2));
		System.out.print("\n");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i).get("count"));
		}
	}

}
