package Decide;

public class DecideTest {
	// File containing test cases for Decide.java
	
	public static void smallestRadius_test() {
		LIC lic = new LIC();
		//smallestRadius test
		//obtuse case
		double smallest = lic.smallestRadius(0,0,50,10,100,0);
		assert ( smallest <= 50.1 && smallest >= 49.9) : "smallest radius not within expected range for obtuse case";
		//acute case
		smallest = lic.smallestRadius(0,0,1,2,2,0);
		assert ( smallest <= 1.26 && smallest >= 1.24) : "smallest radius not within expected range for acute case";
	}
	
	public static void LIC0_test() {
	    LIC lic = new LIC();
		double[] X1 = {0.23, 6.51};
		double[] Y1 = {1.31, 2.20};
		//For the 2 numpoints in X1 and Y1 there exist at least one set of two consecutive points that are further apart than 4.4, so LIC0 should return true.
		assert true == lic.LIC0(X1, Y1, 2, 4.4) : "LIC0 (true) Failed";
		double[] X2 = {0.23, 1.51};
		double[] Y2 = {1.31, 2.20};
		//For the 2 numpoints in X2 and Y2 there exist no set of two consecutive points that are further apart than 1.56, so LIC0 should return false.
		assert false == lic.LIC0(X2, Y2, 2, 1.56) : "LIC0 (false) Failed";	
	
	}
    
	public static void LIC1_test() {
	    LIC lic = new LIC();
		double[] LIC1_X1 = {-1.0, 0.0, 1};
		double[] LIC1_Y1 = {0, 0, 0};
		//For the 3 numpoints in LIC1_X1 and LIC1_Y1 there exist at least one set of three consecutive points that can not be contained by a circle of radius 0.95, so LIC1 should return true.
		assert true == lic.LIC1(LIC1_X1, LIC1_Y1, 3, 0.95) : "LIC1 (true) Failed";
		double[] LIC1_X2 = {-1.0, 0.0, 1.0};
		double[] LIC1_Y2 = {0, 0, 0};
		//For the 3 numpoints in LIC1_X2 and LIC1_Y2 there exist no set of three consecutive points that can not be contained by a circle of radius 1, so LIC1 should return false.
		assert false == lic.LIC1(LIC1_X2, LIC1_Y2, 3, 1.0) : "LIC1 (false) Failed";
	
	}
	
	public static void LIC2_test() {
	    LIC lic = new LIC();
		//angle less than pi - epsilon = 90 degrees
		double[] LIC2_X1 = {0, 1, 0.5};
		double[] LIC2_Y1 = {0, 0, 1};
		//For the 3 numpoints in LIC2_X1 and LIC2_Y1 there exist at least one set of three consecutive points that form an angle that is either smaller than PI-(Math.PI/2) or bigger than PI+(Math.PI/2), so LIC2 should return true. 
		assert true == lic.LIC2(LIC2_X1, LIC2_Y1, 3, Math.PI/2) : "LIC2 (true, angle < 90) Failed";
		//angle more than pi + epsilon = 270 degrees
		double[] LIC2_X2 = {0, 1, 0.5};
		double[] LIC2_Y2 = {0, 0, -1};
		//For the 3 numpoints in LIC2_X2 and LIC2_Y2 there exist at least one set of three consecutive points that form an angle that is either smaller than PI-(Math.PI/2) or bigger than PI+(Math.PI/2), so LIC2 should return true.
		assert true == lic.LIC2(LIC2_X2, LIC2_Y2, 3, Math.PI/2) : "LIC2 (true, angle > 270) Failed";
		//angles between 90 and 270
		double[] LIC2_X3 = {0, 1, 2, 3};
		double[] LIC2_Y3 = {0, 0, 2, 2};
		//For the 4 numpoints in LIC2_X3 and LIC2_Y3 there exist no set of three consecutive points that form an angle that is either smaller than PI-(Math.PI/2) or bigger than PI+(Math.PI/2), so LIC2 should return false.
		assert false == lic.LIC2(LIC2_X3, LIC2_Y3, 4, Math.PI/2) : "LIC2 (false) Failed";
	
	}
	
