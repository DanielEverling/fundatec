import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Prova {

	private int id;
	
	private LocalDateTime data;
	
	private Endereco local;
	
	private String empresa;
	
	private int numeroVagas;
	
	private double salarioBase;
	
	private String descricao;
	
	private List<Candidato> candidatos = new ArrayList<>();
	
	public Prova(int id, LocalDateTime data, Endereco local, String empresa, int numeroVagas, double salarioBase, String descricao) {
		this.id = id;
		this.data = data;
		this.local = local;
		this.empresa = empresa;
		this.numeroVagas = numeroVagas;
		this.salarioBase = salarioBase;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}
	
	public LocalDateTime getData() {
		return data;
	}

	public Endereco getLocal() {
		return local;
	}

	public String getEmpresa() {
		return empresa;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public List<Candidato> getCandidatos() {
		return candidatos;
	}
	
	public void inscreverCandidato(Candidato candidato) {
		boolean candidatoInscrito = validarInscricaoCandidato(candidato);
		if (candidatoInscrito) {
			System.out.println("O candidato ja está inscrito para essa prova");
			return;
		}
		this.candidatos.add(candidato);
	}
	
	private boolean validarInscricaoCandidato(Candidato candidatoParaInscricao) {
		for(Candidato candidatoInscrito : candidatos) {
			if (candidatoInscrito.getCpf().equals(candidatoParaInscricao.getCpf())) {
				return true;
			}
		}
		return false;
	}

	
	
	
}
