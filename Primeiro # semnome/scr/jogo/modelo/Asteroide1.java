package shottingStar.modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class asteroide1 {
	
	private Image imagem;
	private int x,y; //posicao do tiro
	private int largura , altura;//largura e altura do tiro
	private boolean isVisivel; //quando ele chegar no final da tela ele sumir
	
	//private static final int LARGURA = 938; //posicao maxima da tela//onde os tiro irao sumir
	private static int VELOCIDADE = 3; //velocidade do inimigo
	
	public asteroide1(int x, int y) {//pega a posicao do player de onde ira sair o tiro
		this.x = x; //this do tiro vai ser igual ao x do jogador;
		this.y = y;
		isVisivel = true;
	}
	
	public void load() {
		ImageIcon referencia = new ImageIcon("res\\asteroideRemodeled.png");//imagem do tiro
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);//tamanho de colisao da bala
		this.altura = imagem.getHeight(null);
		
		
	}
	
	public void update() {
		this.x -= VELOCIDADE;
			//if(this.x > LARGURA)
				//isVisivel = false;//caso o tiro passe a largura que é a posicao final da tela ele sumira
	}
	
	
	
	
	public Rectangle getBounds() {//cria um retangulo da area de colisao do objeto
		return new Rectangle (x,y,largura,altura);
	}
	

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}
	
	

	
	
}
