/*
 * Simplify Radicical
 * A GUI which will simpify any radical to its most
 * simplest form. Will say if it cannot be simplified
 * or if it is a perfect square it will return the 
 * number. Implements the Formula class to access the 
 * formulas that will convert the number to its simple
 * form. Also implements error checking so that only
 * numbers could be inputed. Will pop up an error window
 * if it is called.
 */



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Formulas
{

	// Instance Variables
	Scanner input = new Scanner(System.in);
	
	DecimalFormat degrees = new DecimalFormat("###.0");
	private int radicalNumber = 0;
	private int radicalTimes = 0;
	private ArrayList<Integer> perfectSquares = new ArrayList<Integer>();
	//private int[] perfectSquares = new int[100];
	private String plus = "";
	private String minus = "";
	private double a = 0;
	private double b = 0;
	private double c = 0;
	private double discriminant = 0d;
	private ArrayList<Double> angles = new ArrayList<Double>();
	private double[] side = new double[3];
	private JPanel errorPane = new JPanel();
	
	
	public Formulas() 
	{
		createPerfects();
		angles.add(0.0);
		angles.add(0.1);
		angles.add(0.2);
	}
	// SETTERS
	
	public void setRadicalTimes(int n)
	{
		n = radicalTimes;
	}
	
	public void setRadicalNumber(int n)
	{
		n = radicalNumber;
	}
	
	
	public void setPlus(String plus)
	{
		this.plus = plus;
	}

	public void setMinus(String minus)
	{
		this.minus = minus;
	}
	
	public void setAngle(int letter, double angle)
	{
		angles.set(letter, angle);
	}

	public void setSide(int letter, double length)
	{
		side[letter] = length;
	}

	// GETTERS

	public int getRadicalTimes()
	{
		return radicalTimes;
	}

	public int getRadicalNumber()
	{
		return radicalNumber;
	}

	public String getPlus()
	{
		return plus;
	}

	public String getMinus()
	{
		return minus;
	}

	public double getAngle(int letter)
	{
		return angles.get(letter);
	}
	
	public double getSide(int letter)
	{
		return side[letter];
	}
	
	// HELPER METHODS
	public String toString()
	{
		return "testing";
	}
	public double getDiscriminat()
	{
		return discriminant;
	}
	/**
	 * 
	 * @param fomula
	 * @return
	 */
	public boolean equals(Formulas fomula)
	{
		return true;
	}

	// OTHER METHOD

	/**
	 * Method created to simplify a radical down to it's simplest form.
	 * 
	 * @param number
	 *            the number of the radical you are trying to simplify
	 */
	public void simplifyRadical(double number) 
	{
		radicalTimes = 0;
		radicalNumber = 0;
		for (int i = 1; i < perfectSquares.size(); i++) 
		{
			if (number % perfectSquares.get(i) == 0) 
			{
				radicalTimes = i+1;
				radicalNumber = ((int) number / perfectSquares.get(i));
			}
		}

	}

	/**
	 * Method to create all the perfect squares based on the length of the
	 * perfect squares array, and implement them into the perfectSquares array.
	 */
	public void createPerfects() 
	{
		for (int i = 1; i < 101; i++) 
		{
			perfectSquares.add((int) Math.pow(i, 2));
		}
	}

// Code not implemented in conversion to GUI
//	/**
//	 * Method to find the nth term in a geometric sequence
//	 * 
//	 * @param staringTerm
//	 *            The first term in the sequence
//	 * @param ratio
//	 *            the ratio which it to be used
//	 * @param nth
//	 *            the term that you are trying to find.
//	 * @return a*r^n-1
//	 *
//	 */
//	public double geometricSequenceTerm(int startingTerm, double ratio, double nth)
//	{
//		return startingTerm * Math.pow(ratio, (nth - 1));
//	}
//
//	/**
//	 * Finding the partial sum
//	 * 
//	 * @param staringTerm
//	 *            The first term in the geometric sequence
//	 * @param ratio
//	 *            the ratio that is to be used
//	 * @param nth
//	 *            the nth term of the geometric sequence that you are trying to
//	 *            calculate
//	 * @return
//	 */
//	public int geometricPartialSum(int startingTerm, double ratio, double nth)
//	{
//		return (int) ((startingTerm * (1 - (int) Math.pow(ratio, nth))) / (1 - ratio));
//	}
//
//	/**
//	 * Method to find the sum of consecutive numbers starting from 1
//	 * 
//	 * @param startingTerm
//	 *            the last term in the consecutive numbers
//	 * @return the total of all the numbers
//	 */
//
//	public double sumOfNumbers(int startingTerm)
//	{
//		return ((startingTerm * (startingTerm + 1)) / 2);
//	}

	/**
	 * Converts the fahrenheit temperature to celsius.
	 * @param temp the temperatrue in fahrenheit
	 * @return the the temperature in celsius.
	 */
	public double convertFtoC(double temp)
	{
		return ((temp - 32) * 5 / 9);
	}

	/**
	 * Converts the celsius temperature to fahrenheit.
	 * @param temp the temperatrue in celsius
	 * @return the the temperature in fahrenhiet
	 */
	public double convertCtoF(double temp)
	{
		return ((temp * 9 / 5) + 32);
	}

	/**
	 * Converts the kelvin temperature to celsius.
	 * @param temp the temperatrue in kelvin
	 * @return the the temperature in celsius
	 */
	public double convertCtoK(double temp)
	{
		return temp + 273.15;
	}
	/**
	 * Converts the celsius temperature to kelvin.
	 * @param temp the temperatrue in celsius
	 * @return the the temperature in kelvin
	 */
	public double converKtoC(double temp)
	{
		return temp - 273.15;
	}
	// Initialize and start running the quadratic formula
	public void solveQuad(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		calculateDisc();
	}
	// Executes the quadratic formula and give the positive result
	public double calculateSolution1() {
	      return (-b + Math.sqrt(discriminant))/(2.0*a);
	   }
	   
	// Executes the quadratic formula and give the positive result
	   public double calculateSolution2() {
	      return (-b - Math.sqrt(discriminant))/(2.0*a);
	   }
	   
	   // check if there are real roots
	   public boolean hasSolution() {
	      if (discriminant < 0) return false;
	      else return true;
	   }
	   
	/**
	 * Calulates the discriminant for use in the quaratic formula
	 */
	private void calculateDisc()
	{
		discriminant = Math.pow(b, 2) - 4.0 * a * c;
	}

	/**
	 * Set each of the three angles in the angles ArrayList, but if it does
	 * not exist an IndexOutOfBounds will be thrown and then it will create
	 * the new additions to the ArrayList
	 * @param angleA Theta of angle A
	 * @param angleB Theta of angle B
	 * @param angleC Theta of angle C
	 */
	private void parseTriangle(double angleA, double angleB, double angleC)
	{
		try{
			angles.set(0, angleA);
			angles.set(1, angleB);
			angles.set(2, angleC);
		}
		catch(IndexOutOfBoundsException ex)
		{
			angles.add(angleA);
			angles.add(angleB);
			angles.add(angleC);
		}
	}
	
	/**
	 * This form of solving a triangle uses the law of cosines.
	 * Law of Cosines: angleC = (a^2+b^2-c^2)/(2ab)
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 */
	public void sssTriangle(double  sideA, double sideB, double sideC)
	{
		double angleA, angleB, angleC;
		setSide(0, sideA);
		setSide(1, sideB);
		setSide(2, sideC);
		if(sideA == sideB && sideB == sideC)
		{
			angleA =  Math.toDegrees(Math.acos((Math.pow(sideB, 2) + Math.pow(sideC, 2) - Math.pow(sideA, 2)) / (2 * sideB * sideC)));
			angleB = angleA;
			angleC = angleB;
		}
		angleA =  Math.toDegrees(Math.acos((Math.pow(sideB, 2) + Math.pow(sideC, 2) - Math.pow(sideA, 2)) / (2 * sideB * sideC)));
		angleB =   Math.toDegrees(Math.acos((Math.pow(sideA, 2) + Math.pow(sideC, 2) - Math.pow(sideB, 2)) / (2 * sideA * sideC)));
		angleC =   Math.toDegrees(Math.acos((Math.pow(sideB, 2) + Math.pow(sideA, 2) - Math.pow(sideC, 2)) / (2 * sideB * sideA)));
		System.out.println("test");
		angles.set(0, angleA);
		angles.set(1, angleB);
		angles.set(2, angleC);
		if(isTriangle(angleA, angleB, angleC))
		{
			parseTriangle(angleA, angleB, angleC);	
		}
		
	}
	/**
	 * This method of solving triangles is using the Law of Sines
	 * to obtain the remaining info.
	 * Law of Sines: sidaA/angleA = sideB/angleB = sideC/angleC
	 * @param sideA
	 * @param angle1
	 * @param angle2
	 */
	
	public void saaTriangle(double sideA, double angle1, double angle2 )
	{
		double angleA, angleB, angleC;
		double sideB, sideC;
		angleA = angle1;
		angleB = angle2;
		setSide(0, sideA);
		sideB = (sideA * Math.sin(Math.toDegrees(angleB)))/Math.sin(Math.toDegrees(angleA));
		System.out.println(sideB);
		angleC = (180 - (angleA + angleB));
		sideC = (sideA * Math.sin(Math.toDegrees(angleC)))/Math.sin(Math.toDegrees(angleA));
		angles.set(0, angleA);
		angles.set(1, angleB);
		angles.set(2, angleC);
		if(isTriangle(angleA, angleB, angleC))
		{
			parseTriangle(angleA, angleB, angleC);
			side[0] = sideA;
			side[1] = sideB;
			side[2] = sideC;

		}
	}
	/**
	 * This uses the Law of Cosines to gain the theta of the angles
	 * in the triangle. 
	 * Law of Cosines used: 
	 * sideB b^2 = a^2+C^2-2ac*cos(angleB)
	 * angleC = (a^2+b^2-c^2)/(2ab)
	 * @param side1 The length of sideA
	 * @param angle2 the theta of angleB
	 * @param side3 The length of sideC
	 */
	 public void sasTriangle(double side1, double angle2, double side3)
    {
        double angleA, angleB, angleC;
        double sideA, sideB, sideC;
        double cosB;
        sideA = side1;
        angleB = angle2;
        sideC = side3;
        cosB = angleB;
        setSide(0, sideA);
        //sideB = Math.pow(2, sideA) * Math.pow(2, sideC);
        
        cosB = angleB * Math.PI/180;
        
        cosB = Math.cos(cosB);
        sideB = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideC, 2) - 2 * sideA * sideC * cosB);
                angleC =   Math.toDegrees(Math.acos((Math.pow(sideB, 2) + Math.pow(sideA, 2) - Math.pow(sideC, 2)) / (2 * sideB * sideA)));
        angleA = (180 - (angleB + angleC));
        
        //if(isTriangle(angleA, angleB, angleC))
        //{
            parseTriangle(angleA, angleB, angleC);
            side[0] = sideA;
            side[1] = sideB;
            side[2] = sideC;
        //}
    }
	/**
	 * This checks to see if the triangle is a valid one. That all three sides equal
	 * 180 degrees
	 * @param angleA The angle of A
	 * @param angleB The angle of B
	 * @param angleC The angle of C
	 * @return
	 */
	public boolean isTriangle(double angleA, double angleB, double angleC)
	{
		double angles;
		angles = getAngle(0) + getAngle(1) + getAngle(2);
		System.out.println(angles);
		if((int)angles != 180)
		{
			JOptionPane.showMessageDialog(errorPane, "Not a Triangle", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * Method which calculates the x1, y1, x2, y2 values in the points array
	 * then converts them to find the distance between the to points.
	 * 
	 * @param point1_x
	 *            the point value of x1
	 * @param point1_y
	 *            the point value of y1
	 * @param point2_x
	 *            the point value of x2
	 * @param point2_y
	 *            the point value of y2
	 */
	public double distanceFormula(double point1_x, double point1_y, double point2_x, double point2_y)
	{
		return (Math.pow(point2_x - point1_x, 2)) + (Math.pow(point2_y - point1_y, 2));
	}

	/**
	 * Method which calculates the x1, y1, x2, y2 values in the points array
	 * then converts them to find the midpoint between the to points.
	 * 
	 * @param point1_x
	 *            the point value of x1
	 * @param point1_y
	 *            the point value of y1
	 * @param point2_x
	 *            the point value of x2
	 * @param point2_y
	 *            the point value of y2
	 */
	public double midpointFormula(double point1_x, double point1_y, double point2_x, double point2_y)
	{
		return ((point2_x - point1_x) / 2) - ((point2_y - point1_y) / 2);
	}

	/**
	 * Method that retrieves data from the points array and implements that data
	 * to slope of a linear line
	 * 
	 * @param point1_x
	 *            the point value of x1
	 * @param point1_y
	 *            the point value of y1
	 * @param point2_x
	 *            the point value of x2
	 * @param point2_y
	 *            the point value of y2
	 */
	public double solveSlope(double point1_x, double point1_y, double point2_x, double point2_y)
	{
		return (point2_x - point1_x) - (point2_y - point1_y);
	}

}