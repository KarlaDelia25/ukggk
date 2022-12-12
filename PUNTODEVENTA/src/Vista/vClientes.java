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

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;

import Dao.daoClientes;
import Modelo.Clientes;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class vClientes extends JFrame {

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
	daoClientes dao = new daoClientes();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Clientes> lista = new ArrayList<Clientes>();
	private JTable tblClientes;
	Clientes clientes = new Clientes();
	private JTextField txtTelefonoc;
	private JButton btnPdf;
	private JButton btnPdf_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vClientes frame = new vClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vClientes() {
		//setLocationRelativeTo(null);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(vUsuario.class.getResource("/img/Ying.jpg")));
		setTitle("CLIENTES");
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

		tblClientes = new JTable();
		tblClientes.setBackground(SystemColor.activeCaptionBorder);
		tblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblClientes.getSelectedRow();
				clientes = lista.get(fila);
				lblId.setText("" + clientes.getIdClientes());
				txtNombrec.setText(clientes.getNombrecliente());
				txtEmailc.setText(clientes.getEmailcliente());
				txtDireccionc.setText(clientes.getDireccioncliente());
				txtTelefonoc.setText(""+clientes.getTelefonocliente());
				

			}
		});
		tblClientes.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(tblClientes);

		btnAgrgar = new JButton("AGREGAR");
		btnAgrgar.setBackground(SystemColor.textHighlight);
		btnAgrgar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Clientes clientes = new Clientes();
					clientes.setNombrecliente(txtNombrec.getText());
					clientes.setEmailcliente(txtEmailc.getText());
					clientes.setDireccioncliente(txtDireccionc.getText());
					clientes.setTelefonocliente(Integer.parseInt(txtTelefonoc.getText().toString()));

					if (dao.insertarClientes(clientes)) {
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
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtNombrec.getText().equals("") || txtEmailc.getText().equals("")
							|| txtDireccionc.getText().equals("") || txtTelefonoc.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS");
						return;
					}
					clientes.setNombrecliente(txtNombrec.getText());
					clientes.setEmailcliente(txtEmailc.getText());
					clientes.setDireccioncliente(txtDireccionc.getText());
					clientes.setTelefonocliente(Integer.parseInt(txtTelefonoc.getText().toString()));
					if (dao.editarcliente(clientes)) {
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
		btnEliminar.setBackground(SystemColor.textHighlight);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcion = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR ESTE CLIENTE ?",
							"ELIMINAR USUARIO", JOptionPane.YES_NO_OPTION);
					if (opcion == 0) {
						if (dao.eliminarCliente(lista.get(fila).getIdClientes())) {
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
		
		btnPdf_1 = new JButton("PDF");
		btnPdf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPdf_1.setBackground(SystemColor.textHighlight);
		btnPdf_1.setBounds(363, 62, 89, 23);
		NOMBRE.add(btnPdf_1);
		
		

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
		lista = dao.consultacliente();
		for (Clientes u : lista) {
			Object o[] = new Object[6];
			o[0] = u.getIdClientes();
			o[1] = u.getNombrecliente();
			o[2] = u.getEmailcliente();
			o[3] = u.getDireccioncliente();
			o[4] = u.getTelefonocliente();
			
			
			
			modelo.addRow(o);
		}
		tblClientes.setModel(modelo);
	}

	public void limpiar() {
		txtNombrec.setText("");
		txtEmailc.setText("");
		txtDireccionc.setText("");
		txtTelefonoc.setText("");
		
	}
}

