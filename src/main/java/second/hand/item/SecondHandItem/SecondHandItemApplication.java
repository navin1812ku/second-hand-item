package second.hand.item.SecondHandItem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
@EnableJpaRepositories
public class SecondHandItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondHandItemApplication.class, args);
	}

}
