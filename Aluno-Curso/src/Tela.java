import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela {

	private JFrame frame;
	private JTextField inputnome;
	private JTextField inputdisciplina;
	private JTextField inputnota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tela de Cadastro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(125, 19, 178, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(144, 68, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Disciplina");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(143, 103, 59, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nota");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(152, 133, 53, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		inputnome = new JTextField();
		inputnome.setBounds(216, 70, 86, 20);
		frame.getContentPane().add(inputnome);
		inputnome.setColumns(10);
		
		inputdisciplina = new JTextField();
		inputdisciplina.setBounds(218, 102, 86, 20);
		frame.getContentPane().add(inputdisciplina);
		inputdisciplina.setColumns(10);
		
		inputnota = new JTextField();
		inputnota.setBounds(219, 134, 86, 20);
		frame.getContentPane().add(inputnota);
		inputnota.setColumns(10);
		
		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				
				aluno.setNome(inputnome.getText());
				aluno.setDisciplina(inputdisciplina.getText());
				aluno.setNota(inputnota.getAlignmentX());
				
				if(AlunoDAO.salvarAluno(aluno)){
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				}
				else{
					JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
				}
			}
		});
		btncadastrar.setBounds(172, 194, 89, 23);
		frame.getContentPane().add(btncadastrar);
	}
}
