

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.OrderImpl;
import service.Order;

public class OrderFrame extends JFrame{
	Container container = getContentPane();
	JPanel panel_north = new JPanel();

	// panel_center
	JPanel panel_center = new JPanel();

	// panel_label
	JPanel panel_label = new JPanel();
	JLabel label = new JLabel("주문내역", JLabel.CENTER);
	JLabel logo = new JLabel(new ImageIcon("img/logo.png"));
	JPanel panel_center2 = new JPanel();
	JPanel panel_orderadate = new JPanel();
	JLabel label_orderadate = new JLabel("    2024.03.07");
	JPanel panel_orderstauts = new JPanel();
	JLabel label_orderstatus = new JLabel("  배송완료");

	// panel_lb
	JPanel panel_lb = new JPanel();
	ImageIcon imageIcon = new ImageIcon("img/test.png");
	JLabel lb = new JLabel(new ImageIcon("img/test.png"));
	ImageIcon imageIcon_T = new ImageIcon("img/로고.png");
	// panel_info
	JPanel panel_info = new JPanel();

	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	Order order = new OrderImpl();
	JPanel panel_item_content = new JPanel();
	JPanel panel_item_image = new JPanel();
	String str = "";
	public OrderFrame(String id) {

		// Frame 기본 설정
		setSize(450, 700);
		setTitle("OrderForm");
		setLocation(400, 200);
		str = order.readId(id);
		init();
		start();
		setIconImage(imageIcon_T.getImage());
		setVisible(true);
	}

	private void init() {
		String[] item_strs = str.split("\t");
		int size = item_strs.length;
		String[] item_nos = new String[size];
		JTextArea[] item_textAreas = new JTextArea[size];
		JScrollPane[] item_scrollPane = new JScrollPane[size];
		JButton[] item_btns = new JButton[size];
		JPanel[] panel_items = new JPanel[size];
		
		container.setLayout(new BorderLayout(0, 10));
		container.add("North", panel_north);
		container.add("Center", panel_center);
		container.setBackground(Color.WHITE);
		panel_north.setLayout(new BorderLayout());
		panel_north.add("West", logo);
		panel_north.add("Center", panel_label);
		panel_north.setBackground(Color.white);

		panel_label.setBackground(new Color(154, 205, 50));
		panel_label.add(label);

		Font font = new Font("HY견고딕 보통", Font.BOLD, 20);
		label.setFont(font);

		panel_center.setLayout(new BorderLayout());
		//panel_center.add("North", panel_orderadate);
		//panel_center.add("West", panel_lb);
		panel_center.add("West", panel_item_image);
		panel_center.add("Center", panel_item_content);

		panel_item_content.setBackground(Color.white);
		//textArea.setText(str);
		//panel_center.add("Center", scrollPane);
		if(size<6) {
			panel_item_image.setLayout(new GridLayout(6, 1, 0, 10));
		} else {
			panel_item_image.setLayout(new GridLayout(size, 1, 0, 10));
		}
		
		panel_item_image.setBackground(Color.WHITE);
		
		
//		panel_orderadate.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panel_orderadate.add(label_orderadate);
//		panel_orderadate.setBackground(Color.white);
//		label_orderadate.setFont(new Font("HY견고딕 보통", Font.BOLD, 15));

		panel_lb.add(lb);
		panel_lb.setBackground(Color.white);

		if (size > 1) {
			for(int i=0; i< size; i++) {
				if (item_strs[i].length() >= 4) {
					item_nos[i] = item_strs[i].substring(0, 2);
				}
			}
			for (int i = 0; i < size; i++) {
				item_btns[i] = new JButton(new ImageIcon("img/"+(item_nos[i])+".png"));
				item_btns[i].setBorderPainted(false);
				item_btns[i].setContentAreaFilled(false);
				item_btns[i].setFocusPainted(false);
				panel_item_image.add(item_btns[i]);
			}
			if(size < 6) {
				panel_item_content.setLayout(new GridLayout(6, 1, 0, 10));
			} else {
				panel_item_content.setLayout(new GridLayout(size, 1, 0, 10));
			}
			
			for (int i = 0; i < size; i++) {
				item_textAreas[i] = new JTextArea(item_strs[i]);
				item_textAreas[i].setEditable(false);
				item_textAreas[i].setFont(new Font("HY견고딕 보통", Font.BOLD, 14));
				item_textAreas[i].setBorder(null);
				panel_item_content.add(item_textAreas[i]);
				
			}
		} else {

			JOptionPane.showMessageDialog(this, "주문내역이 없습니다.");
		}

		panel_info.setBackground(Color.white);


		panel_center2.setBackground(Color.white);


	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        logo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	new HomeFrame();
            	setVisible(false);
            }
        });
	}




}
