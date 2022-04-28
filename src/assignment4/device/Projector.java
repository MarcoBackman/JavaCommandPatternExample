package assignment4.device;

public class Projector {
	private String location;
	private boolean switchStatus;

	public Projector(final String location) {
		this.location = location;
	}

	public void on() {
		switchStatus = true;
		System.out.println("Projector is on");
	}

	public void off() {
		switchStatus = false;
		System.out.println("Projector is off");
	}

	public boolean getSwitchStatus() {
		return switchStatus;
	}
	
	public String getLocation() {
		return location;
	}
}
