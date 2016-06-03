

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class Frames extends JFrame implements ActionListener
{
	private JPanel contentPane = new JPanel();
	private JLabel label1 = new JLabel("Math Formulas Calculator", SwingConstants.CENTER);
	private JPanel content = new JPanel();
	private JMenuItem simplifyItem = new JMenuItem("Simplify Radical");
	private JMenuItem quadItem = new JMenuItem("Solve Quadratic Formula");
	private JMenuItem tempuratureItem = new JMenuItem("Convert Temperatures");
	private JMenuItem exitItem = new JMenuItem("Exit");
	private JMenu formulaMenu = new JMenu("Formulas");
	private JMenuItem distanceItem = new JMenuItem("Solve for Points");
	private JMenu helpMenu = new JMenu("Help");
	private JMenu triangleMenu = new JMenu("Solve Triangle...");
	private JMenuItem aboutItem = new JMenuItem("About");
	private JMenuItem aasTriangleItem = new JMenuItem("Solve a AAS Triangle");
	private JMenuItem sssTriangleItem = new JMenuItem("Solve a SSS Triangle");
	private JMenuItem sasTriangleItem = new JMenuItem("Solve a SAS Triagle");
	private SimplifyRadical simplePane = new SimplifyRadical();
	private Quad quadPane = new Quad();
	private Temperature tempPane = new Temperature();
	private SSStriangle sssPane = new SSStriangle();
	private AAStriangle aasPane = new AAStriangle();
	private SAStriangle sasPane = new SAStriangle();
	private AboutPane abt;
	private Points distPane = new Points();

	public Frames()
	{
		super("Math Formulas Calculator");
		label1.setText("Please select an item from the menu");
		content.add(label1);
		setSize(400, 450);
		setJMenuBar(CreateMenuBar());
		contentPane.setLayout(new GridBagLayout());
		add(content);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource() == simplifyItem)
		{
			changePanel(simplePane);
		} else if (e.getSource() == quadItem)
		{
			changePanel(quadPane);
		} else if (e.getSource() == tempuratureItem)
		{
			changePanel(tempPane);
		} else if (e.getSource() == sssTriangleItem)
		{
			changePanel(sssPane);
		} else if (e.getSource() == aasTriangleItem)
		{
			changePanel(aasPane);
		} 
		else if (e.getSource()==sasTriangleItem){
			changePanel(sasPane);
		}
		else if (e.getSource() == aboutItem)
		{
			if (abt == null)
			{
				@SuppressWarnings("unused")
				AboutPane abt = new AboutPane();
			} else
			{
				abt.setVisible(true);
			}
		
			
		}
		else if(e.getSource()==distanceItem)
		{
			changePanel(distPane);
		}
		else if(e.getSource()==exitItem)
		{
			System.exit(0);
		}
	}

	private void changePanel(JPanel name)
	{
		content.removeAll();
		repaint();
		content.add(name);
		printAll(getGraphics());
	}

	private JMenuBar CreateMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();

		formulaMenu.setMnemonic(KeyEvent.VK_F);
		
		// Adding Action Listeners to the menu selections
		simplifyItem.addActionListener(this);
		quadItem.addActionListener(this);
		tempuratureItem.addActionListener(this);
		sssTriangleItem.addActionListener(this);
		aasTriangleItem.addActionListener(this);
		sasTriangleItem.addActionListener(this);
		distanceItem.addActionListener(this);
		
		exitItem.addActionListener(this);

		formulaMenu.add(simplifyItem);
		formulaMenu.add(tempuratureItem);
		formulaMenu.add(quadItem);
		triangleMenu.add(sssTriangleItem);
		triangleMenu.add(aasTriangleItem);
		triangleMenu.add(sasTriangleItem);
		formulaMenu.add(triangleMenu);
		formulaMenu.add(distanceItem);
		formulaMenu.addSeparator();
		formulaMenu.add(exitItem);
		menuBar.add(formulaMenu);

		helpMenu.setMnemonic(KeyEvent.VK_H);
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(this);
		menuBar.add(helpMenu);

		return menuBar;

	}
}
