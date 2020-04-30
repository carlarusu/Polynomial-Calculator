package entities;

/**
 *  The class represents a monomial with integer coefficients.
 *  @author Carla Rusu
 */

public class IntMonomial extends Monomial{
	private int coef;
	
	/**Constructs integer type monomial
	 * @param coef
	 * @param deg
	 */
	public IntMonomial(int coef, int deg) {
		super(deg);
		this.coef = coef;
	}

	@Override
	public float getCoef() {
		return (int)coef;
	}

	@Override
	public String getSign() {
		if (coef < 0)
			return "-";
		else return "+";
	}
	
	@Override
	public void setCoef(float coef) {
		this.coef = (int)coef;
	}
}
