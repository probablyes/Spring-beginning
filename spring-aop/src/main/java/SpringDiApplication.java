import aspect.LoggerAspect;
import model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import service.BookRepository;
import service.GenericRepository;

import javax.swing.*;

/**
 * Created by HP on 22.04.2017.
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringDiApplication {
    public static void main(String args[]){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDiApplication.class);

        GenericRepository<String, Book> repo = context.getBean(BookRepository.class);
        repo.add(new Book("1234567890123", "Pierwsza", "Pierwszy autor"));
        repo.add(new Book("2345678901234", "Druga", "Drugi autor"));
        repo.add(new Book("3456789012345", "Trzecia", "Trzeci autor"));
        Book book = repo.get("1234567890123");
        System.out.println(book);
    }
}
