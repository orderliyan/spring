package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import controller.Server;
import entity.Result;

public class Agent {
	private static Logger logger = Logger.getLogger(Server.class); 
	
	//读取系统日志
	public static Result<String> readLog(int row,int line) throws IOException {
		Result<String> result=new Result<String>();
		FileReader fr=new FileReader ("G://logs/info.log");
		BufferedReader bufr=new BufferedReader (fr);
		StringBuffer buf=new StringBuffer();
		while(row>0) {
			 bufr.readLine();
			 row--;
		}
		String str=bufr.readLine();
		if(str==null) {
			result.setStatus(0);
		}else {
			buf.append(str+"<br / >");
			while(line>1) {
				buf.append(bufr.readLine()+"<br / >");
				line--;
			}
			result.setData(buf.toString());
			result.setStatus(1);
		 } 
		bufr.close();
        return result;
	}

	//记录系统日志
	public static void writeLog(String str){
	   // 记录info级别的信息  
	   logger.info("浏览器User Agent信息："+str);  
	}
}
