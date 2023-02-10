package br.com.franca.ShirtVirtual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableScheduling
@EnableAsync
@EntityScan(basePackages = "br.com.franca.ShirtVirtual.model")
@ComponentScan(basePackages = {"br.*"})
@EnableJpaRepositories(basePackages = {"br.com.franca.ShirtVirtual.repository"})
@EnableTransactionManagement
public class ShirtVirtualApplication {

	private static Logger logger = LoggerFactory.getLogger(ShirtVirtualApplication.class);

	public static void main(String[] args) {

		logger.info("Iniciando a loja virtual, aguarde.");
		SpringApplication.run(ShirtVirtualApplication.class, args);
		logger.info("Loja virtual iniciada com sucesso.");

		//System.out.println(new BCryptPasswordEncoder().encode("123"));

	}

}