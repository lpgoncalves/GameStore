import java.sql.*;

public class Main {

	public static void main(String[] args) {
	
		String jdbc = "jdbc:sqlserver://localhost:1433;databaseName=GAMESTORE";
		
		BancoDados bd = new BancoDados();
		Connection con = bd.ConectaBD(jdbc, "sa", "123456");
		
		bd.CriarTabela(con);
		
	}

}

/*MAIN AQUI NESSA PORRA*/