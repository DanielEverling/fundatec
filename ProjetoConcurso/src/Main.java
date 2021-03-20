import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 1 - Cadastrar a prova
		// 2 - Cadastrar um candidato (TODOS OS CANDIDATOS que ja fizeram prova (200 mil candidatos))
		// 3 - Inscrever um candidato para uma determinada prova (50 vagas)
		// 4 - Mostrar concursos com intervalos entre datas
		// Ex.: Os concursos entre 20/01/2020 - 28/01/2020
		// 5 - Mostrar os concursos com salarios maiores que um determinado valor
		// Ex.: O usuário informa R$ 2000,00 e o sistema mostra todos
		// os consursos que estão pagando acima deste valor
		// 6 - Mostrar os concursos de uma determinada cidade
		// Ex.: O usuário informa Porto Alegre e o sistema mostra todos
		// os consursos que são desta cidade
		// 7 - Mostrar os concursos com um determinado numero de vagas
		// 8 - Mostrar todos os concursos
		// 9 - Mostrar todas os candidatos
		// 10 - Sair

		// Informações da prova
		// data (LocalDateTime)
		// local (Endereco)
		// numeroVagas (int);
		// descricao (String)
		// empresa (String);
		// salarioBase (double)

		// Informações do Candidato
		// nome (String);
		// cpf (String)

		Scanner teclado = new Scanner(System.in);
		BancoDeDados objetoMeuBanco = new BancoDeDados();

		String opcao = "S";

		while (opcao.equalsIgnoreCase("S")) {

			System.out.println("Informe uma opcao do menu");
			System.out.println("1 - Cadastrar a prova");
			System.out.println("2 - Cadastrar candidato");
			System.out.println("3 - Inscrever candidato");
			System.out.println("4 - Filtrar prova por periodo");
			System.out.println("5 - Filtrar prova por salario");
			System.out.println("6 - Filtrar prova por cidade");
			System.out.println("7 - Filtrar prova por vagas");
			System.out.println("8 - Todos as provas");
			System.out.println("9 - Todos os candidatos");
			System.out.println("10 - Sair");
			
			int opcaoMenu = teclado.nextInt();

			if (opcaoMenu == 1) {
				System.out.println("Informe o ano da prova");
				int ano = teclado.nextInt();
				System.out.println("Informe o mes da prova");
				int mes = teclado.nextInt();
				System.out.println("Informe o dia da prova");
				int dia = teclado.nextInt();
				System.out.println("Informe o hora da prova");
				int hora = teclado.nextInt();
				System.out.println("Informe o minuto da prova");
				int minuto = teclado.nextInt();
				
				LocalDateTime dataProva = LocalDateTime.of(ano, mes, dia, hora, minuto);
				
				System.out.println("Informe a sigla do estado");
				String siglaDoEstado = teclado.next();
				Estado objetoEstado = new Estado(siglaDoEstado);
				
				System.out.println("Informe a cidade");
				String nomeCidade = teclado.next();
				
				Cidade objetoCidade = new Cidade(nomeCidade, objetoEstado);
				
				System.out.println("Informe a rua");
				String rua = teclado.next();
				
				System.out.println("Informe o numero");
				String numero = teclado.next();
				
				System.out.println("Informe o bairro");
				String bairro = teclado.next();
				
				System.out.println("Informe o cep");
				String cep = teclado.next();
				
				System.out.println("Informe o complemento");
				String complemento = teclado.next();
				
				Endereco objetoEndereco = new Endereco(rua, numero, bairro, cep, complemento, objetoCidade);
				
				System.out.println("Informe a empresa");
				String empresa = teclado.next();
				
				System.out.println("Informe a descricao");
				String descricao = teclado.next();
				
				System.out.println("Informe o numero de vagas");
				int numeroVagas = teclado.nextInt();
				
				System.out.println("Informe o salario base");
				double salarioBase = teclado.nextDouble();
				
				int id = objetoMeuBanco.getProvas().size() + 1;
				Prova objetoProva = new Prova(id, dataProva, objetoEndereco, empresa, numeroVagas, salarioBase, descricao);
			
				objetoMeuBanco.adicionarProva(objetoProva);
				
				
			} else if (opcaoMenu == 2) {
				System.out.println("Informe o nome");
				String nome = teclado.next();
				System.out.println("Informe o CPF");
				String cpf = teclado.next();
				
				Candidato objCandidato = new Candidato(nome, cpf);
				objetoMeuBanco.salvarCandidato(objCandidato);
			} else if (opcaoMenu == 3) {
				System.out.println("Informe o identificador do aluno");
				String cpf = teclado.next();
				
				System.out.println("Informe o idetificador da prova");
				int idDaProva = teclado.nextInt();
			
				// filtrar a lista de candidato e obter o candidato
				
				Candidato candidatoEncontrado = objetoMeuBanco.filtrarCandidato(cpf);
				if (candidatoEncontrado == null) {
					System.out.println("Candidato nao encontrado");
				}
				
				Prova provaEncontrada = objetoMeuBanco.filtrarProva(idDaProva);
				if (provaEncontrada == null) {
					System.out.println("Prova nao encontrada");
				}
				
				if (candidatoEncontrado != null && provaEncontrada != null) {
					provaEncontrada.inscreverCandidato(candidatoEncontrado); 
				}
			} else if (opcaoMenu == 4) {
				System.out.println("Informe o ano da prova");
				int anoInical = teclado.nextInt();
				System.out.println("Informe o mes da prova");
				int mesInical = teclado.nextInt();
				System.out.println("Informe o dia da prova");
				int diaInicial = teclado.nextInt();
				
				System.out.println("Informe o ano da prova");
				int anoFinal = teclado.nextInt();
				System.out.println("Informe o mes da prova");
				int mesFinal = teclado.nextInt();
				System.out.println("Informe o dia da prova");
				int diaFinal = teclado.nextInt();
				
				LocalDateTime dataInicial = LocalDateTime.of(anoInical, mesInical, diaInicial, 0, 0);
				LocalDateTime dataFinal = LocalDateTime.of(anoFinal, mesFinal, diaFinal, 23, 59, 59);
				
				List<Prova> provasEncontradas = objetoMeuBanco.filtrarProvaPorPeriodo(dataInicial, dataFinal);
				
				if (provasEncontradas.isEmpty()) {
					System.out.println("Nenhuma prova encontrada");
				} else {
					for (Prova provaLoop : provasEncontradas) {
						System.out.println(provaLoop.getId());
						System.out.println(provaLoop.getEmpresa());
						System.out.println(provaLoop.getSalarioBase());
						System.out.println(provaLoop.getData());
						System.out.println("-----------------------------");
					}
				}
				
			} else if (opcaoMenu ==  5) {
				System.out.println("Informe um salario para filtro");
				double salario = teclado.nextDouble();
				
				List<Prova> provasEncontradas = objetoMeuBanco.filtrarProvaPorSalario(salario);
				
				if (provasEncontradas.isEmpty()) {
					System.out.println("Nenhuma prova encontrada");
				} else {
					for (Prova provaLoop : provasEncontradas) {
						System.out.println(provaLoop.getId());
						System.out.println(provaLoop.getEmpresa());
						System.out.println(provaLoop.getSalarioBase());
						System.out.println(provaLoop.getData());
						System.out.println("-----------------------------");
					}
				}
				
			} else if (opcaoMenu ==  6) {
				System.out.println("Informe a cidade que deseja pesquisar");
				String bolinhaDeMeuDeus = teclado.next();
				
				List<Prova> provasEncontradas = objetoMeuBanco.filtrarProvaPorCidade(bolinhaDeMeuDeus);
				
				if (provasEncontradas.isEmpty()) {
					System.out.println("Nenhuma prova encontrada");
				} else {
					for (Prova provaLoop : provasEncontradas) {
						System.out.println(provaLoop.getId());
						System.out.println(provaLoop.getEmpresa());
						System.out.println(provaLoop.getSalarioBase());
						System.out.println(provaLoop.getLocal().getRua());
						System.out.println(provaLoop.getLocal().getCep());
						System.out.println(provaLoop.getLocal().getCidade().getNome());
						System.out.println("-----------------------------");
					}
				}
				
			} else if (opcaoMenu ==  7) {
				System.out.println("Informe o numero de vagas que deseja filtrar");
				int vagas = teclado.nextInt();
				
				List<Prova> provasEncontradas = objetoMeuBanco.filtrarProvaPorVaga(vagas);
				
				if (provasEncontradas.isEmpty()) {
					System.out.println("Nenhuma prova encontrada");
				} else {
					for (Prova provaLoop : provasEncontradas) {
						System.out.println(provaLoop.getId());
						System.out.println(provaLoop.getEmpresa());
						System.out.println(provaLoop.getNumeroVagas());
						System.out.println("-----------------------------");
					}
				}
				
			} else if (opcaoMenu ==  8) {
				System.out.println("Todas as provas do sistema");
				for (Prova provaLoop : objetoMeuBanco.getProvas()) {
					System.out.println(provaLoop.getId());
					System.out.println(provaLoop.getEmpresa());
					System.out.println(provaLoop.getDescricao());
					System.out.println(provaLoop.getData());
					System.out.println("-----------------------------");
				}
			} else if (opcaoMenu ==  9) {
				System.out.println("Todas os candidatos do sistema");
				for (Candidato c : objetoMeuBanco.getCandidatos()) {
					System.out.println(c.getNome());
					System.out.println(c.getCpf());
					System.out.println("-----------------------------");
				}
			}
			System.out.println("Deseja continuar");
			opcao = teclado.next();
		}

	}
}
