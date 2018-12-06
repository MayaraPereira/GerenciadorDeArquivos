package arvore;

import nos.NodeList;
import nos.TreeNode;

public class Tree {
	// Atributo que armazena uma referencia a raiz da arvore
	private TreeNode raiz = null;
	private TreeNode esquerdo = null;

	/**
	 * Construtor padrao
	 **/
	public Tree() {
		this.raiz = null;
	}
	public void inserir(TreeNode no, String dado) {
		if(no == null) {
			raiz = new TreeNode(dado);
		}
		else {
			no.getFilhoEsquerdo().insert("arthur", no);
		}
	}
	public TreeNode getRaiz() {
		return this.raiz;
	}

	public void setRaiz(TreeNode raiz) {
		this.raiz = raiz;
	}

	public NodeList searchArquivo(String nome) {
		if(!isEmpty() && !raiz.getFilhoEsquerdo().isEmpty()) {
			TreeNode aux = raiz;
			
			if(aux.getFilhoEsquerdo().search(nome) != null);
			return null;
		}
		return null;
	}

	public TreeNode searchPasta(String nome) {
		if (!isEmpty())
			return esquerdo.getFilhoDireito().search(nome);
		else
			return null;
	}

	public boolean isEmpty() {
		return (this.raiz == null);
	}

}
