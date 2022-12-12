
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
import javax.swing.ImageIcon;

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
setBounds(100, 100, 1070, 876);
contentPane = new JPanel();
contentPane.setBackground(new Color(0, 0, 0));
setExtendedState(JFrame.MAXIMIZED_BOTH);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);

btnNewButton = new JButton("VENTAS");
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
btnNewButton.setBounds(10, 11, 89, 23);
btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
btnNewButton.setBackground(new Color(206, 237, 247));
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
vVentas Ven = new vVentas();
Ven.setVisible(true);
}
});
contentPane.setLayout(null);
contentPane.add(btnNewButton);

btnNewButton_1 = new JButton("CLIENTES");
btnNewButton_1.setBackground(new Color(206, 237, 247));
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
btnNewButton_1.setBounds(333, 11, 89, 23);
btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
vClientes Clie = new vClientes();
Clie.setVisible(true);
}
});
contentPane.add(btnNewButton_1);

btnNewButton_2 = new JButton("EMPLEADOS");
btnNewButton_2.setBackground(new Color(206, 237, 247));
btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
btnNewButton_2.setBounds(542, 11, 89, 23);
btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0)));
btnNewButton_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
vEmpleados Empl = new vEmpleados();
Empl.setVisible(true);
}
});
contentPane.add(btnNewButton_2);

btnNewButton_3 = new JButton("REFACCIONES");
btnNewButton_3.setBackground(new Color(206, 237, 247));
btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
btnNewButton_3.setBounds(109, 11, 89, 23);
btnNewButton_3.setBorder(new LineBorder(new Color(0, 0, 0)));
btnNewButton_3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
vRefacciones Refa = new vRefacciones();
Refa.setVisible(true);
}
});
contentPane.add(btnNewButton_3);

btnNewButton_4 = new JButton("TALLER");
btnNewButton_4.setBackground(new Color(206, 237, 247));
btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
btnNewButton_4.setBounds(222, 11, 89, 23);
btnNewButton_4.setBorder(new LineBorder(new Color(0, 0, 0)));
btnNewButton_4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
vTaller Tall = new vTaller();
Tall.setVisible(true);
}
});
contentPane.add(btnNewButton_4);

btnNewButton_5 = new JButton("INVENTARIO");
btnNewButton_5.setBackground(new Color(206, 237, 247));
btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
btnNewButton_5.setBounds(443, 11, 89, 23);
btnNewButton_5.setBorder(new LineBorder(new Color(0, 0, 0)));
btnNewButton_5.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
vInventario Inve = new vInventario();
Inve.setVisible(true);
}

});
contentPane.add(btnNewButton_5);

btnNewButton_6 = new JButton("USUARIO");
btnNewButton_6.setBackground(new Color(206, 237, 247));
btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
btnNewButton_6.setBounds(652, 11, 89, 23);
btnNewButton_6.setBorder(new LineBorder(new Color(0, 0, 0)));
btnNewButton_6.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
vUsuario US = new vUsuario();
US.setVisible(true);


}
});
contentPane.add(btnNewButton_6);

btnNewButton_7 = new JButton("PROVEEDORES");
btnNewButton_7.setBackground(new Color(206, 237, 247));
btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 11));
btnNewButton_7.setBounds(760, 11, 89, 23);
btnNewButton_7.setBorder(new LineBorder(new Color(0, 0, 0)));
btnNewButton_7.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
vProveedores Prob = new vProveedores();
Prob.setVisible(true);
}
});
contentPane.add(btnNewButton_7);

JLabel lblNewLabel = new JLabel("");
lblNewLabel.setBounds(333, 92, 380, 477);
lblNewLabel.setIcon(new ImageIcon(vPrincipal.class.getResource("/img/uh.png")));
contentPane.add(lblNewLabel);
}
}

