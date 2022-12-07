
package Vista;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class vPrincipal extends JFrame {
	double ancho = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	double alto = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private JPanel contentPane;
	private JToolBar barraHerramientas;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vPrincipal frame = new vPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vPrincipal() {
		setTitle("PINWORKSHOP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 876);
		contentPane = new JPanel();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("VENTAS");
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("CLIENTES");
		btnNewButton_1.setBounds(109, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("EMPLEADOS");
		btnNewButton_2.setBounds(209, 11, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("REFACCIONES");
		btnNewButton_3.setBounds(308, 11, 89, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("TALLER");
		btnNewButton_4.setBounds(10, 49, 89, 23);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("INVENTARIO");
		btnNewButton_5.setBounds(109, 49, 89, 23);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("USUARIO");
		btnNewButton_6.setBounds(219, 49, 89, 23);
		contentPane.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("PROVEEDORES");
		btnNewButton_7.setBounds(318, 49, 89, 23);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(61, 117, 684, 462);
		contentPane.add(lblNewLabel);
	}
}
