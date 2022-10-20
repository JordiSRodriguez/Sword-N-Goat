import java.util.Random;
import java.util.Scanner;

public class Main {
	static Random rand = new Random();
	static Scanner sc = new Scanner(System.in);
	public static String nombreClase;
	public static String nombreJugador;
	public static int vidaJug;
	public static int vidaMaxJug;
	public static int dañoJug;
	public static int vidaEnemigo;
	public static int dañoEnemigo;
	public static String nombreEnemigo;
	public static boolean luchando = false;
	public static int numEnemigo = 1;
	public static String[] arrayNombreEnemigo = { "", "Una Piedra ", "Una Cabra ", "Una Gallina ", "La Avalancha de gallinas ", "El Rey Cabra "};

	private static void statsJug() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +nombreJugador + "\nVida: " + vidaJug + "\nDano: " + dañoJug + "\n");
	}

	private static void statsEnemigo() {
		System.out.println("Enemigo " + "\nVida: " + vidaEnemigo + "\nDano: " + dañoEnemigo + "\n");
	}

	private static void claseGuerrero() {
		nombreClase = "Guerrero";
		vidaMaxJug = 20;
		vidaJug = 20;
		dañoJug = 4;
	}

	private static void claseArquero() {
		nombreClase = "Arquero";
		vidaMaxJug = 14;
		vidaJug = 14;
		dañoJug = 6;
	}

	private static void crearEnemigo() {
		int[] arrayVidaEnemigo = { 1, 5, 7, 12, 15, 20 };
		int[] arrayDañoEnemigo = { 1, 1, 2, 4, 5, 7 };
		vidaEnemigo = arrayVidaEnemigo[numEnemigo];
		dañoEnemigo = arrayDañoEnemigo[numEnemigo];
		
	}

	private static void ataqueEnemigo() {
		System.out.println("El enemigo te ataca!");
		vidaJug = (int) (vidaJug - Math.random() * dañoEnemigo);
		if (vidaJug <= 0) {
			fin();
			System.exit(0);
		}
	}

	private static boolean ataque() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nAtacas al enemigo!");
		vidaEnemigo = vidaEnemigo - dañoJug;
		if (vidaEnemigo <= 0) {
			System.out.println("Has ganado!");
			return false;
		}
		return true;
	}

	private static void fin() {
		System.out.println(nombreJugador + " ha muerto!");
		System.out.println("HAS PERDIDO!");
		System.exit(0);
		return;
	}

	private static void combate() {
		String movimiento;
		nombreEnemigo = arrayNombreEnemigo[numEnemigo];
		System.out.println("\n\n\n\n\n\n" + nombreEnemigo + "se acerca");
		crearEnemigo();
		luchando = true;
		while (luchando = true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\n\n\nPulsa 'a' para atacar\nPulsa 'i' para ver stats \nPulsa 'h' para curarte");
			movimiento = sc.nextLine();
			if (movimiento.charAt(0) == 'a') {
				luchando = ataque();
				if (luchando == false) {
					System.out.println("\n\n\n\n\n\nHas acabado el combate");
					return;
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ataqueEnemigo();
			} else if (movimiento.charAt(0) == 'i') {
				statsJug();
				statsEnemigo();

			} else if (movimiento.charAt(0) == 'h') {
				int x = 5;
				System.out.println("Te curas...");
				vidaJug = vidaJug + x;
				if (vidaJug > vidaMaxJug) {
					vidaJug = vidaMaxJug;
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ataqueEnemigo();
			}
		}
	}

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Introduce el nombre de tu personaje: ");
			nombreJugador = sc.nextLine();
			System.out.println("\n\n\nElige tu clase: ");
			System.out.println("Escribe 'g' para guerrero");
			System.out.println("Escribe 'a' para arquero");
			System.out.println("Escribe 's' para salir");
			nomClase = sc.nextLine();
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
			if (nomClase.charAt(0) == 's') {
				System.out.println("TE HAS RENDIDO");
				System.exit(0);
			}
			
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
		}

	}

}