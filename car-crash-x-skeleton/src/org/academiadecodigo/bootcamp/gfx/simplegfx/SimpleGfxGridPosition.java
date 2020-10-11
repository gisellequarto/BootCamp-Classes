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
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        rectangle = new Rectangle(getCol() * grid.getCellSize() + SimpleGfxGrid.PADDING, getRow() * grid.getCellSize() + SimpleGfxGrid.PADDING, grid.getCellSize(), grid.getCellSize());
        setColor(getColor());
        rectangle.draw();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        rectangle = new Rectangle(col * grid.getCellSize() + SimpleGfxGrid.PADDING, row * grid.getCellSize() + SimpleGfxGrid.PADDING, grid.getCellSize(), grid.getCellSize());
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

        switch (direction) {

            case UP:
                int maxRowsUp = distance < getRow() ? distance : getRow();
                rectangle.translate(0, -maxRowsUp * SimpleGfxGrid.PADDING);
                break;
            case DOWN:
                int maxRowsDown = distance > getGrid().getRows() - (getRow() + 1) ? getGrid().getRows() - (getRow() + 1) : distance;
                rectangle.translate(0, (maxRowsDown) * SimpleGfxGrid.PADDING);
                break;
            case LEFT:
                int maxRowsLeft = distance < getCol() ? distance : getCol();
                rectangle.translate(-maxRowsLeft * SimpleGfxGrid.PADDING, 0);
                break;
            case RIGHT:
                int maxRowsRight = distance > getGrid().getCols() - (getCol() + 1) ? getGrid().getCols() - (getCol() + 1) : distance;
                rectangle.translate((maxRowsRight) * SimpleGfxGrid.PADDING, 0);
                break;
        }

        super.moveInDirection(direction, distance);

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
