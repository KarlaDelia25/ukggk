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

import Dao.daoVentas;
import Modelo.Ventas;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class vVentas extends JFrame {

	private JPanel contentPane;
	private JTable tblVentas;
	private JScrollPane scrollPane;
	daoVentas dao = new daoVentas();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Ventas> lista;
	static double total;
	double sub_total;
	double igv;
	
	int fila = -1;
	Ventas Ventas = new Ventas();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vVentas frame = new vVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static DefaultTableModel modelo3                     ;

	public void actualizarTabla() {

		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = dao.consultaVentas();
		for (Ventas ca : lista) {
			Object carac[] = new Object[4];
			carac[0] = ca.getCodigo();

			modelo.addRow(carac);

		}
		tblVentas.setModel(modelo);
	}

	public vVentas() {
		
		
		
		setTitle("VENTA DE PRODUCTOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 773, 326);
		contentPane.add(scrollPane);

		tblVentas = new JTable();
		tblVentas.setSelectionBackground(Color.CYAN);
		tblVentas.setBackground(new Color(187, 233, 255));
		tblVentas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
		
			}
		});
		tblVentas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblVentas);
		
		JButton btnEntradas = new JButton("ENTRADAS");
		btnEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vEntradas newJframe = new vEntradas ();
				newJframe.setVisible(true);
			}
		});
		btnEntradas.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnEntradas.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 128, 192)));
		btnEntradas.setBackground(new Color(187, 233, 255));
		btnEntradas.setBounds(10, 67, 85, 23);
		contentPane.add(btnEntradas);
		
		JButton btnSalidas = new JButton("SALIDAS");
		btnSalidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vSalidas newJframe = new vSalidas ();
				newJframe.setVisible(true);
				
			}
		});
		btnSalidas.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSalidas.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 128, 192)));
		btnSalidas.setBackground(new Color(187, 233, 255));
		btnSalidas.setBounds(105, 67, 85, 23);
		contentPane.add(btnSalidas);
		
		JButton btnCobrar = new JButton("COBRAR");
		btnCobrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCobrar.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnCobrar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 128, 192)));
		btnCobrar.setBackground(new Color(187, 233, 255));
		btnCobrar.setBounds(462, 449, 136, 66);
		contentPane.add(btnCobrar);
		
		JButton btnImprimirTicket = new JButton("IMPRIMIR TICKET");
		btnImprimirTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImprimirTicket.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnImprimirTicket.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 128, 192)));
		btnImprimirTicket.setBackground(new Color(187, 233, 255));
		btnImprimirTicket.setBounds(489, 553, 85, 23);
		contentPane.add(btnImprimirTicket);
		
		JButton btnVentasDelDia = new JButton("VENTAS DEL DÍA/MES/AÑO");
		btnVentasDelDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vVentasdeldia newJframe = new vVentasdeldia ();
				newJframe.setVisible(true);
			}
		});
		btnVentasDelDia.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnVentasDelDia.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 128, 192)));
		btnVentasDelDia.setBackground(new Color(187, 233, 255));
		btnVentasDelDia.setBounds(629, 553, 154, 23);
		contentPane.add(btnVentasDelDia);
		
		JLabel lblProductosEn = new JLabel("0 PRODUCTOS EN LA VENTA ACTUAL");
		lblProductosEn.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProductosEn.setBounds(38, 449, 233, 14);
		contentPane.add(lblProductosEn);
		
		JLabel hno = new JLabel("TOTAL:");
		hno.setFont(new Font("Arial", Font.PLAIN, 12));
		hno.setBounds(22, 534, 52, 14);
		contentPane.add(hno);
		
		JLabel lblCobrar = new JLabel("$0.00");
		lblCobrar.setFont(new Font("Arial", Font.BOLD, 26));
		lblCobrar.setBounds(649, 472, 174, 43);
		contentPane.add(lblCobrar);
		
		JLabel nkon = new JLabel("PAGÓ CON:");
		nkon.setFont(new Font("Arial", Font.PLAIN, 12));
		nkon.setBounds(99, 534, 81, 14);
		contentPane.add(nkon);
		
		JLabel ojojji = new JLabel("CAMBIO:");
		ojojji.setFont(new Font("Arial", Font.PLAIN, 12));
		ojojji.setBounds(190, 534, 66, 14);
		contentPane.add(ojojji);
		
		JButton btnEliminar = new JButton("ELIMINAR VENTA");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnEliminar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 128, 192)));
		btnEliminar.setBackground(new Color(187, 233, 255));
		btnEliminar.setBounds(48, 474, 85, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblTotal = new JLabel("$0.00");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTotal.setBounds(22, 562, 52, 14);
		contentPane.add(lblTotal);
		
		JLabel lblPagoc = new JLabel("$0.00");
		lblPagoc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPagoc.setBounds(99, 562, 52, 14);
		contentPane.add(lblPagoc);
		
		JLabel lblCambio = new JLabel("$0.00");
		lblCambio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCambio.setBounds(190, 562, 52, 14);
		contentPane.add(lblCambio);
		
		JButton btnNewButton = new JButton("BUSCAR Y/OAGREGAR");
		btnNewButton.setBounds(216, 66, 166, 23);
		contentPane.add(btnNewButton);
		actualizarTabla();
		modelo.addColumn("CÓDIGO DE BARRAS");
		modelo.addColumn("DESCRIPCIÓN DEL PRODUCTO");
		modelo.addColumn("PRECIO");
		modelo.addColumn("PRECIO VENTA");


		
		actualizarTabla();
	
	
	


}
}
