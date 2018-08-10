package pl.recrutimentTask.observers;

import pl.recruitmentTask.devices.InputDevice;

public class ScannerObserver implements InputObserver{

	InformedObject informed;
	InputDevice observed; 
	
	
	public ScannerObserver(InformedObject informed,InputDevice observed) {
		this.informed = informed;
		this.observed = observed;
		observed.acceptObserver(this);
	}
	
	@Override
	public void notifyAboutNewInput() {
		informed.getInformation(observed);
	}

}
