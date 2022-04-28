package assignment4.command;

import assignment4.device.Light;

public class LightOnCommand implements Command {
	final private Light light;
 
	public LightOnCommand(final Light light) {
		this.light = light;
	}
 
	public void execute() {
		light.on();
	}
 
	public void undo() {
		light.off();
	}
}
