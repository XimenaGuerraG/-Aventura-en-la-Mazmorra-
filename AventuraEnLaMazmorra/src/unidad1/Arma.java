package unidad1;

public class Arma extends Objeto {
	// ATRIBUTOS
	private int puntosDeAtaque;

	// CONSTRUCTOR
	public Arma(String nombre, int puntosDeAtaque, int posX, int posY) {
		super(nombre, posX, posY);
		this.puntosDeAtaque = puntosDeAtaque;
	}

	public int getPuntosDeAtaque() {
		return puntosDeAtaque;
	}

}
