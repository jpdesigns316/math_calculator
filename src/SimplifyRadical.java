/*
 * Simplify Radicical
 * A GUI which will simpify any radical to its most
 * simplest form. Will say if it cannot be simplified
 * or if it is a perfect square it will return the 
 * number. Implements the Formula class to access the 
 * formulas that will convert the number to its simple
 * form. Also implements error checking so that only
 * numbers could be inputed. Will pop up an error window
 * if it is called saying the issue.
 */





import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplifyRadical extends JPanel implements ActionListener, KeyListener
{
	
	private JLabel radical = new JLabel("Enter the number under the radical");
	private JTextField number = new JTextField(5);
	private JPanel topPane = new JPanel();
	private JPanel errorPane = new JPanel();
	private JPanel contentPane = new JPanel();
	private JButton simplify = new JButton("Simplify");
	private Formulas form = new Formulas();
	private JTextFocusListener focusListener;
	private ChalkPane chalk = new ChalkPane();
	
	public SimplifyRadical()
	{
	
		topPane.setLayout(new FlowLayout());
		topPane.add(radical);
		topPane.add(number);
		number.addKeyListener(this);
		chalk.solutions.setText("Enter a radical to simplify");
		simplify.addActionListener(this);
		setLayout(new BorderLayout());
		setSize(800,600);

		focusListener = new JTextFocusListener();
		number.addFocusListener(focusListener);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(topPane, BorderLayout.NORTH);
		contentPane.add(chalk, BorderLayout.CENTER);
		contentPane.add(simplify, BorderLayout.SOUTH);
		add(contentPane);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		simplify();
	}
	
	public void simplify()
	{
		int tempNumber = 0;

		try
		{
			tempNumber = Integer.parseInt(number.getText());

			form.simplifyRadical(tempNumber);
			System.out.println(form.getRadicalNumber());
			if (form.getRadicalNumber() == 1)
			{

				chalk.solutions.setText("\u221A " + tempNumber + " simplified is\n " + form.getRadicalTimes() + " ");
			} else if (form.getRadicalNumber() == 0)
			{
				chalk.solutions.setText("\u221A " + tempNumber + " cannot be simplified.");
			} else
			{

				chalk.solutions.setText("\u221A " + tempNumber + " simplified is\n " + form.getRadicalTimes() + "\u221A "
						+ form.getRadicalNumber());
			}
		} catch (NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(errorPane, "Input Numbers only", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			simplify();
		}
	}

	public void keyReleased(KeyEvent e)
	{
	}

	public void keyTyped(KeyEvent e)
	{
	}
}
