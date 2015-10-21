import java.awt.*;
import java.sql.*;
import javax.swing.JOptionPane;

import javax.swing.*;

public class CB_Item extends JComboBox  {
	
	public CB_Item(BancoDados bd, int x, int y, int width, int height){
		ResultSet rs = bd.ConsultarTipoProduto();
		
		setFont(new Font("Segoe UI", Font.BOLD, 14));
		addItem("Selecione um Tipo");
		try{
			while(rs.next()) addItem(rs.getString(2));
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null,e);
			
		}catch(Exception e){
			
		}
			setBounds(x,y,width,height);	
	}

}
