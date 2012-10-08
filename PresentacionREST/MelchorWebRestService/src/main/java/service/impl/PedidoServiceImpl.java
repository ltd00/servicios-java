package service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mysql.MySqlDBConn;

import service.PedidoService;

public class PedidoServiceImpl implements PedidoService {

	public PedidoServiceImpl() {
	}

	public int insertarPedido(String NroPedido,
			String FechaPedido, String TipoPedido, String Asunto)
			throws Exception {

		MySqlDBConn con = new MySqlDBConn();
		CallableStatement cs = null;
		String storeProcedure = "{CALL usp_InsertarPedido(?,?,?,?)}";

		try {
			cs = con.getConnection().prepareCall(storeProcedure);
			cs.setString(1, NroPedido);
			cs.setString(2, FechaPedido);
			cs.setString(3, TipoPedido);
			cs.setString(4, Asunto);
			cs.execute();

			

		} catch (Exception ex) {
			throw ex;
		}

		return 1;
	}


	public int insertarDetallePedido(
 String NroProducto,
 String Cantidad,
 String Prioridad,
 String Observacion) throws IOException,
			ParserConfigurationException, SAXException, Exception {
		// TODO Auto-generated method stub
		
		MySqlDBConn con = new MySqlDBConn();
		CallableStatement csDet = null;
		String storeProcedureDet = "{CALL usp_InsertarDetallePedido(?,?,?,?)}";
		
		
		try {
			csDet = con.getConnection().prepareCall(storeProcedureDet);

			csDet.setString(1, NroProducto);
			csDet.setString(2, Cantidad);
			csDet.setString(3,Prioridad);
			csDet.setString(4, Observacion);
			csDet.execute();
		} catch (Exception ex) {
			throw ex;
		}
		
		return 1;
	}

}
