package upc.edu.pe.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@SuppressWarnings("restriction")
@WebService
public interface PedidoService {


	public int registrarPedidos(@WebParam(name = "codigo") String codigo,
			@WebParam(name = "descripcion") String descripcion);
	
}
