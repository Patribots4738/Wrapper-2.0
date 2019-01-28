package wrapper;

import java.util.*;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ControlType;

import interfaces.MotorGroup;

public class PIDSparkMaxGroup implements MotorGroup {

  public  ArrayList<CANPIDController> motors = new ArrayList<>();

    public PIDSparkMaxGroup(int... deviceIDs) {

        for (int deviceID : deviceIDs) {

            CANSparkMax motor = new CANSparkMax(deviceID, CANSparkMaxLowLevel.MotorType.kBrushless);
            CANPIDController CANSpark = new CANPIDController(motor);
            CANSpark.setP(1.5);
            CANSpark.setI(0.05);
            CANSpark.setD(0);
            CANSpark.setIZone(0);
            CANSpark.setFF(0);
            motors.add(CANSpark);

        }

    }

    public void control(double motorInput) {

        for (int i = 0; i < motors.size(); i++) {
            motors.get(i).setOutputRange(motorInput - (motorInput * 0.02), motorInput + (motorInput * 0.02));
            motors.get(i).setReference(motorInput, ControlType.kVelocity);

        }

    }

}