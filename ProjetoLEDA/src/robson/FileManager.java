package robson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

/**
 * Gerenciador de Arquivos e Diretorios
 * @author Robson Martins
 */
public class FileManager {

	/* mensagens de texto diversas */
	private final String MSG_TITLE       = "Gerenciador de Arquivos e Diretorios";
	private final String MSG_AUTHOR      = "by Robson Martins (42055) - 16SCJ";
	private final String MSG_HELP_INFO   = "Digite help <enter> para ajuda.";
	private final String MSG_PROMPT      = "> ";
	private final String MSG_QUIT        = "Bye!";
	private final String MSG_VI_WELCOME  = "Editor de Textos. Digite \":q\" para sair.";

	/* mensagens de status e erro */
	private final String MSG_CMD_SUCCESS          = "Comando executado com sucesso";
	private final String MSG_CMD_INVALID          = "Comando invalido";
	private final String MSG_ARG_NUM_ERROR        = "Numero invalido de argumentos";
	private final String MSG_ERROR_CONSOLE_IN     = "Erro de leitura no console";
	private final String MSG_ERROR_MKDIR          = "Erro ao criar diretorio";
	private final String MSG_ERROR_DEL            = "Erro ao apagar arquivo";
	private final String MSG_ERROR_DENY           = "Acesso negado";
	private final String MSG_ERROR_FILE_NOT_FOUND = "Arquivo nao encontrado";
	private final String MSG_ERROR_FILE_IO        = "Erro de entrada/saida no arquivo";
	private final String MSG_EMPTY_DIR            = "Diretorio vazio";

	/* mensagens de help */
	private final String HELP_TEXT_TITLE = "Comandos disponiveis:";
	private final String HELP_TEXT_HELP  = "help - Exibe ajuda sobre os comandos disponiveis";
	private final String HELP_TEXT_QUIT  = "quit - Sai do Programa";
	private final String HELP_TEXT_MKDIR = "mkdir <path> - Cria o diretorio especificado pelo argumento \"path\"";
	private final String HELP_TEXT_DIR   = "dir <path> - Lista o conteudo do diretorio especificado pelo argumento \"path\"";
	private final String HELP_TEXT_DEL   = "del <file> - Remove o arquivo especificado pelo argumento \"file\"";
	private final String HELP_TEXT_COPY  = "copy <src> <dest> - Copia o arquivo especificado pelo argumento \"src\" para o arquivo especificado por \"dest\"";
	private final String HELP_TEXT_TYPE  = "type <file> - Exibe o conteudo do arquivo texto especificado pelo argumento \"file\"";
	private final String HELP_TEXT_VI    = "vi <file> - Cria um novo arquivo texto para edicao e salva como \"file\"";
	
	/* comandos disponiveis */
	private final String CMD_HELP  = "help";
	private final String CMD_QUIT  = "quit";
	private final String CMD_MKDIR = "mkdir";
	private final String CMD_DIR   = "dir";
	private final String CMD_DEL   = "del";
	private final String CMD_COPY  = "copy";
	private final String CMD_TYPE  = "type";
	private final String CMD_VI    = "vi";
	
	/**
	 * Ponto de entrada principal do Sistema.
	 * Cria um objeto do tipo {@link FileManager} e executa o metodo
	 * executaConsole(), que inicia o interpretador de comandos do
	 * Gerenciador de Arquivos e Diretorios.
	 * @param args Lista de argumentos passados pela linha de comando da JVM
	 */
	public static void main(String[] args) {
		
		FileManager fileManager = new FileManager();
		fileManager.executaConsole();
	}
	
	/**
	 * Inicia o interpretador de comandos do Gerenciador de Arquivos e
	 * Diretorios. 
	 */
	public void executaConsole() {

		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String linha = "";
				
		System.out.println(MSG_TITLE);
		System.out.println(MSG_AUTHOR);
		System.out.println(MSG_HELP_INFO);
		
		do {
			try {
				System.out.print(MSG_PROMPT);
				linha = bufferedReader.readLine();
				analisaComando(linha);
				
			} catch (IOException e) {
				System.out.println(MSG_ERROR_CONSOLE_IN);
				break;
			}
		} while (!linha.trim().equalsIgnoreCase(CMD_QUIT));

		System.out.println(MSG_QUIT);
	}
	
