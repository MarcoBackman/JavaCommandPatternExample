package assignment4.command;

import assignment4.device.Projector;

public class TurnOnProjectorCommand implements Command {
	final private Projector projector;
 
	public TurnOnProjectorCommand(final Projector projector) {
		this.projector = projector;
	}
 
	public void execute() {
		projector.on();
	}
 
	public void undo() {
		projector.off();
	}
}
