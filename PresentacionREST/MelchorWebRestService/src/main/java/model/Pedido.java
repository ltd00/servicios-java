package model;

import java.util.Date;


public class Pedido {
	private int IdPedido;
	private String NroPedido;
	private String FechaPedido;
	private String TipoPedido;
	private String Asunto;

	public int getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}

	public String getNroPedido() {
		return NroPedido;
	}

	public void setNroPedido(String nroPedido) {
		NroPedido = nroPedido;
	}

	public String getFechaPedido() {
		return FechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		FechaPedido = fechaPedido;
	}

	public String getTipoPedido() {
		return TipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		TipoPedido = tipoPedido;
	}

	public String getAsunto() {
		return Asunto;
	}

	public void setAsunto(String asunto) {
		Asunto = asunto;
	}

}
