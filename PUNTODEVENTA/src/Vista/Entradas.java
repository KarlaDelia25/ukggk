package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JButton;

public class Entradas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entradas frame = new Entradas();
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
	public Entradas() {
		setTitle("ENTRADAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTRADA DE EFECTIVO");
		lblNewLabel.setBounds(31, 11, 125, 35);
		contentPane.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 25));
		spinner.setBounds(23, 100, 504, 71);
		contentPane.add(spinner);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setBounds(589, 48, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.setBounds(589, 114, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REGISTRO DE ENTRADAS");
		btnNewButton_2.setBounds(559, 189, 179, 23);
		contentPane.add(btnNewButton_2);
	}

}
