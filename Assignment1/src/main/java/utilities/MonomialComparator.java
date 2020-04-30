package utilities;
import java.util.*;
import entities.Monomial;

/**
 *  The class represents an implementation of interface Comparator.
 *  @author Carla Rusu
 */

public class MonomialComparator implements Comparator<Monomial>{

	/**Compares the degrees of two monomials
	 * @return int => 0 if equal, 1 if 1st is smaller and minus 1 if 1st is bigger
	 */
	public int compare(Monomial m1, Monomial m2) {
		int res = 0;
		if (m1.getDeg() < m2.getDeg())
			res = 1;
		else if (m1.getDeg() > m2.getDeg())
			res = -1;
		return res;
	}

}