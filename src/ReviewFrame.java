
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.ReviewController;
import service.Review;

public class ReviewFrame extends JFrame implements ActionListener{
	Review controller = new ReviewController();
	Container container = getContentPane();
	JLabel logo = new JLabel(new ImageIcon("img/logo.png"));
	JButton btn_search = new JButton(new ImageIcon("img/search.png"));
	JButton btn_cart = new JButton(new ImageIcon("img/cart.png"));
	ImageIcon imageIcon_T = new ImageIcon("img/로고.png");
	JPanel panel_all = new JPanel();
	JScrollPane scrollPane = new JScrollPane();
	JPanel panel_top = new JPanel();
	JPanel panel_top_title = new JPanel();
	JPanel panel_top_btn = new JPanel();
	JPanel panel_content = new JPanel();
	JPanel panel_content2 = new JPanel();
	JPanel panel_content3 = new JPanel();
	JPanel panel_center = new JPanel();
	String str = "";
	
	public ReviewFrame() {
		// Frame 기본설정
		setSize(400, 700);
		setTitle("올리버몰");
		setLocation(400, 200);
		str = controller.searchItemNo(3);
		init();
		start();
		setIconImage(imageIcon_T.getImage());
		setVisible(true);
	}
	private void init() {
		String[] review_strs = str.split("\t");
		int size = review_strs.length;
		String[] review_id = new String[size];
		String[] review_content = new String[size];
		JTextArea[] review_textAreas = new JTextArea[size];
		JScrollPane[] review_scrollPane = new JScrollPane[size];
		JLabel[] label_reviews = new JLabel[size];
		JPanel[] panel_content = new JPanel[size];
		container.add(scrollPane);
		scrollPane.setViewportView(panel_all);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		panel_all.setLayout(new BorderLayout(0, 30));
		panel_all.setBackground(Color.WHITE);
		panel_all.add("North", panel_top_title);
		panel_all.add("Center" , panel_center);
		
		panel_top_title.setLayout(new BorderLayout(10, 10));
		panel_top_title.setBackground(Color.WHITE);
		panel_top_title.add("West", logo);
		panel_top_title.add("East", panel_top_btn);
		panel_top_btn.setLayout(new GridLayout());
		panel_top_btn.setBackground(Color.WHITE);
		panel_top_btn.add(btn_cart);
		btn_search.setBorderPainted(false);
		btn_search.setContentAreaFilled(false);
		btn_cart.setBorderPainted(false);
		btn_cart.setContentAreaFilled(false);
		
		panel_center.setLayout(new GridLayout(5, 1, 0, 30));
		panel_center.setBackground(Color.WHITE);
		for(int i=0; i< size; i++) {
			int idx = review_strs[i].indexOf('\n');
			review_id[i] = review_strs[i].substring(0, idx);
			review_content[i] = review_strs[i].substring(idx, review_strs[i].length());
			panel_content[i].setBackground(Color.WHITE);
			panel_center.add(panel_content[i]);
			panel_content[i].setLayout(new BorderLayout());
		}
		for (int i = 0; i < size; i++) {
			label_reviews[i] = new JLabel(review_id[i]);
			panel_content[i].add("North", label_reviews[i]);
			label_reviews[i].setFont(new Font("굴림", Font.BOLD, 16));
			review_textAreas[i] = new JTextArea(review_content[i]);
			review_textAreas[i].setEditable(false);
			review_textAreas[i].setFont(new Font("굴림", Font.BOLD, 15));
			review_textAreas[i].setBorder(null);
			panel_content[i].add("Center", review_textAreas[i]);
		}



		
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
