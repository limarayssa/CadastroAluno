package BancoDeDados;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.List;

import Modelos.Alunos;
import Util.ListaDeAlunos;

public class ManipulacaoArquivoTXT {
	
	private static String nomeDoArquivo = "Cadastro de aluno.txt";

	public static void SalvarArquivoTXT () throws IOException{

		try (BufferedWriter buffer = new BufferedWriter (new FileWriter(nomeDoArquivo));
				PrintWriter pw = new PrintWriter (buffer)){
			for(Alunos a: ListaDeAlunos.getInstance())
				pw.println(a);
		}
	}
	

	public static void LerArquivoTXT () throws FileNotFoundException, IOException{
		
		try(FileWriter arq = new FileWriter(nomeDoArquivo, true)) {};
		
		String line = "";

		try(BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo))) {

			while((line = reader.readLine())!= null && !"".equals(line)) {			
					Alunos aluno = new Alunos(line);
					ListaDeAlunos.getInstance().add(aluno);
			}
		}

	}
}
