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

import Dao.daoProveedores;
import Modelo.Proveedores;

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

public class vProveedores extends JFrame {

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
	daoProveedores dao = new daoProveedores();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
	private JTable tblProveedores;
	Proveedores proveedores = new Proveedores();
	private JTextField txtTelefonoc;
	private JButton btnPdf;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vProveedores frame = new vProveedores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vProveedores() {
		//setLocationRelativeTo(null);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(vUsuario.class.getResource("/img/Ying.jpg")));
		setTitle("PROVEEDORES");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 534, 352);
		NOMBRE = new JPanel();
		NOMBRE.setBackground(SystemColor.inactiveCaption);
		NOMBRE.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setLocationRelativeTo(null);

		setContentPane(NOMBRE);
		NOMBRE.setLayout(null);

		txtNombrec = new JTextField();
		txtNombrec.setBackground(SystemColor.activeCaptionBorder);
		txtNombrec.setColumns(10);
		txtNombrec.setBounds(106, 53, 86, 20);
		NOMBRE.add(txtNombrec);

		txtEmailc = new JTextField();
		txtEmailc.setBackground(SystemColor.activeCaptionBorder);
		txtEmailc.setColumns(10);
		txtEmailc.setBounds(106, 84, 86, 20);
		NOMBRE.add(txtEmailc);

		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 56, 71, 14);
		NOMBRE.add(lblNewLabel);

		JLabel Password = new JLabel("EMAIL");
		Password.setFont(new Font("Arial", Font.BOLD, 11));
		Password.setBounds(10, 87, 59, 14);
		NOMBRE.add(Password);

		JLabel gdfjgjdfioj = new JLabel("DIRECCION");
		gdfjgjdfioj.setFont(new Font("Arial", Font.BOLD, 11));
		gdfjgjdfioj.setBounds(10, 121, 71, 14);
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
		scrollPane.setBounds(53, 195, 414, 107);
		NOMBRE.add(scrollPane);

		tblProveedores = new JTable();
		tblProveedores.setBackground(SystemColor.controlShadow);
		tblProveedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblProveedores.getSelectedRow();
				proveedores = lista.get(fila);
				lblId.setText("" + proveedores.getIdproveedores());
				txtNombrec.setText(proveedores.getNombreprov());
				txtEmailc.setText(proveedores.getEmailprov());
				txtDireccionc.setText(proveedores.getDireccionprov());
				txtTelefonoc.setText(""+proveedores.getTelefonoprov());
				

			}
		});
		tblProveedores.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblProveedores);

		btnAgrgar = new JButton("AGREGAR");
		btnAgrgar.setFont(new Font("Arial", Font.BOLD, 11));
		btnAgrgar.setBackground(SystemColor.textHighlight);
		btnAgrgar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Proveedores proveedores = new Proveedores();
					proveedores.setNombreprov(txtNombrec.getText());
					proveedores.setEmailprov(txtEmailc.getText());
					proveedores.setDireccionprov(txtDireccionc.getText());
					proveedores.setTelefonoprov(Integer.parseInt(txtTelefonoc.getText().toString()));

					if (dao.insertarProveedores(proveedores)) {
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
		btnAgrgar.setBounds(233, 7, 89, 23);
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
					proveedores.setNombreprov(txtNombrec.getText());
					proveedores.setEmailprov(txtEmailc.getText());
					proveedores.setDireccionprov(txtDireccionc.getText());
					proveedores.setTelefonoprov(Integer.parseInt(txtTelefonoc.getText().toString()));
					if (dao.editarProveedores(proveedores)) {
						actualizarTabla();
						limpiar();
						JOptionPane.showMessageDialog(null, "SE A CORRECTAMENTE");

					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnEditar.setBounds(233, 41, 89, 23);
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
						if (dao.eliminarProveedores(lista.get(fila).getIdproveedores())) {
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
		btnEliminar.setBounds(233, 75, 89, 23);
		NOMBRE.add(btnEliminar);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 11));
		btnBorrar.setBackground(SystemColor.textHighlight);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnBorrar.setBounds(233, 112, 89, 23);
		NOMBRE.add(btnBorrar);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 11));
		lblTelefono.setBounds(10, 158, 71, 14);
		NOMBRE.add(lblTelefono);
		
		txtTelefonoc = new JTextField();
		txtTelefonoc.setBackground(SystemColor.activeCaptionBorder);
		txtTelefonoc.setColumns(10);
		txtTelefonoc.setBounds(106, 155, 86, 20);
		NOMBRE.add(txtTelefonoc);
		
		btnPdf = new JButton("PDF");
		btnPdf.setFont(new Font("Arial", Font.BOLD, 11));
		btnPdf.setBackground(SystemColor.textHighlight);
		btnPdf.setBounds(354, 75, 89, 23);
		NOMBRE.add(btnPdf);

		modelo.addColumn("ID");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("EMAIL");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		actualizarTabla();
		
	}

	public void actualizarTabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = dao.consultaProveedores();
		for (Proveedores u : lista) {
			Object o[] = new Object[5];
			o[0] = u.getIdproveedores();
			o[1] = u.getNombreprov();
			o[2] = u.getEmailprov();
			o[3] = u.getDireccionprov();
			o[4] = u.getTelefonoprov();
			
			
			modelo.addRow(o);
		}
		tblProveedores.setModel(modelo);
	}

	public void limpiar() {
		txtNombrec.setText("");
		txtEmailc.setText("");
		txtDireccionc.setText("");
		txtTelefonoc.setText("");
	}
}


