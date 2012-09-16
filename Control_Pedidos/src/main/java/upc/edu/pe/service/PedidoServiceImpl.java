package upc.edu.pe.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;


@SuppressWarnings("restriction")
@WebService(endpointInterface="upc.edu.pe.service.PedidoService")

public class PedidoServiceImpl  implements PedidoService {
	/*  public Pedido buscarPersona(long legajo) {
		    Pedido pedido = new Pedido();
	       
	        return pedido;
	    }

		public List<Pedido> obtenerPedidos() {
			List<Pedido> lista = new ArrayList<Pedido>();
			Pedido pedido1 = new Pedido();
			pedido1.setCodigo("01");
			pedido1.setDescripcion("Mock de persona para el legajo " );
	        lista.add(pedido1);
			return lista;
		}*/
		public int registrarPedidos(@WebParam(name = "codigo") String codigo,
				@WebParam(name = "descripcion") String descripcion) {
			PedidoConnection pedidoCon = new PedidoConnection();
			Pedido pedido1 = new Pedido();
			pedido1.setCodigo( codigo);
			pedido1.setDescripcion(descripcion );
			
	        
	        
			return pedidoCon.insertPedido(pedido1);
		}

		
		
		
}
