
//container é todo o nosso terreno
//a fase deve estar dentro do terreno

package shottingStar;


import javax.swing.JFrame;
import shottingStar.modelo.Fase;


public class Container extends JFrame{
	
	public Container() {
		add(new Fase());
		
		setTitle("ShotingStar");                            //nome da janela
		setSize(1024,728);                                  //tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //quando clicar em fechar ele fecha
		setLocationRelativeTo(null);                        //ponto na tela de onde aparecera null= meio
		this.setResizable(false);                           // nao poder colocar em tela grande
		setVisible(true);                                   //fazer com que a tela fique visivel
	}
	
	
	public static void main(String[] args) {
		new Container();
	}
	
}
