package entities;

/**
 *  The abstract class represents a monomial.
 *  Extended by IntMonomial and FloatMonomial.
 *  @author Carla Rusu
 */

abstract public class Monomial {
	private int deg;
	
	/**Constructs a monomial
	 * @param deg. sets the degree of the monomial
	 */
	Monomial(int deg){
		this.deg = deg;
	}
	
	/**Returns the degree of the monomial
	 * @return the degree of the monomial
	 */
	public int getDeg() {
		return deg;
	}
	
	/**Returns the sign of the monomial
	 * @return sign of the monomial
	 */
	abstract public String getSign();
	
	/**Returns the float coefficient of the monomial
	 * @return coefficient of the monomial
	 */
	abstract public float getCoef();
	
	/**Sets the coefficient of the monomial
	 * @param coef of the monomial
	 */
	abstract public void setCoef(float coef);
}
