package entities;
import java.util.*;

import utilities.MonomialComparator;

/**
 *  The class represents a polynomial with one variable.
 *  It includes methods for addition, subtraction, multiplication, integration,
 *  differentiation, and division.
 *  @author Carla Rusu
 */

public class Polynomial {
	private ArrayList<Monomial> poly;
	private int polyDeg;
	
	/**Constructor. Constructs a new polynomial.
	 * Sets initial degree to minus 1.
	 */
	public Polynomial (){
		poly = new ArrayList<Monomial>();
		polyDeg = -1;
	}
	
	/**Adds new monomial to the polynomial based on natural order
	 * @param mono. The monomial to be added
	 * @return boolean value representing addition status
	 */
	public boolean addMonomial(Monomial mono) {
		if (mono.getDeg() > polyDeg)
			polyDeg = mono.getDeg();
		boolean added = this.poly.add(mono);
		Comparator<Monomial> comparable = new MonomialComparator();
		Collections.sort(this.poly, comparable);
		
		for (int i = 0; i < this.poly.size()-1; i++) {
			if (this.poly.get(i).getDeg() == this.poly.get(i+1).getDeg()) {
				this.poly.get(i).setCoef(this.poly.get(i).getCoef() + this.poly.get(i+1).getCoef());
				this.poly.remove(this.poly.get(i+1));
			}
			if (this.poly.get(i).getCoef() == 0) {
				this.poly.remove(this.poly.get(i));
			}
		}
		return added;
	}
	
	/**Adds 2 polynomials  
	 * @param that. The polynomial to be added to current polynomial
	 * @return the result of the addition
	 */
	public Polynomial addition(Polynomial that) {
		Polynomial res = new Polynomial();
		for (Monomial i : this.poly) {
			IntMonomial aux = new IntMonomial((int) i.getCoef(), i.getDeg());
			res.addMonomial(aux);
		}
		for (Monomial j : that.poly) {
			IntMonomial aux = new IntMonomial((int) j.getCoef(), j.getDeg());
			res.addMonomial(aux);
		}
		return res;
	}
	
	/**Subtracts 2 polynomials  
	 * @param that. The polynomial to be subtracted from the current polynomial
	 * @return the result of the subtraction
	 */
	public Polynomial subtract(Polynomial that) {
		Polynomial res = new Polynomial();		
		for (Monomial i : this.poly) {
			FloatMonomial aux = new FloatMonomial((int) i.getCoef(), i.getDeg());
			res.addMonomial(aux);
		}
		for (Monomial j : that.poly) {
			int coef = (int) (0-j.getCoef());
			FloatMonomial aux = new FloatMonomial(coef, j.getDeg());
			res.addMonomial(aux);
		}
		return res;
	}
	
	/**Returns a new polynomial that is the derivative of this polynomial.
	 * @return derivative of polynomial
	 */
	public Polynomial diff() {
		Polynomial res = new Polynomial();
		for(Monomial i : this.poly) {
			if (i.getDeg() > 0) {
				IntMonomial aux = new IntMonomial((int) i.getCoef() * i.getDeg(), i.getDeg() - 1);
				res.addMonomial(aux);
			}
		}
		return res;
	}
	
	/**Returns a new polynomial that is the integral of this polynomial.
	 * @return integral of polynomial
	 */
	public Polynomial integrate() {
		Polynomial res = new Polynomial();
		for(Monomial i : this.poly) {
			FloatMonomial aux = new FloatMonomial(i.getCoef() / (i.getDeg() +1), i.getDeg() + 1);
			res.addMonomial(aux);
		}
		return res;
	}
	
	/**Multiplies 2 polynomials.
	 * @param that. The polynomial to be multiplied with the current polynomial
	 * @return the result of the multiplication
	 */
	public Polynomial multiply(Polynomial that) {
		Polynomial res = new Polynomial();		
		for (Monomial i : this.poly) {
			for (Monomial j : that.poly) {
				FloatMonomial aux = new FloatMonomial(i.getCoef()*j.getCoef(), i.getDeg()+j.getDeg());
				res.addMonomial(aux);
			}
		}
		return res;
	}
	
