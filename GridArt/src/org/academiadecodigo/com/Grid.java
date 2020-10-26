package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.util.LinkedList;
import java.util.List;

public class Grid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 20;
    public static int HEIGHT;
    public static int WIDTH;
    private int lines;
    private int columns;
    private List<Rectangle> rectanglesList;
    private List<Integer[]> savedStatus;
    private SaveArchive save;
    private String filePath;

    public Grid(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        HEIGHT = lines * CELL_SIZE;
        WIDTH = columns * CELL_SIZE;
        rectanglesList = new LinkedList<>();
        createRectangles(lines, columns);
        drawRectangles();
        filePath = "SavedGrid";
    }


    public void createRectangles(int lines, int columns) {
        int x = PADDING;
        int y = PADDING;
        for (int l = 0; l < lines; l++) {

            for (int c = 0; c < columns; c++) {
                Rectangle rec = new Rectangle(x, y, CELL_SIZE, CELL_SIZE);
                rectanglesList.add(rec);
                x += CELL_SIZE;
            }
            x = PADDING;
            y += CELL_SIZE;
        }
    }


    public void drawRectangles() {
        for (Rectangle r : rectanglesList) {
            r.draw();
        }
    }

    public void changeRectangle(int x, int y, Cursor cursor) {
        for (Rectangle r : rectanglesList) {
            if ((r.getX() == x) && (r.getY() == y)) {
                if (r.isFilled()) {
                    r.setColor(Color.BLACK);
                    r.draw();
                    return;
                }
                Color actual = cursor.getColor();
                r.setColor(actual);
                r.fill();
            }
        }
    }

    public void saveRectanglesStatus() {
        savedStatus = new LinkedList<>();
        for (Rectangle r : rectanglesList) {
            if(r.isFilled()) {
            savedStatus.add(new Integer[]{1, rectangleColorIndex(r)});
            continue;
            }
            savedStatus.add(new Integer[]{0, rectangleColorIndex(r)});
        }
        save = new SaveArchive(savedStatus, filePath);
        save.save();
    }

    public void loadSavedGrid() {
        LoadArchive load = new LoadArchive(filePath);
        savedStatus = load.getSavedStatus();
        int counter = 0;
        for (Rectangle r : rectanglesList) {
            if (savedStatus.get(counter)[0] == 1) {
                Color color = MenuGrid.colors[savedStatus.get(counter)[1]];
                r.setColor(color);
                r.fill();
                counter++;
                continue;
            }
            r.setColor(Color.BLACK);
            r.draw();
            counter++;
        }
    }

    public void clear() {
        for (Rectangle r : rectanglesList) {
            r.setColor(Color.BLACK);
            r.draw();
        }
    }

    private int rectangleColorIndex(Rectangle rectangle) {
        int colorIndex = -1;
        for (int i = 0; i < MenuGrid.colors.length; i++) {
            if (MenuGrid.colors[i] == rectangle.getColor()) {
                colorIndex = i;
                break;
            }
        }
        return colorIndex;
    }

}



