
package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Eliminarproducto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eliminarproducto frame = new Eliminarproducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Eliminarproducto() {
		setTitle("ELIMINAR PRODUCTO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(159, 21, 247, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CÓDIGO DEL PRODUCTO");
		lblNewLabel.setBounds(10, 26, 139, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ELIMINAR PRODUCTO");
		btnNewButton.setBounds(31, 104, 287, 41);
		contentPane.add(btnNewButton);
	}

}
