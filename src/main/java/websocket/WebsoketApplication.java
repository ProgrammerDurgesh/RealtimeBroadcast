package websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("websocket")
public class WebsoketApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebsoketApplication.class, args);
		System.out.println("running ");
	}
}
