package com.dzfp.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean工具
 * 
 * @author 陈捷
 *
 */
public class BeanUtil {

	private static ClassPathXmlApplicationContext context;

	/**
	 * 获取spring上下文
	 * 
	 * @return 上下文容器
	 */
	private static ApplicationContext getContext() {
		// Long startTime = Calendar.getInstance().getTimeInMillis();
		if (context == null) {
			ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext-server.xml");
			context = context1;
			context.start();
		}

		// Long endTime = Calendar.getInstance().getTimeInMillis();

		// System.out.println("初始化spring上下文,花费了:" + (endTime - startTime));
		return context;
	}

	/**
	 * 获取bean
	 * 
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		if (!StringUtils.isNotEmpty(beanName)) {
			return null;
		}
		return getContext().getBean(beanName);
	}
}