	/**Divides 2 polynomials.
	 * @param that. The polynomial dividing the current polynomial
	 * @return the result of the division as array containing quotient and remainder
	 */
	public Polynomial[] divide(Polynomial that){
		
		Polynomial quotient = new Polynomial();	
		Polynomial remainder = new Polynomial();
		Polynomial[] res = new Polynomial[2];
		
		int count = 0;
		for (Monomial i : that.poly)
			if(i.getCoef() == 0)
				count++;
		if(count == that.poly.size()) {
			FloatMonomial exc = new FloatMonomial( -1, -1);
			quotient.addMonomial(exc);
			remainder.addMonomial(exc);
			res[0] = quotient;
			res[1] = remainder;
			return res;
		}
		
		remainder = this.deepCopy();
		remainder.poly.get(0).getCoef();
		FloatMonomial r = (FloatMonomial) remainder.poly.get(0);
		IntMonomial t = (IntMonomial) that.poly.get(0);
		
		while (r.getDeg() >= t.getDeg()) {
			FloatMonomial aux = new FloatMonomial( r.getCoef() / t.getCoef(), r.getDeg() - t.getDeg());
			quotient.addMonomial(aux);
			Polynomial divider = new Polynomial();
			divider.addMonomial(aux);
			remainder = remainder.subtract(that.multiply(divider));
			if(!remainder.poly.isEmpty()) {
				r = (FloatMonomial) remainder.poly.get(0);
			} else {
				r = new FloatMonomial(0, -1);
			}
		}
		
		res[0] = quotient;
		res[1] = remainder;
		return res;
	}
	
	/**Returns a new polynomial that copies the current one
	 * @return copy of polynomial
	 */
	private Polynomial deepCopy() {
		Polynomial res = new Polynomial();
		for (Monomial i : this.poly) {
			FloatMonomial aux = new FloatMonomial(i.getCoef(), i.getDeg());
			res.addMonomial(aux);
		}
		return res;
	}
	
	/**Returns the degree of the polynomial
	 * @return degree of the polynomial
	 */
	public int getPolyDeg() {
		return polyDeg;
	}
	
	/**Returns the size of the polynomial
	 * @return size of the polynomial
	 */
	public int getPolySize() {
		return this.poly.size();
	}
	
	/**Returns the representation of the polynomial as a String
	 * @return a String representing the polynomial
	 */
	public String toString() {
		String s = "";
		int first = 0;
		if (poly.isEmpty()) {
			s = "0";
		}else if(poly.get(0).getCoef() == -1 && poly.get(0).getDeg() == -1) {
			s = "Division by 0. Invalid second term.";
		}else {
			for(Monomial i : poly) {
				if (i.getCoef() == Math.ceil(i.getCoef()))
					if (first == 0) {
						s += (i.getSign().equals("-")) ? i.getSign() : ""; 
						s += (i.getCoef() == 0) ? (int)i.getCoef() : ((Math.abs((int)i.getCoef()) != 1)? (int)i.getCoef(): ((i.getDeg() == 0)? (int)i.getCoef():""));
						if (i.getCoef() != 0)
							s += (i.getDeg() == 0) ? "" : ((i.getDeg() == 1) ? "x" : ("x^" + i.getDeg())) + " ";
						first++;
					}else {
						s += i.getSign() + " ";
						s += (i.getCoef() == 0) ? Math.abs((int)i.getCoef()) : ((Math.abs((int)i.getCoef()) != 1)? Math.abs((int)i.getCoef()): ((i.getDeg() == 0)? Math.abs((int)i.getCoef()):""));
						if (i.getCoef() != 0)
							s += (i.getDeg() == 0) ? "" : ((i.getDeg() == 1) ? "x" : ("x^" + i.getDeg())) + " ";
						}
				else
					if (first == 0) {
						s += (i.getSign().equals("-")) ? i.getSign() : ""; 
						s += (i.getCoef() == 0) ? i.getCoef() : ((Math.abs(i.getCoef()) != 1)? i.getCoef(): ((i.getDeg() == 0)? i.getCoef():""));
						if (i.getCoef() != 0)
							s += (i.getDeg() == 0) ? "" : ((i.getDeg() == 1) ? "x" : ("x^" + i.getDeg())) + " ";
						first++;
					}else {
						s += i.getSign() + " ";
						s += (i.getCoef() == 0) ? Math.abs(i.getCoef()) : ((Math.abs(i.getCoef()) != 1)? Math.abs(i.getCoef()): ((i.getDeg() == 0)? Math.abs(i.getCoef()):""));
						if (i.getCoef() != 0)
							s += (i.getDeg() == 0) ? "" : ((i.getDeg() == 1) ? "x" : ("x^" + i.getDeg())) + " ";
						}
			}
		}
		return s;
	}
}
