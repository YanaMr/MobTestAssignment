package tests;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springioc.Animal;
import springioc.Config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContainerTest {
    @Test
    public void givenAnnotationConfig_whenContextCreated_ThenBeansGot() {
        ApplicationContext javaConfigContext = new AnnotationConfigApplicationContext(Config.class);
        Animal animal = javaConfigContext.getBean(Animal.class);

        assertNotNull(animal);
    }
}
