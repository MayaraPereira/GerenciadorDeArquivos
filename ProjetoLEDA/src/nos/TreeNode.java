package nos;

import listasEncadeadas.ListaEncadeadaArquivo;
import listasEncadeadas.ListaEncadeadaPasta;

public class TreeNode {
	
	private TreeNode antecessor;
	private TreeNode sucessor;
	private TreeNode antecessorNo;
	private String dado;
	private ListaEncadeadaPasta listaPastas;
	private ListaEncadeadaArquivo filhoEsquerdo;
	
	public TreeNode(String dado) {
		this.dado = dado;
	}

	public TreeNode getAntecessorNo() {
		return antecessorNo;
	}

	public void setAntecessorNo(TreeNode antecessorNo) {
		this.antecessorNo = antecessorNo;
	}

	public TreeNode getAntecessor() {
		return antecessor;
	}

	public void setAntecessor(TreeNode antecessor) {
		this.antecessor = antecessor;
	}

	public TreeNode getSucessor() {
		return sucessor;
	}

	public void setSucessor(TreeNode sucessor) {
		this.sucessor = sucessor;
	}

	public String getDado() {
		return dado;
	}

	public void setDado(String dado) {
		this.dado = dado;
	}

	public ListaEncadeadaPasta getListaPastas() {
		return listaPastas;
	}

	public void setListaPastas (ListaEncadeadaPasta listaPastas) {
		this.listaPastas = listaPastas;
	}

	public ListaEncadeadaArquivo getFilhoEsquerdo() {
		return filhoEsquerdo;
	}

	public void setFilhoEsquerdo(ListaEncadeadaArquivo filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}
	
	
}
