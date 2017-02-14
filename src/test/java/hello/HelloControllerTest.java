package hello;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloControllerTest {

    @Test
    public void controllerSaysHello() {
        HelloController controller = new HelloController(new SomeTestConfig("hello", "world"));
        assertEquals("hello - world", controller.index());
    }

}
