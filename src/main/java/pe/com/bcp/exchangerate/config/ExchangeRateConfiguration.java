package pe.com.bcp.exchangerate.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("pe.com.bcp.exchangerate")
@EnableJpaRepositories("pe.com.bcp.exchangerate")
@EntityScan("pe.com.bcp.exchangerate")
@EnableAutoConfiguration
@EnableTransactionManagement
public class ExchangeRateConfiguration {
}
