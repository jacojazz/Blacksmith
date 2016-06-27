package blacksmith;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

public class Market {
	private static ArrayList<MarketListing> listings = new ArrayList<MarketListing>();

	public static DefaultTableModel getTableData() {
		DefaultTableModel tm = new DefaultTableModel();
		tm.addColumn("Item");
		tm.addColumn("Quantity");
		tm.addColumn("Price");
		tm.addColumn("Buy");

		for (Iterator<MarketListing> listingsIterator = listings.iterator(); listingsIterator.hasNext();) {
			tm.addRow(listingsIterator.next().getRow());
		}
		return tm;
	}
}
