package pl.recrutimentTask.database;

public interface DatabaseItem {
	public char[] getItemBarCode();
	public void setItemBarCode(char[] barCode);
	public Float getItemPrice();
	public void setItemPrice(Float price);
	public void setItemName(String name);
	public String getItemName();
}
