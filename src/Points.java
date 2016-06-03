

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Points extends JPanel implements ActionListener
{
	private JPanel topPane = new JPanel();
	private JPanel middlePane = new JPanel();;
	private JPanel bottomPane = new JPanel();;
	private JPanel contentPane = new JPanel();;
	private JPanel errorPane = new JPanel();;
	private JPanel x1Pane = new JPanel();;
	private JPanel y1Pane = new JPanel();;
	private JPanel x2Pane = new JPanel();;
	private JPanel y2Pane = new JPanel();;
	private JLabel x1Label = new JLabel();
	private JLabel y1Label = new JLabel();;
	private JLabel x2Label = new JLabel();;
	private JLabel y2Label = new JLabel();;
	private JTextField x1Text = new JTextField(3);
	private JTextField y1Text = new JTextField(3);
	private JTextField x2Text = new JTextField(3);
	private JTextField y2Text = new JTextField(3);
	private JButton getDistance = new JButton("Convert");
	

	private JTextFocusListener focusListner = new JTextFocusListener();
	private JRadioButton distance = new JRadioButton("Distance");;
	private JRadioButton midpoint = new JRadioButton("Midpoint");;
	private JRadioButton slope = new JRadioButton("Slope");
	private ButtonGroup bg = new ButtonGroup();
	private JPanel radioPane = new JPanel();
	private ChalkPane chalk = new ChalkPane();

	private Formulas form = new Formulas();

	public Points()
	{
		focusListner = new JTextFocusListener();
		distance = new JRadioButton("Distance");
		midpoint = new JRadioButton("Midpoint");
		slope = new JRadioButton("Slope");
		x1Text.addFocusListener(focusListner);
		y1Text.addFocusListener(focusListner);
		x2Text.addFocusListener(focusListner);
		y2Text.addFocusListener(focusListner);

		x1Pane.add(x1Label);
		x1Pane.add(x1Text);
		y1Pane.add(y1Label);
		y1Pane.add(y1Text);
		x2Pane.add(x2Label);
		x2Pane.add(x2Text);
		y2Pane.add(y2Label);
		y2Pane.add(y2Text);

		GridLayout grid = new GridLayout(1, 4);
		topPane.setLayout(grid);
		topPane.add(x1Pane);
		topPane.add(y1Pane);
		topPane.add(x2Pane);
		topPane.add(y2Pane);

		middlePane.add(chalk);
		bg.add(distance);
		bg.add(midpoint);
		bg.add(slope);
		topPane.setBorder(new TitledBorder("Enter the coordinates to solve"));
		radioPane.setBorder(new TitledBorder("Select the point formula"));
		radioPane.add(distance);
		radioPane.add(midpoint);
		radioPane.add(slope);
		bottomPane.setLayout(new BorderLayout());
		bottomPane.add(radioPane, BorderLayout.SOUTH);
		bottomPane.add(getDistance, BorderLayout.NORTH);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(topPane, BorderLayout.NORTH);
		contentPane.add(middlePane, BorderLayout.CENTER);
		contentPane.add(bottomPane, BorderLayout.SOUTH);
		add(contentPane);
		getDistance.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		boolean isDist = distance.isSelected();
		boolean isMid = midpoint.isSelected();
		boolean isSlope = slope.isSelected();
		double x1, y1, x2, y2;
		double answerDouble;
		String answerText;
		try
		{
			x1 = Double.parseDouble(x1Text.getText());
			y1 = Double.parseDouble(y1Text.getText());
			x2 = Double.parseDouble(x2Text.getText());
			y2 = Double.parseDouble(y2Text.getText());
			if (isDist)
			{
				answerDouble = form.distanceFormula(x1, y1, x2, x2);
				answerText = String.format("The distance bewteen the points is\n \u221A%.2f", answerDouble);
				chalk.solutions.setText(answerText);
			} else if (isMid)
			{
				answerDouble = form.midpointFormula(x1, y1, x2, y2);
				answerText = String.format("The midpoint bewteen the points is\n %.2f", answerDouble);
				chalk.solutions.setText(answerText);
			} else if (isSlope)
			{
				answerDouble = form.solveSlope(x1, y1, x2, y2);
				answerText = String.format("The slope bewteen the points is\n %.2f", answerDouble);
				chalk.solutions.setText(answerText);
			}

		} catch (NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(errorPane, "Input Numbers only", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
