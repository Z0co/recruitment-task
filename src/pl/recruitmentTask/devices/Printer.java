package pl.recruitmentTask.devices;

public class Printer implements TextOutputDevice{

	@Override
	public void output(String output) {
		print(output.toCharArray());
	}

	private void print(char[] output){
		System.out.println(output);
	}
}
