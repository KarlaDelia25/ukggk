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
import javax.swing.JButton;

public class Ventasdeldia extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventasdeldia frame = new Ventasdeldia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventasdeldia() {
		setTitle("VENTAS DEL DÍA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 719, 418);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 100, 193, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("MOSTRAR VENTAS DE :");
		lblNewLabel.setBounds(28, 58, 171, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("IMPRIMIR");
		btnNewButton.setBounds(575, 100, 89, 23);
		contentPane.add(btnNewButton);
	}

}
