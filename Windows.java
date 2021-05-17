
package jtree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class Windows {
	JTree tree;
	Icon openIcon = new ImageIcon("open.png");
	Icon closedIcon = new ImageIcon("close.png");
	Icon leafIcon = new ImageIcon("leaf.png");

	public Windows() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		// Tạo JFrame
		JFrame f = new JFrame("Windows");
		// Tạo JTree
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("This PC", true);
		DefaultMutableTreeNode objects = new DefaultMutableTreeNode("3D Objects", true);
		DefaultMutableTreeNode anh = new DefaultMutableTreeNode("Ảnh", true);
		DefaultMutableTreeNode anh1 = new DefaultMutableTreeNode("Ảnh Doreamon", true);
		DefaultMutableTreeNode anh2 = new DefaultMutableTreeNode("Ảnh Pikachu", true);
		DefaultMutableTreeNode paint = new DefaultMutableTreeNode("Paint", true);
		DefaultMutableTreeNode desktop = new DefaultMutableTreeNode("Desktop", true);
		DefaultMutableTreeNode documents = new DefaultMutableTreeNode("Documents", true);
		DefaultMutableTreeNode downloads = new DefaultMutableTreeNode("Downloads", true);
		DefaultMutableTreeNode music = new DefaultMutableTreeNode("Music", true);
		DefaultMutableTreeNode pictures = new DefaultMutableTreeNode("Pictures", true);
		DefaultMutableTreeNode videos = new DefaultMutableTreeNode("Videos", true);
		root.add(objects);
		objects.add(anh);
		anh.add(anh1);
		anh.add(anh2);
		objects.add(paint);
		root.add(desktop);
		root.add(documents);
		root.add(downloads);
		root.add(music);
		root.add(pictures);
		root.add(videos);
		tree = new JTree(root);
		// Tạo MenuBar
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Computer");
		JMenu source = new JMenu("View");
		JMenuItem jNew = new JMenuItem("New");
		JMenuItem jExit = new JMenuItem("Exit");
		menubar.add(file);
		menubar.add(edit);
		menubar.add(source);
		file.add(jNew);
		file.addSeparator();
		file.add(jExit);
		f.setJMenuBar(menubar);

		// Thiết lập xử lý cho exit
//		jExit.setMnemonic(KeyEvent.VK_E);
		jNew.setAccelerator(KeyStroke.getKeyStroke("control N"));
		jExit.setAccelerator(KeyStroke.getKeyStroke("control E"));
		jExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
				f.dispose();

			}
		});
		jNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Windows();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
		tree.setScrollsOnExpand(false);
		renderer.setLeafIcon(leafIcon);
		tree.setShowsRootHandles(false);
		f.add(tree);
		f.setVisible(true);
		f.setSize(480, 360);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setTitle("Windows");
		f.setLocationRelativeTo(null);

	}

	public static void main(String[] args) throws IOException {
		try {
			// Giao diện look and feel theo Windows UI
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			new Windows();

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex) {
			System.out.println("ERROR : " + ex);
		}

	}
}
