//\Rami_AboRabia

package algo_ass2;
import java.lang.Math;
import java.util.ArrayList;

public class algo_ass2 {
	
	public static int find_dist(int start, int h) {
		int dist = 0;
		while (start + dist < h) { //complexity of the resault
			start += dist; //1+2+3+4....+res
			dist++;
		}	//a0 = max num of throws
		return dist;
	}
			

	public static void q1_c(int h, int attempts, int msh) { //msh- max survival hight
		if (msh > h || msh < 0) {
			System.out.println("msh (max survival hight) can't be greater h or negetive");
			return;
		}
		if (attempts < 1 ) {
			System.out.println("need more attempts");
			return;
		}
		boolean found = false;
		int max = h+1;
		int min = 0;
		int start = 0;
		int mid = h/2;
		ArrayList <Integer> arr = new ArrayList<Integer>();
		while (attempts > 2 ) { //binary search
			if (min + 1 == max) { // min is the msh, found it!
				found = true;
				//System.out.println("found by binary search");
				break;
			}
			if (mid != 0) {
				arr.add(mid);
				}
			if (mid <= msh) {
				if (mid == max -1) {//mid is the msh, found it!
					found = true;
					//System.out.println("found by binary search");
					break;
				}
				min = mid;
				start = mid+1;
				mid = ( start + max ) / 2;
			} else { // mid > msh
				attempts--;
				max = mid;
				mid = ( start + max ) / 2;
			}
		}// while bin search -  ends
		
		if (!(found)) {
			int dist = find_dist(start, max-1);
			while ( attempts > 1 ) { 					//iterative search (n,n-1,...,1)
				if  ( start + dist < max && start + dist != 0) {
					arr.add(start + dist);
				}
				if (start + dist <= msh ) {
					if (start + dist == max -1) {
						found = true;
						//System.out.println("found by iterative search");
						break;
					}
					min = start + dist;
					start += dist;
					dist--;
				} else { //start + dist > msh
					attempts--;
					max = Math.min(max, start + dist);
				}
		}//while iterative search loop
	}// if found
	if (!found) {
		if (start == min) {
			start++;
		}
		while (start < max) { //linear search
			arr.add(start);
			if (start <= msh ) {
				start++;
			} else {
				//System.out.println("found by linear search");
				break;
			}
		}
	}
	System.out.println(arr);
	}
	

public static void main(String[] args) {
	q1_c(200,2,199); //  enter q1_c(max_height , num_of_vehicle , max survival height) 
	
}


}
