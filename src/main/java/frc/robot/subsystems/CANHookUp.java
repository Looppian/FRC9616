
package frc.robot.subsystems;

import static frc.robot.Constants.LauncherConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANHookUp extends SubsystemBase{
    CANSparkMax m_leftHook;
    CANSparkMax m_rightHook;

    public CANHookUp() {
        m_leftHook = new CANSparkMax(kLeftHookID, MotorType.kBrushless);
        m_rightHook = new CANSparkMax(kRightHookID, MotorType.kBrushless);

        m_leftHook.setSmartCurrentLimit(HookCurrentLimit);
        m_rightHook.setSmartCurrentLimit(HookCurrentLimit);

    }
public Command getHookUpCommand() {

    return this.startEnd(
        () -> {
            setHookUp(kHookSpeed)
           
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
