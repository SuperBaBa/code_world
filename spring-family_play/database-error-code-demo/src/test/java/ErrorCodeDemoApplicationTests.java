import com.jarvis.DataBaseErrorCode;
import com.jarvis.exception.CustomizeDuplicatedKeyException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author:tennyson date:2020/7/7
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DataBaseErrorCode.class)
public class ErrorCodeDemoApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test(expected = CustomizeDuplicatedKeyException.class)
    public void testThrowingCustomException() {
        jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'a')");
        jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'b')");
    }
}
