import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the Shoe class
 */
public class ShoeTest {

  private Shoe sportShoe;
  private Shoe fashionShoe;

  /**
   * Set up two shoe objects for test
   */
  @BeforeEach
  void setUp() {
    sportShoe = new Shoe(Kind.SPORT, Color.WHITE, Brand.ADIDAS, 42.5);
    fashionShoe = new Shoe(Kind.BOOT, Color.RED, Brand.DIOR, 35.5);
  }

  /**
   * Test Constructor
   */
  @Test
  void testShoeConstructorAndGetters() {
    assertEquals(Kind.SPORT, sportShoe.getKind());
    assertEquals(Color.WHITE, sportShoe.getColor());
    assertEquals(Brand.ADIDAS, sportShoe.getBrand());
    assertEquals(42.5, sportShoe.getSize(), 1e-9);

    assertEquals(Kind.BOOT, fashionShoe.getKind());
    assertEquals(Color.RED, fashionShoe.getColor());
    assertEquals(Brand.DIOR, fashionShoe.getBrand());
    assertEquals(35.5, fashionShoe.getSize(), 1e-9);
  }

  /**
   * Test description of shoes
   */
  @Test
  void testToString() {
    String shoeStr = sportShoe.toString();
    assertTrue(shoeStr.contains("Sport"));
    assertTrue(shoeStr.contains("Neutral"));
    assertTrue(shoeStr.contains("Adidas"));
    assertTrue(shoeStr.contains("42.5"));
  }

  /**
   * Test NIKE + DRESS exception
   */
  @Test
  void testNikeException() {
    assertThrows(IllegalArgumentException.class,
        () -> new Shoe(Kind.DRESS, Color.WHITE, Brand.NIKE, 42.5));

    assertThrows(IllegalArgumentException.class,
        () -> new Shoe(Kind.SPORT, Color.WHITE, Brand.NIKE, -1.0));
  }
}
