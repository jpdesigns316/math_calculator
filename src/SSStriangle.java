

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
public class SSStriangle extends JPanel implements KeyListener
{
	private JLabel a = new JLabel("Side 1:");
	private JLabel b = new JLabel("Side 2:");
	private JLabel c = new JLabel("Side 3:");
	private final int A = 0;
	private final int B = 1;
	private final int C = 2;
	private JTextField aText = new JTextField(3);
	private JTextField bText = new JTextField(3);
	private JTextField cText = new JTextField(3);
	private JPanel errorPane = new JPanel();
	private JPanel topPane = new JPanel();
	private JPanel middlePane = new JPanel();
	private JPanel bottomPane = new JPanel();
	private JButton solve = new JButton("Solve");
	private JTextFocusListener focusListener = new JTextFocusListener();
	private Formulas form = new Formulas();
	private ChalkPane chalk = new ChalkPane();
	
	public SSStriangle()
	{

		// Add all the components to the Frame using FlowLayout
		topPane.setLayout(new FlowLayout());
		topPane.add(a);
		topPane.add(aText);
		topPane.add(b);
		topPane.add(bText);
		topPane.add(c);
		topPane.add(cText);
		//middlePane.add(answer);
		middlePane.add(chalk);
		bottomPane.add(solve);
		
		// Add listeners
		aText.addFocusListener(focusListener);
		bText.addFocusListener(focusListener);
		cText.addFocusListener(focusListener);
		aText.addKeyListener(this);
		bText.addKeyListener(this);
		cText.addKeyListener(this);
		solve.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				solveTriangle();
			}
		});
		setLayout(new BorderLayout());
		topPane.setBorder(new TitledBorder("Enter the sides"));
		setSize(300, 250);
		add(topPane, BorderLayout.NORTH);
		add(middlePane, BorderLayout.CENTER);
		add(bottomPane, BorderLayout.SOUTH);

		
	}
	
	@SuppressWarnings("unused")
	public void solveTriangle()
	{
		{
			double sideA, sideB, sideC;
			double angleA, angleB, angleC, total;
			String angles = "";
			String measurement = "";
			sideA = 0;
			sideB = 0;
			sideC = 0;
			try
			{

				sideA = Double.parseDouble(aText.getText());
				sideB = Double.parseDouble(bText.getText());
				sideC = Double.parseDouble(cText.getText());
				measurement = JOptionPane.showInputDialog("Enter the measurement");
				form.sssTriangle(sideA, sideB, sideC);
			} catch (NumberFormatException ex)
			{
				System.out.println("TEST");
				JOptionPane.showMessageDialog(errorPane, "Apple Numbers only", "Error", JOptionPane.ERROR_MESSAGE);
			}
			angleA = form.getAngle(A);
			angleB = form.getAngle(B);
			angleC = form.getAngle(C);
			total = angleA + angleB + angleC;
			angles = String.format(
					"a: %.2f %s A: %.2f\u00B0\n" 
			      + "b: %.2f %s B: %.2f\u00B0\n"
				  + "c: %.2f %s C: %.2f\u00B0\n",
					sideA, measurement, angleA, sideB, measurement, angleB, sideC, measurement, angleC);
			chalk.solutions.setText(angles);
		}

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			solveTriangle();
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