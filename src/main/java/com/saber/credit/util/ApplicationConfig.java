package com.saber.credit.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 加载config.properties的工具类，提供访问系统常量及配置参数
 *
 */
public class ApplicationConfig {
	
	public static final String PARAM_FILTER = "FILTER";
	public static final String PARAM_PAGE = "PAGE";
	
	private static final String CONFIG_FILE = "config.properties";
	private static Map<String, Object> configs = new HashMap<String, Object>();
	
	
	private static final Logger log = Logger.getLogger(ApplicationConfig.class);
	static {
		InputStream in = null;
		Properties p = new Properties();
		try{
			in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(CONFIG_FILE);		
			p.load(in);
			for(Object k : p.keySet()){
				String key = (String) k;
				configs.put( key, p.getProperty(key));
			}
			log.info("config.properties is loaded!"  );
		} catch (IOException e){
			log.error("Unable to read config.properties");				
		} finally{
			if(in != null)
				try {
					in.close();
				} catch (IOException e) {
					log.error("Unable to close inputstream");		
				}
		}
	}
	
	/**
	 * 获取config.properties中的设置项
	 * @param key 设置项的key
	 * @return 设置数值
	 */
	public static String getConfig(String key){
		return (String) configs.get(key);
	}
	
	public static void set(String config, Object value){
		configs.put(config, value);
		
		log.info("--> Application Configuration Loaded: " + config + " = " + value);
	}
}
