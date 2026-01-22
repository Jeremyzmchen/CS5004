import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the Book class
 */
public class BookTest {

  private Book testBook1;
  private Book testBook2;
  private Book testBook3;

  /**
   * Set up three book objects
   */
  @BeforeEach
  void setUp() {
    this.testBook1 = new Book("title1", "author1", 100);
    this.testBook2 = new Book("title2", "author2", 200);
    this.testBook3 = new Book("title3", "author3", 300);
  }

  /**
   * Test the title match the method getTitle
   */
  @Test
  void getTitle() {
    Assertions.assertEquals("title1", this.testBook1.getTitle());
    Assertions.assertEquals("title2", this.testBook2.getTitle());
    Assertions.assertEquals("title3", this.testBook3.getTitle());
  }

  /**
   * Test the author match the method getAuthor
   */
  @Test
  void getAuthor() {
    Assertions.assertEquals("author1", this.testBook1.getAuthor());
    Assertions.assertEquals("author2", this.testBook2.getAuthor());
    Assertions.assertEquals("author3", this.testBook3.getAuthor());
  }

  /**
   * Test the pages match the method getPages
   */
  @Test
  void getPages() {
    Assertions.assertEquals(100, this.testBook1.getPages());
    Assertions.assertEquals(200, this.testBook2.getPages());
    Assertions.assertEquals(300, this.testBook3.getPages());
  }
}