package BancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
//import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerAlunos;
import Modelos.Alunos;
import Util.ListaDeAlunos;


public class ManipulacaoArquivoXML {
	
	private static String nomeDoArquivo = "Cadastro de Aluno.xml";

	public static void SalvarArquivoXML () throws ParserConfigurationException, FileNotFoundException, IOException, TransformerException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Element alunosTag = doc.createElement("Alunos");
		doc.appendChild(alunosTag);
		
		for (Alunos a: ListaDeAlunos.getInstance()) {
			
			Element alunoTag = doc.createElement("aluno");
			alunoTag.setAttribute("id", "1");
			alunosTag.appendChild(alunoTag);
			
			Element nomeTag = doc.createElement("Nome");
			nomeTag.setTextContent(a.getNome());
			alunoTag.appendChild(nomeTag);
			
			Element cpfTag = doc.createElement("CPF");
			cpfTag.setTextContent(String.valueOf(a.getCpf()));
			alunoTag.appendChild(cpfTag);
			
			Element cursoTag = doc.createElement("Curso");
			cursoTag.setTextContent(a.getCurso());
			alunoTag.appendChild(cursoTag);
		
			Element enderecoTag = doc.createElement("Endereço");
			alunoTag.appendChild(enderecoTag);
			
				Element ruaTag = doc.createElement("Rua");
				ruaTag.setTextContent(a.getEndereco().getRua());
				enderecoTag.appendChild(ruaTag);
				
				Element numTag = doc.createElement("Número");
				numTag.setTextContent(String.valueOf(a.getEndereco().getNum()));
				enderecoTag.appendChild(numTag);
				
				Element bairroTag = doc.createElement("Bairro");
				bairroTag.setTextContent(a.getEndereco().getBairro());
				enderecoTag.appendChild(bairroTag);
				
				Element cidadeTag = doc.createElement("Cidade");
				cidadeTag.setTextContent(a.getEndereco().getCidade());
				enderecoTag.appendChild(cidadeTag);
				
				Element estadoTag = doc.createElement("Estado");
				estadoTag.setTextContent(a.getEndereco().getEstado());
				enderecoTag.appendChild(estadoTag);
		}
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		
		trans.setOutputProperty( OutputKeys.INDENT , "yes");
		trans.setOutputProperty("{http://xml.apache.org/xlst}indent-amount", "4");
		
		
		DOMSource source = new DOMSource(doc);
		
		try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo), "UTF-8")) {
		
			StreamResult result = new StreamResult(osw);
			trans.transform(source, result);
			
		}
	}
	
	public static void LerArquivoXML () throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		SAXParser parser = spf.newSAXParser();
		
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo), "UTF-8")) {
			
			InputSource source =  new InputSource(isr);
			XMLHandlerAlunos handler  = new XMLHandlerAlunos();
			
			parser.parse(source, handler);
		}
	}
}
