// TODO Put Year Copyright (c) {year} FRC 6423 - Ward Melville Iron Patriots
// https://github.com/FIRSTTeam6423
// 
// Open Source Software; you can modify and/or share it under the terms of
// MIT license file in the root directory of this project

package org.frc6423.robot;

import static edu.wpi.first.units.Units.Seconds;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import monologue.Logged;
import monologue.Monologue;
import monologue.Monologue.MonologueConfig;
import org.frc6423.lib.CommandRobot;
import org.frc6423.lib.Tracer;
import org.frc6423.robot.Constants.Flags;

public class Robot extends CommandRobot implements Logged {

  public Robot() {
    super(Flags.LOOPTIME.in(Seconds));

    // Prevent driverstation from clogging output
    DriverStation.silenceJoystickConnectionWarning(true);

    // Init Monologue
    Monologue.setupMonologue(
        this,
        "/Robot",
        new MonologueConfig()
            .withAllowNonFinalLoggedFields(true)
            .withDatalogPrefix("Telemetry")
            .withLazyLogging(true)
            .withOptimizeBandwidth(DriverStation::isFMSAttached)
            .withThrowOnWarning(false));

    // Log build data to datalog
    final String meta = "/BuildData/";
    Monologue.log(meta + "RuntimeType", getRuntimeType().toString());
    Monologue.log(meta + "ProjectName", BuildConstants.MAVEN_NAME);
    Monologue.log(meta + "Version", BuildConstants.VERSION);
    Monologue.log(meta + "BuildDate", BuildConstants.BUILD_DATE);
    Monologue.log(meta + "GitDirty", String.valueOf(BuildConstants.DIRTY));
    Monologue.log(meta + "GitSHA", BuildConstants.GIT_SHA);
    Monologue.log(meta + "GitDate", BuildConstants.GIT_DATE);
    Monologue.log(meta + "GitBranch", BuildConstants.GIT_BRANCH);

    // Set monologue to update and trace every loop
    addPeriodic(
        () -> Tracer.traceFunc("Monologue", Monologue::updateAll), Flags.LOOPTIME.in(Seconds));

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
