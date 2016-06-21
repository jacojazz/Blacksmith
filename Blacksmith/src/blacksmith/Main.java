package blacksmith;

public class Main {
	public static void main(String[] args) {
		Inventory.add(new QuantifiedItem(ItemType.COPPERORE, ItemTier.NONE, ItemState.NONE, 10));
		Inventory.add(new QuantifiedItem(ItemType.TINORE, ItemTier.NONE, ItemState.NONE, 10));
		Inventory.print();
		RecipeManager.furnace(ItemType.COPPERBAR);
		RecipeManager.furnace(ItemType.BRONZEBAR);
		Inventory.print();
	}
}
