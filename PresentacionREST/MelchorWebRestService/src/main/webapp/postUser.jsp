<!DOCTYPE html>
<html>
<head>
<title>INSERTAR PEDIDOS</title>
</head>
<body>	
	@PathParam("NroPedido") String NroPedido,
			@PathParam("FechaPedido") String FechaPedido,
			@PathParam("TipoPedido") String TipoPedido,
			@PathParam("Asunto") String Asunto
			
	<form action="rs/pedido-service/insertPedido" method="GET">
		<label for="NroPedido">NroPedido</label>
		<textarea name="NroPedido"></textarea>
		<label for="FechaPedido">FechaPedido</label>
		<textarea name="FechaPedido"></textarea>
		<label for="TipoPedido">TipoPedido</label>
		<textarea name="TipoPedido"></textarea>
		<label for="Asunto">Asunto</label>
		<textarea name="Asunto"></textarea>

	<input type="submit" value="Submit" />
 </form>

</body>
</html>