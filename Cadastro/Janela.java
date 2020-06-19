import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Janela extends JFrame{
	
	private String auxNome;
	private String auxSenha;
	
	JButton botao = new JButton("Avançar");
	JLabel legenda = new JLabel("Texto");
	JLabel legendaSenha = new JLabel("Texto");
	Font fonte = new Font("Arial",Font.BOLD, 15);
	JTextField caixaLogin = new JTextField(60);
	JTextField caixaSenha = new JTextField(60);
	
	Pessoa p1 = new Pessoa();
	
	public Janela() {
		
		//----------------------------------------------Botão---------------------------------------------------------
		botao.setFont(fonte);
		setLayout(null);									//layout da janela deixar null para eu escolher onde colocar os botoes
		botao.setBounds(175, 410, 100, 40);					//cria o botao no lugar e das dimensoes dadas(x, y, largura, altura)
		add(botao);											//adiciona o botao
		
		//-------------------------------------------texto---------------------------------------------------
		legenda.setFont(fonte);
		legenda.setText("Login:");
		legenda.setBounds(200, 240, 200, 50);
		add(legenda);
		
		legendaSenha.setFont(fonte);
		legendaSenha.setText("Senha:");
		legendaSenha.setBounds(200, 310, 200, 50);
		add(legendaSenha);
		//---------------------------------------caixa de texto-------------------------------------------
		caixaLogin.setBounds(100, 280, 250, 30);
		add(caixaLogin);
		auxNome = caixaLogin.getText();
		
		p1.setLogin(auxNome);
		
		caixaSenha.setBounds(100, 350, 250, 30);
		add(caixaSenha);
		auxSenha = caixaSenha.getText();
		
		p1.setSenha(auxSenha);
		
		System.out.println(p1.getLogin());
		System.out.println(p1.getSenha());
		
		//---------------------------------------Tela-------------------------------------------------------
		setTitle("Login");									//adiciona nome a janela
		setSize(500,800);									//Tamanho da janela (largura , altura)
		setLocationRelativeTo(null);						//posicao de onde ela ira aparecer null = meio da tela
		setResizable(false);								//nao poder redmensionar o tamanho
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//para parar de executar o programa quando fechar ele
		setVisible(true);									//deixa a janela visivel
	}		
}
