package co.edu.icesi;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class BeanPost implements BeanPostProcessor{
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean.getClass().getPackageName().equals("co.edu.icesi")) {
			log.info("My Bean: " + beanName);
		}
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(!bean.getClass().getPackageName().equals("co.edu.icesi")) {
			log.info("Spring Bean: " + beanName);
		}
		return bean;
	}
	
}
