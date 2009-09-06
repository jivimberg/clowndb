package model;

import org.jdom.Element;

public class Provider{
	
	private String name;
	
	public Provider(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Element toXML() {
		Element element = new Element("Provider");
		element.setAttribute("Nombre", name);
		return element;
	}
	
	public String toString(){
		return name;
	}
}
