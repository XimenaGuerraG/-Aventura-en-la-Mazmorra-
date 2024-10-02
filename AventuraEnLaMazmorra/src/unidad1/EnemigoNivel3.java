package unidad1;

public class EnemigoNivel3 extends Enemigo {

	// CONSTRUCTOR
	public EnemigoNivel3() {
		super("Mago", 100, 20, 10); // INICIALIZA AL ENEMIGO (NOMBRE,SALUD, PUNTOS DE ATAQUE Y DEFENSA)
	}

	// IMPLEMENTACION DEL METODO ATACAR
	@Override
	public void atacar(Jugador jugador) {
		int daño = 50; // DAÑO QUE CAUSARA
		if (Math.random() < 0.05) { // 5% PROBABILIDAD DE FALLAR
			System.out.println("El Mago falla el ataque.");
			return;
		}
		jugador.recibirDaño(daño); // LLAMA AL METODO RECIBIR DAÑO DEL JUGADOR
		System.out.println("El Mago ataca causando " + daño);
	}

	// IMPLEMENTACION DEL METODO RECIBIR DAÑO
	@Override
	public void recibirDaño(int daño) {
		salud -= daño; // REDUCE LA SALUD DEL ENEMIGO
		System.out.println("El Mago ha recibido " + daño);
		System.out.println("Salud restante: " + salud);

		if (!estaVivo()) { // VERIFICAR SI EL ENEMIGO ESTA VIVO
			destruir(); // LLAMA AL METODO DESTRUIR SI EL ENEMIGO ESTA MUERTO , DE ESTA MANERA
						// DESAPARECE DEL MAPA
		}
	}
}
