
#combinations
import java.io.*;
import java.util.*;

public class EthCode {
	static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
		if (index == r) {
			for (int j = 0; j < r; j++)
				System.out.print(data[j] + " ");
			System.out.println("");
			return;
		}

		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}

	static void printCombination(int arr[], int n, int r) {
		int[] data = new int[r]; // Create an array to store combinations
		combinationUtil(arr, data, 0, n - 1, 0, r);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Take user input for array elements
		System.out.print("Enter the number of elements: ");
		int n = scanner.nextInt();
		int[] arr = new int[n];

		System.out.println("Enter the elements:");
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		System.out.print("Enter the size of combinations (r): ");
		int r = scanner.nextInt();

		printCombination(arr, n, r);
	}
}

#activity selection
import java.io.*;
import java.util.*;

class ActivitySelection {
    public static void printMaxActivities(int s[], int f[], int n) {
        int i, j;
        System.out.println("Following activities are selected:");
        i = 0;
        System.out.print(i + " ");
        for (j = 1; j < n; j++) {
            if (s[j] >= f[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the number of activities
        System.out.print("Enter the number of activities: ");
        int n = scanner.nextInt();
        int[] s = new int[n]; // Array to store start times
        int[] f = new int[n]; // Array to store finish times

        // Take user input for start times
        System.out.println("Enter the start times:");
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        // Take user input for finish times
        System.out.println("Enter the finish times:");
        for (int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
        }

        printMaxActivities(s, f, n);
    }
}

#longest palindrome
import java.util.*;

class EthCode {
    static void printSubStr(String str, int low, int high) {
        for (int i = low; i <= high; ++i)
            System.out.print(str.charAt(i));
    }

    static int longestPalSubstr(String str) {
        
        int n = str.length();
        int maxLength = 1, start = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k))
                        flag = 0;

                if (flag != 0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        System.out.print("Longest palindrome subString is: ");
        printSubStr(str, start, start + maxLength - 1);
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        int length = longestPalSubstr(str);
        System.out.println("\nLength of the longest palindrome subString is: " + length);
    }
}

#manuering problem
public class EthCode {
    
    static int numberOfPaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String args[]) {
        int m = 3; // Number of rows
        int n = 3; // Number of columns

        int totalPaths = numberOfPaths(m, n);
        System.out.println("Total number of paths from the top-left corner to the bottom-right corner: " + totalPaths);
    }
}

#move hiphen
import java.util.Scanner;

class EthCode {
    static void moveSpaceInFront(char str[]) {
        // Traverse from end and swap hyphens
        int i = str.length - 1;
        for (int j = i; j >= 0; j--) {
            if (str[j] != '-') {
                char c = str[i];
                str[i] = str[j];
                str[j] = c;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        char str[] = inputString.toCharArray();

        moveSpaceInFront(str);
        System.out.println("String with spaces moved to the front: " + String.valueOf(str));
    }
}


#selection
import java.util.Scanner;

class EthCode {
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EthCode sorter = new EthCode();

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Original array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sorter.sort(arr);

        System.out.println("\nArray after sorting in ascending order:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


#quicksort
class EthCode{
int partition(int arr[], int low, int high)
 {
 int pivot = arr[high];
 int i = (low-1); 
 for (int j=low; j<high; j++)
 {
 if (arr[j] <= pivot)
 {
 i++;
 int temp = arr[i];
 arr[i] = arr[j];
 arr[j] = temp;
 }
 }
 int temp = arr[i+1];
 arr[i+1] = arr[high];
 arr[high] = temp;
 return i+1;
 }

void sort(int arr[], int low, int high){
 if (low < high)
 {
  int pi = partition(arr, low, high);
  sort(arr, low, pi-1);
  sort(arr, pi+1, high);
 }}
static void printArray(int arr[])
 {
 int n = arr.length;
 for (int i=0; i<n; ++i)
 System.out.print(arr[i]+" ");
 System.out.println();
 }
public static void main(String args[])
 {
 int arr[] = {10, 7, 8, 9, 1, 5};
 int n = arr.length;
  QuickSort ob = new QuickSort();
 ob.sort(arr, 0, n-1);
 System.out.println("sorted array");
 printArray(arr);
 }}
