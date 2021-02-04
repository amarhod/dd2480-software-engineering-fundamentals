package Decide;

public class Decide {
    //Program for deciding hypothetical anti-ballistic missile system
    //Call method decide with appropriate input to decide to send an interceptor or not.
    
    //decide method
    public boolean decide(double[] X, double[] Y, int numpoints, double length1, double length2, double area1, double area2,
						double radius1, double radius2, double epsilon, double dist, int a_pts, int b_pts, int c_pts, 
						int d_pts, int e_pts, int f_pts, int g_pts, int k_pts, int n_pts, int q_pts, int quads, String[][] LCM, boolean[] PUV) {
						//decides method, calls CMV, PUM, FUV and decides if it launches or not
						
		MatrixCalc matrixcalc = new MatrixCalc();
		
		boolean[] cmv = matrixcalc.CMV(X, Y, numpoints, length1, length2, area1, area2, radius1, radius2, epsilon, 
		dist, a_pts, b_pts, c_pts, d_pts, e_pts, f_pts, g_pts, k_pts, n_pts, q_pts, quads);
		boolean[][] pum = matrixcalc.PUM(cmv, LCM);
		boolean[] fuv = matrixcalc.FUV(pum, PUV);
		boolean launch = true;
		for(boolean v: fuv){
			if(!v){launch = false;}
		}
		if(launch){
			System.out.println("YES");
			return launch;
		}else{
			System.out.println("NO");
			return launch;
		}
	}
	public static void main(String[] args) {
		System.out.println("Testing Decide class");
	}
}
