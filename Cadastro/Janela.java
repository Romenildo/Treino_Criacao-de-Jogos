import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame{
	
	
	JButton botao = new JButton("Avançar");
	
	
	public Janela() {
		
		//----------------------------------------------Botão---------------------------------------------------------
		
		setLayout(null);									//layout da janela deixar null para eu escolher onde colocar os botoes
		botao.setBounds(200, 600, 100, 40);					//cria o botao no lugar e das dimensoes dadas(x, y, largura, altura)
		add(botao);											//adiciona o botao
		//-------------------------------------------------------------------------------------------------------
		
		
		
		//---------------------------------------Tela-------------------------------------------------------
		setTitle("Login");									//adiciona nome a janela
		setSize(500,800);									//Tamanho da janela (largura , altura)
		setLocationRelativeTo(null);						//posicao de onde ela ira aparecer null = meio da tela
		setResizable(false);								//nao poder redmensionar o tamanho
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//para parar de executar o programa quando fechar ele
		setVisible(true);									//deixa a janela visivel
	}		
}
