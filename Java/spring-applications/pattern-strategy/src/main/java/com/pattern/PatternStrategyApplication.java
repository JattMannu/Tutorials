package com.pattern;

import com.pattern.strategy.AppleStrategy;
import com.pattern.strategy.OrangeStrategy;
import com.pattern.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Slf4j
public class PatternStrategyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PatternStrategyApplication.class, args);
	}

	@Autowired
	private AppleStrategy appleStrategy;

	@Autowired
	private OrangeStrategy orangeStrategy;

	@Autowired
	@Qualifier("default")
	private Strategy strategy;

	@Override
	public void run(String... args) throws Exception {
		ConsumerContext mark = new ConsumerContext("Mark", appleStrategy);
		log.info(mark.doAction());

		ConsumerContext john = new ConsumerContext("John", orangeStrategy);
		log.info(john.doAction());

		ConsumerContext Ali = new ConsumerContext("Ali", strategy);
		log.info(Ali.doAction());
	}

	@Bean(name = "default")
	protected Strategy getStrategy(){
		return new OrangeStrategy();
	}
}
