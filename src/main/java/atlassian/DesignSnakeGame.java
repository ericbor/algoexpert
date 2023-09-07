package atlassian;

import org.junit.Assert;

import java.util.*;

//https://leetcode.com/problems/design-snake-game/
public class DesignSnakeGame {
    private final int width;
    private final int height;
    private final int[][] food;
    private final Map<String, int[]> directions = Map.of("U", new int[]{-1, 0}, "D", new int[]{1, 0},
            "L", new int[]{0, -1}, "R", new int[]{0, 1});
    private int currFood = 0;
    //int snakeSize = 0;
    private final List<int[]> list = new LinkedList<>();

    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width - 1;
        this.height = height - 1;
        this.food = food;
        list.add(new int[]{0, 0});
    }

    public int move(String direction) {
        int[] dir = directions.get(direction);
        int[] currPos = list.get(list.size() - 1);
        int r = currPos[0] + dir[0];
        int c = currPos[1] + dir[1];

        if (r < 0 || c < 0 || r > height || c > width) {
            return -1;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] == r && list.get(i)[1] == c) {
                return -1;
            }
        }


        if (currFood < food.length && food[currFood][0] == r && food[currFood][1] == c) {
            currFood++;
        } else {
            list.remove(0);
        }


        list.add(new int[]{r, c});

        return list.size() - 1;
    }

    public static void main(String[] args) {

        DesignSnakeGame snakeGame6 = new DesignSnakeGame(2, 2, new int[][]{{1, 1}, {0, 0}});
        Assert.assertEquals(0, snakeGame6.move("R"));
        Assert.assertEquals(1, snakeGame6.move("D"));
        Assert.assertEquals(1, snakeGame6.move("L"));
        Assert.assertEquals(2, snakeGame6.move("U"));
        Assert.assertEquals(2, snakeGame6.move("R"));


        DesignSnakeGame snakeGame = new DesignSnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
        Assert.assertEquals(0, snakeGame.move("R"));
        Assert.assertEquals(0, snakeGame.move("D"));
        Assert.assertEquals(1, snakeGame.move("R"));
        Assert.assertEquals(1, snakeGame.move("U"));
        Assert.assertEquals(2, snakeGame.move("L"));
        Assert.assertEquals(-1, snakeGame.move("U"));

        DesignSnakeGame snakeGame3 = new DesignSnakeGame(3, 2, new int[][]{{3, 2}, {1, 2}, {0, 1}});
        Assert.assertEquals(0, snakeGame3.move("R"));
        Assert.assertEquals(0, snakeGame3.move("D"));
        Assert.assertEquals(0, snakeGame3.move("R"));
        Assert.assertEquals(0, snakeGame3.move("U"));
        Assert.assertEquals(0, snakeGame3.move("L"));
        Assert.assertEquals(-1, snakeGame3.move("U"));

        DesignSnakeGame snakeGame2 = new DesignSnakeGame(2, 2, new int[][]{{1, 1}, {0, 1}});
        Assert.assertEquals(0, snakeGame2.move("R"));
        Assert.assertEquals(-1, snakeGame2.move("R"));

        DesignSnakeGame snakeGame5 = new DesignSnakeGame(2, 2, new int[][]{{0, 1}});
        Assert.assertEquals(1, snakeGame5.move("R"));
        Assert.assertEquals(1, snakeGame5.move("D"));

        DesignSnakeGame snakeGame4 = new DesignSnakeGame(2, 1, new int[][]{{0, 1}});
        Assert.assertEquals(1, snakeGame4.move("R"));
        Assert.assertEquals(-1, snakeGame4.move("R"));

        DesignSnakeGame snakeGame8 = new DesignSnakeGame(2, 2, new int[][]{{0, 1}, {1, 1}, {1, 0}, {0, 0}});
        Assert.assertEquals(1, snakeGame8.move("R"));
        Assert.assertEquals(2, snakeGame8.move("D"));
        Assert.assertEquals(3, snakeGame8.move("L"));
        Assert.assertEquals(4, snakeGame8.move("U"));
    }
}
