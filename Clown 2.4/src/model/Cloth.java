package model;

import org.jdom.Element;

import enums.ClothColor;
import enums.Seasson;
import enums.Sex;

public class Cloth{
	
	private String code;
	private String description;
	private ClothColor color;
	private String size;
	private Double cost;
	private Double wholesalePrice;
	private Double retailPrice;
	private Integer amount;
	private Sex sex;
	private Seasson seasson;
	private Integer year;
	private Provider provider;
	private String imagePath;

	public Cloth(String code, String description, ClothColor color, String size, double cost, double wholesalePrice, 
			Double retailPrice, Sex sex, Seasson seasson, Integer year, int amount, Provider provider) {
		this.code = code;
		this.description = description;
		this.color = color;
		this.size = size;
		this.cost = cost;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.sex = sex;
		this.seasson = seasson;
		this.year = year;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Seasson getSeasson() {
		return seasson;
	}

	public void setSeasson(Seasson seasson) {
		this.seasson = seasson;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	
	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
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
		
	public Element toXML(){
		Element element = new Element("Cloth");
		element.setAttribute("Código", code);
		element.setAttribute("Descripción", description);
		element.setAttribute("Color", color.toString());
		element.setAttribute("Tamaño", size.toString());
		element.setAttribute("Costo", cost.toString());
		element.setAttribute("PrecioM", wholesalePrice.toString());
		element.setAttribute("Preciom", retailPrice.toString());
		element.setAttribute("Año", year.toString());
		element.setAttribute("Sexo", sex.toString());
		element.setAttribute("Cantidad", amount.toString());
		element.setAttribute("Temporada", seasson.toString());
		if(imagePath != null){
			element.setAttribute("ImagePath", imagePath);
		}else{
			element.setAttribute("ImagePath", "null");
		}
		if(provider != null)
			element.addContent(provider.toXML());
		return element;
	}

	public void setImage(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return imagePath;
	}
	
}