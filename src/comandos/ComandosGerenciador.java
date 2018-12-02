package comandos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import arvore.BST;
import listasEncadeadas.ListaEncadeadaPasta;
import nos.TreeNode;

public class ComandosGerenciador{
	
	private BST tree;
	private TreeNode treeNodeAtual;
	private String caminho;
	
	/* mensagens de texto diversas */
	private final String MSG_TITLE       = "Gerenciador de Arquivos e Diretorios";
	private final String MSG_AUTHOR      = "by Arthur Almeida e Mayara Medeiros";
	private final String MSG_HELP_INFO   = "Digite help <enter> para ajuda.";
	private final String MSG_PROMPT      = "> ";
	private final String MSG_QUIT        = "Bye!";

	/* mensagens de status e erro */
	private final String MSG_CMD_SUCCESS          = "Comando executado com sucesso";
	private final String MSG_CMD_INVALID          = "Comando invalido";
	private final String MSG_ARG_NUM_ERROR        = "Numero invalido de argumentos";
	private final String MSG_ERROR_MKDIR          = "Erro ao criar diretorio";
	private final String MSG_ERROR_VI             = "Erro ao criar arquivo";
	private final String MSG_ERROR_DEL            = "Erro ao apagar arquivo";
	private final String MSG_ERROR_DIRDEL         = "Erro ao apagar diretorio";
	private final String MSG_ERROR_DENY           = "Acesso negado";
	private final String MSG_ERROR_FILE_NOT_FOUND = "Arquivo nao encontrado";
	private final String MSG_ERROR_PATH_NOT_FOUND = "Pasta nao encontrada";
	private final String MSG_ERROR_FILE_IO        = "Erro de entrada/saida no arquivo";
	private final String MSG_EMPTY_DIR            = "Diretorio vazio";

	/* mensagens de help */
	private final String HELP_TEXT_TITLE 	= "Comandos disponiveis:";
	private final String HELP_TEXT_HELP  	= "help - Exibe ajuda sobre os comandos disponiveis";
	private final String HELP_TEXT_QUIT  	= "quit - Sai do Programa";
	private final String HELP_TEXT_MKDIR 	= "mkdir <path> - Cria o diretorio especificado pelo argumento \"path\"";
	private final String HELP_TEXT_DIR   	= "dir <path> - Lista o conteudo do diretorio especificado pelo argumento \"path\"";
	private final String HELP_TEXT_DIRDEL	= "dirdel - Remove o diretorio que o usuario estah \"path\"";
	private final String HELP_TEXT_DEL   	= "del <file> - Remove o arquivo especificado pelo argumento \"file\"";
	private final String HELP_TEXT_VI    	= "vi <file> - Cria um novo arquivo e salva na pasta atual como \"file\"";
	private final String HELP_TEXT_DIRSEARCH= "dirsearch <path> - Busca o diretorio especificado pelo argumento \"path\", retornando o caminho";
	private final String HELP_TEXT_SEARCH	= "search <file> - Busca o arquivo especificado pelo argumento \"file\", retornando o caminho";
	private final String HELP_TEXT_ENTER 	= "enter <path> - acessa a pasta \"path\"";
	private final String HELP_TEXT_BACK 	= "back - acessa o diretorio pai da pasta atual \"path\"";
	private final String HELP_TEXT_ORDER 	= "order <path> - exibe em ordem alfabetica o conteudo da pasta \"path\"";


	
	/* comandos disponiveis */
	private final String CMD_HELP  		 = "help";
	private final String CMD_QUIT  		 = "quit";
	private final String CMD_MKDIR 		 = "mkdir";
	private final String CMD_DIR 		 = "dir";
	private final String CMD_DIR_DEL	 = "dirdel";
	private final String CMD_DEL   		 = "del";
	private final String CMD_VI   	 	 = "vi";
	private final String CMD_DIRSEARCH 	 = "dirsearch";
	private final String CMD_SEARCH 	 = "search";
	private final String CMD_ENTER  	 = "enter";
	private final String CMD_BACK	  	 = "back";
	private final String CMD_ORDER  	 = "order";
	
	
	public ComandosGerenciador() {
		 tree = new BST();
		 treeNodeAtual = new TreeNode(raiz da arvore);
		 caminho = "\\root\\";
	}

