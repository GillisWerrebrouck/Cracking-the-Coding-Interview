import java.util.LinkedList;

/**
 * Object-oriented design for a jigsaw puzzle.
 * 
 * @author Gillis Werrebrouck
 */

public class Jigsaw {
    public static void main(final String args[]) {}
}

enum PieceType {
    INNER,
    EDGE,
    CORNER,
}

enum Orientation {
    TOP,
    LEFT,
    BOTTOM,
    RIGHT,
}

class Piece {
    public PieceType type;
    public Orientation orientation = Orientation.TOP;

    public Piece(PieceType type) {
        this.type = type;
    }

    public PieceType getType() {
        return type;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void rotateClockwise() {
        switch (this.getOrientation()) {
            case TOP:
                this.orientation = Orientation.RIGHT;
                break;

            case RIGHT:
                this.orientation = Orientation.BOTTOM;
                break;

            case BOTTOM:
                this.orientation = Orientation.LEFT;
                break;

            case LEFT:
                this.orientation = Orientation.TOP;
                break;

            default:
                break;
        }
    }

    // check if (this - side - piece) fits
    public boolean fitsWith(Piece piece, Orientation side) {
        // TODO: add implementation
        return true;
    }

    public boolean isEdge() {
        return this.type == PieceType.EDGE;
    }

    public boolean isCorner() {
        return this.type == PieceType.CORNER;
    }
}

class Puzzle {
    private LinkedList<Piece> pieces = new LinkedList<Piece>(); // all unused pieces
    private Piece[][] solution;

    public Puzzle() {}

    private void groupPieces(LinkedList<Piece> cornerPieces, LinkedList<Piece> edgePieces, LinkedList<Piece> innerPieces) {
        // TODO: add implementation
    }

    private LinkedList<Piece> getCorrectPieces(LinkedList<Piece> cornerPieces, LinkedList<Piece> edgePieces, LinkedList<Piece> innerPieces, int row, int col) {
        // TODO: add implementation
        return null;
    }

    private boolean fitPiece(LinkedList<Piece> possiblePieces, int row, int col) {
        if (row == 0 && col == 0) {
            Piece piece = possiblePieces.get(0);
            solution[0][0] = piece;

            return true;
        } else {
            Piece referencePiece = col == 0 ? solution[row-1][0] : solution[row][col-1];
            Orientation referenceOrientation = col == 0 ? Orientation.BOTTOM : Orientation.RIGHT;

            for (int p = 0; p < possiblePieces.size(); p++) {
                for (int r = 0; r < Orientation.values().length; r++) {
                    if (referencePiece.fitsWith(possiblePieces.get(p), referenceOrientation)) {
                        solution[row][col] = possiblePieces.get(p);
                        this.pieces.remove(possiblePieces.get(p));
                        return true;
                    }
                    pieces.get(p).rotateClockwise();
                }
            }
            return false;
        }
    }

    public boolean solve() {
        LinkedList<Piece> cornerPieces = new LinkedList<Piece>();
        LinkedList<Piece> edgePieces = new LinkedList<Piece>();
        LinkedList<Piece> innerPieces = new LinkedList<Piece>();

        groupPieces(cornerPieces, edgePieces, innerPieces);

        for (int row = 0; row < solution.length; row++) {
            for (int col = 0; col < solution[row].length; col++) {
                LinkedList<Piece> piecesOfSort = getCorrectPieces(cornerPieces, edgePieces, innerPieces, row, col);
                if (fitPiece(piecesOfSort, row, col)) {
                    return false;
                }
            }
        }

        return true;
    }
}
