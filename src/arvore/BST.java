package arvore;

public class BST {
	// Atributo que armazena uma referencia a raiz da arvore
	protected BSTNode root = null;

	/**
	 * Construtor padrao
	 **/
	public BST() {
		root = null;
	}

	/**
	 * Elimina todos os nos da arvore
	 **/
	public void clear() {
		root = null;
	}

	/**
	 * Verifica se a arvore esta vazia
	 **/
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Retorna uma referencia ao nodo raiz da arvore
	 **/
	public BSTNode getRootNode() {
		return root;
	}

	/**
	 * Insere um novo nodo na arvore binaria de pesquisa contendo a chave
	 * especificada pelo parametro el
	 **/
	public boolean insert(int el) {
		BSTNode p = root, prev = null;
		// caso o valor ja exista na arvore, nao inserir e retornar false
		if (search(el) != null)
			return false;
		// procurando um lugar para colocar o novo nodo
		while (p != null) {
			prev = p;
			if (el < p.key)
				p = p.left;
			else
				p = p.right;

		}
		// se arvore vazia, nodo sendo inserido vira raiz da arvore
		if (root == null)
			root = new BSTNode(el);
		else if (prev.key < el)
			prev.right = new BSTNode(el);
		else
			prev.left = new BSTNode(el);
		return true;
	}

	/**
	 * Retorna uma referencia ao nodo que contem a chave especificada pelo parametro
	 * el
	 **/
	public BSTNode search(int el) {
		return search(root, el);
	}

	/**
	 * Versao protegida do metodo search. Esta versao do metodo e utilizada pela
	 * versao publica, que sempre inicia a busca a partir do nodo raiz.
	 **/
	protected BSTNode search(BSTNode p, int el) {
		while (p != null) {
			/* se valor procurado == chave do nodo retorna referencia ao nodo */
			if (el == p.key)
				return p;
			/*
			 * se valor procurado < chave do nodo, procurar na sub-arvore esquerda deste
			 * nodo
			 */
			else if (el < p.key)
				p = p.left;
			/*
			 * se valor procurado > chave do nodo, procurar na sub-arvore direita deste nodo
			 */
			else
				p = p.right;
		}
		// caso chave nao foi encontrada, retorna null
		return null;
	}

	public void max() {
		max(root);

	}

	protected void max(BSTNode n) {
		if (n.right != null)
			max(n.right);
		else
			System.out.println(n.key);

	}

	public int somaMaior(int el) {
		return somaMaior(root, el);
	}

	protected int somaMaior(BSTNode p, int el) {
		if (p != null) {
			if (p.key > el)
				return p.key + somaMaior(p.left, el) + somaMaior(p.right, el);
			else
				return 0 + somaMaior(p.left, el) + somaMaior(p.right, el);
		}
		return 0;
	}
	//

	public int countNodes() {

		return countNodes(root);
	}

	protected int countNodes(BSTNode p) {

		if (p == null)
			return 0;
		else
			return 1 + countNodes(p.left) + countNodes(p.right);
	}

	//

	public int countLeafNodes() {
		return countLeafNodes(root);

	}

	public int countLeafNodes(BSTNode p) {

		if (p == null)
			return 0;

		if (p.left == null && p.right == null)
			return 1;

		return countLeafNodes(p.left) + countLeafNodes(p.right);
	}

	//
	/**
	 * Retorna uma referencia ao pai do nodo que contem a chave especificada pelo
	 * parametro el.
	 **/
	protected BSTNode searchFather(int el) {
		BSTNode p = root;
		BSTNode prev = null;
		while (p != null && !(p.key == el)) { // acha o nodo com a chave el
			prev = p;
			if (p.key < el)
				p = p.right;
			else
				p = p.left;
		}
		if (p != null && p.key == el)
			return prev;
		return null;
	}

	//

	public int height() {
		return height(root) - 1;

	}

	protected int height(BSTNode p) {
		int alturaLeft;
		int alturaRight;
		if (p != null) {
			alturaLeft = height(p.left);
			alturaRight = height(p.right);
			if (alturaLeft > alturaRight)
				return (alturaLeft + 1);
			else
				return (alturaRight + 1);

		} else
			return 0;

	}

	//
	public boolean isFull() {
		int tamanho = this.height(); // pega o tamanho
		int nodos = this.countNodes(); // total de nodos
		// faz o 2 elevado no tamanho da arvore -1. faz o modulo.
		// se for zero esta cheia, senao tem nodos que podem ser inseridos
		return (nodos % (2 ^ tamanho) - 1) == 0;
	}
	//

	/**
	 * Caminhamento em ordem. Visita a sub-arvore esquerda Visista o nodo Visita a
	 * sub-arvore direita
	 **/
	public void inorder() {
		inorder(root);
	}

	/**
	 * Versao protegida do metodo. Utilizada pela versao publica que sempre inicia a
	 * busca pelo nodo raiz
	 **/
	protected void inorder(BSTNode p) {

		if (p != null) {
			inorder(p.left);

			inorder(p.right);

		}
	}

	/**
	 * Caminhamento em pre-ordem. Visita o nodo Visista a sub-arvore esquerda Visita
	 * a sub-arvore direita
	 **/
	public void preorder() {
		preorder(root);
	}

	/**
	 * Versao protegida do metodo. Utilizada pela versao publica que sempre inicia a
	 * busca pelo nodo raiz
	 **/
	protected void preorder(BSTNode p) {
		if (p != null) {

			preorder(p.left);
			preorder(p.right);
		}
	}

	/**
	 * Caminhamento em p&#65533;s-ordem. Visita a sub-arvore esquerda Visita a
	 * sub-arvore direita Visista o nodo
	 **/
	public void postorder() {
		postorder(root);
	}

	/**
	 * Versao protegida do metodo. Utilizada pela versao publica que sempre inicia a
	 * busca pelo nodo raiz
	 **/
	protected void postorder(BSTNode p) {
		if (p != null) {
			postorder(p.left);
			postorder(p.right);
		}
	}

	/**
	 * Remove o nodo que contem a chave especificada por el
	 **/
	public void delete(int el) {
		BSTNode node, father = null;
		node = search(el); // procura nodo a ser deletado
		if (node != null && node.key == el) {
			if (node != root)
				father = searchFather(el); // procura pai do nodo a ser deletado
			if (node.right == null) { // nodo nao tem filho direito
				if (node == root)
					root = node.left;
				else if (father.left == node)
					father.left = node.left;
				else
					father.right = node.left;
			} else if (node.left == null) { // nodo nao tem o filho esquerdo
				if (node == root)
					root = node.right;
				else if (father.left == node)
					father.left = node.right;
				else
					father.right = node.right;
			} else { // nodo possui ambos os filhos
				BSTNode tmp = node.left; // 1. Obtem a raiz da sub-arvore esquerda do nodo a ser removido
				while (tmp.right != null) { // 2. Encontra o maior valor da sub-arvore esquerda do nodo a ser removido
					tmp = tmp.right;
				}
				delete(tmp.key); // 3. Remove da arvore o maior valor da sub-arvore esquerda do nodo a ser
									// removido
									// Esta chamada recursiva deleta o nodo com maior valor (chave), que sempre sera
									// um caso simples
									// nodo com um ou nenhum filho.
				node.key = tmp.key; // 4.Copia o valor (chave) do nodo removido para o nodo a ser removido

			}
		} else if (root != null) {

		}

	}
}
