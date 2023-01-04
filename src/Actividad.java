
public class Actividad {
	public enum listaCategorías {deportes,gastronómicas,espectáculos,relajación};
	private  listaCategorías categoría;
	private String nombre;
	
	public Actividad(String nombre,String categoría){
		this.nombre=nombre;
		this.categoría=listaCategorías.valueOf(categoría);
	}

	public listaCategorías getCategoría() {
		return categoría;
	}

	public void setCategoría(listaCategorías categoría) {
		this.categoría = categoría;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
