package com.grupoPZBM.backendtrabppi;

public class Cart {
	
	private long total;
	private Product[] products;
	
	public Cart(long total, Product[] products) {
		this.total = total;
		this.products = products;
	}

	public long getTotal() {
		return total;
	}

	public Product[] getProducts() {
		return products;
	}
}
