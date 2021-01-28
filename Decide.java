

class Decide {
    //Program for deciding hypothetical anti-ballistic missile system
    //Call method decide with appropriate input to decide to send an interceptor or not.
    
    //LIC conditions
    public boolean LIC0() {
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
