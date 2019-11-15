package co.edu.icesi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LifeCycleApplication {

	@Autowired
	private MyBeanY m;
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(LifeCycleApplication.class, args);
		
		LifeCycleApplication lca1 = context.getBean(LifeCycleApplication.class);
		LifeCycleApplication lca2 = new LifeCycleApplication();
		
		lca1.Text();
		lca2.Text();
	}

	private void Text() {
		m.info();
	}
	
}
