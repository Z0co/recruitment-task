package pl.recrutimentTask.validationChain;

import pl.recrutimentTask.database.DatabaseItem;

public interface NameAndPricePrinterLink {
	default String getOutputText(DatabaseItem item){
		StringBuilder sb = new StringBuilder();
		sb.append(item.getItemName());
		sb.append(" ");
		sb.append(item.getItemPrice());
		return sb.toString();
	}
}
