package wrapper;

import java.util.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import interfaces.MotorGroup;

public class SparkMaxMotorGroup implements MotorGroup{

    ArrayList<CANSparkMax> motors = new ArrayList<>();

    public SparkMaxMotorGroup(int... deviceIDs) {
        for (int deviceID : deviceIDs) {

            CANSparkMax motor = new CANSparkMax(deviceID,CANSparkMaxLowLevel.MotorType.kBrushless);
            motors.add(motor);
            
        }
    }

    public void control(double motorInput) {
        for (int i = 0; i < motors.size(); i++) {

            motors.get(i).set(motorInput);

        }

    }

}