import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class BancoDados {
	private Connection con;
	public BancoDados(){
		
	}
	
	public void ConectaBD(String connectUrl, String user, String senha) {
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			con = DriverManager.getConnection(connectUrl, user, senha);
			System.out.println("Conexão Realizada com sucesso");

		
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			
		} catch (Exception e){
			System.out.println("Não foi possivel conectar" + e);
			
		}
		
	}
	
	public ResultSet[] ConsultarCliente(String nome, String doc){
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente WHERE nome_cliente LIKE '"+ nome +"%' or codigo_cliente = '"+ doc +"'");
			
			Statement stmt1 = con.createStatement();
			ResultSet count = stmt1.executeQuery("SELECT COUNT(*) AS tm FROM Cliente WHERE nome_cliente LIKE '"+ nome +"%' or codigo_cliente = '"+ doc +"'");
			
			ResultSet[] result = new ResultSet[]{
					rs, count
			};
			System.out.println("Consulta realizada com sucesso");
			return result;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet[] ConsultarProduto(String produto, Object tipo){
		try{
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Produtos, Tipo_Produto "
					+ "WHERE nome_produto LIKE '"+ produto +"%' AND "
					+ "cd_tipo_produto = cd_tipo AND "
					+ "descricao_tipo = '"+ tipo +"'");
			
			Statement stmt1 = con.createStatement();
			ResultSet count = stmt1.executeQuery("SELECT COUNT(*) AS tm FROM Produtos WHERE nome_produto LIKE '"+ produto +"%'"); 
			
			ResultSet[] result = new ResultSet[]{
				rs, count	
			};
			
			System.out.println("Consulta realizada com sucesso" + produto);
			return result;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet ConsultarTipoProduto(){
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Tipo_Produto");
			
			return rs;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean Autenticar(String login, String senha){
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE login='"+login+"' AND senha='"+senha+"'");
			rs.next();
			if(rs.getRow() > 0)
				return true;
			else 
				return false;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public void InserirProduto(String nome, String descricao, double preco, int cd_tipo){
		try{
			cd_tipo++;
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO Produtos(descricao_produto, nome_produto, preco_produto, cd_tipo_produto) "
					+ "VALUES ('"+descricao+"', '"+nome+"', "+preco+", "+cd_tipo+")");			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void EditarProduto(int id, String nome, String descricao, double preco){
		try{
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE Produtos SET descricao_produto = '"+descricao+"', nome_produto='"+nome+"', preco_produto='"+preco+"' WHERE id_produto="+id+" ");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void ExcluirProduto(int id){
		try{
			Statement stmt = con.createStatement();
			int count = stmt.executeUpdate("DELETE FROM Produtos WHERE id_produto = "+id+"");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void CriarTabela(){
		try{
		String tabela_tipo_produto = 	"CREATE TABLE Tipo_Produto" +
				"(cd_tipo int NOT NULL, " +
				"descricao_tipo varchar(10) NOT NULL, " +
				"PRIMARY KEY (cd_tipo)) ";
		
		String tipo_game = "INSERT INTO Tipo_Produto VALUES (1, 'Games')";
		String tipo_console = "INSERT INTO Tipo_Produto VALUES (2, 'Consoles')";
		String tipo_acessorio = "INSERT INTO Tipo_Produto VALUES (3, 'Acessorios')";
		
		String tabela_produtos = "CREATE TABLE Produtos " +
				"(id_produto int IDENTITY(1,1) NOT NULL , " +
				"descricao_produto varchar(50) NOT NULL, " +
				"nome_produto varchar(20), " + 
				"preco_produto decimal(10,2), " +
				"cd_tipo_produto int," +
				"PRIMARY KEY (id_produto))"; 
		
		String games = "CREATE TABLE Games" +
				"(id_produto int NOT NULL, "+
				"nome_game varchar(30) NOT NULL, " +
				"memory_required int, " +
				"numero_de_pl int, " +
				"detalhes varchar(50))";
		
		String console = "CREATE TABLE Consoles" +
				"(id_produto int NOT NULL, " +
				"driver_type varchar(30) NOT NULL, " +
				"size int, " +
				"detalhes_consoles varchar(50))";		
		
		String acessorios = "CREATE TABLE Acessorios" + 
				"(id_produto int NOT NULL, " + 
				"nome_acessorio varchar(20) NOT NULL, " +
				"descricao_acessorio varchar(50) ," +
				"detalhes_acessorio varchar(50))";
		
		String cliente = "CREATE TABLE Cliente" +
				"(id_cliente int IDENTITY(1,1) NOT NULL, " +
				"codigo_cliente varchar(15) NOT NULL, " +
				"nome_cliente varchar(20), " +
				"end_cliente varchar(20), " +
				"detalhes_cliente varchar(30), " +
				"PRIMARY KEY (id_cliente))";
		
		String pedido_cliente = "CREATE TABLE Pedido_Cliente" +
				"(id_pedido int IDENTITY(1,1) NOT NULL, " +
				"data_pedido date, " +
				"detalhes_pedido varchar(50), " +
				"id_produto int, " +
				"id_cliente int NOT NULL, " +
				"PRIMARY KEY(id_pedido))";
	
		String compras_cliente = "CREATE TABLE Compras_Cliente" +
				"(id_compras int IDENTITY(1,1) NOT NULL, " +
				"data_compras date NOT NULL, " +
				"detalhes_compras varchar(50), " +
				"id_produto int, " +
				"id_cliente int NOT NULL, " +
				"PRIMARY KEY(id_compras))";
		
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate(tabela_tipo_produto);
		stmt.executeUpdate(tipo_game);
		stmt.executeUpdate(tipo_console);
		stmt.executeUpdate(tipo_acessorio);
		System.out.println("Tabela Tipo_Produto criada com sucesso");
		
		stmt.executeUpdate(tabela_produtos);
		System.out.println("Tabela Produtos criada com sucesso");
		
		stmt.executeUpdate(games);
		System.out.println("Tabela games criada com sucesso");
		
		stmt.executeUpdate(console);
		System.out.println("Tabela console criada com sucesso");
		
		stmt.executeUpdate(acessorios);
		System.out.println("Tabela acessorios criada com sucesso");
		
		stmt.executeUpdate(cliente);
		System.out.println("Tabela cliente criada com sucesso");
		
		stmt.executeUpdate(pedido_cliente);
		System.out.println("Tabela pedido_cliente criada com sucesso");
		
		stmt.executeUpdate(compras_cliente);
		System.out.println("Tabela compras_cliente criada com sucesso");
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}


/*
 * String sql = "INSERT INTO \"TIPO_PRODUTO\" (id_tipo, descricao_tipo) VALUES (?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, 1);
			stmt.setString(2, "Teste");
			stmt.executeUpdate();
*/


