
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.JoinImpl;
import controller.LoginImpl;
import dto.UsersDTO;
import service.Join;
import service.Login;

// 로그인 화면
public class LoginForm extends JFrame implements ActionListener {
	Container container = getContentPane();
	Font font1 = new Font("Garamond", Font.BOLD, 70);
	Font font2 = new Font("Palatino", Font.BOLD, 13);
	// 타이틀 바의 이미지를 가지는 객체
	ImageIcon imageIcon_T = new ImageIcon("img/로고.png");
	JPanel panel = new JPanel();
	JPanel panel_north = new JPanel();
	JPanel panel_south = new JPanel();
	JPanel panel_center = new JPanel();
	JPanel panel_center2 = new JPanel();

	JPanel p_title = new JPanel(); // 올리버몰 타이틀.
	JPanel p_label = new JPanel();
	JPanel p_labelid = new JPanel();
	JPanel p_labelpw = new JPanel();
	JPanel p_button = new JPanel();

	JLabel lb_title = new JLabel("Oliver\nMall");
	JLabel lb_id = new JLabel("I  D  : ");
	JLabel lb_pw = new JLabel("PW : ");
	JPanel panel_background = new JPanel() {
		// panel 배경 설정
		@Override
		public void paintComponent(Graphics g) {
			Image image = new ImageIcon("img/올리버몰.png").getImage();
			// Scale image to size of component
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false); // 투명하게
			super.paintComponent(g);
		}
	};

	JTextField tf_id = new JTextField(15);
	JPasswordField tf_pw = new JPasswordField(15);

	JButton bt_login = new JButton(" Login ");
	JButton bt_join = new JButton(" Sign up ");

	Login login = new LoginImpl();

	public LoginForm() {
		setIconImage(imageIcon_T.getImage());
		setSize(450, 700);
		setTitle("올리버몰");
		setLocation(400, 200);
		init();
		start();
		setVisible(true);
	}

	private void init() {

		container.setLayout(new BorderLayout());
		container.add("Center", panel_background);

		// frame 구성
		panel_background.setLayout(new GridLayout(4, 1, 0, 0));
		panel_background.add(panel_north);
		panel_background.add(panel_center);
		panel_background.add(panel_center2);
		panel_background.add(panel_south);

		// panel_north --> title
		panel_center.setLayout(new BorderLayout());
		panel_center.add("North", p_title);
		p_title.add(lb_title);
		lb_title.setFont(font1);
		lb_title.setForeground(new Color(85, 107, 47));
		// lb_title.setForeground(new Color(167, 204, 10));
		// lb_title.setForeground(new Color(154, 205, 50));

		// panel_south --> login
		panel_center2.setLayout(new BorderLayout());
		panel_center2.add("South", panel);

		panel.setLayout(new BorderLayout());
		panel.add(p_label);

		p_label.setLayout(new GridLayout(2, 1, 0, 1));
		p_label.add(p_labelid);
		p_label.add(p_labelpw);

		p_labelid.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_labelid.add(lb_id);
		p_labelid.add(tf_id);

		p_labelpw.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_labelpw.add(lb_pw);
		p_labelpw.add(tf_pw);

		panel_south.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_south.add(bt_login);
		panel_south.add(bt_join);
		bt_login.setBackground(new Color(145, 189, 51));
		bt_join.setBackground(new Color(145, 189, 51));
		bt_login.setForeground(Color.BLACK);
		bt_join.setForeground(Color.BLACK);
		bt_login.setFont(font2);
		bt_join.setFont(font2);
		bt_login.setPreferredSize(new Dimension(100, 30));
		bt_join.setPreferredSize(new Dimension(100, 30));

		panel_north.setBackground(new Color(255, 0, 0, 0));
		panel_center.setBackground(new Color(255, 0, 0, 0));
		panel_center2.setBackground(new Color(255, 0, 0, 0));
		panel_south.setBackground(new Color(255, 0, 0, 0));
		p_label.setBackground(new Color(255, 0, 0, 0));
		p_title.setBackground(new Color(255, 0, 0, 0));
		p_labelid.setBackground(new Color(255, 0, 0, 0));

		p_labelpw.setBackground(new Color(255, 0, 0, 0));

	}

	private void start() {
		// X버튼
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		bt_login.addActionListener(this);
		bt_join.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_login) {
			String id = tf_id.getText();
			String pw = tf_pw.getText();
			// 입력 검사
			if (id.equals("") || pw.equals("")) {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하시오");
				return; // 함수 강제 종료
			}

			UsersDTO dto = new UsersDTO();
			dto.setId(id);
			dto.setPw(pw);

			String result = login.inputLogin(dto);
			JOptionPane.showMessageDialog(this, result);
			// 화면 초기화
			tf_id.setText("");
			tf_pw.setText("");
			if (result.equals("환영합니다")) {
				new HomeFrame(99, dto.getId());
				setVisible(false);
			}
		} else if (e.getSource() == bt_join) {
			new JoinForm();
			setVisible(false);
		}

	}
}
