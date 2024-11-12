import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

enum Color { RED, GREEN }

abstract class Tree { 
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree { 
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree { 
    public TreeLeaf(int value, Color color, int depth) { 
        super(value, color, depth); 
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis { 
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis { 
    private int sumInLeaves = 0;

    public int getResult() {
        return sumInLeaves;
    }

    public void visitNode(TreeNode node) {
        // Do nothing for nodes
    }

    public void visitLeaf(TreeLeaf leaf) {
        sumInLeaves += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis { 
    private long productOfRedNodes = 1L;
    private static final int MOD = 1000000007;

    public int getResult() {
        return (int) productOfRedNodes;
    }

    private void multiply(Tree tree) {
        if (tree.getColor() == Color.RED) {
            productOfRedNodes = (productOfRedNodes * tree.getValue()) % MOD;
        }
    }

    public void visitNode(TreeNode node) {
        multiply(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        multiply(leaf);
    }
}

class FancyVisitor extends TreeVis { 
    private int sumOfValuesNonLeafEvenDepth = 0;
    private int sumOfValuesGreenLeaf = 0;

    public int getResult() {
        return Math.abs(sumOfValuesNonLeafEvenDepth - sumOfValuesGreenLeaf);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumOfValuesNonLeafEvenDepth += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumOfValuesGreenLeaf += leaf.getValue();
        }
    }
}

public class Java_Visitor_Pattern { 
    static Map<Integer, Tree> tree = new HashMap<>();

    public static Tree solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Object[]> nodeAtts = new HashMap<>();

        // Read node values
        for (int i = 0; i < n; i++) {
            nodeAtts.put(i + 1, new Object[]{sc.nextInt(), null});
        }

        // Read node colors
        for (int i = 0; i < n; i++) {
            nodeAtts.get(i + 1)[1] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        // Read edges
        Map<Integer, ArrayList<Integer>> edges = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        // Create root node
        Tree root = new TreeNode((Integer) nodeAtts.get(1)[0], (Color) nodeAtts.get(1)[1], 0);
        tree.put(1, root);

        // Perform DFS to build tree
        DFS(n, edges, nodeAtts);
        return tree.get(1);
    }

    private static void DFS(int n, Map<Integer, ArrayList<Integer>> edges, Map<Integer, Object[]> nodeAtts) {
        boolean[] visited = new boolean[n + 1];
        TreeNode parent = (TreeNode) tree.get(1);
        DFSUtil(parent, 1, visited, edges, nodeAtts);
    }

    private static void DFSUtil(TreeNode parent, int v, boolean[] visited, Map<Integer, ArrayList<Integer>> edges, Map<Integer, Object[]> nodeAtts) {
        visited[v] = true;

        if (v != 1 && edges.get(v).size() == 1) {
            TreeLeaf treeLeaf = new TreeLeaf((Integer) nodeAtts.get(v)[0], (Color) nodeAtts.get(v)[1], parent.getDepth() + 1);
            parent.addChild(treeLeaf);
            tree.put(v, treeLeaf);
            return;
        }

        TreeNode treeNode = (v != 1) ? new TreeNode((Integer) nodeAtts.get(v)[0], (Color) nodeAtts.get(v)[1], parent.getDepth() + 1) : (TreeNode) tree.get(1);

        if (v != 1) {
            parent.addChild(treeNode);
            tree.put(v, treeNode);
        }

        for (int n : edges.get(v)) {
            if (!visited[n]) {
                DFSUtil(treeNode, n, visited, edges, nodeAtts);
            }
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        System.out.println(vis1.getResult());
        System.out.println(vis2.getResult());
        System.out.println(vis3.getResult());
    }
}
