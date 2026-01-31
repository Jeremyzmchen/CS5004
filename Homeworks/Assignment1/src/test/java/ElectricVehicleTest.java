import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests for the ElectricVehicle class.
 */
public class ElectricVehicleTest {
  private static final double EP = 0.001;

  /**
   * Test name if it is empty or null.
   */
  @Test
  public void testName() {
    ElectricVehicle ev1 = new ElectricVehicle("", 100.0, 1.0, 3.0);
    assertEquals("unknown EV", ev1.getName());

    ElectricVehicle ev2 = new ElectricVehicle(null, 100.0, 1.0, 3.0);
    assertEquals("unknown EV", ev2.getName());
  }

  /**
   * Test constructor clamping for battery size.
   */
  @Test
  public void testBatterySizeClamping() {
    ElectricVehicle tesla = new ElectricVehicle("Tesla", 180.0, 1.0, 3.0);
    assertEquals(150.0, tesla.getBatterySize(), EP);

    ElectricVehicle rivian = new ElectricVehicle("Rivian", 5.0, 1.0, 3.0);
    assertEquals(10.0, rivian.getBatterySize(), EP);
  }

  /**
   * Test constructor clamping for efficiency.
   */
  @Test
  public void testEfficiencyClamping() {
    // Test getEfficiency method when defaultEfficiency > 4.5
    ElectricVehicle tesla = new ElectricVehicle("Tesla", 50.0, 1.0, 10.0);
    assertEquals(4.5, tesla.getEfficiency(), EP);

    // Test getEfficiency method when defaultEfficiency < 0.5
    ElectricVehicle rivian = new ElectricVehicle("Rivian", 50.0, 1.0, 0.1);
    assertEquals(0.5, rivian.getEfficiency(), EP);
  }


  /**
   * Test state of charge clamping.
   */
  @Test
  public void testStateOfChargeClamping() {
    // Test getStateOfCharge method when stateOfCharge > 1.0
    ElectricVehicle tesla = new ElectricVehicle("Tesla", 50.0, 2.0, 3.0);
    assertEquals(1.0, tesla.getStateOfCharge(), EP);

    // Test getStateOfCharge method when stateOfCharge < 0.15>
    ElectricVehicle rivian = new ElectricVehicle("Rivian", 50.0, 0.1, 3.0);
    assertEquals(0.15, rivian.getStateOfCharge(), EP);
  }

  /**
   * Test range.
   */
  @Test
  public void testRange() {
    ElectricVehicle tesla = new ElectricVehicle("Tesla", 100.0, 0.5, 3.0);
    assertEquals(150.0, tesla.range(), EP);
  }

  /**
   * Test efficiency at normal temperature.
   */
  @Test
  public void testUpateEfficiencyTemp() {
    // Test updateEfficiencyTemp method when 65.0 <= currentTemp <= 77
    ElectricVehicle tesla = new ElectricVehicle("Tesla", 50.0, 0.5, 3.0);
    tesla.updateEfficiency(70.0);
    assertEquals(3.0, tesla.getEfficiency(), EP);

    // Test updateEfficiencyTemp method when 77.0 <= currentTemp
    ElectricVehicle rivian = new ElectricVehicle("Rivian", 50.0, 0.5, 1.0);
    rivian.updateEfficiency(100.0);
    assertEquals(0.85, rivian.getEfficiency(), EP);

    // Test updateEfficiencyTemp method when currentTemp <= 65.0
    ElectricVehicle ford = new ElectricVehicle("Ford", 50.0, 0.5, 1.0);
    ford.updateEfficiency(50.0);
    assertEquals(0.15, ford.getEfficiency(), EP);
  }

  /**
   * Test toString format.
   */
  @Test
  public void testToString() {
    ElectricVehicle ford = new ElectricVehicle("Ford MachE", 100.0, 0.5, 1.0);
    String result = ford.toString();
    assertTrue(result.contains("Ford MachE"));
    assertTrue(result.contains("50.0%"));
    assertTrue(result.contains("50.0"));
  }
}