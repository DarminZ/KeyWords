package com.keywords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.db.DBOperate;


public class GetWords {

	public static void excute(int id,String str) throws Exception{
		ArrayList<HashMap<String, Object>> listhash = new ArrayList<HashMap<String, Object>>();
		ArrayList<HashMap<String, Object>> hashMaps = new ArrayList<HashMap<String, Object>>();
		//���ȴ���Ϊ2�Ĵ�
//		ArrayList<HashMap<String, Object>> arrayList_1 = new ArrayList<HashMap<String, Object>>();
//		//����3��6�Ĵ�
//		ArrayList<HashMap<String, Object>> arrayList_2 = new ArrayList<HashMap<String, Object>>();

		listhash = GetSistring.getSistring(str,str);
		
		CaculateSE.caculateSE(str,listhash);
		listhash = CaculateSE.Paixu(listhash);
		for (int i = 0; i < listhash.size(); i++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			if ( Integer.parseInt(listhash.get(i).get("Count").toString())>2 &&
					Double.valueOf(listhash.get(i).get("SE").toString())>0.9) {				
				hashMap.put("Str", listhash.get(i).get("Str"));
				hashMap.put("Count", listhash.get(i).get("Count"));
				hashMap.put("SE", listhash.get(i).get("SE"));
				hashMaps.add(hashMap);
			}
		}
		hashMaps = FilterLP.filter(hashMaps);
		//ȥ�������Ĵ�
		GetSistring.delete(hashMaps);
		//������Ϊ2�Ĵʵ����ó���
//		String string = "";
//		for (int i = 0; i < hashMaps.size(); i++) {
//			HashMap<String, Object> hashMap = new HashMap<String, Object>();
//			if (hashMaps.get(i).get("Str").toString().length()==2) {
//				hashMap.put("Str", hashMaps.get(i).get("Str"));
//				hashMap.put("Count", hashMaps.get(i).get("Count"));
//				hashMap.put("SE", hashMaps.get(i).get("SE"));
//				string += hashMaps.get(i).get("Str").toString();
//				arrayList_1.add(hashMap);
//			}else if (hashMaps.get(i).get("Str").toString().length()>2){
//				hashMap.put("Str", hashMaps.get(i).get("Str"));
//				hashMap.put("Count", hashMaps.get(i).get("Count"));
//				hashMap.put("SE", hashMaps.get(i).get("SE"));
//				string += hashMaps.get(i).get("Str").toString();
//				arrayList_2.add(hashMap);			
//			}	
//			if (hashMaps.size()==1) {
//				string += hashMaps.get(i).get("Str").toString();
//			}else {
//				string += hashMaps.get(i).get("Str").toString() + "," ;
//			}		
//		}		
		print(hashMaps);
	}
	
	//��ӡ����
	public static void print(ArrayList<HashMap<String, Object>> hashMaps) throws IOException{
		for (int i = 0; i < hashMaps.size(); i++) {
			OpenFile.AddtoTxt(hashMaps.get(i).get("Str").toString());			
			OpenFile.AddtoTxt(hashMaps.get(i).get("Count").toString());
			System.out.println(hashMaps.get(i).get("Str"));
			System.out.println(hashMaps.get(i).get("SE"));
			System.out.println(hashMaps.get(i).get("Count"));
		}
		OpenFile.AddtoTxt("\n");
	}
}
