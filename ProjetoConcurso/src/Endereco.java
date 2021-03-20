
public class Endereco {

	private String rua;
	
	private String numero;
	
	private String bairro;
	
	private String cep;
	
	private String complemento;
	
	private Cidade cidade;

	public Endereco(String rua, String numero, String bairro, String cep, String complemento, Cidade cidade) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}
	
}
