package Vista;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.print.*;
import javax.swing.JOptionPane;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.Doc;
import javax.print.ServiceUI;
import javax.print.attribute.*;



import java.awt.*;
import java.awt.print.*;
import javax.swing.JOptionPane;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.Doc;
import javax.print.ServiceUI;
import javax.print.attribute.*;

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

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Dao.daoVentas;
import Modelo.Refacciones;
import Modelo.Ventas;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class vVentas extends JFrame {

	private JPanel contentPane;
	private JTable tblVentas;
	private JScrollPane scrollPane;
	daoVentas dao = new daoVentas();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Refacciones> lista = new ArrayList<Refacciones>();
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
	                  

	
	
	public vVentas() {
		
		
		
		setTitle("VENTA");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 799, 626);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 773, 324);
		contentPane.add(scrollPane);
		


		tblVentas = new JTable();
		tblVentas.setSelectionBackground(Color.CYAN);
		tblVentas.setBackground(SystemColor.activeCaptionBorder);
		tblVentas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
		
			}
		});
		tblVentas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
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
		btnEntradas.setBackground(SystemColor.textHighlight);
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
		btnSalidas.setBackground(SystemColor.activeCaption);
		btnSalidas.setBounds(105, 67, 85, 23);
		contentPane.add(btnSalidas);
		
		JButton btnCobrar = new JButton("COBRAR");
		btnCobrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCobrar.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnCobrar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 128, 192)));
		btnCobrar.setBackground(SystemColor.textHighlight);
		btnCobrar.setBounds(462, 449, 136, 66);
		contentPane.add(btnCobrar);
		
		JButton btnImprimirTicket = new JButton("IMPRIMIR TICKET");
		btnImprimirTicket.addActionListener(new ActionListener() {
			private Object contentTicket;

			public void actionPerformed(ActionEvent e) {
				ticket();
			}

			private void ticket() {
			
				  String contentTicket = "REFACCIONARIA {{nameLocal}}\n"+
				    "EXPEDIDO EN: {{expedition}}\n"+
				    "DOMICILIO CONOCIDO TECAMAC, MEX.\n"+
				    "=============================\n"+
				    "TECAMAC, XXXXXXXXXXXX\n"+
				    "RFC: XXX-020226-XX9\n"+
				    "Caja # {{box}} - Ticket # {{ticket}}\n"+
				    "LE ATENDIO: {{cajero}}\n"+
				    "{{dateTime}}\n"+
				    "=============================\n"+
				    "{{items}}\n"+
				    "=============================\n"+
				    "SUBTOTAL: {{subTotal}}\n"+
				    "IVA: {{tax}}\n"+
				    "TOTAL: {{total}}\n\n"+
				    "RECIBIDO: {{recibo}}\n"+
				    "CAMBIO: {{change}}\n\n"+
				    "=============================\n"+
				    "GRACIAS POR SU COMPRA...\n"+
				    "ESPERAMOS SU VISITA NUEVAMENTE {{nameLocal}}\n"+
				    "\n"+
				    "\n";
			}
				  //El constructor que setea los valores a la instancia
				  void Ticket(String nameLocal, String expedition, String box, String ticket, String caissier, String dateTime, String items, String subTotal, String tax, String total, String recibo, String change) {
				    this.contentTicket = ((String) this.contentTicket).replace("{{nameLocal}}", nameLocal);
				    this.contentTicket = ((String) this.contentTicket).replace("{{expedition}}", expedition);
				    this.contentTicket = ((String) this.contentTicket).replace("{{box}}", box);
				    this.contentTicket = ((String) this.contentTicket).replace("{{ticket}}", ticket);
				    this.contentTicket = ((String) this.contentTicket).replace("{{cajero}}", caissier);
				    this.contentTicket = ((String) this.contentTicket).replace("{{dateTime}}", dateTime);
				    this.contentTicket = ((String) this.contentTicket).replace("{{items}}", items);
				    this.contentTicket = ((String) this.contentTicket).replace("{{subTotal}}", subTotal);
				    this.contentTicket = ((String) this.contentTicket).replace("{{tax}}", tax);
				    this.contentTicket = ((String) this.contentTicket).replace("{{total}}", total);
				    this.contentTicket = ((String) this.contentTicket).replace("{{recibo}}", recibo);
				    this.contentTicket = ((String) this.contentTicket).replace("{{change}}", change);
				  }
				    
				  public void print() {
				    //Especificamos el tipo de dato a imprimir
				    //Tipo: bytes; Subtipo: autodetectado
				    DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
				    
				    //Aca obtenemos el servicio de impresion por defatul
				    //Si no quieres ver el dialogo de seleccionar impresora usa esto
				    //PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
				    
				    
				    //Con esto mostramos el dialogo para seleccionar impresora
				    //Si quieres ver el dialogo de seleccionar impresora usalo
				    //Solo mostrara las impresoras que soporte arreglo de bits
				    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
				    PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
				    PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
				    PrintService service = ServiceUI.printDialog(null, 700, 200, printService, defaultService, flavor, pras);
				      
				    //Creamos un arreglo de tipo byte
				    byte[] bytes;

				    //Aca convertimos el string(cuerpo del ticket) a bytes tal como
				    //lo maneja la impresora(mas bien ticketera :p)
				    bytes = ((String) this.contentTicket).getBytes();

				    //Creamos un documento a imprimir, a el se le appendeara
				    //el arreglo de bytes
				    Doc doc = new SimpleDoc(bytes,flavor,null);
				      
				    //Creamos un trabajo de impresión
				    DocPrintJob job = service.createPrintJob();

				    //Imprimimos dentro de un try de a huevo
				    try {
				      //El metodo print imprime
				      job.print(doc, null);
				    } catch (Exception er) {
				      JOptionPane.showMessageDialog(null,"Error al imprimir: " + er.getMessage());
				    }
				  }

				});
	
		btnImprimirTicket.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnImprimirTicket.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 128, 192)));
		btnImprimirTicket.setBackground(SystemColor.textHighlight);
		btnImprimirTicket.setBounds(640, 471, 85, 23);
		contentPane.add(btnImprimirTicket);
		
		
		JLabel lblProductosEn = new JLabel("0 PRODUCTOS EN LA VENTA ACTUAL");
		lblProductosEn.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProductosEn.setBounds(38, 449, 233, 14);
		contentPane.add(lblProductosEn);
		
		JLabel hno = new JLabel("TOTAL:");
		hno.setFont(new Font("Arial", Font.PLAIN, 12));
		hno.setBounds(22, 534, 52, 14);
		contentPane.add(hno);
		
		JLabel nkon = new JLabel("SUB TOTAL:");
		nkon.setFont(new Font("Arial", Font.PLAIN, 12));
		nkon.setBounds(99, 534, 81, 14);
		contentPane.add(nkon);
		
		JLabel ojojji = new JLabel("IGV:");
		ojojji.setFont(new Font("Arial", Font.PLAIN, 12));
		ojojji.setBounds(190, 534, 66, 14);
		contentPane.add(ojojji);
		
		JButton btnEliminar = new JButton("ELIMINAR VENTA");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						int opcion = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR ESTA VENTA ?",
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
		
		modelo.addColumn("CÓDIGO DE BARRAS");
		modelo.addColumn("DESCRIPCIÓN DEL PRODUCTO");
		modelo.addColumn("PRECIO");
		modelo.addColumn("PRECIO VENTA");
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
			tblVentas.setModel(modelo);
		}
	}

	
	
	



