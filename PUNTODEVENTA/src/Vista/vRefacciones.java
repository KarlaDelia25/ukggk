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

import Dao.daoRefacciones;
import Modelo.Refacciones;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;

public class vRefacciones extends JFrame {
	static double total;
	double sub_total;
	double igv;

	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JLabel lblId;
	private JTable tblProductos;
	private JScrollPane scrollPane;
	daoRefacciones dao = new daoRefacciones();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Refacciones> lista;
	int fila = -1;
	Refacciones Productos = new Refacciones();

	private JTextField txtPrecio;
	private JTextField txtPrecioventa;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vRefacciones frame = new vRefacciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void actualizarTabla() {

		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = dao.consultaProductoss();
		for (Refacciones pro : lista) {
			Object produc[] = new Object[4];
			produc[0] = pro.getIdproductos();
			produc[1] = pro.getDescripccion();
			produc[2] = pro.getPrecio();
			produc[3] = pro.getPrecioventa();
			modelo.addRow(produc);

		}
		tblProductos.setModel(modelo);
	}

	public void limpiar() {
		lblId.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtPrecioventa.setText("");

	}

	public vRefacciones() {

		setTitle("PRODUCTOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 26, 46, 14);
		contentPane.add(lblNewLabel);

		lblId = new JLabel("0");
		lblId.setBounds(38, 26, 46, 14);
		contentPane.add(lblId);

		JLabel lblNewLabel_2 = new JLabel("DESCRIPCION");
		lblNewLabel_2.setBounds(10, 74, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(66, 71, 101, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("PRECIO");
		lblNewLabel_2_1.setBounds(10, 114, 46, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("PRECIO VENTA");
		lblNewLabel_2_2.setBounds(10, 162, 46, 14);
		contentPane.add(lblNewLabel_2_2);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtDescripcion.getText().equals("") || txtDescripcion.getText().equals("")
							|| txtPrecio.getText().equals("") || txtPrecioventa.getText().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					Refacciones Productos = new Refacciones();
					Productos.setDescripccion(txtDescripcion.getText());
					Productos.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
					Productos.setPrecioventa(Double.parseDouble(txtPrecioventa.getText().toString()));
					if (dao.insertarProductos(Productos)) {
						JOptionPane.showMessageDialog(null, "SE AGREGO CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnAgregar.setBounds(10, 213, 89, 23);
		contentPane.add(btnAgregar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcion = JOptionPane.showConfirmDialog(null,
							"ESTAS SEGURO DE ELIMINAR LA COLUMNA DE Productoss??", "ELIMINAR Productoss",
							JOptionPane.YES_NO_OPTION);
					if (opcion == 0) {
						if (dao.eliminarProductos(Productos.getIdproductos())) {
							actualizarTabla();
							limpiar();
							JOptionPane.showMessageDialog(null, "SE ELIMINÓ CORRECTAMENTE");

						} else {
							JOptionPane.showMessageDialog(null, "ERROR");

						}
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}

			}
		});
		btnEliminar.setBounds(10, 261, 89, 23);
		contentPane.add(btnEliminar);

		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtDescripcion.getText().equals("") || txtPrecio.getText().equals("")
							|| txtPrecioventa.getText().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					Productos.setDescripccion(txtDescripcion.getText());
					Productos.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
					Productos.setPrecioventa(Double.parseDouble(txtPrecioventa.getText().toString()));
					if (dao.editarProductos(Productos)) {
						JOptionPane.showMessageDialog(null, "SE EDITÓ CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");

				}
			}
		});
		btnEditar.setBounds(10, 308, 89, 23);
		contentPane.add(btnEditar);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnBorrar.setBounds(10, 353, 89, 23);
		contentPane.add(btnBorrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 11, 610, 455);
		contentPane.add(scrollPane);

		tblProductos = new JTable();
		tblProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblProductos.getSelectedRow();
				Productos = lista.get(fila);
				lblId.setText("" + Productos.getIdproductos());
				txtDescripcion.setText(Productos.getDescripccion());
				txtPrecio.setText("" + Productos.getPrecio());
				txtPrecioventa.setText("" + Productos.getPrecioventa());

			}
		});
		tblProductos.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(tblProductos);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(65, 102, 102, 26);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtPrecioventa = new JTextField();
		txtPrecioventa.setColumns(10);
		txtPrecioventa.setBounds(65, 159, 102, 26);
		contentPane.add(txtPrecioventa);

		btnNewButton.setBounds(24, 443, 129, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1.setBounds(22, 477, 131, 23);
		contentPane.add(btnNewButton_1);
		actualizarTabla();
		modelo.addColumn("ID");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("PRECIO");
		modelo.addColumn("PRECIOV");
		vBuscar tabla2 = new vBuscar();
		tabla2.setVisible(true);

		actualizarTabla();
	}

	public void nuevatabla() {
		modelo = new DefaultTableModel();
		tblProductos.setModel(modelo);
	}
}
