package model;

public class PedidoDetalle {

	private int IdPedidoDet;
	private int IdPedido;
	private int IdProducto;
	private int Cantidad;
	private String Prioridad;
	private String Observacion;

	public int getIdPedidoDet() {
		return IdPedidoDet;
	}

	public void setIdPedidoDet(int idPedidoDet) {
		IdPedidoDet = idPedidoDet;
	}

	public int getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public String getPrioridad() {
		return Prioridad;
	}

	public void setPrioridad(String prioridad) {
		Prioridad = prioridad;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}

}
