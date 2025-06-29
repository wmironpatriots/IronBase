package org.frc6423.lib;

/** Represents the identification info for a CAN device*/
public class CanDeviceId {
  private final String busName;
  private final int canId;

  /**
   * Create a new {@link CanDeviceId}
   * 
   * @param busName name of the bus device is on
   * @param canId actual ID of the device
   */
  public CanDeviceId(String busName, int canId) {
    this.busName = busName;
    this.canId = canId;
  }

  /**
   * @return the name of the bus that the device is on
   */
  public String getBusName() {
    return busName;
  }

  /**
   * @return the CAN ID of the device
   */
  public int getCanId() {
    return canId;
  }
}