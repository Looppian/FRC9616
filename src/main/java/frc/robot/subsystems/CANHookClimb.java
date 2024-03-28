package frc.robot.subsystems;
//Hook Constants
import static frc.robot.Constants.HookConstants.kClimbSpeed;
import static frc.robot.Constants.HookConstants.kClimberCurrentLimit;
//Hook ID's
import static frc.robot.Constants.DeviceIDs.kHookLeftID;
import static frc.robot.Constants.DeviceIDs.kHookRightID;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//Assigns SparkMaxes to left and right hooks
public class CANHookClimb extends SubsystemBase{
    CANSparkMax m_leftHook;
    CANSparkMax m_rightHook;
//Assigns Hook ID's
    public CANHookClimb() {
        m_leftHook = new CANSparkMax(kHookLeftID, MotorType.kBrushless);
        m_rightHook = new CANSparkMax(kHookRightID, MotorType.kBrushless);

        m_leftHook.setSmartCurrentLimit(kClimberCurrentLimit);
        m_rightHook.setSmartCurrentLimit(kClimberCurrentLimit);

    }

public Command getHookUpCommand() {

    return this.startEnd(
        () -> {
            setHookUp(kClimbSpeed);
           
        },

        () -> {
            stop();
        });

}

public void setHookUp(double speed) {
    m_leftHook.set(speed);
    m_rightHook.set(speed);
}

public void stop() {
    m_leftHook.set(0);
    m_rightHook.set(0);
}

}