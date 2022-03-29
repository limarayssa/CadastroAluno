package Aplicacao;

import java.io.BufferedReader; //Importação da classe do leitor 
import java.io.IOException;//Importação da exceção para try catch
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import View.ViewCRUDAlunos;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {

		//Construtor da classe BufferedReader (leitor)
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		CRUDAluno.ListarAlunos(1);

		int menu = 0; //Inicialização da variável pro menu
		while (menu != 5) {

			menu = ViewCRUDAlunos.ViewMenuPrincipal(reader);

			switch(menu) { //switch do menu

			case 1:
				CRUDAluno.SalvarAluno(reader);
				ViewCRUDAlunos.msgFinal(0);
				break;


			case 2:
				CRUDAluno.ListarAlunos(0);
				break;

			case 3:
				CRUDAluno.DeletarAluno(reader);
				ViewCRUDAlunos.msgFinal(1);
				break;

			case 4:
				CRUDAluno.EditarAluno(reader);
				ViewCRUDAlunos.msgFinal(2);
				break;

			case 5:
				ViewCRUDAlunos.msgFinal(3);
				break;
			}
		}


	}
}
