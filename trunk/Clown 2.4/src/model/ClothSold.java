package model;

import java.util.Date;

import org.jdom.Element;

public class ClothSold {
	
	private String date;
	private Cloth sold;
	
	@SuppressWarnings("deprecation")
	public ClothSold(Cloth sold, int amount) {
		Date auxDate = new Date();
		date = auxDate.getDate() + "/" + auxDate.getMonth() + "/" + (auxDate.getYear() + 1900);
		this.sold = new Cloth(sold.getCode(), sold.getDescription(), sold.getColor(), sold.getSize(), sold.getCost(), 
				sold.getWholesalePrice(), sold.getRetailPrice(), sold.getSex(), sold.getSeasson(), sold.getYear(), amount, null);
	}
	
	public ClothSold(Cloth sold, String date) {
		this.date = date;
		this.sold = sold;
	}

	public String getDate() {
		return date;
	}

	public Cloth getSold() {
		return sold;
	}

	public void setSold(Cloth sold) {
		this.sold = sold;
	}
	
	public Element toXML() {
		Element element = new Element("SoldCloth");
		element.setAttribute("Date", date.toString());
		element.setContent(sold.toXML());
		return element;
	}
}