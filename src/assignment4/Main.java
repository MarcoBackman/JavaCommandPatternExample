package assignment4;

import assignment4.command.DimmerLightOnCommand;
import assignment4.command.FullScrollDownScreenCommand;
import assignment4.command.FullScrollUpScreenCommand;
import assignment4.command.LightOnCommand;
import assignment4.command.TurnOffProjectorCommand;
import assignment4.command.TurnOnProjectorCommand;
import assignment4.controller.RemoteControlWithUndo;
import assignment4.device.Light;
import assignment4.device.Projector;
import assignment4.device.Screen;
import assignment4.microCommands.EndClass;
import assignment4.microCommands.StartClass;

/*
 * Name             : Sung-Jun (Tony) Baek
 * Assignment number: Assignment4 Command Pattern
 */

public class Main {
	
	public static void main(final String[] args) {
		//Create remote controller instance
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		
		/*
		 * For basic 6 commands in total with 3 device declaration
		 */
		
		//Declare and initialize classroom's devices first
		Light classRoomLight = new Light("Class Room"); //Class has single light system
		Screen classRoomScreen = new Screen("Class Room");
		Projector classRoomProjector = new Projector("Class Room");
		
		//Dim the lights  - one slot toggles the Dim the lights command and the Turn on full lighting command
		DimmerLightOnCommand classRoomDimOn
			= new DimmerLightOnCommand(classRoomLight);
		
		//Drop the screen
		FullScrollDownScreenCommand classRoomScreenFullScrollDown
			= new FullScrollDownScreenCommand(classRoomScreen);
		
		//Turn on the projector
		TurnOnProjectorCommand classRoomProjectorOn
		= new TurnOnProjectorCommand(classRoomProjector);
		
		//Turn on full lighting
		LightOnCommand classLightOn
		= new LightOnCommand(classRoomLight);
		
		//Raise the screen
		FullScrollUpScreenCommand classRoomScreenFullScrollUp
		= new FullScrollUpScreenCommand(classRoomScreen);
		
		//Turn off the projector
		TurnOffProjectorCommand classRoomProjectorOff
		= new TurnOffProjectorCommand(classRoomProjector);
		
		//Set commands for the remote controller
		remoteControl.setCommand(0, classRoomDimOn, classLightOn); //Class never sleeps yay!
		remoteControl.setCommand(1, classRoomScreenFullScrollDown, classRoomScreenFullScrollUp);
		remoteControl.setCommand(2, classRoomProjectorOn, classRoomProjectorOff);
		
		/*
		 * Two micro controller commands for combined acctions
		 */
		
		//create 2 macro commands
		StartClass startClass = new StartClass(classRoomDimOn, classRoomScreenFullScrollDown, classRoomProjectorOn);
		EndClass endClass = new EndClass(classLightOn, classRoomScreenFullScrollUp, classRoomProjectorOff);
		
		//Set a command for the remote controller
		remoteControl.setCommand(3, startClass, endClass);
		
		//Test field!
		remoteControl.onButtonWasPushed(3);
		System.out.println(""); //line braker
		remoteControl.offButtonWasPushed(3);
		System.out.println(""); //line braker
		remoteControl.onButtonWasPushed(1);
		System.out.println(""); //line braker
		remoteControl.onButtonWasPushed(2);
		System.out.println(""); //line braker
		remoteControl.onButtonWasPushed(3);
	}
}
