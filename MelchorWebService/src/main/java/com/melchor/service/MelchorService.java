package com.melchor.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.bean.Producto;

@WebService
public interface MelchorService {
	
	@WebResult(name="productos")
	ArrayList<Producto> ObtenerListaProductos(
			@WebParam(name = "IN01CODEMP") String IN01CODEMP,
			@WebParam(name = "IN01AA") String IN01AA,
			@WebParam(name = "IN01KEY") String IN01KEY,
			@WebParam(name = "IN01DESLAR") String IN01DESLAR,
			@WebParam(name = "vcodigoAlmacen") String vcodigoAlmacen,
			@WebParam(name = "vMes") String vMes);
}
