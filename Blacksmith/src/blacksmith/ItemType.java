package blacksmith;

public enum ItemType {
	NONE("TEMP ITEM", ItemGroup.NONE),

	// FOOD
	APPLE("Apple", ItemGroup.FOOD),
	BREAD("Bread", ItemGroup.FOOD),

	// EQUIPMENT
	DAGGER("Dagger", ItemGroup.EQUIPMENT),
	SHORTSWORD("Shortsword", ItemGroup.EQUIPMENT),
	BROADSWORD("Broadsword", ItemGroup.EQUIPMENT),
	LONGSWORD("Longsword", ItemGroup.EQUIPMENT),
	HATCHET("Hatchet", ItemGroup.EQUIPMENT),
	HAMMER("Hammer", ItemGroup.EQUIPMENT),
	SPEAR("Spear", ItemGroup.EQUIPMENT),
	SHIELD("Shield", ItemGroup.EQUIPMENT),
	BATTLEAXE("Battleaxe", ItemGroup.EQUIPMENT),
	HELMET("Helmet", ItemGroup.EQUIPMENT),
	BREASTPLATE("Breastplate", ItemGroup.EQUIPMENT),
	LEGGINGS("Leggings", ItemGroup.EQUIPMENT),
	BOOTS("Boots", ItemGroup.EQUIPMENT),
	BOW("Bow", ItemGroup.EQUIPMENT),
	ARROW("Arrow", ItemGroup.EQUIPMENT),

	// SUPPLIES
	LOG("Log", ItemGroup.SUPPLIES),
	STRING("String", ItemGroup.SUPPLIES),

	// ORE
	COAL("Coal", ItemGroup.ORE),
	COPPERORE("Copper Ore", ItemGroup.ORE),
	TINORE("Tin Ore", ItemGroup.ORE),
	ZINCORE("Zinc Ore", ItemGroup.ORE),
	IRONORE("Iron Ore", ItemGroup.ORE),
	SILVERORE("Silver Ore", ItemGroup.ORE),
	GOLDORE("Gold Ore", ItemGroup.ORE),
	DIAMONDORE("Diamond Ore", ItemGroup.ORE),
	MITHRILORE("Mithril Ore", ItemGroup.ORE),
	ADAMANTITEORE("Adamantite Ore", ItemGroup.ORE),
	COBALTORE("Cobalt Ore", ItemGroup.ORE),

	// GEMS
	DIAMOND("Diamond", ItemGroup.GEMS),
	RUBY("Ruby", ItemGroup.GEMS),
	EMERALD("Emerald", ItemGroup.GEMS),
	SAPPHIRE("Sapphire", ItemGroup.GEMS),

	// BARS
	COPPERBAR("Copper", ItemGroup.BARS),
	TINBAR("Tin", ItemGroup.BARS),
	IRONBAR("Iron", ItemGroup.BARS),
	BRASSBAR("Brass", ItemGroup.BARS),
	BRONZEBAR("Bronze", ItemGroup.BARS),
	STEELBAR("Steel", ItemGroup.BARS),
	SILVERBAR("Silver", ItemGroup.BARS),
	GOLDBAR("Gold", ItemGroup.BARS),
	MITHRILBAR("Mithril", ItemGroup.BARS),
	ADAMANTITEBAR("Adamantite", ItemGroup.BARS),
	COBALTBAR("Cobalt", ItemGroup.BARS),
	HELLSTONEBAR("Hellstone", ItemGroup.BARS),
	LEGENDARIUMBAR("Legendarium", ItemGroup.BARS),
	MUSTACHIUMBAR("Mustachium", ItemGroup.BARS),
	XENOTINEBAR("Xenotine", ItemGroup.BARS),
	UNOBTANIUMBAR("Unobtanium", ItemGroup.BARS);

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
