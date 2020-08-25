import java.util.ArrayList;

/**
 * Algorithm to find a path in a maze with some cells that are not reachable.
 * The returned path, if one exists is not the shortest possible path.
 * 
 * @author Gillis Werrebrouck
 */

public class Robot_in_a_Grid {
    public static void main(final String args[]) {
        int row = 8;
        int col = 8;

        boolean[][] maze = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                maze[r][c] = true;
            }
        }

        // blocking cells
        maze[0][1] = false;
        maze[1][1] = false;
        maze[2][1] = false;
        maze[3][1] = false;
        maze[4][1] = false;
        maze[5][1] = false;
        maze[6][1] = false;
        maze[6][2] = false;
        maze[1][3] = false;
        maze[2][3] = false;
        maze[4][3] = false;
        maze[1][4] = false;
        maze[4][4] = false;
        maze[5][4] = false;
        maze[6][4] = false;
        maze[7][4] = false;
        maze[1][5] = false;
        maze[3][5] = false;
        maze[6][6] = false;
        maze[7][6] = false;
        maze[0][7] = false;
        maze[1][7] = false;
        maze[3][7] = false;
        maze[4][7] = false;

        ArrayList<Coordinate> path = findPath(maze);
        if(path != null) {
            System.out.println(path);
        } else {
            System.out.println("No path could be found");
        }
    }

    public static ArrayList<Coordinate> findPath(boolean[][] maze) {
        ArrayList<Coordinate> path = new ArrayList<Coordinate>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        boolean hasPath = findPath(maze, maze.length - 1, maze[0].length - 1, path, visited);
        return hasPath ? path : null;
    }


    public static boolean findPath(boolean[][] maze, int currentRow, int currentCol, ArrayList<Coordinate> path, boolean[][] visited) {
        boolean isStart = (currentRow == 0) && (currentCol == 0);

        if (!maze[currentRow][currentCol]) {
            return false;
        }

        visited[currentRow][currentCol] = true;

        if (
            isStart
            || (0 < currentRow && !visited[currentRow-1][currentCol] && findPath(maze, currentRow-1, currentCol, path, visited)) // UP
            || (currentCol < maze[0].length - 1 && !visited[currentRow][currentCol+1] && findPath(maze, currentRow, currentCol+1, path, visited)) // RIGHT
            || (currentRow < maze.length - 1 && !visited[currentRow+1][currentCol] && findPath(maze, currentRow+1, currentCol, path, visited)) // DOWN
            || (0 < currentCol && !visited[currentRow][currentCol-1] && findPath(maze, currentRow, currentCol-1, path, visited)) // LEFT
        ) {
            path.add(new Coordinate(currentRow, currentCol));
            return true;
        }

        return false;
    }
}

class Coordinate {
    private int row;
    private int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return this.row + " - " + this.col;
    }
}
