package Vista;

import java.awt.EventQueue;

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


import Dao.daoEmpleados;
import Modelo.Empleados;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class vEmpleados extends JFrame {

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
	daoEmpleados dao = new daoEmpleados();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Empleados> lista = new ArrayList<Empleados>();
	private JTable tblEmpleados;
	Empleados empleados = new Empleados();
	private JTextField txtTelefonoc;
	private JLabel huihuh;
	private JTextField txtRfc;
	private JButton btnPdf;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vEmpleados frame = new vEmpleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vEmpleados() {
		//setLocationRelativeTo(null);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(vUsuario.class.getResource("/img/Ying.jpg")));
		setTitle("EMPLEADOS");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 585, 406);
		NOMBRE = new JPanel();
		NOMBRE.setBackground(new Color(170, 221, 240));
		NOMBRE.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setLocationRelativeTo(null);

		setContentPane(NOMBRE);
		NOMBRE.setLayout(null);

		txtNombrec = new JTextField();
		txtNombrec.setColumns(10);
		txtNombrec.setBounds(106, 53, 86, 20);
		NOMBRE.add(txtNombrec);

		txtEmailc = new JTextField();
		txtEmailc.setColumns(10);
		txtEmailc.setBounds(106, 84, 86, 20);
		NOMBRE.add(txtEmailc);

		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(10, 56, 71, 14);
		NOMBRE.add(lblNewLabel);

		JLabel Password = new JLabel("EMAIL");
		Password.setBounds(10, 87, 59, 14);
		NOMBRE.add(Password);

		JLabel gdfjgjdfioj = new JLabel("DIRECCION");
		gdfjgjdfioj.setBounds(10, 121, 71, 14);
		NOMBRE.add(gdfjgjdfioj);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(10, 11, 46, 14);
		NOMBRE.add(lblNewLabel_3);

		txtDireccionc = new JTextField();
		txtDireccionc.setBounds(106, 118, 86, 20);
		NOMBRE.add(txtDireccionc);
		txtDireccionc.setColumns(10);

		lblId = new JLabel("1");
		lblId.setBounds(111, 11, 81, 31);
		NOMBRE.add(lblId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 235, 414, 107);
		NOMBRE.add(scrollPane);

		tblEmpleados = new JTable();
		tblEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblEmpleados.getSelectedRow();
				empleados = lista.get(fila);
				lblId.setText("" + empleados.getIdEmpleados());
				txtNombrec.setText(empleados.getNombreem());
				txtEmailc.setText(empleados.getEmailem());
				txtDireccionc.setText(empleados.getDireccionem());
				txtTelefonoc.setText(""+empleados.getTelefonoem());
				txtTelefonoc.setText(""+empleados.getRfc());
				
				

			}
		});
		tblEmpleados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblEmpleados);

		btnAgrgar = new JButton("AGREGAR");
		btnAgrgar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Empleados empleados = new Empleados();
					empleados.setNombreem(txtNombrec.getText());
					empleados.setEmailem(txtEmailc.getText());
					empleados.setDireccionem(txtDireccionc.getText());
					empleados.setTelefonoem(Integer.parseInt(txtTelefonoc.getText().toString()));
					empleados.setRfc(Integer.parseInt(txtRfc.getText().toString()));
				

					if (dao.insertarEmpleado(empleados)) {
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
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtNombrec.getText().equals("") || txtEmailc.getText().equals("")
							|| txtDireccionc.getText().equals("") || txtTelefonoc.getText().equals("") || txtRfc.getText().equals("")){
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS");
						return;
					}
					empleados.setNombreem(txtNombrec.getText());
					empleados.setEmailem(txtEmailc.getText());
					empleados.setDireccionem(txtDireccionc.getText());
					empleados.setTelefonoem(Integer.parseInt(txtTelefonoc.getText().toString()));
					empleados.setRfc(Integer.parseInt(txtRfc.getText().toString()));
					
					if (dao.editarempleados(empleados)) {
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
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcion = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR ESTE CLIENTE ?",
							"ELIMINAR USUARIO", JOptionPane.YES_NO_OPTION);
					if (opcion == 0) {
						if (dao.eliminarEmpleados(lista.get(fila).getIdEmpleados())) {
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
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnBorrar.setBounds(233, 112, 89, 23);
		NOMBRE.add(btnBorrar);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setBounds(10, 158, 71, 14);
		NOMBRE.add(lblTelefono);
		
		txtTelefonoc = new JTextField();
		txtTelefonoc.setColumns(10);
		txtTelefonoc.setBounds(106, 155, 86, 20);
		NOMBRE.add(txtTelefonoc);
		
		huihuh = new JLabel("RFC");
		huihuh.setBounds(10, 201, 71, 14);
		NOMBRE.add(huihuh);
		
		txtRfc = new JTextField();
		txtRfc.setColumns(10);
		txtRfc.setBounds(106, 198, 86, 20);
		NOMBRE.add(txtRfc);
		
		btnPdf = new JButton("PDF");
		btnPdf.setBounds(409, 83, 89, 23);
		NOMBRE.add(btnPdf);

		modelo.addColumn("ID");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("EMAIL");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("RFC");
		actualizarTabla();
		
	}

	public void actualizarTabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = dao.consultaempleados();
		for (Empleados u : lista) {
			Object o[] = new Object[6];
			o[0] = u.getIdEmpleados();
			o[1] = u.getNombreem();
			o[2] = u.getEmailem();
			o[3] = u.getDireccionem();
			o[4] = u.getTelefonoem();
			o[5] = u.getRfc();
			
			
			modelo.addRow(o);
		}
		tblEmpleados.setModel(modelo);
	}

	public void limpiar() {
		txtNombrec.setText("");
		txtEmailc.setText("");
		txtDireccionc.setText("");
		txtTelefonoc.setText("");
		txtRfc.setText("");
	}
}
