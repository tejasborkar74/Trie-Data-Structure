import java.util.HashMap;

public class Trie {

	private class Node {
		char data;
		HashMap<Character, Node> children = new HashMap<>();// new karna imp to avoid null ptr exception
		boolean IsTerminal;

		public Node(char data, boolean IsTerminal) {
			this.data = data;
			this.IsTerminal = IsTerminal;

		}
	}

	private Node root;
	private int NumWords;

	public Trie() {
		this.root = new Node('\0', false);
		this.NumWords = 0;
	}

	public int NumWords() {
		return this.NumWords;
	}

	public void addWord(String word) {
		addWord(this.root, word);
	}

	private void addWord(Node node, String word) {

		if (word.length() == 0) {
			if (node.IsTerminal) {
				// word already exists
			}

			else {
				node.IsTerminal = true;
				this.NumWords++;
			}

			return;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(ch);

		if (child == null) {
			child = new Node(ch, false);
			node.children.put(ch, child);
		}

		addWord(child, ros);

	}

	public void display() {
		display(this.root, "");
		System.out.println();
	}

	private void display(Node node, String ans) {

		if (node.IsTerminal) {
			System.out.println(ans);

			// return statement is not used as art ke bad arts bhi print hona hai!!
			// if return used arts and seen are not displayed

		}

		for (char child : node.children.keySet()) {

			display(node.children.get(child), ans + child);

		}

	}

	public boolean search(String word) {
		return search(this.root, word);
	}

	private boolean search(Node node, String word) {

		if (word.length() == 0) {

			// not written then gives true for se also;
			if (node.IsTerminal) {
				return true;
			}

			return false;
			// means that word is part of some word present in trie

		}

		char ch = word.charAt(0);
		String ros = word.substring(1);

		if (!node.children.containsKey(ch)) {
			return false;
		}

		return search(node.children.get(ch), ros);

	}

	public void remove(String word) {
		remove(this.root, word);
	}

	private void remove(Node parent, String word) {

		if (word.length() == 0) {
			if (parent.IsTerminal) {
				parent.IsTerminal = false;
				this.NumWords--;
			}

			else {
				// the word is part of another word in the trie
			}

			return;

		}

		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);

		// if word is not present
		if (child == null) {
			return;
		}

		remove(child, ros);

		// remove the nodes from memory as well
		// removal takes place when coming back from recursion
		// leaf nodes hat gayi then upar check hoga ...

		if (!child.IsTerminal && child.children.size() == 0) {
			parent.children.remove(child.data);
		}

	}

}