	public static void LIC3_test() {
	    LIC lic = new LIC();
		double[] LIC3_X1 = {0, 0, 0, 0 ,3, 0};
		double[] LIC3_Y1 = {0, 0, 0, 1, 0, 6};
		//For the 6 numpoints in LIC3_X1 and LIC3_Y1 there exist at least one set of three consecutive points that are the vertices of a triangle with an area bigger than 3, so LIC3 should return true. 
		assert true == lic.LIC3(LIC3_X1, LIC3_Y1, 6, 3) : "LIC3 (true) Failed";
		double[] LIC3_X2 = {0, -1, 0, 0 ,1, 1};
		double[] LIC3_Y2 = {0, 0, -1, 1, 0,-1};
		//For the 6 numpoints in LIC3_X2 and LIC3_Y2 there exist no set of three consecutive points that are the vertices of a triangle with an area bigger than 3, so LIC3 should return false.
		assert false == lic.LIC3(LIC3_X2, LIC3_Y2, 6, 3) : "LIC3 (false) Failed";
	
	}
	
	public static void LIC4_test() {
	    LIC lic = new LIC();
		double[] LIC4_X1 = {0, -1, 0, 0 ,1, 1};
		double[] LIC4_Y1 = {0, 0, -1, 1, 0,-1};
		//For the 6 numpoints in LIC4_X1 and LIC4_Y1 there exist at least one set of 5 consecutive points that lie in more than 3 quadrants, so LIC4 should return true.
		assert true == lic.LIC4(LIC4_X1, LIC4_Y1, 6, 5, 3) : "LIC4 (true) Failed";
		double[] LIC4_X2 = {0, 1, 0, 2 ,1, 1};
		double[] LIC4_Y2 = {0, 0, -1, 2, 0,-1};
		//For the 6 numpoints in LIC4_X2 and LIC4_Y2 there exist no set of 5 consecutive points that lie in more than 3 quadrants, so LIC4 should return false.
		assert false == lic.LIC4(LIC4_X2, LIC4_Y2, 6, 5, 3) : "LIC4 (false) Failed";
	
	}
	
	public static void LIC5_test() {
	    LIC lic = new LIC();
		double[] LIC5_X1 = {0, -1, 0};
		double[] LIC5_Y1 = {0, 0, 0};
		//For the 3 numpoints in LIC5_X1 and LIC5_Y1 there exist at least one set of two consecutive points such that LIC5_X1[j] - LIC5_X1[i] < 0 where i = j-1, so LIC5 should return true. 
		assert true == lic.LIC5(LIC5_X1, LIC5_Y1, 3) : "LIC5 (true) Failed";
		double[] LIC5_X2 = {0, 1, 2};
		double[] LIC5_Y2 = {0, 0, 0};
		//For the 3 numpoints in LIC5_X2 and LIC5_Y2 there exist no set of two consecutive points such that LIC5_X2[j] - LIC5_X2[i] < 0 where i = j-1, so LIC5 should return false. 
		assert false == lic.LIC5(LIC5_X2, LIC5_Y2, 3) : "LIC5 (false) Failed";	
	
	}
	
	public static void LIC6_test() {
	    LIC lic = new LIC();
		double[] LIC6_X1 = {0, -1, 0, 0 ,1, 0};
		double[] LIC6_Y1 = {0, 0, -1, 0, 0,-1};
		//For the 6 numpoints in LIC6_X1 and LIC6_Y1 there exist at least one set of 4 consecutive points such that at least one of these points lies further than 1.25 away from the line joining the first and last points, so LIC6 should return true.
		assert true == lic.LIC6(LIC6_X1, LIC6_Y1, 6, 4, 1.25) : "LIC6 (true) Failed";
		double[] LIC6_X2 = {0, 0, 0, 0 ,1, 5};
		double[] LIC6_Y2 = {0, 0, -2, 0, 0, 5};
		//For the 6 numpoints in LIC6_X2 and LIC6_Y2 there exist no set of 4 consecutive points such that at least one of these points lies further than 2 away from the line joining the first and last points, so LIC6 should return false.
		assert false == lic.LIC6(LIC6_X2, LIC6_Y2, 6, 4, 2) : "LIC6 (false) Failed";
	
	}
	
