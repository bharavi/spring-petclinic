package org.springframework.samples.petclinic.system;

import net.sf.infrared.agent.setup.InfraREDServletContextListener;
import net.sf.infrared.aspects.servlet.InfraREDServletFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class InfraredConfiguration {

	@Bean
	public FilterRegistrationBean<InfraREDServletFilter> infraREDServletFilterFilterRegistrationBean() {
		FilterRegistrationBean<InfraREDServletFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new InfraREDServletFilter());
		registrationBean.addUrlPatterns("/*");

		return registrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean<InfraREDServletContextListener> listenerRegistrationBean() {
		ServletListenerRegistrationBean<InfraREDServletContextListener> bean = new ServletListenerRegistrationBean<>();
		bean.setListener(new InfraREDServletContextListener());
		return bean;

	}

}
