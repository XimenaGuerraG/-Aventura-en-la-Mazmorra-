package unidad1;

import java.util.ArrayList;

public class Jugador {

	// ATRIBUTOS
	private String Nombre;
	private int Salud;
	private int Defensa;
	private int PuntosDeAtaque;
	private ArrayList<Objeto> inventario; // INVENTARIO DEL JUGADOR
	private int capacidadMaxima = 5; // CAPACIDAD MAXIMA DEL INVENTARIO

	// CONSTRUCTOR
	public Jugador(String Nombre) {
		this.setNombre("Caballero");
		this.setSalud(150);
		this.setPuntosDeAtaque(10);
		this.setDefensa(10);
		this.setInventario(new ArrayList<Objeto>()); // INICIALIZA EL INVENTARIO
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getSalud() {
		return Salud;
	}

	public void setSalud(int salud) {
		Salud = salud;
	}

	public int getPuntosDeAtaque() {
		return PuntosDeAtaque;
	}

	public void setPuntosDeAtaque(int puntosDeAtaque) {
		PuntosDeAtaque = puntosDeAtaque;
	}

	public int getDefensa() {
		return Defensa;
	}

	public void setDefensa(int defensa) {
		Defensa = defensa;
	}

	public ArrayList<Objeto> getInventario() {
		return inventario;
	}

	public void setInventario(ArrayList<Objeto> inventario) {
		this.inventario = inventario;
	}

	// METODO PARA ATACAR AL ENEMIGO
	public void atacar(Enemigo enemigo) {
		// CALCULA EL DAÑO BASADO EN LOS PUNTOS DE ATAQUE DEL JUGADOR MENOS LA DEFENSA DEL ENEMIGO
		int daño = this.PuntosDeAtaque - enemigo.getDefensa();
		enemigo.recibirDaño(daño); // LLAMA AL METODO PARA RECIBIR DAÑO EN EL ENEMIGO
		System.out.println("Has atacado al : " + enemigo.getNombre());
		System.out.println("Causando un daño de " + daño);
	}

	// METODO PARA USAR OBJETOS
	public void usarObjeto(Objeto objeto) {
		// SI EL OBJETO ES UNA POCIÓN DE SALUD
		if (objeto instanceof PocionDeSalud) {
			this.Salud += ((PocionDeSalud) objeto).getCuracion(); // RESTAURA SALUD
			System.out.println("Has restaurado tu salud");
			System.out.println("Salud actual: " + this.Salud);
		}
		// SI EL OBJETO ES UN ARMA
		else if (objeto instanceof Arma) {
			this.PuntosDeAtaque += ((Arma) objeto).getPuntosDeAtaque(); // AUMENTA LOS PUNTOS DE ATAQUE
			System.out.println("Has equipado un arma. Puntos de ataque: " + this.PuntosDeAtaque);
		}
		eliminarDelInventario(objeto); // ELIMINAR LOS OBJETOS DEL INVENTARIO
	}

	// METODO PARA AGREGAR UN OBJETO AL INVENTARIO
	public void agregarAlInventario(Objeto objeto) {
		// VERIFICAR SI EL INVENTARIO NO ESTA LLENO
		if (inventario.size() < capacidadMaxima) {
			if (inventario.add(objeto)) {
				System.out.println("Has agregado " + objeto.getNombre() + " a tu inventario.");
			} else {
				System.out.println("El objeto no se pudo agregar al inventario.");
			}
		} else {
			System.out.println("El inventario está lleno."); //MENSAJE SI EL INVENTARIO ESTA LLENO
		}
	}

	// METODO PARA ELIMINAR UN OBJETO DEL INVENTARIO
	public void eliminarDelInventario(Objeto objeto) {
		if (inventario.remove(objeto)) { // REMOVER, ELIMINAR UN OBJETO DEL INVENTARIO
			System.out.println("Has eliminado " + objeto.getNombre() + " de tu inventario.");
		} else {
			System.out.println("El objeto no se encuentra en el inventario.");
		}
	}

	//METODO PARA RECIBIR DAÑO
	public void recibirDaño(int daño) {
		this.Salud -= daño; // REDUCE LA SALUD DEL JUGADOR
		System.out.println("Has recibido " + daño + " puntos de daño");
		System.out.println("Salud actual: " + this.Salud);

		// VERIFICAR SI LA SALUD ES MENOR O IGUAL A 0
		if (this.Salud <= 0) {
			System.out.println("Has muerto."); // MENSAJE SI EL JUGADOR A MUERTO
		}
	}

	// METODO PARA EQUIPAR UN OBJETO
	public void equiparObjeto(Objeto objeto) {
		if (objeto instanceof Arma) {
			this.PuntosDeAtaque += ((Arma) objeto).getPuntosDeAtaque(); //AUMENTA LOS PUNTOS DE ATAQUE
			System.out.println("Has equipado un arma.");
			System.out.println("Puntos de ataque: " + this.PuntosDeAtaque);
		}
	}

	// METODO PARA DESQUIPAR UN OBJETO
	public void desequiparObjeto(Objeto objeto) {
		if (objeto instanceof Arma) {
			this.PuntosDeAtaque -= ((Arma) objeto).getPuntosDeAtaque(); // DISMINUYE LOS PUNTOS DE ATAQUE
			System.out.println("Has desequipado un arma.");
			System.out.println("Puntos de ataque: " + this.PuntosDeAtaque);
		}
	}

}
