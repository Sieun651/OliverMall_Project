
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.ItemController;
import dto.UsersDTO;
import service.Item;

public class HomeFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	JLabel logo = new JLabel(new ImageIcon("img/logo.png"));
	JButton btn_search = new JButton(new ImageIcon("img/search.png"));
	JButton btn_cart = new JButton(new ImageIcon("img/cart.png"));
	JButton btn_order = new JButton(new ImageIcon("img/order.png"));
	JPanel panel_all = new JPanel();
	JScrollPane scrollPane = new JScrollPane();
	ImageIcon imageIcon_T = new ImageIcon("img/로고.png");
	JPanel panel_top = new JPanel();
	JPanel panel_top_title = new JPanel();
	JPanel panel_top_btn = new JPanel();
	JPanel panel_menu = new JPanel();
	JPanel panel_item = new JPanel();
	JPanel panel_item_image = new JPanel();
	JPanel panel_item_content = new JPanel();

	JButton[] categoryButtons = new JButton[4];
	JButton btn_home = new JButton("Home");
	String[] categoryStr = { "Skin", "Point", "Base", "Sun" };
	JTextField tf_search = new JTextField();

	Item controller = new ItemController();

	String str = "";
	int category;
	String userid;
	JButton[] item_btns;
	String[] item_nos;

	public HomeFrame() {
		// Frame 기본설정

		setSize(450, 700);
		setTitle("올리버몰");
		setLocation(400, 200);
		str = controller.read();
		init();
		start();
		setIconImage(imageIcon_T.getImage());
		setVisible(true);

	}

	public HomeFrame(int c) {
		category = c;
		// Frame 기본설정
		setSize(450, 700);
		setTitle("올리버몰");
		setLocation(400, 200);
		str = controller.readCategory(Integer.toString(category));
		init();
		start();
		setIconImage(imageIcon_T.getImage());
		setVisible(true);

	}

	public HomeFrame(String name) {
		// Frame 기본설정
		setSize(450, 700);
		setTitle("올리버몰");
		setLocation(400, 200);
		str = controller.searchName(name);
		init();
		start();
		setIconImage(imageIcon_T.getImage());
		setVisible(true);

	}

	public HomeFrame(int c, String id) {
		userid = id;
		// Frame 기본설정
		setSize(450, 700);
		setTitle("올리버몰");
		setLocation(400, 200);
		str = controller.read();
		init();
		start();
		setIconImage(imageIcon_T.getImage());
		setVisible(true);

	}

	private void init() {
		String[] item_strs = str.split("\t");
		if (str.equals(""))
			JOptionPane.showMessageDialog(this, "검색 결과가 없습니다.");
		int size = item_strs.length;
		item_nos = new String[size];
		JTextArea[] item_textAreas = new JTextArea[size];
		JScrollPane[] item_scrollPane = new JScrollPane[size];
		item_btns = new JButton[size];
		JPanel[] panel_items = new JPanel[size];

		container.add(scrollPane);
		scrollPane.setViewportView(panel_all);
		// 시작 스크롤 위치 변경, 실패
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		panel_all.setLayout(new BorderLayout());
		panel_all.setBackground(Color.WHITE);
		panel_all.add("North", panel_top);
		panel_all.add("Center", panel_item);

		panel_top.setLayout(new GridLayout(2, 1, 0, 5));
		panel_top.setBackground(Color.WHITE);
		panel_top.add(panel_top_title);
		panel_top.add(panel_menu);
		panel_top_title.setLayout(new BorderLayout(2, 10));
		panel_top_title.setBackground(Color.WHITE);
		panel_top_title.add("West", logo);
		panel_top_title.add("Center", tf_search);
		panel_top_title.add("East", panel_top_btn);
		panel_top_btn.setLayout(new GridLayout());
		panel_top_btn.setBackground(Color.WHITE);
		panel_top_btn.add(btn_search);
		panel_top_btn.add(btn_cart);
		panel_top_btn.add(btn_order);
		btn_search.setBorderPainted(false);
		btn_search.setContentAreaFilled(false);
		btn_cart.setBorderPainted(false);
		btn_cart.setContentAreaFilled(false);
		btn_order.setBorderPainted(false);
		btn_order.setContentAreaFilled(false);
		panel_menu.setLayout(new FlowLayout());
		panel_menu.add(btn_home);
		panel_menu.setBackground(Color.WHITE);
		btn_home.setBorderPainted(false);
		btn_home.setContentAreaFilled(false);
		btn_home.setFont(new Font("Arial", Font.BOLD, 14));
		btn_home.setPreferredSize(new Dimension(75, 40));
		for (int i = 0; i < 4; i++) {
			categoryButtons[i] = new JButton(categoryStr[i]);
			categoryButtons[i].setPreferredSize(new Dimension(70, 40));
			categoryButtons[i].setFont(new Font("Arial", Font.BOLD, 14));
			categoryButtons[i].setBorderPainted(false);
			categoryButtons[i].setContentAreaFilled(false);
			panel_menu.add(categoryButtons[i]);
		}
		panel_item.setLayout(new BorderLayout());
		panel_item.add("West", panel_item_image);
		panel_item.add("Center", panel_item_content);
		panel_item_content.setBackground(Color.WHITE);

		panel_item_image.setLayout(new GridLayout(size + 2, 1, 0, 10));
		panel_item_image.setBackground(Color.WHITE);

		for (int i = 0; i < size; i++) {
			if (item_strs[i].length() >= 5) {
				item_nos[i] = item_strs[i].substring(3, 5);
			}
		}
		for (int i = 0; i < size; i++) {
			item_btns[i] = new JButton(new ImageIcon("img/" + (item_nos[i]) + ".png"));
			item_btns[i].setBorderPainted(false);
			item_btns[i].setContentAreaFilled(false);
			item_btns[i].addActionListener(this);
			panel_item_image.add(item_btns[i]);
		}

		panel_item_content.setLayout(new GridLayout(size + 2, 1, 0, 10));
		for (int i = 0; i < size; i++) {
			item_textAreas[i] = new JTextArea(item_strs[i]);
			item_textAreas[i].setEditable(false);
			item_textAreas[i].setFont(new Font("HY견고딕 보통", Font.BOLD, 15));
			item_textAreas[i].setBorder(null);
			panel_item_content.add(item_textAreas[i]);

		}
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				scrollPane.getVerticalScrollBar().setValue(0);
			}
		};

		SwingUtilities.invokeLater(runnable);
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		for (int i = 0; i < 4; i++) {
			categoryButtons[i].addActionListener(this);
		}
		btn_home.addActionListener(this);
		btn_search.addActionListener(this);
		btn_order.addActionListener(this);
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new HomeFrame();
				setVisible(false);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == categoryButtons[0]) { // 스킨 케어
			new HomeFrame(1);
			setVisible(false);
		} else if (e.getSource() == categoryButtons[1]) { // 포인트 메이크업
			new HomeFrame(2);
			setVisible(false);
		} else if (e.getSource() == categoryButtons[2]) { // 베이스 메이크업
			new HomeFrame(3);
			setVisible(false);
		} else if (e.getSource() == categoryButtons[3]) { // 선케어
			new HomeFrame(4);
			setVisible(false);
		} else if (e.getSource() == btn_home) { // 홈
			new HomeFrame();
			setVisible(false);
		} else if (e.getSource() == btn_search) { // 검색
			String name = tf_search.getText();
			if (name.equals("")) {
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				return;
			}
			new HomeFrame(name);
			setVisible(false);
		} else if (e.getSource() == btn_order) { // 주문 내역
			new OrderFrame(userid);
			setVisible(false);
		}
		for (int i = 0; i < item_btns.length; i++) {
			if (e.getSource() == item_btns[i]) {// 상품별 클릭

				new ItemFrame(Integer.parseInt(item_nos[i]), userid);
			}

		}

	}

}
