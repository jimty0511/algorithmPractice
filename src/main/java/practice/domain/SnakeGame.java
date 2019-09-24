package practice.domain;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SnakeGame {

    Set<Integer> set; // this copy is good for fast loop-up for eating body case
    Deque<Integer> body;// this copy is good for updating tail
    int score;
    int[][] food;
    int foodIndex;
    int width;
    int height;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        set.add(0);
        body = new LinkedList<>();
        body.offerLast(0);
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        if (score == -1)
            return -1;

        int rowHead = body.peekFirst() / width;
        int colHead = body.peekFirst() % width;
        switch (direction) {
            case "U":
                rowHead--;
                break;
            case "D":
                rowHead++;
                break;
            case "L":
                colHead--;
                break;
            default:
                colHead++;
        }
        int head = rowHead * width + colHead;

        set.remove(body.peekLast());
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }

        set.add(head);
        body.offerFirst(head);

        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(body.peekLast());
            foodIndex++;
            return ++score;
        }

        body.pollLast();
        return score;
    }
}
