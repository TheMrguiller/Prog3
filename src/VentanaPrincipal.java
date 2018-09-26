import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.*;

import LabelEspeciales.FondoSwing;


public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal() {
		
		//Iniciacion de ventana
		(new ImageIcon("src\\Fondo.gif"));
		FondoSwing panel = new FondoSwing();
		panel.setLayout(new BorderLayout());
		panel.Imagen("src\\fondo dos.JPG");
		setTitle("RandomSprite Smackdown");//titulo del juego
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );//Operacion de cierre
		setSize(900, 700);//parametro de medidas de la ventana
		setLocationRelativeTo(null);//Centrado
		//Contenedores
		JPanel paneliz = new JPanel();//Panel de botones principales
			JPanel panelinterior = new JPanel();
			JButton botonHistoria = new JButton(new ImageIcon("src/Historia.gif"));
			JButton botonPractica = new JButton();
			JButton boton1VS1 = new JButton();
			JButton botonAyuda = new JButton();
		JPanel panelde = new JPanel();//Panel de titulo
			JLabel labelTitulo = new JLabel();
		//Modificaciones
			panelinterior.setLayout(new GridLayout());
		//Añadir los contenedores
		add(paneliz);
		add(panelde);
		paneliz.add(panelinterior,BorderLayout.CENTER);
		panelinterior.add(botonHistoria);
		panelinterior.add(botonPractica);
		panelinterior.add(boton1VS1);
		panelinterior.add(botonAyuda);
		panelde.add(labelTitulo,BorderLayout.NORTH);
		
	}
	
	




public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}
}