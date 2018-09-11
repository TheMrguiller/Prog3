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
		panelinferiro.setOpaque(false);
		
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
				
				coche.acelera(5);
				
			}
		});
		botonfrenar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-5);
				
			}
		});
		botonizq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.giro(-10);
				label.setRotacion(label.getRotacion() -0.5);
				
				
			}
		});
		botondere.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.giro(10);
				label.setRotacion(label.getRotacion()+0.5);
				
			
			}
		});
		
		Thread hilo = new Thread() {
			public void run() {
				try {
					while(sigue) {
					Thread.sleep(500);
					tiempo= tiempo + 500;
					coche.mueve(tiempo/1000);
					label.setLocation(coche.posX,coche.posY );
					
					System.out.println(label.getLocation());
					label.revalidate();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
				
	};
	hilo.start();
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

