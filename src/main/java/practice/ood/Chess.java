package practice.ood;

import java.util.List;

// https://www.educative.io/courses/grokking-the-object-oriented-design-interview/JP7BXYkj3DK
public class Chess {
    public enum GameStatus {
        ACTIVE, BLACK_WIN, WHITE_WIN, FORFEIT, STALEMATE, RESIGNATION
    }

    public enum AccountStatus {
        ACTIVE, CLOSED, CANCELED, BLACKLISTED, NONE
    }

    public class Address {
        private String address, city, state, zipCode, country;
    }

    public class Person {
        private String name, email, phone;
        private Address address;
    }

    public abstract class Piece {
        private boolean killed = false, white = false;

        public Piece(boolean white) {
            this.setWhite(white);
        }

        public boolean isKilled() {
            return killed;
        }

        public void setKilled(boolean killed) {
            this.killed = killed;
        }

        public boolean isWhite() {
            return white;
        }

        public void setWhite(boolean white) {
            this.white = white;
        }

        public abstract boolean canMove(Board board, Box start, Box end);
    }

    public class Board {
        Box[][] boxes;

        public Board() {
            this.resetBoard();
        }

        public Box getBox(int x, int y) {
            return boxes[x][y];
        }

        public void resetBoard() {

        }
    }

    public class Box {
        private Piece piece;
        private int x, y;

        public Box(int x, int y, Piece piece) {
            this.setPiece(piece);
            this.setX(x);
            this.setY(y);
        }

        public Piece getPiece() {
            return piece;
        }

        public void setPiece(Piece piece) {
            this.piece = piece;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public class King extends Piece {

        public King(boolean white) {
            super(white);
        }

        @Override
        public boolean canMove(Board board, Box start, Box end) {
            return false;
        }
    }

    public class Knight extends Piece {
        public Knight(boolean white) {
            super(white);
        }

        @Override
        public boolean canMove(Board board, Box start, Box end) {
            return false;
        }
    }

    public class Player {
        private Person person;
    }

    public class Move {
        private Player player;
        private Box start, end;
        private Piece pieceMoved, pieceKilled;

        public Move(Player player, Box start, Box end) {
            this.player = player;
            this.start = start;
            this.end = end;
            this.pieceMoved = start.getPiece();
        }
    }

    public class Game {
        private Player[] players;
        private Board board;
        private Player current;
        private GameStatus status;
        private List<Move> moveList;
    }

}
