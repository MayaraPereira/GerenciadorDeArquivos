package listasEncadeadas;

import java.util.ArrayList;

import nos.NodeList;
import nos.TreeNode;

public class ListaEncadeadaArquivo {

	private NodeList head;
	private NodeList nill;
	private NodeList ultimo;
	
	public ListaEncadeadaArquivo() {
		nill = new NodeList("-1");
		nill.setAntecessor(null);
		nill.setSucessor(null);

		head = new NodeList(nill.getDado());
		head.setSucessor(nill.getSucessor());
		head.setAntecessor(nill.getAntecessor());
		
		ultimo = new NodeList(head.getDado());
		ultimo.setSucessor(head.getSucessor());
		ultimo.setAntecessor(head.getAntecessor());
		
		
	}

	public NodeList getHead() {
		return head;
	}

	public void setHead(NodeList head) {
		this.head = head;
	}

	public NodeList getNill() {
		return nill;
	}

	public void setNill(NodeList nill) {
		this.nill = nill;
	}

	public NodeList getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodeList ultimo) {
		this.ultimo = ultimo;
	}
	
	public boolean isEmpty() {
		if (head.getDado() == "-1" && head.getSucessor() == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public int size() {
		if (isEmpty() == true) {
			return 0;
		}else {
			int cont = 0;
			NodeList no = head;
			while(no.getDado() != "-1" && no.getSucessor() != null) {
				no = no.getSucessor();
				cont++;
			}
			return cont;
		}
	}
	
	public NodeList search(String element) {
		if (isEmpty() == true) {
		}else {
			NodeList no = head;
			while(no.getDado() != "-1" && no.getSucessor() != null) {
				if (no.getDado() == element) {
					return no;
				}else {
					no = no.getSucessor();
				}
			}
		}
		return null;
	}
	
	//inserindo no inicio
	public void insert(String element, TreeNode noAtual) {
		if (isEmpty()) {
			head = ultimo = new NodeList(element);
			head.setAntecessorNo(noAtual);
			ultimo.setAntecessorNo(noAtual);
		}else {
			head = new NodeList(element);
			head.setAntecessorNo(noAtual);
		}		
	}
	
	public void remove(String element) {
		NodeList noRemove = search(element);
		if (noRemove != null) {
			NodeList no = head;
			while(no != nill) {
				if (noRemove == no) {
					head.getSucessor().setAntecessor(null);
					head = head.getSucessor();
					break;
				}else if (no.getSucessor() == noRemove) {
					noRemove.getSucessor().setAntecessor(no);
					no.setSucessor((noRemove.getSucessor()));
					break;
				}else {
					no = no.getSucessor();
				}
			}
		}
	}
	
	public ArrayList<String> toArray() {
		ArrayList<String> listaNums = new ArrayList<>();
 		NodeList no = head;
		while(no.getDado() != nill.getDado()) {
			listaNums.add(no.getDado());
			no = no.getSucessor();
		}
		
		return listaNums;
	}
	
}
