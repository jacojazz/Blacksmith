package blacksmith;

import java.util.UUID;

public class Item {
	private UUID ID;
	private ItemType ITEM_TYPE;
	private ItemTier ITEM_TIER;
	private ItemState ITEM_STATE;

	Item() {
		this(ItemType.NONE);
	}

	Item(ItemType ITEM_TYPE) {
		this(ITEM_TYPE, ItemTier.NONE, ItemState.NONE);
	}

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

	public void setState(ItemState ITEM_STATE) {
		this.ITEM_STATE = ITEM_STATE;
	}

	public boolean itemCompare(Item i) {
		if (i.getType().equals(ITEM_TYPE) && i.getTier().equals(ITEM_TIER) && i.getState().equals(ITEM_STATE)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		if (ITEM_TIER != ItemTier.NONE) {
			return ITEM_TYPE.getFormattedName() + " (" + ITEM_TIER.getResource().getFormattedName() + ")" + " (" + ITEM_STATE.name().substring(0, 1) + ")";
		} else {
			return ITEM_TYPE.getFormattedName();
		}
	}
}
