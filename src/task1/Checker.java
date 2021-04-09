package task1;

public class Checker {
    private final int alph = 26;

    private String transform(final String name, final char[] match) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            res.append(match[name.charAt(i) - 'a']);
        }
        return res.toString();
    }

    public boolean check(final String[] names, final String perm) {
        char[] match = new char[alph];
        for (int i = 0; i < alph; i++) {
            match[perm.charAt(i) - 'a'] = (char)('a' + i);
        }

        boolean correct = true;
        String prev = transform(names[0], match);
        for (int i = 1; i < names.length; i++) {
            String cur = transform(names[i], match);
            if (cur.compareTo(prev) < 0) {
                correct = false;
                break;
            }
            prev = cur;
        }
        return correct;
    }
}
