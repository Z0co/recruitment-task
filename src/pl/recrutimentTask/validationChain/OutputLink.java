package pl.recrutimentTask.validationChain;

import pl.recruitmentTask.devices.TextOutputDevice;
import pl.recrutimentTask.pointOfSale.PointOfSale;

public interface OutputLink {
	public void print(char[] input);
	public void setNextLink(OutputLink nextLink);
	public void setPointOfSale(PointOfSale pointOfSale);
	public TextOutputDevice getOutputDevice();
}
