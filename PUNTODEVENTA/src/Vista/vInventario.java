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

public class vInventario extends JFrame {

	private JPanel contentPane;
	private JTextField txtExistencia;
	private JTextField txtCantidad;
	private JTextField txtImporte;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JButton btnSeleccionar;
	private JLabel lblId;
	private JTable tblInventario;
	private JScrollPane scrollPane;
	daoInventario dao = new daoInventario();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Inventario> lista;
	int fila = -1;
	Inventario inventario = new Inventario();

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

	public void actualizarTabla() {

		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = dao.consultaInventario();
		for (Inventario inv: lista) {
			Object inven[] = new Object[4];
			inven[0] = inv.getId();
			inven[1] = inv.getExistencia();
			inven[2] = inv.getCantidad();
			inven[3] = inv.getImporte();
			modelo.addRow(inven);

		}
		tblInventario.setModel(modelo);
	}

	public void limpiar() {
		lblId.setText("");
		txtExistencia.setText("");
		txtCantidad.setText("");
		txtImporte.setText("");
	
	}

	public vInventario(){
		setTitle("CARACTERISTICAS");
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

		JLabel lblNewLabel_2 = new JLabel("EXISTENCIA");
		lblNewLabel_2.setBounds(10, 74, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtExistencia = new JTextField();
		txtExistencia.setBounds(62, 71, 101, 20);
		contentPane.add(txtExistencia);
		txtExistencia.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(62, 111, 101, 20);
		contentPane.add(txtCantidad);

		JLabel lblNewLabel_2_1 = new JLabel("CANTIDAD");
		lblNewLabel_2_1.setBounds(10, 114, 46, 14);
		contentPane.add(lblNewLabel_2_1);

		txtImporte = new JTextField();
		txtImporte.setColumns(10);
		txtImporte.setBounds(62, 159, 101, 20);
		contentPane.add(txtImporte);

		JLabel lblNewLabel_2_2 = new JLabel("IMPORTE");
		lblNewLabel_2_2.setBounds(10, 162, 46, 14);
		contentPane.add(lblNewLabel_2_2);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtExistencia.getText().equals("") || txtCantidad.getText().equals("")
							|| txtImporte.getText().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					Inventario inventario = new Inventario();
					inventario.setExistencia(Integer.parseInt(txtExistencia.getText().toString()));
					inventario.setCantidad(Integer.parseInt(txtCantidad.getText().toString()));
					inventario.setImporte(Integer.parseInt(txtImporte.getText().toString()));
					if (dao.insertarInventario(inventario)) {
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
					int opcion=JOptionPane.showConfirmDialog(null,"ESTAS SEGURO DE ELIMINAR ESTE INVENTARIO??","ELIMINAR CARACTERISTICAS",JOptionPane.YES_NO_OPTION);
				    if (opcion ==0) {
					if (dao.eliminarInventario(inventario.getId())) {
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
					if (txtExistencia.getText().equals("") || txtCantidad.getText().equals("")
							|| txtImporte.getText().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					inventario.setExistencia(Integer.parseInt(txtExistencia.getText().toString()));
					inventario.setCantidad(Integer.parseInt(txtExistencia.getText().toString()));
					inventario.setImporte(Integer.parseInt(txtExistencia.getText().toString()));
					if (dao.editarInventario(inventario)) {
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
		scrollPane.setBounds(173, 11, 610, 365);
		contentPane.add(scrollPane);

		tblInventario = new JTable();
		tblInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblInventario.getSelectedRow();
				inventario = lista.get(fila);
				lblId.setText("" + inventario.getId());
				txtImporte.setText("" + inventario.getExistencia());
				txtImporte.setText("" + inventario.getCantidad());
				txtImporte.setText("" + inventario.getImporte());
		

			}
		});
		tblInventario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblInventario);
		actualizarTabla();
		modelo.addColumn("ID");
		modelo.addColumn("MARCA");
		modelo.addColumn("MODELO");
		modelo.addColumn("PRECIO");
		modelo.addColumn("IMG");
		actualizarTabla();
	
	
	}
	
}

