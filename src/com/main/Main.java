package com.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.db.DBOperate;
import com.keywords.GetWords;
import com.keywords.OpenFile;


public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		ArrayList<HashMap<String,Object>> contentList = new DBOperate().SelectContent("gzdt");
//		ArrayList<HashMap<String,Object>> titletList = new DBOperate().SelectTitle("gzdt");
		ArrayList<HashMap<String,Object>> messageList = new DBOperate().SelectContent();
//		for (int i = 0; i < 30; i++) {
//			String str = OpenFile.deleteHTMLTag(contentList.get(i).get("content").toString());
//			str = str.replaceAll("[\\pZ|\n\\pN\\p{P}&&[^£¬¡££¡£¿¡¢£»£º]]","");
//			int id = Integer.valueOf(contentList.get(i).get("id").toString());			
//			Excute.excute(id,str);			
//		}
		String str = "";
		for (int i = 0; i < messageList.size(); i++) {
			str += messageList.get(i).get("content").toString()+"\n";
			str = str.replaceAll("[\\pZ|\n\\pN|[a-z][A-Z]]","");
			//int id = Integer.valueOf(messageList.get(i).get("id").toString());									
		}
		GetWords.excute(0,str);
	}

}
