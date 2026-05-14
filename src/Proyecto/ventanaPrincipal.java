package Proyecto;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton btnNewButton;
    private JPanel contentPane;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ventanaPrincipal frame = new ventanaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ventanaPrincipal() {
        setSize(450, 350); //TAMAÑO DE LA VENTANA 
        setLocationRelativeTo(null); // CENTRAR LA VENTANA
    
        getContentPane().setBackground(new Color(235, 222, 207));
        getContentPane().setLayout(null);
        
        
        //TITULO INICIO
        JLabel lblNewLabel = new JLabel("INICIO");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
        lblNewLabel.setBounds(172, 41, 90, 45);
        getContentPane().add(lblNewLabel);
        
        
        //BOTON AÑADIR ANIMALES
        
        //ABRIR VENTANA
        btnNewButton = new JButton("Añadir Animal");
        btnNewButton.setBounds(142, 110, 150, 23);
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            
            //ABRIR VENTANA AÑADIR CLIENTE DESDE VENATANA_1
            public void actionPerformed(ActionEvent e) {
                añadirAnimales ventana = new añadirAnimales();
                ventana.setVisible(true);
                dispose();//CERRAR VENTANA
            }
        });
        
        getContentPane().add(btnNewButton);
        
        
        
        //BOTON RESERVAR HABITACIÓN
        JButton btnNewButton_1 = new JButton("Reservar Habitación");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setBounds(142, 144, 150, 23);
        getContentPane().add(btnNewButton_1);
        
      //Poner imagen de fondo
      		JLabel lblFoto3 = new JLabel("");
      		lblFoto3.setForeground(new Color(0, 255, 128));
      		lblFoto3.setBounds(0, 0, 651, 412);
      		ImageIcon icono3=new
      		ImageIcon(añadirAnimales.class.getResource("/fotos/inicio.png"));
      		Image imagen1 =
      		icono3.getImage().getScaledInstance(lblFoto3.getWidth(),
      		lblFoto3.getHeight(), Image.SCALE_SMOOTH);
      		ImageIcon iconoAjustado1 = new ImageIcon(imagen1);
      		lblFoto3.setIcon(iconoAjustado1);
      		contentPane.add(lblFoto3);
        
        
        setResizable(false);
    }
    
}