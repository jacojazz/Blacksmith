package blacksmith;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;

import blacksmith.utils.Messages;

public class GUITest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private HashMap<String, Image> res = new HashMap<String, Image>();
	private JTable marketTable;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITest frame = new GUITest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void resourceLoad() {
		try {
			res.put("mainIcon", ImageIO.read(getClass().getResource("icon.png"))); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GUITest() {
		super(Messages.getString("Blacksmith.name")); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		resourceLoad();

		setIconImage(res.get("mainIcon")); //$NON-NLS-1$
		setBounds(100, 100, 640, 480);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem removeInv = new JMenuItem(Messages.getString("Blacksmith.invRemove")); //$NON-NLS-1$
		popupMenu.add(removeInv);

		final JList<Item> invDisplay = new JList<Item>();
		invDisplay.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				check(e);
			}

			public void mouseReleased(MouseEvent e) {
				check(e);
			}

			public void check(MouseEvent e) {
				if (e.isPopupTrigger()) {
					invDisplay.setSelectedIndex(invDisplay.locationToIndex(e.getPoint()));
					popupMenu.show(invDisplay, e.getX(), e.getY());
				}
			}
		});
		invDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		invDisplay.setListData(Inventory.getArray().toArray(new Item[Inventory.getArray().size()]));
		invDisplay.setBounds(10, 13, 200, 417);
		contentPane.add(invDisplay);

		removeInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory.checkAndRemove(invDisplay.getSelectedValue());
				updateInv(invDisplay);
			}
		});

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		tabbedPane.setBounds(220, 13, 394, 417);
		contentPane.add(tabbedPane);

		JPanel marketPanel = new JPanel();
		tabbedPane.addTab(Messages.getString("Blacksmith.market"), null, marketPanel, null); //$NON-NLS-1$
		marketPanel.setLayout(null);

		JScrollPane marketScrollPane = new JScrollPane();
		marketScrollPane.setBounds(12, 13, 365, 300);
		marketPanel.add(marketScrollPane);

		marketTable = new JTable(Market.getTableData()) {
			private static final long serialVersionUID = -2575164177251838224L;

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 3) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return Integer.class;
				case 2:
					return Integer.class;
				case 3:
					return Boolean.class;
				default:
					return null;
				}
			}
		};
		marketTable.setRowSelectionAllowed(false);
		marketTable.setFillsViewportHeight(true);
		marketScrollPane.setViewportView(marketTable);

		final JLabel coinsLabel = new JLabel(Messages.getString("Blacksmith.coinsValue") + User.getCoins()); //$NON-NLS-1$
		coinsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		coinsLabel.setBounds(17, 356, 355, 14);
		marketPanel.add(coinsLabel);

		JButton buySelected = new JButton(Messages.getString("Blacksmith.buySelected")); //$NON-NLS-1$
		buySelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel tm = marketTable.getModel();
				for (int i = 0; i < tm.getRowCount(); i++) {
					if ((Boolean) tm.getValueAt(i, 3) == true && (User.getCoins() - (Integer) tm.getValueAt(i, 2) >= 0)) {
						MarketListing listing = new MarketListing((Item) tm.getValueAt(i, 0), (Integer) tm.getValueAt(i, 1), (Integer) tm.getValueAt(i, 2));
						Market.removeListing(listing, true);
						marketTable.setModel(Market.getTableData());
						coinsLabel.setText(Messages.getString("Blacksmith.coinsValue") + User.getCoins()); //$NON-NLS-1$
						updateInv(invDisplay);
					}
				}
			}
		});
		buySelected.setBounds(142, 328, 105, 25);
		marketPanel.add(buySelected);

		JPanel furnacePanel = new JPanel();
		tabbedPane.addTab(Messages.getString("Blacksmith.furnace"), null, furnacePanel, null); //$NON-NLS-1$
		furnacePanel.setLayout(null);

		final JComboBox<ItemType> smeltCombo = new JComboBox<ItemType>();
		smeltCombo.setModel(new DefaultComboBoxModel<ItemType>(ItemType.getSubArrayFromCraftable(Craftable.FURNACE)));
		smeltCombo.setBounds(10, 12, 270, 20);
		furnacePanel.add(smeltCombo);

		JButton smeltButton = new JButton(Messages.getString("Blacksmith.smelt")); //$NON-NLS-1$
		smeltButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecipeManager.furnace(smeltCombo.getItemAt(smeltCombo.getSelectedIndex()));
				updateInv(invDisplay);
			}
		});
		smeltButton.setBounds(290, 11, 89, 23);
		furnacePanel.add(smeltButton);

		JPanel anvilPanel = new JPanel();
		tabbedPane.addTab(Messages.getString("Blacksmith.anvil"), null, anvilPanel, null); //$NON-NLS-1$
		anvilPanel.setLayout(null);

		final JComboBox<ItemType> anvilTypeCombo = new JComboBox<ItemType>();
		anvilTypeCombo.setModel(new DefaultComboBoxModel<ItemType>(ItemType.getSubArrayFromCraftable(Craftable.ANVIL)));
		anvilTypeCombo.setBounds(10, 12, 125, 20);
		anvilPanel.add(anvilTypeCombo);

		final JComboBox<ItemTier> anvilTierCombo = new JComboBox<ItemTier>();
		anvilTierCombo.setModel(new DefaultComboBoxModel<ItemTier>(ItemTier.values()));
		anvilTierCombo.setBounds(145, 12, 125, 20);
		anvilPanel.add(anvilTierCombo);

		JButton forgeButton = new JButton(Messages.getString("Blacksmith.forge")); //$NON-NLS-1$
		forgeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecipeManager.anvil(anvilTypeCombo.getItemAt(anvilTypeCombo.getSelectedIndex()), anvilTierCombo.getItemAt(anvilTierCombo.getSelectedIndex()));
				updateInv(invDisplay);
			}
		});
		forgeButton.setBounds(290, 11, 89, 23);
		anvilPanel.add(forgeButton);

		JPanel craftPanel = new JPanel();
		tabbedPane.addTab(Messages.getString("Blacksmith.crafting"), null, craftPanel, null); //$NON-NLS-1$
		craftPanel.setLayout(null);

		final JComboBox<ItemType> craftCombo = new JComboBox<ItemType>();
		craftCombo.setModel(new DefaultComboBoxModel<ItemType>(ItemType.getSubArrayFromCraftable(Craftable.CRAFTINGTABLE)));
		craftCombo.setBounds(10, 12, 270, 20);
		craftPanel.add(craftCombo);

		JButton craftButton = new JButton(Messages.getString("Blacksmith.craft")); //$NON-NLS-1$
		craftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecipeManager.craft(craftCombo.getItemAt(craftCombo.getSelectedIndex()));
				updateInv(invDisplay);
			}
		});
		craftButton.setBounds(290, 11, 89, 23);
		craftPanel.add(craftButton);

		JPanel finishingPanel = new JPanel();
		tabbedPane.addTab(Messages.getString("Blacksmith.finishingTable"), null, finishingPanel, null); //$NON-NLS-1$
		finishingPanel.setLayout(null);

		JPanel enchantingPanel = new JPanel();
		tabbedPane.addTab(Messages.getString("Blacksmith.enchantingTable"), null, enchantingPanel, null); //$NON-NLS-1$
		enchantingPanel.setLayout(null);

		JPanel adminPanel = new JPanel();
		tabbedPane.addTab(Messages.getString("Blacksmith.admin"), null, adminPanel, null); //$NON-NLS-1$
		adminPanel.setLayout(null);

		final JComboBox<ItemType> typeBox = new JComboBox<ItemType>();
		typeBox.setModel(new DefaultComboBoxModel<ItemType>(ItemType.values()));
		typeBox.setBounds(22, 11, 100, 20);
		adminPanel.add(typeBox);

		final JComboBox<ItemTier> tierBox = new JComboBox<ItemTier>();
		tierBox.setModel(new DefaultComboBoxModel<ItemTier>(ItemTier.values()));
		tierBox.setBounds(144, 11, 100, 20);
		adminPanel.add(tierBox);

		final JComboBox<ItemState> stateBox = new JComboBox<ItemState>();
		stateBox.setModel(new DefaultComboBoxModel<ItemState>(ItemState.values()));
		stateBox.setBounds(266, 11, 100, 20);
		adminPanel.add(stateBox);

		JButton addInvButton = new JButton(Messages.getString("Blacksmith.invAdd")); //$NON-NLS-1$
		addInvButton.setBounds(150, 42, 89, 23);
		addInvButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory.add(new Item(typeBox.getItemAt(typeBox.getSelectedIndex()), tierBox.getItemAt(tierBox.getSelectedIndex()), stateBox.getItemAt(stateBox.getSelectedIndex())));
				invDisplay.setListData(Inventory.getArray().toArray(new Item[Inventory.getArray().size()]));
			}
		});
		adminPanel.add(addInvButton);

		final JComboBox<ItemType> marketTypeBox = new JComboBox<ItemType>();
		marketTypeBox.setModel(new DefaultComboBoxModel<ItemType>(ItemType.values()));
		marketTypeBox.setBounds(22, 95, 100, 20);
		adminPanel.add(marketTypeBox);

		final JComboBox<ItemTier> marketTierBox = new JComboBox<ItemTier>();
		marketTierBox.setModel(new DefaultComboBoxModel<ItemTier>(ItemTier.values()));
		marketTierBox.setBounds(144, 95, 100, 20);
		adminPanel.add(marketTierBox);

		final JComboBox<ItemState> marketStateBox = new JComboBox<ItemState>();
		marketStateBox.setModel(new DefaultComboBoxModel<ItemState>(ItemState.values()));
		marketStateBox.setBounds(266, 95, 100, 20);
		adminPanel.add(marketStateBox);

		final JSlider marketQuantitySlider = new JSlider();
		marketQuantitySlider.setPaintLabels(true);
		marketQuantitySlider.setMinimum(1);
		marketQuantitySlider.setBounds(22, 128, 344, 23);
		adminPanel.add(marketQuantitySlider);

		final JSlider marketPriceSlider = new JSlider();
		marketPriceSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

			}
		});
		marketPriceSlider.setMinimum(1);
		marketPriceSlider.setBounds(22, 164, 344, 23);
		adminPanel.add(marketPriceSlider);

		JButton addMarketButton = new JButton(Messages.getString("Blacksmith.marketAdd")); //$NON-NLS-1$
		addMarketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Market.addListing(new Item(marketTypeBox.getItemAt(marketTypeBox.getSelectedIndex()), marketTierBox.getItemAt(marketTierBox.getSelectedIndex()), marketStateBox.getItemAt(marketStateBox.getSelectedIndex())), marketQuantitySlider.getValue(), marketPriceSlider.getValue());
				marketTable.setModel(Market.getTableData());
			}
		});
		addMarketButton.setBounds(94, 200, 200, 23);
		adminPanel.add(addMarketButton);

	}

	private static void updateInv(JList<Item> inv) {
		inv.setListData(Inventory.getArray().toArray(new Item[Inventory.getArray().size()]));
	}
}
