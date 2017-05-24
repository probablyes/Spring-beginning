package decorators.messageProducers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Producer(type = Producer.ProducerType.SIMPLE)
@Primary
public class SimpleMessageProducer implements MessageProducer {

    @Autowired
    @Qualifier("randomNumber")
    private int number;

    @Autowired
    @Qualifier("randomNumber")
    private int secondNumber;

    public SimpleMessageProducer() {
        System.out.println("Simple producer created");
    }

    @Override
    public String getMessage() {

        return "FirstNumber: " + number + ", second number: " + secondNumber;
    }
}