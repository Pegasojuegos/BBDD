
public class DatosCliente2 {
	Cliente Grupo[];

	public DatosCliente2(int tamaño) {
		this.Grupo= new Cliente [tamaño];
	
		for (int i = 0; i < Grupo.length; i++) {
			Grupo[i] = new Cliente();
		}

		// Creo los DNI
		for (Cliente i : Grupo) {
			boolean esta=false;
			do {
				esta=true;
				int n = (int) (Math.random() * 99999998 + 1);
				int nlet = n % 23;
				char nif[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
						'H', 'L', 'C', 'K', 'E' };
				String dni=String.format("%08d%c",n,nif[nlet]);
				for (Cliente j : Grupo) {
					if(j.getDNI().equals(dni)) {
						esta=false;
					}//if
				}//for
				if(esta=true) {
					i.setDNI(dni);
				}
			}//doWhile
			while(esta==false);
		}

		//Añadir nombreCliente apellido1 apellido2
		String nombre[] = { "Andrés", "Crisiano", "Gerard", "Lionel", "Leo", "Ana", "Enzo", "Eric", "Eva", "Hugo",
				"Iván", "Juan", "Lara", "Leo", "Luz", "Mar", "Nora", "Raúl", "Sara", "Héctor", "Helena", "Isis",
				"Penélope", "Ulises", "Zeus", "Alba", "Alenajdro", "Álvaro", "Enma", "Lucas", "Lucía", "Manuel",
				"Mariana", "Martín", "Bernardo", "Esther", "Gabriel", "Isabel", "Jorge", "Lucía", "Marta", "Moisés",
				"Raquel", "Samuel", "Alberto", "Enrique", "Felipe", "Isabel", "Leticia", "Margarira" };

		String apellido[] = { "García", "García", "García", "García", "García", "Gonzalez", "Gonzalez", "Gonzalez",
				"Martín", "Martín", "Marín", "Vidal", "Rubio", "Alonso", "Ortega", "Gimenez", "Castillo", "Serra",
				"Dominguez", "Castro", "Ferrer", "Delgado", "Flores", "Roca", "Garrido", "Leon", "Pujol", "Font",
				"Soriano", "Vera", "Soto", "Domench", "Luque", "Prieto", "Tomas", "Valls", "Grau", "Arias", "Parra",
				"Calvo", "Rivas", "Guzman", "Crespo" };
		
		for (Cliente i : Grupo) {
			int nom=(int) (Math.random()*nombre.length-1)+1;
			int ape1=(int) (Math.random()*apellido.length-1)+1;
			int ape2=(int) (Math.random()*apellido.length-1)+1;
			i.setNombreCliente(nombre[nom]);
			i.setApellido1(apellido[ape1]);
			i.setApellido2(apellido[ape2]);
		
		}
		
		
		//Añade telefono
	for (Cliente i : Grupo) {
			boolean esta=false;
			do {
				esta=true;
				int n = (int) (Math.random() * 999999998 + 1);
				String tel=String.format("%09d", n);
				int telnum=Integer.parseInt(tel);
				
				if(tel.matches("[6-9][0-9]{8}")) {
				
					for (Cliente j : Grupo) {
						if(j.getTelefono()==(telnum)) {
							esta=false;
						}//ifTelnum
					}//forj
					
					if(esta=true) {
						i.setTelefono(telnum);
					}//ifTure
				}//ifMatch
				else esta=false;
			}//doWhile
			while(esta==false);
			
		}
	
	//Añade seguridadSocial
	for (Cliente i : Grupo) {
		boolean esta=false;
		do {
			esta=true;
			int nProv = (int) (Math.random() * 49 + 1);
			int n = (int) (Math.random() * 99999998 + 1);
			String num=String.format("%02d", nProv);
			num+=String.format("%08d", n);
			num+=String.format("%02d", n%97);
			for (Cliente j : Grupo) {
				if(j.getSeguridadSocial().equals(num)) {
					esta=false;
				}//ifTelnum
			}//forj
			if(esta=true) {
				i.setSeguridadSocial(num);
			}//ifTure
		}while(esta==false);
	}
		
	}
		
	public String toString() {
		String res="";
		for (Cliente i : Grupo) {
			res+=String.format("insert into Clientes values(\"%s\",\"%s\",\"%s\",\"%s\",\"%d\");\n",i.getDNI(),i.getNombreCliente(),i.getApellido1(),i.getApellido2(),i.getTelefono());
		}
		return res;
	}
	
	public String toString2() {
		String res="";
		for (Cliente i : Grupo) {
			res+=String.format("insert into Personal values(\"%s\",\"%s\",\"%s\");\n",i.getNombreCliente(),i.getDNI(),i.getSeguridadSocial());
		}
		return res;
	}
}
