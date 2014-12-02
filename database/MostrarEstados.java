package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class MostrarEstados extends JFrame {
	private JTable tabla;
	public String msg1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarEstados frame = new MostrarEstados();
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
	public MostrarEstados() {
		getContentPane().setBackground(new Color(0, 0, 153));
		setBounds(100, 100, 960, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		//DefaultTableModel modelo = new DefaultTableModel();
		tabla = new JTable();
		tabla.setBounds(241, 108, 479, 103);
		getContentPane().add(tabla);
		
		JButton btnClickkk = new JButton("Buscar Estados");
		btnClickkk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					updateData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			}
		});
		btnClickkk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClickkk.setBounds(312, 328, 334, 77);
		getContentPane().add(btnClickkk);
	}
	public void updateData() throws SQLException
	{
		ResultSet rs=ControladorConsultas.getEstados();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("id");
		modelo.addColumn("estado");
		while(rs.next())
		{
			Object [] fila = new Object[2];
			for(int i=0;i<2;i++)
				fila[i]=rs.getObject(i+1);
			modelo.addRow(fila);
		}
		tabla.setModel(modelo);
		msg1="Clicked";
	}
	public String getMsg1(){
		return msg1;
	}
}
