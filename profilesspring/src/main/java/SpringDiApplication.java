import beans.NamesRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by HP on 21.04.2017.
 */

@Configuration
@ComponentScan
public class SpringDiApplication {

    public static void main (String args[]){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDiApplication.class);
        NamesRepository nr = context.getBean(NamesRepository.class);

        List<String> allNames = nr.getAll();
        allNames.forEach(System.out::println);
        context.close();

    }

}
