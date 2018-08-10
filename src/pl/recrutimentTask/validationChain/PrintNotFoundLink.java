package pl.recrutimentTask.validationChain;

import pl.recruitmentTask.devices.DeviceNames;
import pl.recruitmentTask.devices.TextOutputDevice;
import pl.recrutimentTask.pointOfSale.PointOfSale;

public class PrintNotFoundLink implements OutputLink{
	private PointOfSale pointOfSale;
	private final String PRODUCT_NOT_FOUND = "Product not found";
	
	public PrintNotFoundLink(PointOfSale pointOfSale) {
		this.pointOfSale = pointOfSale;
	}
	
	@Override
	public void print(char[] input) {
		TextOutputDevice device = getOutputDevice();
		device.output(PRODUCT_NOT_FOUND);	
	}

	@Override
	public void setNextLink(OutputLink nextLink) {	
	}

	@Override
	public void setPointOfSale(PointOfSale pointOfSale) {
		this.pointOfSale = pointOfSale;
	}

	@Override
	public TextOutputDevice getOutputDevice() {
		return pointOfSale.getOutputDevice(DeviceNames.LCD);
	}
}
