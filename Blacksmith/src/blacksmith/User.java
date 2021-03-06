package blacksmith;

public class User {
	private static int level = 0;
	private static int xp = 0;
	private static int xpPerLevel = 1000;
	private static int coins = 2000;

	private static Item equippedTool;

	public static int getXPForLevel() {
		return (level + 1 * xpPerLevel) - xp;
	}

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int level) {
		User.level = level;
	}

	public static int getXP() {
		return xp;
	}

	public static void addXP(int xp) {
		if (User.xp + xp > xpPerLevel) {
			int difference = xpPerLevel - User.xp;
			User.xp = xp - difference;
			User.level++;
		}
	}

	public static void equipTool(Item i) {
		if (i.getType().getGroup() == ItemGroup.TOOLS) {
			User.equippedTool = i;
		}
	}

	public static Item getEquippedTool() {
		return equippedTool;
	}

	public static int getCoins() {
		return coins;
	}

	public static void setCoins(int coins) {
		User.coins = coins;
	}
}
