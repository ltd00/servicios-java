package service;

import junit.framework.TestCase;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TestService extends TestCase {

	// @Resource(type = UserServiceImpl.class)
	// private ServiceDefn service;
	Logger logger = Logger.getLogger(TestService.class);

	@Test
	public void testInsertPedidos() {

		// insertar pedidos
		System.out
				.println(invokeService("http://localhost:28080/MelchorWebRestService/rs/pedido-service/insertPedido/1/08-10-2012/P/Prueba"));
		// insertar detalle
		System.out
				.println(invokeService("http://localhost:28080/MelchorWebRestService/rs/pedido-service/insertDetallePedido/1/1000/1/Aprobado"));
		System.out
				.println(invokeService("http://localhost:28080/MelchorWebRestService/rs/pedido-service/insertDetallePedido/2/10/1/Aprobado"));

	}

	private String invokeService(String targetURL) {
		WebClient webClient = WebClient.create(targetURL);
		webClient.accept("application/json");
		return webClient.get(String.class);
	}
}
