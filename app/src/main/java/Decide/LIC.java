package Decide;

import java.awt.geom.Point2D;
import java.util.*;


public class LIC {
    //Class with all the Launch Interceptor Program (LIC) tests needed for the Decide class

	
	public double smallestRadius(double x1, double y1, double x2, double y2, double x3, double y3) {
		//helper function that returns the smallest possible circle that contains three points in euclidean space
		
		double radiusAcute; //the smallest radius if the triangle is acute
		double radiusObtuse; // the smallest radius if the triangle is obtuse
		
		//circumcenter, center of the smallest radius for acute triangles
		// https://en.wikipedia.org/wiki/Circumscribed_circle
		
		double d = 2*(x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2));
		double ux = (1/d) * ( (x1*x1 + y1*y1)*(y2 - y3) + (x2*x2 + y2*y2)*(y3 - y1) + (x3*x3 + y3*y3)*(y1 - y2) );
		double uy = (1/d) * ( (x1*x1 + y1*y1)*(x3 - x2) + (x2*x2 + y2*y2)*(x1 - x3) + (x3*x3 + y3*y3)*(x2 - x1) );
		
		radiusAcute = Point2D.distance(x1,y1,ux,uy); 
		
		//calculate the point between the two points with longest distance between them
		double cx;
		double cy;
		
		double dist12 = Point2D.distance(x1,y1,x2,y2);
		double dist13 = Point2D.distance(x1,y1,x3,y3);
		double dist23 = Point2D.distance(x2,y2,x3,y3);
		
