package Clase201819.src.es.deusto.prog3.cap00.ejercicios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.security.auth.x500.X500Principal;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Ejercicio de hilos con ventanas. Programa esta clase para que se cree una ventana
 * que pida un dato de texto al usuario y un botón de confirmar para que se confirme.
 * Haz que al pulsar el botón de confirmación se llame al procesoConfirmar()
 * que simula un proceso de almacenamiento externo que tarda unos segundos.
 * Observa que hasta que ocurre esta confirmación la ventana no responde.
 * 1. Arréglalo para que la ventana no se quede "frita" hasta que se acabe de confirmar.
 * 2. Haz que el botón de "confirmar" no se pueda pulsar dos veces mientras el proceso
 * de confirmación se esté realizando
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */

	
public class VentanaConfirmacionLenta extends JFrame {
	
	public VentanaConfirmacionLenta() {
			setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
			setTitle( "Ventana" );
			setSize( 800, 600 );
			setLocationRelativeTo( null ); 
		//Contenedores
			JTextField cuadroDeTexto = new JTextField();
			JButton bconfirmar = new JButton("Confirmar");
			JPanel panel = new JPanel();
			//
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			cuadroDeTexto.setEditable(true);
			cuadroDeTexto.setSize(100,100);;
			//Añadir contenedor
			this.add(panel,BorderLayout.CENTER);
			panel.add(cuadroDeTexto);
			panel.add(bconfirmar);
			bconfirmar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					VentanaConfirmacionLenta.this.procesoConfirmar((JButton)e.getSource());
					
				}
			});
		}
		
	private static Random r = new Random();
	// Este método simula un proceso que tarda un tiempo en hacerse (entre 5 y 10 segundos)
	
	private static void procesoConfirmar(JButton confirmar) {
		
		Thread hilo = new Thread() {
			public void run(){
				try {
					
					confirmar.setEnabled(false);
					Thread.sleep( 5000 + 1000*r.nextInt(6) );
					confirmar.setEnabled(true);
		} catch (InterruptedException e) {}
			}
			
		};
		hilo.start();
		
	}
	
	public static void main(String[] args) {
		VentanaConfirmacionLenta ventana = new VentanaConfirmacionLenta();
		ventana.setVisible(true);
	}

}
