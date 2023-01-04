
public class TodasActividades {
	private Actividad todas[]=new Actividad[20];
	public static final String lista[][]= {
			{"deportes","escalada","surf","sederismo","ciclismo","hípica","kayak"},
			{"gastronómicas","cata de vinos","cata de cervezas","cata de quesos","cata mixta","picnic","ruta gastronómica"},
			{"relajación","spa","meditación","masajes","baños"},
			{"espectáculos","discoteca","shows","cine","fiesta de disfraces"}};
	
	public static String getAct(int numAct) {
		String res="";
		for(int i=0;i<lista.length;i++) {
			for(int j=1;j<lista[i].length;j++) {
				numAct--;
				if(numAct==0) {
					res=lista[i][j];
				}
			}//forj
		}//fori
		return res;
	}
	public TodasActividades() {
		int cont=0;
		for(int i=0;i<lista.length;i++) {
			for(int j=0;j<lista[i].length;j++) {
				if (j!=0) {
					todas[cont]=new Actividad(lista[i][j],lista[i][0]);
					cont++;
				}//if	
			}//forj
		}//fori
	}
	public String toString() {
		String res="";
		for (Actividad i : todas) {
			res+=String.format("insert into Actividades values(\"%s\",\"%s\");\n",i.getNombre(),i.getCategoría());
		}
		return res;
	}
}
