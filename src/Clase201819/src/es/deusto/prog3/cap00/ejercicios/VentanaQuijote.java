package Clase201819.src.es.deusto.prog3.cap00.ejercicios;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

/** Ejercicio de hilos con ventanas. Esta clase carga el texto del Quijote en un área de texto,
 * y permite navegar por el área con la scrollbar y con botones de página arriba y página abajo.
 * 1. Modificarlo para que al pulsar los botones el scroll se haga con una animación 
 * a lo largo de un segundo, en lugar de en forma inmediata.
 * 2. Prueba a pulsar muy rápido varias páginas abajo. ¿Cómo lo arreglarías para que el scroll
 * en ese caso funcione bien y vaya bajando una página tras otra pero las baje *completas*?
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class VentanaQuijote extends JFrame {

	private JTextArea taTexto;
	private JScrollPane spTexto;
	ArrayList<Integer> listapixel= new  ArrayList<>();
	private boolean sigue=true;
	public VentanaQuijote() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Don Quijote de la Mancha" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );  // Pone la ventana relativa a la pantalla
		taTexto = new JTextArea();
		spTexto = new JScrollPane( taTexto );
		add( spTexto, BorderLayout.CENTER );
		JPanel pBotonera = new JPanel();
		JButton bPagArriba = new JButton( "^" );
		JButton bPagAbajo = new JButton( "v" );
		pBotonera.add( bPagArriba );
		pBotonera.add( bPagAbajo );
		add( pBotonera, BorderLayout.SOUTH );
		hilo.start();
		bPagArriba.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				listapixel.add((Integer)(-(spTexto.getHeight()-20)) );
			}
		});
		bPagAbajo.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					System.out.println(listapixel);
				listapixel.add((Integer)(spTexto.getHeight()-20)) ;
			
			}
		});
		this.addWindowListener(new WindowAdapter() {
			
			
			@Override
			public void windowClosed(WindowEvent e) {
				sigue=false;
				
			}
			
			
		});
	}

	Thread hilo = new Thread() {
		public void run() {
			try {
				while(sigue) {
				Thread.sleep(10);
				VentanaQuijote.this.funcionarhilo();
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	private void funcionarhilo() throws InterruptedException {
		if(listapixel.isEmpty()) {
			Thread.sleep(10);
			
		}else {
			int pixel=listapixel.remove(0);
			muevePagina(pixel);
		}
		
	}
	private void muevePagina( int pixelsVertical ) throws InterruptedException {
		// TODO Cambiar este comportamiento de acuerdo a los comentarios de la cabecera de clase
		JScrollBar bVertical = spTexto.getVerticalScrollBar();
		System.out.println( "Moviendo texto de " + bVertical.getValue() + " a " + (bVertical.getValue()+pixelsVertical) );
		int di =(pixelsVertical<0)?-1:1;
		System.out.println(pixelsVertical);
		
		for(int vertical=bVertical.getValue();vertical !=bVertical.getValue() + pixelsVertical;di++) {
			System.out.println(vertical);
			bVertical.setValue( vertical);
			Thread.sleep(10);
		}
	}
	
	private void cargaQuijote() {
		try {
			Scanner scanner = new Scanner( VentanaQuijote.class.getResourceAsStream( "DonQuijote.txt" ), "UTF-8" );
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				taTexto.append( linea + "\n" );
			}
			scanner.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, "No se ha podido cargar el texto" );
		}
	}

	public static void main(String[] args) {
		VentanaQuijote v = new VentanaQuijote();
		v.setVisible( true );
		v.cargaQuijote();
	}

}
