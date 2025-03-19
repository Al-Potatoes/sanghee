package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1991 {
    static TreeNode[] tree = new TreeNode[26];

    static class TreeNode {
        char elem;
        TreeNode left, right;

        TreeNode(char value) {
            this.elem = value;
            this.left = null;
            this.right = null;
        }
    }

    static void preorder(TreeNode node) {
        if (node == null) return;

        System.out.print(node.elem);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.elem);
        inorder(node.right);
    }

    static void postorder(TreeNode node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.elem);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new TreeNode(parent);
            }

            if (left != '.') {
                tree[left - 'A'] = new TreeNode(left);
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            if (right != '.') {
                tree[right - 'A'] = new TreeNode(right);
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);
        System.out.println();
    }
}

// 14084KB	108ms
