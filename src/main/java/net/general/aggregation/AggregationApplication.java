package net.general.aggregation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("net.general.aggregation.mapper")
@EnableSwagger2
public class AggregationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregationApplication.class, args);
	}

}
