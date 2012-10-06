package model;

public class DetallePedido {
    private String IdPedidoDet;

    private String  IdPedido;
    
    private String IdProducto;
    
    private String Cantidad;
    
    private String Prioridad;
    
    private String Observacion;

	public String getIdPedidoDet() {
		return IdPedidoDet;
	}

	public void setIdPedidoDet(String idPedidoDet) {
		IdPedidoDet = idPedidoDet;
	}

	public String getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(String idPedido) {
		IdPedido = idPedido;
	}

	public String getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(String idProducto) {
		IdProducto = idProducto;
	}

	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String cantidad) {
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
