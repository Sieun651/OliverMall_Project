

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import service.Item;
import controller.ItemController;
import dto.ItemDTO;
import dto.UsersDTO;

public class ItemFrame extends JFrame implements ActionListener {
	Item controller = new ItemController();
	ItemDTO dto = new ItemDTO();
	Container container = getContentPane();
	// 패널들
	JPanel panel = new JPanel();
	JPanel p_north = new JPanel();
	JPanel p_center = new JPanel();
	JPanel p_image = new JPanel();
	JPanel p_label = new JPanel();
	JPanel p_south = new JPanel();
	JPanel p_null = new JPanel();
	JPanel p_button = new JPanel();
	// 상단 이미지 버튼 선언
	ImageIcon imageIcon_T = new ImageIcon("img/로고.png");
	JButton btn_back = new JButton(new ImageIcon("img/left.gif"));
	JButton btn_search = new JButton(new ImageIcon("img/search.png"));
	JButton btn_cart = new JButton(new ImageIcon("img/cart.png"));
	JLabel logo = new JLabel(new ImageIcon("img/logo.png"));
	JButton btn_order = new JButton(new ImageIcon("img/order.png"));
	JButton btn_home = new JButton(new ImageIcon("img/logo.png"));
	// 검색창
	JTextArea textArea = new JTextArea("");
	// 상품 이미지, 상품명, 원가, 판매가, 할인혜택
	JTextArea taNull = new JTextArea();
	JButton btn_image = new JButton();
	JLabel l_null = new JLabel("   ");
	JLabel l_name = new JLabel("상품명");
	JLabel l_cost = new JLabel("상품가격");
	JLabel l_sale = new JLabel("상품할인가");
	JLabel l_profit = new JLabel("상품가격차이");
	//JLabel l_discount = new JLabel();
	// 할인 혜택 버튼
	JButton b_discount = new JButton("할인혜택");
	// 장바구니로 보내기 버튼
	JButton buttonCart = new JButton("장바구니");
	// 구매 버튼
    JButton purchaseButton = new JButton("구매하기");
	// 장바구니 관련
	DefaultListModel<String> model_cart = new DefaultListModel<>();
	JList<String> list_cart = new JList<>(model_cart);
	JScrollPane scrollPane_cart = new JScrollPane(list_cart);
	// 기타
	JTextPane textPane = new JTextPane();
	JScrollPane scrollPane = new JScrollPane(textPane);
	
