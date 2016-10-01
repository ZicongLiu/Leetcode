private class Node {
    String str;
    Double factor;
    
    Node(String str, Double factor) {
        this.str = str;
        this.factor = factor;
    }
}

private class UnionFind {
    private Map<String, Double> map;
    private Map<String, String> parent;
    
    UnionFind() {
        map = new HashMap<>();
        parent = new HashMap<>();
    }
    
    public Node find(String str) {
        if (parent.get(str) == null) {
            return null;
        }
        double factor = 1.0;
        String copy = str;
        while (parent.get(str) != str) {
            factor *= map.get(str);
            str = parent.get(str);
        }
        Node res = new Node(str, factor);
        
        // path compression
        while (parent.get(copy) != copy) {
            String father = parent.get(copy);
            Double fatherFactor = map.get(copy);
            parent.put(copy, str);
            map.put(copy, factor);
            copy = father;
            factor /= fatherFactor;
        }
        return res;
    }
    
    public void union(String left, String right, double factor) {
        if (parent.get(left) == null) {
            parent.put(left, left);
            map.put(left, 1.0);
        }
        if (parent.get(right) == null) {
            parent.put(right, right);
            map.put(right, 1.0);
        }
        
        Node l = find(left); // left == l.str * l.factor
        Node r = find(right); // right == r.str * r.factor
        if (l.str != r.str) {
            parent.put(l.str, r.str);
            map.put(l.str, r.factor * factor / l.factor);
        }
    }
    
}

public double[] calcEquation(String[][] equations,
 double[] values, String[][] queries) {
    UnionFind uf = new UnionFind();
    for (int i = 0; i < equations.length; i++) {
        String left = equations[i][0];
        String right = equations[i][1];
        uf.union(left, right, values[i]);
    }
    
    double[] res = new double[queries.length];
    for (int i = 0; i < queries.length; i++) {
        String left = queries[i][0];
        String right = queries[i][1];
        Node l = uf.find(left);
        Node r = uf.find(right);
        // not exist or not related
        if (l == null || r == null || !l.str.equals(r.str)) {
            res[i] = -1.0;
        } else {
            res[i] = l.factor / r.factor;
        }
    }
    return res;
}