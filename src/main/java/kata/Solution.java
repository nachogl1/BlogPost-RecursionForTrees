package kata;

public class Solution {
    public static boolean isPathExist(char[][] maze, int startX, int startY, int endX, int endY) {
        if (endX >= maze.length || endY >= maze.length) throw new RuntimeException("Target point out of bounds");
        return recursiveSearch(maze, startX, startY, endX, endY, new boolean[maze.length][maze[0].length]);
    }

    private static boolean recursiveSearch(char[][] maze, int x, int y, int endX, int endY, boolean[][] visited) {
        if (x >= maze.length || y >= maze.length || x < 0 || y < 0) return false;// start point out of bounds -> return false

        if(maze[x][y] == '#') return false; // Point is a wall -> return false

        if (visited[x][y]) return false; // I have been here before -> return false

        visited[x][y] = true;

        if (x == endX && y == endY) return true; // This is my target -> return true

        //Now do this for every direction (up,down,right and left)
        return
                recursiveSearch(maze, x, y + 1, endX, endY, visited) ||
                        recursiveSearch(maze, x, y - 1, endX, endY, visited) ||
                        recursiveSearch(maze, x + 1, y, endX, endY, visited) ||
                        recursiveSearch(maze, x - 1, y, endX, endY, visited);
    }
}
