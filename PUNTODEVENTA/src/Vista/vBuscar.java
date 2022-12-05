package Vista;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Dao.DaoProvedor;
import Modelo.Proveedor;

public class vBuscar extends javax.swing.JFrame {

	Proveedor p, p1;
	DaoProvedor DaoProveedor;
	int id = 0;
	ArrayList<Proveedor> listaProveedors = null;
	Object opciones[] = { "Aceptar" };
	DefaultTableModel model = new DefaultTableModel();

	public vBuscar() {
		initComponents();
		model.addColumn("NOMBRE");
		model.addColumn("CONTACTO");
		model.addColumn("TELEFONO");
		model.addColumn("CIUDAD");
		DaoProveedor = new DaoProvedor();
		p1 = new Proveedor();
		refrescarTabla();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		txtCiudad = new javax.swing.JTextField();
		txtProveedor = new javax.swing.JTextField();
		txtContacto = new javax.swing.JTextField();
		txtTelefono = new javax.swing.JTextField();
		btnLimpiar = new javax.swing.JButton();
		btnAgregar = new javax.swing.JButton();
		btnEliminar = new javax.swing.JButton();
		btnGuardar = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblDatos = new javax.swing.JTable();
		jLabel5 = new javax.swing.JLabel();
		txtBuscar = new javax.swing.JTextField();
		btnPDF = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("Proveedor");
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 21, -1, -1));

		jLabel2.setText("Contacto");
		getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

		jLabel3.setText("Telefono");
		getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

		jLabel4.setText("Cuidad");
		getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));
		getContentPane().add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 150, 30));

		txtProveedor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtProveedorActionPerformed(evt);
			}
		});
		getContentPane().add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));
		getContentPane().add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 150, 30));
		getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 150, 30));

		btnLimpiar.setText("Limpiar");
		btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLimpiarActionPerformed(evt);
			}
		});
		getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 70, 40));

		btnAgregar.setText("Agregar");
		btnAgregar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAgregarActionPerformed(evt);
			}
		});
		getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, 40));

		btnEliminar.setText("Eliminar");
		btnEliminar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEliminarActionPerformed(evt);
			}
		});
		getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 70, 40));

		btnGuardar.setText("Guardar");
		btnGuardar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnGuardarActionPerformed(evt);
			}
		});
		getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, 40));

		tblDatos.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblDatosMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tblDatos);

		getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 630, 220));

		jLabel5.setText("BUSCAR");
		getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

		txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtBuscarKeyReleased(evt);
			}
		});
		getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 270, 30));

		btnPDF.setText("PDF");
		btnPDF.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPDFActionPerformed(evt);
			}
		});
		getContentPane().add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 70, 40));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void txtProveedorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtProveedorActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtProveedorActionPerformed

	private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			FileOutputStream archivo;
			// File file = new
			// File("C:\\Users\\Rene\\Documents\\NetBeansProjects\\Java_MVC_MySQL\\src\\pdf\\reporteProducto.pdf");
			URI uri = new URI(getClass().getResource("/pdf/rProveedor.pdf").toString());
			File file = new File(uri);
			archivo = new FileOutputStream(file);
			Document doc = new Document();
			PdfWriter.getInstance(doc, archivo);
			doc.open();
			java.awt.Image img2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icono.png"));
			// Image img =
			// Image.getInstance("C:\\Users\\Rene\\Documents\\NetBeansProjects\\Java_MVC_MySQL\\src\\img\\i2.png");
			Image img = Image.getInstance(getClass().getResource("/img/logo.png"));
			img.setAlignment(Element.ALIGN_CENTER);
			img.scaleToFit(200, 200);
			doc.add(img);
			Paragraph p = new Paragraph(10);
			Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
			p.add(Chunk.NEWLINE);
			p.add("CATALOGO DE PROVEEDORES");
			p.add(Chunk.NEWLINE);
			p.add(Chunk.NEWLINE);
			p.setAlignment(Element.ALIGN_CENTER);
			doc.add(p);
			// Tabla de datos
			PdfPTable tabla = new PdfPTable(5);
			tabla.setWidthPercentage(100);
			PdfPCell c1 = new PdfPCell(new Phrase("ID PROVEEDOR", negrita));
			PdfPCell c2 = new PdfPCell(new Phrase("PROVEEDOR", negrita));
			PdfPCell c3 = new PdfPCell(new Phrase("CONTACTO", negrita));
			PdfPCell c4 = new PdfPCell(new Phrase("TELEFONO", negrita));
			PdfPCell c5 = new PdfPCell(new Phrase("CIUDAD", negrita));
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
			for (Proveedor pro : listaProveedors) {
				tabla.addCell("" + pro.getIdProveedor());
				tabla.addCell(pro.getNombreProveedor());
				tabla.addCell("" + pro.getNombreContacto());
				tabla.addCell("" + pro.getTelefonoProveedor());
				tabla.addCell("" + pro.getCiudadProveedor());

			}
			doc.add(tabla);
			Paragraph p1 = new Paragraph(10);
			p1.add(Chunk.NEWLINE);
			p1.add("N�MERO DE REGISTROS: " + listaProveedors.size());
			p1.add(Chunk.NEWLINE);
			p1.add(Chunk.NEWLINE);
			p1.setAlignment(Element.ALIGN_RIGHT);
			doc.add(p1);
			doc.close();
			archivo.close();
			Desktop.getDesktop().open(file);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(vBuscar.class.getName()).log(Level.SEVERE, null, ex);
		} catch (DocumentException ex) {
			Logger.getLogger(vBuscar.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(vBuscar.class.getName()).log(Level.SEVERE, null, ex);
		} catch (URISyntaxException ex) {
			Logger.getLogger(vBuscar.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed
		p = new Proveedor();
		p.setNombreProveedor(txtProveedor.getText().toString());
		p.setNombreContacto(txtContacto.getText().toString());
		p.setTelefonoProveedor(txtTelefono.getText().toString());
		p.setCiudadProveedor(txtCiudad.getText().toString());
		if (!p.validaProveedor()) {
			JOptionPane.showOptionDialog(this, "Falta llenar campos", "ERROR", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")),
					opciones, opciones[0]);
			return;
		}
		if (!DaoProveedor.create(p)) {
			JOptionPane.showOptionDialog(this, "No se guardo registro", "ERROR", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")),
					opciones, opciones[0]);
		} else {
			JOptionPane.showOptionDialog(this, "Se guardo correctamente", "EXITO!!!", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")),
					opciones, opciones[0]);

		}
		limpiarCampos();
		refrescarTabla();
	}// GEN-LAST:event_btnAgregarActionPerformed

	private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtBuscarKeyReleased
		refrescarTabla2(txtBuscar.getText().toString());
	}// GEN-LAST:event_txtBuscarKeyReleased

	private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblDatosMouseClicked
		int fila = tblDatos.getSelectedRow();
		id = listaProveedors.get(fila).getIdProveedor();
		p1 = DaoProveedor.read(id);
		txtProveedor.setText(p1.getNombreProveedor());
		txtContacto.setText(p1.getNombreContacto());
		txtTelefono.setText(p1.getTelefonoProveedor());
		txtCiudad.setText(p1.getCiudadProveedor());
	}// GEN-LAST:event_tblDatosMouseClicked

	private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
		p1.setNombreProveedor(txtProveedor.getText().toString());
		p1.setNombreContacto(txtContacto.getText().toString());
		p1.setTelefonoProveedor(txtTelefono.getText().toString());
		p1.setCiudadProveedor(txtCiudad.getText().toString());
		if (p1.getIdProveedor() > 0) {

			if (!p1.validaProveedor()) {
				JOptionPane.showOptionDialog(this, "Falta Llenar Campos", "ERROR", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")), opciones, opciones[0]);
				return;
			}
			if (!DaoProveedor.update(p1)) {
				JOptionPane.showOptionDialog(this, "Error al Actualizar Registro", "ERROR", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")), opciones, opciones[0]);
			} else {
				JOptionPane.showOptionDialog(this, "Se Actualizo Correctamente!!", "EXITO!!!",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")), opciones, opciones[0]);
			}
		} else {
			JOptionPane.showOptionDialog(this, "Falta seleccionar un Registro a Eliminar", "ERROR",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")), opciones, opciones[0]);
		}

		limpiarCampos();
		refrescarTabla();
	}// GEN-LAST:event_btnGuardarActionPerformed

	private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLimpiarActionPerformed
		limpiarCampos();
	}// GEN-LAST:event_btnLimpiarActionPerformed

	private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
		if (id > 0) {
			Object opciones2[] = { "SI", "NO" };
			int x = JOptionPane.showOptionDialog(this, "¿Estás seguro que deseas eliminar este registro?",
					"Eliminar Registro", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")), opciones2, opciones2[0]);
			if (x == 0) {
				if (!DaoProveedor.delete(id)) {
					JOptionPane.showOptionDialog(this, "Error al eliminar Registro", "ERROR",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")), opciones, opciones[0]);
				} else {
					JOptionPane.showOptionDialog(this, "SE ELIMINO CORRECTAMENTE", "EXITO!!!",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")), opciones, opciones[0]);
				}
				limpiarCampos();
			}
		} else {
			JOptionPane.showOptionDialog(this, "Falta seleccionar un Registro a Eliminar", "ERROR",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(getClass().getResource("/imagenes/logooxxomin.png")), opciones, opciones[0]);
		}
		refrescarTabla();
	}// GEN-LAST:event_btnEliminarActionPerformed

	public void refrescarTabla() {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		listaProveedors = DaoProveedor.read();
		for (Proveedor p : listaProveedors) {
			Object item[] = new Object[4];
			item[0] = p.getNombreProveedor();
			item[1] = p.getNombreContacto();
			item[2] = p.getTelefonoProveedor();
			item[3] = p.getCiudadProveedor();
			model.addRow(item);
		}
		tblDatos.setModel(model);
	}

	public void refrescarTabla2(String palabra) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		listaProveedors = DaoProveedor.buscar(palabra);
		for (Proveedor p : listaProveedors) {
			Object item[] = new Object[4];
			item[0] = p.getNombreProveedor();
			item[1] = p.getNombreContacto();
			item[2] = p.getTelefonoProveedor();
			item[3] = p.getCiudadProveedor();
			model.addRow(item);
		}
		tblDatos.setModel(model);
	}

	public void limpiarCampos() {
		txtProveedor.setText("");
		txtContacto.setText("");
		txtTelefono.setText("");
		txtCiudad.setText("");
	}

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(vBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(vBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(vBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(vBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new vBuscar().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAgregar;
	private javax.swing.JButton btnEliminar;
	private javax.swing.JButton btnGuardar;
	private javax.swing.JButton btnLimpiar;
	private javax.swing.JButton btnPDF;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tblDatos;
	private javax.swing.JTextField txtBuscar;
	private javax.swing.JTextField txtCiudad;
	private javax.swing.JTextField txtContacto;
	private javax.swing.JTextField txtProveedor;
	private javax.swing.JTextField txtTelefono;
	// End of variables declaration//GEN-END:variables
}
