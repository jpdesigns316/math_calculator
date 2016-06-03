

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
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Quad extends JPanel implements ActionListener, KeyListener
{
	private JLabel a = new JLabel("A:");
	private JLabel b = new JLabel("B:");
	private JLabel c = new JLabel("C:");
	private JTextField aText = new JTextField(3);
	private JTextField bText = new JTextField(3);
	private JTextField cText = new JTextField(3);
	private JPanel errorPane = new JPanel();
	private JPanel topPane = new JPanel();
	private JPanel middlePane = new JPanel();
	private JPanel bottomPane = new JPanel();
	private JButton solve = new JButton("Solve");
	private Formulas form = new Formulas();
	private ChalkPane chalk = new ChalkPane();
	private JTextFocusListener focusListener;
	
	public Quad()
	{
		
		// Add all the components to the Frame using FlowLayout
		topPane.setLayout(new FlowLayout());
		topPane.setBorder(new TitledBorder("Enter the values of A, B, and C"));
		topPane.add(a);
		topPane.add(aText);
		topPane.add(b);
		topPane.add(bText);
		topPane.add(c);

		topPane.add(cText);
		//middlePane.add(answer);
		middlePane.add(chalk);
		bottomPane.add(solve);

		// Add an actionListener to the button
		focusListener = new JTextFocusListener();
		aText.addFocusListener(focusListener);
		bText.addFocusListener(focusListener);
		cText.addFocusListener(focusListener);
		aText.addKeyListener(this);
		bText.addKeyListener(this);
		cText.addKeyListener(this);
		solve.addActionListener(this);
		setLayout(new BorderLayout());
		add(topPane, BorderLayout.NORTH);
		add(middlePane, BorderLayout.CENTER);
		add(bottomPane, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		convertQuad();
	}
	
	public void convertQuad()
	{
		try
		{
			double a = Double.parseDouble(aText.getText());
			double b = Double.parseDouble(bText.getText());
			double c = Double.parseDouble(cText.getText());
			form.solveQuad(a, b, c);
			if (a == 0)
			{
				System.out.println("Not a quadratic equation");

			} // next check if disc < 0, using hasSolution()
			else if (form.hasSolution() == false)
				System.out.println("No real solutions");
			// finally calculate and print solutions
			else
			{

				double solution1 = form.calculateSolution1();
				double solution2 = form.calculateSolution2();
				if (solution1 == (int) solution1)
				{
					String solutionText = "";
					solutionText = String.format(
							"Solution 1: %.2f\nSolution 2: %.2f",
							solution1, solution2);
					chalk.solutions.setText(solutionText);
				} else
				{
					String solutionRadical1 = "";
					solutionRadical1 = String.format(
							"Solution:\n %.2f +- \u221A%.2f\n-----------------\n    %.2f",
							-solution1, form.getDiscriminat(), (2 * a), -solution1, form.getDiscriminat(), (2 * a));
					chalk.solutions.setText(solutionRadical1);
				}
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
			convertQuad();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	}
