package com.leetcode.problems;
import java.util.PriorityQueue;

public class KthSmallestFraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,3};
		int target=1;
		kthSmallestPrimeFraction(nums, target);
	}

	
	 public static int[] kthSmallestPrimeFraction(int[] A, int K) {
	       PriorityQueue<int[]> pq = new PriorityQueue<>(A.length, (a, b) -> A[a[0]] * A[b[1]] - A[b[0]] * A[a[1]]);
			for (int i = 0; i < A.length - 1; i++) {
				pq.add(new int[] { i, A.length - 1 });
			}

			while (!pq.isEmpty() && --K > 0) {
				int[] head = pq.poll();
				if (head[1] - 1 > head[0]) {
					head[1]--;
					pq.add(head);
				}

			}
			int[] result = pq.peek();

			result[0] = A[result[0]];
			result[1] = A[result[1]];

			return result;
	    }
}
