package assignment4.command;

import assignment4.device.Screen;

public class FullScrollUpScreenCommand implements Command {
	final private Screen screen;
	 
	public FullScrollUpScreenCommand(final Screen screen) {
		this.screen = screen;
	}
 
	public void execute() {
		screen.fullScrollUp();
	}
 
	public void undo() {
		screen.fullScrollDown();
	}
}
