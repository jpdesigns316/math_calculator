/*
 * Programming Project: FINAL PROJECT
 * Programmer: Jonathan D Peterson
 * Project Last Updated: 12/06/15
 * 
 *  Program Description:
 *  A Math formulas calculator that can do
 *  various mathematical formulas.
 *  
 *  Algorithm
 *  - DESIGN a MenuBar to show the different 
 *    selections that could be made. 
 *    - IMPLEMENT an ActionListener that will 
 *      change the JPanel which is visible.
 *    - IMPLEMENT hotkeys that will open the 
 *      Menus.
 *  - METHOD changePanel(panel:JPanel) that can
 *    remove everything in the JPanel contentPane
 *    and then replace it with a new JPanel.
 *  - EXPAND the text based Math Calculator to 
 *    a GUI that utitlzes JTextField to obtain 
 *    info
 *  - DESIGN a JPanel to have the look of a 
 *    chalkboard. In this the results of the 
 *    formulas will be placed in here.
 *  - FIX errors in mathematical formulas in
 *    the Formulas.java.
 *  - CREATE a global FocusListener file which
 *    will highlight the text of a JTextField
 *    when it is selected.
 *  - IMPLEMENT an KeyListener to check when
 *    the ENTER key is pressed and execute
 *    the formula. This is in addition to 
 *    a JButton which will execute the 
 *    formula.
 *  - CREATE an About selection to 
 *    just say a little info about this 
 *    project.      
 */	  



import javax.swing.SwingUtilities;

public class Main
{

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
		    public void run() 
		    {
		      @SuppressWarnings("unused")
			Frames frame = new Frames();
		    }	
		});
	}

}
