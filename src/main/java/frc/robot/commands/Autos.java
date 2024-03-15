// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.CANDrivetrain;
import frc.robot.subsystems.CANLauncher;
import frc.robot.commands.PrepareLaunch;
import frc.robot.commands.LaunchNote;

public final class Autos 
{

  public static Command simpleAuto(CANDrivetrain drivetrain, CANLauncher launcher) 
  {
    
    return new RunCommand
      (() -> new PrepareLaunch(launcher))
        .withTimeout(LauncherConstants.kLauncherDelay)
        .andThen(new LaunchNote(launcher))
        .withTimeout(1)

        .andThen(new RunCommand(() -> drivetrain.arcadeDrive(-0.5, 0), drivetrain))
        .withTimeout(2)
        
        .andThen(() -> launcher.setFeedWheel(0))
        .andThen(() -> launcher.setLaunchWheel(0))
        .andThen(new RunCommand(() -> drivetrain.arcadeDrive(0, 0), drivetrain)); 
  }

  private Autos() 
  {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
