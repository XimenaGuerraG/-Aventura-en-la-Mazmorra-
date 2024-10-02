package unidad1;

public abstract class Enemigo {
     
	//ATRIBUTOS 
	protected String nombre;
	protected int salud;
	protected int puntosDeAtaque;
	protected int defensa;

	// CONSTRUCTOR
	public Enemigo(String nombre, int salud, int puntosDeAtaque, int defensa) {
		this.nombre = nombre;
		this.salud = salud;
		this.puntosDeAtaque = puntosDeAtaque;
		this.defensa = defensa;
	}

	// METODO ABSTRACTO PARA ATACAR AL JUGADOR
	public abstract void atacar(Jugador jugador);

	// METODO ABSTRCATO PARA QUE EL ENEMIGO RECIBA DAÑO
	public abstract void recibirDaño(int daño);

	public String getNombre() {
		return nombre;
	}

	public int getSalud() {
		return salud;
	}

	public int getPuntosDeAtaque() {
		return puntosDeAtaque;
	}

	public int getDefensa() {
		return defensa;
	}

	// METODO QUE VERIFICA SI EL ENEMIGO ESTA VIVO
	public boolean estaVivo() {
		return salud > 0;
	}

	// METODO PROTEGIDO PARA DESTRUIR AL ENEMIGO
	protected void destruir() {
		System.out.println(nombre + " ha sido destruido.");
	}
}