	/**
	 * Analisa qual o comando presente na string passada como parametro e
	 * executa o comando correspondente.
	 * @param linha String que pode conter um comando seguido de seus argumentos
	 */
	private void analisaComando(String linha) {

		String[] args = linha.trim().split(" ");
		
		if (args.length == 0 || args[0].length() == 0) {
			/* entrou uma linha em branco */
			return;
			
		} else if (args[0].equalsIgnoreCase(CMD_HELP)) {
			helpExecute();
			
		} else if (args[0].equalsIgnoreCase(CMD_QUIT)) {
			/* nao faz nada aqui, o comando quit e' tratado pelo
			 * metodo executaConsole() */
			
		} else if (args[0].equalsIgnoreCase(CMD_MKDIR)) {
			if (args.length < 2) {
				System.out.println(MSG_ARG_NUM_ERROR);
				System.out.println("Uso: " + HELP_TEXT_MKDIR);
			} else {
				mkdirExecute(args[1]);
			}
			
		} else if (args[0].equalsIgnoreCase(CMD_DIR)) {
			if (args.length < 2) {
				System.out.println(MSG_ARG_NUM_ERROR);
				System.out.println("Uso: " + HELP_TEXT_DIR);
			} else {
				dirExecute(args[1]);
			}
			
		} else if (args[0].equalsIgnoreCase(CMD_DEL)) {
			if (args.length < 2) {
				System.out.println(MSG_ARG_NUM_ERROR);
				System.out.println("Uso: " + HELP_TEXT_DEL);
			} else {
				delExecute(args[1]);
			}
			
		} else if (args[0].equalsIgnoreCase(CMD_COPY)) {
			if (args.length < 3) {
				System.out.println(MSG_ARG_NUM_ERROR);
				System.out.println("Uso: " + HELP_TEXT_COPY);
			} else {
				copyExecute(args[1],args[2]);
			}
			
		} else if (args[0].equalsIgnoreCase(CMD_TYPE)) {
			if (args.length < 2) {
				System.out.println(MSG_ARG_NUM_ERROR);
				System.out.println("Uso: " + HELP_TEXT_TYPE);
			} else {
				typeExecute(args[1]);
			}
			
		} else if (args[0].equalsIgnoreCase(CMD_VI)) {
			if (args.length < 2) {
				System.out.println(MSG_ARG_NUM_ERROR);
				System.out.println("Uso: " + HELP_TEXT_VI);
			} else {
				viExecute(args[1]);
			}
			
		} else {
			System.out.println(MSG_CMD_INVALID);
			System.out.println(MSG_HELP_INFO);
		}
	}
	
	/**
	 * Exibe uma mensagem de ajuda (help), listando os comandos suportados.
	 */
	private void helpExecute() {
		System.out.println(MSG_TITLE);
		System.out.println(MSG_AUTHOR);
		System.out.println(HELP_TEXT_TITLE);
		System.out.println(HELP_TEXT_HELP);
		System.out.println(HELP_TEXT_QUIT);
		System.out.println(HELP_TEXT_MKDIR);
		System.out.println(HELP_TEXT_DIR);
		System.out.println(HELP_TEXT_DEL);
		System.out.println(HELP_TEXT_COPY);
		System.out.println(HELP_TEXT_TYPE);
		System.out.println(HELP_TEXT_VI);
	}
	
	/**
	 * Cria um diretorio, cujo nome e' especificado pelo parametro <i>path</i>.
	 * @param path Caminho do diretorio a ser criado
	 */
	private void mkdirExecute(String path) {
		
		File file = new File(path);

		try {
			if (file.mkdir()) {
				System.out.println(MSG_CMD_SUCCESS);
			} else {
				System.out.println(MSG_ERROR_MKDIR);
			}
		} catch (SecurityException e) {
			System.out.println(MSG_ERROR_DENY);
		}
	}
	
