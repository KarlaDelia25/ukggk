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

	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtImg;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JButton btnSeleccionar;
	private JLabel lblId;
	private JTable tblProductos;
	private JScrollPane scrollPane;
	daoRefacciones dao = new daoRefacciones();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Refacciones> lista;
	private JLabel lblImg;
	int fila = -1;
	Refacciones Productos = new Refacciones();
	private JSpinner spnPrecio;
	private JSpinner spnPreciov;

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
			produc[0] = pro.getId();
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
		spnPrecio.setValue("");
		spnPreciov.setValue("");
		txtImg.setText("");

	}

	public vRefacciones() {
		setTitle("PRODUCTOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 505);
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

		txtImg = new JTextField();
		txtImg.setColumns(10);
		txtImg.setBounds(62, 409, 101, 20);
		contentPane.add(txtImg);

		JLabel uihh = new JLabel("IMG");
		uihh.setBounds(10, 412, 46, 14);
		contentPane.add(uihh);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtDescripcion.getText().equals("") || txtDescripcion.getText().equals("")
							|| spnPrecio.getValue().equals("") || txtImg.getText().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					Refacciones Productos = new Refacciones();
					Productos.setDescripccion(txtDescripcion.getText());
					Productos.setPrecio(Double.parseDouble(spnPrecio.getValue().toString()));
					Productos.setPrecioventa(Double.parseDouble(spnPreciov.getValue().toString()));
					Productos.setImg(txtImg.getText());
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
					int opcion=JOptionPane.showConfirmDialog(null,"ESTAS SEGURO DE ELIMINAR LA COLUMNA DE Productoss??","ELIMINAR Productoss",JOptionPane.YES_NO_OPTION);
				    if (opcion ==0) {
					if (dao.eliminarProductos(Productos.getId())) {
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
					if (txtDescripcion.getText().equals("") || txtDescripcion.getText().equals("")
							|| spnPrecio.getValue().equals("") || txtImg.getText().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					Productos.setDescripccion(txtDescripcion.getText());
					Productos.setPrecio(Double.parseDouble(spnPrecio.getValue().toString()));
					Productos.setPrecio(Double.parseDouble(spnPreciov.getValue().toString()));
					Productos.setImg(txtImg.getText());
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

		btnSeleccionar = new JButton("SELECCIONAR");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivo JPGE(*.JPG;*.JPGE)",
						"jpg", "jpg");
				JFileChooser imagen = new JFileChooser();
				imagen.addChoosableFileFilter(filtro);
				imagen.setDialogTitle("Abrir Archivo");
				File ruta = new File("D:/motos");
				imagen.setCurrentDirectory(ruta);
				int window = imagen.showOpenDialog(null);
				if (window == JFileChooser.APPROVE_OPTION)
					;
				File file = imagen.getSelectedFile();
				txtImg.setText(String.valueOf(file));
				Image foto = getToolkit().getImage(txtImg.getText());
				;
				foto = foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
				lblImg.setIcon(new ImageIcon(foto));

			}
		});

		btnSeleccionar.setBounds(166, 408, 139, 23);
		contentPane.add(btnSeleccionar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 11, 610, 365);
		contentPane.add(scrollPane);

		tblProductos = new JTable();
		tblProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblProductos.getSelectedRow();
				Productos = lista.get(fila);
				lblId.setText("" + Productos.getId());
				txtDescripcion.setText(Productos.getDescripccion());
				spnPrecio.setValue("" + Productos.getPrecio());
				spnPreciov.setValue("" + Productos.getPrecioventa());
				txtImg.setText(Productos.getImg());

			}
		});
		tblProductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblProductos);
		actualizarTabla();

		lblImg = new JLabel("");
		lblImg.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImg.setBounds(330, 382, 106, 84);
		contentPane.add(lblImg);
		
		spnPrecio = new JSpinner();
		spnPrecio.setBounds(66, 111, 30, 20);
		contentPane.add(spnPrecio);
		
		spnPreciov = new JSpinner();
		spnPreciov.setBounds(66, 159, 30, 20);
		contentPane.add(spnPreciov);
		modelo.addColumn("ID");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("PRECIO");
		modelo.addColumn("PRECIOV");
		modelo.addColumn("IMG");
		actualizarTabla();
	
	
	}
	
}
