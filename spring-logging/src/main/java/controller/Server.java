package controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Result;
import service.Agent;

@Controller
@RequestMapping("/log")
public class Server {
	@RequestMapping("/logging.do")
	@ResponseBody //以jason对象返回
	public Result<String> showLog(HttpServletRequest request) throws IOException {
		Agent agent=new Agent();
		String row=request.getParameter("row");
		String line=request.getParameter("line");
		//String ua = request.getHeader("User-Agent");//获取浏览器ua信息
		//agent.wiiteLog(ua);//将浏览器信息记录到日志中
		//读取系统日志信息
		Result<String> result=null;
		result=agent.readLog(Integer.parseInt(row),Integer.parseInt(line));
		return result;	//将结果返回给前端页面
	}
}