	/**
	 * Lista o conteudo do diretorio especificado pelo parametro <i>path</i>.
	 * Primeiro os diretorios, depois os arquivos, listados em ordem alfabetica.
	 * @param path Caminho do diretorio a ser listado
	 */
	private void dirExecute(String path) {

		File file = new File(path);
		String[] rawFileList = null;
		TreeSet<String> dirList  = new TreeSet<String>();
		TreeSet<String> fileList = new TreeSet<String>();
		
		try {
			rawFileList = file.list();
		} catch (SecurityException e) {
			System.out.println(MSG_ERROR_DENY);
			return;
		}
		
		if (rawFileList == null || rawFileList.length == 0) {
			System.out.println(MSG_EMPTY_DIR);
			return;
		}
		
		for (String item : rawFileList) {
			file = new File(path + File.separator + item);
			if (file.isDirectory()) {
				dirList.add("{" + item + "}");
			} else {
				fileList.add(item);
			}
		}
		
		for (String item : dirList) {
			System.out.println(item);
		}
		for (String item : fileList) {
			System.out.println(item);
		}
	}
	
	/**
	 * Remove o arquivo especificado pelo parametro <i>filename</i>.
	 * @param filename Nome do arquivo a ser removido
	 */
	private void delExecute(String filename) {
		
		File file = new File(filename);

		try {
			if (file.delete()) {
				System.out.println(MSG_CMD_SUCCESS);
			} else {
				System.out.println(MSG_ERROR_DEL);
			}
		} catch (SecurityException e) {
			System.out.println(MSG_ERROR_DENY);
		}
	}
	
	/**
	 * Copia um arquivo origem para um arquivo destino.
	 * @param origem Caminho completo do arquivo origem
	 * @param destino Caminho completo do arquivo destino
	 */
	private void copyExecute(String origem, String destino) {
		
		try {
			File srcFile = new File(origem);
			File dstFile = new File(destino);

			FileInputStream srcFileInStream = new FileInputStream(srcFile);
			FileOutputStream dstFileOutStream = new FileOutputStream(dstFile);

			byte [] buffer = new byte[4096];
			
			int lido = 0;
			do {
				lido = srcFileInStream.read(buffer);
				if (lido > 0) {
					dstFileOutStream.write(buffer,0,lido);
				}
			} while (lido > 0);

			srcFileInStream.close();
			dstFileOutStream.close();
			System.out.println(MSG_CMD_SUCCESS);
			
		} catch (FileNotFoundException e) {
			System.out.println(MSG_ERROR_FILE_NOT_FOUND);
			
		} catch (IOException e) {
			System.out.println(MSG_ERROR_FILE_IO);
		}
	}
	
	/**
	 * Exibe o conteudo de um arquivo texto especificado pelo
	 * parametro <i>filename</i>.
	 * @param filename Nome do arquivo a ser exibido
	 */
	private void typeExecute(String filename) {
		
		try {
			FileReader file = new FileReader(filename);
			BufferedReader bufReader = new BufferedReader(file);
			String linha = "";

			do {
				linha = bufReader.readLine();
				if (linha != null) {
					System.out.println(linha);
				}
			} while (linha != null);

			bufReader.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(MSG_ERROR_FILE_NOT_FOUND);
			
		} catch (IOException e) {
			System.out.println(MSG_ERROR_FILE_IO);
		}
	}

	/**
	 * Cria um novo arquivo texto para edicao e salva com o nome especificado
	 * pelo parametro <i>filename</i>.
	 * @param filename Nome do arquivo a ser salvo
	 */
	private void viExecute(String filename) {

		System.out.println(MSG_VI_WELCOME);
		
		try {
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader bufReader = new BufferedReader(reader);

			FileWriter file = new FileWriter(filename);
			PrintWriter printWriter = new PrintWriter(file);
			
			boolean comandoParaSair = false;
			String linha = "";
		
			do {
				linha = bufReader.readLine();
				if (linha == null) {
					break;
				}

				comandoParaSair = (linha.trim().equalsIgnoreCase(":q"));

				if (!comandoParaSair) {
					printWriter.println(linha);
				}
				
			} while (!comandoParaSair);

			printWriter.close();
			file.close();
			System.out.println(MSG_CMD_SUCCESS);

		} catch (FileNotFoundException e) {
			System.out.println(MSG_ERROR_FILE_NOT_FOUND);
			
		} catch (IOException e) {
			System.out.println(MSG_ERROR_FILE_IO);
		}
	}
	
}
