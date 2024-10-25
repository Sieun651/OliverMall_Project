
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.JoinImpl;
import dto.UsersDTO;
import service.Join;

public class JoinForm extends JFrame implements ActionListener {
	Container container = getContentPane();
	Font font = new Font("HY견고딕 보통", Font.BOLD, 20);
	Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
	Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
	
	// 타이틀 바의 이미지를 가지는 객체
	ImageIcon imageIcon_T = new ImageIcon("img/로고.png");

	// JLabel
	JLabel lb_title = new JLabel("회원가입");
	JLabel lb_title2 = new JLabel(" 정보를 입력해주세요");
	JLabel lb_name = new JLabel("  이름");
	JLabel lb_id = new JLabel("  아이디");
	JLabel lb_pw = new JLabel("  비밀번호");
	JLabel lb_tel = new JLabel("  전화번호");
	JLabel lb_email = new JLabel("  본인 확인 이메일");
	JLabel lb_gender = new JLabel("  성별");
	JLabel lb_birthdate = new JLabel("  생년월일");

	// JPanel
	JPanel p_North = new JPanel();
	JPanel p_Center = new JPanel();
	JPanel p_South = new JPanel();
	JPanel p_scroll = new JPanel();
	JPanel p_join = new JPanel();
	JPanel p_name = new JPanel();
	JPanel p_id = new JPanel();
	JPanel p_pw = new JPanel();
	JPanel p_tel = new JPanel();
	JPanel p_telcode = new JPanel();
	JPanel p_email = new JPanel();
	JPanel p_gender = new JPanel();
	JPanel p_genderrbt = new JPanel();
	JPanel p_birthdate = new JPanel();
	JPanel p_birthdatecode = new JPanel();
	JPanel p_button = new JPanel();

	// JTextField
	JTextField tf_name = new JTextField(15);
	JTextField tf_id = new JTextField(15);
	JPasswordField tf_pw = new JPasswordField(15);
	JTextField tf_tel = new JTextField(15);
	JTextField tf_email1 = new JTextField(30);
	JTextField tf_birthdate = new JTextField(15);

	// RadioButton
	JRadioButton rbt_boy = new JRadioButton("  남     ");
	JRadioButton rbt_girl = new JRadioButton("  여     ");

	ButtonGroup buttonGroup = new ButtonGroup();

	// South_button
	JButton bt_join = new JButton("  가입완료  ");
	JButton bt_Cancel = new JButton("    취소    ");

	Join join = new JoinImpl();

