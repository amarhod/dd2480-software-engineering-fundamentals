

class Decide {
    //Program for deciding hypothetical anti-ballistic missile system
    //Call method decide with appropriate input to decide to send an interceptor or not.
    
    //LIC conditions
    public boolean LIC0() {
		
	}
	public boolean LIC1() {
		
	}
	public boolean LIC2() {
		
	}
	public boolean LIC3() {
		
	}
	public boolean LIC4() {
		
	}
	public boolean LIC5() {
		
	}
	public boolean LIC6() {
		
	}
	public boolean LIC7() {
		
	}
	public boolean LIC8() {
		
	}
	public boolean LIC9() {
		
	}
	public boolean LIC10() {
		
	}
	public boolean LIC11() {
		
	}
	public boolean LIC12() {
		
	}
	public boolean LIC13() {
		
	}
	public boolean LIC14() {
		
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
