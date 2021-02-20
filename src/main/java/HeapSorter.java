import java.util.ArrayList;


//Algorithm details found at https://www.geeksforgeeks.org/heap-sort/
public class HeapSorter {
	static void heapify(ArrayList<Integer> array, int size, int idx)
	{
		int largest = idx;
		int left = 2*idx+1;
		int right = 2*idx+2;
		
		if(left<size&&array.get(left)>array.get(largest))
			largest = left;
		if(right<size&&array.get(right)>array.get(largest))
			largest = right;
		
		if(largest!=idx)
		{
			swap(array,idx,largest);
			heapify(array,size,largest);
		}
	}
	
	static void sort(ArrayList<Integer> array)
	{
		for(int i = array.size()/2-1;i>=0;i--)
			heapify(array,array.size(),i);
		
		for(int i = array.size()-1; i>=0;i--)
		{
			swap(array,0,i);
			heapify(array,i,0);
		}
	}
	
	static void swap(ArrayList<Integer>array,int id1, int id2)
	{
		int tmp = array.get(id1);
		array.set(id1, array.get(id2));
		array.set(id2, tmp);
	}

}
