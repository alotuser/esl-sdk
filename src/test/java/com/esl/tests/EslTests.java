package com.esl.tests;

import java.io.IOException;

import com.esl.open.sdk.domain.SystemParam;
import com.esl.open.sdk.dto.DelTaskDto;
import com.esl.open.sdk.dto.LedTaskDto;
import com.esl.open.sdk.dto.PageTaskDto;
import com.esl.open.sdk.dto.PicTaskDto;
import com.esl.open.sdk.exception.EslOpenException;
import com.esl.open.sdk.request.GetEslRequest;
import com.esl.open.sdk.request.GetTagRequest;
import com.esl.open.sdk.request.GetTaskRequest;
import com.esl.open.sdk.request.SendDelTaskRequest;
import com.esl.open.sdk.request.SendLedTaskRequest;
import com.esl.open.sdk.request.SendPageTaskRequest;
import com.esl.open.sdk.request.SendPicTaskRequest;
import com.esl.open.sdk.response.EslOpenResponse;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;

public class EslTests {

	/**
	 * 系统级参数
	 */
	public static SystemParam systemParam = new SystemParam("http://192.168.1.40:8080", "your appId", "your appSecret");

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
		task.setTagId(569319926);
		task.setTid("1234");
		
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
		
		task.setTid("1235");
		task.setTagId(569319926);
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
		
		task.setTid("1236");
		task.setTagId(569319926);
		task.setPageNo(1);
		task.setImageSrc("http://139.224.201.5:88/res/templateSvgImg/1926886404438904832/1927527911135178753/20250716/cbd2a2e6f15542a09599c98ac0e243ff.png");
		
		SendPicTaskRequest request = new SendPicTaskRequest(systemParam,ListUtil.of(task));
		
		EslOpenResponse eslOpenResponse = request.doRequest();

		System.out.println(JSONUtil.toJsonPrettyStr(eslOpenResponse));
	}
	
	
	public static void main(String[] args) throws EslOpenException, IOException {

		
		//testGetEslRequest();
		
		//testGetTagRequest();
		
		//testGetTaskRequest();
		//testSendDelTask();
		testSendLedTask();
		//testSendPageTask();
		//testSendPicTask();
		
		


	}

}
