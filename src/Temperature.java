/*-
- * Covert Temperatures
 * A GUI the has input for Fahrenheit, celsius, or kelvin
 * and radio button that will dicatate the data that will
 * be converted form. Implements error checking that 
 * will not allow letters of be entered.
 */


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Temperature extends JPanel implements KeyListener
{
	// Create the Components that will be added to the JFrame
	private JTextField tempText = new JTextField(5);
	private JRadioButton fRadio = new JRadioButton("Fahrenheit");
	private JRadioButton cRadio = new JRadioButton("Celsius");
	private JRadioButton kRadio = new JRadioButton("Kelvin");
	// Splitting the pane into three sections to put
	// things into the place that they should be in
	private JPanel topPane = new JPanel(); 
	private JPanel middlePane = new JPanel();
	private JPanel bottomPane = new JPanel();
	private JPanel errorPane = new JPanel();
	//private JPanel contentPane = new JPanel();
	// Each label will have their own JLabel and JTextField
	// so that they could displayed nicely
	private JPanel tempPane = new JPanel();
//	private JPanel solutionPane = new JPanel();
	
	private JButton convert = new JButton("Convert");
	private Formulas form = new Formulas();
	// Check to see if a radio button is selected
	@SuppressWarnings("unused")
	private boolean fromF = fRadio.isSelected();
	@SuppressWarnings("unused")
	private boolean fromC = cRadio.isSelected();
	@SuppressWarnings("unused")
	private boolean fromK = kRadio.isSelected();
	private JTextFocusListener focusListener = new JTextFocusListener();
	private ButtonGroup bg  = new ButtonGroup();;
	private ChalkPane chalk = new ChalkPane();
	
	public Temperature()
	{
		// Setting the layout of each frame
		topPane.setLayout(new BorderLayout());
		
		bottomPane.setLayout(new GridLayout(0, 3));
		setLayout(new BorderLayout());
		
		tempPane.add(tempText, BorderLayout.NORTH);
		topPane.add(tempPane, BorderLayout.NORTH);
		topPane.add(bottomPane, BorderLayout.SOUTH);
		tempPane.setBorder(new TitledBorder("Enter the temperature:"));
		bg.add(fRadio);
		bg.add(cRadio);
		bg.add(kRadio);
		bottomPane.add(fRadio);
		bottomPane.add(cRadio);
		bottomPane.add(kRadio);
	
		
		// Setting the TitledBorder for a border around the JPanel
		// with a title to show what is required
		bottomPane.setBorder(new TitledBorder("Convert From"));
	
		add(middlePane, BorderLayout.SOUTH);
		add(chalk, BorderLayout.CENTER);
		add(topPane, BorderLayout.NORTH);
		middlePane.add(convert, BorderLayout.CENTER);
		
		fRadio.setSelected(true);
		setSize(300,200);
		
		// Adding the FocusLisenters to block text to 
		// highlight text when JTextField is selected
		tempText.addFocusListener(focusListener);
		tempText.addKeyListener(this);
		convert.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				convertTemp();
				
			}
		});
	}

	/*
	 * Based on the JRadioButton, try to parse the data put into the JTextField
	 * into a double. If it cannot, an exception will be thrown and an error box
	 * will be show. The parsed data will be used on the formula from Formulas 
	 * which converts temperatures. After it get doubles back, the doubles will 
	 * be formated to 2 decimal points and then converted back to String to be 
	 * added back to the JTextField.
	 */
	public void convertTemp()
	{
		// Initializing and setting each variable
		// booleans to check is a JRadioButton is selected
		boolean fromF = fRadio.isSelected();
		boolean fromC = cRadio.isSelected();
		boolean fromK = kRadio.isSelected();
		double tempF = 0d;
		double tempC = 0d;
		double tempK = 0d;
		String convert = "";
		if (fromF)
		{
			try
			{	
				
				tempF = Double.parseDouble(tempText.getText());
				tempC = form.convertFtoC(tempF);
				tempK = form.convertCtoK(tempC);
				convert = String.format("%.2f\u00B0F converts to\n"
						+ "%.2f\u00B0C and %.2f\u00B0K",tempF, tempC, tempK);
				chalk.solutions.setText(convert);

			} catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(errorPane, "Input Numbers only", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (fromC)
		{
			try
			{
				tempC = Double.parseDouble(tempText.getText());
				tempK = form.convertCtoK(tempC);
				tempF = form.convertCtoF(tempC);
				convert = String.format("%.2f\u00B0C converts to\n"
						+ "%.2f\u00B0F and %.2f\u00B0K",tempC, tempF, tempK);
				chalk.solutions.setText(convert);

			} catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(errorPane, "Input Numbers only", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (fromK)
		{
			try
			{
				tempK = Double.parseDouble(tempText.getText());
				tempC = form.converKtoC(tempK);
				tempF = form.convertCtoF(tempC);
				convert = String.format("%.2f\u00B0K converts to\n"
						+ "%.2f\u00B0C and %.2f\u00B0F",tempK, tempC, tempF);
				chalk.solutions.setText(convert);

			} catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(errorPane, "Input Numbers only", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			convertTemp();
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