	public static void LIC7_test() {
	    LIC lic = new LIC();
		//k_pts = 1, length1 = 10
		double[] LIC7_X1 = {0, -1, 0, 15 ,1, 0};
		double[] LIC7_Y1 = {0, 0, -1, 0, 0,-1};
		//For the 6 numpoints in LIC7_X1 and LIC7_Y1 there exist at least one set of two points separated by exactly 1 consecutive intervening points that are further than length 10 apart, so LIC7 should return true.
		assert true == lic.LIC7(LIC7_X1, LIC7_Y1, 6, 10, 1) : "LIC7 (true) Failed";
		double[] LIC7_X2 = {0, -1, 0, 8 ,1, 0};
		double[] LIC7_Y2 = {0, 0, -1, 0, 0,-1};
		//For the 6 numpoints in LIC7_X2 and LIC7_Y2 there exist no set of two points separated by exactly 1 consecutive intervening points that are further than length 10 apart, so LIC7 should return false.
		assert false == lic.LIC7(LIC7_X2, LIC7_Y2, 6, 10, 1) : "LIC7 (false) Failed";
	
	}
	
	public static void LIC8_test() {
	    LIC lic = new LIC();
		double[] LIC8_X1 = {-1.0, 0 ,0, 0, 1.0, 0, 0};
		double[] LIC8_Y1 = {0, 0, 0, 0, 0, 0, 0};
		//For the 7 numpoints in LIC8_X1 and LIC8_Y1 there exist at least one set of three points separated by exactly 1 and 1 consecutive intervening points respectively that cannot be contained by a circle of radius 0.95, so LIC8 should return true.
		assert true == lic.LIC8(LIC8_X1, LIC8_Y1, 7, 0.95, 1, 1) : "LIC8 (true) Failed";
		double[] LIC8_X2 = {-1.0, 1.5, 0, 0, 1.0, -0.5, 0};
		double[] LIC8_Y2 = {0, 0, 0, 0, 0, 0, 0};
		//For the 7 numpoints in LIC8_X2 and LIC8_Y2 there exist no set of three points separated by exactly 1 and 1 consecutive intervening points respectively that cannot be contained by a circle of radius 1, so LIC8 should return false.
		assert false == lic.LIC8(LIC8_X2, LIC8_Y2, 7, 1.0, 1, 1) : "LIC8 (false) Failed";
	
	}
	
	public static void LIC9_test() {
	    LIC lic = new LIC();
		double[] LIC9_X1 = {0, 0, 0, 0, 1.0};
		double[] LIC9_Y1 = {0, 0, 1.0, 0, 1.0};
		//For the 5 numpoints in LIC9_X1 and LIC9_Y1 there exist at least one set of three points separated by exactly 1 and 1 consecutive intervening points respectively that form an angle that is either smaller than PI - (Math.PI/2.1) or bigger than PI + (Math.PI/2.1), so LIC9 should return true.
		assert true == lic.LIC9(LIC9_X1, LIC9_Y1, 5, Math.PI/2.1, 1, 1) : "LIC9 (true) Failed";
		double[] LIC9_X2 = {0, 0, 0, 0, 1.0};
		double[] LIC9_Y2 = {0, 0, 1.0, 0, 1.0};
		//For the 5 numpoints in LIC9_X2 and LIC9_Y2 there exist no set of three points separated by exactly 1 and 1 consecutive intervening points respectively that form an angle that is either smaller than PI - (Math.PI/2) or bigger than PI + (Math.PI/2), so LIC9 should return false.
		assert false == lic.LIC9(LIC9_X2, LIC9_Y2, 5, Math.PI/2, 1, 1) : "LIC9 (false) Failed";	
	
	}
	
	public static void LIC10_test() {
	    LIC lic = new LIC();
		double[] LIC10_X1 = {0, 0, 1.0, 0, 2.0};
		double[] LIC10_Y1 = {0, 0, 2.0, 0, 0};
		//For the 5 numpoints in LIC10_X1 and LIC10_Y1 there exist at least one set of three points separated by exactly 1 and 1 consecutive intervening points respectively that are the vertices of a triangle with area greater than 1.95, so LIC10 should return true.
		assert true == lic.LIC10(LIC10_X1, LIC10_Y1, 5, 1.95, 1, 1) : "LIC10 (true) Failed";
		double[] LIC10_X2 = {-2.0, 0, -1.0, 0, 0};
		double[] LIC10_Y2 = {0, 0, -2.0, 0, 0};
		//For the 5 numpoints in LIC10_X2 and LIC10_Y2 there exist no set of three points separated by exactly 1 and 1 consecutive intervening points respectively that are the vertices of a triangle with area greater than 2, so LIC10 should return false.
		assert false == lic.LIC10(LIC10_X2, LIC10_Y2, 5, 2.0, 1, 1) : "LIC10 (false) Failed";	
	
	}
	
