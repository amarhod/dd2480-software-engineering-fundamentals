

class DecideTest {
	// File containing test cases for Decide.java
    
    public static void main(String[] args) {
		//To run test cases, need to add "-ea" option:
		//"java -ea DecideTest"

		Decide decide = new Decide();
		double[] X1 = {0.23, 6.51};
		double[] Y1 = {1.31, 2.20};
		assert true == decide.LIC0(X1, Y1, 2, 4.4) : "LIC0 (true) Failed";
		double[] X2 = {0.23, 1.51};
		double[] Y2 = {1.31, 2.20};
		assert false == decide.LIC0(X2, Y2, 2, 1.56) : "LIC0 (false) Failed";	

		double[] LIC1_X1 = {-1.0, 0.0, 1.0};
		double[] LIC1_Y1 = {0, 0, 0};
		assert true == decide.LIC1(LIC1_X1, LIC1_Y1, 3, 0.95) : "LIC1 (true) Failed";
		double[] LIC1_X2 = {-1.0, 0.0, 1.0};
		double[] LIC1_Y2 = {0, 0, 0};
		assert false == decide.LIC1(LIC1_X2, LIC1_Y2, 3, 1.0) : "LIC1 (false) Failed";	

		double[] LIC4_X1 = {0, -1, 0, 0 ,1, 1};
		double[] LIC4_Y1 = {0, 0, -1, 1, 0,-1};
		assert true == decide.LIC4(LIC4_X1, LIC4_Y1, 5, 3) : "LIC4 (true) Failed";
		double[] LIC4_X2 = {0, 1, 0, 2 ,1, 1};
		double[] LIC4_Y2 = {0, 0, -1, 2, 0,-1};
		assert false == decide.LIC4(LIC4_X2, LIC4_Y2, 5, 3) : "LIC4 (false) Failed";
		


		double[] LIC8_X1 = {-1.0, 0.0 ,0.0, 0.0, 1.0, 0.0, 0.0};
		double[] LIC8_Y1 = {0, 0, 0, 0, 0, 0, 0};
		assert true == decide.LIC8(LIC8_X1, LIC8_Y1, 7, 0.95, 1, 1) : "LIC8 (true) Failed";
		double[] LIC8_X2 = {-1.0, 1.5 ,0.0, 0.0, 1.0, -0.5, 0.0};
		double[] LIC8_Y2 = {0, 0, 0, 0, 0, 0, 0};
		assert false == decide.LIC8(LIC8_X2, LIC8_Y2, 7, 1.0, 1, 1) : "LIC8 (false) Failed";	
	}
}
