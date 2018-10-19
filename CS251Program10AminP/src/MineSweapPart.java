import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MineSweapPart extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 600;
	private static final int WIDTH = 600;
	private static final int ROWS = 16;
	private static final int COLS = 16;
	private static final int MINES = 16;
	private static int minesLeft = MineSweapPart.MINES;
	private static int actualMinesLeft = MineSweapPart.MINES;
	private static final String FLAGGED = "@";
	private static final String MINE = "M";
	// visual indication of an exposed MyJButton
	private static final Color expColor = Color.lightGray;
	// colors used when displaying the getStateStr() String
	private static final Color colorMap[] =
		{Color.lightGray, Color.blue, Color.green,
				Color.cyan, Color.yellow, Color.orange,
				Color.pink, Color.magenta, Color.red, Color.red};
	private boolean running = true;
	// holds the "number of mines in perimeter" value for each MyJButton
	private int[][] sGrid = new int[ROWS][COLS];
	
	
	public MineSweapPart()
	{
		this.setTitle("MineSweap " +
				MineSweapPart.minesLeft +" Mines left");
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setLayout(new GridLayout(ROWS, COLS, 0, 0));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.createContents();
		// place MINES number of mines in sGrid and adjust all of the "mines in perimeter" values
		this.setMines();
		this.setVisible(true);
	}
	
	
	public void createContents()
	{
		for (int br = 0; br < ROWS; ++br)
		{
			for (int bc = 0; bc < COLS; ++bc)
			{
				// set sGrid[br][bc] entry to 0 - no mines in it’s perimeter
				sGrid[br][bc] = 0;
				// create a MyJButton that will be at location (br, bc) in the GridLayout
				MyJButton but = new MyJButton("", br, bc);
				// register the event handler with this MyJbutton
				but.addActionListener(new MyListener());
				// add the MyJButton to the GridLayout collection
				this.add(but);
			}
		}
	}
	
	
	// nested private class
	private class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if ( running )
			{
				// used to detrmine if ctrl or alt key was pressed at the time of mouse action
				int mod = event.getModifiers();
				MyJButton jb = (MyJButton)event.getSource();
				// is the MyJbutton that the mouse action occurred in flagged
				boolean flagged = jb.getText().equals(MineSweapPart.FLAGGED);
				// is the MyJbutton that the mouse action occurred in already exposed
				boolean exposed = jb.getBackground().equals(expColor);
				// flag a cell : ctrl + left click
				if ( !flagged && !exposed && (mod & ActionEvent.CTRL_MASK) != 0 )
				{
					jb.setText(MineSweapPart.FLAGGED);
					--MineSweapPart.minesLeft;
					// if the MyJbutton that the mouse action occurred in is a mine
					if ( sGrid[jb.row][jb.col] == 9 )
					{
						// what else do you need to adjust?
						// could the game be over?
						--MineSweapPart.actualMinesLeft;
						if(MineSweapPart.actualMinesLeft == MineSweapPart.minesLeft)
						{
							running = false;
						}
					}
					if(MineSweapPart.minesLeft == 0) {
						
					}
					setTitle("MineSweap " +
							MineSweapPart.minesLeft + " Mines left");
				}
				// un-flag a cell : alt + left click
				else if ( flagged && !exposed && (mod & ActionEvent.ALT_MASK) != 0 )
				{
					jb.setText("");
					++MineSweapPart.minesLeft;
					// if the MyJbutton that the mouse action occurred in is a mine
					if ( sGrid[jb.row][jb.col] == 9 )
					{
						// what else do you need to adjust?
						// could the game be over?
						++MineSweapPart.actualMinesLeft;
					}
					setTitle("MineSweap " +
							MineSweapPart.minesLeft +" Mines left");
				}
				// expose a cell : left click
				else if ( !flagged && !exposed)
				{
					exposeCell(jb);
				}
			}
		}
		
		
		public void exposeCell(MyJButton jb)
		{
			if ( !running )
				return;
			// expose this MyJButton
			jb.setBackground(expColor);
			jb.setForeground(colorMap[sGrid[jb.row][jb.col]]);
			jb.setText(getStateStr(jb.row, jb.col));
			// if the MyJButton that was just exposed is a mine
			if ( sGrid[jb.row][jb.col] == 9 )
			{
				
				for (int br = 0; br < ROWS; ++br)
				{
					for (int bc = 0; bc < COLS; ++bc)
					{
						// set sGrid[br][bc] entry to 0 - no mines in it’s perimeter
						int indn1 = (br) * COLS + bc;
						if(sGrid[br][bc] == 9)
						{
							MyJButton jbn1 = (MyJButton)jb.getParent().getComponent(indn1);
							//exposeCell(jbn1);
							if (!(jbn1.getBackground().equals(expColor)) && !(jbn1.getText().equals(MineSweapPart.FLAGGED)))
							{
								System.out.println("here");
								exposeCell(jbn1);
							}
						}
						
					}
				}
				// what else do you need to adjust?
				// could the game be over?
				return;
			}
			// if the MyJButton that was just exposed has no mines in its perimeter
			if ( sGrid[jb.row][jb.col] == 0 )
			{
				// lots of work here - must expose all MyJButtons in its perimeter
				// and so on
				// and so on
				// .
				// .
				// .
		
				for (int rm = -1; rm < 2; ++rm)
				{
					for(int cm = -1; cm < 2; ++cm)
					{
						int indn = (jb.row+rm) * COLS + jb.col+cm;
						System.out.println("row " + (jb.row + rm));
						System.out.println("col " + (jb.col + cm));
						if(	(jb.row + rm) < ROWS && (jb.row + rm) >= 0
								&& (jb.col + cm) < COLS && (jb.col + cm) >= 0 )
								{
									MyJButton jbn = (MyJButton)jb.getParent().getComponent(indn);
									if (!(jbn.getBackground().equals(expColor)) && !(jbn.getText().equals(MineSweapPart.FLAGGED)))
									{
										System.out.println("here");
										exposeCell(jbn);
									}
								}
					}
				}				
				
					
		  
			}
		}
	
	}
	
        
	
	
	// nested private class
	public static void main(String[] args)
	{
		new MineSweapPart();
	}
	
	
	//************************************************************************************************
	// place MINES number of mines in sGrid and adjust all of the "mines in perimeter" values
	private void setMines()
	{
		// your code here ...
		int rowMineLoc;
		int colMineLoc;
		int placedMines = 0;
		
		for(int i = 0; placedMines < this.MINES ; ++i) {
			
			rowMineLoc = (int)(Math.random()*this.ROWS);
			colMineLoc = (int)(Math.random()*this.COLS);
			if (this.sGrid [rowMineLoc][colMineLoc] != 9) {
				System.out.println("row" + rowMineLoc);
				System.out.println("column" + colMineLoc);
				this.sGrid[rowMineLoc][colMineLoc] = 9;
				++placedMines;
				//System.out.println("Mines placed " + placedMines)
				
			}
		}
			
		for (int br = 0; br < this.ROWS; ++br)
			{
				for (int bc = 0; bc < this.COLS; ++bc)
				{
					System.out.println("BR: " + br + " and CR: " + br );
					//if(this.sGrid [br][bc] != 9)
					//this.sGrid [br][bc] = mineCnt(br , bc);
					//System.out.println("BR: " + br + " and CR: " + br );
				}
			}
		
		for(int y = 0; y < this.ROWS; y ++) {
		      for(int x = 0; x < this.COLS; x ++) {
		        if(this.sGrid[y][x] != 9) {
		          this.sGrid[y][x] = minesCnt(y, x);
		        }
		      }
		 }
			
		
		
	}
	
	public int minesCnt(int y, int x) {
	    int mines = 0;
	    // check mines in all directions
	    mines += mineAt(y - 1, x - 1);  // NW
	    mines += mineAt(y - 1, x);      // N
	    mines += mineAt(y - 1, x + 1);  // NE
	    mines += mineAt(y, x - 1);      // W
	    mines += mineAt(y, x + 1);      // E
	    mines += mineAt(y + 1, x - 1);  // SW
	    mines += mineAt(y + 1, x);      // S
	    mines += mineAt(y + 1, x + 1);  // SE
	    
	    return mines;
	  }
	
	public int mineAt(int y, int x) {
	    // we need to check also that we're not out of array bounds as that would
	    // be an error
	    if(y >= 0 && y < this.ROWS && x >= 0 && x < this.COLS && this.sGrid[y][x] == 9) {
	      return 1;
	    } else {
	      return 0;
	    }
	  }

	
	private int mineCnt(int x, int y) {
		int mineCnt = 0;
		
		mineCnt += mineFound(y - 1, x - 1);  
	    mineCnt += mineFound(y - 1, x);      
	    mineCnt += mineFound(y - 1, x + 1);  
	    mineCnt += mineFound(y, x - 1);    
	    mineCnt += mineFound(y, x + 1);     
	    mineCnt += mineFound(y + 1, x - 1);  
	    mineCnt += mineFound(y + 1, x);      
	    mineCnt += mineFound(y + 1, x + 1);  

		
		return mineCnt;
	}
	
	public int mineFound(int y, int x) {

	    if(y >= 0 && y < this.ROWS && x >= 0 && x < this.COLS && this.sGrid[y][x] == 9) {
	      return 1;
	    } else {
	      return 0;
	    }
	  }
	
	private String getStateStr(int row, int col)
	{
		// no mines in this MyJbutton’s perimeter
		if ( this.sGrid[row][col] == 0 )
			return "";
		// 1 to 8 mines in this MyJButton’s perimeter
		else if ( this.sGrid[row][col] > 0 && this.sGrid[row][col] < 9 )
			return "" + this.sGrid[row][col];
		// this MyJButton in a mine
		else
			return MineSweapPart.MINE;
	}
}