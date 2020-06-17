//tudo relacionado ao personagem

package shottingStar.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
	
	private int x,y;  //mover persongaem
	private int dx, dy;
	private Image imagem;  //sprite do persongaem
	private int altura, largura; //colisao
	
	private List<Tiro> tiros;//lista que aloca infinitos tiros
	
	public Player() {
		//Construtor ja deixa padrao
		this.x = 100;
		this.y = 100;  //local da tela onde o personagem aparece
		
		tiros = new ArrayList<Tiro>();

	}
	
	public void load() {
		//carregar sprite do personagem e o tamanho dele
		ImageIcon referencia = new ImageIcon("res\\player.png");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
	}
	
	public void update() {
		//mover personagem
		x += dx;
		y += dy;
	}
	
	public void tiroSimples() {
		this.tiros.add(new Tiro(x+10, y));//tiro aparecer exatamento no meio da nave
	}
	
	public void keyPressed(KeyEvent tecla) {
		//ler as teclas digitadas
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_Z)   //tecla para atira caso precione z ele ativa o metodo do tiro
			tiroSimples();
		if(codigo == KeyEvent.VK_UP)//quando precionado para cima o dy soma +3 com a posicao fazendo ele andar mais 3 casas
			dy =-3;
		if(codigo == KeyEvent.VK_DOWN)
			dy =3;
		if(codigo == KeyEvent.VK_LEFT)
			dx =-3;
		if(codigo == KeyEvent.VK_RIGHT)
			dx =3;
	}
	
	public void keyRelease(KeyEvent tecla) {
		//para o personagem parar caso fique sem apertar
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_UP)
			dy =0;
		if(codigo == KeyEvent.VK_DOWN)
			dy =0;
		if(codigo == KeyEvent.VK_LEFT)
			dx =0;
		if(codigo == KeyEvent.VK_RIGHT)
			dx =0;
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

	public List<Tiro> getTiros() {
		return tiros;
	}
	
	
	

}
