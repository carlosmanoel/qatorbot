import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fabio on 24/04/17.
 */
public class MainTest {
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        MainTest tester = new MainTest(); // MyClass is tested

        // assert statements
        Assert.assertEquals("10 x 0 must be 0", 0, (10 * 0));
        Assert.assertEquals("0 x 10 must be 0", 0, (0 * 10));
        Assert.assertEquals("0 x 0 must be 0", 0, (0 * 0));
    }
}
