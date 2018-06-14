package practice.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchExampleNeighbourList {

    public static class BfsNode {
        int data;
        boolean visited;
        List<BfsNode> neighbours;

        public BfsNode(int data) {
            this.data = data;
            this.neighbours = new ArrayList<>();
        }

        public void addNeighbours(BfsNode neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<BfsNode> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<BfsNode> neighbours) {
            this.neighbours = neighbours;
        }
    }

    private Queue<BfsNode> queue;
    static ArrayList<BfsNode> nodes = new ArrayList<>();

    public BreadthFirstSearchExampleNeighbourList() {
        this.queue = new LinkedList<>();
    }

    public void bfs(BfsNode node) {
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()) {
            BfsNode element = queue.remove();
            System.out.println(element.data + "t");
            List<BfsNode> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                BfsNode n = neighbours.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }
}
