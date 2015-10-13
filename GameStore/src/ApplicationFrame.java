import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.channels.NetworkChannel;
import java.text.Collator;

import javax.swing.JPasswordField;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class ApplicationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField TXT_Login;
	private JPasswordField TXT_Password;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelWin");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationFrame frame = new ApplicationFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ApplicationFrame() {
		setResizable(false);
		try {
			UIManager.setLookAndFeel("org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelWin");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		String jdbc = "jdbc:sqlserver://localhost:1433;databaseName=GAMESTORE";
		
		BancoDados bd = new BancoDados();
		Connection con = bd.ConectaBD(jdbc, "sa", "123456");
		
		bd.CriarTabela(con);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setDefaultLocale(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(102, 153, 204));
		menuBar.setBounds(0, 0, 854, 30);
		contentPane.add(menuBar);
		
		JMenu mnLogin = new JMenu("Login");
		mnLogin.setForeground(new Color(102, 153, 255));
		mnLogin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnLogin);
		
		JMenuItem mntmConectar = new JMenuItem("Conectar");
		mnLogin.add(mntmConectar);
		
		JMenuItem mntmDesconectar = new JMenuItem("Desconectar");
		mnLogin.add(mntmDesconectar);
		
		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
		mnLogin.add(mntmAtualizar);
		
		JLabel LB_Background = new JLabel("");
		LB_Background.setBounds(0, 41, 786, 146);
		contentPane.add(LB_Background);
		LB_Background.setIcon(new ImageIcon("C:\\Users\\Lu\u00EDsPaulo\\Downloads\\GameStoreLogo-crop.png"));
		
		JPanel Panel_Card = new JPanel();
		Panel_Card.setBounds(209, 186, 570, 517);
		contentPane.add(Panel_Card);
		Panel_Card.setLayout(new CardLayout(0, 0));
		
		JPanel Panel_Login = new JPanel();
		Panel_Card.add(Panel_Login, "name_7725914845621");
		Panel_Login.setLayout(null);
		
		TXT_Login = new JTextField();
		TXT_Login.setBounds(105, 143, 238, 30);
		Panel_Login.add(TXT_Login);
		TXT_Login.setFont(new Font("Segoe WP SemiLight", Font.PLAIN, 15));
		TXT_Login.setColumns(10);
		
		JLabel LB_Login = new JLabel("LOGIN");
		LB_Login.setBounds(50, 137, 55, 39);
		Panel_Login.add(LB_Login);
		LB_Login.setForeground(new Color(102, 153, 255));
		LB_Login.setFont(new Font("Segoe WP SemiLight", Font.PLAIN, 16));
		
		JLabel LB_Senha = new JLabel("SENHA");
		LB_Senha.setBounds(46, 180, 55, 39);
		Panel_Login.add(LB_Senha);
		LB_Senha.setForeground(new Color(102, 153, 255));
		LB_Senha.setFont(new Font("Segoe WP SemiLight", Font.PLAIN, 16));
		
		JButton BT_Entrar = new JButton("ENTRAR");
		BT_Entrar.setVisible(false);
		
		BT_Entrar.setBounds(105, 282, 238, 39);
		Panel_Login.add(BT_Entrar);
		BT_Entrar.setBackground(new Color(51, 153, 255));
		BT_Entrar.setForeground(new Color(51, 153, 255));
		BT_Entrar.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		
		TXT_Password = new JPasswordField();
		TXT_Password.setBounds(105, 184, 238, 30);
		Panel_Login.add(TXT_Password);
		
		JPanel Panel_Entrar = new JPanel();
		
		Panel_Entrar.setBackground(SystemColor.textHighlight);
		Panel_Entrar.setBounds(105, 231, 238, 40);
		Panel_Login.add(Panel_Entrar);
		Panel_Entrar.setLayout(null);
		
		JLabel LB_Entrar = new JLabel("ENTRAR");
		LB_Entrar.setForeground(new Color(255, 255, 255));
		LB_Entrar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		LB_Entrar.setBounds(new Rectangle(70, 5, 79, 27));
		LB_Entrar.setAlignmentY(0.0f);
		Panel_Entrar.add(LB_Entrar);
		
		JLabel LB_ImgEntrar = new JLabel("");
		LB_ImgEntrar.setIcon(new ImageIcon("C:\\Users\\Lu\u00EDsPaulo\\Downloads\\Right Arrow-32.png"));
		LB_ImgEntrar.setForeground(Color.WHITE);
		LB_ImgEntrar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		LB_ImgEntrar.setBounds(new Rectangle(196, 7, 32, 27));
		LB_ImgEntrar.setAlignmentY(0.0f);
		Panel_Entrar.add(LB_ImgEntrar);
		
		JPanel Panel_User = new JPanel();
		Panel_Card.add(Panel_User, "name_8185795600670");
		Panel_User.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 246, 570, 271);
		Panel_User.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setShowVerticalLines(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "CPF/CNPJ", "Endere\u00E7o", "Obs"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(84);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(116);
		table.setBorder(new CompoundBorder());
		
		textField = new JTextField();
		textField.setBounds(138, 93, 299, 33);
		Panel_User.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 570, 39);
		panel.setBackground(new Color(102, 102, 102));
		Panel_User.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 102));
		panel_1.setBounds(0, 0, 136, 39);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAdicionar = new JLabel("ADICIONAR");
		lblAdicionar.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		lblAdicionar.setForeground(new Color(255, 255, 255));
		lblAdicionar.setBounds(45, 13, 91, 14);
		panel_1.add(lblAdicionar);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setIcon(new ImageIcon("C:\\Users\\Lu\u00EDsPaulo\\Downloads\\Plus Math-26.png"));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label.setBounds(10, 0, 30, 33);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(102, 102, 102));
		panel_2.setBounds(134, 0, 136, 39);
		panel.add(panel_2);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		lblEditar.setBounds(45, 13, 91, 14);
		panel_2.add(lblEditar);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Lu\u00EDsPaulo\\Downloads\\Edit-26.png"));
		label_2.setVerticalAlignment(SwingConstants.BOTTOM);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label_2.setBounds(10, 0, 30, 33);
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(102, 102, 102));
		panel_3.setBounds(271, 0, 136, 39);
		panel.add(panel_3);
		
		JLabel lblExcluir = new JLabel("EXCLUIR");
		lblExcluir.setForeground(Color.WHITE);
		lblExcluir.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		lblExcluir.setBounds(45, 13, 91, 14);
		panel_3.add(lblExcluir);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Lu\u00EDsPaulo\\Downloads\\Delete-26.png"));
		label_3.setVerticalAlignment(SwingConstants.BOTTOM);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label_3.setBounds(10, 0, 30, 33);
		panel_3.add(label_3);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setForeground(new Color(0, 153, 255));
		lblNome.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblNome.setBounds(77, 102, 50, 14);
		Panel_User.add(lblNome);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setForeground(new Color(0, 153, 255));
		lblCpfcnpj.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblCpfcnpj.setBounds(50, 138, 77, 24);
		Panel_User.add(lblCpfcnpj);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 137, 299, 33);
		Panel_User.add(textField_1);
		
		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet[] result = bd.ConsultarCliente(con,textField.getText(),textField_1.getText());
				ResultSet rs = result[0];
				ResultSet count = result[1];
				
				try {
					count.next();
					int tm = count.getInt("tm");
					Object[][] tabela = new Object[tm][5];
					int i = 0;
					while(rs.next()){
						tabela[i][0] = rs.getInt("id_cliente");
						tabela[i][1] = rs.getString("nome_cliente");
						tabela[i][2] = rs.getString("codigo_cliente");
						tabela[i][3] = rs.getString("end_cliente");
						tabela[i][4] = rs.getString("detalhes_cliente");
						
						i++;
					}
				
					table.setModel(new DefaultTableModel(
							tabela,
							new String[] {
								"ID", "Nome", "CPF/CNPJ", "Endere\u00E7o", "Obs"
							}
						) {
							Class[] columnTypes = new Class[] {
								Object.class, Object.class, Object.class, Object.class, String.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			}
		});
		btnPesquisar.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		btnPesquisar.setForeground(new Color(51, 153, 204));
		btnPesquisar.setBounds(336, 174, 101, 31);
		Panel_User.add(btnPesquisar);
		
		JPanel Panel_Side = new JPanel();
		Panel_Side.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Panel_Side.setVisible(false);
		Panel_Side.setEnabled(false);
		Panel_Side.setBounds(0, 178, 210, 513);
		contentPane.add(Panel_Side);
		Panel_Side.setLayout(null);
		
		JPanel Panel_SideDashboard = new JPanel();
		Panel_SideDashboard.setBounds(0, 46, 4, 53);
		Panel_Side.add(Panel_SideDashboard);
		
		JPanel Panel_Dashboard = new JPanel();
		
		Panel_Dashboard.setBounds(7, 53, 173, 37);
		Panel_Side.add(Panel_Dashboard);
		
		BT_Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Panel_Login.setVisible(false);
				Panel_Side.setVisible(true);
				Panel_User.setVisible(true);
			}
		});
		Panel_Dashboard.setLayout(null);
		
		JLabel LB_Dashboard = new JLabel("DASHBOARD");
		LB_Dashboard.setForeground(SystemColor.textHighlight);
		LB_Dashboard.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		LB_Dashboard.setBounds(new Rectangle(41, 5, 132, 22));
		LB_Dashboard.setAlignmentY(Component.TOP_ALIGNMENT);
		Panel_Dashboard.add(LB_Dashboard);
		
		JLabel LB_ImgDashboard = new JLabel("");
		LB_ImgDashboard.setIcon(new ImageIcon("C:\\Users\\Lu\u00EDsPaulo\\Downloads\\Dashboard Filled-32.png"));
		LB_ImgDashboard.setBounds(0, 2, 32, 32);
		Panel_Dashboard.add(LB_ImgDashboard);
		LB_ImgDashboard.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		LB_ImgDashboard.setAlignmentY(0.0f);
		
		JPanel Panel_Customers = new JPanel();
		
		Panel_Customers.setLayout(null);
		Panel_Customers.setBounds(7, 125, 173, 37);
		Panel_Side.add(Panel_Customers);
		
		JLabel LB_Customers = new JLabel("CLIENTES");
		LB_Customers.setForeground(SystemColor.textHighlight);
		LB_Customers.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		LB_Customers.setBounds(new Rectangle(41, 5, 132, 22));
		LB_Customers.setAlignmentY(0.0f);
		LB_Customers.setBounds(41, 5, 132, 22);
		Panel_Customers.add(LB_Customers);
		
		JLabel LB_ImgCustomers = new JLabel("");
		LB_ImgCustomers.setIcon(new ImageIcon("C:\\Users\\Lu\u00EDsPaulo\\Downloads\\Gender Neutral User-32.png"));
		LB_ImgCustomers.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		LB_ImgCustomers.setAlignmentY(0.0f);
		LB_ImgCustomers.setBounds(0, 2, 32, 32);
		Panel_Customers.add(LB_ImgCustomers);
		
		JPanel Panel_SideCustomers = new JPanel();
		Panel_SideCustomers.setBounds(0, 117, 4, 53);
		Panel_Side.add(Panel_SideCustomers);
		
		JPanel Panel_Products = new JPanel();
		
		Panel_Products.setLayout(null);
		Panel_Products.setBounds(7, 193, 173, 37);
		Panel_Side.add(Panel_Products);
		
		JLabel LB_Products = new JLabel("PRODUTOS");
		LB_Products.setForeground(SystemColor.textHighlight);
		LB_Products.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		LB_Products.setBounds(new Rectangle(41, 5, 132, 22));
		LB_Products.setAlignmentY(0.0f);
		LB_Products.setBounds(41, 5, 132, 22);
		Panel_Products.add(LB_Products);
		
		JLabel LB_ImgProducts = new JLabel("");
		LB_ImgProducts.setIcon(new ImageIcon("C:\\Users\\Lu\u00EDsPaulo\\Downloads\\Controller-32.png"));
		LB_ImgProducts.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		LB_ImgProducts.setAlignmentY(0.0f);
		LB_ImgProducts.setBounds(0, 2, 32, 32);
		Panel_Products.add(LB_ImgProducts);
		
		JPanel Panel_SideProducts = new JPanel();
		Panel_SideProducts.setBounds(0, 188, 4, 53);
		Panel_Side.add(Panel_SideProducts);
		
		Panel_Entrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Panel_Entrar.setBackground(new Color(65, 105, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_Entrar.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Panel_Entrar.setBackground(new Color(65, 105, 225));
				Panel_Login.setVisible(false);
				Panel_Side.setVisible(true);
			}
		});
		
		Panel_Dashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Panel_SideDashboard.setBackground(Color.BLUE);
				LB_Dashboard.setForeground(Color.BLACK);
				LB_Dashboard.setFont(LB_Dashboard.getFont().deriveFont(Font.BOLD));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Panel_SideDashboard.setBackground(Color.white);
				LB_Dashboard.setForeground(SystemColor.textHighlight);
				LB_Dashboard.setFont(LB_Dashboard.getFont().deriveFont(Font.PLAIN));
			}
		});
		
		Panel_Customers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Panel_SideCustomers.setBackground(Color.BLUE);
				LB_Customers.setForeground(Color.BLACK);
				LB_Customers.setFont(LB_Customers.getFont().deriveFont(Font.BOLD));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_SideCustomers.setBackground(Color.white);
				LB_Customers.setForeground(SystemColor.textHighlight);
				LB_Customers.setFont(LB_Customers.getFont().deriveFont(Font.PLAIN));
			}
		});
		
		Panel_Products.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Panel_SideProducts.setBackground(Color.BLUE);
				LB_Products.setForeground(Color.BLACK);
				LB_Products.setFont(LB_Products.getFont().deriveFont(Font.BOLD));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_SideProducts.setBackground(Color.white);
				LB_Products.setForeground(SystemColor.textHighlight);
				LB_Products.setFont(LB_Products.getFont().deriveFont(Font.PLAIN));
			}
		});
		
		contentPane.setVisible(true);
	}
}
