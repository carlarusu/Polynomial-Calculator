package testEntities;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.IntMonomial;
import entities.Polynomial;

public class PolynomialTest {

    @Test
    public void test_toString() {
    	IntMonomial m1 = new IntMonomial(-3, 3);
		IntMonomial m2 = new IntMonomial(-1, 1);
		IntMonomial m5 = new IntMonomial(7, 6);
		
		IntMonomial m3 = new IntMonomial(-3, 3);
		IntMonomial m4 = new IntMonomial(5, 4);
		
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
	
		p1.addMonomial(m1);
		p1.addMonomial(m2);
		p1.addMonomial(m5);
		
		p2.addMonomial(m3);
		p2.addMonomial(m4);
		
        assertEquals("7x^6 - 3x^3 - x ", p1.toString());
        assertEquals("5x^4 - 3x^3 ", p2.toString());
    }
    
    @Test
    public void test_addition() {
    	IntMonomial m1 = new IntMonomial(-3, 3);
		IntMonomial m2 = new IntMonomial(-1, 1);
		IntMonomial m5 = new IntMonomial(7, 6);
		
		IntMonomial m3 = new IntMonomial(-3, 3);
		IntMonomial m4 = new IntMonomial(5, 4);
		
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
	
		p1.addMonomial(m1);
		p1.addMonomial(m2);
		p1.addMonomial(m5);
		
		p2.addMonomial(m3);
		p2.addMonomial(m4);

    	assertEquals("7x^6 + 5x^4 - 6x^3 - x ", p1.addition(p2).toString());
    }
    
    @Test
    public void test_subtract() {
    	IntMonomial m1 = new IntMonomial(-3, 3);
		IntMonomial m2 = new IntMonomial(-1, 1);
		IntMonomial m5 = new IntMonomial(7, 6);
		
		IntMonomial m3 = new IntMonomial(-3, 3);
		IntMonomial m4 = new IntMonomial(5, 4);
		
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
	
		p1.addMonomial(m1);
		p1.addMonomial(m2);
		p1.addMonomial(m5);
		
		p2.addMonomial(m3);
		p2.addMonomial(m4);
   	
    	assertEquals("7x^6 - 5x^4 - x ", p1.subtract(p2).toString());
    }
    
    @Test
    public void test_multiply() {
    	IntMonomial m1 = new IntMonomial(-3, 3);
		IntMonomial m2 = new IntMonomial(-1, 1);
		IntMonomial m5 = new IntMonomial(7, 6);
		
		IntMonomial m3 = new IntMonomial(-3, 3);
		IntMonomial m4 = new IntMonomial(5, 4);
		
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
	
		p1.addMonomial(m1);
		p1.addMonomial(m2);
		p1.addMonomial(m5);
		
		p2.addMonomial(m3);
		p2.addMonomial(m4);
     	
    	assertEquals("35x^10 - 21x^9 - 15x^7 + 9x^6 - 5x^5 + 3x^4 ", p1.multiply(p2).toString());
    }
    
    @Test
    public void test_divide() {
    	IntMonomial m1 = new IntMonomial(-3, 3);
		IntMonomial m2 = new IntMonomial(-1, 1);
		IntMonomial m5 = new IntMonomial(7, 6);
		
		IntMonomial m3 = new IntMonomial(-3, 3);
		IntMonomial m4 = new IntMonomial(5, 4);
		
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
	
		p1.addMonomial(m1);
		p1.addMonomial(m2);
		p1.addMonomial(m5);
		
		p2.addMonomial(m3);
		p2.addMonomial(m4);
		
		Polynomial[] p3 = p1.divide(p2);
   	
    	assertEquals("1.4x^2 + 0.8x + 0.4", p3[0].toString());
    	assertEquals("-2x^3 - x ", p3[1].toString());
    }
    
    @Test
    public void test_diff() {
    	IntMonomial m1 = new IntMonomial(-3, 3);
		IntMonomial m2 = new IntMonomial(-1, 1);
		IntMonomial m5 = new IntMonomial(7, 6);
		
		Polynomial p1 = new Polynomial();

		p1.addMonomial(m1);
		p1.addMonomial(m2);
		p1.addMonomial(m5);
    	
    	assertEquals("42x^5 - 9x^2 - 1", p1.diff().toString());
    }
    
    @Test
    public void test_integrate() {
    	IntMonomial m1 = new IntMonomial(-3, 3);
		IntMonomial m2 = new IntMonomial(-1, 1);
		IntMonomial m5 = new IntMonomial(7, 6);
		
		Polynomial p1 = new Polynomial();

		p1.addMonomial(m1);
		p1.addMonomial(m2);
		p1.addMonomial(m5);
  	
    	assertEquals("x^7 - 0.75x^4 - 0.5x^2 ", p1.integrate().toString());
    }
}
