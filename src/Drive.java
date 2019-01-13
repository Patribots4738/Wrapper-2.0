package wrapper;

import utils.Mathd;
import interfaces.MotorGroup;

public class Drive {

    MotorGroup LeftMotors;
    MotorGroup RightMotors;

    public Drive(MotorGroup LeftMotors, MotorGroup RightMotors) {

        this.LeftMotors = LeftMotors;
        this.RightMotors = RightMotors;

    }

    public void linearArcade(double throttle, double turning) {

        double leftMotorInput = (throttle + turning);
        double rightMotorInput = -(throttle - turning);

        LeftMotors.control(leftMotorInput);
        RightMotors.control(rightMotorInput);

    }

    public void parabolicArcade(double throttle, double turning, double speedMultiplier) {

        double leftMotorInput = (throttle + turning) * Math.abs((throttle + turning)) * speedMultiplier;
        double rightMotorInput = -((throttle - turning) * Math.abs((throttle - turning)) * speedMultiplier);

        LeftMotors.control(leftMotorInput);
        RightMotors.control(rightMotorInput);

    }

    public void linearTank(double leftStick, double rightStick) {

        double leftMotorInput = leftStick;
        double rightMotorInput = -rightStick;

        LeftMotors.control(leftMotorInput);
        RightMotors.control(rightMotorInput);

    }

    public void parabolicTank(double leftStick, double rightStick, double speedMultiplier) {

        double leftMotorInput = leftStick * Math.abs(leftStick) * speedMultiplier;
        double rightMotorInput = -(rightStick * Math.abs(rightStick) * speedMultiplier);

        LeftMotors.control(leftMotorInput);
        RightMotors.control(rightMotorInput);

    }

    public void kindaCurvature(double throttle, double turning) {

        boolean turnInPlace = false;

        if (Mathd.isBetween(throttle, 0.05, -0.05)) {

            turnInPlace = true;

        } else {

            turnInPlace = false;

        }

        if (turnInPlace) {

            parabolicArcade(throttle, turning, 1);

        } else {

            double angleToMaintain = (Math.PI * -turning) / 3;

            double speedDifference = Math.atan(angleToMaintain) * throttle;

            double leftMotorInput = -throttle + speedDifference;
            double rightMotorInput = -throttle - speedDifference;

            LeftMotors.control(leftMotorInput);
            RightMotors.control(rightMotorInput);

        }

    }

}