package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entidades.EntradaLog;

public class Programa {

	public static void main(String[] args) {

		// Scanner sc= new Scanner (System.in);
		System.out.println("Informe o caminho completo do arquivo: ");
		// c:\temp\log.txt
		// String caminho=sc.nextLine();
		// \ antes da \ para a \ ser interpretada como caractere
		String caminho = "c:\\temp\\log.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

			// list aceita elementos repetidos, seria um estrutura de dados adequada ser
			// quiser
			// ver todos os logs
			List<EntradaLog> listaLogs = new ArrayList<EntradaLog>();
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(" ");
				String userName = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				listaLogs.add(new EntradaLog(userName, moment));
				line = br.readLine();
			}

			// ordeando lista por nome
			Collections.sort(listaLogs);

			System.out.println("\nImprimindo o log completo");
			int i = 1;
			for (EntradaLog nickname : listaLogs) {
				System.out.println(i + "." + nickname);
				i++;
			}

			System.out.println("Tamanho de registros de Log de Usuários: " + listaLogs.size());

		} catch (IOException error) {
			System.out.println("Error: " + error.getMessage());
		}

		// sc.close();

	}

}
