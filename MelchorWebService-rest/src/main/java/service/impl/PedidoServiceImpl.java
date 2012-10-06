package service.impl;

import java.io.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import model.DetallePedido;

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
	public String setPedido(String xmlStr) throws Exception {

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new ByteArrayInputStream(xmlStr
				.getBytes("UTF-8")));
		NodeList books = doc.getElementsByTagName("Detalle");
		for (int i = 0; i < books.getLength(); i++) {
			Element book = (Element) books.item(i);
			Node idPedido = book.getElementsByTagName("idPedido").item(0);
			Node idPedidoDet = book.getElementsByTagName("idPedidoDet").item(0);
			Node cantidad = book.getElementsByTagName("Cantidad").item(0);
			Node idProducto = book.getElementsByTagName("idProducto").item(0);
			Node observacion = book.getElementsByTagName("observacion").item(0);
			Node prioridad = book.getElementsByTagName("prioridad").item(0);
			
			DetallePedido detPedido = new  DetallePedido();
			detPedido.setIdPedido(""+idPedido);
			detPedido.setIdPedidoDet(""+idPedidoDet);
			detPedido.setCantidad(""+cantidad);
			detPedido.setIdProducto(""+idProducto);
			detPedido.setObservacion(""+observacion);
			detPedido.setPrioridad(""+prioridad);
			insertDetPedidos(detPedido);
		
		System.out.print(xmlStr);
		}
		return xmlStr;
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

	
	

}