	private ItemFrame itemFrame;
    private Item selectedItem;
    String userid;
	public ItemFrame(int itemno) {
		setSize(450, 700);
		setTitle("올리버몰");
		setLocation(400, 200);
		dto = controller.searchItemNo(itemno);
		init();
		start();
		setIconImage(imageIcon_T.getImage());
		setVisible(true);
	}
	public ItemFrame(int itemno, String id) {
		userid = id;
		setSize(450, 700);
		setTitle("올리버몰");
		setLocation(400, 200);
		dto = controller.searchItemNo(itemno);
		init();
		start();
		setIconImage(imageIcon_T.getImage());
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", p_north);
		container.add("Center", p_center);
		container.add("South", p_south);
		p_north.setBackground(Color.WHITE);
		p_center.setBackground(Color.WHITE);
		p_south.setBackground(Color.WHITE);
		p_north.setLayout(new BorderLayout());
		p_north.add("West", logo);
		p_north.add("East", p_button);
		p_button.setLayout(new FlowLayout());
		p_button.setBackground(Color.WHITE);
		p_button.add(btn_back);
		p_button.add(btn_cart);
		p_button.add(btn_order);
		btn_home.setBorderPainted(false);
		btn_home.setContentAreaFilled(false);
		btn_back.setBorderPainted(false);
		btn_back.setContentAreaFilled(false);
		btn_cart.setBorderPainted(false);
		btn_cart.setContentAreaFilled(false);
		btn_order.setBorderPainted(false);
		btn_order.setContentAreaFilled(false);
		p_center.setLayout(new BorderLayout());
		p_center.add("North", p_image);
		p_center.add("Center", p_label);
		p_center.add("South", p_null);
		p_null.add(taNull);
		p_null.setBackground(Color.WHITE);
		p_image.setLayout(new FlowLayout(FlowLayout.CENTER));
		// 이미지가 안나타남.
		int itemno = dto.getItemno();
		if(itemno<10) {
			btn_image = new JButton(new ImageIcon("img/"+"0"+Integer.toString(dto.getItemno())+".png"));
		} else {
			btn_image = new JButton(new ImageIcon("img/"+dto.getItemno()+".png"));
		}
		btn_image.setBorderPainted(false);
		btn_image.setContentAreaFilled(false);
		p_image.add(btn_image); 
		p_image.setBackground(Color.WHITE);
		p_label.setLayout(new BorderLayout()); // 3행 1열의 그리드 레이아웃 설정
		p_label.add("North", l_name); // 상품명 추가
		l_name.setText("▷"+dto.getName()+"◁");
		String kind = dto.getKind();
		String category = "";
		if(kind.equals("1")) {
			category = "스킨케어";
		} else if(kind.equals("2")) {
			category = "포인트 ";
		} else if(kind.equals("3")) {
			category = "베이스 ";
		} else if(kind.equals("4")) {
			category = "선케어 ";
		}
		String str = dto.getContent();
		String[] item_strs = str.split("\\\\n");
		// str 나누기 
		str = "  ";
		
		for(int i=0; i<item_strs.length; i++) {
			str += item_strs[i]+"\n  ";
		}
		
		textArea.setText("\n\t      "+category+"제품\n\n"
				+ "  정가: "+dto.getCost()+"원,  "+dto.getDiscount()+"원 할인중\n\n"+str);
		p_label.add("Center", textArea);
		p_label.add("South", l_sale); // 할인가 추가
		l_sale.setText("구매가: "+dto.getSale()+"원");
		textArea.setFont(new Font("나눔고딕", Font.BOLD,19));
		textArea.setEditable(false);
		l_name.setFont(new Font("나눔고딕", Font.BOLD,23));
		l_profit.setFont(new Font("나눔고딕", Font.BOLD, 20));
		l_cost.setFont(new Font("나눔고딕", Font.BOLD, 20));
		l_sale.setFont(new Font("나눔고딕", Font.BOLD, 30));
		l_name.setHorizontalAlignment(JLabel.CENTER);
		l_cost.setHorizontalAlignment(JLabel.CENTER);
		l_profit.setHorizontalAlignment(JLabel.CENTER);
		l_sale.setHorizontalAlignment(JLabel.CENTER);
		l_cost.setForeground(Color.GRAY);
		l_sale.setForeground(new Color(0, 103, 0));
		p_label.setBackground(Color.WHITE);
		p_south.setLayout(new GridLayout(1, 2));
		p_south.add(buttonCart); // 장바구니로 보내기
		p_south.add(purchaseButton); // 구매창 열기
		buttonCart.setContentAreaFilled(false);
		purchaseButton.setContentAreaFilled(false);

        // 결제 수단 선택
        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<String> paymentComboBox = new JComboBox<>(new String[]{"신용카드", "계좌이체", "휴대폰 결제"});
        paymentPanel.add(new JLabel("결제 수단:"));
        paymentPanel.add(paymentComboBox);

        // 구매 버튼
        JButton purchaseButton = new JButton("구매하기");
        purchaseButton.addActionListener(this);
//
//        // 레이아웃 구성
//        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
//        contentPane.add("North", infoPanel);
//        contentPane.add("Center", paymentPanel);
//        contentPane.add("South", purchaseButton);
//        setContentPane(contentPane);
	}

	private void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 버튼
		btn_back.addActionListener(this);
		btn_search.addActionListener(this);
		btn_home.addActionListener(this);
		btn_order.addActionListener(this);
		buttonCart.addActionListener(this);
		b_discount.addActionListener(this);
		purchaseButton.addActionListener(this);
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
		// 이벤트 처리 코드 작성
		if (e.getSource() == logo) { // 홈 이벤트처리
			dispose();
			// 전 단계로 가기
		} else if (e.getSource() == btn_back) { // 뒤로가기 이벤트처리
			 dispose();
		} else if (e.getSource() == btn_order) { // 주문내역
			new OrderFrame(userid);
			setVisible(false);
		} else if (e.getSource() == buttonCart) { // 상품 장바구니로 보내기 이벤트처리
			JOptionPane.showMessageDialog(this, "장바구니에 추가되었습니다.");
		} else if (e.getSource() == b_discount) { // 상품 할인혜택 이벤트처리
			// 할인 혜택 정보 보여주는 창 열기 등의 기능 추가
			//l_discount.setText("현재 상품 할인율 : " + "%");
			//JOptionPane.showMessageDialog(this, "30% 할인하고 있습니다.");
		} else if (e.getSource() == purchaseButton) { // 상품 구매하기 이벤트처리
			// 구매 관련 기능 추가
			
			JOptionPane.showMessageDialog(this, "구매가 완료되었습니다.");
		}
	}


}
