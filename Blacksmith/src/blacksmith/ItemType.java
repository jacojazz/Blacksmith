package blacksmith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public enum ItemType {
	NONE("TEMP ITEM", ItemGroup.NONE, Craftable.NONE),

	// FOOD
	APPLE("Apple", ItemGroup.FOOD, Craftable.NONE),
	BREAD("Bread", ItemGroup.FOOD, Craftable.NONE),

	// EQUIPMENT
	ARROW("Arrow", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	BATTLEAXE("Battleaxe", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	BOOTS("Boots", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	BOW("Bow", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	BREASTPLATE("Breastplate", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	BROADSWORD("Broadsword", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	DAGGER("Dagger", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	HAMMER("Hammer", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	HATCHET("Hatchet", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	HELMET("Helmet", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	LEGGINGS("Leggings", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	LONGSWORD("Longsword", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	SHIELD("Shield", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	SHORTSWORD("Shortsword", ItemGroup.EQUIPMENT, Craftable.ANVIL),
	SPEAR("Spear", ItemGroup.EQUIPMENT, Craftable.ANVIL),

	// TOOLS
	PICKAXE("Pickaxe", ItemGroup.TOOLS, Craftable.ANVIL),
	MININGDRILL("Mining Drill", ItemGroup.TOOLS, Craftable.CRAFTINGTABLE),

	// ELECTRONICS
	COPPERWIRE("Copper Wire", ItemGroup.ELECTRONICS, Craftable.CRAFTINGTABLE),
	INSULATEDWIRE("Insulated Wire", ItemGroup.ELECTRONICS, Craftable.CRAFTINGTABLE),
	PCB("Printed Circuit Board", ItemGroup.ELECTRONICS, Craftable.CRAFTINGTABLE),
	CAPACITOR("Capacitor", ItemGroup.ELECTRONICS, Craftable.CRAFTINGTABLE),
	PROCESSOR("Processor", ItemGroup.ELECTRONICS, Craftable.CRAFTINGTABLE),
	SILICON("Silicon", ItemGroup.ELECTRONICS, Craftable.CRAFTINGTABLE),
	LOGICGATE("Logic Gates", ItemGroup.ELECTRONICS, Craftable.CRAFTINGTABLE),
	COMPUTER("Computer", ItemGroup.ELECTRONICS, Craftable.CRAFTINGTABLE),
	BATTERY("Battery", ItemGroup.ELECTRONICS, Craftable.CRAFTINGTABLE),

	// SUPPLIES
	LOG("Log", ItemGroup.SUPPLIES, Craftable.NONE),
	STONE("Stone", ItemGroup.SUPPLIES, Craftable.NONE),
	STRING("String", ItemGroup.SUPPLIES, Craftable.NONE),
	FEATHER("Feather", ItemGroup.SUPPLIES, Craftable.NONE),
	FLINT("Flint", ItemGroup.SUPPLIES, Craftable.NONE),
	RUBBER("Rubber", ItemGroup.SUPPLIES, Craftable.FURNACE),
	SAND("Sand", ItemGroup.SUPPLIES, Craftable.ANVIL),
	GLASS("Glass", ItemGroup.SUPPLIES, Craftable.FURNACE),

	// ORE
	ADAMANTITEORE("Adamantite Ore", ItemGroup.ORE, Craftable.NONE),
	COAL("Coal", ItemGroup.ORE, Craftable.NONE),
	COBALTORE("Cobalt Ore", ItemGroup.ORE, Craftable.NONE),
	COPPERORE("Copper Ore", ItemGroup.ORE, Craftable.NONE),
	DIAMONDORE("Diamond Ore", ItemGroup.ORE, Craftable.NONE),
	EMERALDORE("Emerald Ore", ItemGroup.ORE, Craftable.NONE),
	GOLDORE("Gold Ore", ItemGroup.ORE, Craftable.NONE),
	IRONORE("Iron Ore", ItemGroup.ORE, Craftable.NONE),
	MITHRILORE("Mithril Ore", ItemGroup.ORE, Craftable.NONE),
	RUBYORE("Ruby Ore", ItemGroup.ORE, Craftable.NONE),
	SAPPHIREORE("Sapphire Ore", ItemGroup.ORE, Craftable.NONE),
	SILVERORE("Silver Ore", ItemGroup.ORE, Craftable.NONE),
	TINORE("Tin Ore", ItemGroup.ORE, Craftable.NONE),
	ZINCORE("Zinc Ore", ItemGroup.ORE, Craftable.NONE),

	// GEMS
	DIAMOND("Diamond", ItemGroup.GEMS, Craftable.CRAFTINGTABLE),
	EMERALD("Emerald", ItemGroup.GEMS, Craftable.NONE),
	RUBY("Ruby", ItemGroup.GEMS, Craftable.NONE),
	SAPPHIRE("Sapphire", ItemGroup.GEMS, Craftable.NONE),

	// BARS
	ADAMANTITEBAR("Adamantite", ItemGroup.BARS, Craftable.FURNACE),
	BRASSBAR("Brass", ItemGroup.BARS, Craftable.FURNACE),
	BRONZEBAR("Bronze", ItemGroup.BARS, Craftable.FURNACE),
	COBALTBAR("Cobalt", ItemGroup.BARS, Craftable.FURNACE),
	COPPERBAR("Copper", ItemGroup.BARS, Craftable.FURNACE),
	GOLDBAR("Gold", ItemGroup.BARS, Craftable.FURNACE),
	HELLSTONEBAR("Hellstone", ItemGroup.BARS, Craftable.FURNACE),
	IRONBAR("Iron", ItemGroup.BARS, Craftable.FURNACE),
	LEGENDARIUMBAR("Legendarium", ItemGroup.BARS, Craftable.FURNACE),
	MITHRILBAR("Mithril", ItemGroup.BARS, Craftable.FURNACE),
	MUSTACHIUMBAR("Mustachium", ItemGroup.BARS, Craftable.FURNACE),
	SILVERBAR("Silver", ItemGroup.BARS, Craftable.FURNACE),
	STEELBAR("Steel", ItemGroup.BARS, Craftable.FURNACE),
	TINBAR("Tin", ItemGroup.BARS, Craftable.FURNACE),
	UNOBTANIUMBAR("Unobtanium", ItemGroup.BARS, Craftable.FURNACE),
	XENOTINEBAR("Xenotine", ItemGroup.BARS, Craftable.FURNACE);

	private String formattedName;
	private ItemGroup group;
	private Craftable craft;

	ItemType(String formattedName, ItemGroup group, Craftable craft) {
		this.formattedName = formattedName;
		this.group = group;
		this.craft = craft;
	}

	public String getFormattedName() {
		return formattedName;
	}

	public ItemGroup getGroup() {
		return group;
	}

	public Craftable getCraftable() {
		return craft;
	}

	public static ItemType[] getSubArrayFromCraftable(Craftable craftable) {
		ArrayList<ItemType> temp = new ArrayList<ItemType>(Arrays.asList(ItemType.values()));
		for (Iterator<ItemType> tempIterator = temp.iterator(); tempIterator.hasNext();) {
			ItemType tempType = tempIterator.next();
			if (tempType.getCraftable() != craftable) {
				tempIterator.remove();
			}
		}
		return temp.toArray(new ItemType[temp.size()]);
	}

	public String toString() {
		return formattedName;
	}
}
