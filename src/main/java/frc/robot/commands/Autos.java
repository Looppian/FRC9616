// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.CANDrivetrain;
import frc.robot.subsystems.CANLauncher;
// import frc.robot.commands.PrepareLaunch;

public final class Autos 
{

  public static Command simpleAuto(CANDrivetrain drivetrain, CANLauncher launcher) 
  {
    
    return new RunCommand
    /*
     * Order of Auto tasks: 
     *  Pre:
     *    Wait 1 second + Launch delay then Will create launch note object. (Then wait time out)
     *  Post:
     *    Moves forward at 0.8 speed for 1 second, then stops and fires the the note launcher (Deprecated Rn) then, 
     *    Moves -0.5 indefently (Or 1 second) until the auto ends.
     */
      (() -> new PrepareLaunch(launcher))
        //Pre 
        .withTimeout(1)
        .withTimeout(LauncherConstants.kLauncherDelay)
        .andThen(new LaunchNote(launcher))
        .withTimeout(0.5)
        
        //The actual Movement of the robot
        .andThen(() -> drivetrain.arcadeDrive(0.8, 0), drivetrain)
        .withTimeout(1)
        .andThen(() -> drivetrain.arcadeDrive(0, 0), drivetrain)
        /*.andThen(new RunCommand(() -> launcher.setLaunchWheel(LauncherConstants.kLauncherSpeed)))
        .andThen(new RunCommand(() -> launcher.setFeedWheel(LauncherConstants.kLaunchFeederSpeed)))
        .withTimeout(2) */
        .andThen(() -> launcher.setFeedWheel(0))
        .andThen(() -> launcher.setLaunchWheel(0))
        .withTimeout(1);
        .andThen(() -> drivetrain.arcadeDrive(-0.5, 0), drivetrain)

        
  }

  private Autos() 
  {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
