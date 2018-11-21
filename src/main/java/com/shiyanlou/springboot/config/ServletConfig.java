package com.shiyanlou.springboot.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

//@Configuration表示该类为配置类，改注解可以被@ComponentScan扫描到
//@Configuration

/**
 * 注意：这是SpringBoot2.x通过Java代码修改内嵌容器端口的方式，如果是使用SpringBoot1.x这个方法就行不通了，SpringBoot1.x是通过实现EmbeddedServletContainerCustomizer接口来修改。
 * 来源: 实验楼 链接: https://www.shiyanlou.com/courses/1152
 * @author gnnt
 */
public class ServletConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		// TODO Auto-generated method stub
		factory.setPort(8082);
	}

}