	public JoinForm() {
		setSize(450, 700);
		setTitle("올리버몰");
		setIconImage(imageIcon_T.getImage());
		setLocation(400, 200);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", p_North);
		container.add("Center", p_Center);
		container.add("South", p_South);

		// title
		p_North.add(lb_title);
		p_North.setBackground(new Color(167, 204, 10));
		lb_title.setFont(font);
		// Center_panel
		p_Center.setLayout(new GridLayout(7, 1, 0, 2));
		p_Center.add(p_name);
		p_Center.add(p_id);
		p_Center.add(p_pw);
		p_Center.add(p_tel);
		p_Center.add(p_email);
		p_Center.add(p_gender);
		p_Center.add(p_birthdate);

		// South_panel
		p_South.add(p_button);

		// Center_label
		p_name.setLayout(new GridLayout(2, 1, 0, 0));
		p_name.add(lb_name);
		p_name.add(tf_name);
		p_id.setLayout(new GridLayout(2, 1, 0, 0));
		p_id.add(lb_id);
		p_id.add(tf_id);
		p_pw.setLayout(new GridLayout(2, 1, 0, 0));
		p_pw.add(lb_pw);
		p_pw.add(tf_pw);

		p_tel.setLayout(new GridLayout(2, 1, 0, 0));
		p_tel.add(lb_tel);
		p_tel.add(p_telcode);
		p_telcode.setLayout(new GridLayout(1, 3, 5, 0));
		p_telcode.add(tf_tel);

		p_email.setLayout(new GridLayout(2, 1, 0, 0));
		p_email.add(lb_email);
		p_email.add(tf_email1);

		p_gender.setLayout(new GridLayout(2, 1, 0, 0));
		p_gender.add(lb_gender);
		p_gender.add(p_genderrbt);
		p_genderrbt.add(rbt_boy);
		p_genderrbt.add(rbt_girl);

		// button
		p_genderrbt.setLayout(new FlowLayout(FlowLayout.LEFT));
		p_button.add(bt_join);
		p_button.add(bt_Cancel);
		buttonGroup.add(rbt_boy);
		buttonGroup.add(rbt_girl);

		p_birthdate.setLayout(new GridLayout(2, 1, 0, 0));
		p_birthdate.add(lb_birthdate);
		p_birthdate.add(p_birthdatecode);
		p_birthdatecode.setLayout(new GridLayout(1, 3, 5, 0));
		p_birthdatecode.add(tf_birthdate);

		// label Font
		lb_title.setFont(font1);
		lb_title2.setFont(font1);
		lb_name.setFont(font1);
		lb_id.setFont(font1);
		lb_pw.setFont(font1);
		lb_tel.setFont(font1);
		lb_email.setFont(font1);
		lb_gender.setFont(font1);
		lb_birthdate.setFont(font1);

		// panel 배경
		p_Center.setBackground(Color.WHITE);
		p_South.setBackground(Color.WHITE);
		p_join.setBackground(Color.WHITE);
		p_name.setBackground(Color.WHITE);
		p_id.setBackground(Color.WHITE);
		p_pw.setBackground(Color.WHITE);
		p_tel.setBackground(Color.WHITE);
		p_telcode.setBackground(Color.WHITE);
		p_email.setBackground(Color.WHITE);
		p_gender.setBackground(Color.WHITE);
		p_genderrbt.setBackground(Color.WHITE);
		p_birthdate.setBackground(Color.WHITE);
		p_birthdatecode.setBackground(Color.WHITE);
		p_button.setBackground(Color.WHITE);
		rbt_boy.setBackground(Color.WHITE);
		rbt_girl.setBackground(Color.WHITE);

		// button 색
		bt_Cancel.setBackground(new Color(167, 204, 10));
		bt_join.setBackground(new Color(167, 204, 10));
		bt_Cancel.setForeground(Color.BLACK);
		bt_join.setForeground(Color.BLACK);
		bt_Cancel.setFont(font2);
		bt_join.setFont(font2);
	}

	private void start() {
		// X버튼
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		bt_join.addActionListener(this);
		bt_Cancel.addActionListener(this);
		rbt_boy.addActionListener(this);
		rbt_girl.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bt_join) {
			String name = tf_name.getText();
			String id = tf_id.getText();
			String pw = tf_pw.getText();
			String tel = tf_tel.getText();
			String gender = rbt_boy.isSelected() ? "남" : "여";
			String birth = tf_birthdate.getText();
			String email = tf_email1.getText();
			// 입력 검사
			if (id.equals("")) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하시오");
				return; // 함수 강제 종료
			} else if (pw.equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하시오.");
				return; // 함수 강제 종료
			} else if (name.equals("")) {
				JOptionPane.showMessageDialog(this, "이름을 입력하시오.");
				return; // 함수 강제 종료
			} else if (tel.equals("")) {
				JOptionPane.showMessageDialog(this, "전화번호 입력하시오.");
				return; // 함수 강제 종료
			} else if (birth.equals("")) {
				JOptionPane.showMessageDialog(this, "생년월일을 입력하시오.");
				return; // 함수 강제 종료
			} else if (email.equals("")) {
				JOptionPane.showMessageDialog(this, "이메일을 입력하시오.");
				return; // 함수 강제 종료
			}
			UsersDTO dto = new UsersDTO();
			dto.setName(name);
			dto.setId(id);
			dto.setPw(pw);
			dto.setTel(tel);
			dto.setGender(gender);
			dto.setBirth(birth);
			dto.setEmail(email);
			String result = join.join(dto);
			JOptionPane.showMessageDialog(this, result);
			if (result.equals("아이디가 생성되었습니다.")) {
				new LoginForm();
				setVisible(false);
			} else {
				tf_name.setText("");
				tf_id.setText("");
				tf_pw.setText("");
				tf_tel.setText("");
				tf_name.setText("");
				rbt_boy.setSelected(false);
				rbt_girl.setSelected(false);
				tf_birthdate.setText("");
				tf_email1.setText("");
			}
		} else if (e.getSource() == bt_Cancel) {
			new LoginForm(); // 로그인 창 열기
			setVisible(false);
		}
	}
}