		if (dist12 >= dist13 && dist12 >= dist23) {
			cx = (x1 + x2)*0.5;
			cy = (y1 + y2)*0.5;
			radiusObtuse = Point2D.distance(x1,y1,cx,cy);
		} else if (dist13 >= dist12 && dist13 >= dist23) {
			cx = (x1 + x3)*0.5;
			cy = (y1 + y3)*0.5;
			radiusObtuse = Point2D.distance(x1,y1,cx,cy);
		} else {
			cx = (x2 + x3)*0.5;
			cy = (y2 + y3)*0.5;
			radiusObtuse = Point2D.distance(x2,y2,cx,cy);
		}
		//obtuse angle test, a^2 + b^2 < c^2
		if (dist12*dist12 + dist13*dist13 < dist23*dist23 || dist23*dist23 + dist13*dist13 < dist12*dist12 || dist12*dist12 + dist23*dist23 < dist13*dist13) {
			return radiusObtuse;
		}
		return radiusAcute;
	}

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

			if(smallestRadius(x1,y1,x2,y2,x3,y3) > radius1){return true;}

		}
		return false;
	}

	public boolean LIC2(double[] X, double[] Y, int numpoints, double epsilon) {
		// pi - epsilon < Angle between any three points < pi + epsilon
		double x1, y1, x2, y2, x3, y3, angle;
		for(int i = 2; i < numpoints; i++){
			x1 = X[i-2];
			y1 = Y[i-2];
			x2 = X[i-1];
			y2 = Y[i-1];
			x3 = X[i];
			y3 = Y[i];
			
			angle = (Math.toDegrees(Math.atan2(y1-y2, x1-x2) - Math.atan2(y3-y2, x3-x2)) + 360) % 360;	
			
			//If P1 or P3 is equal to P2 there is no angle
			if (!((x1 == x2 && y1 == y2) || (x3 == x2 && y3 == y2))) {
				if(angle < Math.toDegrees(Math.PI - epsilon) || angle > Math.toDegrees(Math.PI + epsilon)){
					return true;
				}
			}
		}
		return false;
	}

	//There exists at least one set of three consecutive data points that are the vertices of a triangle with area greater than AREA1
	public boolean LIC3(double[] X, double[] Y, int numpoints, double area1) {
		double x1, y1, x2, y2, x3, y3, area;
		for(int i = 2; i < numpoints; i++){
			x1 = X[i-2];
			y1 = Y[i-2];
			x2 = X[i-1];
			y2 = Y[i-1];
			x3 = X[i];
			y3 = Y[i];
			area = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
			
			//System.out.println(area);
			
			if(area > area1){
				return true;
			}
		}
		return false;
	}

	public boolean LIC4(double[] X, double[] Y, int numpoints, int q_pts, int quads) {
		//There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i<numpoints; i++) {
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

	public boolean LIC5(double[] X, double[] Y, int numpoints) {
		//There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1)
		double x1, x2, diff;
		for (int i = 0; i < numpoints-1; i++) {
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
	public boolean LIC6(double[] X, double[] Y, int numpoints, int n_pts, double dist) {
		Queue Xqueue = new LinkedList();
		Queue Yqueue = new LinkedList();
		double[] Xarray = new double[n_pts];
		double[] Yarray = new double[n_pts];
		
		for(int i = 0; i<numpoints; i++) {
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

	public boolean LIC7(double[] X, double[] Y, int numpoints, double length1, int k_pts) {
		// there exists a set of two points seperated by K_PTS consecutive points with distance > length1
		
		double x1, y1, x2, y2;
		
		for (int i = 0; i < numpoints - k_pts - 1; i++) {
			x1 = X[i];
			y1 = Y[i];
			x2 = X[i + k_pts + 1];
			y2 = Y[i + k_pts + 1];
			
			if (Point2D.distance(x1,y1,x2,y2) > length1) {
				return true;
			}
		}
		
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

			if(smallestRadius(x1,y1,x2,y2,x3,y3) > radius1){return true;}

		}
		return false;
	}

	public boolean LIC9(double[] X, double[] Y, int numpoints, double epsilon, int c_pts, int d_pts) {
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
			if((angle < Math.toDegrees(Math.PI - epsilon)) || (angle > Math.toDegrees(Math.PI + epsilon))){return true;}
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
	
	// There exists a set of two points seperated by G_PTS x[i + G_PTS] - x[i] < 0
	public boolean LIC11(double[] X, double[] Y, int numpoints, int g_pts) {
		double x1, x2;
		
		//If NUMPOINTS < 3 the condition is false
		if (numpoints < 3) {
			return false;
		}
		
		//System.out.println(Arrays.toString(X));
		
		for (int i = 0; i < numpoints - g_pts - 1; i++) {
			x1 = X[i];
			x2 = X[i + g_pts + 1];
			
			//System.out.println("x1: " +x1 +" x2: "+ x2);
			if ((x2-x1) < 0) {
				return true;
			}
		}
		return false;
	}

	public boolean LIC12(double[] X, double[] Y, int numpoints, double length1, double length2, int k_pts) {
		// There exists a set of two points seperated by K_PTS which are distance greater than LENGTH1
		// AND one set of two points (may be a different set) such that they are a distance less than LENGTH2
		
		boolean firstCond = false; //both these conditions need to be true for the LIC
		boolean secondCond = false; 
		double x1, y1, x2, y2, distance;
		
		for (int i = 0; i < numpoints - k_pts - 1; i++) {
			x1 = X[i];
			y1 = Y[i];
			x2 = X[i + k_pts + 1];
			y2 = Y[i + k_pts + 1];
			
			distance = Point2D.distance(x1,y1,x2,y2);
			
			if (distance > length1) {
				firstCond = true;
			}
			if (distance < length2) {
				secondCond = true;
			}
		}
		
		if (firstCond && secondCond) {
			return true;
		}
		
		return false;
	}

	public boolean LIC13(double[] X, double[] Y, int numpoints, double radius1, double radius2, int a_pts, int b_pts) {
		// There exists a set of three points seperated by A_PTS and B_PTS that can not be contained in a circle of radius1
		// AND one set of three points (may be a different set) such that the can be contained in or on the radius of a circle of radius2
		
		boolean firstCond = false; //both these conditions need to be true for the LIC
		boolean secondCond = false; 
		double x1, y1, x2, y2, x3, y3;
		
		for (int i = 0; i < numpoints - a_pts - b_pts - 2; i++) {
			x1 = X[i];
			y1 = Y[i];
			x2 = X[i + a_pts + 1];
			y2 = Y[i + a_pts + 1];
			x3 = X[i+ a_pts + b_pts + 2];
			y3 = Y[i+ a_pts + b_pts + 2];
			

			
			if (smallestRadius(x1,y1,x2,y2,x3,y3) > radius1) {
				firstCond = true;
			}
			if (smallestRadius(x1,y1,x2,y2,x3,y3) < radius2) {
				secondCond = true;
			}
		}
		
		if (firstCond && secondCond) {
			return true;
		}
	
		return false;
	}

	public boolean LIC14(double[] X, double[] Y, int numpoints, double area1, double area2, int e_pts, int f_pts) {
		// There exists one set of three points seperated by E_PTS and F_PTS that form a  triangle with area > area1
		// AND one set of three points (may be a different set) that form a triangle < area2
		
		boolean firstCond = false; //both these conditions need to be true for the LIC
		boolean secondCond = false; 
		double x1, y1, x2, y2, x3, y3, area;
		
		for (int i = 0; i < numpoints - e_pts - f_pts - 2; i++) {
			x1 = X[i];
			y1 = Y[i];
			x2 = X[i + e_pts + 1];
			y2 = Y[i + e_pts + 1];
			x3 = X[i+ e_pts + f_pts + 2];
			y3 = Y[i+ e_pts + f_pts + 2];
			
			area = (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
			
			if (area > area1) {
				firstCond = true;
			}
			if (area < area2) {
				secondCond = true;
			}
		}
		
		if (firstCond && secondCond) {
			return true;
		}
		
		return false;
	}
}
