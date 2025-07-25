package com.esl.open.sdk.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.esl.open.sdk.exception.EslOpenException;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;

public class PropertiesUtil {
	private static int socketTimeOut = 5000;
	private static int connectTimeOut = 3000;
	private static int connectRequestTimeOut = 3000;
	private static int maxTotal = 20;
	private static int defaultMaxPerRoute = 20;
	private static int maxPerRoute = 20;
	private static String tokenFilePath = "/export/esl/openapi/";
	private static boolean isSig = true;
	private static String sdkVersion = "1.0.1";

 
	public static String getTokenFilePath() {
		Properties prop = new Properties();
		InputStream inputStream = null;
		String tokenFilePath = "";

		String var4;
		try {
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties");
			prop.load(inputStream);
			tokenFilePath = prop.getProperty("tokenFilePath");
			String var3 = StrUtil.isBlank(tokenFilePath) ? PropertiesUtil.tokenFilePath : tokenFilePath;
			return var3;
		} catch (Exception var8) {
			var4 = PropertiesUtil.tokenFilePath;
		} finally {
			IoUtil.close(inputStream);
		}

		return var4;
	}

	public static boolean getIsSig() {
		Properties prop = new Properties();
		InputStream inputStream = null;
		String isSig = "";

		boolean var4;
		try {
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties");
			prop.load(inputStream);
			isSig = prop.getProperty("isSig");
			boolean var3 = StrUtil.isBlank(isSig) ? PropertiesUtil.isSig : Integer.parseInt(isSig) == 1;
			return var3;
		} catch (Exception var8) {
			var4 = PropertiesUtil.isSig;
		} finally {
			IoUtil.close(inputStream);
		}

		return var4;
	}

	public static String getTokenScanPath() {
		Properties prop = new Properties();
		InputStream inputStream = null;
		String tokenScanPath = "";

		String var4;
		try {
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties");
			prop.load(inputStream);
			tokenScanPath = prop.getProperty("tokenScanPath");
			String var3 = tokenScanPath == null ? "" : tokenScanPath;
			return var3;
		} catch (Exception var8) {
			var4 = "";
		} finally {
			IoUtil.close(inputStream);
		}

		return var4;
	}

	public static String getSdkersion() {
		Properties prop = new Properties();
		InputStream inputStream = null;
		String sdkVersion = "";

		String var4;
		try {
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties");
			prop.load(inputStream);
			sdkVersion = prop.getProperty("sdkVersion");
			String var3 = StrUtil.isBlank(sdkVersion) ? PropertiesUtil.sdkVersion : sdkVersion;
			return var3;
		} catch (Exception var8) {
			var4 = PropertiesUtil.sdkVersion;
		} finally {
			IoUtil.close(inputStream);
		}

		return var4;
	}

	public static String getEnvironmentMode() throws EslOpenException {
		Properties prop = new Properties();
		String env = "";

		try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties")) {
			prop.load(inputStream);
			env = prop.getProperty("env");
			String var4 = env;
			return var4;
		} catch (FileNotFoundException e) {
			throw new EslOpenException("未找到'environment.properties'环境配置文件", e);
		} catch (IOException e) {
			throw new EslOpenException(e);
		}
	}

	public static String getAPIUrl() throws EslOpenException {
		Properties prop = new Properties();
		String url = "";

		try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties")) {
			prop.load(inputStream);
			url = prop.getProperty("url");
			String var4 = url;
			return var4;
		} catch (FileNotFoundException e) {
			throw new EslOpenException("未找到'environment.properties'环境配置文件", e);
		} catch (IOException e) {
			throw new EslOpenException(e);
		}
	}

	public static int getSocketTimeOut() throws IOException {
		Properties prop = new Properties();
		String env = "";
		int socketTimeOut = 0;

		try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties")) {
			prop.load(inputStream);
			env = prop.getProperty("socketTimeOut");
			socketTimeOut = Integer.parseInt(env);
			if (socketTimeOut <= 0) {
				int var21 = PropertiesUtil.socketTimeOut;
				return var21;
			} else {
				int var5 = socketTimeOut;
				return var5;
			}
		} catch (Exception var18) {
			return PropertiesUtil.socketTimeOut;
		}
	}

	public static int getConnectTimeOut() throws IOException {
		Properties prop = new Properties();
		InputStream inputStream = null;
		String env = "";
		int connectTimeOut = 0;

		int var4;
		try {
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties");
			prop.load(inputStream);
			env = prop.getProperty("connectTimeOut");
			connectTimeOut = Integer.parseInt(env);
			if (connectTimeOut <= 0) {
				var4 = PropertiesUtil.connectTimeOut;
				return var4;
			}

			var4 = connectTimeOut;
		} catch (Exception var9) {
			return PropertiesUtil.connectTimeOut;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

		return var4;
	}

	public static int getConnectRequestTimeOut() throws IOException {
		Properties prop = new Properties();
		InputStream inputStream = null;
		String env = "";
		int connectRequestTimeOut = 0;

		int var4;
		try {
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties");
			prop.load(inputStream);
			env = prop.getProperty("connectRequestTimeOut");
			connectRequestTimeOut = Integer.parseInt(env);
			if (connectRequestTimeOut <= 0) {
				var4 = PropertiesUtil.connectRequestTimeOut;
				return var4;
			}

			var4 = connectRequestTimeOut;
		} catch (Exception var9) {
			int var5 = PropertiesUtil.connectRequestTimeOut;
			return var5;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}

		}

		return var4;
	}

	public static int getHttpClientPoolMaxTotal() {
		Properties prop = new Properties();
		InputStream inputStream = null;

		int var4;
		try {
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties");
			prop.load(inputStream);
			String env = prop.getProperty("maxTotal");
			int maxTotal = Integer.parseInt(env);
			if (maxTotal <= 0) {
				var4 = PropertiesUtil.maxTotal;
				return var4;
			}

			var4 = maxTotal;
		} catch (Exception var15) {
			int maxTotal = PropertiesUtil.maxTotal;
			return maxTotal;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return var4;
	}

	public static int getHttpClientPoolDefaultMaxPerRoute() {
		Properties prop = new Properties();
		InputStream inputStream = null;

		int var4;
		try {
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties");
			prop.load(inputStream);
			String env = prop.getProperty("defaultMaxPerRoute");
			int defaultMaxPerRoute = Integer.parseInt(env);
			if (defaultMaxPerRoute <= 0) {
				var4 = PropertiesUtil.defaultMaxPerRoute;
				return var4;
			}

			var4 = defaultMaxPerRoute;
		} catch (Exception var15) {
			int defaultMaxPerRoute = PropertiesUtil.defaultMaxPerRoute;
			return defaultMaxPerRoute;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return var4;
	}

	public static int getHttpClientPoolMaxPerRoute() {
		Properties prop = new Properties();
		InputStream inputStream = null;

		int var4;
		try {
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("environment.properties");
			prop.load(inputStream);
			String env = prop.getProperty("maxPerRoute");
			int maxTotal = Integer.parseInt(env);
			if (maxTotal <= 0) {
				var4 = maxPerRoute;
				return var4;
			}

			var4 = maxTotal;
		} catch (Exception var15) {
			int maxTotal = maxPerRoute;
			return maxTotal;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return var4;
	}
}
