import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Person class
 */
public class PersonTest {

  private Person alex;

  /**
   * Set up a Person instance
   */
  @BeforeEach
  void setUp() {
    this.alex = new Person("Alex White", "alex.white@gmail.com",
        "San Jose, CA, USA");
  }

  /**
   * Test the name is match the method getName
   */
  @Test
  void getName() {
    Assertions.assertEquals("Alex White", this.alex.getName());
  }

  /**
   * Test the email is match the method getEmail
   */
  @Test
  void getEmail() {
    Assertions.fail("Not yet implemented");
  }

  /**
   * Test the address is match the method getAddress
   */
  @Test
  void getAddress() {
    Assertions.fail("Not yet implemented");
  }
}