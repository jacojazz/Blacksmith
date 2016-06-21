package blacksmith;

public enum ItemTier {
	// IN ORDER, DON'T SORT

	NONE(ItemType.NONE),
	WOODEN(ItemType.LOG),
	STONE(ItemType.STONE),
	COPPER(ItemType.COPPERBAR),
	BRASS(ItemType.BRASSBAR),
	BRONZE(ItemType.BRONZEBAR),
	IRON(ItemType.IRONBAR),
	STEEL(ItemType.STEELBAR),
	SILVER(ItemType.SILVERBAR),
	GOLD(ItemType.GOLDBAR),
	DIAMOND(ItemType.DIAMOND),
	MITHRIL(ItemType.MITHRILBAR),
	ADAMANTITE(ItemType.ADAMANTITEBAR),
	COBALT(ItemType.COBALTBAR),
	HELLSTONE(ItemType.HELLSTONEBAR),
	LEGENDARIUM(ItemType.LEGENDARIUMBAR),
	MUSTACHIUM(ItemType.MUSTACHIUMBAR),
	XENOTINE(ItemType.XENOTINEBAR),
	UNOBTAINIUM(ItemType.UNOBTANIUMBAR);

	private ItemType resource;

	ItemTier(ItemType resource) {
		this.resource = resource;
	}

	public ItemType getResource() {
		return resource;
	}
}
