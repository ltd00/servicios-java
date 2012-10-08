package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

@Path("/pedido-service/")
public interface PedidoService {

	@GET
	@Path("/insertPedido/{NroPedido}/{FechaPedido}/{TipoPedido}/{Asunto}")
	@Produces("application/json")
	public int insertarPedido(
			@PathParam("NroPedido") String NroPedido,
			@PathParam("FechaPedido") String FechaPedido,
			@PathParam("TipoPedido") String TipoPedido,
			@PathParam("Asunto") String Asunto) throws IOException,
			ParserConfigurationException, SAXException, Exception;

	@GET
	@Path("/insertDetallePedido/{NroProducto}/{Cantidad}/{Prioridad}/{Observacion}")
	@Produces("application/json")
	public int insertarDetallePedido(
			@PathParam("NroProducto") String NroProducto,
			@PathParam("Cantidad") String Cantidad,
			@PathParam("Prioridad") String Prioridad,
			@PathParam("Observacion") String Observacion
			
			) throws IOException,
			ParserConfigurationException, SAXException, Exception;
	
	
	

}
