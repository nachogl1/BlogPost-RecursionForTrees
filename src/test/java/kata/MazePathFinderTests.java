package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MazePathFinderTests {

    @Test
    public void throwsIfTargetPointOutOfBounds() {
        char[][] maze = {
                {' ', '#', ' ', ' '},
                {' ', '#', ' ', '#'},
                {' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' '}
        };

        int startX = 0, startY = 0;
        int endX = 10, endY = 10;

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Solution.isPathExist(maze, startX, startY, endX, endY);
        });

        assertEquals("Target point out of bounds", exception.getMessage());
    }

    @Test
    public void solveTheBloodyMaze() {

        char[][] maze = {
                {' ', '#', ' ', ' '},
                {' ', '#', ' ', '#'},
                {' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' '}
        };

        int startX = 0, startY = 0;
        int endX = 2, endY = 2;

        assertTrue(Solution.isPathExist(maze, startX, startY, endX, endY));
    }
    @Test
    public void solveTheBloodyMaze2() {

        char[][] maze = {
                {' ', '#', ' ', ' '},
                {' ', '#', ' ', '#'},
                {' ', '#', ' ', '#'},
                {'#', ' ', '#', ' '}
        };

        int startX = 0, startY = 0;
        int endX = 2, endY = 2;

        assertFalse(Solution.isPathExist(maze, startX, startY, endX, endY));
    }

    @Test
    public void solveTheBloodyMaze3() {

        char[][] maze = {
                {' ', '#', ' ', ' ',' ', ' ', ' '},
                {' ', '#', ' ', '#','#', '#', ' '},
                {' ', '#', ' ', '#','#', ' ', ' '},
                {' ', '#', ' ', '#','#', ' ', '#'},
                {' ', '#', ' ', '#','#', ' ', ' '},
                {' ', ' ', ' ', '#','#', '#', ' '},
                {'#', ' ', '#', ' ','#', ' ', ' '}
        };

        int startX = 0, startY = 0;
        int endX = 6, endY = 6;

        assertTrue(Solution.isPathExist(maze, startX, startY, endX, endY));
    }
}
