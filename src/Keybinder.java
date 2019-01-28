package wrapper;

import wrapper.XboxController;
import utils.KeyBinderDictionary;

public class Keybinder {// this is a dedicated class for deep space 2019

	XboxController xbox;

	public KeyBinderDictionary dictionary;

	

	public String[] keysAndValues;

	public Keybinder(XboxController xbox) {

		this.xbox = xbox;

	}

	public void bind(String keybindString) {
		// key:value,key:value...
		// strings containing a key and a value seperated by a colon
		String[] keyBindPairs = keybindString.split(",");
		dictionary = new KeyBinderDictionary(keyBindPairs.length);
		for (int i = 0; i < keyBindPairs.length; i++) {

			// keys and their values at alternating indexes, with keys first at 0
			keysAndValues = keyBindPairs[i].split(":");
			
			dictionary.add(keysAndValues[0], Integer.parseInt(keysAndValues[1]));

		}

	}

	public double getThrottle() {
		
		return xbox.getAxis(dictionary.get("throttle"));
		
	}

	public double getTurning() {
		
		return xbox.getAxis(dictionary.get("turning"));

	}

	public double getTankLeftStick(){

		return xbox.getAxis(dictionary.get("tankLeft"));

	} 

	public double getTankRightStick(){

		return xbox.getAxis(dictionary.get("tankRight"));

	}

	public boolean getArmToggle() {

		return xbox.getToggle(dictionary.get("arm"));

	}

	public boolean getHatchLaunch(){

		return xbox.getButton(dictionary.get("eject"));

	}

	public boolean getSlapIntake(){

		return xbox.getToggle(dictionary.get("slapIntake"));

	}

	public boolean getDropRamp(){

		return xbox.getToggle(dictionary.get("ramp"));

	}

	public boolean getDropWheels(){

		return xbox.getToggle(dictionary.get("wheels"));

	}

	public boolean getIntakeSuck() {

		return xbox.getButton(dictionary.get("intakeSuck"));

	}

	public boolean getIntakeBlow(){

		return xbox.getButton(dictionary.get("intakeBlow"));

	}

	public boolean getToggleForward(){

		return xbox.getToggle(dictionary.get("forward"));

	}

	public boolean getElevatorUp(){

		return xbox.getButton(dictionary.get("elevatorUp"));

	}

	public boolean getElevatorDown(){

		return xbox.getButton(dictionary.get("elevatorDown"));

	}

}