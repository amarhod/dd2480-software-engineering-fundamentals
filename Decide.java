import java.awt.geom.Point2D;
import java.util.*;


class Decide {
    //Program for deciding hypothetical anti-ballistic missile system
    //Call method decide with appropriate input to decide to send an interceptor or not.
	
	
	//Global variables
	int NUMPOINTS = 3;
	double[] X = {0.23, 6.51, 0.15};
	double[] Y = {1.31, 2.20, 1.3};
	double LENGTH1 = 2.0;
	double AREA1 = 6.6;
	int PI = 180;
	int EPSILON = 90;

    //LIC conditions
    public boolean LIC0(double[] X, double[] Y, int numpoints, double length1) {
		//There exists at least one set of two consecutive data points that are a distance 
		//greater than the length, LENGTH1, apart.
		double x1, y1, x2, y2, dist;
		for(int i = 1; i < numpoints; i++){
			x1 = X[i-1];
			y1 = Y[i-1];
			x2 = X[i];
			y2 = Y[i];
			dist = Point2D.distance(x1,y1,x2,y2);
			if(dist > length1){return true;}
		}
		return false;
	}

	public boolean LIC1(double[] X, double[] Y, int numpoints, double radius1) {
		//There exists at least one set of three consecutive data points that cannot all be contained 
		//within or on a circle of radius RADIUS1.
		double x1, y1, x2, y2, x3, y3;
		double[] dists = new double[3];
		for(int i = 2; i < numpoints; i++){
			x1 = X[i-2];
			y1 = Y[i-2];
			x2 = X[i-1];
			y2 = Y[i-1];
			x3 = X[i];
			y3 = Y[i];
			dists[0] = Point2D.distance(x1,y1,x2,y2);
			dists[1] = Point2D.distance(x1,y1,x3,y3);
			dists[2] = Point2D.distance(x2,y2,x3,y3);
			for(double dist: dists){
				if(dist/2 > radius1){return true;}
			}
		}
		return false;
	}

	public boolean LIC2(double[] X, double[] Y, int numpoints, double pi, double epsilon) {
		// pi - epsilon < Angle between any three points < pi + epsilon
		double x1, y1, x2, y2, x3, y3, angle;
		for(int i = 2; i < numpoints; i++){
			x1 = X[i-2];
			y1 = Y[i-2];
			x2 = X[i-1];
			y2 = Y[i-1];
			x3 = X[i];
			y3 = Y[i];
			
			angle = Math.toDegrees((Math.atan2(y1-y2, x1-x2) - Math.atan2(y3-y2, x3-x2)));
			
			if (angle < 0) {
				angle += 360;
			}
			if (angle > 180) {
				angle = 360-angle;
			}
			
			System.out.println(angle);
			
			//If P1 or P3 is equal to P2 there is no angle
			if (!((x1 == x2 && y1 == y2) || (x3 == x2 && y3 == y2))) {
				if(angle < (pi-epsilon) || angle > pi+epsilon ){
					return true;
				}
			}
		}
		return false;
	}

	public boolean LIC3() {
		//There exists at least one set of three consecutive data points that are the vertices of a triangle
		//with area greater than AREA1
		double x1, y1, x2, y2, x3, y3, area;
		for(int i = 2; i < NUMPOINTS; i++){
			x1 = X[i-2];
			y1 = Y[i-2];
			x2 = X[i-1];
			y2 = Y[i-1];
			x3 = X[i];
			y3 = Y[i];
			area = (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
			
			//System.out.println(area);
			
			if(area > AREA1){
				return true;
			}
		}
		return false;
	}

	public boolean LIC4(double[] X, double[] Y, int q_pts, int quads) {
		//There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i<X.length; i++) {
			double x1 = X[i];
			double y1 = Y[i];
			
			if (x1 > 0) {
		        if (y1 >= 0){
		        	queue.add(1);
		        }
	        	else{
	        		queue.add(4);
	        	}
	        }
		    else if (x1 < 0){
		        if (y1 >= 0){
		        	queue.add(2);
		        }
		        else{
		        	queue.add(3);
		        }
			}
		    else {
		    	if (y1 >= 0){
		    		queue.add(1);
		        }
	        	else{
	        		queue.add(3);
	        	}
		    }
			
			if (queue.size() > q_pts){
				queue.poll();
			}
			//System.out.println("Quadrants are: "+queue.toString());
			//System.out.println("Unique count: "+queue.stream().distinct().count());
			if(queue.stream().distinct().count() > quads) {
				return true;
			}
		}
			
		return false;
	}

	public boolean LIC5(double[] X, double[] Y) {
		//There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1)
		double x1, x2, diff;
		for (int i = 0; i < NUMPOINTS; i++) {
			x1 = X[i];
			x2 = X[i+1];
		        diff = x2 - x1;

		        if(diff < 0){
				return true;
			}
		}
		return false;
	}
	
