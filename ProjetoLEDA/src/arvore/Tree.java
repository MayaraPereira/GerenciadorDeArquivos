package arvore;

import nos.NodeList;
import nos.TreeNode;

public class Tree {
	// Atributo que armazena uma referencia a raiz da arvore
	private TreeNode raiz = null;
	private TreeNode esquerdo = null;
	private TreeNode direito = null;

	/**
	 * Construtor padrao
	 **/
	public Tree() {
		this.raiz = null;
	}
	
	public TreeNode getRaiz() {
		return this.raiz;
	}
	
	public NodeList searchArquivo(String nome) {
		return esquerdo.getFilhoEsquerdo().search(nome);
	}
	
	public TreeNode searchPasta(String nome) {
		return direito.getFilhoDireito().search(nome);
	}
	
	

	
}
