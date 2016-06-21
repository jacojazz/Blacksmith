package blacksmith;

public class Main {
	public static void main(String[] args) {
		Inventory.add(new QuantifiedItem(ItemType.COPPERBAR, 5));
		Inventory.add(new QuantifiedItem(ItemType.IRONBAR, 5));
		Inventory.print();
		RecipeManager.anvil(ItemType.DAGGER, ItemTier.COPPER);
		Inventory.print();
		RecipeManager.anvil(ItemType.DAGGER, ItemTier.IRON);
		Inventory.print();
	}
}