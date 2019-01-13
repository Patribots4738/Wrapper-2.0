package wrapper;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmashBoard{

    public void sendBoolean(String destination, boolean bool){

        SmartDashboard.putBoolean(destination, bool);

    }

    public void sendDouble(String destination, double duble){//no, that is not misspelled

        SmartDashboard.putNumber(destination, duble);

    }

    public void sendString(String destination, String string){

        SmartDashboard.putString(destination, string);

    }





    }






    
