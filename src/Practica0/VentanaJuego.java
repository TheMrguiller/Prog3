package Practica0;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class VentanaJuego extends JFrame {
	double tiempo=0;
	boolean sigue=true;
	VentanaJuego(){
		
		//Inicio de ventana
		setTitle("juego");
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo( null );
		setResizable(false);
		//Creacion de componentes
		
		JPanel panelprincipal = new JPanel();
		JPanel panelinferiro = new JPanel();
		JButton botonacelerar= new JButton("Acelerar");
		JButton botonfrenar = new JButton("Frenar");
		JButton botonizq = new JButton("Girarizq");
		JButton botondere = new JButton("Girardere");
		JLabelGraficoAjustado label = new JLabelGraficoAjustado("", 100, 100);
		//modificaciones
		label.setImagen("src\\coche.PNG");
		label.setVisible(true);
		label.setOpaque(false);
		panelprincipal.setOpaque(false);
		panelprincipal.setLayout(null);
		panelinferiro.setOpaque(false);
		label.setRotacion(Math.toRadians(90));
		//Elementos
		CocheJuego coche = new CocheJuego("Piloto", label);
		
		//Añadir componentes a contenedores
		this.add(panelprincipal,BorderLayout.CENTER);
		this.add(panelinferiro, BorderLayout.SOUTH);
		panelinferiro.add(botonacelerar);
		panelinferiro.add(botonfrenar);
		panelinferiro.add(botonizq);
		panelinferiro.add(botondere);
		panelprincipal.add(label);
		//Eventos
		botonacelerar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				coche.acelera(1);
				
			}
		});
		botonfrenar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-1);
				
			}
		});
		botonizq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.giro(-20);
				label.setRotacion(Math.toRadians(90)+Math.toRadians(coche.miDireccionActual));
				
				
			}
		});
		botondere.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.giro(20);
				label.setRotacion(Math.toRadians(90)+Math.toRadians(coche.miDireccionActual));
				
			
			}
		});
		
		Thread hilo = new Thread() {
			public void run() {
				try {
					while(sigue) {
					Thread.sleep(200);
					tiempo= tiempo + 200;
					coche.mueve(tiempo/1000);
					label.setLocation(coche.posX,coche.posY );
					 
					
					
				
					label.revalidate();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
				
	};
		Thread hiloChoque = new Thread() {
			public void run() {
				try {
					while(sigue) {
					
					double direccionanterior=coche.miDireccionActual;
					double direccionnueva=900;//Ejemplo imposible
					double velocidad = coche.getMiVelocidad();
					if(direccionanterior != direccionnueva) {
					if(coche.posX<=0 || coche.posY<=0 ) {
						
						coche.setMiVelocidad(0);
						coche.setMiDireccionActual(coche.getMiDireccionActual()+Math.toRadians(180));
						label.setRotacion(Math.toRadians(90)+Math.toRadians(coche.miDireccionActual));
						coche.setPosX(coche.posX + 1);
						coche.setPosY( coche.posY+1 );
						Thread.sleep(10);
						coche.setMiVelocidad(velocidad);
					}
					if(coche.posX>=350 || coche.posY>=350 ) {
						
						coche.setMiVelocidad(0);
						coche.setMiDireccionActual(coche.getMiDireccionActual()+Math.toRadians(180));
						label.setRotacion(Math.toRadians(90)+Math.toRadians(coche.miDireccionActual));
						
						coche.setPosX(coche.posX - 1);
						coche.setPosY( coche.posY-1 );
						Thread.sleep(10);
						coche.setMiVelocidad(velocidad);
					}
					}
					direccionnueva=coche.miDireccionActual;
					Thread.sleep(20);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
	hilo.start();
	hiloChoque.start();
	addWindowListener(new WindowAdapter() {
		
		
		public void windowClosing(WindowEvent e) {
			sigue=false;
			
			
			
			
		}
		
	});
}

		
	
	
	public static void main(String[] args) {
		VentanaJuego ventana = new VentanaJuego();
		ventana.setVisible(true);
	}
	
	}

