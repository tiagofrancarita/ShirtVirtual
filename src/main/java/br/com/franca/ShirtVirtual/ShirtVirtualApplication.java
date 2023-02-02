package br.com.franca.ShirtVirtual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShirtVirtualApplication {

	private static Logger logger = LoggerFactory.getLogger(ShirtVirtualApplication.class);

	public static void main(String[] args) {

		logger.info("Iniciando a loja virtual, aguarde.");
		SpringApplication.run(ShirtVirtualApplication.class, args);
		logger.info("Loja virtual iniciada com sucesso.");
	}

}
