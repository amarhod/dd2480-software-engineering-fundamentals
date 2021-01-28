import java.awt.geom.Point2D;


class Decide {
    //Program for deciding hypothetical anti-ballistic missile system
    //Call method decide with appropriate input to decide to send an interceptor or not.
	
	
	//Global variables
	int NUMPOINTS = 2;
	double[] X = {0.23, 6.51};
	double[] Y = {1.31, 2.20};
	double LENGTH1 = 2.0;

    //LIC conditions
    public boolean LIC0() {
		double x1, y1, x2, y2, dist;
		for(int i = 1; i < NUMPOINTS; i++){
			x1 = X[i-1];
			y1 = Y[i-1];
			x2 = X[i];
			y2 = Y[i];
			dist = Point2D.distance(x1,y1,x2,y2);
			if(dist > LENGTH1){return true;}
		}
		return false;
	}

	public boolean LIC1() {
		return false;
	}

	public boolean LIC2() {
		return false;
	}

	public boolean LIC3() {
		return false;
	}

	public boolean LIC4() {
		return false;
	}

	public boolean LIC5() {
		return false;
	}

	public boolean LIC6() {
		return false;
	}

	public boolean LIC7() {
		return false;
	}

	public boolean LIC8() {
		return false;
	}

	public boolean LIC9() {
		return false;
	}

	public boolean LIC10() {
		return false;
	}

	public boolean LIC11() {
		return false;
	}

	public boolean LIC12() {
		return false;
	}

	public boolean LIC13() {
		return false;
	}

	public boolean LIC14() {
		return false;
	}
	
	
    //conditions met vector
    public int[] CMV() {
		//computes the conditions met vector from the LIC's
		int[] vector = {0};
        return vector;
    }
    
    //Preliminary unlock matrix
    public int[][] PMV() {
		//computes the PUM matrix from the CMV and the LCM
		int[][] matrix = { {0} };
        return matrix;
	}
	
	//Final unlock vector
	public int[] FUV() {
		//computes the FUV vector from the PMV and the PUV
		int[] vector = {0};
        return vector;
	}
	
    
    //decide method
    public void decide(int numpoints, int[] points, int[][] LCM, int[] PUV) {
		//decides method, calls CMV, PUM, FUV and decides if it launches or not
	}
}
