import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    @Test
    public void rectangleTest() {

        Rectangle r = new Rectangle("Blue", 4, 5);

        r.setWidth(10);

        assertEquals(5, r.getHeight());
    }

    @Test
    public void squareFailsLSP() {

        Rectangle r = new Square("Red", 5);

        r.setWidth(10);

        assertEquals(5, r.getHeight());
    }
}