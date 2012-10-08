package service;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import junit.framework.TestCase;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TestService extends TestCase{

    // @Resource(type = UserServiceImpl.class)
    // private ServiceDefn service;
	Logger logger = Logger.getLogger(TestService.class);

    @Test
    public void testGetUsers() {
    	
    	// insertar pedidos
    	System.out.println(invokeService("http://localhost:8080/MelchorWebRestService/rs/pedido-service/insertPedido/1/12/11/1221"));
    	// insertar detalle
    	System.out.println(invokeService("http://localhost:8080/MelchorWebRestService/rs/pedido-service/insertDetallePedido/1/1000/1/prueba"));
    	System.out.println(invokeService("http://localhost:8080/MelchorWebRestService/rs/pedido-service/insertDetallePedido/2/1000/1/prueba"));
    	
    }

    private String invokeService(String targetURL) {
        WebClient webClient = WebClient.create(targetURL);
        webClient.accept("application/json");
        return webClient.get(String.class);
    }
}
