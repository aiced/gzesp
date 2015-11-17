package com.ai.gzesp.recharge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class FileUtils {
	
	private static String CARD_REQ_FIlE_PRIFIX = "esp_day_card_req_";
	
	private static String CARD_RESP_FIlE_PRIFIX = "esp_day_card_resp_";
	
	private static String BAND_REQ_FIlE_PRIFIX = "esp_day_band_req_";
	
	private static String BAND_RESP_FIlE_PRIFIX = "esp_day_band_resp_";
	
	/**
	 * 根据day日期yyyymmdd，找到回执txt文件，并读取内容到 list
	 * @param day
	 * @return
	 */
	public static List<String[]> readCardRespFile(String day){
		String filePath = getCardRespFilePath(day);
		Resource res = new FileSystemResource(filePath); 
		List<String[]> result = null;
		try {
			if(res.exists()){
				InputStream in = res.getInputStream();
				result = getListFromInputStream(in); //finally会关闭in 和 br
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * 根据day日期yyyymmdd，找到回执txt文件，并读取内容到 list
	 * @param day
	 * @return
	 */
	public static List<String[]> readBandRespFile(String day){
		String filePath = getBandRespFilePath(day);
		Resource res = new FileSystemResource(filePath); 
		List<String[]> result = null;
		try {
			if(res.exists()){
				InputStream in = res.getInputStream();
				result = getListFromInputStream(in); //finally会关闭in 和 br
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return result;
	}
	
	/**
	 * 根据day日期yyyymmdd，创建新txt文件，根据结果集list，写文件内容
	 * @param day
	 * @param list
	 */
	public static void writeCardReqFile(String day, List<LinkedHashMap<String, String>> list) {
		String filePath = getCardReqFilePath(day);
		FileSystemResource res = new FileSystemResource(filePath);
		File file = null;
		OutputStream os = null;
		BufferedWriter bw = null;
		try {
			// 创建txt文件
			file = res.getFile();
			if (!file.exists()) {
				file.createNewFile();
			}
			//设置744权限
			Runtime.getRuntime().exec("chmod 744 " + filePath);   
//			file.setReadable(true);
//			file.setWritable(true, true);
//			file.setExecutable(true, true); 
			// 写文件内容
			os = res.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
			for(int i = 0; i < list.size(); i++){
				LinkedHashMap<String, String> map = list.get(i);
				int num2 = map.entrySet().size();
				int j = 1;
				for (Map.Entry<String, String> me : map.entrySet()) {
					bw.write(me.getValue());
					if(j < num2){
						bw.write(",");
					}
					j++;
				}
				if(i < list.size()-1){
					bw.newLine(); // 换行
				}
			}
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	/**
	 * 根据day日期yyyymmdd，创建新txt文件，根据结果集list，写文件内容
	 * @param day
	 * @param list
	 */
	public static void writeBandReqFile(String day, List<LinkedHashMap<String, String>> list) {
		String filePath = getBandReqFilePath(day);
		FileSystemResource res = new FileSystemResource(filePath);
		File file = null;
		OutputStream os = null;
		BufferedWriter bw = null;
		try {
			// 创建txt文件
			file = res.getFile();
			if (!file.exists()) {
				file.createNewFile();
			}
			//设置744权限
			Runtime.getRuntime().exec("chmod 744 " + filePath);   
//			file.setReadable(true, false); //设置用户，用户组，的可以，其他用户的，设置不了
//			file.setWritable(true, true);
//			file.setExecutable(true, true); 
			// 写文件内容
			os = res.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
			for(int i = 0; i < list.size(); i++){
				LinkedHashMap<String, String> map = list.get(i);
				int num2 = map.entrySet().size();
				int j = 1;
				for (Map.Entry<String, String> me : map.entrySet()) {
					bw.write(me.getValue());
					if(j < num2){
						bw.write(",");
					}
					j++;
				}
				if(i < list.size()-1){
					bw.newLine(); // 换行
				}
			}
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	/**
	 * 从InputStream中读取文件内容，并存放到 list里，每行记录逗号split成String[]
	 * @param in
	 * @return
	 */
	public static List<String[]> getListFromInputStream(InputStream in) {
		List<String[]> result = new ArrayList<String[]>();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",", -1); // 每列逗号分隔
				result.add(row);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
	
	/**
	 * 根据日期yyyymmdd，拼出沃掌柜给bss 一卡充状态同步文件的完全路径
	 * 如：传入20150801 返回 /home/webapp/app/interface/card/req/esp_day_card_req_20150801.txt
	 * @param day
	 * @return
	 */
	public static String getCardReqFilePath(String day){
		StringBuilder sb = new StringBuilder();
		sb.append(getParentPath()); 
		sb.append(File.separator);
		sb.append("card");
		sb.append(File.separator);
		sb.append("req");
		sb.append(File.separator);
		sb.append(CARD_REQ_FIlE_PRIFIX);
		sb.append(day);
		sb.append(".txt");
		
		return sb.toString();
	}
	
	/**
	 * 根据日期yyyymmdd，拼出bss给沃掌柜回执文件的完全路径
	 * 如：传入20150801 返回 /home/webapp/app/interface/card/resp/esp_day_card_resp_20150801.txt
	 * @param day
	 * @return
	 */
	public static String getCardRespFilePath(String day){
		StringBuilder sb = new StringBuilder();
		sb.append(getParentPath()); 
		sb.append(File.separator);
		sb.append("card");
		sb.append(File.separator);
		sb.append("resp");
		sb.append(File.separator);
		sb.append(CARD_RESP_FIlE_PRIFIX);
		sb.append(day);
		sb.append(".txt");
		
		return sb.toString();
	}
	
	/**
	 * 根据日期yyyymmdd，拼出沃掌柜给bss 宽带续约对账同步文件的完全路径
	 * 如：传入20150801 返回 /home/webapp/app/interface/band/req/esp_day_card_req_20150801.txt
	 * @param day
	 * @return
	 */
	public static String getBandReqFilePath(String day){
		StringBuilder sb = new StringBuilder();
		sb.append(getParentPath()); 
		sb.append(File.separator);
		sb.append("band");
		sb.append(File.separator);
		sb.append("req");
		sb.append(File.separator);
		sb.append(BAND_REQ_FIlE_PRIFIX);
		sb.append(day);
		sb.append(".txt");
		
		return sb.toString();
	}
	
	/**
	 * 根据日期yyyymmdd，拼出bss给沃掌柜宽带续约对账回执文件的完全路径
	 * 如：传入20150801 返回 /home/webapp/app/interface/band/resp/esp_day_card_resp_20150801.txt
	 * @param day
	 * @return
	 */
	public static String getBandRespFilePath(String day){
		StringBuilder sb = new StringBuilder();
		sb.append(getParentPath()); 
		sb.append(File.separator);
		sb.append("band");
		sb.append(File.separator);
		sb.append("resp");
		sb.append(File.separator);
		sb.append(BAND_RESP_FIlE_PRIFIX);
		sb.append(day);
		sb.append(".txt");
		
		return sb.toString();
	}
	
	/**
	 * 所有接口文件，前面父路径是固定的/home/webapp/app/interface/
	 * @return
	 */
	public static String getParentPath(){
		StringBuilder sb = new StringBuilder();
		//sb.append("file:"); //通过file的方式
		sb.append(File.separator);
		sb.append("home");
		sb.append(File.separator);
		sb.append("webapp");
		sb.append(File.separator);
		sb.append("app");
		sb.append(File.separator);
		sb.append("interface");
		
		return sb.toString();
	}
	

	public static void main(String[] args) {
		System.out.println(getParentPath());
		System.out.println(getCardRespFilePath("20150801"));
		System.out.println(getCardReqFilePath("20150801"));
	}
}
