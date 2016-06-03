

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ChalkPane extends JPanel
{
	public JTextArea solutions = new JTextArea(5,15);
	private JPanel borders = new JPanel();
	
	public ChalkPane()
	{
		try{
			solutions.setFont(Utils.createFont().deriveFont(Font.PLAIN, 24f));
		}
		catch(Exception e)
		{
			System.out.println("Error!");
		}
		solutions.setBackground(new Color(59,101,61));
		solutions.setForeground(Color.WHITE);
		solutions.setMargin(new Insets(10,10,10,10));
		solutions.setEditable(false);
		borders.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(10.0f)));
		borders.setBackground(new Color(255,140,0));
		borders.add(solutions);
		add(borders);

	}

}
