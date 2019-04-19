package rest.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("rest")
@EnableWebMvc
@Configuration
public class WebAppConfig {
}
