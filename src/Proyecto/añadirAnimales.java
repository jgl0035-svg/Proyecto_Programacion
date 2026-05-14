package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class añadirAnimales extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_Nombre;
	private JTextField text_Edad;
	private JTextField text_Tipo;
	private JTextField text_idHabitat;
	
	//CREO EL OBJETO QUE GESTIONA LA CONEXION CON LA BASE DE DATOS Y ESTARÁ DISPONIBLE PARA TODO EL CÓDIGO
	public ConexionMySQL conexion=new ConexionMySQL("root","","zoologico");  
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					añadirAnimales frame = new añadirAnimales();
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
	public añadirAnimales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 667, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta del nombre
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setForeground(new Color(0, 0, 0));
		lbl_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_Nombre.setBounds(178, 169, 108, 22);
		contentPane.add(lbl_Nombre);
		
		//Etiqueta de la edad
		JLabel lbl_Edad = new JLabel("Edad");
		lbl_Edad.setForeground(new Color(0, 0, 0));
		lbl_Edad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_Edad.setBounds(178, 202, 108, 22);
		contentPane.add(lbl_Edad);
		
		//Campo nombre
		text_Nombre = new JTextField();
		text_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_Nombre.setBounds(343, 166, 156, 28);
		contentPane.add(text_Nombre);
		text_Nombre.setColumns(10);
		
		//Campo edad
		text_Edad = new JTextField();
		text_Edad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_Edad.setBounds(343, 199, 156, 28);
		contentPane.add(text_Edad);
		text_Edad.setColumns(10);
		
		//Etiqueta del tipo de animal
				JLabel lbl_Tipo = new JLabel("Tipo");
				lbl_Tipo.setForeground(new Color(0, 0, 0));
				lbl_Tipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lbl_Tipo.setBounds(178, 232, 108, 22);
				contentPane.add(lbl_Tipo);
				
				//Campo del tipo de animal
				text_Tipo = new JTextField();
				text_Tipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
				text_Tipo.setColumns(10);
				text_Tipo.setBounds(343, 229, 156, 28);
				contentPane.add(text_Tipo);
				
				//Etiqueta del id del habitat
				JLabel lbl_idHabitat = new JLabel("idHabitat");
				lbl_idHabitat.setForeground(new Color(0, 0, 0));
				lbl_idHabitat.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lbl_idHabitat.setBounds(178, 265, 108, 22);
				contentPane.add(lbl_idHabitat);
				
				//Campo del id del habitat
				text_idHabitat = new JTextField();
				text_idHabitat.setFont(new Font("Tahoma", Font.PLAIN, 18));
				text_idHabitat.setColumns(10);
				text_idHabitat.setBounds(343, 262, 156, 28);
				contentPane.add(text_idHabitat);
		
		//Botón
		JButton btn_Insertar = new JButton("INSERTAR");
		btn_Insertar.setForeground(new Color(0, 0, 0));
		btn_Insertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conexion.conectar();//Conecta con la BD
					String nombre=text_Nombre.getText(); // Lee el texto de la casilla nombre del formulario
					int	edad=Integer.parseInt(text_Edad.getText());//Pasa a entero el texto leido de la casilla número
					String tipo=text_Tipo.getText();
					int	idHabitat=Integer.parseInt(text_idHabitat.getText());
					String sentencia="INSERT INTO animales (nombre, edad, tipo, idHabitat ) VALUES ('"+nombre+"',"+edad+",'"+tipo+"',"+idHabitat+")";
					conexion.ejecutarInsertDeleteUpdate(sentencia);//Manda la orden a la base de datos
					conexion.desconectar();//Desconecta de la base de datos
					
					
					//Llamo a un aviso
					String mensaje = "El animal se ha añadido correctamente";
					JOptionPane.showMessageDialog(null, mensaje);
					
					
					//Dejo los campos vacios para el proximo usuario
					text_Nombre.setText("");
					text_Edad.setText("");
					text_Tipo.setText("");
					text_idHabitat.setText("");
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_Insertar.setBounds(275, 348, 94, 20);
		contentPane.add(btn_Insertar);
		
		// Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(255, 255, 255));
        btnVolver.setBounds(0, 23, 89, 23);
        btnVolver.addActionListener(new ActionListener() {
            
            //VOLVER A VENTANA PRINCIPAL
            public void actionPerformed(ActionEvent e) {
                new ventanaPrincipal().setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVolver);

        setResizable(false);
    
		
		//Poner imagen de fondo
		JLabel lblFoto1 = new JLabel("");
		lblFoto1.setForeground(new Color(0, 255, 128));
		lblFoto1.setBounds(0, 0, 651, 412);
		ImageIcon icono1=new
		ImageIcon(añadirAnimales.class.getResource("/fotos/fondo.png"));
		Image imagen1 =
		icono1.getImage().getScaledInstance(lblFoto1.getWidth(),
		lblFoto1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon iconoAjustado1 = new ImageIcon(imagen1);
		lblFoto1.setIcon(iconoAjustado1);
		contentPane.add(lblFoto1);
		
		
		


	}
}