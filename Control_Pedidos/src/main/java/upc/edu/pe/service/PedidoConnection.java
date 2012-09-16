package upc.edu.pe.service;


import java.sql.DriverManager;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PedidoConnection {

	 private DataSource data1;
	 
	 public int insertPedido(Pedido pedido){
		 
		 try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = 
			(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pedidos", "root", "i510635");
			  PreparedStatement st = 
			(PreparedStatement) con.prepareStatement("insert into pedidos values(?,?)");
			  st.setString(1, pedido.getCodigo());
			  st.setString(2, pedido.getDescripcion());

//			  int ph = Integer.parseInt(phone);
//			  st.setInt(5, ph);
			  st.executeUpdate();
			  } catch (Exception e) {
			  System.out.println(e.getMessage());
			  return 0;
			  }
			  return 1;
			  }
		   
		 
		 
		 
		 
		 
	 
}
