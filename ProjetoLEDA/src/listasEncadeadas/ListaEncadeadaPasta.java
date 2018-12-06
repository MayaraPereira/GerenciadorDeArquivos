package listasEncadeadas;

import java.util.ArrayList;

import nos.TreeNode;


public class ListaEncadeadaPasta {
	
	private TreeNode head;
	private TreeNode nill;
	private TreeNode ultimo;
	

	public ListaEncadeadaPasta() {
		
		nill = new TreeNode("-1");
		nill.setAntecessor(null);
		nill.setSucessor(null);

		head = new TreeNode(nill.getDado());
		head.setSucessor(nill.getSucessor());
		head.setAntecessor(nill.getAntecessor());
		
		ultimo = new TreeNode(head.getDado());
		ultimo.setSucessor(head.getSucessor());
		ultimo.setAntecessor(head.getAntecessor());
		
	}


	public TreeNode getHead() {
		return head;
	}


	public void setHead(TreeNode head) {
		this.head = head;
	}


	public TreeNode getNill() {
		return nill;
	}


	public void setNill(TreeNode nill) {
		this.nill = nill;
	}


	public TreeNode getUltimo() {
		return ultimo;
	}


	public void setUltimo(TreeNode ultimo) {
		this.ultimo = ultimo;
	}
	
	public boolean isEmpty() {
		if (head == null) {
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
			TreeNode no = head;
			while(no.getDado() != "-1" && no.getSucessor() != null) {
				no = no.getSucessor();
				cont++;
			}
			return cont;
		}
	}
	
	public TreeNode search(String element) {
		if (isEmpty() == true) {
		}else {
			TreeNode no = head;
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
			head = ultimo = new TreeNode(element);
			head.setAntecessorNo(noAtual);
			ultimo.setAntecessorNo(noAtual);
		}else {
			head = new TreeNode(element);
			head.setAntecessorNo(noAtual);
			
		}		
	}
	
	public void remove(String element) {
		TreeNode noRemove = search(element);
		if (noRemove != null) {
			TreeNode no = head;
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
		TreeNode no = head;
		while(no.getDado() != nill.getDado()) {
			listaNums.add(no.getDado());
			no = no.getSucessor();
		}
		
		return listaNums;
	}
	

}
