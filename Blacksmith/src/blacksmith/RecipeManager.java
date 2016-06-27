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
		case BRASSBAR:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.COPPERORE), new Item(ItemType.ZINCORE))))) {
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
		case RUBBER:
			if (Inventory.checkAndRemove(new QuantifiedItem(ItemType.LOG, 10))) {
				break;
			} else {
				return;
			}
		case GLASS:
			if (Inventory.checkAndRemove(new Item(ItemType.SAND))) {
				break;
			} else {
				return;
			}
		case SILICON:
			if (Inventory.checkAndRemove(new Item(ItemType.GLASS))) {
				break;
			} else {
				return;
			}
		default:
			System.err.println(Messages.getString("RecipeManager.furnace.switch"));
			return;
		}
		Inventory.add(new Item(ITEM_TYPE));
		User.addXP(10);
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
		case SAND:
			if (Inventory.checkAndRemove(new Item(ItemType.STONE))) {
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

	public static void craft(ItemType ITEM_TYPE) {
		switch (ITEM_TYPE) {
		case DIAMOND:
			if (Inventory.checkAndRemove(new Item(ItemType.DIAMONDORE))) {
				break;
			} else {
				return;
			}
		case EMERALD:
			if (Inventory.checkAndRemove(new Item(ItemType.EMERALDORE))) {
				break;
			} else {
				return;
			}
		case RUBY:
			if (Inventory.checkAndRemove(new Item(ItemType.RUBYORE))) {
				break;
			} else {
				return;
			}
		case SAPPHIRE:
			if (Inventory.checkAndRemove(new Item(ItemType.SAPPHIREORE))) {
				break;
			} else {
				return;
			}
		case COPPERWIRE:
			if (Inventory.checkAndRemove(new Item(ItemType.COPPERBAR))) {
				break;
			} else {
				return;
			}
		case INSULATEDWIRE:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.COPPERWIRE), new Item(ItemType.RUBBER))))) {
				break;
			} else {
				return;
			}
		case CAPACITOR:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new Item(ItemType.SILICON), new QuantifiedItem(ItemType.IRONBAR, 2), new QuantifiedItem(ItemType.INSULATEDWIRE, 2))))) {
				break;
			} else {
				return;
			}
		case PCB:
			if (Inventory.checkAndRemove(new ArrayList<Item>(Arrays.asList(new QuantifiedItem(ItemType.SILICON, 8), new QuantifiedItem(ItemType.COPPERWIRE, 4))))) {
				break;
			} else {
				return;
			}
		default:
			System.err.println(Messages.getString("RecipeManager.craft.switch"));
			break;
		}
		Inventory.add(new Item(ITEM_TYPE));
	}
}
