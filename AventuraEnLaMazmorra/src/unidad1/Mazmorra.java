package unidad1;

import java.util.ArrayList;
import java.util.Scanner;

public class Mazmorra {

	// ATRIBUTOS
	private Jugador jugador;
	private char[][] mapa; // REPRESENTACION DE LA MAZMORRA
	private Enemigo[][] enemigos; // MATRIZ QUE ALMACENA ENEMIGOS
	private int[][] muros; // MATRIZ QUE REPRESENTA A LOS ENEMIGOS
	private ArrayList<Objeto> objetos;// LISTA DE OBJETOS DE LA MAZMORRA

	// CONSTRUCTOR
	public Mazmorra() {
		jugador = new Jugador(""); // INICIALIZA AL JUGADOR
		mapa = new char[12][17]; // DIMENSION 12x17 DE LA MAZMORRA
		enemigos = new Enemigo[12][17]; // MATRIZ PARA LOS ENEMIGOS
		muros = new int[12][17]; // MATRIZ PARA LOS MUROS
		objetos = new ArrayList<>(); // INICIALIZA LA LISTA DE LOS OBJETOS
		inicializarMazmorra(); // LLAMA AL METODO PARA INICIAR LA MAZMORRA
	}

	// METODO PARA INICIAR LA MAZMORRA
	private void inicializarMazmorra() {
		for (int i = 0; i < 12; i++) {// INICIALIZA EL MAPA VACIO
			for (int j = 0; j < 17; j++) {
				mapa[i][j] = ' '; // ESPACIOS VACIOS
			}
		}

		// POSICIÓN DE LOS ENEMIGOS EN EL MAPA
		enemigos[3][14] = new EnemigoNivel1();
		enemigos[6][8] = new EnemigoNivel2();
		enemigos[9][9] = new EnemigoNivel3();

		// COLOCAIÓN DE MUROS ALREDEDOR
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 17; j++) {
				if (i == 0 || i == 11 || j == 0 || j == 16) {
					muros[i][j] = 1;
					mapa[i][j] = '#';
				}
			}
		}

		// SALAS DE LA MAZMORRA
		for (int f = 0; f < 3; f++) {
			for (int k = 6; k < 11; k++) {
				if (f == 0 || f == 2 || k == 6 || k == 10) {
					muros[f][k] = 1;
					mapa[f][k] = '#';
				}
			}
		}

		for (int y = 4; y < 5; y++) {
			for (int z = 0; z < 13; z++) {
				if (y == 4 || y == 4 || z == 0 || z == 12) {
					muros[y][z] = 1;
					mapa[y][z] = '#';
				}
			}
		}

		for (int o = 6; o < 9; o++) {
			for (int p = 12; p < 17; p++) {
				if (o == 6 || o == 8 || p == 12 || p == 16) {
					muros[o][p] = 1;
					mapa[o][p] = '#';
				}
			}
		}

		for (int u = 7; u < 8; u++) {
			for (int w = 4; w < 17; w++) {
				if (u == 7 || u == 7 || w == 4 || w == 16) {
					muros[u][w] = 1;
					mapa[u][w] = '#';
				}
			}
		}

		for (int n = 8; n < 9; n++) {
			for (int m = 4; m < 6; m++) {
				if (n == 8 || n == 9 || m == 4 || m == 6) {
					muros[n][m] = 1;
					mapa[n][m] = '#';
				}
			}
		}

		// Considera los bordes
		objetos.add(new PocionDeSalud(50, 3, 10)); // POCIÓN (CURACIÓN ,POSICIÓN EN X y Y)
		objetos.add(new PocionDeSalud(50, 5, 12));
		objetos.add(new PocionDeSalud(50, 10, 3));
		objetos.add(new Arma("Espada", 50, 3, 4));

	}

	// MENU PRINCIPAL DEL JUEGO
	public void mostrarMenu() {
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;
		while (!salir) {
			System.out.println();
			System.out.println("Bienvenido a Una Aventura en la Mazmorra");
			System.out.println();
			System.out.println("1. Iniciar un nuevo juego");
			System.out.println("2. Instrucciones");
			System.out.println("3. Salir");
			int opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				iniciarJuego();
				break;
			case 2:
				mostrarInstrucciones();
				break;
			case 3:
				salir = true;
				System.out.println("Adiós!");
				break;
			default:
				System.out.println("Opción inválida.");
			}
		}
	}

	// INSTRUCCIONES DEL JUEGO
	private void mostrarInstrucciones() {
		System.out.println("INSTRUCCIONES: ");
		System.out.println("Desplázate por la mazmorra, lucha contra enemigos, y recoge objetos");
		System.out.println("COMO MOVERSE POR LA MAZMORRA:");
		System.out.println(" W (arriba).");
		System.out.println(" A (izquierda).");
		System.out.println(" S (abajo).");
		System.out.println(" D (derecha).");
		System.out.println("SIMBOLOGIA");
		System.out.println("J (Representa al Jugador)");
		System.out.println("0 (Representa una Poción)");
		System.out.println("@ (Representa un enemigo)");
		System.out.println("i (Representa un Arma)");
		System.out.print("# (Representa un Muro)");
	}

	// METODO PARA INICIAL EL JUEGO
	public void iniciarJuego() {
		Scanner scanner = new Scanner(System.in);
		int posX = 2, posY = 2; // POSICIÓN DEL JUGADOR

		while (true) {
			mostrarMazmorra(posX, posY); // MUESTRA EL ESTATUS ACTUAL DE LA MAZMORRA
			System.out.println("Mover: W (arriba), A (izquierda), S (abajo), D (derecha).");
			String movimiento = scanner.next().toUpperCase(); // LEE EL MOVIMIENTO DEL JUGADOR

			// MOVIMIENTO DEL JUGADOR
			switch (movimiento) {
			case "W":
				if (posX > 0 && muros[posX - 1][posY] != 1) // SE MUEVE HACIA ARRIBA
					posX--;
				break;
			case "S":
				if (posX < mapa.length - 1 && muros[posX + 1][posY] != 1) // SE MUEVE HACIA ABAJO
					posX++;
				break;
			case "A":
				if (posY > 0 && muros[posX][posY - 1] != 1) // SE MUEVE HACIA LA IZQUIERDA
					posY--;
				break;
			case "D":
				if (posY < mapa[0].length - 1 && muros[posX][posY + 1] != 1) // SE MUEVE HACIA LA DERECHA
					posY++;
				break;
			default:
				System.out.println("Movimiento inválido.");
				continue;
			}

			// REVISA SI HAY ENEMIGOS EN LA POSICIÓN
			if (enemigos[posX][posY] != null) {
				System.out.println("¡Has encontrado a un enemigo!");
				iniciarCombate(enemigos[posX][posY]); // INICIA COMBATE
				enemigos[posX][posY] = null; // ELIMINA A LOS ENEMIGOS DESPUES DE DERROTARLOS
			}

			// REVISA SI HAY ALGUN OBJETO EN LA POSICIÓN
			for (Objeto objeto : objetos) {
				if (objeto.getPosX() == posX && objeto.getPosY() == posY) {
					if (objeto instanceof PocionDeSalud) {
						System.out.println("¡Has encontrado una Poción de salud!");
					} else if (objeto instanceof Arma) {
						System.out.println("¡Has encontrado una Espada!");
					}
					jugador.agregarAlInventario(objeto); // AGREGA OBJETOS AL INVENTARIO
					objetos.remove(objeto); // ELIMINA OBJETOS
					break;
				}
			}

		}
	}

	// MUESTRA LA MAZMORRA EN LA CONSOLA
	private void mostrarMazmorra(int posX, int posY) {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if (i == posX && j == posY) {
					System.out.print("J"); // J (REPRESENTA AL JUGADOR)
				} else if (muros[i][j] == 1) {
					System.out.print("#"); // # (REPRESENTA UN MURO)
				} else if (enemigos[i][j] != null) {
					System.out.print("@"); // @ (REPRESENTA UN ENEMIGO)
				} else if (hayPocionEn(i, j)) {
					System.out.print("0"); // 0 (REPRESENTA UNA POCIÓN)
				} else if (hayArmaEn(i, j)) {
					System.out.print("i"); // I (REPRESENTA UN ARMA)

				} else {
					System.out.print(" "); // REPRESENTA UNA CELDA VACIA
				}
			}
			System.out.println();
		}
	}

	// COMPRUEBA SI HAY OBJETOS EN LA CORDENADA
	private boolean hayPocionEn(int x, int y) {
		for (Objeto objeto : objetos) {
			if (objeto instanceof PocionDeSalud && objeto.getPosX() == x && objeto.getPosY() == y) {
				return true; // HAY UNA POCIÓN
			}
		}
		return false; // NO HAY POCIÓN
	}

	private boolean hayArmaEn(int x, int y) {
		for (Objeto objeto : objetos) {
			if (objeto instanceof Arma && objeto.getPosX() == x && objeto.getPosY() == y) {
				return true; // HAY UNA ARMA
			}
		}
		return false; // NO HAY ARMA
	}

	// METODO PARA INICIAR COMBATE
	private void iniciarCombate(Enemigo enemigo) {
		Scanner scanner = new Scanner(System.in);
		while (jugador.getSalud() > 0 && enemigo.estaVivo()) {
			System.out.println("1. Atacar");
			System.out.println("2. Usar poción");
			System.out.println("3. Usar Arma");
			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				jugador.atacar(enemigo); // JUGADOR ATACA AL ENEMIGO
				if (enemigo.estaVivo()) {
					enemigo.atacar(jugador); // ENEMIGO ATACAR AL JUGADOR , SI SIGUE VIVO
				}
				break;
			case 2:
				// USO DE POCIÓN EN EL INVENTARIO
				for (Objeto objeto : jugador.getInventario()) {
					if (objeto instanceof PocionDeSalud) {
						jugador.usarObjeto(objeto); // USA POCIÓN
						break;
					}
				}
				break;
			case 3:
				// USO DE ARMA EN EL INVENTARIO
				for (Objeto objeto : jugador.getInventario()) {
					if (objeto instanceof Arma) {
						jugador.usarObjeto(objeto); // USA LA ARMA
						break;
					}
				}
				break;

			default:
				System.out.println("Opción inválida.");
			}
		}

		// MENSAJE AL FINAL DEL COMBATE
		if (jugador.getSalud() <= 0) { // CUANDO LA SALUD DEL JUGADOR SEA MENOR A 0 , ESTE HA SIDO DERROTADO
			System.out.println("¡Has sido derrotado!");
		} else {
			System.out.println("¡Has derrotado al enemigo!");
		}
	}
}