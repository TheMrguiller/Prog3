package clases;

public class Personaje {
	
	private String nombre;
	private int fuerza;
	private int vida;
	private int velocidad;
	
	public Personaje(String nombre, int fuerza, int vida, int velocidad) {
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.vida = vida;
		this.velocidad = velocidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", fuerza=" + fuerza + ", vida=" + vida + ", velocidad=" + velocidad
				+ "]";
	}
	
	/** Método para calcular un golpe en la lógica interna del programa
	 * @param enemigo personaje que recibe el golpe
	 */
	public void DarGolpe(Personaje enemigo) {
		enemigo.setVida((int) (enemigo.getVida() - this.getFuerza() * 0.5));
	}
}
