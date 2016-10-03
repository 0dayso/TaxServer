package com.aisinogz.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerHelper {
	private static Logger LOGGER = Logger.getLogger(FreeMarkerHelper.class);
	private static Configuration conf = new Configuration();
	private static Map<String, Template> templateCache = new HashMap<String, Template>();

	static {
		conf.setEncoding(Locale.getDefault(), "UTF-8");
		conf.setDefaultEncoding("UTF-8");
		conf.setNumberFormat("###############");
		conf.setBooleanFormat("true,false");
	}

	public static String generate(Map<String, Object> model, String templateName) {
		StringWriter w = new StringWriter();
		Template template = null;
		try {
			if (templateCache.containsKey(templateName)) {
				LOGGER.debug("从缓存中获取模板信息:" + templateName);
				template = (Template) templateCache.get(templateName);
			} else {
				InputStream inputStream = FreeMarkerHelper.class.getResourceAsStream("/template/" + templateName);
				String templateStr = null;
				try {
					templateStr = IOUtils.toString(inputStream);
				} catch (IOException e1) {
					LOGGER.error("templateName error!!" + e1.getMessage());
					e1.printStackTrace();
				}
				try {
					template = new Template(templateName, new StringReader(templateStr), conf);
				} catch (IOException e1) {
					LOGGER.error("create template error!!!" + e1.getMessage());
				}
				templateCache.put(templateName, template);
			}
			template.process(model, w);
		} catch (IOException e) {
			LOGGER.error("获取模板信息时出现IOException，详情为：" + e.getMessage());
			e.printStackTrace();
		} catch (TemplateException e) {
			LOGGER.error("获取模板信息时出现TemplateException，详情为：" + e.getMessage());
			e.printStackTrace();
		}
		return w.toString();
	}

	@Test
	public void test1() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bussinessId", "你好，中国1");
		model.put("base64Data", "你好，中国2");
		String generateStr = generate(model, "Request_General.xml");
		System.out.println(generateStr);
	}
}