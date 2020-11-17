import org.jarvis.sqltask.DataSourceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author marcus
 * @date 2020/11/13-16:55
 */
@SpringBootTest(classes = {DataSourceApplication.class})
@RunWith(SpringRunner.class)
public class DataSourceApplicationTests {
    @Test(expected = ExceptionInInitializerError.class)
    public void givenInitializingClass_whenUsingForName_thenInitializationError() throws ClassNotFoundException {
        Class.forName("java.lang.Integer");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("java.lang.Integer");
    }

    static class InitializingClass {
        static {
            if (true) { //enable throwing of an exception in a static initialization block
                throw new RuntimeException();
            }
        }
    }
}
