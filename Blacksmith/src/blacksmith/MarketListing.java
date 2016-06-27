package blacksmith;

public class MarketListing {
	private Item item;
	private int quantity;
	private int price;

	public MarketListing(Item i, int q, int p) {
		this.item = i;
		this.quantity = q;
		this.price = p;
	}

	public boolean compare(MarketListing listing) {
		if (listing.getItem() == this.getItem() && listing.getQuantity() == this.getQuantity() && listing.getPrice() == this.getPrice()) {
			return true;
		} else {
			return false;
		}
	}

	public Object[] getRow() {
		return new Object[] { item, quantity, price, false };
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}
}
