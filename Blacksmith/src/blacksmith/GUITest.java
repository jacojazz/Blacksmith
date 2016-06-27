package blacksmith;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class GUITest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

	public GUITest() {
		super("Blacksmith");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		try {
			setIconImage(ImageIO.read(getClass().getResource("icon.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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

		final JList<Item> invDisplay = new JList<Item>();
		invDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		invDisplay.setListData(Inventory.getArray().toArray(new Item[Inventory.getArray().size()]));
		invDisplay.setBounds(10, 13, 200, 417);
		contentPane.add(invDisplay);

		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem removeInv = new JMenuItem("Remove from Inv");
		removeInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory.checkAndRemove(invDisplay.getSelectedValue());
				updateInv(invDisplay);
			}
		});
		popupMenu.add(removeInv);
		addPopup(invDisplay, popupMenu);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(220, 13, 394, 417);
		contentPane.add(tabbedPane);

		JPanel furnacePanel = new JPanel();
		tabbedPane.addTab("Furnace", null, furnacePanel, null);
		furnacePanel.setLayout(null);

		final JComboBox<ItemType> smeltCombo = new JComboBox<ItemType>();
		smeltCombo.setModel(new DefaultComboBoxModel<ItemType>(ItemType.values()));
		smeltCombo.setBounds(10, 12, 270, 20);
		furnacePanel.add(smeltCombo);

		JButton smeltButton = new JButton("Smelt");
		smeltButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecipeManager.furnace(smeltCombo.getItemAt(smeltCombo.getSelectedIndex()));
				updateInv(invDisplay);
			}
		});
		smeltButton.setBounds(290, 11, 89, 23);
		furnacePanel.add(smeltButton);

		JPanel anvilPanel = new JPanel();
		tabbedPane.addTab("Anvil", null, anvilPanel, null);
		anvilPanel.setLayout(null);

		final JComboBox<ItemType> anvilTypeCombo = new JComboBox<ItemType>();
		anvilTypeCombo.setModel(new DefaultComboBoxModel<ItemType>(ItemType.values()));
		anvilTypeCombo.setBounds(10, 12, 125, 20);
		anvilPanel.add(anvilTypeCombo);

		final JComboBox<ItemTier> anvilTierCombo = new JComboBox<ItemTier>();
		anvilTierCombo.setModel(new DefaultComboBoxModel<ItemTier>(ItemTier.values()));
		anvilTierCombo.setBounds(145, 12, 125, 20);
		anvilPanel.add(anvilTierCombo);

		JButton forgeButton = new JButton("Forge");
		forgeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecipeManager.anvil(anvilTypeCombo.getItemAt(anvilTypeCombo.getSelectedIndex()), anvilTierCombo.getItemAt(anvilTierCombo.getSelectedIndex()));
				updateInv(invDisplay);
			}
		});
		forgeButton.setBounds(290, 11, 89, 23);
		anvilPanel.add(forgeButton);

		JPanel craftPanel = new JPanel();
		tabbedPane.addTab("Crafting", null, craftPanel, null);
		craftPanel.setLayout(null);

		final JComboBox<ItemType> craftCombo = new JComboBox<ItemType>();
		craftCombo.setModel(new DefaultComboBoxModel<ItemType>(ItemType.values()));
		craftCombo.setBounds(10, 12, 270, 20);
		craftPanel.add(craftCombo);

		JButton craftButton = new JButton("Craft");
		craftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecipeManager.craft(craftCombo.getItemAt(craftCombo.getSelectedIndex()));
				updateInv(invDisplay);
			}
		});
		craftButton.setBounds(290, 11, 89, 23);
		craftPanel.add(craftButton);

		JPanel finishingPanel = new JPanel();
		tabbedPane.addTab("Finishing Table", null, finishingPanel, null);
		finishingPanel.setLayout(null);

		JPanel enchantingPanel = new JPanel();
		tabbedPane.addTab("Enchanting Table", null, enchantingPanel, null);
		enchantingPanel.setLayout(null);

		JPanel adminPanel = new JPanel();
		tabbedPane.addTab("Admin", null, adminPanel, null);
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

		JButton addButton = new JButton("Add to Inv");
		addButton.setBounds(150, 42, 89, 23);
		adminPanel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory.add(new Item(typeBox.getItemAt(typeBox.getSelectedIndex()), tierBox.getItemAt(tierBox.getSelectedIndex()), stateBox.getItemAt(stateBox.getSelectedIndex())));
				invDisplay.setListData(Inventory.getArray().toArray(new Item[Inventory.getArray().size()]));
			}
		});
	}

	private static void updateInv(JList<Item> inv) {
		inv.setListData(Inventory.getArray().toArray(new Item[Inventory.getArray().size()]));
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
