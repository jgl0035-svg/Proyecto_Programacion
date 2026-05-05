package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_Nombre;
	private JTextField text_Edad;
	
	//CREO EL OBJETO QUE GESTIONA LA CONEXION CON LA BASE DE DATOS Y ESTARÁ DISPONIBLE PARA TODO EL CÓDIGO
	public ConexionMySQL conexion=new ConexionMySQL("root","","persona");  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta del título
		JLabel lbl_Titulo = new JLabel("USUARIOS");
		lbl_Titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_Titulo.setBounds(164, 21, 125, 22);
		contentPane.add(lbl_Titulo);
		
		//Etiqueta del nombre
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_Nombre.setBounds(48, 70, 108, 22);
		contentPane.add(lbl_Nombre);
		
		//Etiqueta de la edad
		JLabel lbl_Edad = new JLabel("Edad");
		lbl_Edad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_Edad.setBounds(48, 113, 108, 22);
		contentPane.add(lbl_Edad);
		
		//Campo nombre
		text_Nombre = new JTextField();
		text_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_Nombre.setBounds(211, 75, 125, 18);
		contentPane.add(text_Nombre);
		text_Nombre.setColumns(10);
		
		//Campo edad
		text_Edad = new JTextField();
		text_Edad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_Edad.setBounds(211, 118, 125, 18);
		contentPane.add(text_Edad);
		text_Edad.setColumns(10);
		
		//Botón
		JButton btn_Insertar = new JButton("INSERTAR");
		btn_Insertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conexion.conectar();//Conecta con la BD
					String nombre=text_Nombre.getText(); // Lee el texto de la casilla nombre del formulario
					int	numero=Integer.parseInt(text_Edad.getText());//Pasa a entero el texto leido de la casilla número
					String sentencia="INSERT INTO USUARIOS (NOMBRE,EDAD) VALUES ('"+nombre+"',"+numero+")";
					conexion.ejecutarInsertDeleteUpdate(sentencia);//Manda la orden a la base de datos
					conexion.desconectar();//Desconecta de la base de datos
					
					//Llamo a un aviso
					String mensaje = "Usuario introducido correctamente";
					JOptionPane.showMessageDialog(null, mensaje);
					
					
					//Dejo los campos vacios para el proximo usuario
					text_Nombre.setText("");
					text_Edad.setText("");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_Insertar.setBounds(174, 205, 84, 20);
		contentPane.add(btn_Insertar);

	}
}