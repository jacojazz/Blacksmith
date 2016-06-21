package blacksmith;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeManager {
	public static void furnace(ItemType ITEM_TYPE) {
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
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.LOG), new Item(ItemType.FLINT))))) {
				break;
			} else {
				return;
			}
		case BATTLEAXE:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.LOG), new QuantifiedItem(ITEM_TIER.getResource(), 4))))) {
				break;
			} else {
				return;
			}
		case BOOTS:
			if (Inventory.checkAndRemove(new QuantifiedItem(ITEM_TIER.getResource(), 2))) {
				break;
			} else {
				return;
			}
		case BOW:
			if (Inventory.checkAndRemove(new QuantifiedItem(ITEM_TIER.getResource(), 3))) {
				break;
			} else {
				return;
			}
		case BREASTPLATE:
			if (Inventory.checkAndRemove(new QuantifiedItem(ITEM_TIER.getResource(), 4))) {
				break;
			} else {
				return;
			}
		case BROADSWORD:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.LOG), new QuantifiedItem(ITEM_TIER.getResource(), 4))))) {
				break;
			} else {
				return;
			}
		case DAGGER:
			if (Inventory.checkAndRemove(new Item(ITEM_TIER.getResource()))) {
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
		case HAMMER:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.LOG), new QuantifiedItem(ITEM_TIER.getResource(), 6))))) {
				break;
			} else {
				return;
			}
		case HATCHET:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.LOG), new QuantifiedItem(ITEM_TIER.getResource(), 2))))) {
				break;
			} else {
				return;
			}
		case HELMET:
			if (Inventory.checkAndRemove(new QuantifiedItem(ITEM_TIER.getResource(), 2))) {
				break;
			} else {
				return;
			}
		case LEGGINGS:
			if (Inventory.checkAndRemove(new QuantifiedItem(ITEM_TIER.getResource(), 4))) {
				break;
			} else {
				return;
			}
		case LONGSWORD:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.LOG), new QuantifiedItem(ITEM_TIER.getResource(), 3))))) {
				break;
			} else {
				return;
			}
		case SHIELD:
			if (Inventory.checkAndRemove(new QuantifiedItem(ITEM_TIER.getResource(), 5))) {
				break;
			} else {
				return;
			}
		case SHORTSWORD:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.LOG), new QuantifiedItem(ITEM_TIER.getResource(), 2))))) {
				break;
			} else {
				return;
			}
		case SPEAR:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new QuantifiedItem(ItemType.LOG, 3), new Item(ITEM_TIER.getResource()))))) {
				break;
			} else {
				return;
			}
		default:
			System.err.println(Messages.getString("RecipeManager.anvil.switch"));
			return;
		}
		Inventory.add(new Item(ITEM_TYPE, ITEM_TIER, ItemState.UNFINISHED));
	}
}
