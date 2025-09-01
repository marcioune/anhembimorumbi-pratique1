package anhembimorumbi_pratique1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Usuario {
	private String nome;
	private String cpf;
	private String email;

	public Usuario(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void exibirUsuario() {
		System.out.println("--------------------");
		System.out.println("| Dados do usuário |");
		System.out.println("--------------------");
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
		System.out.println("E-mail: " + email);
		System.out.println("\n");
	}
}

class Evento {
	private String nome;
	private String endereco;
	private String cidade;
	private String estado;
	private String categoria;
	private String horario;
	private String descricao;
	private String usuario;

	public Evento(String nome, String endereco, String cidade, String estado, String categoria, String horario, String descricao, String usuario) {
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.categoria = categoria;
		this.horario = horario;
		this.descricao = descricao;
		this.usuario = usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void exibirEvento() {
		System.out.println("----------------------");
		System.out.println("| Detalhes do Evento |");
		System.out.println("----------------------");
		System.out.println("Nome: " + nome);
		System.out.println("Endereço: " + endereco);
		System.out.println("Cidade: " + cidade);
		System.out.println("Estado: " + estado);
		System.out.println("Categoria: " + categoria);
		System.out.println("Horário: " + horario);
		System.out.println("Descrição: " + descricao);
		System.out.println("Usuário: " + usuario);
	}
}

public class AnhembiMorumbiPratique1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Usuario usuario = null;
        Evento evento = null;

        while (true) {
        	System.out.println("--------------------------------------------------------------------");
			System.out.println("| Cadastro de usuário, cadatro de eventos e notificação de eventos |");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Selecione a opção desejada:");
			System.out.println("1 - Cadastrar usuário");
			System.out.println("2 - Cadastrar evento");
			System.out.println("3 - Listar o usuário");
			System.out.println("4 - Listar o evento");
			System.out.println("5 - Participar do evento");
			System.out.println("0 - Sair");
			System.out.println("--------------------------------------------------------------------");
            System.out.println("Escolha uma opção: ");
            System.out.println("--------------------------------------------------------------------");

            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> {
                	usuario = cadastrarUsuario(sc);
                }
                case 2 -> {
                	evento = cadastrarEvento(sc);
                }
                case 3 -> {
                	if (usuario == null) {
                		System.out.println("Cadastre o usuário primeiro através da opção 1!\n");
                	}
                	else {
                		usuario.exibirUsuario();
                	}
                }
                case 4 -> {
                	if (evento == null) {
                		System.out.println("Cadastre o evento primeiro através da opção 2!\n");
                	}
                	else {
                		evento.exibirEvento();
                	}
                }
                case 5 -> {
                	ParticiparEvento(evento, usuario.getNome());
                }
                case 0 -> {
                	System.out.println("Sistema encerrado com sucesso!");
                    return;
                }
                default -> {
                	System.out.println("Opção inválida, por favor, tente novamente...");
                }
            }
        }
    }

	private static Usuario cadastrarUsuario(Scanner sc) {
		System.out.println("-----------------------");
		System.out.println("| Cadastro de usuário |");
		System.out.println("-----------------------");

		System.out.print("Digite o nome: ");
		String nome = sc.nextLine();

		System.out.print("Digite o CPF: ");
		String cpf = sc.nextLine();

		System.out.print("Digite o e-mail: ");
		String email = sc.nextLine();

		Usuario usuario = new Usuario(nome, cpf, email);
		System.out.println("Usuário cadastrado com sucesso!\n");

		return usuario;
	}
	
	private static Evento cadastrarEvento(Scanner sc) {
		System.out.println("----------------------");
		System.out.println("| Cadastro de evento |");
		System.out.println("----------------------");
		
		System.out.print("Digite o nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Digite o endereço: ");
		String endereco = sc.nextLine();
		
		System.out.print("Digite a cidade: ");
		String cidade = sc.nextLine();
		
		System.out.print("Digite o estado: ");
		String estado = sc.nextLine();
		
		String categoria = "";
		boolean digitarCategoria = true;
		Set<String> categoriasValidas = new HashSet<>(Arrays.asList(
		    "festa", "evento esportivo", "show", "curso", "palestra"
		));

		while (digitarCategoria) {
			System.out.print("Digite a categoria:\n");
			System.out.print("(Categorias aceitas: festa, evento esportivo, show, curso, palestra)\n");
			categoria = sc.nextLine().toLowerCase();
			
			if (categoriasValidas.contains(categoria)) {
				digitarCategoria = false;				
			}
			else
			{
				System.out.print("Categoria inválida, por favor, tente novamente...");
			}
		}
		
		System.out.print("Digite o horario: ");
		String horario = sc.nextLine();
		
		System.out.print("Digite a descrição: ");
		String descricao = sc.nextLine();
		
		Evento evento = new Evento(nome, endereco, cidade, estado, categoria, horario, descricao, null);
		System.out.println("Evento cadastrado com sucesso!\n");

		return evento;
	}
	
	private static void ParticiparEvento(Evento evento, String usuario) {
		evento.setUsuario(usuario);
		System.out.println("Participação no evento efetuado com sucesso!\n");
	}
}