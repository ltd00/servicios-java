package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pedido-service/")
@Produces("application/xml")
public interface PedidoService {
	

	    @GET
	    @Path("/pedido")
	    @Produces({"application/xml", "application/json"})
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	    public String setPedido(@FormParam("xmlStr") String xmlStr) throws Exception ;

	}