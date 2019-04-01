
public class radixSort {
	
	public static void main(String[] args) 
	{
		// initialize a new array
		int n = 1000;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = (int)(Math.random()*n);
		
		// find the exponent for the maximum value in the array
		System.out.println(getMaxDigits(arr));
		
		// print out the sorted array
		radix(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	// find the exponent for the maximum value in the array
	public static int getMaxDigits(int[] arr)
	{
		// find the maximum value of the array 'arr'
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
			if (arr[i] > max)
				max = arr[i];
		
		// find the number of digits of 'max'
		int count = 1;
		while (Math.pow(10, count) < max)
			count++;
		return count;
	}
	
	// radix sort the array
	public static void radix(int[] arr)
	{
		// initialize all the linked list buckets
		LinkedList b0 = new LinkedList();
		LinkedList b1 = new LinkedList();
		LinkedList b2 = new LinkedList();
		LinkedList b3 = new LinkedList();
		LinkedList b4 = new LinkedList();
		LinkedList b5 = new LinkedList();
		LinkedList b6 = new LinkedList();
		LinkedList b7 = new LinkedList();
		LinkedList b8 = new LinkedList();
		LinkedList b9 = new LinkedList();
		// place the linked lists b0-b9 into an array
		LinkedList[] bin = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9};
		
		int m = 10;
		int n = 1;
		int exp = getMaxDigits(arr);
		
		// loop through every place value up to 'exp'
		for (int e = 0; e < exp; e++)
		{
			for (int i = 0; i < arr.length; i++) 
			{
				// go through the array and find the value of the digit in place 'e'
				int val = (arr[i] % m) / n;
				// place the arr[i] into the corresponding bin for the round
				bin[val].insertRear(arr[i]);
			}
			
			int count = 0;
			// loop through bins 'b0' - 'b9' within 'bin'
			for (int j = 0; j < bin.length; j++)
			{
				// remove the values from the bin in order and place back into 'arr'
				while (!bin[j].isEmpty())
					arr[count++] = (int) bin[j].removeFront();
			}
			
			// increment 'm' and 'n'
			m *= 10;
			n *= 10;
		}	
	}
}
