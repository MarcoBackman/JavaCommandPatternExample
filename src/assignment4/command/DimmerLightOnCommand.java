package assignment4.command;

import assignment4.device.Light;

public class DimmerLightOnCommand implements Command {
	final private Light light;
	private int prevLevel; //Previos dimming level
	
	public DimmerLightOnCommand(final Light light) {
		this.light = light;
	}
	
	public void execute() {
		light.dim(30);
	}
	
	public void undo() {
		light.dim(prevLevel);
	}
	
	public void setDimmingLevel(int dimLevel) {
		this.prevLevel = this.light.getLevel();
		light.dim(dimLevel);
	}
}
