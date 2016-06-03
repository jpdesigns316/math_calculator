


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AboutPane extends JFrame
{
	private JLabel aboutText;
	public AboutPane()
	{
		
		JPanel abt = new JPanel();
		setTitle("About");
		aboutText = new JLabel("", SwingConstants.CENTER);
		abt.setBorder(new EmptyBorder(25,10,10,25));
		abt.add(aboutText);
		aboutText.setText("<html>"
						+ "<u><strong>Math Formulas Calulator v1.0</strong></u><br/>"
						+ "By Jonathan D Peterson<br/>"
						+ "<em>\u00A9 2015<br/><br/>"
						+ "This is a program written for the final project<br/>"
						+ "in the CS112 class. It is a program that can<br/>"
						+ "calculate many diferent formulas. ");
		add(abt);
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		
	}
}
