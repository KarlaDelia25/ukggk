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


import Dao.daoSalidas;

import Modelo.Salidas;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class vSalidas extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtFecha;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JLabel lblidsalida;
	private JTable tblSalidas;
	private JScrollPane scrollPane;
	daoSalidas dao = new daoSalidas();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Salidas> lista;
	int fila = -1;
	Salidas salidas = new Salidas();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vSalidas frame = new vSalidas();
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
		lista = dao.fetchSalidas();
		for (Salidas sali : lista) {
			Object sal[] = new Object[4];
			sal[0] = sali.getIdsalida();
			sal[1] = sali.getCantidads();
			sal[2] = sali.getFechas();
			modelo.addRow(sal);

		}
		tblSalidas.setModel(modelo);
	}

	public void limpiar() {
		lblidsalida.setText("");
		txtCantidad.setText("");
		txtFecha.setText("");

	}

	public vSalidas() {
		setTitle("SALIDAS");
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

		lblidsalida = new JLabel("0");
		lblidsalida.setBounds(38, 26, 46, 14);
		contentPane.add(lblidsalida);

		JLabel lblNewLabel_2 = new JLabel("CANTIDAD");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 74, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtCantidad = new JTextField();
		txtCantidad.setBackground(SystemColor.activeCaptionBorder);
		txtCantidad.setBounds(62, 71, 101, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		txtFecha = new JTextField();
		txtFecha.setBackground(SystemColor.activeCaptionBorder);
		txtFecha.setColumns(10);
		txtFecha.setBounds(62, 111, 101, 20);
		contentPane.add(txtFecha);

		JLabel lblNewLabel_2_1 = new JLabel("FECHA");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(10, 114, 46, 14);
		contentPane.add(lblNewLabel_2_1);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBackground(SystemColor.textHighlight);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtCantidad.getText().equals("") || txtFecha.getText().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					Salidas salidas = new Salidas();
					salidas.setCantidads(Double.parseDouble(txtCantidad.getText().toString()));
					salidas.setFechas(txtFecha.getText());
					if (dao.insertarSalidas(salidas)) {
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
					int opcion=JOptionPane.showConfirmDialog(null,"ESTAS SEGURO DE ELIMINAR LA COLUMNA DE SALIDAS??","ELIMINAR SALIDAS",JOptionPane.YES_NO_OPTION);
				    if (opcion ==0) {
					if (dao.eliminarSalidas(salidas.getIdsalida())) {
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
					if (txtCantidad.getText().equals("") || txtCantidad.getText().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					salidas.setCantidads(Double.parseDouble(txtCantidad.getText().toString()));
					salidas.setFechas(txtFecha.getText());
					if (dao.editarSalida(salidas)) {
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

		tblSalidas = new JTable();
		tblSalidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblSalidas.getSelectedRow();
				salidas = lista.get(fila);
				lblidsalida.setText("" + salidas.getIdsalida());
				txtCantidad.setText("" + salidas.getCantidads());
				txtFecha.setText(salidas.getFechas());

			}
		});
		tblSalidas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
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
		scrollPane.setViewportView(tblSalidas);
		actualizarTabla();
		modelo.addColumn("ID");
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("FECHA");
		actualizarTabla();
	
	
	}
	
}

