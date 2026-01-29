import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

  @Test
  public void testCompareTo() {
    Shape circle = new Circle(0, 0, 1);
    Shape rectangle = new Rectangle(0, 0, 2, 2);
    Shape triangle = new Triangle(0, 0, 3, 0, 0, 4);

    assertTrue(circle.compareTo(rectangle) < 0);
    assertTrue(triangle.compareTo(rectangle) > 0);
    assertEquals(0, rectangle.compareTo(new Rectangle(0,0,2,2)));
  }

  @Test
  public void testDistanceFromOrigin() {
    Shape triangle = new Triangle(10, 10, 13, 10, 10, 14);
    assertEquals(5.0, triangle.distanceFromOrigin(), 0.001);
  }
}