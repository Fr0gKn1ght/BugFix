import java.util.ArrayList;
public class BinarySearcher {
	//Algorithm details found at https://www.geeksforgeeks.org/binary-search/
	//Only works with sorted arrays.
	static int binarySearch(ArrayList<Integer> array,int start,int end,int search)
	{
		//Ensures valid interval.
		if(end>=start) 
		{
			int center = start+(end-start)/2;
			
			//Element found.
			if(array.get(center)==search)
				return center;
			
			//Element right of center
			if(array.get(center) > search)
				return binarySearch(array,start,center-1,search);
			//Element left of center
			else
				return binarySearch(array,center+1,end,search);
		}
		
		return -1; //element not found
	}
}
