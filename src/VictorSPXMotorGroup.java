package wrapper;

import java.util.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import interfaces.MotorGroup;

public class VictorSPXMotorGroup implements MotorGroup{

    ArrayList<VictorSPX> motors = new ArrayList<>();

    public VictorSPXMotorGroup(int... deviceIDs) {
        for (int deviceID : deviceIDs) {

            VictorSPX motor = new VictorSPX(deviceID);
            motors.add(motor);
            
        }
    }

    public void control(double motorInput) {
        for (int i = 0; i < motors.size(); i++) {

            motors.get(i).set(ControlMode.PercentOutput, motorInput);

        }

    }

}