package blacksmith;

import java.util.UUID;

public class Item {
	private UUID ID;
	private ItemType ITEM_TYPE;
	private ItemTier ITEM_TIER;
	private ItemState ITEM_STATE;

	Item(ItemType ITEM_TYPE, ItemTier ITEM_TIER, ItemState ITEM_STATE) {
		this.ID = UUID.randomUUID();
		this.ITEM_TYPE = ITEM_TYPE;
		this.ITEM_TIER = ITEM_TIER;
		this.ITEM_STATE = ITEM_STATE;
	}

	public UUID getID() {
		return ID;
	}

	public ItemType getType() {
		return ITEM_TYPE;
	}

	public ItemTier getTier() {
		return ITEM_TIER;
	}

	public ItemState getState() {
		return ITEM_STATE;
	}

	public void setState(ItemState iTEM_STATE) {
		ITEM_STATE = iTEM_STATE;
	}

	@Override
	public String toString() {
		return ITEM_TYPE.getFormattedName();
	}
}
