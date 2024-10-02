package unidad1;

import java.util.ArrayList;

public class Inventario {

	private ArrayList<Objeto> objetos; // LISTA QUE ALMACENA LOS OBJETOS DEL INVENTARIO
	private int capacidadMaxima = 10; // CAPACIDAD MAXIMA DEL INVENTARIO

	// CONSTRUCTOR
	public Inventario() {
		objetos = new ArrayList<Objeto>(); // INICIALIZA LA LISTA DE OBJETOS
	}

	// METODO PARA AGREGA UN OBJETO AL INVENTARIO
	public void agregarObjeto(Objeto objeto) {
		// VERIFICAR SI HAY ESPACIO
		if (objetos.size() < capacidadMaxima) {
			objetos.add(objeto); // AGREGAR OBJETO A LA LISTA
			System.out.println("Objeto agregado al inventario.");
		} else {
			System.out.println("Inventario lleno. No se puede agregar más objetos.");
		}
	}

	// METODO PARA ELIMINAR UN OBJETO DEL INVENTARIO
	public void eliminarObjeto(Objeto objeto) {
		objetos.remove(objeto); // ELIMINA EL OBJETO
	}

	// METODO PARA MOSTRAR LOS OBJETOS EN EL INVENTARIO
	public void mostrarObjetos() {
		System.out.println("Inventario:");
		// ITERAR EN LA LISTA DE OBJETOS
		for (Objeto objeto : objetos) {
			// VERIFICAR SI EL OBJETO ES UN ARMA
			if (objeto instanceof Arma) {
				System.out.println("Arma: " + objeto.getNombre() + " - Daño: " + ((Arma) objeto).getPuntosDeAtaque());
			}
			// VERIFICAR SI EL OBJETO ES UNA POCIÓN DE SALUD
			else if (objeto instanceof PocionDeSalud) {
				System.out.println("Poción de salud: " + objeto.getNombre() + " - Cura: "
						+ ((PocionDeSalud) objeto).getCuracion());
			}
			// AGREGAR MAS OBJETOS
			else {
				System.out.println("Objeto: " + objeto.getNombre());
			}
		}
	}

	// METODO PARA VERIFICAR SI UN OBJETO ESTA EN EL INVENTARIO
	public boolean contieneObjeto(Objeto objeto) {
		return objetos.contains(objeto); // DEVUELVE TRUE SI EL OBJETO ESTA EN LA LISTA
	}

	// METODO PARA OBTENER LA CAMAPCIDAD MAXIMA
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	// METODO PARA OBJETENER EL NUMERO DE OBJETOS
	public int getNumeroDeObjetos() {
		return objetos.size(); // DEVUELVE LA CANTIDAD DE OBJETOS
	}
}
