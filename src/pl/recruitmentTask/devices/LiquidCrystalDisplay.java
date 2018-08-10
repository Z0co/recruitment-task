package pl.recruitmentTask.devices;

public class LiquidCrystalDisplay implements TextOutputDevice{

	private char[] display = {};
	
	@Override
	public void output(String output) {
		clearDisplay();
		printOnScreen(output.toCharArray());
	}

	private void clearDisplay(){
		display = new char[]{};
	}
	
	private void printOnScreen(char[] output){
		display = output;
		System.out.println(display);
	}
}
