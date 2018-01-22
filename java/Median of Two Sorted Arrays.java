// Explanation

// The key point of this problem is to ignore half part of A and B each step recursively 
// by comparing the median of remaining A and B:

// if (aMid < bMid) Keep [aRight + bLeft]

// else Keep [bRight + aLeft]
// As the following: time=O(log(m + n))

public double findMedianSortedArrays(int[] A, int[] B) {
	    int m = A.length, n = B.length;
	    int l = (m + n + 1) / 2;
	    int r = (m + n + 2) / 2;
	    return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
	if (aStart > A.length - 1) return B[bStart + k - 1];            
	if (bStart > B.length - 1) return A[aStart + k - 1];                
	if (k == 1) return Math.min(A[aStart], B[bStart]);
	
	int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
	if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
	if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        
	
	if (aMid < bMid) // aMid <= bMid is also OK
	    return getkth(A, aStart + k/2, B, bStart,       k - k/2);// 
	else 
		return getkth(A, aStart,       B, bStart + k/2, k - k/2);// if aMid == bMid, then delete either A or B is OK
}

// getkth(), every time remove k/2 numbers, then find (k - k/2) th smallest number

// memorize getkth() function

// A :   3 7 9 12 15
// B :   2 4 6 13 18
// find the 5th smallest number, 
// so compare 9 and 6, since 9>6 then, 