public class lexiographically_largest_string_from_box {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        int n = word.length();
        int m = n - numFriends + 1;
        String res = "";

        for (int i = 0; i < n; i++) {
            String substring = word.substring(i, Math.min(i + m, n));
            res = res.compareTo(substring) < 0 ? substring : res;
        }

        return res;
    }
}
