package task1;

public class Solver {
    private final int alph = 26;

    private final boolean[][] graph; // graph[i][j] = true if there is edge i->j and false otherwise

    private final int[] color;

    private final StringBuilder topSort;

    private boolean cycle;

    public Solver() {
        graph = new boolean[26][];
        color = new int[alph];
        topSort = new StringBuilder();
        cycle = false;

        for (int i = 0; i < alph; i++) {
            graph[i] = new boolean[alph];
            for (int j = 0; j < alph; j++) {
                graph[i][j] = false;
            }
            color[i] = 0;
        }
    }

    private void dfs(int v) {
        color[v] = 1;
        for (int i = 0; i < alph; i++) {
            if (!graph[v][i]) {
                continue;
            }
            if (color[i] == 1) {
                cycle = true;
            }
            if (color[i] == 0) {
                dfs(i);
            }
        }
        color[v] = 2;
        topSort.append((char)(v + 'a'));
    }

    public String solve(final String[] names) {
        for (int i = 1; i < names.length; i++) {
            boolean inequality = false;
            for (int j = 0; j < Math.min(names[i - 1].length(), names[i].length()); j++) {
                if (names[i - 1].charAt(j) != names[i].charAt(j)) {
                    inequality = true;
                    graph[names[i - 1].charAt(j) - 'a'][names[i].charAt(j) - 'a'] = true;
                    break;
                }
            }
            if (!inequality && names[i - 1].length() > names[i].length()) {
                return null;
            }
        }

        for (int i = 0; i < alph; i++) {
            if (color[i] == 0) {
                dfs(i);
            }
        }

        if (cycle) {
            return null;
        } else {
            return topSort.reverse().toString();
        }
    }
}
