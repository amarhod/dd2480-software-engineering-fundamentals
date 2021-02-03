

class Decide {
    //Program for deciding hypothetical anti-ballistic missile system
    //Call method decide with appropriate input to decide to send an interceptor or not.

    //conditions met vector
    public boolean[] CMV(double[] X, double[] Y, int numpoints, double length1, double length2, double area1, double area2,
                            double radius1, double radius2, double epsilon, double dist, int a_pts, int b_pts, int c_pts, 
                            int d_pts, int e_pts, int f_pts, int g_pts, int k_pts, int n_pts, int q_pts, int quads) {
        //computes the conditions met vector from the LIC's
		boolean[] vector = new boolean[15];
		LIC lic = new LIC();
        vector[0] = lic.LIC0(X, Y, numpoints, length1);
        vector[1] = lic.LIC1(X, Y, numpoints, radius1);
        vector[2] = lic.LIC2(X, Y, numpoints, epsilon);
        vector[3] = lic.LIC3(X, Y, numpoints, area1);
        vector[4] = lic.LIC4(X, Y, numpoints, q_pts, quads);
        vector[5] = lic.LIC5(X, Y, numpoints);
        vector[6] = lic.LIC6(X, Y, numpoints, n_pts, dist);
        vector[7] = lic.LIC7(X, Y, numpoints, length1, k_pts);
        vector[8] = lic.LIC8(X, Y, numpoints, radius1, a_pts, b_pts);
        vector[9] = lic.LIC9(X, Y, numpoints, epsilon, c_pts, d_pts);
        vector[10] = lic.LIC10(X, Y, numpoints, area1, e_pts, f_pts);
        vector[11] = lic.LIC11(X, Y, numpoints, g_pts);
        vector[12] = lic.LIC12(X, Y, numpoints, length1, length2, k_pts);
        vector[13] = lic.LIC13(X, Y, numpoints, radius1, radius2, a_pts, b_pts);
        vector[14] = lic.LIC14(X, Y, numpoints, area1, area2, e_pts, f_pts);
        return vector;
    }

    //Preliminary unlock matrix
    public boolean[][] PUM(boolean[] cmv, String[][] lcm) {
		//computes the PUM matrix from the CMV and the LCM
		
		boolean matrix[][] = new boolean[15][15];
		
		for (int i=0; i < 15; i++){
			for (int j=0; j < 15; j++){
				if (lcm[i][j] == "ANDD") {
					if (cmv[i] && cmv[j]){
						matrix[i][j] = true;
					} else {
						matrix[i][j] = false;
					}
				} else if (lcm[i][j] == "ORR") {
					if (cmv[i] || cmv[j]){
						matrix[i][j] = true;
					} else {
						matrix[i][j] = false;
					}
				} else if (lcm[i][j] == "NOTUSED") {
					matrix[i][j] = true;
				}
			}
		}
		
        return matrix;
	}
	
	//Final unlock vector
	public boolean[] FUV(boolean[][] pum, boolean[] puv) {
		//computes the FUV vector from the PUM and the PUV
		
		boolean vector[] = new boolean[15];
		boolean allTrueFlag = true; //set to false if any element in row i of the PUM is false
		
		for (int i=0; i < 15; i++){
			allTrueFlag = true;
			if (puv[i] == false) {
				vector[i] = true;
			} else {
				for (int j=0; j < 15; j++){
					if (pum[i][j] == false){
						allTrueFlag = false; //all elements in row are not true
					}
				}
				if (allTrueFlag) {
					vector[i] = true;
				} else {
					vector[i] = false;
				}
			}
		}
		
        return vector;
	}
    
    //decide method
    public boolean decide(double[] X, double[] Y, int numpoints, double length1, double length2, double area1, double area2,
						double radius1, double radius2, double epsilon, double dist, int a_pts, int b_pts, int c_pts, 
						int d_pts, int e_pts, int f_pts, int g_pts, int k_pts, int n_pts, int q_pts, int quads, String[][] LCM, boolean[] PUV) {
						//decides method, calls CMV, PUM, FUV and decides if it launches or not
		boolean[] cmv = CMV(X, Y, numpoints, length1, length2, area1, area2, radius1, radius2, epsilon, 
		dist, a_pts, b_pts, c_pts, d_pts, e_pts, f_pts, g_pts, k_pts, n_pts, q_pts, quads);
		boolean[][] pum = PUM(cmv, LCM);
		boolean[] fuv = FUV(pum, PUV);
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
}
