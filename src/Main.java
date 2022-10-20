import java.util.Random;
import java.util.Scanner;
/*@autor Jordi, Andy, Stelian
 * @param none
 * @version 1*/
public class Main {
	/*En la primera parte vemos la introduccion de nuestro juego 
	 * tenemos en esta primera seccion las variables que utilizaremos por el resto del nuestro programa*
	 * Para facilitar la introduccion de datos mediante consola a nuestro jugador, utilizamos la linea de comando 
	 * static Random rand = new Random();*/
	static Random rand = new Random();
	static Scanner sc = new Scanner(System.in);
	public static String nombreClase;
	public static String nombreJugador;
	public static int vidaJug;
	public static int vidaMaxJug;
	public static int danoJug;
	public static int vidaEnemigo;
	public static int danoEnemigo;
	public static String nombreEnemigo;
	public static boolean luchando = false;
	public static int numEnemigo = 1;
	public static String[] arrayNombreEnemigo = { "", "Una Piedra ", "Una Cabra ", "Una Gallina ", "La Avalancha de gallinas ", "El Rey Cabra "};
	/*Como segundo tenemos una linea de System.out.println, donde se le pide a nuestro usuario que introduzca su nombre, 
	 cuyos datos se guardaran en variable "nombreJugador" */
	private static void statsJug() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +nombreJugador + "\nVida: " + vidaJug + "\nDano: " + danoJug + "\n");
	}
	/*Sacamos por consola la vida y el dano que hace el enemigo el cual sacara los datos con otro comando System.out.println */
	private static void statsEnemigo() {
		System.out.println("Enemigo " + "\nVida: " + vidaEnemigo + "\nDano: " + danoEnemigo + "\n");
	}
	/*Vemos la clase de "guerrero" en donde podemos ver la vida que se asigna al empezar y el dano que hace,
	estas ya vienen asignadas de manera fija con datos de tipo entero como se puede ver a continuacion*/
	private static void claseGuerrero() {
		nombreClase = "Guerrero";
		vidaMaxJug = 20;
		vidaJug = 20;
		danoJug = 4;
	}
	/*Vemos la otra clase que en este caso es la de "arquero", con diferencias notables a las de "guerrero" 
	 como la anterior tambien tiene los datos asignados de manera fija con dato de tipo entero*/
	private static void claseArquero() {
		nombreClase = "Arquero";
		vidaMaxJug = 14;
		vidaJug = 14;
		danoJug = 6;
	}
	/*Asignamos la vida del enemigo con datos de tipo entero que van a variar segun el enemigo que nos toque*/
	private static void crearEnemigo() {
		int[] arrayVidaEnemigo = { 1, 5, 7, 12, 15, 20 };
		int[] arrayDañoEnemigo = { 1, 1, 2, 4, 5, 7 };
		vidaEnemigo = arrayVidaEnemigo[numEnemigo];
		danoEnemigo = arrayDañoEnemigo[numEnemigo];
		
	}
	/*En el caso de ataque agregamos un Math.random multipicado multiplicado por la variable "danoEnemigo"
	 donde se genera el ataque con un numero aleatorio
	 dando variedad asi al combate, */
	private static void ataqueEnemigo() {
		System.out.println("El enemigo te ataca!");
		vidaJug = (int) (vidaJug - Math.random() * danoEnemigo);
		if (vidaJug <= 0) {
			fin();
			System.exit(0);
		}
	}
	/*En el caso de nuestro ataque varia segun el heroe que hayamos elegido*/
	private static boolean ataque() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nAtacas al enemigo!");
		vidaEnemigo = vidaEnemigo - danoJug;
		if (vidaEnemigo <= 0) {
			System.out.println("Has ganado!");
			return false;
		}
		return true;
	}
	/*La funcion fin solo se presentara cuando nuestro heroe pierda toda su vida
	 dando fin a nuestra ejecucion del programa*/
	private static void fin() {
		System.out.println(nombreJugador + " ha muerto!");
		System.out.println("HAS PERDIDO!");
		System.exit(0);
		return;
	}
	/*El desarrollo del combate se realiza mediante un bucle while que lo va repitiendo segun el ataque y la vida 
	 que tengamos mas la vida y el ataque del enemigo*/
	private static void combate() {
		String movimiento;
		nombreEnemigo = arrayNombreEnemigo[numEnemigo];
		//Segun el valor de la variable numEnemigo nos aparecera un enemigo u otro
		System.out.println("\n\n\n\n\n\n" + nombreEnemigo + "se acerca");
		crearEnemigo();
		//Se creara un enemigo
		luchando = true;
		while (luchando = true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Desplegaremos un menu de opciones
			System.out.println("\n\n\nPulsa 'a' para atacar\nPulsa 'i' para ver stats \nPulsa 'h' para curarte");
			movimiento = sc.nextLine();
			if (movimiento.charAt(0) == 'a') {
				luchando = ataque();
				//Se podra usar la habilidad de ataque hasta terminar el combate
				if (luchando == false) {
					System.out.println("\n\n\n\n\n\nHas acabado el combate");
					return;
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ataqueEnemigo();
			} else if (movimiento.charAt(0) == 'i') {
				statsJug();
				statsEnemigo();
				//Al usar la opcion de info se desplegaran las estadisticas del jugador y del enemigo
			} else if (movimiento.charAt(0) == 'h') {
				int x = 5;
				System.out.println("Te curas...");
				vidaJug = vidaJug + x;
				if (vidaJug > vidaMaxJug) {
					vidaJug = vidaMaxJug;
				}
				//Si usamos la opcion h el jugador se curara 5 de vida
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ataqueEnemigo();
			}
			//Al final de curarse o atacar, recibiremos un ataque del enemigo
		}
	}
	/*El inicio de nuestra historia empieza contada por println para poner en contexto a nuestro jugador y dando inicio a nuestra aventura*/
	public static void main(String[] args) {
		String nomClase;
		int num = 2;
		while (num > 1) {
			System.out.println("Nuestro heroe camina por el prado...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Espera, no tiene nombre!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//Introducimos el nombre del personaje en la variable nombreJugador
			System.out.println("Introduce el nombre de tu personaje: ");
			nombreJugador = sc.nextLine();
			//Elegimos nuestra clase o detenemos el juego
			System.out.println("\n\n\nElige tu clase: ");
			System.out.println("Escribe 'g' para guerrero");
			System.out.println("Escribe 'a' para arquero");
			System.out.println("Escribe 's' para salir");
			nomClase = sc.nextLine();
			//En caso de que se introduzca algo distinto a esas opciones se repetira el menu hasta que se elija una opcion correcta
			while (nomClase.charAt(0) != 'g' && nomClase.charAt(0) != 'a' && nomClase.charAt(0) != 's') {
				System.out.println("Escribe 'g' para guerrero");
				System.out.println("Escribe 'a' para arquero");
				System.out.println("Escribe 's' para salir");
				nomClase = sc.nextLine();
			}
			if (nomClase.charAt(0) == 'g') {
				claseGuerrero();
				statsJug();
			}
			if (nomClase.charAt(0) == 'a') {
				claseArquero();
				statsJug();
			}
			//Cada clase tiene distintas stats que se desplegaran al elegirla
			if (nomClase.charAt(0) == 's') {
				System.out.println("TE HAS RENDIDO");
				System.exit(0);
			}
			//Al rendirnos se detendra el codigo
			
			for (int enemigoActual = 1; enemigoActual <= 5; enemigoActual++) {
				while (numEnemigo == enemigoActual) {
					combate();
					numEnemigo++;
				}
				if (numEnemigo >= 6) {
					System.out.println("Felicidades, te has pasado el juego! :)");
					System.exit(0);
				}
				System.out.println("Zona despejada, continua\n");
			}
			//Este bucle for guardara el enemigo en el que nos encontramos y hara que el sistema de enemigos funcione continuamente hasta eliminarlos a todos
		}

	}

}