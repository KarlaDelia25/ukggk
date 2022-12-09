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

import Dao.daoTaller;
import Modelo.Taller;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class vTaller extends JFrame {

	private JPanel contentPane;
	private JTextField txtDetalles;
	private JTextField txtCostototal;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JLabel lblId;
	private JTable tblTaller;
	private JScrollPane scrollPane;
	daoTaller dao = new daoTaller();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Taller> lista;
	int fila = -1;
	Taller taller = new Taller();
	private JTextField textRefacciones;
	private JLabel hioj;
	private JTextField txtMecanico;
	private JTextField txtCliente;
	private JLabel lblCliente;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vTaller frame = new vTaller();
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
		lista = dao.consultaTaller();
		for (Taller ta : lista) {
			Object tall[] = new Object[6];
			tall[0] = ta.getIdtaller();
			tall[1] = ta.getDetalles();
			tall[2] = ta.getRefacciones();
			tall[3] = ta.getCostototal();
			tall[4] = ta.getMecanico();
			tall[5] = ta.getCliente();
			modelo.addRow(tall);

		}
		tblTaller.setModel(modelo);
	}

	public void limpiar() {
		lblId.setText("");
		txtDetalles.setText("");
		textRefacciones.setText("");
		txtCostototal.setText("");
		txtMecanico.setText("");
		txtCliente.setText("");
	}

	public vTaller() {
		setTitle("TALLER");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 926, 655);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 26, 46, 14);
		contentPane.add(lblNewLabel);

		lblId = new JLabel("0");
		lblId.setBounds(38, 26, 46, 14);
		contentPane.add(lblId);

		JLabel lblNewLabel_2 = new JLabel("DETALLES");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2.setBounds(48, 51, 78, 14);
		contentPane.add(lblNewLabel_2);

		txtDetalles = new JTextField();
		txtDetalles.setBounds(10, 71, 193, 178);
		contentPane.add(txtDetalles);
		txtDetalles.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("REFACCIONES");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(48, 260, 101, 14);
		contentPane.add(lblNewLabel_2_1);

		txtCostototal = new JTextField();
		txtCostototal.setColumns(10);
		txtCostototal.setBounds(88, 466, 101, 20);
		contentPane.add(txtCostototal);

		JLabel lblNewLabel_2_2 = new JLabel("COSTO TOTAL");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2_2.setBounds(10, 469, 74, 14);
		contentPane.add(lblNewLabel_2_2);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBackground(SystemColor.textHighlight);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtDetalles.getText().equals("") || textRefacciones.getText().equals("")
							|| txtCostototal.getText().equals("") || txtMecanico.getText().equals("") || txtCliente.getText().equals("")) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					Taller taller = new Taller();
					taller.setDetalles(txtDetalles.getText());
					taller.setRefacciones(textRefacciones.getText());
					taller.setCostototal(Double.parseDouble(txtCostototal.getText().toString()));
					taller.setMecanico(txtMecanico.getText());
					taller.setMecanico(txtCliente.getText());
					if (dao.insertarTaller(taller)) {
						JOptionPane.showMessageDialog(null, "SE AGREGO CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnAgregar.setBounds(517, 582, 89, 23);
		contentPane.add(btnAgregar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(SystemColor.textHighlight);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcion=JOptionPane.showConfirmDialog(null,"ESTAS SEGURO DE ELIMINAR LA REFACCIÓN??","ELIMINAR REFACCIÓN",JOptionPane.YES_NO_OPTION);
				    if (opcion ==0) {
					if (dao.eliminarTaller(taller.getIdtaller())) {
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
		btnEliminar.setBounds(616, 582, 89, 23);
		contentPane.add(btnEliminar);

		btnEditar = new JButton("EDITAR");
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtDetalles.getText().equals("") || textRefacciones.getText().equals("")
							|| txtCostototal.getText().equals("") || txtMecanico.getText().equals("") || txtCliente.getText().equals("")){ 
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
						return;
					}
					taller.setDetalles(txtDetalles.getText());
					taller.setRefacciones(textRefacciones.getText());
					taller.setCostototal(Double.parseDouble(txtCostototal.getText().toString()));
					taller.setMecanico(txtMecanico.getText());
					taller.setCliente(txtCliente.getText());
					if (dao.editarTaller(taller)) {
						JOptionPane.showMessageDialog(null, "SE EDITÓ CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
					
				}
			}
		});
		btnEditar.setBounds(715, 582, 89, 23);
		contentPane.add(btnEditar);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBackground(SystemColor.textHighlight);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnBorrar.setBounds(811, 582, 89, 23);
		contentPane.add(btnBorrar);



		scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 11, 687, 531);
		contentPane.add(scrollPane);

		tblTaller = new JTable();
		tblTaller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblTaller.getSelectedRow();
				taller = lista.get(fila);
				lblId.setText("" + taller.getIdtaller());
				txtDetalles.setText(taller.getDetalles());
				textRefacciones.setText(taller.getRefacciones());
				txtCostototal.setText("" + taller.getCostototal());
				txtMecanico.setText(taller.getMecanico());
				txtCliente.setText(taller.getCliente());

			}
		});
		tblTaller.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tblTaller.getColumnModel().getColumn(1).setPreferredWidth(247);
		scrollPane.setViewportView(tblTaller);
		
		textRefacciones = new JTextField();
		textRefacciones.setColumns(10);
		textRefacciones.setBounds(10, 280, 193, 178);
		contentPane.add(textRefacciones);
		
		hioj = new JLabel("MECANICO");
		hioj.setFont(new Font("Arial", Font.BOLD, 11));
		hioj.setBounds(10, 516, 74, 14);
		contentPane.add(hioj);
		
		txtMecanico = new JTextField();
		txtMecanico.setColumns(10);
		txtMecanico.setBounds(88, 513, 101, 20);
		contentPane.add(txtMecanico);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(88, 553, 101, 20);
		contentPane.add(txtCliente);
		
		lblCliente = new JLabel("CLIENTE");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 11));
		lblCliente.setBounds(10, 556, 46, 14);
		contentPane.add(lblCliente);
		
		actualizarTabla();
		modelo.addColumn("ID");
		modelo.addColumn("DETALLES");
		modelo.addColumn("REFACCIONES");
		modelo.addColumn("COSTO TOTAL");
		modelo.addColumn("MECÁNICO");
		modelo.addColumn("CLIENTE");
		actualizarTabla();
	
	
	}
}
