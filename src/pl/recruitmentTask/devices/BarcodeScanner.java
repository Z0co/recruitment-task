package pl.recruitmentTask.devices;

import pl.recrutimentTask.observers.InputObserver;

public class BarcodeScanner implements InputDevice{
	
	private InputObserver observer;
	private char[] input;
	@Override
	public char[] getInput() {
		return input;
		
	}
	
	@Override
	public void acceptObserver(InputObserver observer) {
		this.observer = observer;
	}

	@Override
	public void setCurrentInput() {
		input = new char[]{'a'};
		observer.notifyAboutNewInput();
	}
	
	@Override
	public void setCurrentInput(char[] input) {
		this.input = input;
		observer.notifyAboutNewInput();
	}

}
