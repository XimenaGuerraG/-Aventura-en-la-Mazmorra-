package unidad1;

public class EnemigoNivel2 extends Enemigo {

	// CONSTRUCTOR
	public EnemigoNivel2() {
		super("Soldado", 100, 10, 5); // INICIALIZA AL ENEMIGO (NOMBRE,SALUD, PUNTOS DE ATAQUE Y DEFENSA)
	}

	// IMPLEMENTACION DEL METODO ATACAR
	@Override
	public void atacar(Jugador jugador) {
		int daño = 30; // DAÑO QUE CAUSARA
		if (Math.random() < 0.1) { // 10% PROBABILIDAD DE FALLAR
			System.out.println("El Soldado falla el ataque.");
			return;
		}
		jugador.recibirDaño(daño); // LLAMA AL METODO RECIBIR DAÑO DEL JUGADOR
		System.out.println("El Soldado ataca causando " + daño);
	}

	// IMPLEMENTACION DEL METODO RECIBIR DAÑO
	@Override
	public void recibirDaño(int daño) {
		salud -= daño; // REDUCE LA SALUD DEL ENEMIGO
		System.out.println("El Soldado ha recibido " + daño);
		System.out.println("Salud restante: " + salud);

		if (!estaVivo()) { // VERIFICAR SI EL ENEMIGO ESTA VIVO
			destruir(); // LLAMA AL METODO DESTRUIR SI EL ENEMIGO ESTA MUERTO , DE ESTA MANERA
						// DESAPARECE DEL MAPA
		}
	}

}
