package service.impl;

import java.io.IOException;
import java.sql.CallableStatement;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.mysql.MySqlDBConn;

import service.PedidoService;

public class PedidoServiceImpl implements PedidoService {

	public PedidoServiceImpl() {
	}

	public int insertarPedido(String NroPedido, String FechaPedido,
			String TipoPedido, String Asunto) throws Exception {

		int rslt = 0;
		MySqlDBConn con = new MySqlDBConn();
		CallableStatement cs = null;
		String storeProcedure = "{CALL usp_InsertarPedido(?,?,?,?)}";

		try {
			cs = con.getConnection().prepareCall(storeProcedure);
			cs.setString(1, NroPedido);
			cs.setString(2, FechaPedido);
			cs.setString(3, TipoPedido);
			cs.setString(4, Asunto);
			cs.execute();
			rslt = 1;
		} catch (Exception ex) {
			throw ex;
		}

		return rslt;
	}

	public int insertarDetallePedido(String NroProducto, String Cantidad,
			String Prioridad, String Observacion) throws IOException,
			ParserConfigurationException, SAXException, Exception {
		int rslt = 0;
		MySqlDBConn con = new MySqlDBConn();
		CallableStatement csDet = null;
		String storeProcedureDet = "{CALL usp_InsertarDetallePedido(?,?,?,?)}";

		try {
			csDet = con.getConnection().prepareCall(storeProcedureDet);

			csDet.setString(1, NroProducto);
			csDet.setString(2, Cantidad);
			csDet.setString(3, Prioridad);
			csDet.setString(4, Observacion);
			csDet.execute();
			rslt = 1;
		} catch (Exception ex) {
			throw ex;
		}
		return rslt;
	}

}
