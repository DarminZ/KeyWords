package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DBOperate {

	//加入热词库
	public void AddHotWord(ArrayList<HashMap<String,Object>> datas){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.createConn();
			String sql = "insert into HotWord(name,count)values(?,?)";
			for (int i=0;i<datas.size();i++) {
				ps = conn.prepareStatement(sql);
				ps.setString(1,datas.get(i).get("Str").toString());
				ps.setInt(2,Integer.valueOf(datas.get(i).get("Count").toString()));
				ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DBManager.close(conn);
			DBManager.close(ps);
			DBManager.close(rs);
		}
	}
	
	//提取文章内容
	public ArrayList<HashMap<String, Object>> SelectContent(String str){
		ArrayList<HashMap<String, Object>> contentList = new ArrayList<HashMap<String, Object>>();		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = null;
		if (str == "gzdt") {
			sql = "select id,content from Gzdt";
		}else if (str == "zcfg") {
			sql = "select id,content from Zcfg";
		}else if (str == "kcgl") {
			sql = "select id,content from Kcgl";
		}else if (str == "ktkf") {
			sql = "select id,content from Ktkf";
		}else if (str == "kjjz") {
			sql = "select id,content from Kjjz";
		}else if (str == "gjhz") {
			sql = "select id,content from Gjhz";
		}
		try {
			conn = DBManager.createConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				HashMap<String, Object>content = new HashMap<String, Object>();
				content.put("id", rs.getInt("id"));
				content.put("content", rs.getString("content"));
				contentList.add(content);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DBManager.close(conn);
			DBManager.close(st);
			DBManager.close(rs);
		}
		return contentList;		
	}
	
	//提取标题内容
		public ArrayList<HashMap<String, Object>> SelectTitle(String str){
			ArrayList<HashMap<String, Object>> titletList = new ArrayList<HashMap<String, Object>>();		
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			String sql = null;
			if (str == "gzdt") {
				sql = "select id,title from Gzdt";
			}else if (str == "zcfg") {
				sql = "select id,title from Zcfg";
			}else if (str == "kcgl") {
				sql = "select id,title from Kcgl";
			}else if (str == "ktkf") {
				sql = "select id,title from Ktkf";
			}else if (str == "kjjz") {
				sql = "select id,title from Kjjz";
			}else if (str == "gjhz") {
				sql = "select id,title from Gjhz";
			}
			try {
				conn = DBManager.createConn();
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()){
					HashMap<String, Object>title = new HashMap<String, Object>();
					title.put("id", rs.getInt("id"));
					title.put("title", rs.getString("title"));
					titletList.add(title);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				DBManager.close(conn);
				DBManager.close(st);
				DBManager.close(rs);
			}
			return titletList;		
		}
	
	//加入热词库
		public void AddHotWord(int id , String keywords){
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				conn = DBManager.createConn();
				String sql = "update Gzdt set keywords=" + "'"+keywords+"'" + "where id = " + id;
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				DBManager.close(conn);
				DBManager.close(ps);
				DBManager.close(rs);
			}
		}
		//提取动态内容
		public ArrayList<HashMap<String, Object>> SelectContent(){
			ArrayList<HashMap<String, Object>> contentList = new ArrayList<HashMap<String, Object>>();		
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			String sql = null;
			sql = "select MessageID,content from Message";
			try {
				conn = DBManager.createConn();
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()){
					HashMap<String, Object>content = new HashMap<String, Object>();
					content.put("id", rs.getInt(1));
					content.put("content", rs.getString(2));
					contentList.add(content);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				DBManager.close(conn);
				DBManager.close(st);
				DBManager.close(rs);
			}
			return contentList;		
		}
}
