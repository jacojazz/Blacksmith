package blacksmith;

public enum ItemType {
	NONE("TEMP ITEM", ItemGroup.NONE),

	// FOOD
	APPLE("Apple", ItemGroup.FOOD),
	BREAD("Bread", ItemGroup.FOOD),

	// EQUIPMENT
	ARROW("Arrow", ItemGroup.EQUIPMENT),
	BATTLEAXE("Battleaxe", ItemGroup.EQUIPMENT),
	BOOTS("Boots", ItemGroup.EQUIPMENT),
	BOW("Bow", ItemGroup.EQUIPMENT),
	BREASTPLATE("Breastplate", ItemGroup.EQUIPMENT),
	BROADSWORD("Broadsword", ItemGroup.EQUIPMENT),
	DAGGER("Dagger", ItemGroup.EQUIPMENT),
	HAMMER("Hammer", ItemGroup.EQUIPMENT),
	HATCHET("Hatchet", ItemGroup.EQUIPMENT),
	HELMET("Helmet", ItemGroup.EQUIPMENT),
	LEGGINGS("Leggings", ItemGroup.EQUIPMENT),
	LONGSWORD("Longsword", ItemGroup.EQUIPMENT),
	SHIELD("Shield", ItemGroup.EQUIPMENT),
	SHORTSWORD("Shortsword", ItemGroup.EQUIPMENT),
	SPEAR("Spear", ItemGroup.EQUIPMENT),

	// TOOLS
	PICKAXE("Pickaxe", ItemGroup.TOOLS),
	MININGDRILL("Mining Drill", ItemGroup.TOOLS),

	// ELECTRONICS
	COPPERWIRE("Copper Wire", ItemGroup.ELECTRONICS),
	INSULATEDWIRE("Insulated Wire", ItemGroup.ELECTRONICS),
	PCB("Printed Circuit Board", ItemGroup.ELECTRONICS),
	CAPACITOR("Capacitor", ItemGroup.ELECTRONICS),
	PROCESSOR("Processor", ItemGroup.ELECTRONICS),
	SILICON("Silicon", ItemGroup.ELECTRONICS),
	LOGICGATE("Logic Gates", ItemGroup.ELECTRONICS),
	COMPUTER("Computer", ItemGroup.ELECTRONICS),
	BATTERY("Battery", ItemGroup.ELECTRONICS),

	// SUPPLIES
	LOG("Log", ItemGroup.SUPPLIES),
	STONE("Stone", ItemGroup.SUPPLIES),
	STRING("String", ItemGroup.SUPPLIES),
	FEATHER("Feather", ItemGroup.SUPPLIES),
	FLINT("Flint", ItemGroup.SUPPLIES),
	RUBBER("Rubber", ItemGroup.SUPPLIES),
	SAND("Sand", ItemGroup.SUPPLIES),
	GLASS("Glass", ItemGroup.SUPPLIES),

	// ORE
	ADAMANTITEORE("Adamantite Ore", ItemGroup.ORE),
	COAL("Coal", ItemGroup.ORE),
	COBALTORE("Cobalt Ore", ItemGroup.ORE),
	COPPERORE("Copper Ore", ItemGroup.ORE),
	DIAMONDORE("Diamond Ore", ItemGroup.ORE),
	GOLDORE("Gold Ore", ItemGroup.ORE),
	IRONORE("Iron Ore", ItemGroup.ORE),
	MITHRILORE("Mithril Ore", ItemGroup.ORE),
	SILVERORE("Silver Ore", ItemGroup.ORE),
	TINORE("Tin Ore", ItemGroup.ORE),
	ZINCORE("Zinc Ore", ItemGroup.ORE),

	// GEMS
	DIAMOND("Diamond", ItemGroup.GEMS),
	EMERALD("Emerald", ItemGroup.GEMS),
	RUBY("Ruby", ItemGroup.GEMS),
	SAPPHIRE("Sapphire", ItemGroup.GEMS),

	// BARS
	ADAMANTITEBAR("Adamantite", ItemGroup.BARS),
	BRASSBAR("Brass", ItemGroup.BARS),
	BRONZEBAR("Bronze", ItemGroup.BARS),
	COBALTBAR("Cobalt", ItemGroup.BARS),
	COPPERBAR("Copper", ItemGroup.BARS),
	GOLDBAR("Gold", ItemGroup.BARS),
	HELLSTONEBAR("Hellstone", ItemGroup.BARS),
	IRONBAR("Iron", ItemGroup.BARS),
	LEGENDARIUMBAR("Legendarium", ItemGroup.BARS),
	MITHRILBAR("Mithril", ItemGroup.BARS),
	MUSTACHIUMBAR("Mustachium", ItemGroup.BARS),
	SILVERBAR("Silver", ItemGroup.BARS),
	STEELBAR("Steel", ItemGroup.BARS),
	TINBAR("Tin", ItemGroup.BARS),
	UNOBTANIUMBAR("Unobtanium", ItemGroup.BARS),
	XENOTINEBAR("Xenotine", ItemGroup.BARS);

	private String formattedName;
	private ItemGroup group;

	ItemType(String formattedName, ItemGroup group) {
		this.formattedName = formattedName;
		this.group = group;
	}

	public String getFormattedName() {
		return formattedName;
	}

	public ItemGroup getGroup() {
		return group;
	}
}