	private void exibirMensInicial() {
		System.out.println(MSG_TITLE);
		System.out.println(MSG_AUTHOR);
		System.out.println(MSG_HELP_INFO);
		System.out.println(MSG_PROMPT);
	}
	
	private void exibirMensHelp() {
		System.out.println(HELP_TEXT_TITLE);
		System.out.println(HELP_TEXT_HELP);
		System.out.println(HELP_TEXT_QUIT);
		System.out.println(HELP_TEXT_MKDIR);
		System.out.println(HELP_TEXT_DIR);
		System.out.println(HELP_TEXT_DIRDEL);
		System.out.println(HELP_TEXT_DEL);
		System.out.println(HELP_TEXT_VI);
		System.out.println(HELP_TEXT_DIRSEARCH);
		System.out.println(HELP_TEXT_SEARCH);
		System.out.println(HELP_TEXT_ENTER);
		System.out.println(HELP_TEXT_BACK);
		System.out.println(HELP_TEXT_ORDER);
	}

	private void exibirMensQuit() {
		System.out.println(MSG_QUIT);
	}
	
	private void comandoMkdir(String nome) {
		//verifica se na pasta atual tem uma pasta com o mesmo nome
		if (treeNodeAtual.getFilhoDireito().search(nome) == null) {
			//adiciona a pasta na lista encadeada direita do no atual
			treeNodeAtual.getFilhoDireito().insert(nome, treeNodeAtual);
			System.out.println(MSG_CMD_SUCCESS);
		}else {
			System.out.println(MSG_ERROR_MKDIR);
		}
	}
	
	private TreeNode verificarNodeAtual() {
		
	}
	
	private void comandoDir(String nome) {
		//verifica se o usuario esta na pasta que quer ver o conteudo
		if (treeNodeAtual.getDado().equalsIgnoreCase(nome)) {
			//verificando se a pasta esta vazia
			if (treeNodeAtual.getFilhoDireito().isEmpty() && treeNodeAtual.getFilhoEsquerdo().isEmpty()) {
				 System.out.println(MSG_EMPTY_DIR);
			}else {
				ArrayList<String> listaDir = treeNodeAtual.getFilhoDireito().toArray();
				ArrayList<String> listaEsq = treeNodeAtual.getFilhoEsquerdo().toArray();
				if (listaDir.size() != 0) {
					System.out.println("Pastas:");
					for (String dado : listaDir) {
						System.out.println(dado);
					}
				}if (listaEsq.size() != 0) {
					System.out.println("Arquivos:");
					for(String dado : listaEsq) {
						System.out.println(dado);
					}
				}
			}

		}else {
			System.out.println(MSG_ERROR_PATH_NOT_FOUND);
		}
	}
	
	private void comandoDirDel() {
		//se a pasta atual nao for a raiz, pode remover
		if (treeNodeAtual != raiz da arvore) {
			//vou para o antecessor da no da pasta a ser apagada e chamo o metodo de remover
			//para a lista de filhos direito
			treeNodeAtual.getAntecessor().getFilhoDireito().remove(treeNodeAtual.getDado());
			treeNodeAtual = treeNodeAtual.getAntecessor();
			System.out.println(MSG_CMD_SUCCESS);
		}else {
			//acesso negado se a pasta for raiz da arvore
			System.out.println(MSG_ERROR_DENY);
		}
	}
	
	private void comandoDel(String nome) {
		nos.NodeList noRemove = treeNodeAtual.getFilhoEsquerdo().search(nome);
		//verifico se o arquivo existe na pasta atual
		if (noRemove != null) {
			//vou para a lista de filhos esquerdo da pasta atual e chamo o metodo remover
			treeNodeAtual.getFilhoEsquerdo().remove(nome);
			System.out.println(MSG_CMD_SUCCESS);
		}else {
			//se o arquivo nao estiver na pasta atual
			System.out.println(MSG_ERROR_DEL);
		}
	}
	
