package wrapper;

/**
 * Senpai says hi! -Stephen
 */
public class DoubleSoleniod extends edu.wpi.first.wpilibj.DoubleSolenoid{
	
	TogglableButton toggledState = new TogglableButton();
	TogglableButton holdButton = new TogglableButton();
	
	/**
	 * @param moduleNumber
	 * @param forwardChannel
	 * @param reverseChannel
	 */
	public DoubleSoleniod(int moduleNumber, int forwardChannel, int reverseChannel) {
		super(moduleNumber, forwardChannel, reverseChannel);
	}
	
	/**
	 * @param forwardChannel
	 * @param reverseChannel
	 */
	public DoubleSoleniod(int forwardChannel, int reverseChannel) {
		super(forwardChannel, reverseChannel);
	}

	public void onHold(boolean state){
		 if(holdButton.isDown(state)){
			 this.set(Value.kForward);
		 }
		 else if(holdButton.isUp(state)){
			 this.set(Value.kReverse);
		 }
	}
	
	public void toggleDirection(boolean state){
		if(toggledState.isDown(state)){
			if(toggledState.toggleOnPress(state)){
				this.set(Value.kForward);
			} 
			else{
				this.set(Value.kReverse);
			}
		}
	}
	
}