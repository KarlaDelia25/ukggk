package Vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.daoInventario;
import Modelo.Inventario;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JSpinner;

public class vInventario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JButton btnAgregar;
	private JLabel lblId;
	daoInventario dao = new daoInventario();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Inventario> lista;
	int fila = -1;
	Inventario inventario = new Inventario();
	private JLabel lblCdigoDelProducto;
	private JLabel lblCantidadActual;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vInventario frame = new vInventario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public vInventario() {
		setTitle("Inventario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblId = new JLabel("AGREGAR INVENTARIO");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblId.setBounds(27, 11, 324, 45);
		contentPane.add(lblId);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(142, 69, 404, 31);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		btnAgregar = new JButton("ELIMINAR");
		btnAgregar.setBackground(Color.BLUE);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		btnAgregar.setBounds(10, 258, 110, 23);
		contentPane.add(btnAgregar);
		
		lblCdigoDelProducto = new JLabel("CÓDIGO DEL PRODUCTO");
		lblCdigoDelProducto.setBounds(10, 83, 122, 14);
		contentPane.add(lblCdigoDelProducto);
		
		lblCantidadActual = new JLabel("CANTIDAD ACTUAL");
		lblCantidadActual.setBounds(10, 150, 110, 14);
		contentPane.add(lblCantidadActual);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(107, 147, 59, 20);
		contentPane.add(spinner);
		
		JButton btnAgregar_1 = new JButton("AGREGAR ");
		btnAgregar_1.setBackground(Color.BLUE);
		btnAgregar_1.setBounds(10, 218, 110, 23);
		contentPane.add(btnAgregar_1);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBackground(Color.BLUE);
		btnEditar.setBounds(10, 292, 110, 23);
		contentPane.add(btnEditar);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setBackground(Color.BLUE);
		btnBorrar.setBounds(10, 326, 110, 23);
		contentPane.add(btnBorrar);
		
		JLabel lblExistencia = new JLabel("EXISTENCIA");
		lblExistencia.setBounds(10, 122, 110, 14);
		contentPane.add(lblExistencia);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(107, 119, 59, 20);
		contentPane.add(spinner_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(189, 111, 479, 284);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
	
	
	
	}
}


