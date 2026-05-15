import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    @Test
    public void testCircleArea() {

        Circle c = new Circle("Red", 5);

        assertEquals(Math.PI * 25,
                c.calculateArea(),
                0.001);
    }
}