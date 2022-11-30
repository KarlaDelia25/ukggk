package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Salidas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salidas frame = new Salidas();
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
	public Salidas() {
		setTitle("SALIDAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANTIDAD");
		lblNewLabel.setBounds(29, 21, 120, 23);
		contentPane.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinner.setBounds(10, 45, 256, 60);
		contentPane.add(spinner);
		
		textField = new JTextField();
		textField.setBounds(10, 180, 302, 76);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("MOTIVO,RAZÓN,PROVEEDOR");
		lblNewLabel_1.setBounds(10, 143, 256, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setBounds(481, 45, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.setBounds(481, 100, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REGISTRO DE SALIDAS");
		btnNewButton_2.setBounds(481, 166, 174, 23);
		contentPane.add(btnNewButton_2);
	}

}
