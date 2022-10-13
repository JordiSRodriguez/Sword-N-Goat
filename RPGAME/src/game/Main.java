package game;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
public static double salud = 10;
static String [] enemigos = {"Piedra", "Cabra", "Gallina", "Avalancha de gallinas", "Rey Cabra"};

	public static void main(String[] args) {
		//String nombre = JOptionPane.showInputDialog("Introduce el nombre de tu héroe: ");
		//System.out.println(nombre);
		System.out.printf("%1.0f",salud);
		for (int i = 0; i < enemigos.length; i++) {
		}
	}
	
	public static void combate() {
		double dañop = Math.floor(Math.random()*3 +1);
		//System.out.printf("%1.0f", daño);
	}
	
	public static void habilidades(int num) {
		String[] habilidades = {"", "Ataque", "Defensa", "Poción"};
		switch (num) {
		case 1:
			habilidades[1] = "Has atacado a";
			break;
		case 2:
			habilidades[2] = "Te has defendido";
			
			break;
		case 3:
			habilidades[3] = "Te has curado 5HP";
			salud += 5;
			if (salud > 10) {
				salud = 10;
			}else if (salud == 10) {
				System.out.println("Tu salud ya está al máximo");
			}
			break;
		}
	}
}
