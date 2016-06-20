package blacksmith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Inventory {
	private static ArrayList<Item> inv = new ArrayList<Item>();

	public static void sort() {
		Collections.sort(inv, new Comparator<Item>() {
			public int compare(Item i1, Item i2) {
				if (i1.getType() == i2.getType()) {
					return 0;
				} else {
					return 1;
				}
			}
		});
	}

	public static void add(Item i) {
		inv.add(i);
	}

	public static boolean checkAndRemove(Item i) {
		for (Iterator<Item> iIterator = inv.iterator(); iIterator.hasNext();) {
			Item listI = iIterator.next();
			if (listI.getType() == i.getType() && listI.getTier() == i.getTier() && listI.getState() == i.getState()) {
				inv.remove(listI);
				return true;
			} else if (listI instanceof QuantifiedItem && listI.getType() == i.getType() && listI.getTier() == i.getTier() && listI.getState() == i.getState()) {
				((QuantifiedItem) listI).setQuantity(((QuantifiedItem) listI).getQuantity() - 1);
			} else if (i instanceof QuantifiedItem && listI instanceof QuantifiedItem && listI.getType() == i.getType() && listI.getTier() == i.getTier() && listI.getState() == i.getState()) {
				if (((QuantifiedItem) i).getQuantity() > ((QuantifiedItem) listI).getQuantity()) {
					return false;
				} else if (((QuantifiedItem) i).getQuantity() < ((QuantifiedItem) listI).getQuantity() && ((QuantifiedItem) listI).getQuantity() - ((QuantifiedItem) i).getQuantity() > 0) {
					((QuantifiedItem) listI).setQuantity(((QuantifiedItem) listI).getQuantity() - ((QuantifiedItem) i).getQuantity());
					return true;
				} else if (((QuantifiedItem) i).getQuantity() == ((QuantifiedItem) listI).getQuantity()) {
					inv.remove(listI);
					return true;
				}
			}
		}
		return false;
	}

	public static void print() {
		System.out.println(inv.toString());
	}
}
