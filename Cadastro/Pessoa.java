
public class Pessoa {
	
	private String login;
	private String senha;
	
	public Pessoa() {
		login = "o";
	}
	
	
	public void setLogin(String login) {
		 this.login = login;
	}
	
	public void setSenha(String senha) {
		 this.senha= senha;
	}
	
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
}
