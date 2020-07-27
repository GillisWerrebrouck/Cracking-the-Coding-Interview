import java.util.ArrayList;

/**
 * Object-oriented design for a the game Othello.
 * 
 * @author Gillis Werrebrouck
 */

public class Othello {
    public static void main(final String args[]) {
        
    }
}

enum Color {
    BLACK,
    WHITE,
}

class Piece {
    private Color topColor;
    private Color bottomColor;

    public Piece(Color topColor) {
        this.topColor = topColor;
        if (topColor == Color.BLACK) {
            this.bottomColor = Color.WHITE;
        } else {
            this.bottomColor = Color.BLACK;
        }
    }

    public void flip() {
        this.topColor = this.bottomColor;
        if (this.topColor == Color.BLACK) {
            this.bottomColor = Color.WHITE;
        } else {
            this.bottomColor = Color.BLACK;
        }
    }
}

class Player {
    private Color color;
    
    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

class Board {
    private Piece[][] board;
    private int blackCount;
    private int whiteCount;

    public Board(int rows, int cols) {
        this.board = new Piece[rows][cols];
    }

    public boolean putPiece(Color color, int row, int col) {
        // TODO: add implementation
        return false;
    }

    private void flipPieces(Color color, int startRow, int startCol, int endRow, int endCol) {
        // TODO: add implementation
    }

    private int getScoreByColor(Color color) {
        if (color == Color.BLACK) {
            return this.blackCount;
        }
        return this.whiteCount;
    }
}

class Game {
    private Player[] players;
    private Board board;
    private static Game instance;

    private Game() {
        board = new Board(8, 8);
        players = new Player[2];
        players[0] = new Player(Color.BLACK);
        players[1] = new Player(Color.WHITE);
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Board getBoard() {
        return board;
    }

    public Player getWinner() {
        // null if not finished
        // winner if the game is finished
        // TODO: add implementation
        return null;
    }
}
