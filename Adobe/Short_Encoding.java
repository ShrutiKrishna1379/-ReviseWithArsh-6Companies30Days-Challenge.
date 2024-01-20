// Short Encoding of word

class Short_Encoding{
    public intminimumLengthEncoding(String[] words) {
        Set<String> ans = new HashSet(Arrays.asList(words));

        for (String word: words) {

            for (int k = 1; k < word.length(); ++k)

                ans.remove(word.substring(k));

        }

        int answ = 0;

        for (String word: ans)

            answ += word.length() + 1;

        return answ;
    }
}
