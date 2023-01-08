
public class DatosCliente2 {
	private int clientes;
	private int empleados;
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
		

	public DatosCliente2(int clientes,int empleados) {
		this.Grupo= new Cliente [empleados+clientes];
		this.clientes=clientes;
		this.empleados=empleados;
		contActs=60-empleados;
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
				"Raquel", "Samuel", "Alberto", "Enrique", "Felipe", "Isabel", "Leticia", "Margarita" };

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
	for(int i=clientes;i<Grupo.length;i++) {
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
				emp=(int)((Math.random()*empleados)+clientes);
				if(Grupo[emp].getNumActs()>0&&Grupo[emp].isMismaAct()==false) {
					Grupo[emp].setMismaAct(true);
					DNIsEmpleados[i][j]=Grupo[emp].getDNI();
					Grupo[emp].setNumActs(Grupo[emp].getNumActs()-1);
					disponible=true;
				}//if
			}//while
		}//forj
	}//fori
		
	//Asingo que pack ha comprado cada cliente, con su fecha y sus valoraciones
	for(int i=0;i<clientes;i++) {
		int pack=(int) ((Math.random()*100)+1);
		if(pack<=18) {
			Grupo[i].setNomPack("Mango");
			Grupo[i].setValPack(9);
		}else {
			if(pack<=25) {
				Grupo[i].setNomPack("Arándano");
				Grupo[i].setValPack(10);
			}else {
				if(pack<=30) {
					Grupo[i].setNomPack("Frambuesa");
					Grupo[i].setValPack(6);

				}else {
					if(pack<=40) {
						Grupo[i].setNomPack("Macedonia");
						Grupo[i].setValPack(8);
					}else {
						if(pack<=55) {
							Grupo[i].setNomPack("Papaya");
							Grupo[i].setValPack(9);
						}else {
							if(pack<=57) {
								Grupo[i].setNomPack("Albaricoque");
								Grupo[i].setValPack(5);
							}else {
								if(pack<=60) {
									Grupo[i].setNomPack("Manzana");
									Grupo[i].setValPack(7);
								}else {
									if(pack<=65) {
										Grupo[i].setNomPack("Ensalada de frutas");
										Grupo[i].setValPack(6);
									}else {
										if(pack<=70) {
											Grupo[i].setNomPack("Guayaba");
											Grupo[i].setValPack(10);
										}else {
											if(pack<=75) {
												Grupo[i].setNomPack("Chirimoya");
												Grupo[i].setValPack(10);
											}else {
												if(pack<=82) {
													Grupo[i].setNomPack("Galleta y leche");
													Grupo[i].setValPack(8);
												}else {
													if(pack<=88) {
														Grupo[i].setNomPack("Naruto");
														Grupo[i].setValPack(10);
													}else {
														Grupo[i].setNomPack("Fruta en almibar");
														Grupo[i].setValPack(10);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		//desvio un poco las valoraciones
		int rangDesv=(int)((Math.random()*100)+1);
		if (rangDesv<=5) {
			//5% de las veces será tal cual la valoración
		}else {
			if (rangDesv<=30) {
				Grupo[i].setValPack(Grupo[i].getValPack()-1);
			}else {
				if (rangDesv<=55) {
					Grupo[i].setValPack(Grupo[i].getValPack()+1);
				}else {
					if (rangDesv<=67) {
						Grupo[i].setValPack(Grupo[i].getValPack()-2);
					}else {
						if (rangDesv<=79) {
							Grupo[i].setValPack(Grupo[i].getValPack()+2);
						}else {
							if (rangDesv<=87) {
								Grupo[i].setValPack(Grupo[i].getValPack()-3);
							}else {
								if (rangDesv<=95) {
									Grupo[i].setValPack(Grupo[i].getValPack()+3);
								}else {
									if (rangDesv<=98) {
										Grupo[i].setValPack(Grupo[i].getValPack()-7);
									}else {
										Grupo[i].setValPack(Grupo[i].getValPack()+7);
									}
								}
							}
						}
					}
				}
			}
		}
		//Correción por si se sale de rango
		if(Grupo[i].getValPack()<1)Grupo[i].setValPack(1);
		if(Grupo[i].getValPack()>10)Grupo[i].setValPack(10);

	}//for
	
	//Creo las fechas de compra y viaje
	for(int i=0;i<clientes;i++) {
		int año;
		int mes;
		int día;
		int random;
		//Año
		random=(int)((Math.random()*27)+1);
		if(random<=1) {
			año=2013;
		}else {
			if(random<=3) {
				año=2014;
			}else {
				if(random<=6) {
					año=2015;
				}else {
					if(random<=9) {
						año=2016;
					}else {
						if(random<=12) {
							año=2017;
						}else {
							if(random<=15) {
								año=2018;
							}else {
								if(random<=17) {
									año=2019;
								}else {
									if(random<=18) {
										año=2020;
									}else {
										if(random<=23) {
											año=2021;
										}else {
											año=2022;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		mes=mes();
		día=día(mes,año);
		Grupo[i].setFechCompra(String.format("%04d-%02d-%02d", año,mes,día));
		int añovar=(int)(Math.random()+0.5);
		int mesvar;
		int díavar;
		if(añovar==0) {
			mesvar=(int)((Math.random()*(12-mes))+1);
			díavar=día(mes+mesvar,año);
			Grupo[i].setFechViaje(String.format("%04d-%02d-%02d", año,mes+mesvar,díavar));
		}else {
			mesvar=mes();
			díavar=día(mesvar,año+añovar);
			Grupo[i].setFechViaje(String.format("%04d-%02d-%02d", año+añovar,mesvar,díavar));
		}
		
	}//for
	
	}
	
	private int mes() {
		int mes;
		int random=(int)((Math.random()*4)+1);
		if(random<=1) {
			mes=(int)((Math.random()*5)+1);
		}else {
			if(random<=3) {
				mes=(int)((Math.random()*4)+6);
			}else {
				mes=(int)((Math.random()*3)+10);
			}
		}
		return mes;
	}//mes
	
	private int día(int mes,int año) {
		int día;
		if((mes<8&mes%2!=0)|(mes>=8&mes%2==0)) {
			día=(int)((Math.random()*31)+1);
		}else {
			if(mes==2) {
				if(año==2016|año==2020) {//Bisiesto
					día=(int)((Math.random()*29)+1);
				}else {
					día=(int)((Math.random()*28)+1);
				}
			}else {
				día=(int)((Math.random()*30)+1);
			}
		}
		return día;
	}//día
		
	public String toString() {
		String res="";
		for (int i=0;i<clientes;i++) {
			res+=String.format("insert into Clientes values(\"%s\",\"%s\",\"%s\",\"%s\",\"%d\");\n",Grupo[i].getDNI(),Grupo[i].getNombreCliente(),Grupo[i].getApellido1(),Grupo[i].getApellido2(),Grupo[i].getTelefono());
		}
		return res;
	}
	
	public String toString2() {
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
			Act=TodasActividades.getAct(i+1);
			for(int j=0;j<DNIsEmpleados[i].length;j++) {
			res+=String.format("insert into Dirigido_por values(\"%s\",\"%s\");\n",DNIsEmpleados[i][j],Act);
			}//forj
		}//fori
		return res;
	}
	
	public String toString4() {
		String res="";
		for (int i=0;i<clientes;i++) {
			res+=String.format("insert into Compran values(\"%s\",\"%s\",\"%d\",\"%s\",\"%s\");\n",Grupo[i].getDNI(),Grupo[i].getNomPack(),Grupo[i].getValPack(),Grupo[i].getFechCompra(),Grupo[i].getFechViaje());
		}
		return res;
	}
	
}
