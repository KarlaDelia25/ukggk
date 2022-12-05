package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class vBuscar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable tblBuscar;
	private JButton btnEliminarProducto;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vBuscar frame = new vBuscar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static DefaultTableModel modelo2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public vBuscar() {

		setTitle("BUSCAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("INGRESE EL CÓDIGO DEL PRODUCTO");
		lblNewLabel.setBounds(10, 11, 291, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
		
				
				
				
			}
		});
		textField.setBounds(10, 36, 471, 44);
		contentPane.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 103, 640, 389);
		contentPane.add(scrollPane);

		tblBuscar = new JTable();
		tblBuscar.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(tblBuscar);
		modelo2 = new DefaultTableModel();
		modelo2.addColumn("ID");
		modelo2.addColumn("DESCRIPCION");
		modelo2.addColumn("PRECIO");
		modelo2.addColumn("PRECIO VENTA");
		tblBuscar.setModel(modelo2);

		btnNewButton = new JButton("PASAR UNA FILA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				}
			
		});
		btnNewButton.setBounds(49, 514, 118, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("PASAR TODAS LAS FILAS");
		btnNewButton_1.setBounds(207, 514, 155, 23);
		contentPane.add(btnNewButton_1);

	}
}
