package comandos;

public class ComandosGerenciador {
	
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
	private final String HELP_TEXT_TITLE = "Comandos disponiveis:";
	private final String HELP_TEXT_HELP  = "help - Exibe ajuda sobre os comandos disponiveis";
	private final String HELP_TEXT_QUIT  = "quit - Sai do Programa";
	private final String HELP_TEXT_MKDIR = "mkdir <path> - Cria o diretorio especificado pelo argumento \"path\"";
	private final String HELP_TEXT_DIR   = "dir <path> - Lista o conteudo do diretorio especificado pelo argumento \"path\"";
	private final String HELP_TEXT_DIRDEL= "dirdel <path> - Remove o diretorio especificado pelo argumento \"path\"";
	private final String HELP_TEXT_DEL   = "del <file> - Remove o arquivo especificado pelo argumento \"file\"";
	private final String HELP_TEXT_TYPE  = "type <file> - Exibe o conteudo do arquivo texto especificado pelo argumento \"file\"";
	private final String HELP_TEXT_VI    = "vi <file> - Cria um novo arquivo e salva como \"file\"";
	private final String HELP_TEXT_ENTER = "enter <path> - acessa a pasta \"path\"";
	private final String HELP_TEXT_ORDER = "order <path> - exibe em ordem alfabetica o conteudo da pasta \"path\"";


	
	/* comandos disponiveis */
	private final String CMD_HELP  	 = "help";
	private final String CMD_QUIT  	 = "quit";
	private final String CMD_MKDIR 	 = "mkdir";
	private final String CMD_DIR 	 = "dir";
	private final String CMD_DIR_DEL = "dirdel";
	private final String CMD_DEL   	 = "del";
	private final String CMD_COPY  	 = "copy";
	private final String CMD_TYPE 	 = "type";
	private final String CMD_VI   	 = "vi";
	private final String CMD_ENTER   = "enter";
	private final String CMD_ORDER   = "order";


	

}
