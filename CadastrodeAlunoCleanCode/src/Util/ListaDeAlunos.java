package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Alunos;

public class ListaDeAlunos {

	private static List<Alunos> listaDeAlunos = new ArrayList <Alunos>();
	
	public static List<Alunos> getInstance() {
		return listaDeAlunos;
	}
}
