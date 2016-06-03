

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class JTextFocusListener implements FocusListener

{

	@Override
	public void focusGained(FocusEvent e)
	{
		JTextField jText = (JTextField)e.getSource();
		if(e.getSource()==jText)
		{
			jText.selectAll();
		}
	
	}

	@Override
	public void focusLost(FocusEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
