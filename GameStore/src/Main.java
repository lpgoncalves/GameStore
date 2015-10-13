import java.nio.channels.NetworkChannel;
import java.sql.*;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.AbstractBorderFactory;

public class Main {

	public static void main(String[] args) {
	
		String jdbc = "jdbc:sqlserver://localhost:1433;databaseName=GAMESTORE";
		
		BancoDados bd = new BancoDados();
		Connection con = bd.ConectaBD(jdbc, "sa", "123456");
		
		bd.CriarTabela(con);
		
		/*try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}*/
        // start application
        
		ApplicationFrame AF = new ApplicationFrame();
		AF.main(args);
	}

}

/*MAIN AQUI NESSA PORRA*/