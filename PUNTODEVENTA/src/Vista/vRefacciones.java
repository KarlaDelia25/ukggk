package Vista;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Dao.daoRefacciones;
import Modelo.Refacciones;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class vRefacciones extends JFrame {

	private JPanel NOMBRE;
	private JLabel lblId;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtPrecioventa;
	private JButton btnAgrgar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnBorrar;
	int fila = -1;
	daoRefacciones dao = new daoRefacciones();
	DefaultTableModel modelo = new DefaultTableModel();
	static double total;
	double sub_total;
	double igv;
	ArrayList<Refacciones> lista = new ArrayList<Refacciones>();
	private JTable tblRefacciones;
	Refacciones refacciones = new Refacciones();
	private JTextField txtMarca;
	private JButton btnPdf;
	private JTextField txtBuscar;
	private JLabel lblBuscar;
	private JButton btnNewButton;
	private JLabel lblAgregarRefaccionesA;
	private JLabel lblCantidad;
	private JTextField txtCantidad;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vRefacciones frame = new vRefacciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vRefacciones() {
		total=0;
		sub_total=0.0;
		igv = 0.0;
		

		setTitle("REFACCIONES");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 998, 617);
		NOMBRE = new JPanel();
		NOMBRE.setBackground(SystemColor.inactiveCaption);
		NOMBRE.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setLocationRelativeTo(null);

		setContentPane(NOMBRE);
		NOMBRE.setLayout(null);

		txtDescripcion = new JTextField();
		txtDescripcion.setBackground(SystemColor.activeCaptionBorder);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(106, 53, 303, 20);
		NOMBRE.add(txtDescripcion);

		txtPrecio = new JTextField();
		txtPrecio.setBackground(SystemColor.activeCaptionBorder);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(106, 84, 86, 20);
		NOMBRE.add(txtPrecio);

		JLabel lblNewLabel = new JLabel("DESCRIPCION");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 56, 71, 14);
		NOMBRE.add(lblNewLabel);

		JLabel Password = new JLabel("PRECIO");
		Password.setFont(new Font("Arial", Font.BOLD, 11));
		Password.setBounds(10, 87, 59, 14);
		NOMBRE.add(Password);

		JLabel gdfjgjdfioj = new JLabel("PRECIO VENTA");
		gdfjgjdfioj.setFont(new Font("Arial", Font.BOLD, 11));
		gdfjgjdfioj.setBounds(10, 121, 86, 14);
		NOMBRE.add(gdfjgjdfioj);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(10, 11, 46, 14);
		NOMBRE.add(lblNewLabel_3);

		txtPrecioventa = new JTextField();
		txtPrecioventa.setBackground(SystemColor.activeCaptionBorder);
		txtPrecioventa.setBounds(106, 118, 86, 20);
		NOMBRE.add(txtPrecioventa);
		txtPrecioventa.setColumns(10);

		lblId = new JLabel("1");
		lblId.setBounds(111, 11, 81, 31);
		NOMBRE.add(lblId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 962, 230);
		NOMBRE.add(scrollPane);

		tblRefacciones = new JTable();
		tblRefacciones.setBackground(SystemColor.controlShadow);
		tblRefacciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblRefacciones.getSelectedRow();
				refacciones = lista.get(fila);
				lblId.setText("" + refacciones.getIdrefaccion());
				txtDescripcion.setText(refacciones.getDescripcion());
				txtPrecio.setText(refacciones.getPrecio().toString());
				txtPrecioventa.setText(refacciones.getPrecioventa().toString());
				txtMarca.setText("" + refacciones.getMarca());

			}
		});
		tblRefacciones.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(tblRefacciones);

		btnAgrgar = new JButton("AGREGAR");
		btnAgrgar.setFont(new Font("Arial", Font.BOLD, 11));
		btnAgrgar.setBackground(SystemColor.textHighlight);
		btnAgrgar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Refacciones refacciones = new Refacciones();
					refacciones.setDescripcion(txtDescripcion.getText());
					refacciones.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
					refacciones.setPrecioventa(Double.parseDouble(txtPrecioventa.getText().toString()));
					refacciones.setMarca(txtMarca.getText());

					if (dao.create(refacciones)) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "SE AGREGO CORRCTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR");

				}

			}
		});
		btnAgrgar.setBounds(419, 7, 89, 23);
		NOMBRE.add(btnAgrgar);

		btnEditar = new JButton("EDITAR");
		btnEditar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtDescripcion.getText().equals("") || txtPrecio.getText().equals("")
							|| txtPrecioventa.getText().equals("") || txtMarca.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS");
						return;
					}
					refacciones.setDescripcion(txtDescripcion.getText());
					refacciones.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
					refacciones.setPrecioventa(Double.parseDouble(txtPrecio.getText().toString()));
					refacciones.setMarca(txtMarca.getText());
					if (dao.update(refacciones)) {
						actualizarTabla();
						limpiar();
						JOptionPane.showMessageDialog(null, "SE A EDITADO CORRECTAMENTE");

					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnEditar.setBounds(419, 52, 89, 23);
		NOMBRE.add(btnEditar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEliminar.setBackground(SystemColor.textHighlight);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcion = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR ESTE CLIENTE ?",
							"ELIMINAR USUARIO", JOptionPane.YES_NO_OPTION);
					if (opcion == 0) {
						if (dao.delete(lista.get(fila).getIdrefaccion())) {
							actualizarTabla();
							JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE !!");
						} else {
							JOptionPane.showMessageDialog(null, "ERROR");
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnEliminar.setBounds(419, 100, 89, 23);
		NOMBRE.add(btnEliminar);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 11));
		btnBorrar.setBackground(SystemColor.textHighlight);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnBorrar.setBounds(419, 149, 89, 23);
		NOMBRE.add(btnBorrar);

		JLabel lblTelefono = new JLabel("MARCA");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 11));
		lblTelefono.setBounds(10, 158, 71, 14);
		NOMBRE.add(lblTelefono);

		txtMarca = new JTextField();
		txtMarca.setBackground(SystemColor.activeCaptionBorder);
		txtMarca.setColumns(10);
		txtMarca.setBounds(106, 155, 86, 20);
		NOMBRE.add(txtMarca);
		
		btnPdf = new JButton("PDF");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileOutputStream archivo;
					// File file = new
					//File("C:\\Users\\KarlaDelia\\git\\PDEM\\PUNTODEVENTA\\src\\img\\uh.png");
					URI uri = new URI(getClass().getResource("/pdf/rRefacciones.pdf").toString());
					File File = new File(uri);
					archivo = new FileOutputStream(File);
					Document doc = new Document();
					PdfWriter.getInstance(doc, archivo);
					doc.open();
					java.awt.Image img2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/uh.png"));
					 //Image img =
					// Image.getInstance("C:\\Users\\KarlaDelia\\git\\PDEM\\PUNTODEVENTA\\src\\img\\uh.png");
					Image Img = Image.getInstance(getClass().getResource("/img/uh.png"));
					Img.setAlignment(Element.ALIGN_CENTER);
					Img.scaleToFit(200, 200);
					doc.add(Img);
					Paragraph p = new Paragraph(10);
					com.itextpdf.text.Font fontbold = FontFactory.getFont("Calibri", Font.BOLD);
					p.add(Chunk.NEWLINE);
					p.add("CATALOGO DE REFACCIONES");
					p.add(Chunk.NEWLINE);
					p.add(Chunk.NEWLINE);
					p.setAlignment(Element.ALIGN_CENTER);
					doc.add(p);
					// Tabla de datos
					PdfPTable tabla = new PdfPTable(5);
					tabla.setWidthPercentage(100);
					PdfPCell c1 = new PdfPCell(new Phrase("ID", fontbold));
					PdfPCell c2 = new PdfPCell(new Phrase("DESCRIPCION", fontbold));
					PdfPCell c3 = new PdfPCell(new Phrase("PRECIO", fontbold));
					PdfPCell c4 = new PdfPCell(new Phrase("PRECIO VENTA", fontbold));
					PdfPCell c5 = new PdfPCell(new Phrase("MARCA", fontbold));
					c1.setHorizontalAlignment(Element.ALIGN_CENTER);
					c2.setHorizontalAlignment(Element.ALIGN_CENTER);
					c3.setHorizontalAlignment(Element.ALIGN_CENTER);
					c4.setHorizontalAlignment(Element.ALIGN_CENTER);
					c5.setHorizontalAlignment(Element.ALIGN_CENTER);
					c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
					c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
					c3.setBackgroundColor(BaseColor.LIGHT_GRAY);
					c4.setBackgroundColor(BaseColor.LIGHT_GRAY);
					c5.setBackgroundColor(BaseColor.LIGHT_GRAY);
					tabla.addCell(c1);
					tabla.addCell(c2);
					tabla.addCell(c3);
					tabla.addCell(c4);
					tabla.addCell(c5);
					// Agregar los registros
					for (Refacciones re : lista) {
						tabla.addCell("" + re.getIdrefaccion());
						tabla.addCell(re.getDescripcion());
						tabla.addCell("" + re.getPrecio());
						tabla.addCell("" + re.getPrecioventa());
						tabla.addCell(re.getMarca());

					}
					doc.add(tabla);
					Paragraph p1 = new Paragraph(10);
					p1.add(Chunk.NEWLINE);
					p1.add("N�MERO DE REGISTROS: " + lista.size());
					p1.add(Chunk.NEWLINE);
					p1.add(Chunk.NEWLINE);
					p1.setAlignment(Element.ALIGN_RIGHT);
					doc.add(p1);
					doc.close();
					archivo.close();
					Desktop.getDesktop().open(File);
				} catch (FileNotFoundException ex) {
					Logger.getLogger(vRefacciones.class.getName()).log(Level.SEVERE, null, ex);
				} catch (DocumentException ex) {
					Logger.getLogger(vRefacciones.class.getName()).log(Level.SEVERE, null, ex);
				} catch (IOException ex) {
					Logger.getLogger(vRefacciones.class.getName()).log(Level.SEVERE, null, ex);
				} catch (URISyntaxException ex) {
					Logger.getLogger(vRefacciones.class.getName()).log(Level.SEVERE, null, ex);
				}

			}

				
			});
		
		btnPdf.setFont(new Font("Arial", Font.BOLD, 11));
		btnPdf.setBackground(SystemColor.textHighlight);
		btnPdf.setBounds(637, 67, 89, 23);
		NOMBRE.add(btnPdf);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				actualizarTabla2(txtBuscar.getText().toString());
			}
		});

		txtBuscar.setBounds(288, 155, 121, 20);
		NOMBRE.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setFont(new Font("Arial", Font.BOLD, 11));
		lblBuscar.setBounds(228, 161, 71, 14);
		NOMBRE.add(lblBuscar);
	
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(435, 490, 71, 58);
		NOMBRE.add(btnNewButton);
		
		lblAgregarRefaccionesA = new JLabel("AGREGAR REFACCIONES A LA VENTA");
		lblAgregarRefaccionesA.setFont(new Font("Arial", Font.BOLD, 23));
		lblAgregarRefaccionesA.setBounds(170, 427, 437, 31);
		NOMBRE.add(lblAgregarRefaccionesA);
		
		lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setFont(new Font("Arial", Font.BOLD, 11));
		lblCantidad.setBounds(25, 503, 71, 14);
		NOMBRE.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(82, 500, 133, 20);
		NOMBRE.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("AGREGAR A VENTA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(243, 530, 143, 23);
		NOMBRE.add(btnNewButton_1);
		
		

		modelo.addColumn("ID");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("PRECIO");
		modelo.addColumn("PRECIO VENTA");
		modelo.addColumn("MARCA");
		actualizarTabla();
		
	


	}
	
	

	public void actualizarTabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = dao.read();
		for (Refacciones u : lista) {
			Object o[] = new Object[5];
			o[0] = u.getIdrefaccion();
			o[1] = u.getDescripcion();
			o[2] = u.getPrecio();
			o[3] = u.getPrecioventa();
			o[4] = u.getMarca();

			modelo.addRow(o);
		}
		tblRefacciones.setModel(modelo);
	}
	
	public void actualizarTabla2(String palabra) {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = dao.buscar(palabra);
		for (Refacciones u : lista) {
			Object o[] = new Object[5];
			o[0] = u.getIdrefaccion();
			o[1] = u.getDescripcion();
			o[2] = u.getPrecio();
			o[3] = u.getPrecio();
			o[4] = u.getPrecioventa();
			modelo.addRow(o);
		}
		tblRefacciones.setModel(modelo);
	}


	public void limpiar() {
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtPrecioventa.setText("");
		txtMarca.setText("");
	}
}

	