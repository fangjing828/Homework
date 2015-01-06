/* SimpleBoard.java */
package homework5;

/**
 * Simple class that implements an 8x8 game board with three possible values for
 * each cell: 0, 1 or 2.
 * 
 * DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class SimpleBoard {
	private final static int DIMENSION = 8;
	private final int[][] grid;

	/**
	 * Invariants: (1) grid.length == DIMENSION. (2) for all 0 <= i < DIMENSION,
	 * grid[i].length == DIMENSION. (3) for all 0 <= i, j < DIMENSION,
	 * grid[i][j] >= 0 and grid[i][j] <= 2.
	 **/

	/**
	 * Construct a new board in which all cells are zero.
	 */

	public SimpleBoard() {
		this.grid = new int[SimpleBoard.DIMENSION][SimpleBoard.DIMENSION];
	}

	/**
	 * Get the valued stored in cell (x, y).
	 * 
	 * @param x
	 *            is the x-index.
	 * @param y
	 *            is the y-index.
	 * @return the stored value (between 0 and 2).
	 * @exception ArrayIndexOutOfBoundsException
	 *                is thrown if an invalid index is given.
	 */

	public int elementAt(int x, int y) {
		return this.grid[x][y];
	}

	/**
	 * Returns true if "this" SimpleBoard and "board" have identical values in
	 * every cell.
	 * 
	 * @param board
	 *            is the second SimpleBoard.
	 * @return true if the boards are equal, false otherwise.
	 */

	@Override
	public boolean equals(Object board) {
		return ((SimpleBoard) board).hashCode() == this.hashCode();
	}

	/**
	 * Returns a hash code for this SimpleBoard.
	 * 
	 * @return a number between Integer.MIN_VALUE and Integer.MAX_VALUE.
	 */

	@Override
	public int hashCode() {

		// Replace the following line with your solution.
		return 99;
	}

	/**
	 * Set the cell (x, y) in the board to the given value mod 3.
	 * 
	 * @param value
	 *            to which the element should be set (normally 0, 1, or 2).
	 * @param x
	 *            is the x-index.
	 * @param y
	 *            is the y-index.
	 * @exception ArrayIndexOutOfBoundsException
	 *                is thrown if an invalid index is given.
	 **/

	public void setElementAt(int x, int y, int value) {
		this.grid[x][y] = value % 3;
		if (this.grid[x][y] < 0) {
			this.grid[x][y] = this.grid[x][y] + 3;
		}
	}

}
