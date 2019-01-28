package hardware;

import wrapper.Talon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Elevator{

    Talon talon;
    VictorSPX slave;
    int masterID;
    int rotationsPerBallLevel = 10;
    int rotationsPerHatchLevel = 12;

    public Elevator(int talonCANID, int victorCANID){

        talon = new Talon(talonCANID);
        slave = new VictorSPX(victorCANID);
        
        talon.setMaxOutput(1,-1);
        talon.setP(1);
        talon.setI(0);
        talon.setD(0);
        talon.setInverted(true);

    }

    public void setBallHeight(int level){

        talon.setPosition(rotationsPerBallLevel * level);
        slave.set(ControlMode.Follower, masterID);

    }

    public void setHatchHeight(int level){

        talon.setPosition(rotationsPerHatchLevel * level);
        slave.set(ControlMode.Follower, masterID);

    }


}