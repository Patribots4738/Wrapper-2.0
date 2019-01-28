package hardware;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ControlType;
import wrapper.DoubleSoleniod;

public class Arm {

    DoubleSoleniod extender;

    DoubleSoleniod opener;
    
    CANSparkMax spark;
    CANPIDController CANSpark;
    

    public Arm(DoubleSoleniod extender, DoubleSoleniod opener , int SparkMaxCANID) {

        this.extender = extender;

        this.opener = opener;

        spark = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);

        CANSpark = new CANPIDController(spark);

        // you'll need to change these when testing the arm, only the P, I, D and output
        // range, please don't change the IZone and FF
        CANSpark.setP(1);
        CANSpark.setI(0.0005);
        CANSpark.setD(0.05);
        CANSpark.setOutputRange(-1, 1);
        CANSpark.setIZone(0);
        CANSpark.setFF(0);

        CANSpark.setReference(0.5, ControlType.kPosition);

    }

    public void toggleExtend(boolean toggleButton){

        extender.toggleWithState(toggleButton);

    }

    public void toggleHand(boolean toggleButton){

        opener.toggleWithState(toggleButton);

    }

    public void flipArm(boolean toggleButton) {

        if (!toggleButton) {

            CANSpark.setReference(0, ControlType.kPosition);

        }

        else{

            CANSpark.setReference(0.25, ControlType.kPosition);

        }

    }

}