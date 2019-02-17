import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.font.TextAttribute;
//import java.sql.Connection;
//import java.sql.DriverManager;          not used
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.DuplicateFormatFlagsException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import java.awt.List;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import net.proteanit.sql.DbUtils;
import java.awt.Checkbox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Exam extends dbcon {
	boolean f = false;
	JLabel lbltotalM;
	String temp;
	static int num;
	private JFrame frmOnlineExam;
	private JTextField txtAdminid;
	private JPasswordField txtAdminpass;
	private JTextField txtAddSubjectId;
	private JTextField txtAddSubject;
	private JTextField txtAddQId;

	JComboBox cmbAddanswer;
	JComboBox cmbAddsubject;

	CardLayout cardlayout;
	CardLayout cardlayout2;

	private JTextField txtStudentLoginId;
	private JPasswordField txtStudentLoginPass;
	private JTextField txtStudentRegId;
	private JTextField txtStudentRegName;
	private JTextField txtStudentRegMono;
	private JTextField txtStudentRegEmail;
	private JTextField txtStudentRegPass;
	private JTextField txtStudentDetailId;
	private JTextField txtStudentDetailName;
	private JTextField txtStudentDetailMono;
	private JTextField txtStudentDetailEmail;
	private JTextArea textAreaStudentDetailAdd;

	private JTextArea QuestextArea;
	private JTextArea Opt_1textArea;
	private JTextArea Opt_2textArea;
	private JTextArea Opt_3textArea;
	private JTextArea Opt_4textArea;

	JButton btnLogout;

	List list;
	List list2;
	List bookmarklist;

	JLabel lbltestqid;
	JTextArea lblGetTQ;
	JTextArea l1;
	JTextArea l2;
	JTextArea l3;
	JTextArea l4;
	// JLabel lblqno ;

	ButtonGroup bg;
	JRadioButton opt1;
	JRadioButton opt2;
	JRadioButton opt3;
	JRadioButton opt4;

	JLabel lblgetStidTT;
	JLabel lblGetidT;
	JLabel lblGetsubT;
	JLabel lbltemp;

	JLabel lblMarks;
	JLabel lblProfile;
	JLabel lblLogout_1;
	JLabel lblTakeTest;
	JLabel lblGetnameM;
	JLabel lblGetidM;
	JLabel lblGetsubjectM;

	JTextArea textAreaStudentRegAddress;
	JTable viewQtable;
	JTable viewStdtable;
	JScrollPane ViewquesscrollPane;
	JScrollPane ViewStudentscrollPane;
	JScrollPane textAreaScroll;

	JPanel masterpanel_1;
	JPanel masterpanel_2;
	JPanel masterpanel_3;
	JPanel markspanel;

	static String result;
	int count = 0;
	int check;
	int Questionid;

	// Connection con;
	ResultSet rs;
	PreparedStatement ps;
	// Statement st;
	private JTable marktable;
	static int examtime;
	static int timecounter = 0;
	static int min = 0;
	Timer timer;
	TimerTask timerTask;
	JLabel lblSec;
	JLabel lblMin;
	private JTextField txtexamtime;
	private JTextField txtadminid;
	private JTextField txtadminpass;

	/*
	 * public void timer() { TimerTask timerTask = new TimerTask() {
	 * 
	 * 
	 * public void run() { // System.out.println("TimerTask executing counter is: "
	 * + counter); lblSec.setText(String.valueOf(timecounter));
	 * timecounter++;//increments the counter if(timecounter==60) { timecounter=1;
	 * min=Integer.parseInt(lblMin.getText());
	 * lblMin.setText(String.valueOf(min+1));
	 * 
	 * if(lblMin.getText().equals("1")) {
	 * 
	 * endexam(); //cardlayout2.show(masterpanel_2, "panelmark");
	 * 
	 * } }
	 * 
	 * } };
	 * 
	 * Timer timer = new Timer("MyTimer");//create a new Timer
	 * 
	 * timer.scheduleAtFixedRate(timerTask, 10, 1000);//this line starts the timer
	 * at the same time its executed
	 * 
	 * }
	 */

	public void m1() {
		dbconn();
		try {
			int maxid = 0;
			// con=DriverManager.getConnection(
			// "jdbc:mysql://localhost:3306/exam","root","admin");
			// st=con.createStatement();
			String qur3 = "select MAX(subid) from addsubject";
			// ps.setString(1, cmbAddsubject.getSelectedItem().toString());
			rs = st.executeQuery(qur3);
			while (rs.next()) {
				maxid = rs.getInt(1);
				txtAddSubjectId.setText(String.valueOf(maxid + 1));
				// System.out.println(maxid+1);
			}
			// st.close(); no operation allowed after statement close in method m2() so
			// don't close statement
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void m2() {
		dbconn();
		try {

			int maxid2 = 0;
			// con=DriverManager.getConnection(
			// "jdbc:mysql://localhost:3306/exam","root","admin");
			// st=con.createStatement();
			String qur4 = "select MAX(qid) from addquestion where subject='"
					+ cmbAddsubject.getSelectedItem().toString() + "'";

			rs = st.executeQuery(qur4);
			while (rs.next()) {
				maxid2 = rs.getInt(1);
				txtAddQId.setText(String.valueOf(maxid2 + 1));
				// System.out.println(maxid2+1);
			}
			// st.close();
			// con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void endexam() {
		dbconn();
		// timer.cancel();
		try {

			// Class.forName("com.mysql.jdbc.Driver");
			// con=DriverManager.getConnection(
			// "jdbc:mysql://localhost:3306/exam","root","admin");
			int i = 0, j = 0;
			while (i < list.getItemCount() && j < list2.getItemCount()) {
				ps = con.prepareStatement("select *  from addquestion where qid=? and answer=? ");
				ps.setString(1, list.getItem(i));
				ps.setString(2, list2.getItem(j));

				rs = ps.executeQuery();
				if (rs.next()) {
					count = count + 1;
					// System.out.println(count);
				}
				i++;
				j++;
			}
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			// System.out.println(dateFormat.format(date));
			String getdate = dateFormat.format(date);
			ps = con.prepareStatement("insert into mark values(?,?,?,?,?)");

			ps.setString(1, lblGetidT.getText());
			ps.setString(2, txtStudentDetailName.getText());
			ps.setString(3, lblGetsubT.getText());
			ps.setInt(4, count);
			ps.setString(5, getdate);
			ps.executeUpdate();
			{
				JOptionPane.showMessageDialog(null, "Exam End");
			}
			lblMarks.setVisible(true);
			lblProfile.setVisible(true);
			lblLogout_1.setVisible(true);
			lblTakeTest.setVisible(true);
			lbltotalM.setText(String.valueOf(count));

		}

		catch (Exception e4) {
			JOptionPane.showMessageDialog(null, e4);

		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam window = new Exam();
					window.frmOnlineExam.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Exam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmOnlineExam = new JFrame();
		frmOnlineExam.setFont(null);
		frmOnlineExam.setForeground(new Color(0, 255, 255));
		frmOnlineExam.setIconImage(Toolkit.getDefaultToolkit().getImage(Exam.class.getResource("/Images/exam.jpg")));
		frmOnlineExam.setTitle("ONLINE EXAM");
		// frmOnlineExam.getContentPane().setBackground(Color.BLUE); NO ANY COLOR BCZ
		// SETTING IMAGES
		// frmOnlineExam.getContentPane().setForeground(new Color(0, 0, 0));
		frmOnlineExam.setBounds(100, 100, 1366, 768);
		frmOnlineExam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOnlineExam.getContentPane().setLayout(null);

		masterpanel_1 = new JPanel();
		masterpanel_1.setBounds(218, 168, 955, 35);
		frmOnlineExam.getContentPane().add(masterpanel_1);
		masterpanel_1.setLayout(new CardLayout(0, 0));
		cardlayout = (CardLayout) masterpanel_1.getLayout();

		final JPanel masterpanel_2 = new JPanel();
		masterpanel_2.setBounds(208, 214, 973, 481);
		frmOnlineExam.getContentPane().add(masterpanel_2);
		masterpanel_2.setLayout(new CardLayout(0, 0));
		cardlayout2 = (CardLayout) masterpanel_2.getLayout();

		JLabel lblPortalimage = new JLabel("");
		lblPortalimage.setIcon(new ImageIcon(Exam.class.getResource("/Images/student exam. portal.png")));
		lblPortalimage.setBounds(208, 11, 973, 146);
		frmOnlineExam.getContentPane().add(lblPortalimage);

		JLabel lblNewLabel = new JLabel("portalImage 2");
		lblNewLabel.setIcon(new ImageIcon(Exam.class.getResource("/Images/bottom.png")));
		lblNewLabel.setBounds(166, 698, 973, 20);
		frmOnlineExam.getContentPane().add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		masterpanel_1.add(panel_1, "panel1");
		panel_1.setLayout(null);

		JButton btnhome = new JButton("HOME");
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout2.show(masterpanel_2, "panelHome");
			}
		});
		btnhome.setBounds(65, 0, 116, 34);
		panel_1.add(btnhome);

		JButton btnAbout = new JButton("ABOUT");
		btnAbout.setBounds(426, 0, 116, 34);
		panel_1.add(btnAbout);

		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout2.show(masterpanel_2, "panelStudentRegistration");
			}
		});
		btnRegister.setBounds(765, 0, 116, 34);
		panel_1.add(btnRegister);

		/*
		 * btnLogout = new JButton("LOGOUT"); btnLogout.setVisible(false);
		 * btnLogout.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * examtime=Integer.parseInt(txtexamtime.getText());
		 * cardlayout2.show(masterpanel_2, "panelHome"); } }); btnLogout.setBounds(811,
		 * 0, 116, 34); panel_1.add(btnLogout);
		 */

		JPanel panel_2 = new JPanel();
		masterpanel_1.add(panel_2, "panel2");
		panel_2.setLayout(null);

		JLabel lblAddSubject = new JLabel("ADD SUBJECT");
		lblAddSubject.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				cardlayout2.show(masterpanel_2, "panelAddSubject");
			}
		});
		lblAddSubject.setBounds(20, 0, 98, 34);
		panel_2.add(lblAddSubject);

		JLabel lblAddQuestion = new JLabel("ADD QUESTION");
		lblAddQuestion.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				cardlayout2.show(masterpanel_2, "panelAddQuestion");
				Exam.this.m2();
			}
		});
		lblAddQuestion.setBounds(162, 0, 106, 34);
		panel_2.add(lblAddQuestion);

		JLabel lblViewQuestion = new JLabel("VIEW QUESTION");
		lblViewQuestion.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				cardlayout2.show(masterpanel_2, "panelViewQuestion");
				dbconn();
				try {
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");

					PreparedStatement ps = con.prepareStatement("select *  from addquestion ORDER BY subject");
					rs = ps.executeQuery();

					// while(rs.next())

					{
						viewQtable.setModel(DbUtils.resultSetToTableModel(rs));

					}

					rs.close();
					con.close();
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, exp);
				}
			}
		});
		lblViewQuestion.setBounds(310, 0, 118, 34);
		panel_2.add(lblViewQuestion);

		JLabel lblViewMark = new JLabel("VIEW MARK");
		lblViewMark.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				dbconn();
				cardlayout2.show(masterpanel_2, "panelmarkadminview");
				try {
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");
					ps = con.prepareStatement("select *  from mark ORDER BY sid");
					rs = ps.executeQuery();

					// while(rs.next())

					{
						marktable.setModel(DbUtils.resultSetToTableModel(rs));

					}
					rs.close();
					con.close();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, exc);
				}
			}
		});
		lblViewMark.setBounds(438, 0, 98, 34);
		panel_2.add(lblViewMark);

		JLabel lblViewStudent = new JLabel("VIEW STUDENT");
		lblViewStudent.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				cardlayout2.show(masterpanel_2, "panelViewStudent");
				dbconn();
				try {
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");

					PreparedStatement ps = con
							.prepareStatement("select *  from studentregistration ORDER BY studentid");
					rs = ps.executeQuery();

					// if(rs.next())

					{
						viewStdtable.setModel(DbUtils.resultSetToTableModel(rs));

					}

					st.close();
					con.close();
				} catch (Exception exp) {

				}
			}
		});
		lblViewStudent.setBounds(575, 0, 92, 34);
		panel_2.add(lblViewStudent);

		JLabel lblLogout = new JLabel("LOGOUT");
		lblLogout.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				cardlayout.show(masterpanel_1, "panel1");
				cardlayout2.show(masterpanel_2, "panelHome");
			}
		});
		lblLogout.setBounds(865, 0, 98, 34);
		panel_2.add(lblLogout);

		JLabel lblNewAdmin = new JLabel("NEW ADMIN");
		lblNewAdmin.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				cardlayout2.show(masterpanel_2, "pnlmakeadmin");

			}
		});
		lblNewAdmin.setBounds(737, 0, 92, 34);
		panel_2.add(lblNewAdmin);

		JPanel panel_3 = new JPanel();
		masterpanel_1.add(panel_3, "panel3");
		panel_3.setLayout(null);

		lblProfile = new JLabel("PROFILE");
		lblProfile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				cardlayout2.show(masterpanel_2, "panelStudentProfile");
			}
		});
		lblProfile.setBounds(26, 0, 93, 35);
		panel_3.add(lblProfile);

		lblTakeTest = new JLabel("TAKE TEST");
		lblTakeTest.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				list.removeAll();
				list2.removeAll();
				bookmarklist.removeAll();
				count = 0;
				cardlayout2.show(masterpanel_2, "paneltakeATest");
				String id = txtStudentDetailId.getText();
				lblgetStidTT.setText(id);
			}
		});
		lblTakeTest.setBounds(258, 0, 117, 35);
		panel_3.add(lblTakeTest);

		lblMarks = new JLabel("MARKS");
		lblMarks.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				cardlayout2.show(masterpanel_2, "panelmark");
				lbltotalM.setText(String.valueOf(count));
			}
		});
		lblMarks.setBounds(558, 0, 117, 35);
		panel_3.add(lblMarks);

		lblLogout_1 = new JLabel("LOGOUT");
		lblLogout_1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				cardlayout2.show(masterpanel_2, "panelHome");
			}
		});
		lblLogout_1.setBounds(852, 0, 111, 35);
		panel_3.add(lblLogout_1);

		JPanel Homepanel = new JPanel();
		masterpanel_2.add(Homepanel, "panelHome");
		Homepanel.setLayout(null);

		JButton btnAdminLogin = new JButton("");

		btnAdminLogin.setIcon(new ImageIcon(Exam.class.getResource("/Images/adm log.png"))); // set icon to Admin button
		btnAdminLogin.setBorder(null);
		// btnAdminLogin.setOpaque(false);
		btnAdminLogin.setBorderPainted(false);
		btnAdminLogin.setContentAreaFilled(false);

		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout2.show(masterpanel_2, "panelAdmin");
			}
		});
		btnAdminLogin.setBounds(137, 158, 229, 193);
		Homepanel.add(btnAdminLogin);

		JButton btnStudentLogin = new JButton("");
		btnStudentLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(masterpanel_1, "panel1");
				cardlayout2.show(masterpanel_2, "panelStudentLogin");
			}
		});
		btnStudentLogin.setIcon(new ImageIcon(Exam.class.getResource("/Images/std log.png"))); // set icon to student
																								// button
		btnStudentLogin.setBorder(null);
		btnStudentLogin.setContentAreaFilled(false);
		// btnStudentLogin.setOpaque(false);
		btnStudentLogin.setBounds(584, 158, 229, 193);
		Homepanel.add(btnStudentLogin);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setForeground(Color.RED);
		lblLogin.setBounds(445, 72, 96, 26);
		Homepanel.add(lblLogin);
		
				JLabel lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setBounds(-82, -217, 1376, 879);
				Homepanel.add(lblNewLabel_1);
				lblNewLabel_1.setIcon(new ImageIcon(Exam.class.getResource("/Images/blue_wave-wide.jpg")));

		JPanel AdminLoginpanel = new JPanel();
		masterpanel_2.add(AdminLoginpanel, "panelAdmin");
		AdminLoginpanel.setLayout(null);

		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdminLogin.setForeground(Color.RED);
		lblAdminLogin.setBounds(331, 95, 124, 27);
		AdminLoginpanel.add(lblAdminLogin);

		JLabel lblId = new JLabel("ID :-");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(262, 170, 63, 27);
		AdminLoginpanel.add(lblId);

		txtAdminid = new JTextField();
		txtAdminid.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtAdminid.setBounds(374, 167, 124, 20);
		AdminLoginpanel.add(txtAdminid);
		txtAdminid.setColumns(10);

		JLabel lblpassword = new JLabel("PASSWORD :-");
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblpassword.setBounds(262, 225, 102, 14);
		AdminLoginpanel.add(lblpassword);

		txtAdminpass = new JPasswordField();
		txtAdminpass.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtAdminpass.setBounds(374, 222, 124, 20);
		AdminLoginpanel.add(txtAdminpass);
		txtAdminpass.setColumns(10);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconn();
				try {
					// Class.forName("com.mysql.jdbc.Driver");
					// con =
					// DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","admin");
					// st = (Statement) con.createStatement();

					String qur = "select * from adminlogin where username=? and password=?";
					ps = con.prepareStatement(qur);
					ps.setString(1, txtAdminid.getText());
					ps.setString(2, txtAdminpass.getText());
					rs = ps.executeQuery();
					if (rs.next()) {
						cardlayout.show(masterpanel_1, "panel2");
						cardlayout2.show(masterpanel_2, "panelAddSubject");
						txtAdminid.setText("");
						txtAdminpass.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Plz Check Id And Password");
					}

					Exam.this.m1(); // auto increment Subject id

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnSubmit.setBounds(348, 273, 124, 23);
		AdminLoginpanel.add(btnSubmit);

		JPanel AddSubjectpanel = new JPanel();
		masterpanel_2.add(AddSubjectpanel, "panelAddSubject");
		AddSubjectpanel.setLayout(null);

		JLabel lblAddSubject_1 = new JLabel("ADD SUBJECT");
		lblAddSubject_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddSubject_1.setForeground(Color.RED);
		lblAddSubject_1.setBounds(359, 81, 122, 14);
		AddSubjectpanel.add(lblAddSubject_1);

		JLabel lblSubjectId = new JLabel("SUBJECT ID :-");
		lblSubjectId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubjectId.setBounds(243, 133, 106, 17);
		AddSubjectpanel.add(lblSubjectId);

		txtAddSubjectId = new JTextField();
		txtAddSubjectId.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtAddSubjectId.setBounds(359, 130, 122, 20);
		AddSubjectpanel.add(txtAddSubjectId);
		txtAddSubjectId.setColumns(10);
		txtAddSubjectId.setEditable(false);

		JLabel lblSubject = new JLabel("SUBJECT :-");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubject.setBounds(243, 174, 89, 17);
		AddSubjectpanel.add(lblSubject);

		txtAddSubject = new JTextField();
		txtAddSubject.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtAddSubject.setBounds(359, 171, 122, 20);
		AddSubjectpanel.add(txtAddSubject);
		txtAddSubject.setColumns(10);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconn();
				try {
					// Class.forName("com.mysql.jdbc.Driver");
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");
					// st=con.createStatement();
					ps = con.prepareStatement("insert into addsubject values(?,?)");
					ps.setString(1, txtAddSubjectId.getText());
					ps.setString(2, txtAddSubject.getText());
					ps.executeUpdate();

					JOptionPane.showMessageDialog(null, "Subject Added Successfully");

					txtAddSubjectId.setText("");
					txtAddSubject.setText("");
					Exam.this.m1();

					st.close();
					con.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnAdd.setBounds(370, 213, 89, 23);
		AddSubjectpanel.add(btnAdd);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subject;
				subject = txtAddSubject.getText();

				if (subject.equals("")) {
					JOptionPane.showMessageDialog(null, "Plz Check Subject To Delete");
				} else {
					int conf = JOptionPane.showConfirmDialog(null, "Are you sure?", "To Subject Delete",
							JOptionPane.YES_NO_OPTION);
					if (conf == 0) {
						String sql = "DELETE FROM addsubject WHERE subject=? ";
						dbconn();
						try {

							// Class.forName("com.mysql.jdbc.Driver");
							// con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","admin");
							ps = con.prepareStatement(sql);
							ps.setString(1, subject);
							int i = ps.executeUpdate();

							JOptionPane.showMessageDialog(null, "SUBJECT DELETED");
							txtAddSubject.setText("");
						}

						catch (Exception e2) {
							JOptionPane.showConfirmDialog(null, e2);
						}
					}

					else {
						JOptionPane.showMessageDialog(null, "CANCLED");
					}
				}
			}
		});
		btnDelete.setBounds(370, 256, 89, 23);
		AddSubjectpanel.add(btnDelete);

		JPanel AddQuestionpanel = new JPanel();
		masterpanel_2.add(AddQuestionpanel, "panelAddQuestion");
		AddQuestionpanel.setLayout(null);

		JLabel lblAddQuestion_1 = new JLabel("ADD QUESTION");
		lblAddQuestion_1.setForeground(Color.RED);
		lblAddQuestion_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddQuestion_1.setBounds(354, 11, 134, 14);
		AddQuestionpanel.add(lblAddQuestion_1);

		cmbAddanswer = new JComboBox();
		cmbAddanswer.setFont(new Font("Tahoma", Font.BOLD, 13));
		cmbAddanswer.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4" }));
		cmbAddanswer.setBounds(354, 453, 49, 20);
		AddQuestionpanel.add(cmbAddanswer);

		JLabel lblQuestionId = new JLabel("QUESTION  ID :-");
		lblQuestionId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuestionId.setBounds(233, 36, 95, 17);
		AddQuestionpanel.add(lblQuestionId);

		txtAddQId = new JTextField();
		txtAddQId.setEditable(false);
		txtAddQId.setBounds(354, 36, 75, 20);
		AddQuestionpanel.add(txtAddQId);
		txtAddQId.setColumns(10);

		final JComboBox comboBoxqid = new JComboBox();
		comboBoxqid.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				dbconn();
				try {
					comboBoxqid.removeAllItems();
					// Class.forName("com.mysql.jdbc.Driver");
					// con =
					// DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","admin");
					// st = (Statement) con.createStatement();

					String qur = "select DISTINCT qid from addquestion where subject=?";
					ps = (PreparedStatement) con.prepareStatement(qur);
					ps.setString(1, cmbAddsubject.getSelectedItem().toString());

					rs = ps.executeQuery();
					while (rs.next()) {
						comboBoxqid.addItem(rs.getString("qid"));
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});

		comboBoxqid.setBounds(439, 36, 49, 20);
		AddQuestionpanel.add(comboBoxqid);

		JLabel lblSubject_1 = new JLabel("SUBJECT :-");
		lblSubject_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubject_1.setBounds(233, 64, 89, 23);
		AddQuestionpanel.add(lblSubject_1);

		cmbAddsubject = new JComboBox();
		dbconn();
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","admin");
			// st = (Statement) con.createStatement();

			String qur = "select DISTINCT subject from addsubject";
			ps = (PreparedStatement) con.prepareStatement(qur);

			rs = ps.executeQuery();
			while (rs.next()) {
				cmbAddsubject.addItem(rs.getString("subject"));
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		cmbAddsubject.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				m2();
			}
		});
		cmbAddsubject.setBounds(354, 67, 134, 20);
		AddQuestionpanel.add(cmbAddsubject);

		JLabel lblQuestion = new JLabel("QUESTION :-");
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuestion.setBounds(233, 114, 89, 20);
		AddQuestionpanel.add(lblQuestion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(354, 90, 544, 60);
		AddQuestionpanel.add(scrollPane);

		QuestextArea = new JTextArea();
		scrollPane.setViewportView(QuestextArea);

		JLabel lblOption_1 = new JLabel("OPTION 1 :-");
		lblOption_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOption_1.setBounds(233, 184, 89, 23);
		AddQuestionpanel.add(lblOption_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(354, 168, 544, 60);
		AddQuestionpanel.add(scrollPane_1);

		Opt_1textArea = new JTextArea();
		scrollPane_1.setViewportView(Opt_1textArea);

		JLabel lblOption_2 = new JLabel("OPTION 2 :-");
		lblOption_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOption_2.setBounds(233, 252, 89, 23);
		AddQuestionpanel.add(lblOption_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(354, 235, 544, 60);
		AddQuestionpanel.add(scrollPane_2);

		Opt_2textArea = new JTextArea();
		scrollPane_2.setViewportView(Opt_2textArea);

		JLabel lblOption_3 = new JLabel("OPTION 3 :-");
		lblOption_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOption_3.setBounds(233, 313, 89, 20);
		AddQuestionpanel.add(lblOption_3);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(354, 306, 544, 60);
		AddQuestionpanel.add(scrollPane_3);

		Opt_3textArea = new JTextArea();
		scrollPane_3.setViewportView(Opt_3textArea);

		JLabel lblOption_4 = new JLabel("OPTION 4 :-");
		lblOption_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOption_4.setBounds(233, 377, 89, 23);
		AddQuestionpanel.add(lblOption_4);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(354, 377, 544, 60);
		AddQuestionpanel.add(scrollPane_4);

		Opt_4textArea = new JTextArea();
		scrollPane_4.setViewportView(Opt_4textArea);

		JLabel lblAnswer = new JLabel("ANSWER :-");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnswer.setBounds(233, 456, 89, 19);
		AddQuestionpanel.add(lblAnswer);

		JButton btnAddQuestion = new JButton("ADD");
		btnAddQuestion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id, subject, question, opt1, opt2, opt3, opt4, ans;

					id = txtAddQId.getText();
					subject = cmbAddsubject.getSelectedItem().toString();
					question = QuestextArea.getText();
					opt1 = Opt_1textArea.getText();
					opt2 = Opt_2textArea.getText();
					opt3 = Opt_3textArea.getText();
					opt4 = Opt_4textArea.getText();
					ans = cmbAddanswer.getSelectedItem().toString();

					if (id.equals("") || subject.equals("") || question.equals("") || opt1.equals("") || opt2.equals("")
							|| opt3.equals("") || opt4.equals("") || ans.equals("")) {
						JOptionPane.showMessageDialog(null, "plz fill all field");
					}

					else {
						dbconn();
						// Class.forName("com.mysql.jdbc.Driver");
						// con=DriverManager.getConnection(
						// "jdbc:mysql://localhost:3306/exam","root","admin");
						// st=con.createStatement();
						ps = con.prepareStatement("insert into addquestion values(?,?,?,?,?,?,?,?)");

						ps.setString(1, id);
						ps.setString(2, subject);
						ps.setString(3, question);
						ps.setString(4, opt1);
						ps.setString(5, opt2);
						ps.setString(6, opt3);
						ps.setString(7, opt4);
						ps.setString(8, ans);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Question Added Successfully");
						txtAddQId.setText("");
						QuestextArea.setText("");
						Opt_1textArea.setText("");
						Opt_2textArea.setText("");
						Opt_3textArea.setText("");
						Opt_4textArea.setText("");

						Exam.this.m2();

						st.close();
						con.close();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});

		btnAddQuestion.setBounds(408, 452, 75, 23);
		AddQuestionpanel.add(btnAddQuestion);

		JButton btnDeleteAllQ = new JButton("DELETE ALL");
		btnDeleteAllQ.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeleteAllQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subject, qid;
				subject = cmbAddsubject.getSelectedItem().toString();
				qid = comboBoxqid.getSelectedItem().toString();

				if (subject.equals("") || qid.equals("")) {
					JOptionPane.showMessageDialog(null, "Plz Check Subject To Delete");
				} else {
					int conf = JOptionPane.showConfirmDialog(null, "Are you sure?", "To Question Delete",
							JOptionPane.YES_NO_OPTION);
					if (conf == 0) {
						dbconn();
						try {
							// Class.forName("com.mysql.jdbc.Driver");
							// con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","admin");
							String sql = "DELETE FROM addquestion WHERE subject=?";
							ps = con.prepareStatement(sql);
							ps.setString(1, subject);
							// ps.setString(2, qid);
							int i = ps.executeUpdate();

							JOptionPane.showMessageDialog(null, "QUESTION DELETED");

						}

						catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2);
						}
					}

					else {
						JOptionPane.showMessageDialog(null, "CANCLED");
					}
				}
			}
		});
		btnDeleteAllQ.setBounds(489, 452, 107, 23);
		AddQuestionpanel.add(btnDeleteAllQ);

		JButton btnUpdateQ = new JButton("UPDATE");
		btnUpdateQ.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdateQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconn();
				try {
					// Class.forName("com.mysql.jdbc.Driver");
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");
					// st=con.createStatement();

					String qid = comboBoxqid.getSelectedItem().toString();
					String subject = cmbAddsubject.getSelectedItem().toString();
					String ques = QuestextArea.getText();
					String opt1 = Opt_1textArea.getText();
					String opt2 = Opt_2textArea.getText();
					String opt3 = Opt_3textArea.getText();
					String opt4 = Opt_4textArea.getText();
					String ans = cmbAddanswer.getSelectedItem().toString();

					String sql = "update addquestion set question=?,opt1=?,opt2=?,opt3=?,opt4=?,answer=? where qid=? and subject=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, ques);
					ps.setString(2, opt1);
					ps.setString(3, opt2);
					ps.setString(4, opt3);
					ps.setString(5, opt4);
					ps.setString(6, ans);
					ps.setString(7, qid);
					ps.setString(8, subject);
					int update = ps.executeUpdate();
					if (update > 0) {
						JOptionPane.showMessageDialog(null, "updated");
					}

				} catch (Exception e3) {
					JOptionPane.showConfirmDialog(null, e3);
				}
			}
		});

		JButton btnSearchQ = new JButton("SEARCH");
		btnSearchQ.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearchQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconn();
				try {
					String qid = comboBoxqid.getSelectedItem().toString();
					String subject = cmbAddsubject.getSelectedItem().toString();
					// Class.forName("com.mysql.jdbc.Driver");
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");
					// st=con.createStatement();

					String qur = "select * from addquestion where qid=? and subject=?";
					ps = con.prepareStatement(qur);
					ps.setString(1, qid);
					ps.setString(2, subject);

					rs = ps.executeQuery();
					if (rs.next()) {
						QuestextArea.setText(rs.getString("question"));
						Opt_1textArea.setText(rs.getString("opt1"));
						Opt_2textArea.setText(rs.getString("opt2"));
						Opt_3textArea.setText(rs.getString("opt3"));
						Opt_4textArea.setText(rs.getString("opt4"));
						cmbAddanswer.setSelectedItem(rs.getString("answer"));

					} else {
						JOptionPane.showMessageDialog(null, "No Record Found");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnSearchQ.setBounds(600, 452, 89, 23);
		AddQuestionpanel.add(btnSearchQ);
		btnUpdateQ.setBounds(809, 452, 89, 23);
		AddQuestionpanel.add(btnUpdateQ);

		JLabel lblRefresh = new JLabel("REFRESH");
		lblRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRefresh.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				try {
					dbconn();
					// Class.forName("com.mysql.jdbc.Driver");
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");
					// st=con.createStatement();
					String qur = "select * from addquestion ";
					ps = con.prepareStatement(qur);
					String qur2 = "select * from addsubject ";
					ps = con.prepareStatement(qur2);
					rs = ps.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "ok");
					}

				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, exc);
				}
			}
		});
		lblRefresh.setBounds(761, 39, 75, 17);
		AddQuestionpanel.add(lblRefresh);

		JLabel lblClear = new JLabel("CLEAR");
		lblClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClear.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				QuestextArea.setText("");
				Opt_1textArea.setText("");
				Opt_2textArea.setText("");
				Opt_3textArea.setText("");
				Opt_4textArea.setText("");

			}
		});
		lblClear.setBounds(846, 36, 60, 20);
		AddQuestionpanel.add(lblClear);

		JLabel lblExamTime = new JLabel("EXAM TIME");
		lblExamTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExamTime.setBounds(606, 38, 95, 18);
		AddQuestionpanel.add(lblExamTime);

		txtexamtime = new JTextField();
		txtexamtime.setText("30"); // Default Exam Time 30 Min.
		txtexamtime.setBounds(606, 66, 38, 20);
		AddQuestionpanel.add(txtexamtime);
		txtexamtime.setColumns(10);

		JLabel lblMin_1 = new JLabel("Min.");
		lblMin_1.setBounds(654, 69, 61, 14);
		AddQuestionpanel.add(lblMin_1);

		JButton btnNewButton = new JButton("Delete One");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String subject, qid;
				subject = cmbAddsubject.getSelectedItem().toString();
				qid = comboBoxqid.getSelectedItem().toString();

				if (subject.equals("") || qid.equals("")) {
					JOptionPane.showMessageDialog(null, "Plz Check Subject To Delete");
				} else {
					int conf = JOptionPane.showConfirmDialog(null, "Are you sure?", "To Question Delete",
							JOptionPane.YES_NO_OPTION);
					if (conf == 0) {
						dbconn();
						try {
							// Class.forName("com.mysql.jdbc.Driver");
							// con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","admin");
							String sql = "DELETE FROM addquestion WHERE subject=? and qid=?";
							ps = con.prepareStatement(sql);
							ps.setString(1, subject);
							ps.setString(2, qid);
							int i = ps.executeUpdate();

							JOptionPane.showMessageDialog(null, "QUESTION DELETED");

						}

						catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2);
						}
					}

					else {
						JOptionPane.showMessageDialog(null, "CANCLED");
					}
				}
			}
		});
		btnNewButton.setBounds(692, 452, 113, 23);
		AddQuestionpanel.add(btnNewButton);

		JPanel ViewQuestionpanel = new JPanel();
		masterpanel_2.add(ViewQuestionpanel, "panelViewQuestion");
		ViewQuestionpanel.setLayout(null);

		ViewquesscrollPane = new JScrollPane();
		viewQtable = new JTable();
		viewQtable.setFont(new Font("Monospaced", Font.PLAIN, 18));
		viewQtable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		viewQtable.setRowHeight(30);

		ViewquesscrollPane = new JScrollPane(viewQtable); // Jtable object passing to JScrollpane
		ViewquesscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		ViewquesscrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ViewquesscrollPane.setBounds(10, 11, 953, 438);
		ViewQuestionpanel.add(ViewquesscrollPane);

		JTableHeader Theader = viewQtable.getTableHeader();
		Theader.setFont(new Font("Tahome", Font.BOLD, 20));

		JPanel ViewMarkspanel = new JPanel();
		masterpanel_2.add(ViewMarkspanel, "panelViewMark");
		ViewMarkspanel.setLayout(null);

		JScrollPane ViewMarksscrollPane = new JScrollPane();
		ViewMarksscrollPane.setBounds(10, 11, 953, 438);
		ViewMarkspanel.add(ViewMarksscrollPane);

		JPanel ViewStudentpanel = new JPanel();
		masterpanel_2.add(ViewStudentpanel, "panelViewStudent");
		ViewStudentpanel.setLayout(null);

		ViewStudentscrollPane = new JScrollPane();
		viewStdtable = new JTable();
		viewStdtable.setFont(new Font("Monospaced", Font.PLAIN, 18));
		viewStdtable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		viewStdtable.setRowHeight(30);

		ViewStudentscrollPane = new JScrollPane(viewStdtable); // Jtable object passing to JScrollpane
		ViewStudentscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		ViewStudentscrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ViewStudentscrollPane.setBounds(10, 11, 953, 438);
		ViewStudentpanel.add(ViewStudentscrollPane);

		JPanel StudentLoginpanel = new JPanel();
		masterpanel_2.add(StudentLoginpanel, "panelStudentLogin");
		StudentLoginpanel.setLayout(null);

		JLabel lblStudentLogin = new JLabel("STUDENT  LOGIN");
		lblStudentLogin.setForeground(Color.RED);
		lblStudentLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudentLogin.setBounds(418, 70, 152, 30);
		StudentLoginpanel.add(lblStudentLogin);

		JLabel lblId_1 = new JLabel("ID :-");
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId_1.setBounds(312, 158, 61, 20);
		StudentLoginpanel.add(lblId_1);

		txtStudentLoginId = new JTextField();
		txtStudentLoginId.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtStudentLoginId.setBounds(418, 152, 138, 20);
		StudentLoginpanel.add(txtStudentLoginId);
		txtStudentLoginId.setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(312, 217, 91, 17);
		StudentLoginpanel.add(lblPassword);

		txtStudentLoginPass = new JPasswordField();
		txtStudentLoginPass.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtStudentLoginPass.setBounds(418, 214, 138, 20);
		StudentLoginpanel.add(txtStudentLoginPass);
		txtStudentLoginPass.setColumns(10);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconn();
				try {
					// Class.forName("com.mysql.jdbc.Driver");
					// con =
					// DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","admin");
					// st = (Statement) con.createStatement();

					String qur = "select username,password from studentregistration where studentid=? and password=?";
					ps = (PreparedStatement) con.prepareStatement(qur);
					ps.setString(1, txtStudentLoginId.getText());
					ps.setString(2, txtStudentLoginPass.getText());
					rs = ps.executeQuery();
					if (rs.next()) {
						cardlayout.show(masterpanel_1, "panel3");
						cardlayout2.show(masterpanel_2, "panelStudentProfile");

						String qur2 = "select * from studentregistration where studentid='"
								+ txtStudentLoginId.getText() + "'";
						ps = con.prepareStatement(qur2);
						rs = ps.executeQuery();

						if (rs.next()) {

							txtStudentDetailId.setText(rs.getString("studentid"));
							txtStudentDetailName.setText(rs.getString("name"));
							txtStudentDetailMono.setText(rs.getString("mono"));
							txtStudentDetailEmail.setText(rs.getString("email"));
							textAreaStudentDetailAdd.setText(rs.getString("address"));
						}
						txtStudentLoginId.setText("");
						txtStudentLoginPass.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Plz Check Id And Password");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnLogin.setBounds(312, 268, 101, 23);
		StudentLoginpanel.add(btnLogin);

		JLabel lblNotRegisterYet = new JLabel("NOT REGISTER YET ?  Click Here");
		lblNotRegisterYet.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				cardlayout2.show(masterpanel_2, "panelStudentRegistration");
			}
		});
		lblNotRegisterYet.setForeground(Color.MAGENTA);
		lblNotRegisterYet.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNotRegisterYet.setBounds(312, 317, 244, 14);
		StudentLoginpanel.add(lblNotRegisterYet);

		JPanel StudentRegisterpanel = new JPanel();
		masterpanel_2.add(StudentRegisterpanel, "panelStudentRegistration");
		StudentRegisterpanel.setLayout(null);

		JLabel lblStudentRegister = new JLabel("STUDENT REGISTRATION");
		lblStudentRegister.setForeground(Color.RED);
		lblStudentRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentRegister.setBounds(398, 40, 211, 26);
		StudentRegisterpanel.add(lblStudentRegister);

		JLabel lblStudentId = new JLabel("STUDENT ID :-");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentId.setBounds(272, 84, 94, 17);
		StudentRegisterpanel.add(lblStudentId);

		txtStudentRegId = new JTextField();
		txtStudentRegId.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtStudentRegId.setBounds(398, 81, 193, 20);
		StudentRegisterpanel.add(txtStudentRegId);
		txtStudentRegId.setColumns(10);

		JLabel lblName = new JLabel("NAME :-");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(272, 133, 69, 20);
		StudentRegisterpanel.add(lblName);

		txtStudentRegName = new JTextField();
		txtStudentRegName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtStudentRegName.setBounds(398, 133, 193, 20);
		StudentRegisterpanel.add(txtStudentRegName);
		txtStudentRegName.setColumns(10);

		JLabel lblMobile = new JLabel("MOBILE :-");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMobile.setBounds(272, 195, 74, 17);
		StudentRegisterpanel.add(lblMobile);

		txtStudentRegMono = new JTextField();
		txtStudentRegMono.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtStudentRegMono.setBounds(399, 192, 192, 20);
		StudentRegisterpanel.add(txtStudentRegMono);
		txtStudentRegMono.setColumns(10);

		JLabel lblEmail = new JLabel("EMAIL :-");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(272, 247, 74, 17);
		StudentRegisterpanel.add(lblEmail);

		txtStudentRegEmail = new JTextField();
		txtStudentRegEmail.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtStudentRegEmail.setBounds(398, 244, 193, 20);
		StudentRegisterpanel.add(txtStudentRegEmail);
		txtStudentRegEmail.setColumns(10);

		JLabel lblAddress = new JLabel("ADDRESS :-");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(272, 298, 94, 26);
		StudentRegisterpanel.add(lblAddress);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(398, 293, 358, 61);
		StudentRegisterpanel.add(scrollPane_6);

		textAreaStudentRegAddress = new JTextArea();
		textAreaStudentRegAddress.setFont(new Font("Tahoma", Font.ITALIC, 13));
		scrollPane_6.setViewportView(textAreaStudentRegAddress);

		JLabel lblPassword_1 = new JLabel("PASSWORD :-");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword_1.setBounds(272, 380, 94, 17);
		StudentRegisterpanel.add(lblPassword_1);

		txtStudentRegPass = new JTextField();
		txtStudentRegPass.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtStudentRegPass.setBounds(398, 380, 193, 20);
		StudentRegisterpanel.add(txtStudentRegPass);
		txtStudentRegPass.setColumns(10);

		JButton btnRegisterStudent = new JButton("REGISTER");
		btnRegisterStudent.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (txtStudentRegId.getText().equals("") || txtStudentRegName.getText().equals("")
							|| txtStudentRegPass.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "plz fill all field");

					}

					else {
						dbconn();
						// Class.forName("com.mysql.jdbc.Driver");
						// con=DriverManager.getConnection(
						// "jdbc:mysql://localhost:3306/exam","root","admin");
						// st=con.createStatement();
						ps = con.prepareStatement("insert into studentregistration values(?,?,?,?,?,?)");

						ps.setString(1, txtStudentRegId.getText());
						ps.setString(2, txtStudentRegName.getText());
						ps.setString(3, txtStudentRegMono.getText());
						ps.setString(4, txtStudentRegEmail.getText());
						ps.setString(5, textAreaStudentRegAddress.getText());
						ps.setString(6, txtStudentRegPass.getText());
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Inserted");
						txtStudentRegId.setText("");
						txtStudentRegName.setText("");
						txtStudentRegMono.setText("");
						txtStudentRegEmail.setText("");
						txtStudentRegPass.setText("");
						textAreaStudentRegAddress.setText("");

						st.close();
						con.close();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnRegisterStudent.setBounds(398, 430, 135, 23);
		StudentRegisterpanel.add(btnRegisterStudent);

		JPanel StudentProfilepanel = new JPanel();
		masterpanel_2.add(StudentProfilepanel, "panelStudentProfile");
		StudentProfilepanel.setLayout(null);

		JLabel lblStudentDetail = new JLabel("STUDENT  DETAIL");
		lblStudentDetail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudentDetail.setForeground(Color.RED);
		lblStudentDetail.setBounds(362, 49, 183, 25);
		StudentProfilepanel.add(lblStudentDetail);

		JLabel lblStudentId_1 = new JLabel("STUDENT  ID :-");
		lblStudentId_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentId_1.setBounds(249, 99, 108, 17);
		StudentProfilepanel.add(lblStudentId_1);

		txtStudentDetailId = new JTextField();
		txtStudentDetailId.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtStudentDetailId.setEditable(false);
		txtStudentDetailId.setText("              ");
		txtStudentDetailId.setBounds(362, 96, 154, 20);
		StudentProfilepanel.add(txtStudentDetailId);
		txtStudentDetailId.setColumns(10);

		JLabel lblName_1 = new JLabel("NAME :-");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName_1.setBounds(249, 150, 88, 17);
		StudentProfilepanel.add(lblName_1);

		txtStudentDetailName = new JTextField();
		txtStudentDetailName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtStudentDetailName.setBounds(362, 147, 238, 20);
		StudentProfilepanel.add(txtStudentDetailName);
		txtStudentDetailName.setColumns(10);

		JLabel lblMobile_1 = new JLabel("MOBILE :-");
		lblMobile_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMobile_1.setBounds(249, 196, 88, 17);
		StudentProfilepanel.add(lblMobile_1);

		txtStudentDetailMono = new JTextField();
		txtStudentDetailMono.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtStudentDetailMono.setBounds(362, 193, 154, 20);
		StudentProfilepanel.add(txtStudentDetailMono);
		txtStudentDetailMono.setColumns(10);

		JLabel lblEmail_1 = new JLabel("EMAIL :-");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail_1.setBounds(249, 242, 63, 17);
		StudentProfilepanel.add(lblEmail_1);

		txtStudentDetailEmail = new JTextField();
		txtStudentDetailEmail.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtStudentDetailEmail.setBounds(362, 239, 238, 20);
		StudentProfilepanel.add(txtStudentDetailEmail);
		txtStudentDetailEmail.setColumns(10);

		JLabel lblAddress_1 = new JLabel("ADDRESS :-");
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress_1.setBounds(249, 303, 88, 17);
		StudentProfilepanel.add(lblAddress_1);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconn();
				try {
					// Class.forName("com.mysql.jdbc.Driver");
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");
					// st=con.createStatement();

					String id = txtStudentDetailId.getText();
					String name = txtStudentDetailName.getText();
					String mono = txtStudentDetailMono.getText();
					String email = txtStudentDetailEmail.getText();
					String address = textAreaStudentDetailAdd.getText();

					String sql = "update studentregistration set name=?,mono=?,email=?,address=? where id=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, name);
					ps.setString(2, mono);
					ps.setString(3, email);
					ps.setString(4, address);
					ps.setString(5, id);
					// ps.setString(6, pass);
					int update = ps.executeUpdate();
					if (update > 0) {
						JOptionPane.showMessageDialog(null, "updated");
					}

				} catch (Exception e3) {
					JOptionPane.showConfirmDialog(null, e3);
				}
			}
		});
		btnUpdate.setBounds(362, 415, 119, 23);
		StudentProfilepanel.add(btnUpdate);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(362, 297, 339, 95);
		StudentProfilepanel.add(scrollPane_7);
		textAreaStudentDetailAdd = new JTextArea();
		textAreaStudentDetailAdd.setFont(new Font("Tahoma", Font.ITALIC, 13));
		scrollPane_7.setViewportView(textAreaStudentDetailAdd);

		JPanel TakeTestpanel = new JPanel();
		masterpanel_2.add(TakeTestpanel, "paneltakeATest");
		TakeTestpanel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("TAKE  A  TEST");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(437, 73, 159, 29);
		TakeTestpanel.add(lblNewLabel_2);

		JLabel lblStudentId_2 = new JLabel("STUDENT  ID  :-");
		lblStudentId_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentId_2.setBounds(288, 143, 105, 20);
		TakeTestpanel.add(lblStudentId_2);

		lblgetStidTT = new JLabel("lblgetId");
		lblgetStidTT.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblgetStidTT.setBounds(403, 143, 62, 20);
		TakeTestpanel.add(lblgetStidTT);

		JLabel lblSubject_2 = new JLabel("SUBJECT  :-");
		lblSubject_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubject_2.setBounds(288, 205, 89, 17);
		TakeTestpanel.add(lblSubject_2);

		final JComboBox cmbSubTakeATest = new JComboBox();
		cmbSubTakeATest.setFont(new Font("Tahoma", Font.ITALIC, 13));
		dbconn();
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","admin");
			// st = (Statement) con.createStatement();

			String qur = "select DISTINCT subject from addsubject";
			ps = (PreparedStatement) con.prepareStatement(qur);

			rs = ps.executeQuery();
			while (rs.next()) {
				cmbSubTakeATest.addItem(rs.getString("subject"));
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		cmbSubTakeATest.setBounds(403, 202, 175, 20);
		TakeTestpanel.add(cmbSubTakeATest);

		lbltemp = new JLabel("lbltemp");
		lbltemp.setEnabled(false);
		lbltemp.setBounds(550, 143, 46, 14);
		// TakeTestpanel.add(lbltemp);

		JPanel Testpanel = new JPanel();
		masterpanel_2.add(Testpanel, "panelTest");
		Testpanel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("TEST");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(422, 11, 69, 20);
		Testpanel.add(lblNewLabel_3);

		JLabel lblStudentId_3 = new JLabel("STUDENT  ID :-");
		lblStudentId_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentId_3.setBounds(144, 35, 98, 20);
		Testpanel.add(lblStudentId_3);

		lblGetidT = new JLabel("getid");
		lblGetidT.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblGetidT.setBounds(245, 41, 46, 14);
		Testpanel.add(lblGetidT);

		JLabel lblSubject_3 = new JLabel("SUBJECT :-");
		lblSubject_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubject_3.setBounds(422, 35, 76, 20);
		Testpanel.add(lblSubject_3);

		lblGetsubT = new JLabel("getsub");
		lblGetsubT.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblGetsubT.setBounds(525, 41, 46, 14);
		Testpanel.add(lblGetsubT);

		JLabel lblTime = new JLabel("TIME :-");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTime.setBounds(663, 35, 51, 20);
		Testpanel.add(lblTime);

		JLabel lblQ = new JLabel("Q.");
		lblQ.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQ.setBounds(10, 92, 21, 25);
		Testpanel.add(lblQ);

		lbltestqid = new JLabel("0");
		lbltestqid.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lbltestqid.setBounds(63, 92, 21, 14);
		Testpanel.add(lbltestqid);

		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(126, 66, 725, 90);
		Testpanel.add(scrollPane_8);

		lblGetTQ = new JTextArea("");
		lblGetTQ.setEditable(false);
		scrollPane_8.setViewportView(lblGetTQ);

		JLabel lblOption = new JLabel("Option 1.");
		lblOption.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOption.setBounds(10, 199, 62, 20);
		Testpanel.add(lblOption);

		opt1 = new JRadioButton("1");
		opt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		opt1.setBounds(78, 190, 40, 23);
		Testpanel.add(opt1);

		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(124, 160, 727, 67);
		Testpanel.add(scrollPane_9);

		l1 = new JTextArea();
		l1.setEditable(false);
		scrollPane_9.setViewportView(l1);

		JLabel lblOption_5 = new JLabel("Option 2.");
		lblOption_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOption_5.setBounds(10, 269, 62, 20);
		Testpanel.add(lblOption_5);

		opt2 = new JRadioButton("2");
		opt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		opt2.setBounds(78, 260, 41, 23);
		Testpanel.add(opt2);

		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(124, 235, 727, 67);
		Testpanel.add(scrollPane_10);

		l2 = new JTextArea();
		l2.setEditable(false);
		scrollPane_10.setViewportView(l2);

		JLabel lblOption_6 = new JLabel("Option 3.");
		lblOption_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOption_6.setBounds(10, 336, 62, 20);
		Testpanel.add(lblOption_6);

		opt3 = new JRadioButton("3");
		opt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		opt3.setBounds(78, 327, 40, 23);
		Testpanel.add(opt3);

		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(124, 306, 727, 67);
		Testpanel.add(scrollPane_11);

		l3 = new JTextArea();
		l3.setEditable(false);
		scrollPane_11.setViewportView(l3);

		JLabel lblOption_7 = new JLabel("Option 4.");
		lblOption_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOption_7.setBounds(10, 398, 62, 23);
		Testpanel.add(lblOption_7);

		opt4 = new JRadioButton("4");
		opt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		opt4.setBounds(78, 398, 40, 23);
		Testpanel.add(opt4);

		bg = new ButtonGroup();
		bg.add(opt1);
		bg.add(opt2);
		bg.add(opt3);
		bg.add(opt4);

		JScrollPane scrollPane_12 = new JScrollPane();
		scrollPane_12.setBounds(124, 377, 727, 67);
		Testpanel.add(scrollPane_12);

		l4 = new JTextArea();
		l4.setEditable(false);
		scrollPane_12.setViewportView(l4);

		final Checkbox checkbox = new Checkbox("BookMark");
		checkbox.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// bookmarklist.addItem(lbltestqid.getText());
				if (opt1.isSelected() || opt2.isSelected() || opt3.isSelected() || opt4.isSelected()) {
					JOptionPane.showMessageDialog(null, "First Click On CLEAR SELECTION");
					checkbox.setState(false);

				}
			}
		});
		checkbox.setBounds(147, 449, 95, 22);
		Testpanel.add(checkbox);

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(lbltestqid.getText());

				dbconn();
				try {
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");

					PreparedStatement ps = con
							.prepareStatement("select *  from addquestion where subject=? and qid=? ");
					ps.setString(1, cmbSubTakeATest.getSelectedItem().toString());
					ps.setInt(2, id - 1);
					rs = ps.executeQuery();

					while (rs.next())

					{

						lbltestqid.setText(rs.getString("qid"));
						lblGetTQ.setText(rs.getString("question"));
						l1.setText(rs.getString("opt1"));
						l2.setText(rs.getString("opt2"));
						l3.setText(rs.getString("opt3"));
						l4.setText(rs.getString("opt4"));

					}
					st.close();
					con.close();
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, exp);
				}

				if ("0".equals(list2.getItem(id - 2))) {
					bg.clearSelection();
				}

				else if ("1".equals(list2.getItem(id - 2))) {
					opt1.setSelected(true);
				} else if ("2".equals(list2.getItem(id - 2))) {
					opt2.setSelected(true);
				} else if ("3".equals(list2.getItem(id - 2))) {
					opt3.setSelected(true);
				} else if ("4".equals(list2.getItem(id - 2))) {
					opt4.setSelected(true);
				}
				// System.out.println("back="+list2.getItem(id-2));
			}
		});
		btnPrevious.setBounds(265, 448, 108, 23);
		Testpanel.add(btnPrevious);

		JButton btnNext = new JButton("Submit & Next");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = Integer.parseInt(lbltestqid.getText());
				// System.out.println("next="+num);
				if (opt1.isSelected()) {
					result = opt1.getText();

				} else if (opt2.isSelected()) {
					result = opt2.getText();
				} else if (opt3.isSelected()) {
					result = opt3.getText();
				} else if (opt4.isSelected()) {
					result = opt4.getText();
				} else {
					result = "0";

				}
				if (result.equals("0"))

				{

					boolean f = false;
					String[] item0 = list.getItems();
					int cn = list.getItemCount();
					for (int i = 0; i < cn; i++) {
						if (item0[i].equals(lbltestqid.getText())) {
							try {
								list.replaceItem(lbltestqid.getText(), num - 1);
								list2.replaceItem(result, num - 1);

							} catch (Exception e4) {
								// JOptionPane.showMessageDialog(null, e4);
							}
							// JOptionPane.showMessageDialog(null, "Already Answered Click ok To Next
							// Question");

							f = true;
							break;
						}
					}

					if (!f) {
						list.add(lbltestqid.getText(), num - 1);
						list2.add(result, num - 1);

					}

					// -----------------------------------------------------------------------
					boolean f1 = false;
					String[] item1 = bookmarklist.getItems();
					int cn1 = bookmarklist.getItemCount();
					for (int i = 0; i < cn1; i++) {
						if (item1[i].equals(lbltestqid.getText())) {
							try {
								bookmarklist.replaceItem(lbltestqid.getText(), num - 1);

							} catch (Exception e4) {
								// JOptionPane.showMessageDialog(null, e4);
							}
							// JOptionPane.showMessageDialog(null, "Already Answered Click ok To Next
							// Question");

							f1 = true;
							break;
						}
					}

					if (!f1) {
						bookmarklist.add(lbltestqid.getText(), num - 1);

					}

				}
				// ----------------------------------------------------------------------
				else {
					boolean f2 = false;
					String[] item = list.getItems();
					int cn2 = list.getItemCount();
					for (int i = 0; i < cn2; i++) {
						if (item[i].equals(lbltestqid.getText())) {
							try {
								list.replaceItem(lbltestqid.getText(), num - 1);
								list2.replaceItem(result, num - 1);
								bookmarklist.remove(lbltestqid.getText());
							} catch (IllegalArgumentException duplicate) {

							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, e2);

							}
							// JOptionPane.showMessageDialog(null, "Already Answered Click ok To Next
							// Question");

							f2 = true;
							break;
						}
					}

					if (!f2) {
						list.add(lbltestqid.getText(), num - 1);

						list2.add(result, num - 1);
						String[] item4 = bookmarklist.getItems();
						int cn4 = bookmarklist.getItemCount();
						for (int i = 0; i < cn4; i++) {
							if (item4[i].equals(lbltestqid.getText()))
								bookmarklist.remove(lbltestqid.getText());
						}

					}

				}

				Questionid = Integer.parseInt(lbltestqid.getText());

				int incid = Questionid + 1;
				dbconn();
				try {
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");

					PreparedStatement ps = con
							.prepareStatement("select *  from addquestion where subject=? and qid=? ");
					ps.setString(1, cmbSubTakeATest.getSelectedItem().toString());
					ps.setInt(2, incid);
					rs = ps.executeQuery();

					while (rs.next())

					{
						bg.clearSelection();
						checkbox.setState(false);
						lbltestqid.setText(rs.getString("qid")); // increment qid for retrieving q
						// lblqno.setText(String.valueOf(qno)); //increment qno.
						lblGetTQ.setText(rs.getString("question"));
						l1.setText(rs.getString("opt1"));
						l2.setText(rs.getString("opt2"));
						l3.setText(rs.getString("opt3"));
						l4.setText(rs.getString("opt4"));
					}

					st.close();
					con.close();
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, exp);
				}
				if ((list2.getItemCount()) >= Integer.parseInt(lbltestqid.getText())) {
					if ("0".equals(list2.getItem(Questionid))) {
						bg.clearSelection();
					}

					else if ("1".equals(list2.getItem(Questionid))) {
						opt1.setSelected(true);
					} else if ("2".equals(list2.getItem(Questionid))) {
						opt2.setSelected(true);
					} else if ("3".equals(list2.getItem(Questionid))) {
						opt3.setSelected(true);
					} else if ("4".equals(list2.getItem(Questionid))) {
						opt4.setSelected(true);
					}
				}

			}

		});
		btnNext.setBounds(479, 448, 134, 23);
		Testpanel.add(btnNext);

		list = new List();
		list.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int QuestionidQ = Integer.parseInt(list.getSelectedItem());
				dbconn();
				try {
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");
					ps = con.prepareStatement("select *  from addquestion where subject=? and qid=? ");
					ps.setString(1, cmbSubTakeATest.getSelectedItem().toString());
					ps.setString(2, list.getSelectedItem().toString());
					rs = ps.executeQuery();

					while (rs.next())

					{
						// lblqno.setText(bookmarklist.getSelectedItem());
						lbltestqid.setText(rs.getString("qid"));
						lblGetTQ.setText(rs.getString("question"));
						l1.setText(rs.getString("opt1"));
						l2.setText(rs.getString("opt2"));
						l3.setText(rs.getString("opt3"));
						l4.setText(rs.getString("opt4"));

					}
					st.close();
					con.close();
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, exp);
				}
				if ("1".equals(list2.getItem(QuestionidQ - 1))) {
					opt1.setSelected(true);
				} else if ("2".equals(list2.getItem(QuestionidQ - 1))) {
					opt2.setSelected(true);
				} else if ("3".equals(list2.getItem(QuestionidQ - 1))) {
					opt3.setSelected(true);
				} else if ("4".equals(list2.getItem(QuestionidQ - 1))) {
					opt4.setSelected(true);
				}

			}
		});

		list.setBounds(872, 27, 46, 200);
		Testpanel.add(list);

		JButton btnEndExam = new JButton("End Exam");
		btnEndExam.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEndExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endexam();
				timer.cancel();
				timecounter = 0;
				lblGetnameM.setText(txtStudentDetailName.getText());
				lblGetidM.setText(lblGetidT.getText());
				lblGetsubjectM.setText(lblGetsubT.getText());
				cardlayout2.show(masterpanel_2, "panelmark");
			}
		});
		btnEndExam.setBounds(693, 448, 108, 23);
		Testpanel.add(btnEndExam);

		list2 = new List();
		list2.setBounds(931, 27, 32, 200);
		Testpanel.add(list2);

		/*
		 * lblqno = new JLabel("lblQno"); lblqno.setBounds(26, 92, 27, 14);
		 * Testpanel.add(lblqno);
		 */

		JLabel lblBookmark = new JLabel("BookMark");
		lblBookmark.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookmark.setBounds(868, 235, 69, 14);
		Testpanel.add(lblBookmark);

		bookmarklist = new List();
		bookmarklist.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				bg.clearSelection();
				dbconn();
				try {
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");
					ps = con.prepareStatement("select *  from addquestion where subject=? and qid=? ");
					ps.setString(1, cmbSubTakeATest.getSelectedItem().toString());
					ps.setString(2, bookmarklist.getSelectedItem().toString());
					rs = ps.executeQuery();

					while (rs.next())

					{
						// lblqno.setText(bookmarklist.getSelectedItem());
						lbltestqid.setText(rs.getString("qid"));
						lblGetTQ.setText(rs.getString("question"));
						l1.setText(rs.getString("opt1"));
						l2.setText(rs.getString("opt2"));
						l3.setText(rs.getString("opt3"));
						l4.setText(rs.getString("opt4"));
						bookmarklist.remove(bookmarklist.getSelectedItem());
					}
					st.close();
					con.close();
				} catch (Exception exp) {
					// JOptionPane.showMessageDialog(null, exp);
				}
			}
		});
		bookmarklist.setBounds(872, 257, 46, 187);
		Testpanel.add(bookmarklist);

		JLabel lblClearSelection = new JLabel("CLEAR SELECTION");
		lblClearSelection.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClearSelection.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				bg.clearSelection();
			}
		});
		lblClearSelection.setBounds(10, 432, 108, 20);
		Testpanel.add(lblClearSelection);

		lblMin = new JLabel("00");
		lblMin.setForeground(Color.BLUE);
		lblMin.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		lblMin.setBounds(724, 35, 25, 20);
		Testpanel.add(lblMin);

		lblSec = new JLabel("00");
		lblSec.setForeground(Color.BLUE);
		lblSec.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		lblSec.setBounds(780, 35, 32, 20);
		Testpanel.add(lblSec);

		JLabel lblQ_1 = new JLabel("Q");
		lblQ_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQ_1.setBounds(886, 7, 21, 14);
		Testpanel.add(lblQ_1);

		markspanel = new JPanel();
		masterpanel_2.add(markspanel, "panelmark");
		markspanel.setLayout(null);

		JButton btnSrart = new JButton("SRART");
		btnSrart.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSrart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id2, sub;
				id2 = txtStudentDetailId.getText();
				sub = cmbSubTakeATest.getSelectedItem().toString();

				lblGetidT.setText(id2);
				lblGetsubT.setText(sub);
				// lblqno.setText("1");
				dbconn();
				try {
					// con=DriverManager.getConnection(
					// "jdbc:mysql://localhost:3306/exam","root","admin");

					ps = con.prepareStatement("select qid  from addquestion where subject=? LIMIT 1");
					ps.setString(1, cmbSubTakeATest.getSelectedItem().toString());
					rs = ps.executeQuery();
					if (rs.next()) {
						lbltemp.setText(rs.getString("qid"));

					}
					int flag = 0;
					ps = con.prepareStatement("select qid from addquestion where subject=? ORDER BY qid DESC LIMIT 1");
					ps.setString(1, cmbSubTakeATest.getSelectedItem().toString());
					rs = ps.executeQuery();
					if (rs.next()) {
						check = Integer.parseInt(rs.getString("qid"));
						flag = 1;
					} else {
						JOptionPane.showMessageDialog(null, "No any Question for this subject");
						cardlayout2.show(masterpanel_2, "paneltakeATest");

					}
					if (flag == 1) {
						ps = con.prepareStatement("select *  from addquestion where subject=? and qid=? ");
						ps.setString(1, cmbSubTakeATest.getSelectedItem().toString());
						ps.setString(2, lbltemp.getText());
						rs = ps.executeQuery();

						while (rs.next())

						{
							// list.addItem(lbltemp.getText());
							lbltestqid.setText(rs.getString("qid"));
							lblGetTQ.setText(rs.getString("question"));
							l1.setText(rs.getString("opt1"));
							l2.setText(rs.getString("opt2"));
							l3.setText(rs.getString("opt3"));
							l4.setText(rs.getString("opt4"));
						}

						lblTakeTest.setVisible(false);
						lblMarks.setVisible(false);
						lblProfile.setVisible(false);
						lblLogout_1.setVisible(false);

						st.close();
						con.close();

						// timer();

						lblMin.setText("00");
						timer = new Timer("MyTimer");// create a new Timer

						timerTask = new TimerTask() {

							public void run() {

								// System.out.println( counter);
								lblSec.setText(String.valueOf(timecounter));
								timecounter++;// increments the counter
								if (lblSec.getText().equals("60"))
								// if(timecounter % 60==0 && timecounter != 0)
								{

									timecounter = 0;
									min = Integer.parseInt(lblMin.getText());
									lblMin.setText(String.valueOf(min + 1));
									if (lblMin.getText().equals(txtexamtime.getText()))
									// if(lblMin.getText().equals("1"))
									{
										lblSec.setText("00");

										endexam();
										timer.cancel();
										timecounter = 0;

										lblGetnameM.setText(txtStudentDetailName.getText());
										lblGetidM.setText(lblGetidT.getText());
										lblGetsubjectM.setText(lblGetsubT.getText());
										cardlayout2.show(masterpanel_2, "panelmark");

									}
								}

							}
						};

						// Timer timer = new Timer("MyTimer");//create a new Timer

						timer.schedule(timerTask, 10, 1000);// this line starts the timer at the same time its executed
						cardlayout2.show(masterpanel_2, "panelTest");

					}

				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, exp);
				}
			}
		});
		btnSrart.setBounds(403, 258, 124, 23);
		TakeTestpanel.add(btnSrart);

		lbltotalM = new JLabel("0");
		lbltotalM.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lbltotalM.setBounds(499, 282, 46, 22);
		markspanel.add(lbltotalM);

		JLabel lblName_2 = new JLabel("NAME :-");
		lblName_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblName_2.setBounds(345, 94, 72, 24);
		markspanel.add(lblName_2);

		JLabel lblId_2 = new JLabel("ID :-");
		lblId_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblId_2.setBounds(345, 154, 46, 24);
		markspanel.add(lblId_2);

		JLabel lblSubject_4 = new JLabel("SUBJECT :-");
		lblSubject_4.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblSubject_4.setBounds(345, 209, 72, 24);
		markspanel.add(lblSubject_4);

		JLabel lblObtainMarks = new JLabel("OBTAIN MARKS :-");
		lblObtainMarks.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblObtainMarks.setBounds(345, 278, 129, 30);
		markspanel.add(lblObtainMarks);

		lblGetnameM = new JLabel("getname");
		lblGetnameM.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGetnameM.setBounds(499, 94, 281, 19);
		markspanel.add(lblGetnameM);

		lblGetidM = new JLabel("getid");
		lblGetidM.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGetidM.setBounds(501, 154, 111, 19);
		markspanel.add(lblGetidM);

		lblGetsubjectM = new JLabel("getsubject");
		lblGetsubjectM.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGetsubjectM.setBounds(500, 206, 151, 30);

		markspanel.add(lblGetsubjectM);

		JPanel markAdminpanel = new JPanel();
		masterpanel_2.add(markAdminpanel, "panelmarkadminview");
		markAdminpanel.setLayout(null);

		JScrollPane scrollPane_5 = new JScrollPane(marktable);
		scrollPane_5.setBounds(24, 34, 927, 414);
		markAdminpanel.add(scrollPane_5);

		marktable = new JTable();
		scrollPane_5.setViewportView(marktable);

		JPanel aboutpanel = new JPanel();
		masterpanel_2.add(aboutpanel, "panelabout");
		aboutpanel.setLayout(null);

		JPanel makeadminpanel = new JPanel();
		masterpanel_2.add(makeadminpanel, "pnlmakeadmin");
		makeadminpanel.setLayout(null);

		JLabel lblCreateNewAdmin = new JLabel("CREATE NEW ADMIN");
		lblCreateNewAdmin.setForeground(Color.RED);
		lblCreateNewAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCreateNewAdmin.setBounds(373, 58, 177, 32);
		makeadminpanel.add(lblCreateNewAdmin);

		JLabel lblId_3 = new JLabel("ID:-");
		lblId_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId_3.setBounds(266, 155, 46, 14);
		makeadminpanel.add(lblId_3);

		txtadminid = new JTextField();
		txtadminid.setBounds(373, 153, 159, 20);
		makeadminpanel.add(txtadminid);
		txtadminid.setColumns(10);

		JLabel lblPassword_2 = new JLabel("PASSWORD:-");
		lblPassword_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword_2.setBounds(266, 210, 94, 20);
		makeadminpanel.add(lblPassword_2);

		txtadminpass = new JTextField();
		txtadminpass.setBounds(373, 211, 159, 20);
		makeadminpanel.add(txtadminpass);
		txtadminpass.setColumns(10);

		JButton btnCreate = new JButton("CREATE");
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dbconn();
				try {
					if (txtadminid.getText().equals("") || txtadminpass.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "plz fill id & password");
					} else {

						ps = (PreparedStatement) con.prepareStatement("insert into adminlogin values(?,?)");
						ps.setString(1, txtadminid.getText());
						ps.setString(2, txtadminpass.getText());
						ps.executeUpdate();

						JOptionPane.showMessageDialog(null, "Admin Added Successfully");

						txtadminid.setText("");
						txtadminpass.setText("");

						con.close();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		btnCreate.setBounds(373, 258, 89, 23);
		makeadminpanel.add(btnCreate);

		JLabel labelTimeSep = new JLabel(":");
		labelTimeSep.setBounds(1265, 214, 11, 14);
		frmOnlineExam.getContentPane().add(labelTimeSep);

	}
}
