package Practica0;


public class Coche {
	private double miVelocidad; // Velocidad en pixels/segundo
	 protected double miDireccionActual; // Dirección en la que estoy mirando en grados (de 0 a 360)
	 protected double posX; // Posición en X (horizontal)
	 protected double posY; // Posición en Y (vertical)
	 private String piloto; // Nombre de piloto
	
	 public double getMiVelocidad() {
		return miVelocidad;
	}

	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}

	public double getMiDireccionActual() {
		return miDireccionActual;
	}

	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public Coche(String piloto) {
		miVelocidad=0;
		miDireccionActual=0;
		posX=0;
		posY=0;
		this.piloto=piloto;
	}
	@Override
	public String toString() {
		String datos="Nombre: "+piloto+",Posicion:("+posX+","+posY+"),Velocidad:"+miVelocidad+",Direccion del coche:"+miDireccionActual;
		return datos;
	}
	
	public void acelera( double aceleracion ) {
		this.miVelocidad= aceleracion + miVelocidad;
	 } 
	public void giro (double giro) {
		this.miDireccionActual= miDireccionActual + giro;
	}
	public void mueve( double tiempoDeMovimiento ) {
		
		posX= miVelocidad * tiempoDeMovimiento* Math.cos(Math.toRadians(miDireccionActual));//Para cambiar a radianes
		posY = miVelocidad * tiempoDeMovimiento * Math.sin(Math.toRadians(miDireccionActual));
		
	 }

	
}
