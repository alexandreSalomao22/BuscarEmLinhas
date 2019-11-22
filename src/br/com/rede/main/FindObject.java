package br.com.rede.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import javax.swing.JOptionPane;

public class FindObject {

	public static void main(String[] args) {

		String linha = "";
		
		
		String path = JOptionPane
				.showInputDialog("COLOQUE O REPOSITORIO ONDE SE ENCONTRA OS ARQUIVOS\n Ex: C:\\logs");
		String arq = JOptionPane.showInputDialog("DIGITE O NOME DO ARQUIVO A SER SALVO");
		String findText = JOptionPane.showInputDialog("DIGITE OQUE DESEJA PROCURAR");
		
		if(path.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Caminho em Branco, Fechando Aplicação");
			System.exit(0);
			
		} if (arq.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Nome do Arquivo em Branco, Fechando Aplicação");
			System.exit(0);
			
		} if (findText.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Palavra a ser Pesquisada em Branco, Fechando Aplicação");
			System.exit(0);
		}
			
		

		try {
			File diretorio = new File("C:\\log_salvo");
			diretorio.mkdir();

			Formatter saida = new Formatter("C:\\log_salvo\\" + arq + ".txt");
			File dirAudios = new File(path);
			File[] arquivos = null;
			arquivos = dirAudios.listFiles();
			for (File arquivo : arquivos) {

				FileReader reader = new FileReader(arquivo.getPath());
				BufferedReader leitor = new BufferedReader(reader);
				while (true) {
					linha = leitor.readLine();
					if (linha == null)
						break;
					if (linha.contains(findText)) {

						saida.format(linha + "\r\n", args);
					}
				}
			}

			saida.close();
			JOptionPane.showMessageDialog(null, "ARQUIVO: " + arq + " SALVO EM: C:\\log_salvo");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(linha);
		}
	}

}