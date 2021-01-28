

class DecideTest {
	// File containing test cases for Decide.java
    
    public static void main(String[] args) {
		//To run test cases, need to add "-ea" option:
		//"java -ea DecideTest"

		Decide decide = new Decide();
		assert true == decide.LIC0() : "LIC0 Failed";
	}
}
