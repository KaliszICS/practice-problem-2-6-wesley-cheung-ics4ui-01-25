import java.util.Arrays;

public class PracticeProblem {

	public static void main(String args[]) {

	}
	public static int[] bubbleSort(double[] nums) {
		int steps=0,swaps = 0;
		for (int i = 0; i < nums.length; i++) {
			boolean sorted = true;
			for (int j = 0; j < nums.length - i - 1; j++) {
				steps++;
				if (nums[j] > nums[j + 1]) {
					swaps+=3;
					double temp;
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j+1] = temp;
					sorted = false;
				}
			}
			
			if (sorted) {
				i = nums.length;
			}
		}
		return new int[]{swaps, steps};
	}
	public static int[] selectionSort(double[] nums) {
		int smallestIndex;
		double temp;
		int steps = 0;
		int swaps = 0;

		for (int i = 0; i < nums.length - 1; i++) {

			smallestIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				steps++;
				if (nums[j] < nums[smallestIndex]) {
					smallestIndex = j;
					swaps++;
				}
			}
			swaps+=3;
			temp = nums[smallestIndex];
			nums[smallestIndex] = nums[i];
			nums[i] = temp;
		}
		return new int[]{swaps,steps};
	}
	public static int[] insertionSort(double[] nums) {
		double key;
		int index;
		int steps = 0;
		int swaps = 0;
		for (int i = 1; i < nums.length; i++) {
			swaps++;
			key = nums[i];
			index = i - 1;

			while (index >= 0 && key < nums[index]) {
				steps++;
				nums[index + 1] = nums[index];
				swaps++;
				index--;
			}
			nums[index + 1] = key;
			swaps++;
		}
		return new int[]{swaps,steps};
	}
	public static String leastSwaps(double[] nums) {
		int a = bubbleSort(Arrays.copyOf(nums, nums.length))[0];
		int b = insertionSort(Arrays.copyOf(nums, nums.length))[0];
		int c = selectionSort(Arrays.copyOf(nums, nums.length))[0];
		if (a <= b && a <= c) {
			return "Bubble";
		} else if (b < a && b <= c) {
			return "Insertion";
		} else {
			return "Selection";
		}
	}
	public static String leastIterations(double[] nums) {
		int a = bubbleSort(Arrays.copyOf(nums, nums.length))[1];
		int b = insertionSort(Arrays.copyOf(nums, nums.length))[1];
		int c = selectionSort(Arrays.copyOf(nums, nums.length))[1];
		if (a <= b && a <= c) {
			return "Bubble";
		} else if (b < a && b <= c) {
			return "Insertion";
		} else {
			return "Selection";
		}
	}

}
