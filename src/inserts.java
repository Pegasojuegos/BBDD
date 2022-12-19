import java.util.Scanner;

public class inserts {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Número de inserts:");
		int cant=s.nextInt();
		s.nextLine();
		System.out.println("Nombre de la tabla:");
		String nomTab=s.nextLine();
		
		String res="";
		String temp="";
		for(int i=0;i<cant;i++) {
			System.out.println("Insert "+(i+1));
			temp=s.nextLine();
			res+="insert into "+nomTab+" values(\"";
			//Si encuentra una coma escribe ","
			for(int j=0;j<temp.length();j++) {
				if(temp.charAt(j)==',') {
					if(temp.substring(j, j+4).equals("null")) {
						res=res.substring(0, res.length()-1);
						res+="null,";
						j=j+5;
						if(!temp.substring(j, j+4).equals("null"))res+="\"";
					}else res+="\",\"";
				}else res+=temp.charAt(j);
			}//forj
			res+="\");\n";
		}//fori
		System.out.println(res);
		
	}

}
