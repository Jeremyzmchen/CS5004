import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the Shoe class
 */
public class ShoeTest {

  private Shoe soccerShoe;
  private Shoe fashionShoe;

  /**
   * Set up two shoe objects for test
   */
  @BeforeEach
  void setUp() {
    soccerShoe = new Shoe(Kind.SPORT, Color.GREEN, Brand.ADIDAS, 42.5);
    fashionShoe = new Shoe(Kind.DRESS, Color.WHITE, Brand.DIOR, 35.5);
  }

  /**
   * Test Constructor and getters
   */
  @Test
  void testShoeCstAndGetter() {
    assertEquals(Kind.SPORT, soccerShoe.getKind());
    assertEquals(Brand.ADIDAS, soccerShoe.getBrand());
    assertEquals(Color.WHITE, fashionShoe.getColor());
    assertEquals(35.5, fashionShoe.getSize());
  }

  /**
   * Test description of shoes
   */
  @Test
  void testToString() {
    assertTrue(fashionShoe.toString().contains("DIOR"));
    assertTrue(soccerShoe.toString().contains("nice white"));
  }

  /**
   * Test NIKE + DRESS exception
   */
  @Test
  void testNikeException() {
    // exception one
    assertThrows(IllegalArgumentException.class, () ->
        new Shoe(Kind.DRESS, Color.WHITE, Brand.NIKE, 42.5));

    // non-exception one
    assertDoesNotThrow(() ->
        new Shoe(Kind.DRESS, Color.RED, Brand.DIOR, 36.5));
  }
}
