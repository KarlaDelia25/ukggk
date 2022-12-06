/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Dao.daoRefacciones;
import Decoder.BASE64Decoder;
import Modelo.Refacciones;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class vRefacciones extends javax.swing.JFrame {

    
    ImageIcon imgOri = null;
    String imagenActual = "";
    daoRefacciones dao = new daoRefacciones();
    ArrayList<Refacciones> lista;
    int index = -1;
    Refacciones auto;
    public vRefacciones() {
        initComponents();
        this.setTitle("REFACCIONES");
        tablaAuto.setRowHeight(100);
        verTabla();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAuto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(20, 106, 80, 14);
        txtMarca = new javax.swing.JTextField();
        txtMarca.setBounds(120, 67, 170, 22);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(20, 71, 80, 14);
        btnEliminar = new javax.swing.JButton();
        btnEliminar.setBounds(300, 220, 80, 60);
        btnGuardar = new javax.swing.JButton();
        btnGuardar.setBounds(120, 220, 80, 60);
        btnActualizar = new javax.swing.JButton();
        btnActualizar.setBounds(210, 220, 80, 60);
        btnCargarFoto = new javax.swing.JButton();
        btnCargarFoto.setBounds(20, 235, 90, 30);
        btnBorrar1 = new javax.swing.JButton();
        btnBorrar1.setBounds(390, 220, 80, 60);
        txtModelo = new javax.swing.JTextField();
        txtModelo.setBounds(120, 103, 170, 22);
        lblImagen = new javax.swing.JLabel();
        lblImagen.setBounds(390, 30, 300, 170);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaAuto.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"Title 1", "Title 2", "Title 3", "Title 4", "New column", "New column"
        	}
        ));
        tablaAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAuto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 740, 210));

        jPanel1.setBorder(new TitledBorder(null, "REFACCIONES", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jPanel1.setLayout(null);

        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 13)); // NOI18N
        jLabel1.setText("PRECIO");
        jPanel1.add(jLabel1);
        jPanel1.add(txtMarca);

        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 11)); // NOI18N
        jLabel2.setText("DESCRIPCION");
        jPanel1.add(jLabel2);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar);

        btnCargarFoto.setText("Cargar Foto");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarFoto);

        btnBorrar1.setText("Borrar");
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar1);
        jPanel1.add(txtModelo);

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblImagen);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 740, 300));
        
        JLabel lblPrecioVenta = new JLabel();
        lblPrecioVenta.setText("PRECIO VENTA");
        lblPrecioVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPrecioVenta.setBounds(20, 139, 90, 14);
        jPanel1.add(lblPrecioVenta);
        
        textField = new JTextField();
        textField.setBounds(120, 136, 170, 22);
        jPanel1.add(textField);
        
        JLabel jLabel1_1_1 = new JLabel();
        jLabel1_1_1.setText("MARCA");
        jLabel1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        jLabel1_1_1.setBounds(20, 169, 90, 14);
        jPanel1.add(jLabel1_1_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(120, 169, 170, 22);
        jPanel1.add(textField_1);
        
        JLabel lblId = new JLabel();
        lblId.setText("ID");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblId.setBounds(20, 32, 34, 14);
        jPanel1.add(lblId);
        
        JLabel lblNewLabel = new JLabel("0");
        lblNewLabel.setBounds(46, 30, 46, 14);
        jPanel1.add(lblNewLabel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaAutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAutoMouseClicked
        index = tablaAuto.getSelectedRow();
        auto = dao.read(lista.get(index).getIdrefaccion());
        txtMarca.setText(auto.getDescripcion());
        txtModelo.setText(auto.getPrecio().toString());
        txtModelo.setText(auto.getPrecioventa().toString());
        txtModelo.setText(auto.getMarca());
        ImageIcon img = base64ToImage(auto.getImagen());
        Image image = img.getImage(); // transform it
        Image newimg = image.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon i = new ImageIcon(newimg);
        lblImagen.setIcon(i);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
    }//GEN-LAST:event_tablaAutoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (index > -1) {
            int res = JOptionPane.showConfirmDialog(null, "Desea eliminar este registro ", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (res == 0) {
                dao.delete(lista.get(index).getIdrefaccion());
                JOptionPane.showMessageDialog(this, "Se Elimino correctamente");
                verTabla();
            }
        }
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Refacciones a = new Refacciones();
        a.setMarca(txtMarca.getText());
        a.setPrecio(Double.parseDouble(txtModelo.getText().toString()));
        a.setPrecioventa(Double.parseDouble(txtModelo.getText().toString()));
        a.setMarca(txtModelo.getText());
        a.setImagen(imagenActual);
        if (dao.create(a)) {
            JOptionPane.showMessageDialog(this, "Se Guardo correctamente");
            verTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al Guardar Auto");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        auto.setDescripcion(txtMarca.getText());
        auto.setPrecio(Double.parseDouble(txtModelo.getText().toString()));
        auto.setPrecioventa(Double.parseDouble(txtModelo.getText().toString()));
        auto.setMarca(txtModelo.getText());
        auto.setImagen(imagenActual);
        if (dao.update(auto)) {
            JOptionPane.showMessageDialog(this, "Se Actualizo correctamente");
            verTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al Actualizar Auto");
        }
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        selector.setFileFilter(filtroImagen);
        int r = selector.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            try {
                File f = selector.getSelectedFile();
                ImageIcon img = new ImageIcon(selector.getSelectedFile().toURL());
                imgOri = img;
                Image image = img.getImage(); // transform it
                Image newimg = image.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                URL urlImage = selector.getSelectedFile().toURL();
                imagenActual = convetirImagen(urlImage);
                lblImagen.setIcon(new ImageIcon(newimg));
            } catch (MalformedURLException ex) {
                Logger.getLogger(vRefacciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCargarFotoActionPerformed
 public ImageIcon base64ToImage(String base64) {
        ImageIcon image = null;
        try {
            byte[] imageByte;
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(base64);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            BufferedImage bufferedImage = ImageIO.read(bis);
            image = new ImageIcon(bufferedImage);
            bis.close();
        } catch (IOException ex) {
            Logger.getLogger(vRefacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

    public String convetirImagen(URL url) {
        String base64 = "";
        try {
            BufferedImage bImage = ImageIO.read(new File(url.getPath()));
            BufferedImage img = resize(bImage, 100, 100);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", bos);
            byte[] data = bos.toByteArray();
            base64 = Base64.getEncoder().encodeToString(data);
        } catch (MalformedURLException ex) {
            Logger.getLogger(vRefacciones.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(vRefacciones.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return base64;
    }

    public BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }

    public void verTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override //Redefinimos el método getColumnClass
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Object.class;
                    case 1:
                        return Object.class;
                    case 2:
                        return ImageIcon.class;
                    default:
                        return Object.class;
                }
            }
        };
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("DESCRIPCION");
        modeloTabla.addColumn("PRECIO");
        modeloTabla.addColumn("PRECIOVENTA");
        modeloTabla.addColumn("MARCA");
        modeloTabla.addColumn("IMAGEN");
        lista = dao.read();
        for (Refacciones a : lista) {
            Object[] columna = new Object[5];
            columna[0] = a.getIdrefaccion();
            columna[1] = a.getDescripcion();
            columna[2] = a.getPrecio();
            columna[3] = a.getPrecioventa();
            columna[4] = a.getMarca();
            columna[5] = base64ToImage(a.getImagen());
            modeloTabla.addRow(columna);
        }
        tablaAuto.setModel(modeloTabla);
    }
    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
    	txtMarca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtMarca.setText("");
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vRefacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vRefacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vRefacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vRefacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vRefacciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tablaAuto;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private JTextField textField;
    private JTextField textField_1;
}
