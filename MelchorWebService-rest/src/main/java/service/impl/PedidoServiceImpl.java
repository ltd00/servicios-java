package service.impl;

import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
			Node IdItem = book.getElementsByTagName("IdItem").item(0);
			Node Cantidad = book.getElementsByTagName("Cantidad").item(0);
			System.out.println(IdItem.getTextContent());
			System.out.println(Cantidad.getTextContent());
		}
		System.out.print(xmlStr);
		return xmlStr;
	}

}
