package blacksmith;

public class Main {
	public static void main(String[] args) {
		Inventory.add(new Item(ItemType.COPPERORE, ItemTier.NONE, ItemState.NONE));
		Inventory.print();
		RecipeManager.furnace(ItemType.COPPERBAR);
		Inventory.print();
	}
}
