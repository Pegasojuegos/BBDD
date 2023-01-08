
public class Pruebas {

	public static void main(String[] args) {
		int cont=0;
		for(int i=0;i<100;i++) {
			if((int) (Math.random()+0.5)==1) {
				cont++;
			}
			System.out.println((int) (Math.random()+0.5));
			System.out.println(cont);
		}
	}

}
