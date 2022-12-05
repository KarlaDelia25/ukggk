package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;

public class vVentasdeldia extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vVentasdeldia frame = new vVentasdeldia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vVentasdeldia() {
		setTitle("VENTAS DEL DÍA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 247, 719, 336);
		contentPane.add(scrollPane);
		  JCalendar calendar = new JCalendar();
	      calendar.setBounds(199,83,184,153);
	      contentPane.add(calendar);

	      JDateChooser dateChooser = new JDateChooser();
	      dateChooser.setBounds(408,134,99,20);
	      contentPane.add(dateChooser);

		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("MOSTRAR VENTAS DE :");
		lblNewLabel.setBounds(200, 52, 171, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("PDF");
		btnNewButton.setBounds(575, 100, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(54, 56, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(54, 100, 89, 23);
		contentPane.add(btnBorrar);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(54, 150, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(54, 196, 89, 23);
		contentPane.add(btnEliminar);
	}
}
