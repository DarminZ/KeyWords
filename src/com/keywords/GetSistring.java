package com.keywords;

import java.util.ArrayList;
import java.util.HashMap;

public class GetSistring {

	/**
	 *  �õ������޳��ַ���
	 * @param content
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<HashMap<String, Object>> getSistring(String content,
			String str) throws Exception {

		ArrayList<String> list = new ArrayList<String>();
		list = GetStrings(str);
		ArrayList<String> Sistringlist = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			// ��ǰ�����ȡ
			for (int j = list.get(i).toString().length(); j > 0; j--) {
				Sistringlist.add(list.get(i).substring(0, j));
			}
			// �Ӻ���ǰ��ȡ
			for (int j = 1; j < list.get(i).toString().length(); j++) {
				Sistringlist.add(list.get(i).substring(j,
						list.get(i).toString().length()));
			}
		}
		// ɾ������С��2�����6�İ����޳��ַ���
		for (int i = 0; i < Sistringlist.size(); i++) {
			if (Sistringlist.get(i).toString().length() < 2
					|| Sistringlist.get(i).toString().length() > 6) {
				Sistringlist.remove(i);
				i--;// ÿɾ��һ�����ȷ����仯
			}
		}

		ArrayList<HashMap<String, Object>> listhashmap = new ArrayList<HashMap<String, Object>>();
		// ����ÿ�������޳��ַ�����Ƶ��
		for (int k = 0; k < Sistringlist.size(); k++) {
			HashMap<String, Object> hashmap = new HashMap<String, Object>();
			hashmap.put("Str", Sistringlist.get(k));
			int count = OpenFile.strCount(content, Sistringlist.get(k)
					.toString());
			hashmap.put("Count", count);
			listhashmap.add(hashmap);
		}
		return listhashmap;
	}

	/**
	 * �õ�ȥ�������ŵ��ַ�������
	 * @param str
	 * @return
	 */
	public static ArrayList<String> GetStrings(String str) {

		ArrayList<String> list = new ArrayList<String>();
		String[] strings = str.split("\\p{P}");
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].length() > 1) {
				list.add(strings[i]);
			}
		}
		return list;
	}
	
	/**
     * �Ƚ�һ���ַ����Ƿ������һ���ַ���
     * @param str �����ַ���
     * @param searchChars �Ƿ�������ַ���
     * @return
     */
	public static boolean containsAny(String str, String searchChars) { 
		  if(str.length()!=str.replace(searchChars,"").length())  { 
			  return true; 
		  } 
		  	return false;
		 }

	/**
	 * һ���ʱ���������һ�����У���ɾ�������
	 * @param hashMaps
	 */
	public static void delete(ArrayList<HashMap<String, Object>> hashMaps){
		for (int i = 0; i < hashMaps.size(); i++) {
			String Str = hashMaps.get(i).get("Str").toString();
			for (int j = 0; j < hashMaps.size(); j++) {
				String Str1 = hashMaps.get(j).get("Str").toString();
				if (Str1.equals(Str)) {
					continue;
				}
				else if (containsAny(Str1, Str)) {
					hashMaps.remove(i);
					i--;
				}
			}
		}
	}
}
