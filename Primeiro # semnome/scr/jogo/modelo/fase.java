//Fase é tudo aquilo que vai estar na tela
//seja objeto, cenario, tiros, inimigos...


package shottingStar.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{//ActionListener faz e o que faz a tela atualizar quando a tela move

	private Image fundo;  //variavel da tela de fundo
	private Player player; //variavel do personagem
	private Timer timer;  //###timer
	
	
	public Fase() {
		//Metodo referente a tudo do backgroud que esta na fase
		setFocusable(true);
		setDoubleBuffered(true);//essas duas linhas faz melhoria no desempenho do jogo
		
		
		ImageIcon referencia = new ImageIcon("res\\0uOOsR9.png");//cria um objeto do nome referencia
		fundo = referencia.getImage();  //as imagens ficam na pasta res
		
		player = new Player();//cria o objeto da classe player
		player.load();//chama o metodo load e carrega a imagem do personagem
		
		addKeyListener(new TecladoAdapter());//instancia o teclado
		
		timer = new Timer(5, this);//###timer
		timer.start();//timer é a velocidade do jogo##timer
	}
	
	
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);//imagem/x/y/posicao null = meio
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);//onde a nave vai aparecer os valores getx e gety vem do objeto na outra classe por isso o getter

		List<Tiro>tiros = player.getTiros();//pega a lista de tiros e coloca na tela
		for(int i =0; i < tiros.size();i++) 
		{
			Tiro m = tiros.get(i);
			m.load();
			graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
				
		}
		
		g.dispose();
		
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		//metodo da actionListener que faz com que a tela atualize
		player.update();//metodo do player que atualizar a tela
		List<Tiro>tiros = player.getTiros();//pega a lista de tiros e coloca na tela
		for(int i =0; i < tiros.size();i++) 
		{
			Tiro m = tiros.get(i);
			if(m.isVisivel()) {
				m.update();
			}else {
				tiros.remove(i);
			}
				
		}
		
		repaint();// nao ficar a imagem anterior
		
		
	}
	
	private class TecladoAdapter extends KeyAdapter{
		//metodos da entrada do teclado
		
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}
	}
	
}
