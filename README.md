# 基站价签SDK开发介绍文档

## 目录
- [一、SDK简介](#一sdk简介)
- [二、环境要求](#二环境要求)
- [三、主要接口功能](#三主要接口功能)
- [四、使用方法](#四使用方法)
- [五、返回结果](#五返回结果)
- [六、注意事项](#六注意事项)
- [七、示例代码](#七示例代码)

---

## 一、SDK简介

本SDK用于对接基站价签系统，支持价签信息查询、任务下发、LED控制、图片切换等功能。  
基于Java开发，采用Maven管理依赖，接口调用简单，便于集成到业务系统。

---

## 二、环境要求

- JDK 8及以上  
- Maven 3.2+  
- 需引入 `esl-open-sdk` 相关依赖
``` xml
<dependency>
    <groupId>com.github.alotuser</groupId>
    <artifactId>esl-sdk</artifactId>
    <version>1.1.1</version>
</dependency>
```
---

## 三、主要接口功能

1.**系统健康接口**   
 &nbsp; &nbsp; &nbsp; &nbsp;检查基站服务是否正常运行，返回服务状态信息，常用于系统监控和故障排查。

2.**获取基站列表**   
 &nbsp; &nbsp; &nbsp; &nbsp;分页查询所有基站设备信息，可按条件筛选，适用于设备管理和数据统计。

3.**获取价签列表**   
 &nbsp; &nbsp; &nbsp; &nbsp;分页查询所有价签设备信息，可按条件筛选，适用于设备管理和数据统计。

4.**获取价签任务列表**  
 &nbsp; &nbsp; &nbsp; &nbsp;查询价签任务的执行情况，支持按任务状态、价签ID等过滤，便于任务跟踪和运维。

5.**发送价签删除任务**  
 &nbsp; &nbsp; &nbsp; &nbsp;向指定价签下发删除任务，支持批量操作，常用于设备回收或数据清理。

6.**发送价签LED闪灯任务**  
 &nbsp; &nbsp; &nbsp; &nbsp;控制价签LED灯闪烁，可设置颜色、次数、频率等，适用于定位或提醒场景。

7.**发送价签切页图片任务**  
 &nbsp; &nbsp; &nbsp; &nbsp;向价签下发切换页面图片任务，支持时间区间和图片地址设置，适合促销或信息展示。

8.**发送价签图片任务**  
 &nbsp; &nbsp; &nbsp; &nbsp;向价签指定页面下发图片显示任务，主要用于内容更新和个性化展示。

---

## 四、使用方法

### 初始化系统级参数 
``` java
SystemParam systemParam = new SystemParam("http://192.168.1.40:8080", "your appId", "your appSecret");
```

### 1. 系统健康接口 
``` java
GetEslRequest getEslRequest = new GetEslRequest(systemParam);
EslOpenResponse healthResp = getEslRequest.doRequest();
System.out.println(JSONUtil.toJsonPrettyStr(healthResp));
```
###  2. 获取基站列表
``` java
GetCoorRequest request = new GetCoorRequest(systemParam);
request.setCurrent(1L);
request.setSize(10L);
request.setCoorId("");
request.setVer("");
request.setBarcode("");
EslOpenResponse eslOpenResponse = request.doRequest();
System.out.println(JSONUtil.toJsonPrettyStr(eslOpenResponse));
```
###  3. 获取价签列表
``` java
GetTagRequest getTagRequest = new GetTagRequest(systemParam);
getTagRequest.setCurrent(1L);
getTagRequest.setSize(10L);
getTagRequest.setTagId("");
getTagRequest.setVer("");
EslOpenResponse tagListResp = getTagRequest.doRequest();
System.out.println(JSONUtil.toJsonPrettyStr(tagListResp));
```
### 4. 获取价签任务列表
``` java
GetTaskRequest getTaskRequest = new GetTaskRequest(systemParam);
getTaskRequest.setCurrent(1L);
getTaskRequest.setSize(10L);
getTaskRequest.setTagId("");
getTaskRequest.setTaskDel("");
getTaskRequest.setTaskSend("");
getTaskRequest.setTaskStatus("");
getTaskRequest.setTid("");
EslOpenResponse taskListResp = getTaskRequest.doRequest();
System.out.println(JSONUtil.toJsonPrettyStr(taskListResp));
```
### 5. 发送价签删除任务
``` java
DelTaskDto delTask = new DelTaskDto();
delTask.setTids(ListUtil.of("123"));
SendDelTaskRequest delTaskRequest = new SendDelTaskRequest(systemParam, delTask);
EslOpenResponse delResp = delTaskRequest.doRequest();
System.out.println(JSONUtil.toJsonPrettyStr(delResp));
```
### 6. 发送价签LED闪灯任务
``` java
LedTaskDto ledTask = new LedTaskDto();
ledTask.setColor(1);
ledTask.setCount(100);
ledTask.setFreq(100);
ledTask.setLight(10);
ledTask.setPageNo(1);
ledTask.setStartTime("2025-07-25 18:30:56");
ledTask.setTagId(569319926);
ledTask.setTid("1234");
SendLedTaskRequest ledTaskRequest = new SendLedTaskRequest(systemParam, ListUtil.of(ledTask));
EslOpenResponse ledResp = ledTaskRequest.doRequest();
System.out.println(JSONUtil.toJsonPrettyStr(ledResp));
```
### 7. 发送价签切页图片任务
``` java
PageTaskDto pageTask = new PageTaskDto();
pageTask.setTid("1235");
pageTask.setTagId(569319926);
pageTask.setPageNo(1);
pageTask.setStartTime("2025-07-25 18:30:56");
pageTask.setEndTime("2025-07-26 18:33:56");
pageTask.setImageSrc("http://139.224.201.5:88/res/templateSvgImg/1926886404438904832/1927527911135178753/20250716/cbd2a2e6f15542a09599c98ac0e243ff.png");
SendPageTaskRequest pageTaskRequest = new SendPageTaskRequest(systemParam, ListUtil.of(pageTask));
EslOpenResponse pageResp = pageTaskRequest.doRequest();
System.out.println(JSONUtil.toJsonPrettyStr(pageResp));
```
### 8. 发送价签图片任务
``` java
PicTaskDto picTask = new PicTaskDto();
picTask.setTid("1236");
picTask.setTagId(569319926);
picTask.setPageNo(1);
picTask.setImageSrc("http://139.224.201.5:88/res/templateSvgImg/1926886404438904832/1927527911135178753/20250716/cbd2a2e6f15542a09599c98ac0e243ff.png");
SendPicTaskRequest picTaskRequest = new SendPicTaskRequest(systemParam, ListUtil.of(picTask));
EslOpenResponse picResp = picTaskRequest.doRequest();
System.out.println(JSONUtil.toJsonPrettyStr(picResp));
```


---

## 五、返回结果

所有接口返回 `EslOpenResponse` 对象，包含业务数据和状态信息，可通过 `JSONUtil.toJsonPrettyStr` 格式化输出。

---

## 六、注意事项

- 所有任务需设置正确的 `tagId`、`tid` 等参数。
- 时间格式需为 `yyyy-MM-dd HH:mm:ss`。
- 网络地址需保证基站可访问。

---

## 七、示例代码

详见 `src/main/java/cn/alotus/test/Test.java`，包含各接口调用演示。

---

如需更多接口说明或参数详解，请参考SDK源码或联系技术支持。
