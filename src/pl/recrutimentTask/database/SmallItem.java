package pl.recrutimentTask.database;

public class SmallItem implements DatabaseItem{
	private char[] barCode;
	private Float price;
	private String name;
	
	public SmallItem(char[] barCode,Float price, String name){
		setItemBarCode(barCode);
		setItemPrice(price);
		setItemName(name);
	}
	
	@Override
	public char[] getItemBarCode() {
		return barCode;
	}

	@Override
	public void setItemBarCode(char[] barCode) {
		if(barCode==null){
			throw new NullPointerException();
		}
		this.barCode = barCode;
	}

	@Override
	public Float getItemPrice() {
		return price;
	}

	@Override
	public void setItemPrice(Float price) {
		if(price==null){
			throw new NullPointerException();
		}
		this.price = price;
	}

	@Override
	public void setItemName(String name) {
		if(name==null){
			throw new NullPointerException();
		}		
		this.name = name;
		
	}

	@Override
	public String getItemName() {
		return name;
	}

}
