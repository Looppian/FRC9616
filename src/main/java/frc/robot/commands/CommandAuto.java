package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.CANDrivetrain;
import frc.robot.subsystems.CANLauncher;

public class CommandAuto extends SequentialCommandGroup {

    public CommandAuto(CANDrivetrain drivetrain, CANLauncher launcher){
     super(
        new InstantCommand(() -> launcher.setLaunchWheel(1)),
        new WaitCommand(1),
        new InstantCommand(() -> launcher.setFeedWheel(1)),
        new WaitCommand(2),
        new InstantCommand(() -> launcher.setLaunchWheel(0), launcher),
        new InstantCommand(() -> launcher.setFeedWheel(0), launcher),
        new InstantCommand(() -> drivetrain.arcadeDrive(1, 0), drivetrain),
        new WaitCommand(2),
        new InstantCommand(() -> drivetrain.arcadeDrive(0, 0), drivetrain)
     );
    }
    
}
