

class DecideTest {
	// File containing test cases for Decide.java
    
    public static void main(String[] args) {
		//To run test cases, need to add "-ea" option:
		//"java -ea DecideTest"

		Decide decide = new Decide();
		
		//smallestRadius test
		//obtuse case
		double smallest = decide.smallestRadius(0,0,50,10,100,0);
		assert ( smallest <= 50.1 && smallest >= 49.9) : "smallest radius not within expected range for obtuse case";
		//acute case
		smallest = decide.smallestRadius(0,0,1,2,2,0);
		assert ( smallest <= 1.26 && smallest >= 1.24) : "smallest radius not within expected range for acute case";
		
		//LIC0
		double[] X1 = {0.23, 6.51};
		double[] Y1 = {1.31, 2.20};
		assert true == decide.LIC0(X1, Y1, 2, 4.4) : "LIC0 (true) Failed";
		double[] X2 = {0.23, 1.51};
		double[] Y2 = {1.31, 2.20};
		assert false == decide.LIC0(X2, Y2, 2, 1.56) : "LIC0 (false) Failed";	
		
		//LIC1
		double[] LIC1_X1 = {-1.0, 0.0, 1};
		double[] LIC1_Y1 = {0, 0, 0};
		assert true == decide.LIC1(LIC1_X1, LIC1_Y1, 3, 0.95) : "LIC1 (true) Failed";
		double[] LIC1_X2 = {-1.0, 0.0, 1.0};
		double[] LIC1_Y2 = {0, 0, 0};
		assert false == decide.LIC1(LIC1_X2, LIC1_Y2, 3, 1.0) : "LIC1 (false) Failed";	
		
		//LIC2
		//angle less than pi - epsilon = 90 degrees
		double[] LIC2_X1 = {0, 1, 0.5};
		double[] LIC2_Y1 = {0, 0, 1};
		assert true == decide.LIC2(LIC2_X1, LIC2_Y1, 3, Math.PI/2) : "LIC2 (true, angle < 90) Failed";
		//angle more than pi + epsilon = 270 degrees
		double[] LIC2_X2 = {0, 1, 0.5};
		double[] LIC2_Y2 = {0, 0, -1};
		assert true == decide.LIC2(LIC2_X2, LIC2_Y2, 3, Math.PI/2) : "LIC2 (true, angle > 270) Failed";
		//angles between 90 and 270
		double[] LIC2_X3 = {0, 1, 2, 3};
		double[] LIC2_Y3 = {0, 0, 2, 2};
		assert false == decide.LIC2(LIC2_X3, LIC2_Y3, 4, Math.PI/2) : "LIC2 (false) Failed";
		
		//LIC3
		double[] LIC3_X1 = {0, 0, 0, 0 ,3, 0};
		double[] LIC3_Y1 = {0, 0, 0, 1, 0, 6};
		assert true == decide.LIC3(LIC3_X1, LIC3_Y1, 6, 3) : "LIC3 (true) Failed";
		double[] LIC3_X2 = {0, -1, 0, 0 ,1, 1};
		double[] LIC3_Y2 = {0, 0, -1, 1, 0,-1};
		assert false == decide.LIC3(LIC3_X2, LIC3_Y2, 6, 3) : "LIC3 (false) Failed";
		
		//LIC4
		double[] LIC4_X1 = {0, -1, 0, 0 ,1, 1};
		double[] LIC4_Y1 = {0, 0, -1, 1, 0,-1};
		assert true == decide.LIC4(LIC4_X1, LIC4_Y1, 6, 5, 3) : "LIC4 (true) Failed";
		double[] LIC4_X2 = {0, 1, 0, 2 ,1, 1};
		double[] LIC4_Y2 = {0, 0, -1, 2, 0,-1};
		assert false == decide.LIC4(LIC4_X2, LIC4_Y2, 6, 5, 3) : "LIC4 (false) Failed";
	    
	    //LIC5
		double[] LIC5_X1 = {0, -1, 0};
		double[] LIC5_Y1 = {0, 0, 0};
		assert true == decide.LIC5(LIC5_X1, LIC5_Y1, 3) : "LIC5 (true) Failed";
		double[] LIC5_X2 = {0, 1, 2};
		double[] LIC5_Y2 = {0, 0, 0};
		assert false == decide.LIC5(LIC5_X2, LIC5_Y2, 3) : "LIC5 (false) Failed";	
		
		//LIC6
		double[] LIC6_X1 = {0, -1, 0, 0 ,1, 0};
		double[] LIC6_Y1 = {0, 0, -1, 0, 0,-1};
		assert true == decide.LIC6(LIC6_X1, LIC6_Y1, 6, 4, 1.25) : "LIC6 (true) Failed";
		double[] LIC6_X2 = {0, 0, 0, 0 ,1, 5};
		double[] LIC6_Y2 = {0, 0, -2, 0, 0, 5};
		assert false == decide.LIC6(LIC6_X2, LIC6_Y2, 6, 4, 2) : "LIC6 (false) Failed";
		
		//LIC7
		//k_pts = 1, length1 = 10
		double[] LIC7_X1 = {0, -1, 0, 15 ,1, 0};
		double[] LIC7_Y1 = {0, 0, -1, 0, 0,-1};
		assert true == decide.LIC7(LIC7_X1, LIC7_Y1, 6, 10, 1) : "LIC7 (true) Failed";
		double[] LIC7_X2 = {0, -1, 0, 8 ,1, 0};
		double[] LIC7_Y2 = {0, 0, -1, 0, 0,-1};
		assert false == decide.LIC7(LIC7_X2, LIC7_Y2, 6, 10, 1) : "LIC7 (false) Failed";
		
		
		//LIC8
		double[] LIC8_X1 = {-1.0, 0 ,0, 0, 1.0, 0, 0};
		double[] LIC8_Y1 = {0, 0, 0, 0, 0, 0, 0};
		assert true == decide.LIC8(LIC8_X1, LIC8_Y1, 7, 0.95, 1, 1) : "LIC8 (true) Failed";
		double[] LIC8_X2 = {-1.0, 1.5, 0, 0, 1.0, -0.5, 0};
		double[] LIC8_Y2 = {0, 0, 0, 0, 0, 0, 0};
		assert false == decide.LIC8(LIC8_X2, LIC8_Y2, 7, 1.0, 1, 1) : "LIC8 (false) Failed";
		
		//LIC9
		double[] LIC9_X1 = {0, 0, 0, 0, 1.0};
		double[] LIC9_Y1 = {0, 0, 1.0, 0, 1.0};
		assert true == decide.LIC9(LIC9_X1, LIC9_Y1, 5, Math.PI/2.1, 1, 1) : "LIC9 (true) Failed";
		double[] LIC9_X2 = {0, 0, 0, 0, 1.0};
		double[] LIC9_Y2 = {0, 0, 1.0, 0, 1.0};
		assert false == decide.LIC9(LIC9_X2, LIC9_Y2, 5, Math.PI/2, 1, 1) : "LIC9 (false) Failed";	

		//LIC10
		double[] LIC10_X1 = {0, 0, 1.0, 0, 2.0};
		double[] LIC10_Y1 = {0, 0, 2.0, 0, 0};
		assert true == decide.LIC10(LIC10_X1, LIC10_Y1, 5, 1.95, 1, 1) : "LIC10 (true) Failed";
		double[] LIC10_X2 = {-2.0, 0, -1.0, 0, 0};
		double[] LIC10_Y2 = {0, 0, -2.0, 0, 0};
		assert false == decide.LIC10(LIC10_X2, LIC10_Y2, 5, 2.0, 1, 1) : "LIC10 (false) Failed";	
		
		//LIC11
		double[] LIC11_X1 = {0, 1, 2, 3 ,-1, 0};
		double[] LIC11_Y1 = {0, 0, -1, 0, 0,-1};
		assert true == decide.LIC11(LIC11_X1, LIC11_Y1, 6, 3) : "LIC11 (true) Failed";
		double[] LIC11_X2 = {0, 1, 2, 3 ,4, 5};
		double[] LIC11_Y2 = {0, 0, -2, 0, 0, 5};
		assert false == decide.LIC11(LIC11_X2, LIC11_Y2, 6, 1) : "LIC11 (false) Failed";		

		//LIC12
		//k_pts = 2, length1 = 5, length2 = 100
		double[] LIC12_X1 = {0, 1, 0, 0, 10};
		double[] LIC12_Y1 = {0, 0, 2, 0, 10};
		assert true == decide.LIC12(LIC12_X1, LIC12_Y1, 5, 5, 100, 2) : "LIC12 (true) Failed";
		//only greater than length1, but no two points closer than 100
		double[] LIC12_X2 = {0, 100, 200, 300, 400};
		double[] LIC12_Y2 = {0, 0, 0, 0, 0};
		assert false == decide.LIC12(LIC12_X2, LIC12_Y2, 5, 5, 100, 2) : "LIC12 (false) Failed";
		//only points closer than length2, but no two points further than 5
		double[] LIC12_X3 = {0, 1, 2, 3, 4};
		double[] LIC12_Y3 = {0, 0, 0, 0, 0};
		assert false == decide.LIC12(LIC12_X3, LIC12_Y3, 5, 5, 100, 2) : "LIC12 (false) Failed";
		
		//LIC13
		//a_pts = 1, b_pts = 1, radius1 = 10 radius2 = 100
		double[] LIC13_X1 = {0, 1, 0, 0, 10};
		double[] LIC13_Y1 = {0, 50, 2, 0, 50};
		assert true == decide.LIC13(LIC13_X1, LIC13_Y1, 5, 10, 100, 1, 1) : "LIC13 (true) Failed";
		double[] LIC13_X2 = {2000, 0, 1, 0, 0, 1000, 5000};
		double[] LIC13_Y2 = {2000, 0, 50, 2, 0, 104, 5000};
		assert false == decide.LIC13(LIC13_X2, LIC13_Y2, 7, 10, 100, 1, 1) : "LIC13 (false) Failed";
		
		//LIC14
		//e_pts = 1, f_pts = 1, area1 = 5 area2 = 100
		double[] LIC14_X1 = {0, 0, 4, 0, 0};
		double[] LIC14_Y1 = {0, 0, 0, 0, 5}; //area 4*5/2 = 10
		assert true == decide.LIC14(LIC14_X1, LIC14_Y1, 5, 5, 100, 1, 1) : "LIC14 (true) Failed";
		double[] LIC14_X2 = {0, 0, 4, 0, 0};
		double[] LIC14_Y2 = {0, 0, 0, 0, 500}; //area 4*500/2 = 1000
		assert false == decide.LIC14(LIC14_X2, LIC14_Y2, 5, 5, 100, 1, 1) : "LIC14 (false) Failed";
		
	}
}
