package practice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchExampleNeighbourList {
    public static class DfsNode {
        int data;
        boolean visited;
        List<DfsNode> neighbours;

        public DfsNode(int data) {
            this.data = data;
            this.neighbours = new ArrayList<>();
        }

        public void addNeighbours(DfsNode neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<DfsNode> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<DfsNode> neighbours) {
            this.neighbours = neighbours;
        }
    }

    public void dfs(DfsNode node) {
        System.out.println(node.data + " ");
        List<DfsNode> neighbours = node.getNeighbours();
        node.visited = true;
        for (int i = 0; i < neighbours.size(); i++) {
            DfsNode n = neighbours.get(i);
            if (n != null && !n.visited) {
                dfs(n);
            }
        }
    }

    public void dfsUsingStack(DfsNode node) {
        Stack<DfsNode> stack = new Stack<>();
        stack.add(node);
        node.visited = true;
        while (!stack.isEmpty()) {
            DfsNode element = stack.pop();
            System.out.println(element.data + " ");
            List<DfsNode> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                DfsNode n = neighbours.get(i);
                if (n != null && !n.visited) {
                    stack.add(n);
                    n.visited = true;
                }
            }
        }
    }
}
