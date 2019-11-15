package co.edu.icesi;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Lazy // Only when we needed Spring crate the Bean
@Log4j2
public class MyBeanY {
	public void info() {
		log.info("hello");
	}
}
