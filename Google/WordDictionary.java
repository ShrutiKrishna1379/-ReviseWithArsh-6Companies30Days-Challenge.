https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

class WordDictionary {
    WordDictionary next[] = null;
    boolean isEnd;

    public WordDictionary() {
        next = new WordDictionary[26];
        isEnd = false;    
    }
    
    public void addWord(String word) {
        WordDictionary trie = this;
        for (char w : word.toCharArray()) {
            if (trie.next[w - 'a'] == null)
                trie.next[w - 'a'] = new WordDictionary();
            trie = trie.next[w - 'a'];
        }
        trie.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, this);
    }

    private boolean search (String word, int index, WordDictionary root) {
        WordDictionary curr = root;
        for (int i = index; i < word.length(); i ++) {
            char w = word.charAt(i);
            if (w != '.') {
                if (curr.next[w - 'a'] == null)
                    return false;
                curr = curr.next[w - 'a'];
            } else {
                for (WordDictionary c : curr.next) {
                    if (c != null && search(word, i + 1, c))
                        return true;
                }
                return false;
            }
        }
        return curr.isEnd;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
