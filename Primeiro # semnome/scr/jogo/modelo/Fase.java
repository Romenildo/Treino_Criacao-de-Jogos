//Fase é tudo aquilo que vai estar na tela
//seja objeto, cenario, tiros, inimigos...


package shottingStar.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Fase extends JPanel implements ActionListener{//ActionListener faz e o que faz a tela atualizar quando a tela move

	private Image fundo;  //variavel da tela de fundo
	private Player player; //variavel do personagem
	private Timer timer;  //###timer
	private List <asteroide1> enemy1;//lista com os inimigos
	private boolean emJogo;
	
	
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
		
		inicializaInimigos();
		emJogo = true;
	}
	
	public void inicializaInimigos() {
		int[] coordenadas = new int[50];//para aumentar dificuldade basta aumentar esse numero
		enemy1 = new ArrayList<asteroide1>();
		
		for (int i = 0; i < coordenadas.length; i++) {
			int x = (int)(Math.random()*8000+1024);//inimigos aparecem em largura diferentes
			int y = (int)(Math.random()*650+30);//inimigos aparecem em altura diferente
			enemy1.add(new asteroide1(x,y));
		}
	}
	
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		
		if(emJogo == true) 
		{
			
			graficos.drawImage(fundo, 0, 0, null);//imagem/x/y/posicao null = meio
			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);//onde a nave vai aparecer os valores getx e gety vem do objeto na outra classe por isso o getter

			List<Tiro>tiros = player.getTiros();//pega a lista de tiros e coloca na tela
			for(int i =0; i < tiros.size();i++) 
			{
				Tiro m = tiros.get(i);
				m.load();
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
					
			}
			for (int o = 0; o < enemy1.size(); o++) 
			{
				asteroide1 in = enemy1.get(o);// in = variavel do nome do inimigo
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}	
		}else {
			ImageIcon fimDeJogo = new ImageIcon("res\\fimDojogo.png");
			graficos.drawImage(fimDeJogo.getImage(), 0, 0, null);
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
		
		for (int o = 0; o < enemy1.size(); o++) 
		{
			asteroide1 in = enemy1.get(o);// in = variavel do nome do inimigo
			if(in.isVisivel()) {
				in.update();//ele vai andar se estivel visivel
			}else {
				enemy1.remove(o);
			}
		}
		
		checarColisao();
		repaint();// nao ficar a imagem anterior
		
		
	}
	
	public void checarColisao() {
		Rectangle formaNave = player.getBounds();//cria um retangulo do tamanho da nave
		Rectangle formaEnemy1;
		Rectangle formaTiro;
		
		for (int i = 0; i < enemy1.size(); i++) 
		{  //pega todos os inimigos que irao aparecer
			asteroide1 tempEnemy1 = enemy1.get(i);
			formaEnemy1 = tempEnemy1.getBounds();
			if(formaNave.intersects(formaEnemy1)) {
				player.setVisible(false);
				tempEnemy1.setVisivel(false);
				emJogo = false;
			}
		}
		
		List<Tiro> tiros = player.getTiros();
		
		for (int j = 0; j < tiros.size(); j++) 
		{
			Tiro tempTiro = tiros.get(j);    //cria uma retangulo para cada tiro
			formaTiro = tempTiro.getBounds();//pega o retangulo da vez e adiciona na forma
			for (int o = 0; o < enemy1.size(); o++) 
			{
				asteroide1 tempEnemy1 = enemy1.get(o);//cria um retangulo para cada inimigo
				formaEnemy1 = tempEnemy1.getBounds();
				if(formaTiro.intersects(formaEnemy1)) {
					tempEnemy1.setVisivel(false);
					tempTiro.setVisivel(false);
				}
			}
		}
		
		
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
