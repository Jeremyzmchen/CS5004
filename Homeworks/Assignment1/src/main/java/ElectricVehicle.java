/**
 * Represent electric vehicles, and calculate their ranges based on a number of characteristics and
 * criteria
 */
public class ElectricVehicle {

  private String name;
  private double batterySize;   // 10.0-150.0 kWh
  private double stateOfCharge;
  private double defaultEfficiency;
  private double currentEfficiency;   // based on weather conditions

  // Constants of clamp
  private static final double MIN_BATTERY_SIZE = 10.0;
  private static final double MAX_BATTERY_SIZE = 150.0;
  private static final double MIN_SOC = 0.15;
  private static final double MAX_SOC = 1.0;
  private static final double MIN_EFFICIENCY = 0.5;
  private static final double MAX_EFFICIENCY = 4.5;

  /**
   * Construct Electric Vehicle method.
   *
   * @param name              cannot be empty or null
   * @param batterySize       10.0 - 150.0
   * @param stateOfCharge     0.15 - 1.0
   * @param defaultEfficiency 0.5 - 4.5
   */
  public ElectricVehicle(
      String name,
      double batterySize,
      double stateOfCharge,
      double defaultEfficiency
  ) {
    if (name == null || name.isEmpty()) {
      this.name = "unknown EV";
    } else {
      this.name = name;
    }

    // Battery size is 10.0 kilowatt-hours (kWh). Maximum battery size is 150.0 kWh.
    // If values outside of these ranges(clamp)
    this.batterySize = clamp(batterySize, MIN_BATTERY_SIZE, MAX_BATTERY_SIZE);

    //
    this.stateOfCharge = clamp(stateOfCharge, MIN_SOC, MAX_SOC);
    ;

    // Maximum default efficiency is 4.5. Minimum default efficiency is 0.5.
    // If values outside of these ranges(clamp)
    this.defaultEfficiency = clamp(defaultEfficiency, MIN_EFFICIENCY, MAX_EFFICIENCY);

    // Current efficiency is initialized to the value of the default efficiency
    this.currentEfficiency = this.defaultEfficiency;
  }

  /**
   * Clamp method for avoiding illegal argument exception.
   *
   * @param value  the original input value
   * @param minVal the minimum value of the range
   * @param maxVal the maximum value of the range
   * @return validation value
   */
  private double clamp(double value, double minVal, double maxVal) {
    if (value < minVal) {
      return minVal;
    } else if (value > maxVal) {
      return maxVal;
    } else {
      return value;
    }
  }

  public double range() {
    return currentEfficiency * stateOfCharge * batterySize;
  }

  /**
   * Updates the EV's current efficiency based on temperature.
   *
   * @param currentTemp the current temperature
   */
  public void updateEfficiency(double currentTemp) {
    if (currentTemp >= 65.0 && currentTemp <= 77.0) {
      currentEfficiency = defaultEfficiency;
    } else if (currentTemp > 77.0) {
      currentEfficiency = 0.85 * defaultEfficiency;
    } else {
      double percent = (65.0 - currentTemp) / 100;
      double factor = Math.min(0.5, percent);
      currentEfficiency = factor * defaultEfficiency;
    }
  }

  /**
   * Get the name of electric vehicle.
   *
   * @return the electric vehicle name
   */
  public String getName() {
    return name;
  }

  /**
   * Get the battery size of electric vehicle.
   *
   * @return the battery size of electric vehicle
   */
  public double getBatterySize() {
    return batterySize;
  }

  /**
   * Get the remain percent of battery.
   *
   * @return the state of charge of electric vehicle
   */
  public double getStateOfCharge() {
    return stateOfCharge;
  }

  /**
   * Sets a new state of charge for the vehicle.
   *
   * @param stateOfCharge the new state of charge
   */
  public void setStateOfCharge(double stateOfCharge) {
    this.stateOfCharge = clamp(batterySize, MIN_SOC, MAX_SOC);
  }

  /**
   * Gets the current efficiency of the vehicle.
   *
   * @return the current efficiency
   */
  public double getEfficiency() {
    return currentEfficiency;
  }

  /**
   * Returns a formatted string representation of the EV.
   *
   * @return formatted string
   */
  @Override
  public String toString() {
    return String.format(
        "%s SOC: %.1f%% Range (miles): %.1f",
        name,
        stateOfCharge * 100.0,
        range()
    );
  }
}