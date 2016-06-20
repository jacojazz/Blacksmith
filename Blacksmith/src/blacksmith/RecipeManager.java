package blacksmith;

public class RecipeManager {
	static void furnace(ItemType ITEM_TYPE) {
		switch (ITEM_TYPE) {
		case ADAMANTITEBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.ADAMANTITEORE, ItemTier.NONE, ItemState.NONE))) {
				break;
			} else {
				return;
			}
		case COBALTBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.COBALTORE, ItemTier.NONE, ItemState.NONE))) {
				break;
			} else {
				return;
			}
		case COPPERBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.COPPERORE, ItemTier.NONE, ItemState.NONE))) {
				break;
			} else {
				return;
			}
		case DIAMOND:
			if (Inventory.checkAndRemove(new Item(ItemType.DIAMONDORE, ItemTier.NONE, ItemState.NONE))) {
				break;
			} else {
				return;
			}
		case GOLDBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.GOLDORE, ItemTier.NONE, ItemState.NONE))) {
				break;
			} else {
				return;
			}
		case HELLSTONEBAR:
			break;
		case IRONBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.IRONORE, ItemTier.NONE, ItemState.NONE))) {
				break;
			} else {
				return;
			}
		case LEGENDARIUMBAR:
			break;
		case MITHRILBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.MITHRILORE, ItemTier.NONE, ItemState.NONE))) {
				break;
			} else {
				return;
			}
		case MUSTACHIUMBAR:
			break;
		case SILVERBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.SILVERORE, ItemTier.NONE, ItemState.NONE))) {
				break;
			} else {
				return;
			}
		case STEELBAR:
			return;
		case TINBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.TINORE, ItemTier.NONE, ItemState.NONE))) {
				break;
			} else {
				return;
			}
		case UNOBTANIUMBAR:
			break;
		case XENOTINEBAR:
			break;
		default:
			System.err.println("Smelting Error: FURNACE SWITCH");
			return;
		}
		Inventory.add(new Item(ITEM_TYPE, ItemTier.NONE, ItemState.NONE));
	}
}
