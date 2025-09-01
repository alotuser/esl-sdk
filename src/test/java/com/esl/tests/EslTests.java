package com.esl.tests;

import java.io.IOException;

import com.esl.open.sdk.domain.SystemParam;
import com.esl.open.sdk.dto.DelTaskDto;
import com.esl.open.sdk.dto.LedTaskDto;
import com.esl.open.sdk.dto.PageTaskDto;
import com.esl.open.sdk.dto.PicTaskDto;
import com.esl.open.sdk.exception.EslOpenException;
import com.esl.open.sdk.request.GetCoorRequest;
import com.esl.open.sdk.request.GetEslRequest;
import com.esl.open.sdk.request.GetTagRequest;
import com.esl.open.sdk.request.GetTaskRequest;
import com.esl.open.sdk.request.SendDelTaskRequest;
import com.esl.open.sdk.request.SendLedTaskRequest;
import com.esl.open.sdk.request.SendPageTaskRequest;
import com.esl.open.sdk.request.SendPicTaskRequest;
import com.esl.open.sdk.response.EslOpenResponse;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;

public class EslTests {

	/**
	 * 系统级参数
	 */
	public static SystemParam systemParam = new SystemParam("http://192.168.1.12:8080", "your appId", "your appSecret");

	/**
	 * 系统健康接口
	 * @throws EslOpenException
	 * @throws IOException
	 */
	public static void testGetEslRequest() throws EslOpenException, IOException {
		// 应用级参数
		GetEslRequest request = new GetEslRequest(systemParam);

		EslOpenResponse eslOpenResponse = request.doRequest();

		System.out.println(JSONUtil.toJsonPrettyStr(eslOpenResponse));
	}
	/**
	 * 获取价签列表
	 * @throws EslOpenException
	 * @throws IOException
	 */
	public static void testGetCoorRequest() throws EslOpenException, IOException {
		// 应用级参数
		GetCoorRequest request = new GetCoorRequest(systemParam);
		
		request.setCurrent(1L);
		request.setSize(10L);
		request.setCoorId("");
		request.setVer("");
		request.setBarcode("");
		
		EslOpenResponse eslOpenResponse = request.doRequest();

		System.out.println(JSONUtil.toJsonPrettyStr(eslOpenResponse));
	}
	/**
	 * 获取价签列表
	 * @throws EslOpenException
	 * @throws IOException
	 */
	public static void testGetTagRequest() throws EslOpenException, IOException {
		// 应用级参数
		GetTagRequest request = new GetTagRequest(systemParam);
		
		request.setCurrent(1L);
		request.setSize(10L);
		request.setTagId("");
		request.setVer("");
		
		
		EslOpenResponse eslOpenResponse = request.doRequest();

		System.out.println(JSONUtil.toJsonPrettyStr(eslOpenResponse));
	}
	/**
	 * 获取价签任务列表
	 * @throws EslOpenException
	 * @throws IOException
	 */
	public static void testGetTaskRequest() throws EslOpenException, IOException {
		// 应用级参数
		GetTaskRequest request = new GetTaskRequest(systemParam);
		
		request.setCurrent(1L);
		request.setSize(10L);
		request.setTagId("");
		request.setTaskDel("");
		request.setTaskSend("");
		request.setTaskStatus("");
		request.setTid("");
		
		EslOpenResponse eslOpenResponse = request.doRequest();

		System.out.println(JSONUtil.toJsonPrettyStr(eslOpenResponse));
	}
	/**
	 * 发送价签任务删除
	 * @throws EslOpenException
	 * @throws IOException
	 */
	public static void testSendDelTask() throws EslOpenException, IOException {
		// 应用级参数
		DelTaskDto task=new DelTaskDto();
		task.setTids(ListUtil.of("123"));
		SendDelTaskRequest request = new SendDelTaskRequest(systemParam,task);
		
		EslOpenResponse eslOpenResponse = request.doRequest();

		System.out.println(JSONUtil.toJsonPrettyStr(eslOpenResponse));
	}
	/**
	 * 发送价签LED闪灯任务
	 * @throws EslOpenException
	 * @throws IOException
	 */
	public static void testSendLedTask() throws EslOpenException, IOException {
		// 应用级参数
		LedTaskDto task=new LedTaskDto();
		task.setColor(1);
		task.setCount(100);
		task.setFreq(100);
		task.setLight(10);
		task.setPageNo(1);
		task.setStartTime("2025-07-25 18:30:56");
		task.setTagId(860140L);
		task.setTid(generateTID());
		
		
		SendLedTaskRequest request = new SendLedTaskRequest(systemParam,ListUtil.of(task));
		
		EslOpenResponse eslOpenResponse = request.doRequest();

		System.out.println(JSONUtil.toJsonPrettyStr(eslOpenResponse));
	}
	/**
	 * 发送价签切页图片任务
	 * @throws EslOpenException
	 * @throws IOException
	 */
	public static void testSendPageTask() throws EslOpenException, IOException {
		// 应用级参数
		PageTaskDto task=new PageTaskDto();
		
		task.setTid(generateTID());
		task.setTagId(860140L);
		task.setPageNo(1);
		task.setStartTime("2025-07-25 18:30:56");
		task.setEndTime("2025-07-26 18:33:56");
		task.setImageSrc("http://139.224.201.5:88/res/templateSvgImg/1926886404438904832/1927527911135178753/20250716/cbd2a2e6f15542a09599c98ac0e243ff.png");
		
		SendPageTaskRequest request = new SendPageTaskRequest(systemParam,ListUtil.of(task));
		
		EslOpenResponse eslOpenResponse = request.doRequest();

		System.out.println(JSONUtil.toJsonPrettyStr(eslOpenResponse));
	}
	/**
	 * 发送价签图片任务
	 * @throws EslOpenException
	 * @throws IOException
	 */
	public static void testSendPicTask() throws EslOpenException, IOException {
		// 应用级参数
		PicTaskDto task=new PicTaskDto();
		int i=0;
		task.setTid(generateTID()+i++);
		task.setTagId(10970800L);
		task.setPageNo(1);//http://192.168.1.98:88/res/templateSvgImg/13.png
		task.setImageSrc("http://192.168.1.98:88/res/templateSvgImg/14.png");
		
//		PicTaskDto task1=new PicTaskDto(),task2=new PicTaskDto(),task3=new PicTaskDto(),task4=new PicTaskDto();
//		task1.setTid(generateTID()+i++);
//		task1.setTagId(10970802L);
//		task1.setImageSrc("http://192.168.1.98:88/res/templateSvgImg/14.png");
//		
//		task2.setTid(generateTID()+i++);
//		task2.setTagId(10970809L);
//		task2.setImageSrc("http://192.168.1.98:88/res/templateSvgImg/14.png");
//		
//		task3.setTid(generateTID()+i++);
//		task3.setTagId(10971034L);
//		task3.setImageSrc("http://192.168.1.98:88/res/templateSvgImg/15.png");
//		
//		task4.setTid(generateTID()+i++);
//		task4.setTagId(10970812L);
//		task4.setImageSrc("http://192.168.1.98:88/res/templateSvgImg/14.png");
		
		
		//http://192.168.1.98:88/res/templateSvgImg/1947904911811362816/1947927272619065345/20250826/baa3a60e461d478192a0236962b77d81.png
		SendPicTaskRequest request = new SendPicTaskRequest(systemParam,ListUtil.of(task));
		
		EslOpenResponse eslOpenResponse = request.doRequest();

		System.out.println(JSONUtil.toJsonPrettyStr(eslOpenResponse));
	}

	public static String generateTID() {
		return StrUtil.toString(System.currentTimeMillis());
	}
	
	public static void main(String[] args) throws EslOpenException, IOException {
		
		//testGetEslRequest();
		testGetCoorRequest();
		//testGetTagRequest();
		//testGetTaskRequest();
		//testSendDelTask();
		//testSendLedTask();
		//testSendPageTask();
		//testSendPicTask();

	}

}
