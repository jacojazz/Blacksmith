package blacksmith;

import javax.swing.JButton;

public class MarketListing {
	private Item item;
	private int quantity;
	private int price;

	public MarketListing(Item i, int q, int p) {
		this.item = i;
		this.quantity = q;
		this.price = p;
	}

	public Object[] getRow() {
		return new Object[] { item, quantity, price, new JButton("Buy") };
	}
}
