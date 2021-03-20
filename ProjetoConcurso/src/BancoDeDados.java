import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

	private List<Candidato> candidatos = new ArrayList<Candidato>();

	private List<Prova> provas = new ArrayList<>();

	public BancoDeDados() {
		Estado estado = new Estado("RS");
		Cidade canoas = new Cidade("Canoas", estado);
		String cpfTemp = "00";
		for (int i = 1; i <= 10; i++) {
			salvarCandidato(new Candidato("CANDIDATO" + i, cpfTemp + i));
			double salario = 1000 * i;
			LocalDateTime horaDaProva = LocalDateTime.now().plusDays(i * 10);
			Endereco endereco = new Endereco("RUA" + i, String.valueOf(i), "BAIRRO" + i, "90530310", "NA", canoas);
			adicionarProva(new Prova(i, horaDaProva, endereco, "EMPRESA" + i, 100, salario, "NA"));
		}
	}

	public void salvarCandidato(Candidato candidato) {
		if (this.candidatos.contains(candidato)) {
			System.out.println("O candidato já possui um cadastro");
			return;
		}
		this.candidatos.add(candidato);
	}

	public List<Prova> filtrarProvaPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		List<Prova> provasEncontradas = new ArrayList<Prova>();
		for (Prova provaCadastrada : provas) {
			if (provaCadastrada.getData().isAfter(dataInicial) && provaCadastrada.getData().isBefore(dataFinal)) {
				provasEncontradas.add(provaCadastrada);
			}
		}
		return provasEncontradas;
	}

	public Candidato filtrarCandidato(String cpf) {
		for (Candidato candidatoLoop : candidatos) {
			if (candidatoLoop.getCpf().equals(cpf)) {
				return candidatoLoop;
			}
		}
		return null;
	}

	public List<Prova> filtrarProvaPorVaga(int vagas) {
		List<Prova> provasEncontradas = new ArrayList<Prova>();
		for (Prova nomeDoObjeto : provas) {
			if (nomeDoObjeto.getNumeroVagas() >= vagas) {
				provasEncontradas.add(nomeDoObjeto);
			}
		}
		return provasEncontradas;
	}

	public List<Prova> filtrarProvaPorCidade(String nomeCidade) {
		List<Prova> provasEncontradas = new ArrayList<Prova>();
		for (Prova nomeDoObjeto : provas) {
			if (nomeDoObjeto.getLocal().getCidade().getNome().equals(nomeCidade)) {
				provasEncontradas.add(nomeDoObjeto);
			}
		}
		return provasEncontradas;
	}

	public List<Prova> filtrarProvaPorSalario(double salario) {
		List<Prova> provasEncontradas = new ArrayList<Prova>();
		for (Prova provaLoop : provas) {
			if (provaLoop.getSalarioBase() >= salario) {
				provasEncontradas.add(provaLoop);
			}
		}
		return provasEncontradas;
	}

	public Prova filtrarProva(int id) {
		for (Prova provaLoop : provas) {
			if (provaLoop.getId() == id) {
				return provaLoop;
			}
		}
		return null;
	}

	public void adicionarProva(Prova prova) {
		this.provas.add(prova);
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public List<Prova> getProvas() {
		return provas;
	}

}
