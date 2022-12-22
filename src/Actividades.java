
public class Actividades {
	public enum listaCategorías {deportes,gastronómicas,espectáculos,relajación};
	private  listaCategorías categoría;
	private String nombre;
	
	public Actividades(listaCategorías categoría){
		int temp;
		this.categoría=categoría;
		switch (categoría) {
		case deportes:
			temp=Math.random()
		default:
			throw new IllegalArgumentException("Unexpected value: " + categoría);
		}
	}
}
