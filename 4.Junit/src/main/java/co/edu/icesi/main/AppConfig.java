package co.edu.icesi.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.icesi.service.SampleService;
import co.edu.icesi.service.SampleServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public SampleService sampleService() {
		return new SampleServiceImpl();
	}
}
