package nos;

public class NodeList {

	private NodeList antecessor;
	private NodeList sucessor;
	private TreeNode antecessorNo;
	private String dado;
	
	public NodeList(String dado) {
		this.dado = dado;
	}
	

	public TreeNode getAntecessorNo() {
		return antecessorNo;
	}

	public void setAntecessorNo(TreeNode antecessorNo) {
		this.antecessorNo = antecessorNo;
	}

	public NodeList getAntecessor() {
		return antecessor;
	}

	public void setAntecessor(NodeList antecessor) {
		this.antecessor = antecessor;
	}

	public NodeList getSucessor() {
		return sucessor;
	}

	public void setSucessor(NodeList sucessor) {
		this.sucessor = sucessor;
	}

	public String getDado() {
		return dado;
	}

	public void setDado(String dado) {
		this.dado = dado;
	}

	
}
