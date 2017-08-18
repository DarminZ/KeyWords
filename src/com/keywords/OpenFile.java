package com.keywords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class OpenFile {

	public static String openFile(File file) {
		try {
			BufferedReader bis = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			String szContent = "";
			String szTemp;

			while ((szTemp = bis.readLine()) != null) {
				szContent += szTemp + "��" + "\n";
			}
			bis.close();
			szContent = szContent.replaceAll("[\\pZ|\n\\pN\\p{P}&&[^��������������]]",
					"");
			return szContent;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 *  ȥ��HTML��ǩ����ȡ����
	 * @param html
	 * @return
	 */
	public static String deleteHTMLTag(String html) {
		Document doc = Jsoup.parse(html);
		Elements elements = doc.getElementsByTag("p");
		elements.select("strong").remove();
		String content = elements.text().toString();
		return content;
	}

	/**
	 *  �����ַ����������г��ֵĴ���
	 * @param content
	 * @param target
	 * @return
	 */
	public static int strCount(String content, String target) {
		int count = 0;
		int index = 0;
		while (true) {
			index = content.indexOf(target, index);
			if (index >= 0) {
				count++;
				index++;
			} else {
				break;
			}
		}
		return count;
	}

	/**
	 *  ����ȡ�����Ĺؼ��ʼ��뵽�ı���
	 * @param key
	 * @throws IOException
	 */
	public static void AddtoTxt(String key) throws IOException {

		File filePath = new File("F:\\workspacesql\\UploadFile\\words.txt");
		if (!filePath.exists()) {
			filePath.createNewFile();
		}

		OutputStream os = new FileOutputStream(filePath, true);
		OutputStreamWriter osr = new OutputStreamWriter(os, "utf-8");
		osr.write(key);
		osr.write("\t");
//		osr.write("\r\n");
		if (osr != null) {
			osr.close();
		}
		if (os != null) {
			os.close();
		}
	}
}
