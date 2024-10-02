package unidad1;

public class Objeto {

	// ATRIBUTOS
	private String nombre;
	private int posX;
	private int posY;

	// CONSTRUCTOR
	public Objeto(String nombre, int posX, int posY) {
		this.nombre = nombre;
		this.posX = posX;
		this.posY = posY;
	}

	// METODOS
	public String getNombre() {
		return nombre;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
