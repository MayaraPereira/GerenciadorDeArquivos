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

	public void setRaiz(TreeNode raiz) {
		this.raiz = raiz;
	}

	public NodeList searchArquivo(String nome) {
		if (!isEmpty())
			return esquerdo.getFilhoEsquerdo().search(nome);
		else
			return null;
	}

	public TreeNode searchPasta(String nome) {
		if (!isEmpty())
			return direito.getFilhoDireito().search(nome);
		else
			return null;
	}

	public boolean isEmpty() {
		return (this.raiz == null);
	}

}
