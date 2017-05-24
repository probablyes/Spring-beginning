package decorators.conigurator;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("messageFile")
    public String configFileName() {
        return "/message.txt";
    }

    @Bean
    @Qualifier("randomNumber")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public int getRandomNuumber() {
        return new Random().nextInt();
    }

}
