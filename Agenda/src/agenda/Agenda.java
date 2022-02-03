package agenda;
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
import javax.swing.JScrollPane;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTable tablaAgenda;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JButton btnSalir;
	private JButton btnEliminar;
	private JButton btnAñadir;
	private ArrayList<Contacto>listaContactos;
	private JScrollPane scrollPane;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Virginia\\Pictures\\Saved Pictures\\71494590.jfif"));
		setFont(new Font("Dialog", Font.BOLD, 20));
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[165.00][119.00][grow]", "[][][79.00][136.00][grow]"));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 0 1 5,grow");
		
		tablaAgenda = new JTable();
		scrollPane.setViewportView(tablaAgenda);
		tablaAgenda.setFillsViewportHeight(true);
		tablaAgenda.setModel(new DefaultTableModel(
			new Object[][] {
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
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNombre, "cell 1 0");
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(textNombre, "cell 2 0,growx");
		textNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblTelefono, "cell 1 1");
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(textTelefono, "cell 2 1,growx");
		textTelefono.setColumns(10);
		
		 btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirContacto();
				mostrarContacto();
			}
		});
		btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnAñadir, "cell 2 2,alignx center");
		
		 btnEliminar = new JButton("Eliminar");
		 btnEliminar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		borrarContacto();
		 		//mostrarContacto();
		 	}
		 });
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnEliminar, "cell 2 3,alignx center");
		
		 btnSalir = new JButton("Salir");
		 btnSalir.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		System.exit(0);
		 	}
		 });
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnSalir, "cell 2 4,alignx center");
	}

	protected void borrarContacto() {
		int fila=tablaAgenda.getSelectedRow();
		listaContactos.remove(fila);
		DefaultTableModel modelo = (DefaultTableModel) tablaAgenda.getModel();
		modelo.removeRow(fila);
		
	
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