	public static void LIC11_test() {
	    LIC lic = new LIC();
		double[] LIC11_X1 = {0, 1, 2, 3 ,-1, 0};
		double[] LIC11_Y1 = {0, 0, -1, 0, 0,-1};
		//For the 6 numpoints in LIC11_X1 and LIC11_Y1 there exist at least one set of two points separated by exactly 3 consecutive intervening points such that LIC11_X1[j] - LIC11_X1[i] < 0 for i < j, so LIC11 should return true.
		assert true == lic.LIC11(LIC11_X1, LIC11_Y1, 6, 3) : "LIC11 (true) Failed";
		double[] LIC11_X2 = {0, 1, 2, 3 ,4, 5};
		double[] LIC11_Y2 = {0, 0, -2, 0, 0, 5};
		//For the 6 numpoints in LIC11_X2 and LIC11_Y2 there exist no set of two points separated by exactly 1 consecutive intervening points such that LIC11_X2[j] - LIC11_X2[i] < 0 for i < j, so LIC11 should return false.
		assert false == lic.LIC11(LIC11_X2, LIC11_Y2, 6, 1) : "LIC11 (false) Failed";		
	
	}
	
	public static void LIC12_test() {
	    LIC lic = new LIC();
		//k_pts = 2, length1 = 5, length2 = 100
		double[] LIC12_X1 = {0, 1, 0, 0, 10};
		double[] LIC12_Y1 = {0, 0, 2, 0, 10};
		//For the 5 numpoints in LIC12_X1 and LIC12_Y1 there exist at least one set of two points separated by exactly 2 consecutive intervening points which are a distance greater than 5 apart and
		//there exist at least one set of two points separated by exactly 2 consecutive intervening points that are a distance less than 100 apart, so LIC12 should return true. 
		assert true == lic.LIC12(LIC12_X1, LIC12_Y1, 5, 5, 100, 2) : "LIC12 (true) Failed";
		//only greater than length1, but no two points closer than 100
		double[] LIC12_X2 = {0, 100, 200, 300, 400};
		double[] LIC12_Y2 = {0, 0, 0, 0, 0};
		//For the 5 numpoints in LIC12_X2 and LIC12_Y2 there exist no set of two points separated by exactly 2 consecutive intervening points which are a distance greater than 5 apart or
		//there exist no set of two points separated by exactly 2 consecutive intervening points that are a distance less than 100 apart, so LIC12 should return false. 
		assert false == lic.LIC12(LIC12_X2, LIC12_Y2, 5, 5, 100, 2) : "LIC12 (false) Failed";
		//only points closer than length2, but no two points further than 5
		double[] LIC12_X3 = {0, 1, 2, 3, 4};
		double[] LIC12_Y3 = {0, 0, 0, 0, 0};
		//For the 5 numpoints in LIC12_X3 and LIC12_Y3 there exist no set of two points separated by exactly 2 consecutive intervening points which are a distance greater than 5 apart or
		//there exist no set of two points separated by exactly 2 consecutive intervening points that are a distance less than 100 apart, so LIC12 should return false.
		assert false == lic.LIC12(LIC12_X3, LIC12_Y3, 5, 5, 100, 2) : "LIC12 (false) Failed";
	
	}
	
	public static void LIC13_test() {
	    LIC lic = new LIC();
		//a_pts = 1, b_pts = 1, radius1 = 10 radius2 = 100
		double[] LIC13_X1 = {0, 1, 0, 0, 10};
		double[] LIC13_Y1 = {0, 50, 2, 0, 50};
		//For the 5 numpoints in LIC13_X1 and LIC13_Y1 there exist at least one set of three points separated by exactly 1 and 1 consecutive intervening points that can not be contained by a circle of radius 10 and
		//there exist at least one set of three points separated by exactly 1 and 1 consecutive intervening points that can be contained in or on a circle of radius 100, so LIC13 should return true.		
		assert true == lic.LIC13(LIC13_X1, LIC13_Y1, 5, 10, 100, 1, 1) : "LIC13 (true) Failed";
		double[] LIC13_X2 = {2000, 0, 1, 0, 0, 1000, 5000};
		double[] LIC13_Y2 = {2000, 0, 50, 2, 0, 104, 5000};
		//For the 5 numpoints in LIC13_X2 and LIC13_Y2 there exist no set of three points separated by exactly 1 and 1 consecutive intervening points that can not be contained by a circle of radius 10 or
		//there exist no set of three points separated by exactly 1 and 1 consecutive intervening points that can be contained in or on a circle of radius 100, so LIC13 should return false.
		assert false == lic.LIC13(LIC13_X2, LIC13_Y2, 7, 10, 100, 1, 1) : "LIC13 (false) Failed";
	
	}
	
