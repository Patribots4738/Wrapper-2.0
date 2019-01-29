package wrapper;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.Mathd;

public class SmashBoard {

    public static void sendBoolean(String destination, boolean bool) {

        SmartDashboard.putBoolean(destination, bool);

    }

    public static boolean receiveBoolean(String origin){

            return SmartDashboard.getBoolean(origin, false);

    }
   

    public static void sendDouble(String destination, double duble) {// no, that is not misspelled

        SmartDashboard.putNumber(destination, duble);

    }

    public static double receiveDouble(String origin){

        return SmartDashboard.getNumber(origin, 0);

    }    

    public static void sendString(String destination, String string) {

        SmartDashboard.putString(destination, string);

    }

    public static String receiveString(String origin){

        return SmartDashboard.getString(origin, "");

    }    

    public static String getDriveMode(){

        return SmartDashboard.getString("drivemode", "curvature");

    }

    public static String receiveKeys1(){
 
        return SmartDashboard.getString("keyBinds1", "throttle:1,turning:4,tankLeft:1,tankRight:5,forward:0,wheels:6,ramp:7,elevatorUp:4,elevatorDown:5,arm:2,slapIntake:1,intakeSuck:8,intakeBlow:9,eject:3");

    }

    public static String receiveKeys2(){

        return SmartDashboard.getString("keyBinds2", "elevatorUp:4,elevatorDown:5,arm:2,slapIntake:1,intakeSuck:8,intakeBlow:9,eject:3");

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

            double angleToMaintain = (Math.PI * -turning * Math.abs(turning * 0.75)) / Math.PI;

            double speedDifference = Math.atan(angleToMaintain);

            speedDifference *=  (Math.abs(speedDifference) * throttle * Math.signum(throttle));//this line preforms some modifications 

            leftMotorInput = throttle - speedDifference;
            rightMotorInput = throttle + speedDifference;
        }

        double[] leftIsFirst = { leftMotorInput, rightMotorInput };

        return leftIsFirst;

    }

}
