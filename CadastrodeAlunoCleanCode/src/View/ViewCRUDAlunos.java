package View;

import java.io.BufferedReader;
import java.io.IOException;
//import java.util.List;

import Modelos.Alunos;
import Util.ListaDeAlunos;

public class ViewCRUDAlunos {

	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException {
		System.out.println("\nMenu"
				+ "\n1- Cadastro de alunos"
				+ "\n2- Listar alunos"
				+ "\n3- Deletar alunos"
				+ "\n4- Editar alunos"
				+ "\n5- Sair");
		
		return Integer.parseInt(reader.readLine());
	}

	public static String[] ViewMenuSalvarAluno (BufferedReader reader) throws IOException{
		
		String[] menuAluno = {"Nome do Aluno: ", "CPF: ", "Curso: ", "Rua: ",
		"Número: ", "Bairro: ", "Cidade: ", "Estado: ", "CEP: "};
		String[] dadosAluno = {"","","","","","","","",""};
		
		for(int i = 0; i< dadosAluno.length; i++) {
			System.out.println(menuAluno[i]);
			dadosAluno[i] = reader.readLine();
		}
	
		return dadosAluno;
	}

	public static int ViewMenuEditarOuDeletarAluno (String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException {
		
		for (int i = 0; i  <ListaDeAlunos.getInstance().size(); i++)

			System.out.println(i + " - " + ListaDeAlunos.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o índice do aluno que deseja " + editar_deletar);		
		
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewOpcaoEdicao (BufferedReader reader) throws NumberFormatException, IOException {
	String[] dadosEditados = {"", ""};
	
	System.out.println("\nEscolha o atributo que deseja alterar: ");
	System.out.println("\n1 - Nome"
			+ "\n2 - CPF"
			+ "\n3 - Curso"
			+ "\n4 - Rua"
			+ "\n5 - Número"
			+ "\n6 - Bairro"
			+ "\n7 - Cidade"
			+ "\n8 - Estado");
	
	dadosEditados [0] = reader.readLine();
	System.out.printf("Escreva o valor do novo atributo: ");
	dadosEditados [1] = reader.readLine();
	
		return dadosEditados;
	}
	
	public static void ViewListaDeAlunosEditada () {
		for (Alunos a : ListaDeAlunos.getInstance()) {
		System.out.println("\n-------- Dados do Aluno --------");
		System.out.println("Nome: " + a.getNome());
		System.out.println("CPF: " + a.getCpf());
		System.out.println("Curso: " + a.getCurso());
		System.out.println("Rua: " + a.getEndereco().getRua());
		System.out.println("Número: " + a.getEndereco().getNum());
		System.out.println("Bairro: " + a.getEndereco().getBairro());
		System.out.println("Cidade: " + a.getEndereco().getCidade());
		System.out.println("Estado: " + a.getEndereco().getEstado());
		System.out.println("---------------------------------\n");
		}
	}
	
	public static void msgFinal (int op) {
		String[] msgFinal = {"Cadastro realizado com sucesso!", "Aluno editado com sucesso!", "Aluno deletado com sucesso", "Obrigada por usar nosso sistema!"};
		System.out.println(msgFinal[op]);
	}
	
}
