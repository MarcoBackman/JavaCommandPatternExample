package assignment4.device;

/*
 * Name             : Sung-Jun (Tony) Baek
 * Assignment number: Assignment4 Command Pattern
 * Description      : Scrolling screen - 100 : Full expansion, 0 : Full retraction
 */

public class Screen {
	private String location;
	private int rollingLevel;

	public Screen(final String location) {
		this.location = location;
	}

	public void fullScrollDown() {
		rollingLevel = 100;
		System.out.println("Screen has scrolled down");
	}

	public void fullScrollUp() {
		rollingLevel = 0;
		System.out.println("Screen has scrolled up");
	}

	public void scrollUp(final int rollingLevel) {
		this.rollingLevel += rollingLevel;
		//roller cannot go over 100
		if (this.rollingLevel > 100) {
			this.rollingLevel = 100;
		}
	}
	
	public void scrollDown(final int rollingLevel) {
		this.rollingLevel -= rollingLevel;
		//roller cannot go below 0
		if (this.rollingLevel < 0) {
			this.rollingLevel = 0;
		}
	}
	
	public int getRollLevel() {
		return rollingLevel;
	}
	
	public String getLocation() {
		return this.location;
	}
}
