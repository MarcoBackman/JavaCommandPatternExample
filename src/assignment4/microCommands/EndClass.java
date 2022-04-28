package assignment4.microCommands;

import assignment4.command.Command;
import assignment4.command.FullScrollUpScreenCommand;
import assignment4.command.LightOnCommand;
import assignment4.command.TurnOffProjectorCommand;

/*
 * Name             : Sung-Jun (Tony) Baek
 * Assignment number: Assignment4 Command Pattern
 */

public class EndClass implements Command {
	final private LightOnCommand lightOn;
	final private FullScrollUpScreenCommand screenUp;
	final private TurnOffProjectorCommand projectorOff;
	 
	public EndClass(final LightOnCommand lightOn,
			final FullScrollUpScreenCommand screenUp,
			final TurnOffProjectorCommand projectorOff) {
		this.lightOn = lightOn;
		this.screenUp = screenUp;
		this.projectorOff = projectorOff;
	}
	
	public void execute() {
		//Turns full light
		lightOn.execute();
		//Drops the screen <- Shouldn't we turn off the projector first?
		screenUp.execute();
		//Turn on the projector
		projectorOff.execute();	
	}

	public void undo() {
		lightOn.undo();
		screenUp.undo();
		projectorOff.undo();	
	}
}
