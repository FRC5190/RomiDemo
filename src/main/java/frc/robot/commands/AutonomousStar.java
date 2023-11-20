// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousStar extends SequentialCommandGroup {
  /** Creates a new AutonomousStar. */
  public AutonomousStar(Drivetrain drivetrain) {
    int sideLength = 7; // test later
    int angle = 36;

    addCommands(
      new DriveDistance(0.5, sideLength, drivetrain),
      new TurnDegrees(0.5, angle, drivetrain),
      new DriveDistance(-0.5, sideLength, drivetrain),
      new TurnDegrees(0.5, angle, drivetrain),
      new DriveDistance(0.5, sideLength, drivetrain),
      new TurnDegrees(0.5, angle, drivetrain),
      new DriveDistance(-0.5, sideLength, drivetrain),
      new TurnDegrees(0.5, angle, drivetrain),
      new DriveDistance(0.5, sideLength, drivetrain),
      new TurnDegrees(0.5, angle, drivetrain)
    );
  }
}
