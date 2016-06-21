package blacksmith;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeManager {
	static void furnace(ItemType ITEM_TYPE) {
		switch (ITEM_TYPE) {
		case ADAMANTITEBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.ADAMANTITEORE))) {
				break;
			} else {
				return;
			}
		case BRONZEBAR:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.COPPERORE), new Item(ItemType.TINORE))))) {
				break;
			} else {
				return;
			}
		case COBALTBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.COBALTORE))) {
				break;
			} else {
				return;
			}
		case COPPERBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.COPPERORE))) {
				break;
			} else {
				return;
			}
		case DIAMOND:
			if (Inventory.checkAndRemove(new Item(ItemType.DIAMONDORE))) {
				break;
			} else {
				return;
			}
		case GOLDBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.GOLDORE))) {
				break;
			} else {
				return;
			}
		case HELLSTONEBAR:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new QuantifiedItem(ItemType.STEELBAR, 5), new QuantifiedItem(ItemType.IRONBAR, 5), new QuantifiedItem(ItemType.STONE, 2))))) {
				break;
			} else {
				return;
			}
		case IRONBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.IRONORE))) {
				break;
			} else {
				return;
			}
		case LEGENDARIUMBAR:
			return;
		case MITHRILBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.MITHRILORE))) {
				break;
			} else {
				return;
			}
		case MUSTACHIUMBAR:
			return;
		case SILVERBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.SILVERORE))) {
				break;
			} else {
				return;
			}
		case STEELBAR:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.IRONBAR), new Item(ItemType.COAL))))) {
				break;
			} else {
				return;
			}
		case TINBAR:
			if (Inventory.checkAndRemove(new Item(ItemType.TINORE))) {
				break;
			} else {
				return;
			}
		case UNOBTANIUMBAR:
			return;
		case XENOTINEBAR:
			return;
		default:
			System.err.println(Messages.getString("RecipeManager.furnace.switch"));
			return;
		}
		Inventory.add(new Item(ITEM_TYPE));
	}

	public static void anvil(ItemType ITEM_TYPE, ItemTier ITEM_TIER) {
		switch (ITEM_TYPE) {
		case ARROW:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.LOG), new Item(ItemType.STRING))))) {
				break;
			} else {
				return;
			}
		case BATTLEAXE:
		case BOOTS:
		case BOW:
		case BREASTPLATE:
		case BROADSWORD:
		case DAGGER:
			if (Inventory.checkAndRemove(new Item(ITEM_TIER.getResource()))) {
				break;
			} else {
				return;
			}
		case HAMMER:
		case HATCHET:
		case HELMET:
		case LEGGINGS:
		case LONGSWORD:
		case SHIELD:
		case SHORTSWORD:
		case SPEAR:
		default:
			System.err.println(Messages.getString("RecipeManager.anvil.switch"));
			return;
		}
		Inventory.add(new Item(ITEM_TYPE, ITEM_TIER, ItemState.UNFINISHED));
	}
}
