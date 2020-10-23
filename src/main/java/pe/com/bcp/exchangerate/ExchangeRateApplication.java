package pe.com.bcp.exchangerate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.com.bcp.exchangerate.config.EnableExchangeRate;

@EnableExchangeRate
@SpringBootApplication
public class ExchangeRateApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExchangeRateApplication.class, args);
	}
}
