package upc.edu.pe.service.test;


import upc.edu.pe.service.PedidoService;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PedidoServiceTest {

	
	private PedidoService pedidoService = null;
	
	public PedidoServiceTest()
	{
		ApplicationContext context = 
				 new ClassPathXmlApplicationContext("/applicationContext.xml");
		this.pedidoService = (PedidoService) context.getBean("pedidoServiceClient");
	}
	
	
	@Test
	public void testRegistrarPedido()
    {
		
		int p1=
				pedidoService.registrarPedidos("1", "2");
		
		System.out.println(p1);
		
		Assert.assertEquals(12.03, p1,0);
		
		
    }
	
	
	
	
}
