import java.util.Scanner;

public class insertsALaVez {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Número de inserts:");
		int cant=s.nextInt();
		s.nextLine();
		System.out.println("Nombre de la tabla:");
		String nomTab=s.nextLine();
		
		String res="Insert into "+nomTab+" values\n";
		String temp="";
		for(int i=0;i<cant;i++) {
			System.out.println("Insert "+(i+1));
			temp=s.nextLine();
			res+="(\"";
			//Si encuentra una coma escribe ","
			for(int j=0;j<temp.length();j++) {
				if(temp.charAt(j)==',') {
					res+="\",\"";
				}else res+=temp.charAt(j);
			}//forj
			res+="\"),\n";
		}//fori
		res=res.substring(0, res.length()-2)+";";
		System.out.println(res);
		
	}

}
