package aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by HP on 22.04.2017.
 */
@Aspect
@Component
public class LoggerAspect {

    @After("execution(* service.BookRepository.*(...))")
    public void logInfoBefore(){
        System.out.println("Log before.");
    }

    @Before("execution(* service.BookRepository.*(...))")
    public void logIAfterBefore(){
        System.out.println("Log after.");
    }

    @AfterThrowing("execution(* service.BookRepository.*(..))")
    public void logError() {
        System.out.println("Method finished with error ");
    }

    @AfterReturning("execution(* service.BookRepository.*(..))")
    public void logSuccess() {
        System.out.println("Method successfully returned");
    }

}
