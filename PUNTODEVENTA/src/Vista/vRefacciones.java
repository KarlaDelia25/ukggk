package Vista;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.daoRefacciones;
import Modelo.Refacciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.EventQueue;
import java.awt.Font;

public class vRefacciones extends JFrame {

	private JPanel NOMBRE;
	private JLabel lblId;
	private JTextField txtNombrec;
	private JTextField txtEmailc;
	private JTextField txtDireccionc;
	private JButton btnAgrgar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnBorrar;
	int fila = -1;
	daoRefacciones dao = new daoRefacciones();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Refacciones> lista = new ArrayList<Refacciones>();
	private JTable tblRefacciones;
	Refacciones refacciones = new Refacciones();
	private JTextField txtTelefonoc;

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

	public vRefacciones() {

		setTitle("REFACCIONES");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 631, 494);
		NOMBRE = new JPanel();
		NOMBRE.setBackground(SystemColor.inactiveCaption);
		NOMBRE.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setLocationRelativeTo(null);

		setContentPane(NOMBRE);
		NOMBRE.setLayout(null);

		txtNombrec = new JTextField();
		txtNombrec.setBackground(SystemColor.activeCaptionBorder);
		txtNombrec.setColumns(10);
		txtNombrec.setBounds(106, 53, 303, 20);
		NOMBRE.add(txtNombrec);

		txtEmailc = new JTextField();
		txtEmailc.setBackground(SystemColor.activeCaptionBorder);
		txtEmailc.setColumns(10);
		txtEmailc.setBounds(106, 84, 86, 20);
		NOMBRE.add(txtEmailc);

		JLabel lblNewLabel = new JLabel("DESCRIPCION");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 56, 71, 14);
		NOMBRE.add(lblNewLabel);

		JLabel Password = new JLabel("PRECIO");
		Password.setFont(new Font("Arial", Font.BOLD, 11));
		Password.setBounds(10, 87, 59, 14);
		NOMBRE.add(Password);

		JLabel gdfjgjdfioj = new JLabel("PRECIO VENTA");
		gdfjgjdfioj.setFont(new Font("Arial", Font.BOLD, 11));
		gdfjgjdfioj.setBounds(10, 121, 86, 14);
		NOMBRE.add(gdfjgjdfioj);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(10, 11, 46, 14);
		NOMBRE.add(lblNewLabel_3);

		txtDireccionc = new JTextField();
		txtDireccionc.setBackground(SystemColor.activeCaptionBorder);
		txtDireccionc.setBounds(106, 118, 86, 20);
		NOMBRE.add(txtDireccionc);
		txtDireccionc.setColumns(10);

		lblId = new JLabel("1");
		lblId.setBounds(111, 11, 81, 31);
		NOMBRE.add(lblId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 595, 258);
		NOMBRE.add(scrollPane);

		tblRefacciones = new JTable();
		tblRefacciones.setBackground(SystemColor.controlShadow);
		tblRefacciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblRefacciones.getSelectedRow();
				refacciones = lista.get(fila);
				lblId.setText("" + refacciones.getIdrefaccion());
				txtNombrec.setText(refacciones.getDescripcion());
				txtEmailc.setText(refacciones.getPrecio().toString());
				txtDireccionc.setText(refacciones.getPrecioventa().toString());
				txtTelefonoc.setText("" + refacciones.getMarca());

			}
		});
		tblRefacciones.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(tblRefacciones);

		btnAgrgar = new JButton("AGREGAR");
		btnAgrgar.setFont(new Font("Arial", Font.BOLD, 11));
		btnAgrgar.setBackground(SystemColor.textHighlight);
		btnAgrgar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Refacciones refacciones = new Refacciones();
					refacciones.setDescripcion(txtNombrec.getText());
					refacciones.setPrecio(Double.parseDouble(txtEmailc.getText().toString()));
					refacciones.setPrecioventa(Double.parseDouble(txtEmailc.getText().toString()));
					refacciones.setMarca(txtDireccionc.getText());

					if (dao.create(refacciones)) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "SE AGREGO CORRCTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR");

				}

			}
		});
		btnAgrgar.setBounds(419, 7, 89, 23);
		NOMBRE.add(btnAgrgar);

		btnEditar = new JButton("EDITAR");
		btnEditar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtNombrec.getText().equals("") || txtEmailc.getText().equals("")
							|| txtDireccionc.getText().equals("") || txtTelefonoc.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS");
						return;
					}
					refacciones.setDescripcion(txtNombrec.getText());
					refacciones.setPrecio(Double.parseDouble(txtEmailc.getText().toString()));
					refacciones.setPrecioventa(Double.parseDouble(txtEmailc.getText().toString()));
					refacciones.setMarca(txtTelefonoc.getText());
					if (dao.update(refacciones)) {
						actualizarTabla();
						limpiar();
						JOptionPane.showMessageDialog(null, "SE A EDITADO CORRECTAMENTE");

					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnEditar.setBounds(419, 52, 89, 23);
		NOMBRE.add(btnEditar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEliminar.setBackground(SystemColor.textHighlight);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcion = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR ESTE CLIENTE ?",
							"ELIMINAR USUARIO", JOptionPane.YES_NO_OPTION);
					if (opcion == 0) {
						if (dao.delete(lista.get(fila).getIdrefaccion())) {
							actualizarTabla();
							JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE !!");
						} else {
							JOptionPane.showMessageDialog(null, "ERROR");
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnEliminar.setBounds(419, 100, 89, 23);
		NOMBRE.add(btnEliminar);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 11));
		btnBorrar.setBackground(SystemColor.textHighlight);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnBorrar.setBounds(419, 149, 89, 23);
		NOMBRE.add(btnBorrar);

		JLabel lblTelefono = new JLabel("MARCA");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 11));
		lblTelefono.setBounds(10, 158, 71, 14);
		NOMBRE.add(lblTelefono);

		txtTelefonoc = new JTextField();
		txtTelefonoc.setBackground(SystemColor.activeCaptionBorder);
		txtTelefonoc.setColumns(10);
		txtTelefonoc.setBounds(106, 155, 86, 20);
		NOMBRE.add(txtTelefonoc);

		modelo.addColumn("ID");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("PRECIO");
		modelo.addColumn("PRECIO VENTA");
		modelo.addColumn("MARCA");
		actualizarTabla();

	}

	public void actualizarTabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = dao.read();
		for (Refacciones u : lista) {
			Object o[] = new Object[5];
			o[0] = u.getIdrefaccion();
			o[1] = u.getDescripcion();
			o[2] = u.getPrecio();
			o[3] = u.getPrecioventa();
			o[4] = u.getMarca();

			modelo.addRow(o);
		}
		tblRefacciones.setModel(modelo);
	}

	public void limpiar() {
		txtNombrec.setText("");
		txtEmailc.setText("");
		txtDireccionc.setText("");
		txtTelefonoc.setText("");
	}
}
