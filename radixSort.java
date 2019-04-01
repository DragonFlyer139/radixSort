
public class radixSort {
	
	public static void main(String[] args) 
	{
		int[] arr = {24234, 113234125, 46, 4234, 634, 12, 6543};
		System.out.println(getMaxDigits(arr));
		
		radix(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static int getMaxDigits(int[] arr)
	{
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
			if (arr[i] > max)
				max = arr[i];
		
		int count = 1;
		while (Math.pow(10, count) < max)
			count++;
		return count;
	}
	
	public static void radix(int[] arr)
	{
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
		
		LinkedList[] box = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9};
		
		int m = 10;
		int n = 1;
		int exp = getMaxDigits(arr);
		
		for (int e = 0; e < exp; e++)
		{
			for (int i = 0; i < arr.length; i++) 
			{
				int nbr = (arr[i] % m) / n;
				box[nbr].insertRear(arr[i]);
			}
			
			int count = 0;
			for (int j = 0; j < box.length; j++)
			{
				while (!box[j].isEmpty())
					arr[count++] = (int) box[j].removeFront();
			}
			
			m *= 10;
			n *= 10;
		}	
	}
}