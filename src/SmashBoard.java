package wrapper;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.Mathd;

public class SmashBoard {

    public static void sendBoolean(String destination, boolean bool) {

        SmartDashboard.putBoolean(destination, bool);

    }

    public static void sendDouble(String destination, double duble) {// no, that is not misspelled

        SmartDashboard.putNumber(destination, duble);

    }

    public static void sendString(String destination, String string) {

        SmartDashboard.putString(destination, string);

    }

    public static void sendDoubleArray(String destination, double[] array ) {

        SmartDashboard.putNumberArray(destination, array);

    }

    public static double[] convertStickToMotorSpeed(double throttle, double turning) {

        boolean turnInPlace = false;

        double leftMotorInput;
        double rightMotorInput;

        if (Mathd.isBetween(throttle, 0.05, -0.05)) {

            turnInPlace = true;

        } else {

            turnInPlace = false;

        }

        if (turnInPlace) {

            leftMotorInput = (throttle + turning) * Math.abs((throttle + turning)) * 1;
            rightMotorInput = -((throttle - turning) * Math.abs((throttle - turning)) * 1);

        } else {

            double angleToMaintain = (Math.PI * -turning) / 3;

            double speedDifference = Math.atan(angleToMaintain) * throttle;

            leftMotorInput = throttle - speedDifference;
            rightMotorInput = throttle + speedDifference;

        }

        double[] leftIsFirst = { leftMotorInput, rightMotorInput };

        return leftIsFirst;

    }

}
