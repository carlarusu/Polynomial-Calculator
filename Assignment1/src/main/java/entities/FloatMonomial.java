package entities;

/**
 *  The class represents a monomial with real coefficients.
 *  @author Carla Rusu
 */

public class FloatMonomial extends Monomial{
	private float coef;
	
	/**Constructs float type monomial
	 * @param coef
	 * @param deg
	 */
	public FloatMonomial(float coef, int deg) {
		super(deg);
		this.coef = coef;
	}

	@Override
	public float getCoef() {
		return coef;
	}

	@Override
	public String getSign() {
		if (coef < 0)
			return "-";
		else return "+";
	}

	@Override
	public void setCoef(float coef) {
		this.coef = coef;
	}
}
