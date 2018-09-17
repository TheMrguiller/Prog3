package Practica0;

import javax.swing.JLabel;

public class CocheJuego extends Coche {
	JLabelGraficoAjustado label;
	public CocheJuego(String piloto,JLabelGraficoAjustado label) {
		super(piloto);
		this.label = label;
		// TODO Auto-generated constructor stub
	}
	public void mueve( double tiempoDeMovimiento ) {
		posX=posX+ miVelocidad * tiempoDeMovimiento* Math.cos(Math.toRadians(miDireccionActual));//Para cambiar a radianes
		posY =posY+ miVelocidad * tiempoDeMovimiento * Math.sin(Math.toRadians(miDireccionActual));
		label.setLocation(this.posX,this.posY );
		
		
	 }
}