	public static void LIC14_test() {
	    LIC lic = new LIC();
		//e_pts = 1, f_pts = 1, area1 = 5 area2 = 100
		double[] LIC14_X1 = {0, 0, 4, 0, 0};
		double[] LIC14_Y1 = {0, 0, 0, 0, 5}; //area 4*5/2 = 10
		//For the 5 numpoints in LIC14_X1 and LIC14_Y1 there exist at least one set of three points separated by exactly 1 and 1 consecutive intervening points that are the vertices of a triangle with area greater than 5 and
		//there exist at least one set of three points separated by exactly 1 and 1 consecutive intervening points that are the vertices of a triangle with area less than 100, so LIC14 should return true.
		assert true == lic.LIC14(LIC14_X1, LIC14_Y1, 5, 5, 100, 1, 1) : "LIC14 (true) Failed";
		double[] LIC14_X2 = {0, 0, 4, 0, 0};
		double[] LIC14_Y2 = {0, 0, 0, 0, 500}; //area 4*500/2 = 1000
		//For the 5 numpoints in LIC14_X2 and LIC14_Y2 there exist no set of three points separated by exactly 1 and 1 consecutive intervening points that are the vertices of a triangle with area greater than 5 or
		//there exist no set of three points separated by exactly 1 and 1 consecutive intervening points that are the vertices of a triangle with area less than 100, so LIC14 should return false.
		assert false == lic.LIC14(LIC14_X2, LIC14_Y2, 5, 5, 100, 1, 1) : "LIC14 (false) Failed";
	
	}
	
	public static void CMV_test() {
		MatrixCalc matrixcalc = new MatrixCalc();
		
		
		boolean[] answer = new boolean[15];
		for (int i = 0; i < 15; i++){
			answer[i] = true;
		}
		answer[6] = false;
		answer[9] = false;
		
		double[] CMV_X1 = {0, 1, 1, -1, 3};
		double[] CMV_Y1 = {0, 0, -1, -1, -1};
		int numpoints = 5;
		double length1 = 2.9;
		double length2 = 3.5;
		double area1 = 0.95;
		double area2 = 1.05;
		double radius1 = Math.sqrt(10)/2.1;
		double radius2 = Math.sqrt(10)/1.9;
		double epsilon = Math.PI/2.1;
		double dist = 1.95;
		int a_pts, b_pts, c_pts, d_pts, e_pts, f_pts, g_pts, k_pts, n_pts, q_pts, quads;
		a_pts = b_pts = c_pts = d_pts = e_pts = f_pts = 1;
		g_pts = 2;
		k_pts = 3;
		q_pts = 5;
		n_pts = 3;
		quads = 2;

		boolean[] vector = matrixcalc.CMV(CMV_X1, CMV_Y1, numpoints, length1, length2, area1, area2,
		radius1, radius2, epsilon, dist, a_pts, b_pts, c_pts, 
		d_pts, e_pts, f_pts, g_pts, k_pts, n_pts, q_pts, quads);
		//Checks so that every LIC returns the correct answer with all the above inputs (read the specific information for each LIC in their test function). 
		for(int i = 0; i < 15; i++){
			assert vector[i] == answer[i] : String.format("CMV test: LIC %d outputed: %s, which is wrong", i, Boolean.toString(vector[i]));
		}
	}
	
	public static void PUM_test() {
		MatrixCalc matrixcalc = new MatrixCalc();
		
		boolean[] cmv_mock = new boolean[15];
		for (int i = 0; i < 15; i++){ //even indexes are true, odd indexes false
			if (i % 2 == 0) {
				cmv_mock[i] = true;
			} else {
				cmv_mock[i] = false;
			}
		}
		
		String[][] lcm_mock = new String[15][15];
		
		for (int i = 0; i < 15; i++){ //symmetrical LCM matrix, most elements are "NOTUSED"
			for (int j = 0; j < 15; j++){
				lcm_mock[i][j] = "NOTUSED";
			}
		}
		lcm_mock[0][0] = "ANDD";
		lcm_mock[1][0] = "ORR";
		lcm_mock[0][1] = "ORR";
		lcm_mock[2][0] = "ORR";
		lcm_mock[0][2] = "ORR";
		lcm_mock[1][2] = "ANDD";
		lcm_mock[2][1] = "ANDD";
		
		boolean[][] pum_mock = matrixcalc.PUM(cmv_mock, lcm_mock);
		
		//testing a handfull of values, using the three different operators and true and false cases
		assert pum_mock[0][0] == true : " PUM[0][0] (true) failed";
		assert pum_mock[5][5] == true : " PUM[5][5] (true) failed";
		assert pum_mock[0][1] == true : " PUM[0][1] (true) failed";
		assert pum_mock[1][2] == false : " PUM[1][2] (false) failed";
		assert pum_mock[2][1] == false : " PUM[2][1] (false) failed";
	}
	
