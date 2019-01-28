package wrapper;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;

public class XboxController extends Gamepad {

	public XboxController(int port) {
		super(port);
	}

	public Vector getLeftStick() {
		return new Vector(this.getAxis(0), -this.getAxis(1));
	}

	public Vector getRightStick() {
		return new Vector(this.getAxis(4), this.getAxis(5));
	}

	public double getRightTrigger() {
		return this.getAxis(2);
	}

	public double getLeftTrigger() {
		return this.getAxis(3);
	}

	public boolean getButton(Buttons button) {
		return this.getButton(button.ordinal());
	}

	public boolean getToggle(Buttons button) {
		return this.getToggle(button.ordinal());
	}

	public boolean getButtonDown(Buttons button) {
		return this.getButtonDown(button.ordinal());
	}

	public boolean getButtonUp(Buttons button) {
		return this.getButtonUp(button.ordinal());
	}

	public boolean getDPad(Directions direction) {
		return this.getPOV(direction);
	}

	public void setRumble(RumbleType type, double rumble) {
		this.setRumble(type, rumble);
	}

	public enum Buttons {
		A, B, X, Y, L, R, Select, Start, L3, R3
	}
}