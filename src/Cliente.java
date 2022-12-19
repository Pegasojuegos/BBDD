
public class Cliente {
	private String DNI;
	private String nombreCliente;
	private String apellido1;
	private String apellido2;
	private int telefono;
	private String seguridadSocial;
	
	public Cliente() {
		DNI="";
		nombreCliente="";
		apellido1="";
		apellido2="";
		telefono=0;
		seguridadSocial="";
	}
	

	public String getSeguridadSocial() {
		return seguridadSocial;
	}

	public void setSeguridadSocial(String seguridadSocial) {
		this.seguridadSocial = seguridadSocial;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
				DNI = dNI;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