	private void comandoVi(String nome) {
		//verifica se existe algum arquivo com o msm nome
		if (treeNodeAtual.getFilhoEsquerdo().search(nome) != null) {
			treeNodeAtual.getFilhoEsquerdo().insert(nome, treeNodeAtual);
			System.out.println(MSG_CMD_SUCCESS);
		}else {
			System.out.println(MSG_ERROR_VI);
		}
	}
	
	//retorna o caminho da primeira pasta com o nome buscado
	private void comandoDirSearch(String nome) {
		String caminhoPasta = "";
		if (nome raiz arvore == nome) {
			caminhoPasta = "\\" + nome;
			System.out.println(caminhoPasta);
		}else if (filho direito raiz arvore == null) {
			System.out.println(MSG_ERROR_PATH_NOT_FOUND);
		}else {
			//chamo o metodo search Pasta da arvore que retorna um no do tipo treenode
			TreeNode no = tree.searchPasta(nome);
			if (no != null) {
				TreeNode noVisita = no;
				nome = "";
				//aqui retorna o caminho da pasta
				System.out.println(retornaCaminho(noVisita, nome));
			}
		}
	}
	
	//retorna o caminho do primeiro arquivo com o nome buscado
	private void comandoSearch(String nome) {
		if (filho esquerdo raiz arvore == null) {
			System.out.println(MSG_ERROR_PATH_NOT_FOUND);
		}else {
			//chamo o metodo search Arquivo da arvore que retorna um no do tipo NodeList
			NodeList no = tree.searchArquivo(nome);
			if (no != null) {
				TreeNode noVisita = no.getAntecessorNo();
				nome = "\\" + nome;
				//aqui retorna o caminho do arquivo
				System.out.println(retornaCaminho(noVisita, nome));
			}
		}
	}
	
	//retorna o caminho da pasta/arquivo
	private String retornaCaminho(TreeNode noVisita, String nome) {
		boolean resposta = false;
		String caminhoRetorno = nome;
		while (resposta == false) {
			if (noVisita == tree.getRaiz()) {
				resposta = true;
				caminhoRetorno = noVisita.getDado() + caminhoRetorno;
				System.out.println(caminho);
			}else {
				caminhoRetorno = "\\" + noVisita.getDado() + caminhoRetorno;
				noVisita = noVisita.getAntecessorNo();
			}
		}
		return caminhoRetorno;
	}
	
	private void comandoEnter(String nome) {
		TreeNode nodeProcurado = treeNodeAtual.getFilhoDireito().search(nome);
		if (nodeProcurado == null) {
			System.out.println(MSG_ERROR_PATH_NOT_FOUND);
		}else {
			treeNodeAtual = nodeProcurado;
			caminho += nome + "\\";
		}
	}
	
	private void comandoBack() {
		treeNodeAtual = treeNodeAtual.getAntecessorNo();
		caminho = retornaCaminho(treeNodeAtual, "");
	}

	//ordena conteudo do diretorio atual por ordem alfabetica
	private void comandoOrder() {
		List list;
		if (!treeNodeAtual.getFilhoDireito().isEmpty()) {
			list = Arrays.asList(treeNodeAtual.getFilhoDireito().toArray());
			Collections.sort(list);
			System.out.println("Pastas:");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		if (!treeNodeAtual.getFilhoEsquerdo().isEmpty()) {
			list = Arrays.asList(treeNodeAtual.getFilhoEsquerdo().toArray());
			Collections.sort(list);
			System.out.println("Arquivos:");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}else if (treeNodeAtual.getFilhoDireito().isEmpty() && treeNodeAtual.getFilhoEsquerdo().isEmpty()) {
			System.out.println(MSG_EMPTY_DIR);
		}
	}

}
