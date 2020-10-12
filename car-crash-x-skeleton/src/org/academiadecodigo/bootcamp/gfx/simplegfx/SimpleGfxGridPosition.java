package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid grid;

    /**
     * Simple graphics position constructor
     *
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid) {
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        rectangle = new Rectangle(grid.columnToX(getCol()), grid.rowToY(getRow()), grid.getCellSize(), grid.getCellSize());
        setColor(getColor());
        rectangle.draw();
    }

    /**
     * Simple graphics position constructor
     *
     * @param col  position column
     * @param row  position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);
        rectangle = new Rectangle(grid.columnToX(getCol()), grid.rowToY(getRow()), grid.getCellSize(), grid.getCellSize());
        setColor(getColor());
        rectangle.draw();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        int xInitial = getCol();
        int yInitial = getRow();

        super.moveInDirection(direction, distance);

        int xFinal = getCol();
        int yFinal = getRow();

        rectangle.translate((xFinal - xInitial) * SimpleGfxGrid.CELL_SIZE, (yFinal - yInitial) * SimpleGfxGrid.CELL_SIZE);
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        super.setColor(color);
    }
}
