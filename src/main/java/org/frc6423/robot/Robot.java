package org.frc6423.robot;

import static edu.wpi.first.units.Units.Seconds;

import org.frc6423.lib.CommandRobot;
import org.frc6423.robot.Constants.Flags;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class Robot extends CommandRobot {

  public Robot() {
    super(Flags.LOOPTIME.in(Seconds));

    // Prevent driverstation from clogging output
    DriverStation.silenceJoystickConnectionWarning(true);

    configureBindings();
    configureGameBehavior();
  }

  private void configureBindings() {}

  private void configureGameBehavior() {}

  @Override
  protected Command getAutonCommand() {
    return Commands.none();
  }
}
