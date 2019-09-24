package practice.problem;

// 824. Goat Latin
public class GoatLatin {
    public String toGoatLatin(String S) {
        StringBuilder res = new StringBuilder();
        String[] strings = S.split(" ");
        int a = 1;
        for (String s : strings) {
            if (isVowel(s.charAt(0))) {
                res.append(s).append("ma");
                for (int i = 0; i < a; i++) {
                    res.append("a");
                }
                res.append(" ");
                a++;
            } else {
                res.append(s.substring(1)).append(s.charAt(0)).append("ma");
                for (int i = 0; i < a; i++) {
                    res.append("a");
                }
                res.append(" ");
                a++;
            }
        }
        return res.toString().trim();
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
