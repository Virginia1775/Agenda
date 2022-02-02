import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTable tablaAgenda;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JButton btnSalir;
	private JButton btnEliminar;
	private JButton btnAñadir;
	private ArrayList<Contacto>listaContactos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		listaContactos= new ArrayList<Contacto>();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\virgi\\Pictures\\Saved Pictures\\71494590.jfif"));
		setFont(new Font("Dialog", Font.BOLD, 20));
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][grow]", "[][][][][][][][][][][]"));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNombre, "cell 8 1");
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(textNombre, "cell 10 1,growx");
		textNombre.setColumns(10);
		
		tablaAgenda = new JTable();
		tablaAgenda.setFillsViewportHeight(true);
		tablaAgenda.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Nombre", "Telefono"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		contentPane.add(tablaAgenda, "cell 1 1 5 10,grow");
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblTelefono, "cell 8 3");
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(textTelefono, "cell 10 3,growx");
		textTelefono.setColumns(10);
		
		 btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirContacto();
				mostrarContacto();
			}
		});
		btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnAñadir, "cell 10 6,alignx center");
		
		 btnEliminar = new JButton("Eliminar");
		 btnEliminar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		borrarContacto();
		 	}
		 });
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnEliminar, "cell 10 8,alignx center");
		
		 btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnSalir, "cell 10 10,alignx center");
	}

	protected void borrarContacto() {
		Contacto c = new Contacto();
		c.setNombre(tablaAgenda.getName());
	
	}

	protected void mostrarContacto() {
		DefaultTableModel modelo = (DefaultTableModel) tablaAgenda.getModel();
		modelo.setRowCount(0);
		for(Contacto contacto: listaContactos) {
			Object fila[] = {
									contacto.getNombre(),contacto.getTelefono()
			};
			modelo.addRow(fila);
		}
		
		
	}

	protected void añadirContacto() {
		Contacto c = new Contacto();
		

		c.setNombre(textNombre.getText());
		c.setTelefono(textTelefono.getText());
		
		listaContactos.add(c);
	
		
	}

}
