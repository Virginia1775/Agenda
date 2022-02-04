package profesor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import agenda.Contacto;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;


public class Agenda_Profesores extends JFrame {

	private JPanel contentPane;
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textSalario;
	private final ButtonGroup GrupoTipoContrato = new ButtonGroup();
	private JTable tablaAgenda;
	private ArrayList<Profesor>listaProfesor;
	private JRadioButton rbFijo;
	private JRadioButton rbTemporal;
	private JButton btnEliminar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda_Profesores frame = new Agenda_Profesores();
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
	public Agenda_Profesores() {
		listaProfesor=new ArrayList<Profesor>();
		setTitle("Agenda Profesores");
		setFont(new Font("Dialog", Font.BOLD, 22));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Virginia\\Pictures\\Saved Pictures\\71494590.jfif"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[172.00][203.00][229.00][]", "[55.00][90.00][27.00,grow][][38.00,grow][][][62.00]"));
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblDni, "cell 0 0,alignx center");
		
		textDni = new JTextField();
		textDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(textDni, "cell 1 0,growx");
		textDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNombre, "cell 0 1,alignx center");
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(textNombre, "cell 1 1,growx");
		textNombre.setColumns(10);
		
		JButton btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				añadirProfesor();
				mostrarProfesor();
			}
		});
		btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnAñadir, "cell 2 1,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 3 1 1 7,grow");
		
		tablaAgenda = new JTable();
		scrollPane.setViewportView(tablaAgenda);
		tablaAgenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Salario", "Tipo de Contrato"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaAgenda.getColumnModel().getColumn(3).setPreferredWidth(99);
		tablaAgenda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblSalario, "cell 0 2,alignx center");
		
		textSalario = new JTextField();
		textSalario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(textSalario, "cell 1 2,growx");
		textSalario.setColumns(10);
		
	    btnEliminar = new JButton("Eliminar");
	    btnEliminar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		limpiarDatos();
	    	}
	    });
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnEliminar, "cell 2 2,alignx center");
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDni.setText(null);
				textNombre.setText(null);
				textSalario.setText(null);
				
				
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnLimpiar, "cell 2 3,alignx center");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarDni();
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnBuscar, "cell 2 4,alignx center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo Contrato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1, "cell 0 5,grow");
		panel_1.setLayout(new MigLayout("", "[][]", "[]"));
		
		rbFijo = new JRadioButton("Fijo");
		rbFijo.setSelected(true);
		panel_1.add(rbFijo, "cell 0 0");
		GrupoTipoContrato.add(rbFijo);
		rbFijo.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		rbTemporal = new JRadioButton("Temporal");
		panel_1.add(rbTemporal, "cell 1 0");
		GrupoTipoContrato.add(rbTemporal);
		rbTemporal.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnSalir, "cell 2 5,alignx center");
	}

	protected void buscarDni() {
		Profesor p = new Profesor();
		p.setDni(textDni.getText());
		int indice = listaProfesor.indexOf(p);
		if (indice==-1) {
			JOptionPane.showMessageDialog(null, "DNI no encontrado");
		} else {
			p=listaProfesor.get(indice);
			textNombre.setText(p.getNombre());
			textSalario.setText(""+p.getSalario());
			GrupoTipoContrato.clearSelection();
			if (p.isFijo()) {
				rbFijo.setSelected(true);
			} else {
				rbTemporal.setSelected(true);
			}
			
		}
	}

	protected void limpiarDatos() {
		int fila=tablaAgenda.getSelectedRow();
		listaProfesor.remove(fila);
		DefaultTableModel modelo = (DefaultTableModel) tablaAgenda.getModel();
		modelo.removeRow(fila);
		
	}

	protected void mostrarProfesor() {
		
		DefaultTableModel modelo = (DefaultTableModel) tablaAgenda.getModel();
		modelo.setRowCount(0);
		for(Profesor profesor: listaProfesor) {
			String contrato = "Temporal";
			if (profesor.isFijo()) {
				contrato="Fijo";
			}
			Object fila[] = {
					                 profesor.getDni(),profesor.getNombre(),profesor.getSalario()
									, contrato
			};
			modelo.addRow(fila);
		}
	}

	protected void añadirProfesor() {
         Profesor p= new Profesor();
		

		p.setNombre(textNombre.getText());
		p.setDni(textDni.getText());
		p.setSalario(Double.parseDouble(textSalario.getText()));
		/*if (rbFijo.isSelected()) {
			p.setFijo(true);
		} else {
			p.setFijo(false);
		}*/
		p.setFijo(rbFijo.isSelected());
		
	
		
		listaProfesor.add(p);
		
	}

}
