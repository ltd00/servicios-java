package service.impl;

import java.io.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import model.DetallePedido;
import model.Pedido;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mysql.MySqlDBConn;

import javax.jws.WebParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import service.PedidoService;

public class PedidoServiceImpl implements PedidoService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	public PedidoServiceImpl() {
	}

	@Override
	public String setPedido(String xmlpedido, String xmldetalle) throws Exception {

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		
		Document docPedido = b.parse(new ByteArrayInputStream(xmldetalle.getBytes("UTF-8")));
		NodeList booksPedido = docPedido.getElementsByTagName("Pedido");
		for (int i = 0; i < booksPedido.getLength(); i++) {
			Element book = (Element) booksPedido.item(i);
			Node idPedido = book.getElementsByTagName("idPedido").item(0);
			Node nroPedido = book.getElementsByTagName("NroPedido").item(1);
			Node fechaPedido = book.getElementsByTagName("FechaPedido").item(2);
			Node tipoPedido = book.getElementsByTagName("TipoPedido").item(3);
			Node asunto = book.getElementsByTagName("Asunto").item(4);
			
			
			Pedido pedido = new  Pedido();
			pedido.setAsunto(""+asunto);
			pedido.setFechaPedido(""+fechaPedido);
			pedido.setIdPedido(""+idPedido);
			pedido.setNroPedido(""+nroPedido);
			pedido.setTipoPedido(""+tipoPedido);
			
			
			insertPedidos(pedido);
		}
		Document doc = b.parse(new ByteArrayInputStream(xmldetalle.getBytes("UTF-8")));
		NodeList books = doc.getElementsByTagName("Detalle");
		for (int i = 0; i < books.getLength(); i++) {
			Element book = (Element) books.item(i);
			Node idPedido = book.getElementsByTagName("idPedido").item(0);
			Node idPedidoDet = book.getElementsByTagName("idPedidoDet").item(1);
			Node cantidad = book.getElementsByTagName("Cantidad").item(2);
			Node idProducto = book.getElementsByTagName("idProducto").item(3);
			Node observacion = book.getElementsByTagName("observacion").item(4);
			Node prioridad = book.getElementsByTagName("prioridad").item(5);
			
			DetallePedido detPedido = new  DetallePedido();
			detPedido.setIdPedido(""+idPedido);
			detPedido.setIdPedidoDet(""+idPedidoDet);
			detPedido.setCantidad(""+cantidad);
			detPedido.setIdProducto(""+idProducto);
			detPedido.setObservacion(""+observacion);
			detPedido.setPrioridad(""+prioridad);
			insertDetPedidos(detPedido);
		
		System.out.print(xmldetalle);
		}
		return xmldetalle;
	}
	public int  insertDetPedidos(DetallePedido pedidodet
			) {

		MySqlDBConn con = new MySqlDBConn();
		CallableStatement cs = null;
		String storeProcedure = "{CALL usp_insertar_detallePedido(?,?,?,?,?,?)}";

		try {
			System.out.println("Prepara Procedure");
			cs = con.getConnection().prepareCall(storeProcedure);
			cs.setString(1, pedidodet.getIdPedidoDet());
			cs.setString(2, pedidodet.getIdPedido());
			cs.setString(3, pedidodet.getCantidad());
			cs.setString(4, pedidodet.getIdProducto());
			cs.setString(5, pedidodet.getObservacion());
			cs.setString(6, pedidodet.getPrioridad());

			// System.out.println("Antes de Ejecutar Procedure");
			 cs.execute();		
			
			cs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 1;
	}


	
	public int  insertPedidos(Pedido pedido
			) {

		MySqlDBConn con = new MySqlDBConn();
		CallableStatement cs = null;
		String storeProcedure = "{CALL usp_insertar_Pedido(?,?,?,?,?,?)}";

		try {
			System.out.println("Prepara Procedure");
			cs = con.getConnection().prepareCall(storeProcedure);
			cs.setString(1, pedido.getAsunto());
			cs.setString(2, pedido.getFechaPedido());
			cs.setString(3, pedido.getIdPedido());
			cs.setString(4, pedido.getNroPedido());
			cs.setString(5, pedido.getTipoPedido());

			// System.out.println("Antes de Ejecutar Procedure");
			 cs.execute();		
			
			cs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 1;
	}

	
	
	
	

}
