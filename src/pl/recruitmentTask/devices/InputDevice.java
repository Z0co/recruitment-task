package pl.recruitmentTask.devices;

import pl.recrutimentTask.observers.InputObserver;

public interface InputDevice extends Device{
	public char[] getInput();
	public void setCurrentInput();
	public void setCurrentInput(char[] input);
	public void acceptObserver(InputObserver observer);
}
