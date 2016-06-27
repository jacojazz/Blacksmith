package blacksmith;

public class QuantifiedItem extends Item {
	private int QUANTITY;

	QuantifiedItem(ItemType ITEM_TYPE, int QUANTITY) {
		super(ITEM_TYPE);
		this.QUANTITY = QUANTITY;
	}

	QuantifiedItem(Item ITEM, int QUANTITY) {
		this(ITEM.getType(), ITEM.getTier(), ITEM.getState(), QUANTITY);
	}

	QuantifiedItem(ItemType ITEM_TYPE, ItemTier ITEM_TIER, ItemState ITEM_STATE, int QUANTITY) {
		super(ITEM_TYPE, ITEM_TIER, ITEM_STATE);
		this.QUANTITY = QUANTITY;
	}

	public void setQuantity(int QUANTITY) {
		this.QUANTITY = QUANTITY;
	}

	public int getQuantity() {
		return QUANTITY;
	}

	@Override
	public String toString() {
		return super.toString() + " (" + getQuantity() + ")";
	}
}
