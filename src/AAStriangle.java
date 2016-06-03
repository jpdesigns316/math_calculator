


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class AAStriangle extends JPanel implements ActionListener, FocusListener
{
	private JLabel side1Label = new JLabel("Side 1:");
	private JLabel angle1Label = new JLabel("Angle 1:");
	private JLabel angle2Label = new JLabel("Angle 2:");
	private JTextField side1Text = new JTextField(3);
	private JTextField angle1Text = new JTextField(3);
	private JTextField angle2Text = new JTextField(3);
	private JPanel errorPane = new JPanel();
	private JPanel topPane = new JPanel();
	private JPanel middlePane = new JPanel();
	private JPanel bottomPane = new JPanel();
	private JButton solve = new JButton("Solve");
	private Formulas form = new Formulas();
	private ChalkPane chalk = new ChalkPane();
	
	public AAStriangle()
	{

		// Add all the components to the Frame using FlowLayout
		topPane.setLayout(new FlowLayout());
		topPane.add(side1Label);
		topPane.add(side1Text);
		topPane.add(angle1Label);
		topPane.add(angle1Text);
		topPane.add(angle2Label);
		topPane.add(angle2Text);
		middlePane.add(chalk);
		bottomPane.add(solve);
		// Add a focusListener to highlight text when selected
		side1Text.addFocusListener(this);
		angle1Text.addFocusListener(this); 
		angle2Text.addFocusListener(this);
		// Add an actionListener to the button
		solve.addActionListener(this);
		setLayout(new BorderLayout());
		topPane.setBorder(new TitledBorder("Enter the two angles, and one side"));
		setSize(300,250);
		add(topPane, BorderLayout.NORTH);
		add(middlePane, BorderLayout.CENTER);
		add(bottomPane, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		double sideA, sideB, sideC;
		@SuppressWarnings("unused")
		double angleA, angleB, angleC, total;
		String angles = "";
		String measurement = "";
		sideA = 0;
		sideB = 0;
		sideC = 0;
		total = 0;
		try{
			
			sideA = Double.parseDouble(side1Text.getText());
			angleA = Double.parseDouble(angle1Text.getText());
			angleB = Double.parseDouble(angle2Text.getText());
			measurement = JOptionPane.showInputDialog("Enter the measurement");
			form.saaTriangle(sideA, angleA, angleB);
		}
		catch(NumberFormatException ex)
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
				"a: %.2f %s A: %.2f\u00B0\n" 
		      + "b: %.2f %s B: %.2f\u00B0\n"
			  + "c: %.2f %s C: %.2f\u00B0\n",
				sideA, measurement, angleA, sideB, measurement, angleB, sideC, measurement, angleC);
		chalk.solutions.setText(angles);
	}

	@Override
	public void focusGained(FocusEvent e)
	{
		if(e.getSource()==side1Text)
		{
			side1Text.selectAll();
		}
		else if(e.getSource()==angle1Text)
		{
			angle1Text.selectAll();
		}
		else if(e.getSource()==angle2Text)
		{
			angle2Text.selectAll();
		}
	}

	@Override
	public void focusLost(FocusEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
