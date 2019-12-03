package net.general.aggregation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("net.general.aggregation.mapper")
@EnableSwagger2
public class AggregationApplication {
	@Bean
	public Queue helloQueue() {
		return new Queue("helloQueue");
	}

	@Bean
	public Queue helloQueue2() {
		return new Queue("helloQueue2");
	}

	public static void main(String[] args) {
		SpringApplication.run(AggregationApplication.class, args);
	}

}
