public class TrieClient {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		trie.addWord("art");
		trie.addWord("arts");
		trie.addWord("bug");
		trie.addWord("boy");
		trie.addWord("see");
		trie.addWord("sea");
		trie.addWord("amit");
		trie.addWord("seen");
		trie.display();
		System.out.println(trie.NumWords());
		System.out.println("******************");
		
		trie.remove("art");
		trie.display();
		System.out.println(trie.NumWords());
		trie.remove("arts");
		trie.display();
		System.out.println(trie.NumWords());
				
		
	}

}
