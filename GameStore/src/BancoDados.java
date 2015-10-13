import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class BancoDados {
	public BancoDados(){
		
	}
	
	public Connection ConectaBD(String connectUrl, String user, String senha) {
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			Connection con = DriverManager.getConnection(connectUrl, user, senha);
			System.out.println("Conex�o Realizada com sucesso");

			return con;
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			return null;
		} catch (Exception e){
			System.out.println("N�o foi possivel conectar" + e);
			return null;
		}
		
	}
	
	public ResultSet[] ConsultarCliente(Connection con){
		try{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente");
		
		Statement stmt1 = con.createStatement();
		ResultSet count = stmt1.executeQuery("SELECT COUNT(*) AS tm FROM Cliente");
		
		ResultSet[] result = new ResultSet[]{
				rs, count
		};
		System.out.println("Consulta realizada com sucesso");
		return result;
		
		}catch(Exception e){
			
		}
		return null;
	}
	
	
	public void CriarTabela(Connection con){
		try{
		String tabela_tipo_produto = 	"CREATE TABLE Tipo_Produto" +
				"(id_tipo int NOT NULL, " +
				"descricao_tipo varchar(100) NOT NULL, " +
				"PRIMARY KEY (id_tipo)) ";
		
		String tabela_produtos = "CREATE TABLE Produtos " +
				"(id_produto int NOT NULL, " +
				"descricao_produto varchar(50) NOT NULL, " +
				"nome_produto varchar(20), " + 
				"preco_produto decimal(10,2), " +
				"PRIMARY KEY (id_produto))"; 
		
		String games = "CREATE TABLE Games" +
				"(nome_game varchar(30) NOT NULL, " +
				"memory_required int, " +
				"numero_de_pl int, " +
				"detalhes varchar(50))";
		
		String console = "CREATE TABLE Consoles" +
				"(driver_type varchar(30) NOT NULL, " +
				"size int, " +
				"detalhes_consoles varchar(50))";		
		
		String acessorios = "CREATE TABLE Acessorios" + 
				"(nome_acessorio varchar(20) NOT NULL, " +
				"descricao_acessorio varchar(50) ," +
				"detalhes_acessorio varchar(50))";
		
		String cliente = "CREATE TABLE Cliente" +
				"(id_cliente int NOT NULL, " +
				"codigo_cliente varchar(15) NOT NULL, " +
				"nome_cliente varchar(20), " +
				"end_cliente varchar(20), " +
				"detalhes_cliente varchar(30), " +
				"PRIMARY KEY (id_cliente))";
		
		String pedido_cliente = "CREATE TABLE Pedido_Cliente" +
				"(id_pedido int NOT NULL, " +
				"data_pedido date, " +
				"detalhes_pedido varchar(50), " +
				"PRIMARY KEY(id_pedido))";
	
		String compras_cliente = "CREATE TABLE Compras_Cliente" +
				"(id_compras int NOT NULL, " +
				"data_compras date NOT NULL, " +
				"detalhes_compras varchar(50), " +
				"PRIMARY KEY(id_compras))";
		
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate(tabela_tipo_produto);
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
		
		}catch(Exception e){
			System.out.println("J� existi as tabelas");;
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


