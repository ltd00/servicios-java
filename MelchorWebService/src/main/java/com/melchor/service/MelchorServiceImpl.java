package com.melchor.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.bean.Producto;
import com.mysql.MySqlDBConn;

@WebService(endpointInterface = "com.melchor.service.MelchorService")
public class MelchorServiceImpl implements MelchorService {

	// public List<Producto> ObtenerListaProductos(
	// @WebParam(name = "IN01CODEMP") String IN01CODEMP,
	// @WebParam(name = "IN01AA") String IN01AA,
	// @WebParam(name = "IN01KEY") String IN01KEY,
	// @WebParam(name = "IN01DESLAR") String IN01DESLAR,
	// @WebParam(name = "vcodigoAlmacen") String vcodigoAlmacen,
	// @WebParam(name = "vMes") String vMes) {
	//
	// System.out.println("Entro a la Lista");
	//
	// List<Producto> lista = new ArrayList<Producto>();
	//
	// Producto entidad = new Producto();
	// entidad.setId("1");
	// entidad.setDescripcion("Leche Gloria");
	// entidad.setUnidadMedida("Unidades");
	// entidad.setAlmacen("Minera Provincia");
	// entidad.setStock("45");
	//
	// lista.add(entidad);
	//
	// System.out.println("Se agrego Lista");
	//
	// return lista;
	// }

	public ArrayList<Producto> ObtenerListaProductos(
			@WebParam(name = "IN01CODEMP") String IN01CODEMP,
			@WebParam(name = "IN01AA") String IN01AA,
			@WebParam(name = "IN01KEY") String IN01KEY,
			@WebParam(name = "IN01DESLAR") String IN01DESLAR,
			@WebParam(name = "vcodigoAlmacen") String vcodigoAlmacen,
			@WebParam(name = "vMes") String vMes) {

		MySqlDBConn con = new MySqlDBConn();
		ArrayList<Producto> lista = new ArrayList<Producto>();
		CallableStatement cs = null;
		String storeProcedure = "{CALL usp_ControlPedido_Listarin01arti(?,?,?,?,?,?)}";

		try {
			System.out.println("Prepara Procedure");
			cs = con.getConnection().prepareCall(storeProcedure);
			cs.setString(1, IN01CODEMP);
			cs.setString(2, IN01AA);
			cs.setString(3, IN01KEY);
			cs.setString(4, IN01DESLAR);
			cs.setString(5, vcodigoAlmacen);
			cs.setString(6, vMes);

			// System.out.println("Antes de Ejecutar Procedure");
			ResultSet res = cs.executeQuery();
			// System.out.println("Ejecuto Procedure");
			Producto entidad = null;
			while (res.next()) {
				// System.out.println("Llenando Lista");
				entidad = new Producto();
				entidad.setIN01KEY(res.getString(1));
				entidad.setIN01DESLAR(res.getString(2));
				entidad.setIN01UNIMED(res.getString(3));
				entidad.setIN04CODALM(res.getString(4));
				entidad.setIN04STOCK(res.getString(5));
				lista.add(entidad);
			}
			res.close();
			cs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return lista;
	}

}
