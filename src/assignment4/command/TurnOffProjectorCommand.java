package assignment4.command;

import assignment4.device.Projector;

public class TurnOffProjectorCommand implements Command {
	final private Projector projector;
	 
	public TurnOffProjectorCommand(final Projector projector) {
		this.projector = projector;
	}
 
	public void execute() {
		projector.on();
	}
 
	public void undo() {
		projector.off();
	}
}
