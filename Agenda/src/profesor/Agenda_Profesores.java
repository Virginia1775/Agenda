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


public class Agenda_Profesores extends JFrame {

	private JPanel contentPane;
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textSalario;
	private final ButtonGroup GrupoTipoContrato = new ButtonGroup();
	private JTable table;
	private ArrayList<Profesor>listaProfesor;

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
		contentPane.setLayout(new MigLayout("", "[172.00][203.00][229.00][]", "[55.00][90.00][27.00,grow][38.00,grow][][][62.00]"));
		
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
		contentPane.add(scrollPane, "cell 3 1 1 6,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Salario", "Tipo de Contrato"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(99);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblSalario, "cell 0 2,alignx center");
		
		textSalario = new JTextField();
		textSalario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(textSalario, "cell 1 2,growx");
		textSalario.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnLimpiar, "cell 2 2,alignx center");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnBuscar, "cell 2 3,alignx center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1, "cell 0 4,grow");
		panel_1.setLayout(new MigLayout("", "[]", "[]"));
		
		JRadioButton rbFijo = new JRadioButton("Fijo");
		panel_1.add(rbFijo, "cell 0 0");
		GrupoTipoContrato.add(rbFijo);
		rbFijo.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnSalir, "cell 2 4,alignx center");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, "cell 0 5,grow");
		panel.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JRadioButton rbTemporal = new JRadioButton("Temporal");
		panel.add(rbTemporal, "cell 0 0");
		GrupoTipoContrato.add(rbTemporal);
		rbTemporal.setFont(new Font("Tahoma", Font.BOLD, 16));
	}

	protected void mostrarProfesor() {
		
		
	}

	protected void añadirProfesor() {
Profesor p= new Profesor();
		

		p.setNombre(textNombre.getText());
		p.setDni(textDni.getText());
		p.setSalario(Double.parseDouble(textSalario.getText()));
		//p.setFijo(Boolean.parseBoolean(GrupoTipoSalario.get));
	
		
		listaProfesor.add(p);
		
	}

}
