package blacksmith;

public class Main {
	public static void main(String[] args) {
		Inventory.add(new QuantifiedItem(ItemType.STEELBAR, 10));
		Inventory.add(new QuantifiedItem(ItemType.IRONBAR, 10));
		Inventory.add(new QuantifiedItem(ItemType.COAL, 10));
		Inventory.add(new QuantifiedItem(ItemType.IRONORE, 10));
		Inventory.print();
		RecipeManager.furnace(ItemType.STEELBAR);
		Inventory.print();
	}
}
