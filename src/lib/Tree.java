package lib;

public class Tree {
}

class UnionFindTree {
    final int[] tree;
    final int[] rank;
    final int size;
    public UnionFindTree(int max) {
        size = max + 1;
        tree = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            tree[i] = i;
        }
    }

    public int root(int a) {
        if(a == tree[a]) {
            return a;
        }
        else {
            tree[a] = root(tree[a]);
            return tree[a];
        }
    }

    public boolean same(int a, int b) {
        return root(a) == root(b);
    }

    public void union(int a, int b) {
        int x = root(a);
        int y = root(b);
        if(x == y) {
            return;
        }

        if(rank[x] < rank[y]) {
            tree[y] = tree[x];
            rank[x]++;
        }
        else {
            tree[x] = tree[y];
            rank[y]++;
        }
    }
}