

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
	}
}
