package model;

import java.util.Date;

import org.jdom.Element;

import enums.ClothColor;
import enums.Seasson;

public class Cloth{
	
	private String code;
	private String description;
	private ClothColor color;
	private Integer size;
	private Double price;
	private Integer amount;
	private Seasson seasson;
	private Provider provider;
	private String path;

	public Cloth(String code, String description, ClothColor color, Integer size, double price, Seasson seasson, int amount, Provider provider) {
		this.code = code;
		this.description = description;
		this.color = color;
		this.size = size;
		this.price = price;
		this.seasson = seasson;
		this.amount = amount;
		this.provider = provider;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ClothColor getColor() {
		return color;
	}

	public void setColor(ClothColor color) {
		this.color = color;
	}

	public double getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	public Seasson getSeasson() {
		return seasson;
	}

	public void setSeasson(Seasson seasson) {
		this.seasson = seasson;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public Element toXML(){
		Element element = new Element("Cloth");
		Date date = new Date();
		element.setAttribute("date", date.toString());
		element.setAttribute("code", code);
		element.setAttribute("description", description);
		element.setAttribute("color", color.toString());
		element.setAttribute("size", size.toString());
		element.setAttribute("price", price.toString());
		element.setAttribute("amount", amount.toString());
		element.setAttribute("seasson", seasson.toString());
		if(provider != null)
			element.addContent(provider.toXML());
		return element;
	}
}