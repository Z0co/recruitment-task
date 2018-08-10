package pl.recrutimentTask.validationChain;

import pl.recruitmentTask.devices.DeviceNames;
import pl.recruitmentTask.devices.TextOutputDevice;
import pl.recrutimentTask.pointOfSale.PointOfSale;

public class PrintEmptyCodeLink implements OutputLink{
	private PointOfSale pointOfSale;
	private OutputLink nextLink;
	private final String EMPTY_CODE = "Invalid bar-code";
	
	public PrintEmptyCodeLink(PointOfSale pointOfSale) {
		this.pointOfSale = pointOfSale;
	}
	
	@Override
	public void print(char[] input) {
		if(input==null || input.length==0){
			TextOutputDevice device = getOutputDevice();
			device.output(EMPTY_CODE);
		}
		else if(nextLink!=null){
			nextLink.print(input);
		}
		
	}


	@Override
	public void setPointOfSale(PointOfSale pointOfSale) {
		this.pointOfSale = pointOfSale;
	}

	@Override
	public void setNextLink(OutputLink nextLink) {
		this.nextLink = nextLink;
		
	}

	@Override
	public TextOutputDevice getOutputDevice() {
		return pointOfSale.getOutputDevice(DeviceNames.LCD);
	}

}