	public static void FUV_test() {
		MatrixCalc matrixcalc = new MatrixCalc();
		
		boolean[][] pum_mock2 = new boolean[15][15]; 
			
		for (int i = 0; i < 15; i++){ //if i + j is even or i or j is 0 we have true, else false
			for (int j = 0; j < 15; j++){
				if ((i + j) % 2 == 0 || i == 0 || j == 0) {
					pum_mock2[i][j] = true;
				} else {
					pum_mock2[i][j] = false;
				}
			}
		}
			
		boolean[] puv_mock = {true, false, true, true, true, true, true, true, true, true, true, true, true, true, false};
		
		boolean[] fuv_mock = matrixcalc.FUV(pum_mock2, puv_mock);
		boolean[] expected_fuv = {true, true, false, false, false, false, false, false, false, false, false, false, false, false, true };
		for(int i = 0; i < 15; i++){
			assert fuv_mock[i] == expected_fuv[i] : " FUV test failed";
		}
	}
	
	public static void decide_test() {
		Decide decide = new Decide();
		
		boolean[] answer = {true, true, true, true, true, true, false, true, true, false, true, true, true, true, true};
		double[] CMV_X1 = {0, 1, 1, -1, 3};
		double[] CMV_Y1 = {0, 0, -1, -1, -1};
		int numpoints = 5;
		double length1 = 2.9;
		double length2 = 3.5;
		double area1 = 0.95;
		double area2 = 1.05;
		double radius1 = Math.sqrt(10)/2.1;
		double radius2 = Math.sqrt(10)/1.9;
		double epsilon = Math.PI/2.1;
		double dist = 1.95;
		int a_pts, b_pts, c_pts, d_pts, e_pts, f_pts, g_pts, k_pts, n_pts, q_pts, quads;
		a_pts = b_pts = c_pts = d_pts = e_pts = f_pts = 1;
		g_pts = 2;
		k_pts = 3;
		q_pts = 5;
		n_pts = 3;
		quads = 2;
		
		String[][] lcm_mock2 = new String[15][15];
		for (int i = 0; i < 15; i++){ //symmetrical LCM matrix, most elements are "NOTUSED"
			for (int j = 0; j < 15; j++){
				lcm_mock2[i][j] = "NOTUSED";
			}
		}
		lcm_mock2[0][0] = "ANDD";
		lcm_mock2[1][0] = "ORR";
		lcm_mock2[0][1] = "ORR";
		lcm_mock2[2][0] = "ORR";
		lcm_mock2[0][2] = "ORR";
		lcm_mock2[1][2] = "ANDD";
		lcm_mock2[2][1] = "ANDD";
		
		boolean[] puv_mock2 = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
		//Tests the complete system with all the above inputs (read the specific information for each LIC in their test function).
		assert decide.decide(CMV_X1, CMV_Y1, numpoints, length1, length2, area1, area2,
							radius1, radius2, epsilon, dist, a_pts, b_pts, c_pts, d_pts,
							e_pts, f_pts, g_pts, k_pts, n_pts, q_pts, quads, lcm_mock2, 
							puv_mock2) == true : "Decide test (true) failed";
	}
	
	
	
    public static void main(String[] args) {
		//To run test cases, need to add "-ea" option:
		//"java -ea DecideTest"

		//Test of LIC functionality
		
		smallestRadius_test();
		
		LIC0_test();
		LIC1_test();
		LIC2_test();
		LIC3_test();
		LIC4_test();
		LIC5_test();
		LIC6_test();
		LIC7_test();
		LIC8_test();
		LIC9_test();
		LIC10_test();
		LIC11_test();
		LIC12_test();
		LIC13_test();
		LIC14_test();
		
		//Test of MatrixCalc methods

		CMV_test();
		PUM_test();
		FUV_test();
		
		//Test of Decide method
		
		decide_test();

		System.out.println("DecideTest run successfully");
	}
}
