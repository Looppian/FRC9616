// Update
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
  public static class DeviceIDs
  {
    // Drive Motors
    public static final int kLeftRearID = 1;
    public static final int kLeftFrontID = 2;
    public static final int kRightRearID = 3;
    public static final int kRightFrontID = 4;
    
    // Shooter Motors
    public static final int kFeederID = 5;
    public static final int kLauncherID = 6;

    // Climber/Hook Motors
    public static final int kHookRightID = 7;
    public static final int kHookLeftID = 8;
  }

  public static class ControllerConstants 
  {
    // Port numbers for driver and operator gamepads. These correspond with the numbers on the USB
    // tab of the DriverStation
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;

    public static final double kTriggerThreshold = 0.25;

  }
  
  public static class DrivetrainConstants 
  {
    // Current limit for drivetrain motors
    public static final int kDriveCurrentLimit = 60;

    // Gains and limits for drivebase controll
    public static final double kBrakeMinimum = 0.35;
    public static final double kRotationGain = 0.75;

    // Inversion of drivetrain motors
    public static final boolean bInvertLeft = true;
    public static final boolean bInvertRight = false;

  }

  public static class LauncherConstants 
  {
    // Current limit for launcher and feed wheels
    public static final int kLauncherCurrentLimit = 80;
    public static final int kFeedCurrentLimit = 60;

    // Speeds for wheels when intaking and launching. Intake speeds are negative to run the wheels
    // in reverse
    public static final double kLauncherSpeed = 1;
    public static final double kLaunchFeederSpeed = 1;
    public static final double kIntakeLauncherSpeed = -1;
    public static final double kIntakeFeederSpeed = -0.2;

    public static final double kLauncherDelay = 1;
  }

  public static class HookConstants
  {
    /* Climber/Hook is not fitted to the robot */

    // Current limits for climber motors
    public static final int kClimberCurrentLimit = 60;

    // Motor speeds for climber
    public static final double kClimbSpeed = 0.8;
    public static final double kClimbExtendSpeed = 0.4;
  }
}
