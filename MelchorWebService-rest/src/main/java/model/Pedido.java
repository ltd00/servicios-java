package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class Pedido {

    private String dni;

    private String  primerApellido;
    
    private String segundoApellido;
    
    private String nombres;
    
    private String fechaNacimiento;
    
    private String ubigeo;
    
    private String sexo;
    
    private String estadoCivil;
    
    	 
    
    
    public Pedido() {}

    
 

    public Pedido(String dni, String primerApellido, String segundoApellido,
			String nombres, String fechaNacimiento, String ubigeo, String sexo,
			String estadoCivil) {
		super();
		this.dni = dni;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.ubigeo = ubigeo;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
	}


    


	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
	}




	public String getPrimerApellido() {
		return primerApellido;
	}




	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}




	public String getSegundoApellido() {
		return segundoApellido;
	}




	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}




	public String getNombres() {
		return nombres;
	}




	public void setNombres(String nombres) {
		this.nombres = nombres;
	}




	public String getFechaNacimiento() {
		return fechaNacimiento;
	}




	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}




	public String getUbigeo() {
		return ubigeo;
	}




	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}




	public String getSexo() {
		return sexo;
	}




	public void setSexo(String sexo) {
		this.sexo = sexo;
	}




	public String getEstadoCivil() {
		return estadoCivil;
	}




	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}




	@Override
    public String toString() {
        return String.format("{dni=%s,nombre=%s}", dni, nombres + " " +
        		primerApellido + " " + segundoApellido) ;
    }

}
