


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
public class SAStriangle extends JPanel implements ActionListener, KeyListener
{
	private JLabel a = new JLabel("Side 1:");
	private JLabel b = new JLabel("Angle 2:");
	private JLabel c = new JLabel("Side 3:");
	private final int A = 0;
	private final int B = 1;
	private final int C = 2;
	private JTextField side1Text = new JTextField(3);
	private JTextField angle2Text = new JTextField(3);
	private JTextField side3Text = new JTextField(3);
	private JPanel errorPane = new JPanel();
	private JPanel topPane = new JPanel();
	private JPanel middlePane = new JPanel();
	private JPanel bottomPane = new JPanel();
	private JButton solve = new JButton("Solve");
	private Formulas form = new Formulas();
	private JTextFocusListener focusListener;
	private ChalkPane chalk = new ChalkPane();

	public SAStriangle()
	{

		// Add all the components to the Frame using FlowLayout
		topPane.setLayout(new FlowLayout());
		topPane.add(a);
		topPane.add(side1Text);
		topPane.add(b);
		topPane.add(angle2Text);
		topPane.add(c);
		topPane.add(side3Text);
		middlePane.add(chalk);
		bottomPane.add(solve);
		// Add the Listeners
		focusListener = new JTextFocusListener();
		side1Text.addFocusListener(focusListener);
		angle2Text.addFocusListener(focusListener);
		side3Text.addFocusListener(focusListener);
		solve.addActionListener(this);
		side1Text.addKeyListener(this);
		angle2Text.addKeyListener(this);
		side3Text.addKeyListener(this);
		
		setLayout(new BorderLayout());
		topPane.setBorder(new TitledBorder("Enter the two angles, and one side"));
		setSize(300, 250);
		add(topPane, BorderLayout.NORTH);
		add(middlePane, BorderLayout.CENTER);
		add(bottomPane, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		solveTriangle();
	}
	
	public void solveTriangle()
	{
		double sideA, sideB, sideC;
		@SuppressWarnings("unused")
		double angleA, angleB, angleC, total;
		String angles = "";
		String measurement = "";
		sideA = 0;
		sideB = 0;
		sideC = 0;
		try
		{

			sideA = Double.parseDouble(side1Text.getText());
			angleB = Double.parseDouble(angle2Text.getText());
			sideC = Double.parseDouble(side3Text.getText());
			measurement = JOptionPane.showInputDialog("Enter the measurement");
			form.sasTriangle(sideA, angleB, sideC);
		} catch (NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(errorPane, "Input Numbers only", "Error", JOptionPane.ERROR_MESSAGE);
		}
		angleA = form.getAngle(0);
		angleB = form.getAngle(1);
		angleC = form.getAngle(2);
		sideA = form.getSide(0);
		sideB = form.getSide(1);
		sideC = form.getSide(2);

		total = angleA + angleB + angleC;
		angles = String.format(
				"a: %.2f %s A: %.2f\u00B0\n" + "b: %.2f %s B: %.2f\u00B0\n" + "c: %.2f %s C: %.2f\u00B0\n", sideA,
				measurement, angleA, sideB, measurement, angleB, sideC, measurement, angleC);
		chalk.solutions.setText(angles);
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
