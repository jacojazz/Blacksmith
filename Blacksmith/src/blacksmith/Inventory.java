package blacksmith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Inventory {
	private static ArrayList<Item> inv = new ArrayList<Item>();

	public static void sort() {
		QtoICheck();
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
		if (inv.isEmpty()) {
			inv.add(i);
			return;
		}

		for (Iterator<Item> iIterator = inv.iterator(); iIterator.hasNext();) {
			Item invI = iIterator.next();
			if (invI.itemCompare(i)) {
				if (invI instanceof QuantifiedItem) {
					if (i instanceof QuantifiedItem) {
						((QuantifiedItem) invI).setQuantity(((QuantifiedItem) invI).getQuantity() + ((QuantifiedItem) i).getQuantity());
					} else {
						((QuantifiedItem) invI).setQuantity(((QuantifiedItem) invI).getQuantity() + 1);
					}
				} else {
					if (i instanceof QuantifiedItem) {
						inv.add(new QuantifiedItem(invI.getType(), invI.getTier(), invI.getState(), ((QuantifiedItem) i).getQuantity() + 1));
						inv.remove(invI);
					} else {
						inv.add(new QuantifiedItem(invI.getType(), invI.getTier(), invI.getState(), 2));
						inv.remove(invI);
					}
				}
				return;
			}
		}
		inv.add(i);
	}

	private static void QtoICheck() {
		for (Iterator<Item> iIterator = inv.iterator(); iIterator.hasNext();) {
			Item i = iIterator.next();
			if (i instanceof QuantifiedItem) {
				if (((QuantifiedItem) i).getQuantity() == 1) {
					inv.remove(i);
					inv.add(new Item(i.getType(), i.getTier(), i.getState()));
				} else if (((QuantifiedItem) i).getQuantity() < 1) {
					inv.remove(i);
				}
			}
		}
	}

	public static boolean checkAndRemove(Item i) {
		QtoICheck();
		for (Iterator<Item> iIterator = inv.iterator(); iIterator.hasNext();) {
			Item listI = iIterator.next();
			if (listI.itemCompare((Item) i)) {
				if (i instanceof QuantifiedItem) {
					if (listI instanceof QuantifiedItem) {
						if (((QuantifiedItem) listI).getQuantity() > ((QuantifiedItem) i).getQuantity()) {
							((QuantifiedItem) listI).setQuantity(((QuantifiedItem) listI).getQuantity() - ((QuantifiedItem) i).getQuantity());
							if (((QuantifiedItem) listI).getQuantity() < 1) {
								inv.remove(listI);
							}
							return true;
						} else if (((QuantifiedItem) listI).getQuantity() == ((QuantifiedItem) i).getQuantity()) {
							inv.remove(listI);
							return true;
						} else {
							return false;
						}
					} else {
						if (((QuantifiedItem) i).getQuantity() > 1) {
							return false;
						} else {
							inv.remove(listI);
							return true;
						}
					}
				} else {
					if (listI instanceof QuantifiedItem) {
						((QuantifiedItem) listI).setQuantity(((QuantifiedItem) listI).getQuantity() - 1);
						if (((QuantifiedItem) listI).getQuantity() < 1) {
							inv.remove(listI);
						}
						return true;
					} else {
						inv.remove(listI);
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean checkAndRemove(ArrayList<Item> iList) {
		QtoICheck();
		ArrayList<Item> invTemp = new ArrayList<Item>(inv);

		for (Item iLi : iList) {
			boolean exists = false;
			for (Item iI : invTemp) {
				if (iLi.itemCompare(iI)) {
					exists = true;
				}
			}
			if (!exists) {
				return false;
			}
		}

		for (Iterator<Item> invIterator = invTemp.iterator(); invIterator.hasNext();) {
			Item invI = invIterator.next();
			for (Iterator<Item> iIterator = iList.iterator(); iIterator.hasNext();) {
				Item i = iIterator.next();
				if (invI.itemCompare(i)) {
					if (i instanceof QuantifiedItem) {
						if (invI instanceof QuantifiedItem) {
							if (((QuantifiedItem) invI).getQuantity() > ((QuantifiedItem) i).getQuantity()) {
								((QuantifiedItem) invI).setQuantity(((QuantifiedItem) invI).getQuantity() - ((QuantifiedItem) i).getQuantity());
								iIterator.remove();
								if (((QuantifiedItem) invI).getQuantity() < 1) {
									invIterator.remove();
								}
							} else if (((QuantifiedItem) invI).getQuantity() == ((QuantifiedItem) i).getQuantity()) {
								invIterator.remove();
								iIterator.remove();
							}
						} else {
							if (((QuantifiedItem) i).getQuantity() > 1) {
								return false;
							} else {
								invIterator.remove();
								iIterator.remove();
							}
						}
					} else {
						if (invI instanceof QuantifiedItem) {
							((QuantifiedItem) invI).setQuantity(((QuantifiedItem) invI).getQuantity() - 1);
							iIterator.remove();
							if (((QuantifiedItem) invI).getQuantity() < 1) {
								invIterator.remove();
							}
						} else {
							invIterator.remove();
							iIterator.remove();
						}
					}
				}
			}
		}
		if (iList.isEmpty()) {
			inv = invTemp;
			return true;
		} else {
			return false;
		}
	}

	public static void print() {
		System.out.println(inv);
	}
}
