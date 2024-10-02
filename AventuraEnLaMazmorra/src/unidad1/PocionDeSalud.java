package unidad1;

public class PocionDeSalud extends Objeto {
	private int curacion;

	// CONSTRUCTOR
	public PocionDeSalud(int curacion, int posX, int posY) {
		super("Poción de Salud", posX, posY); /// INICIALIZA NOMBRE Y POSICIÓN
		this.curacion = curacion;
	}

	public int getCuracion() {
		return curacion;
	}
}


