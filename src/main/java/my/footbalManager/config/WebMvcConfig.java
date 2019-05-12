package my.footbalManager.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"my.footbalManager"})
@EnableJpaRepositories("my.footbalManager.dao")
@EnableTransactionManagement
public class WebMvcConfig {

}