	//one point is further away than the distance between the first and the last point in any sequence of points.
	public boolean LIC6(double[] X, double[] Y, int n_pts, double dist) {
		Queue Xqueue = new LinkedList();
		Queue Yqueue = new LinkedList();
		double[] Xarray = new double[n_pts];
		double[] Yarray = new double[n_pts];
		
		for(int i = 0; i<X.length; i++) {
			Xqueue.add(X[i]);
			Yqueue.add(Y[i]);
			
			if (Xqueue.size() > n_pts){
				Xqueue.poll();
				Yqueue.poll();
			}
			
			if (Xqueue.size() == n_pts) {
				
				Queue Xtemp = new LinkedList<>(Xqueue);
				Queue Ytemp = new LinkedList<>(Yqueue);
				
				for (int ii = 0; ii<n_pts; ii++) {
					Xarray[ii] = (double) Xtemp.poll();
					Yarray[ii] = (double) Ytemp.poll();
				}
				
				double x1 = Xarray[0];
				double y1 = Yarray[0];
				double x2 = Xarray[n_pts-1];
				double y2 = Yarray[n_pts-1];
				double x, y, A, B, C, D, E, F, dot, len_sq, thisDist;
				
				if (x1 == x2 && y1 == y2) {
					for (int ii = 1; ii< n_pts-1; ii++) {
						
						x = Xarray[ii];
						y = Yarray[ii];
						
				        thisDist = Math.sqrt(Math.pow(x1-x, 2)+Math.pow(y1-y, 2));
						
				        //System.out.println(""+Xqueue.toString());
				        //System.out.println(""+Yqueue.toString());
				        //System.out.println("Is the distance: "+ thisDist+" bigger than our target? "+dist);
						
						if(thisDist > dist) {
							return true;
						}
					}
				}
				else {
					for (int ii = 1; ii< n_pts-1; ii++) {
						
						x = Xarray[ii];
						y = Yarray[ii];
				
				        A = x - x1; 
				        B = y - y1;
				        C = x2 - x1; 
				        D = y2 - y1;
				        E = -D;
				        F = C;
				        dot = A * E + B * F;
				        len_sq = E * E + F * F;
				        
				        thisDist = Math.abs(dot) / Math.sqrt(len_sq);
						
				        //System.out.println(""+Xqueue.toString());
				        //System.out.println(""+Yqueue.toString());
				        //System.out.println("Is the distance: "+ thisDist+" bigger than our target? "+dist);
						
						if(thisDist > dist) {
							return true;
						}
					}
				}
			}
		}
				
		return false;
	}

	public boolean LIC7() {
		// K_PTS consecutive points with distance > length1
		return false;
	}

	public boolean LIC8(double[] X, double[] Y, int numpoints, double radius1, int a_pts, int b_pts) {
		// There exists three data points seperated by A_PTS and B_PTS not within a circle of radius1
		if(numpoints < 5){return false;}
		double x1, y1, x2, y2, x3, y3;
		double[] dists = new double[3];
		for(int i = 0; i < numpoints-a_pts-b_pts-2; i++){
			x1 = X[i];
			y1 = Y[i];
			x2 = X[i+a_pts+1];
			y2 = Y[i+a_pts+1];
			x3 = X[i+a_pts+b_pts+2];
			y3 = Y[i+a_pts+b_pts+2];
			dists[0] = Point2D.distance(x1,y1,x2,y2);
			dists[1] = Point2D.distance(x1,y1,x3,y3);
			dists[2] = Point2D.distance(x2,y2,x3,y3);
			for(double dist: dists){
				if(dist/2 > radius1){return true;}
			}
		}
		return false;
	}

	public boolean LIC9(double[] X, double[] Y, int numpoints, double epilson, int c_pts, int d_pts) {
		// There exists three points seperated by C_PTS and D_PTS apart which have pi - epsilon < angle < pi + epsilon
		if(numpoints < 5){return false;}
		double x1, y1, x2, y2, x3, y3, angle;
		for(int i = 0; i < numpoints-c_pts-d_pts-2; i++){
			x1 = X[i];
			y1 = Y[i];
			x2 = X[i+c_pts+1];
			y2 = Y[i+c_pts+1];
			x3 = X[i+c_pts+d_pts+2];
			y3 = Y[i+c_pts+d_pts+2];
			angle = (Math.toDegrees((Math.atan2(y1-y2, x1-x2) - Math.atan2(y3-y2, x3-x2))) + 360) % 360;
			if((angle < Math.toDegrees(Math.PI - epilson)) || (angle > Math.toDegrees(Math.PI + epilson))){return true;}
		}
		return false;
	}

	public boolean LIC10(double[] X, double[] Y, int numpoints, double area1, int e_pts, int f_pts) {
		// There exists three points seperated by E_PTS and F_PTS which form a triangle with area > area1
		if(numpoints < 5){return false;}
		double x1, y1, x2, y2, x3, y3, area;
		for(int i = 0; i < numpoints-e_pts-f_pts-2; i++){
			x1 = X[i];
			y1 = Y[i];
			x2 = X[i+e_pts+1];
			y2 = Y[i+e_pts+1];
			x3 = X[i+e_pts+f_pts+2];
			y3 = Y[i+e_pts+f_pts+2];
			area = Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2);
			if(area > area1){return true;}
		}
		return false;
	}

	public boolean LIC11() {
		// There exists a set of two points seperated by G_PTS x[i + G_PTS] - x[i] < 0
		return false;
	}

	public boolean LIC12() {
		// There exists a set of two points seperated by K_PTS which are distance greater than LENGTH1
		// AND one set of two points (may be a different set) such that they are a distance less than LENGTH2
		return false;
	}

	public boolean LIC13() {
		// There exists a set of three points seperated by A_PTS and B_PTS that can not be contained in a circle of radius1
		// AND one set of three points (may be a different set) such that the can be contained in or on the radius of a circle of radius2
		return false;
	}

	public boolean LIC14() {
		// There exists one set of three points seperated by E_PTS and F_PTS that form a  triangle with area > area1
		// AND one set of three points (may be a different set) that form a triangle < area2
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
