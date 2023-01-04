
public class DatosCliente2 {
	private Cliente Grupo[];
	private int contActs;
	private String DNIsEmpleados[][]={
			//Deportes 18
			{"","",""},//Escalada 3
			{"","",""},//Surf 3
			{"","",""},//Senderismo 3
			{"",""},//Ciclismo 2
			{"","","",""},//Hípica 4
			{"","",""},//Kayak 3
			//Gastromómicas
			{"",""},//Vinos 2
			{"",""},//Cervezas 2
			{"",""},//Quesos 2
			{"","","","",""},//Mixta 5
			{},//Picnic 0
			{""},//Ruta 1
			//Relajación
			{"","","",""},//Spa 4
			{"",""},//Meditación 2
			{"","","",""},//Masajes 4
			{"",""},//Baños
			//Espectáculos
			{"","","","",""},//Discoteca 5
			{"","","","","",""},//Shows 6
			{},//Cine 0
			{"","","","","","",""}//Fiesta disfraces 7
			};
		

	public DatosCliente2(int tamaño) {
		this.Grupo= new Cliente [tamaño];
		int empleados=(int) (tamaño*0.44);
		contActs=60-(int) (tamaño*0.56);
		for (int i = 0; i < Grupo.length; i++) {
			Grupo[i] = new Cliente();
		}

		// Creo los DNI
		for (Cliente i : Grupo) {
			boolean esta=false;
			do {
				esta=true;
				int n = (int) Math.round(Math.random() * 99999998 + 1);
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
	
	//Creo la cantidad de actividades a las que se dedicará cada empleado
	for(int i=empleados;i<Grupo.length;i++) {
		int extra=(int)(Math.random()*4);
		Grupo[i].setNumActs(1+extra);
		contActs=contActs-extra;
		
	}//fori
	
	//Doy actividades a todos los empleados
	boolean disponible;
	int emp;
	for(int i=0;i<DNIsEmpleados.length;i++) {
		for(Cliente a:Grupo) {
			a.setMismaAct(false);
		}
		for(int j=0;j<DNIsEmpleados[i].length;j++) {
			disponible=false;
			while(disponible==false) {
				emp=(int)((Math.random()*Grupo.length-empleados)+empleados);
				if(Grupo[emp].getNumActs()>0&&Grupo[emp].isMismaAct()==false) {
					Grupo[emp].setMismaAct(true);
					DNIsEmpleados[i][j]=Grupo[emp].getDNI();
					Grupo[emp].setNumActs(Grupo[emp].getNumActs()-1);
					disponible=true;
				}//if
			}//while
		}//forj
	}//fori
		
	}
		
	public String toString() {
		int clientes=(int) Math.round(Grupo.length*0.44);
		String res="";
		for (int i=0;i<clientes;i++) {
			res+=String.format("insert into Clientes values(\"%s\",\"%s\",\"%s\",\"%s\",\"%d\");\n",Grupo[i].getDNI(),Grupo[i].getNombreCliente(),Grupo[i].getApellido1(),Grupo[i].getApellido2(),Grupo[i].getTelefono());
		}
		return res;
	}
	
	public String toString2() {
		int empleados=(int) Math.round(Grupo.length*0.44);
		String res="";
		for (int i=empleados;i<Grupo.length;i++) {
			res+=String.format("insert into Personal values(\"%s\",\"%s\",\"%s\");\n",Grupo[i].getNombreCliente(),Grupo[i].getDNI(),Grupo[i].getSeguridadSocial());
		}
		return res;
	}
	
	public String toString3() {
		String res="";
		String Act="";
		int cont=0;
		for(int i=0;i<DNIsEmpleados.length;i++) {
			Act=TodasActividades.getAct(i);
			for(int j=0;j<DNIsEmpleados[i].length;j++) {
			res+=String.format("insert into Dirigido_por values(\"%s\",\"%s\");\n",DNIsEmpleados[i][j],Act);
			}//forj
		}//fori
		return res;
	}
}
