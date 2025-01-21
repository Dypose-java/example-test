package check;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steam.set_up.MainJenkinsProperty;
@Tag("console")
public class Main  {
    @Test
    void test(){
        Assertions.assertTrue(3>2);
    }
    @Test
    void test1(){
        Assertions.assertTrue(3>2);
    }
}
