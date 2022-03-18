package com.grupoPZBM.backendtrabppi;

public class Product {
	private String name;
	private String category;
	private String type;
	private String image;
	private long price;
	private String desc;
	
	public Product(String name, String category,
			String type, String image, 
			long price, String desc) {
		this.name = name;
		this.category = category;
		this.type = type;
		this.image = image;
		this.price = price;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getType() {
		return type;
	}

	public String getImage() {
		return image;
	}

	public long getPrice() {
		return price;
	}

	public String getDesc() {
		return desc;
	}
}
