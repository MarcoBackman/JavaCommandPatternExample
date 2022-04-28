package assignment4.microCommands;

import assignment4.command.Command;
import assignment4.command.DimmerLightOnCommand;
import assignment4.command.FullScrollDownScreenCommand;
import assignment4.command.TurnOnProjectorCommand;

/*
 * Name             : Sung-Jun (Tony) Baek
 * Assignment number: Assignment4 Command Pattern
 */

public class StartClass implements Command {

	final private DimmerLightOnCommand dimLight;
	final private FullScrollDownScreenCommand screenDown;
	final private TurnOnProjectorCommand projectorOn;
	 
	public StartClass(final DimmerLightOnCommand dimLight,
			final FullScrollDownScreenCommand screenDown,
			final TurnOnProjectorCommand projectorOn) {
		this.dimLight = dimLight;
		this.screenDown = screenDown;
		this.projectorOn = projectorOn;
	}
	
	public void execute() {
		//Dims light
		dimLight.execute();
		//Drops the screen
		screenDown.execute();
		//Turn on the projector
		projectorOn.execute();	
	}

	public void undo() {
		dimLight.undo();
		screenDown.undo();
		projectorOn.undo();	
	}

}
