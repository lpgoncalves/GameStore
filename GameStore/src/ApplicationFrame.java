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

import org.omg.CORBA.PUBLIC_MEMBER;


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
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ApplicationFrame extends JFrame {

	private JPanel contentPane;
	private JPanel Panel_Client;
	private JPanel Panel_Products;
	private JPanel Panel_Login;
	private JPanel Panel_Home;
	private JPanel Panel_Add_Product;
	private JPanel Panel_Edit_Product;
	private JTextField TXT_Login;
	private JPasswordField TXT_Password;
	private JTable table;
	private JTextField TXT_Name;
	private JTextField TXT_Doc;
	private JTextField TXT_Product;
	private JTextField TXT_Tipo;
	private JTable Table_Product;
	private Object[][] tabelaArray; 
	private JTextField TXT_ProductName;
	private JTextField TXT_Edit_Name;
	private BancoDados bd;

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
		
		bd = new BancoDados();
		bd.ConectaBD(jdbc, "sa", "123456");
		
		tabelaArray = new Object[9][5];
		
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
		
		JMenuItem mntmAtualizar = new JMenuItem("Criar Tabelas");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bd.CriarTabela();
			}
		});
		mnLogin.add(mntmAtualizar);
		
		JLabel LB_ImgBackground = new JLabel("");
		LB_ImgBackground.setBounds(0, 41, 786, 146);
		contentPane.add(LB_ImgBackground);
		LB_ImgBackground.setIcon(new ImageIcon("Images\\GameStoreLogo-crop.png"));
		
		JPanel Panel_Card = new JPanel();
		Panel_Card.setBounds(209, 186, 570, 517);
		contentPane.add(Panel_Card);
		Panel_Card.setLayout(new CardLayout(0, 0));
		
		Panel_Login = new JPanel();
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
		LB_ImgEntrar.setIcon(new ImageIcon("Images\\Right Arrow-32.png"));
		LB_ImgEntrar.setForeground(Color.WHITE);
		LB_ImgEntrar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		LB_ImgEntrar.setBounds(new Rectangle(196, 7, 32, 27));
		LB_ImgEntrar.setAlignmentY(0.0f);
		Panel_Entrar.add(LB_ImgEntrar);
		
		Panel_Client = new JPanel();
		Panel_Card.add(Panel_Client, "name_8185795600670");
		Panel_Client.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 246, 570, 271);
		Panel_Client.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setShowVerticalLines(true);
		table.setModel(new DefaultTableModel(
			tabelaArray,
			new String[] {
				"ID", "Nome", "CPF/CNPJ", "Endere\u00E7o", "Obs"
			}
		) );
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(84);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(116);
		table.setBorder(new CompoundBorder());
		
		TXT_Name = new JTextField();
		TXT_Name.setBounds(138, 93, 299, 33);
		Panel_Client.add(TXT_Name);
		TXT_Name.setColumns(10);
		
		JPanel Panel_Top = new JPanel();
		Panel_Top.setBounds(0, 0, 570, 39);
		Panel_Top.setBackground(new Color(102, 102, 102));
		Panel_Client.add(Panel_Top);
		Panel_Top.setLayout(null);
		
		JLabel lblConsultaProduto = new JLabel("CONSULTA CLIENTE");
		lblConsultaProduto.setForeground(Color.WHITE);
		lblConsultaProduto.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblConsultaProduto.setBounds(180, 4, 216, 28);
		Panel_Top.add(lblConsultaProduto);
		
		JLabel LB_Name = new JLabel("NOME");
		LB_Name.setForeground(new Color(0, 153, 255));
		LB_Name.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		LB_Name.setBounds(77, 102, 50, 14);
		Panel_Client.add(LB_Name);
		
		JLabel LB_Doc = new JLabel("CPF/CNPJ");
		LB_Doc.setForeground(new Color(0, 153, 255));
		LB_Doc.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		LB_Doc.setBounds(50, 138, 77, 24);
		Panel_Client.add(LB_Doc);
		
		TXT_Doc = new JTextField();
		TXT_Doc.setColumns(10);
		TXT_Doc.setBounds(138, 137, 299, 33);
		Panel_Client.add(TXT_Doc);
		
		JButton BT_Pesquisar = new JButton("PESQUISAR");
		BT_Pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet[] result = bd.ConsultarCliente(TXT_Name.getText(),TXT_Doc.getText());
				ResultSet rs = result[0];
				ResultSet count = result[1];
				
				try {
					count.next();
					int tm = count.getInt("tm");
					if(tm < 9) tm = 9;
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
						));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			}
		});
		BT_Pesquisar.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		BT_Pesquisar.setForeground(new Color(51, 153, 204));
		BT_Pesquisar.setBounds(336, 174, 101, 31);
		Panel_Client.add(BT_Pesquisar);
		
		Panel_Home = new JPanel();
		Panel_Card.add(Panel_Home, "name_28471731239464");
		Panel_Home.setLayout(null);
		
		Panel_Products = new JPanel();
		Panel_Card.add(Panel_Products, "name_30175098231902");
		Panel_Products.setLayout(null);
		
		TXT_Product = new JTextField();
		TXT_Product.setColumns(10);
		TXT_Product.setBounds(138, 93, 299, 33);
		Panel_Products.add(TXT_Product);
		
		JPanel Panel_ProductActions = new JPanel();
		Panel_ProductActions.setLayout(null);
		Panel_ProductActions.setBackground(new Color(102, 102, 102));
		Panel_ProductActions.setBounds(0, 0, 570, 39);
		Panel_Products.add(Panel_ProductActions);
		
		JPanel Panel_BT_Add_Products = new JPanel();
		
		Panel_BT_Add_Products.setLayout(null);
		Panel_BT_Add_Products.setBackground(new Color(102, 102, 102));
		Panel_BT_Add_Products.setBounds(0, 0, 136, 39);
		Panel_ProductActions.add(Panel_BT_Add_Products);
		
		JLabel label = new JLabel("ADICIONAR");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label.setBounds(45, 13, 91, 14);
		Panel_BT_Add_Products.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("Images\\Plus Math-26.png"));
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label_1.setBounds(10, 0, 30, 33);
		Panel_BT_Add_Products.add(label_1);
		
		JPanel Panel_BT_Edit_Products = new JPanel();
		
		Panel_BT_Edit_Products.setLayout(null);
		Panel_BT_Edit_Products.setBackground(new Color(102, 102, 102));
		Panel_BT_Edit_Products.setBounds(134, 0, 136, 39);
		Panel_ProductActions.add(Panel_BT_Edit_Products);
		
		JLabel label_2 = new JLabel("EDITAR");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label_2.setBounds(45, 13, 91, 14);
		Panel_BT_Edit_Products.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("Images\\Edit-26.png"));
		label_3.setVerticalAlignment(SwingConstants.BOTTOM);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label_3.setBounds(10, 0, 30, 33);
		Panel_BT_Edit_Products.add(label_3);
		
		JPanel Panel_BT_Delete_Products = new JPanel();
		
		Panel_BT_Delete_Products.setLayout(null);
		Panel_BT_Delete_Products.setBackground(new Color(102, 102, 102));
		Panel_BT_Delete_Products.setBounds(271, 0, 136, 39);
		Panel_ProductActions.add(Panel_BT_Delete_Products);
		
		JLabel label_4 = new JLabel("EXCLUIR");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label_4.setBounds(45, 13, 91, 14);
		Panel_BT_Delete_Products.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("Images\\Delete-26.png"));
		label_5.setVerticalAlignment(SwingConstants.BOTTOM);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label_5.setBounds(10, 0, 30, 33);
		Panel_BT_Delete_Products.add(label_5);
		
		JLabel LB_Product = new JLabel("PRODUTO");
		LB_Product.setForeground(new Color(0, 153, 255));
		LB_Product.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		LB_Product.setBounds(36, 102, 91, 14);
		Panel_Products.add(LB_Product);
		
		JLabel LB_Tipo = new JLabel("TIPO");
		LB_Tipo.setForeground(new Color(0, 153, 255));
		LB_Tipo.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		LB_Tipo.setBounds(79, 138, 37, 24);
		Panel_Products.add(LB_Tipo);
		
		JComboBox CB_tipo_produto = ComboBox_Tipo(138, 137, 299, 33);
		Panel_Products.add(CB_tipo_produto);
		
		JButton button = new JButton("PESQUISAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet[] result = bd.ConsultarProduto(TXT_Product.getText(), CB_tipo_produto.getSelectedItem());
				ResultSet rs = result[0];
				ResultSet count = result[1];
				
				try {
					count.next();
					int tm = count.getInt("tm");
					if(tm < 9) tm = 9;
					Object[][] tabela = new Object[tm][5];
					int i = 0;
					while(rs.next()){
						tabela[i][0] = rs.getInt("id_produto");
						tabela[i][1] = rs.getString("nome_produto");
						tabela[i][2] = rs.getString("descricao_tipo");
						tabela[i][3] = rs.getString("descricao_produto");
						tabela[i][4] = rs.getBigDecimal("preco_produto");
						
						i++;
					}
				
					Table_Product.setModel(new DefaultTableModel(
							tabela,
							new String[] {
									"Id", "Nome", "Tipo", "Descri\u00E7\u00E3o", "Pre\u00E7o"
							}
						));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setForeground(new Color(51, 153, 204));
		button.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		button.setBounds(336, 174, 101, 31);
		Panel_Products.add(button);
		
		JScrollPane ScrollPane_Products = new JScrollPane();
		ScrollPane_Products.setBounds(0, 235, 570, 271);
		Panel_Products.add(ScrollPane_Products);
		
		Table_Product = new JTable();
		Table_Product.setModel(new DefaultTableModel(
			tabelaArray,
			new String[] {
				"Id", "Nome", "Tipo", "Descri\u00E7\u00E3o", "Pre\u00E7o"
			}
		));
		Table_Product.getColumnModel().getColumn(4).setResizable(false);
		Table_Product.setShowVerticalLines(true);
		Table_Product.setBorder(new CompoundBorder());
		ScrollPane_Products.setViewportView(Table_Product);
		
		JPanel Panel_Dashboard = new JPanel();
		Panel_Card.add(Panel_Dashboard, "name_30922889312389");
		
		Panel_Add_Product = new JPanel();
		Panel_Card.add(Panel_Add_Product, "name_6273018122703");
		Panel_Add_Product.setLayout(null);
		
		JPanel Panel_Top_Add = new JPanel();
		Panel_Top_Add.setBounds(0, 0, 570, 39);
		Panel_Top_Add.setLayout(null);
		Panel_Top_Add.setBackground(new Color(102, 102, 102));
		Panel_Add_Product.add(Panel_Top_Add);
		
		JLabel LB_Adicionar_Cliente = new JLabel("ADICIONAR PRODUTO");
		LB_Adicionar_Cliente.setBounds(224, 5, 216, 28);
		Panel_Top_Add.add(LB_Adicionar_Cliente);
		LB_Adicionar_Cliente.setForeground(Color.WHITE);
		LB_Adicionar_Cliente.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		TXT_ProductName = new JTextField();
		TXT_ProductName.setBounds(67, 149, 441, 30);
		Panel_Add_Product.add(TXT_ProductName);
		TXT_ProductName.setColumns(10);
		
		JLabel LB_ProductName = new JLabel("NOME");
		LB_ProductName.setBounds(67, 129, 211, 22);
		LB_ProductName.setForeground(SystemColor.textHighlight);
		LB_ProductName.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LB_ProductName.setAlignmentY(0.0f);
		Panel_Add_Product.add(LB_ProductName);
		
		JLabel LB_ProductDescription = new JLabel("DESCRI\u00C7\u00C3O");
		LB_ProductDescription.setBounds(67, 190, 211, 22);
		LB_ProductDescription.setForeground(SystemColor.textHighlight);
		LB_ProductDescription.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LB_ProductDescription.setAlignmentY(0.0f);
		Panel_Add_Product.add(LB_ProductDescription);
		
		JTextArea TXTArea_ProductDescription = new JTextArea();
		TXTArea_ProductDescription.setBounds(67, 213, 441, 72);
		Panel_Add_Product.add(TXTArea_ProductDescription);
		
		JLabel LB_ProductPrice = new JLabel("PRE\u00C7O");
		LB_ProductPrice.setForeground(SystemColor.textHighlight);
		LB_ProductPrice.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LB_ProductPrice.setAlignmentY(0.0f);
		LB_ProductPrice.setBounds(67, 296, 211, 22);
		Panel_Add_Product.add(LB_ProductPrice);
		
		JTextField Spinner_ProductPrice = new JTextField();
		Spinner_ProductPrice.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Spinner_ProductPrice.setBounds(67, 321, 441, 29);
		Panel_Add_Product.add(Spinner_ProductPrice);
		
		JLabel LB_Type = new JLabel("TIPO");
		LB_Type.setForeground(SystemColor.textHighlight);
		LB_Type.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LB_Type.setAlignmentY(0.0f);
		LB_Type.setBounds(67, 59, 211, 22);
		Panel_Add_Product.add(LB_Type);
		
		JComboBox ComboBox_ProductType = ComboBox_Tipo(67, 81, 441, 30);
		Panel_Add_Product.add(ComboBox_ProductType);
		
		JPanel Panel_ProductAdd = new JPanel();
		
		Panel_ProductAdd.setBackground(SystemColor.textHighlight);
		Panel_ProductAdd.setBounds(67, 367, 441, 39);
		Panel_Add_Product.add(Panel_ProductAdd);
		Panel_ProductAdd.setLayout(null);
		
		JLabel LB_Add_Product = new JLabel("ADICIONAR");
		LB_Add_Product.setBounds(172, 7, 95, 24);
		LB_Add_Product.setForeground(Color.WHITE);
		LB_Add_Product.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LB_Add_Product.setAlignmentY(Component.TOP_ALIGNMENT);
		Panel_ProductAdd.add(LB_Add_Product);
		
		Panel_Edit_Product = new JPanel();
		Panel_Edit_Product.setLayout(null);
		Panel_Card.add(Panel_Edit_Product, "name_8504224837584");
		
		JPanel Panel_Edit_Top = new JPanel();
		Panel_Edit_Top.setLayout(null);
		Panel_Edit_Top.setBackground(new Color(102, 102, 102));
		Panel_Edit_Top.setBounds(0, 0, 570, 39);
		Panel_Edit_Product.add(Panel_Edit_Top);
		
		JLabel lblEditarProduto = new JLabel("EDITAR PRODUTO");
		lblEditarProduto.setForeground(Color.WHITE);
		lblEditarProduto.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblEditarProduto.setBounds(224, 5, 216, 28);
		Panel_Edit_Top.add(lblEditarProduto);
		
		TXT_Edit_Name = new JTextField();
		TXT_Edit_Name.setColumns(10);
		TXT_Edit_Name.setBounds(67, 149, 441, 30);
		Panel_Edit_Product.add(TXT_Edit_Name);
		
		JLabel LB_Edit_Name = new JLabel("NOME");
		LB_Edit_Name.setForeground(SystemColor.textHighlight);
		LB_Edit_Name.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LB_Edit_Name.setAlignmentY(0.0f);
		LB_Edit_Name.setBounds(67, 129, 211, 22);
		Panel_Edit_Product.add(LB_Edit_Name);
		
		JLabel LB_Edit_Description = new JLabel("DESCRI\u00C7\u00C3O");
		LB_Edit_Description.setForeground(SystemColor.textHighlight);
		LB_Edit_Description.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LB_Edit_Description.setAlignmentY(0.0f);
		LB_Edit_Description.setBounds(67, 190, 211, 22);
		Panel_Edit_Product.add(LB_Edit_Description);
		
		JTextArea TXTA_Edit_TextArea = new JTextArea();
		TXTA_Edit_TextArea.setBounds(67, 213, 441, 72);
		Panel_Edit_Product.add(TXTA_Edit_TextArea);
		
		JLabel LB_Edit_Price = new JLabel("PRE\u00C7O");
		LB_Edit_Price.setForeground(SystemColor.textHighlight);
		LB_Edit_Price.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LB_Edit_Price.setAlignmentY(0.0f);
		LB_Edit_Price.setBounds(67, 296, 211, 22);
		Panel_Edit_Product.add(LB_Edit_Price);
		
		JSpinner Spinner_Edit_Price = new JSpinner();
		Spinner_Edit_Price.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Spinner_Edit_Price.setBounds(67, 321, 441, 29);
		Panel_Edit_Product.add(Spinner_Edit_Price);
		
		JLabel LB_Edit_Type = new JLabel("TIPO");
		LB_Edit_Type.setForeground(SystemColor.textHighlight);
		LB_Edit_Type.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LB_Edit_Type.setAlignmentY(0.0f);
		LB_Edit_Type.setBounds(67, 59, 211, 22);
		Panel_Edit_Product.add(LB_Edit_Type);
		
		JComboBox ComboBox_Edit_Product = ComboBox_Tipo(67, 81, 441, 30);
		Panel_Edit_Product.add(ComboBox_Edit_Product);
		
		JPanel Panel_BT_Edit_Product = new JPanel();
		
		Panel_BT_Edit_Product.setLayout(null);
		Panel_BT_Edit_Product.setBackground(SystemColor.textHighlight);
		Panel_BT_Edit_Product.setBounds(67, 367, 441, 39);
		Panel_Edit_Product.add(Panel_BT_Edit_Product);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblEditar.setAlignmentY(0.0f);
		lblEditar.setBounds(172, 7, 95, 24);
		Panel_BT_Edit_Product.add(lblEditar);
		
		JPanel Panel_Sidebar = new JPanel();
		Panel_Sidebar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Panel_Sidebar.setVisible(false);
		Panel_Sidebar.setEnabled(false);
		Panel_Sidebar.setBounds(0, 178, 210, 513);
		contentPane.add(Panel_Sidebar);
		Panel_Sidebar.setLayout(null);
		
		JPanel Panel_SideDashboard = new JPanel();
		Panel_SideDashboard.setBounds(1, 44, 4, 53);
		Panel_Sidebar.add(Panel_SideDashboard);
		
		JPanel Panel_Sidebar_Dashboard = new JPanel();
		
		Panel_Sidebar_Dashboard.setBounds(7, 51, 193, 37);
		Panel_Sidebar.add(Panel_Sidebar_Dashboard);
		
		BT_Entrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(bd.Autenticar(TXT_Login.getText(), TXT_Password.getText())){
					Panel_Login.setVisible(false);
					Panel_Sidebar.setVisible(true);
					Panel_Client.setVisible(true);
				}
			}
		});
		Panel_Sidebar_Dashboard.setLayout(null);
		
		JLabel LB_Dashboard = new JLabel("DASHBOARD");
		LB_Dashboard.setForeground(SystemColor.textHighlight);
		LB_Dashboard.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		LB_Dashboard.setBounds(new Rectangle(41, 5, 142, 22));
		LB_Dashboard.setAlignmentY(Component.TOP_ALIGNMENT);
		Panel_Sidebar_Dashboard.add(LB_Dashboard);
		
		JLabel LB_ImgDashboard = new JLabel("");
		LB_ImgDashboard.setIcon(new ImageIcon("Images\\Dashboard Filled-32.png"));
		LB_ImgDashboard.setBounds(0, 2, 32, 32);
		Panel_Sidebar_Dashboard.add(LB_ImgDashboard);
		LB_ImgDashboard.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		LB_ImgDashboard.setAlignmentY(0.0f);
		
		JPanel Panel_Sidebar_Customers = new JPanel();
		
		Panel_Sidebar_Customers.setLayout(null);
		Panel_Sidebar_Customers.setBounds(7, 123, 173, 37);
		Panel_Sidebar.add(Panel_Sidebar_Customers);
		
		JLabel LB_Customers = new JLabel("CLIENTES");
		LB_Customers.setForeground(SystemColor.textHighlight);
		LB_Customers.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		LB_Customers.setBounds(new Rectangle(41, 5, 132, 22));
		LB_Customers.setAlignmentY(0.0f);
		LB_Customers.setBounds(41, 5, 100, 22);
		Panel_Sidebar_Customers.add(LB_Customers);
		
		JLabel LB_ImgCustomers = new JLabel("");
		LB_ImgCustomers.setIcon(new ImageIcon("Images\\Gender Neutral User-32.png"));
		LB_ImgCustomers.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		LB_ImgCustomers.setAlignmentY(0.0f);
		LB_ImgCustomers.setBounds(0, 2, 32, 32);
		Panel_Sidebar_Customers.add(LB_ImgCustomers);
		
		JPanel Panel_SideCustomers = new JPanel();
		Panel_SideCustomers.setBounds(1, 115, 4, 53);
		Panel_Sidebar.add(Panel_SideCustomers);
		
		JPanel Panel_Sidebar_Products = new JPanel();
		
		Panel_Sidebar_Products.setLayout(null);
		Panel_Sidebar_Products.setBounds(7, 191, 173, 37);
		Panel_Sidebar.add(Panel_Sidebar_Products);
		
		JLabel LB_Products = new JLabel("PRODUTOS");
		LB_Products.setForeground(SystemColor.textHighlight);
		LB_Products.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		LB_Products.setBounds(new Rectangle(41, 5, 132, 22));
		LB_Products.setAlignmentY(0.0f);
		LB_Products.setBounds(41, 5, 122, 22);
		Panel_Sidebar_Products.add(LB_Products);
		
		JLabel LB_ImgProducts = new JLabel("");
		LB_ImgProducts.setIcon(new ImageIcon("Images\\Controller-32.png"));
		LB_ImgProducts.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		LB_ImgProducts.setAlignmentY(0.0f);
		LB_ImgProducts.setBounds(0, 2, 32, 32);
		Panel_Sidebar_Products.add(LB_ImgProducts);
		
		JPanel Panel_SideProducts = new JPanel();
		Panel_SideProducts.setBounds(1, 186, 4, 53);
		Panel_Sidebar.add(Panel_SideProducts);
		
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
				Panel_Home.setVisible(true);
				Panel_Sidebar.setVisible(true);
				
			}
		});
		
	 
		
		Panel_Sidebar_Dashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Panel_SideDashboard.setBackground(SystemColor.textHighlight);
				LB_Dashboard.setForeground(Color.BLACK);
				LB_Dashboard.setFont(LB_Dashboard.getFont().deriveFont(Font.BOLD));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Panel_SideDashboard.setBackground(Color.white);
				LB_Dashboard.setForeground(SystemColor.textHighlight);
				LB_Dashboard.setFont(LB_Dashboard.getFont().deriveFont(Font.PLAIN));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Panel_SideDashboard.setBackground(SystemColor.textHighlight);
				LB_Dashboard.setForeground(Color.BLACK);
				LB_Dashboard.setFont(LB_Dashboard.getFont().deriveFont(Font.BOLD));
			}
		});
		
		Panel_Sidebar_Customers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Panel_SideCustomers.setBackground(SystemColor.textHighlight);
				LB_Customers.setForeground(Color.BLACK);
				LB_Customers.setFont(LB_Customers.getFont().deriveFont(Font.BOLD));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (Panel_Client.isVisible()) {
					Panel_SideCustomers.setBackground(SystemColor.textHighlight);
					LB_Customers.setForeground(Color.BLACK);
					LB_Customers.setFont(LB_Customers.getFont().deriveFont(Font.BOLD));
				
				} else {
					Panel_SideCustomers.setBackground(Color.white);
					LB_Customers.setForeground(SystemColor.textHighlight);
					LB_Customers.setFont(LB_Customers.getFont().deriveFont(Font.PLAIN));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Panel_SideCustomers.setBackground(SystemColor.textHighlight);
				LB_Customers.setForeground(Color.BLACK);
				LB_Customers.setFont(LB_Customers.getFont().deriveFont(Font.BOLD));
				TrocaDeTela(Panel_Client);
			}
		});
		
		Panel_Sidebar_Products.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Panel_SideProducts.setBackground(SystemColor.textHighlight);
				LB_Products.setForeground(Color.BLACK);
				LB_Products.setFont(LB_Products.getFont().deriveFont(Font.BOLD));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (Panel_Products.isVisible()) {
					Panel_SideProducts.setBackground(SystemColor.textHighlight);
					LB_Products.setForeground(Color.BLACK);
					LB_Products.setFont(LB_Products.getFont().deriveFont(Font.BOLD));
				}
				else{
					Panel_SideProducts.setBackground(Color.white);
					LB_Products.setForeground(SystemColor.textHighlight);
					LB_Products.setFont(LB_Products.getFont().deriveFont(Font.PLAIN));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Panel_SideProducts.setBackground(SystemColor.textHighlight);
				LB_Products.setForeground(Color.BLACK);
				LB_Products.setFont(LB_Products.getFont().deriveFont(Font.BOLD));
				TrocaDeTela(Panel_Products);
				
			}
		});
		
		Panel_ProductAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Panel_ProductAdd.setBackground(new Color(65, 105, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_ProductAdd.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
				double value = Double.parseDouble(Spinner_ProductPrice.getText());
				bd.InserirProduto(TXT_ProductName.getText(), TXTArea_ProductDescription.getText(), value, ComboBox_ProductType.getSelectedIndex());
				TXT_ProductName.setText("");
				TXTArea_ProductDescription.setText("");
				Spinner_ProductPrice.setText("");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		Panel_BT_Edit_Product.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Panel_BT_Edit_Product.setBackground(new Color(65, 105, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_BT_Edit_Product.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TrocaDeTela(Panel_Edit_Product);
			}
		});
		
		Panel_BT_Add_Products.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Panel_BT_Add_Products.setBackground(new Color(60, 179, 113));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_BT_Add_Products.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TrocaDeTela(Panel_Add_Product);
			}
		});
		
		Panel_BT_Edit_Products.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Panel_BT_Edit_Products.setBackground(new Color(60, 179, 113));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_BT_Edit_Products.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TrocaDeTela(Panel_Edit_Product);
			}
		});
		
		Panel_BT_Delete_Products.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Panel_BT_Delete_Products.setBackground(new Color(255, 51, 51));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_BT_Delete_Products.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TO DO
			}
		});
		
		contentPane.setVisible(true);
	}
	
	public void TrocaDeTela(JPanel panel){
		Panel_Client.setVisible(false);
		Panel_Products.setVisible(false);
		Panel_Add_Product.setVisible(false);
		Panel_Edit_Product.setVisible(false);
		Panel_Home.setVisible(false);
		
		panel.setVisible(true);

	}
	
	public JComboBox ComboBox_Tipo(int x, int y, int width, int height){
		ResultSet rs = bd.ConsultarTipoProduto();
		
		JComboBox ComboBox = new JComboBox();
		ComboBox.setFont(new Font("Segoe UI", Font.BOLD, 14));
		try{
		while(rs.next()) ComboBox.addItem(rs.getString(2));
		}catch(SQLException e){
			e.printStackTrace();
		}
		ComboBox.setBounds(x,y,width,height);	
		return ComboBox;
	}
}
