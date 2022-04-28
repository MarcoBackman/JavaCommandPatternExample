package assignment4.command;

import assignment4.device.Screen;

public class FullScrollDownScreenCommand implements Command {
	final private Screen screen;
	 
	public FullScrollDownScreenCommand(final Screen screen) {
		this.screen = screen;
	}
 
	public void execute() {
		screen.fullScrollDown();
	}
 
	public void undo() {
		screen.fullScrollUp();
	}
}
