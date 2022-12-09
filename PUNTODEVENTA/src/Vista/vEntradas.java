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

import com.toedter.calendar.JDateChooser;

import Dao.daoEntradas;
import Modelo.Entradas;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class vEntradas extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JLabel lblidentrada;
	private JTable tblEntradas;
	private JScrollPane scrollPane;
	daoEntradas dao = new daoEntradas();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Entradas> lista;
	int fila = -1;
	Entradas entradas = new Entradas();
	private JDateChooser txtFecha;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vEntradas frame = new vEntradas();
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
		lista = dao.fetchEntradas();
		for (Entradas en : lista) {
			Object entr[] = new Object[4];
			entr[0] = en.getIdentradas();
			entr[1] = en.getCantidad();
			entr[2] = en.getFecha();
			modelo.addRow(entr);

		}
		tblEntradas.setModel(modelo);
	}

	public void limpiar() {
		lblidentrada.setText("");
		txtCantidad.setText("");
		txtFecha.setDateFormatString("");
	    

	}

	public vEntradas() {
		setBackground(SystemColor.windowText);
		setTitle("ENTRADAS");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 799, 505);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 26, 46, 14);
		contentPane.add(lblNewLabel);

		lblidentrada = new JLabel("0");
		lblidentrada.setBounds(38, 26, 46, 14);
		contentPane.add(lblidentrada);

		JLabel lblNewLabel_2 = new JLabel("CANTIDAD");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 74, 46, 14);
		contentPane.add(lblNewLabel_2);
		txtFecha = new JDateChooser();
		txtFecha.getCalendarButton().setBounds(78, 0, 21, 20);
	      txtFecha.setBounds(62,114,99,20);
	      contentPane.add(txtFecha);
	      txtFecha.setLayout(null);

		txtCantidad = new JTextField();
		txtCantidad.setBackground(SystemColor.activeCaptionBorder);
		txtCantidad.setBounds(62, 71, 101, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("FECHA");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(10, 114, 46, 14);
		contentPane.add(lblNewLabel_2_1);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBackground(SystemColor.textHighlight);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtCantidad.getText().equals("") || txtFecha.getDate().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					Entradas entradas = new Entradas();
					entradas.setCantidad(Double.parseDouble(txtCantidad.getText().toString()));
					entradas.setFecha(txtFecha.getDate().toString());
					if (dao.insertarEntradas(entradas)) {
						actualizarTabla();
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
		btnEliminar.setBackground(SystemColor.textHighlight);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcion=JOptionPane.showConfirmDialog(null,"ESTAS SEGURO DE ELIMINAR LA COLUMNA DE ENTRADAS??","ELIMINAR ENTRADAS",JOptionPane.YES_NO_OPTION);
				    if (opcion ==0) {
					if (dao.eliminarEntradas(entradas.getIdentradas())) {
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
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtCantidad.getText().equals("") || txtFecha.getDate().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					entradas.setCantidad(Double.parseDouble(txtFecha.getDate().toString()));
					entradas.setFecha(txtFecha.getDate().toString());
					if (dao.editarEntrada(entradas)) {
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
		btnBorrar.setBackground(SystemColor.textHighlight);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnBorrar.setBounds(10, 353, 89, 23);
		contentPane.add(btnBorrar);


		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.scrollbar);
		scrollPane.setBounds(173, 11, 610, 365);
		contentPane.add(scrollPane);

		tblEntradas = new JTable();
		tblEntradas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblEntradas.getSelectedRow();
				entradas = lista.get(fila);
				lblidentrada.setText("" + entradas.getIdentradas());
				txtCantidad.setText("" + entradas.getCantidad());
				txtFecha.setDateFormatString("" +entradas.getFecha());

			}
		});
		tblEntradas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblEntradas);
		actualizarTabla();
		modelo.addColumn("ID");
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("FECHA Y HORA");
		actualizarTabla();
	
	
	}
	
}


