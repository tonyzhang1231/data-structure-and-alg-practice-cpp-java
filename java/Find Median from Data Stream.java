// 295. Find Median from Data Stream   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 32430
// Total Submissions: 139408
// Difficulty: Hard
// Contributors: Admin
// Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

// Examples: 
// [2,3,4] , the median is 3

// [2,3], the median is (2 + 3) / 2 = 2.5

// Design a data structure that supports the following two operations:

// void addNum(int num) - Add a integer number from the data stream to the data structure.
// double findMedian() - Return the median of all elements so far.
// For example:

// add(1)
// add(2)
// findMedian() -> 1.5
// add(3) 
// findMedian() -> 2
// Credits:
// Special thanks to @Louis1992 for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

//  Heap Design
// Hide Similar Problems (H) Sliding Window Median



// I keep two heaps (or priority queues):

// Max-heap small has the smaller half of the numbers.
// Min-heap large has the larger half of the numbers.
// This gives me direct access to the one or two middle values (they're the tops of the heaps), so getting the median takes O(1) time. And adding a number takes O(log n) time.

// Supporting both min- and max-heap is more or less cumbersome, depending on the language, so I simply negate the numbers in the heap in which I want the reverse of the default order. To prevent this from causing a bug with -231 (which negated is itself, when using 32-bit ints), I use integer types larger than 32 bits.

// Using larger integer types also prevents an overflow error when taking the mean of the two middle numbers. I think almost all solutions posted previously have that bug.

// Update: These are pretty short already, but by now I wrote even shorter ones.

// Share my java solution logn to insert, O(1) to query
public class MedianFinder {
    // max queue is always larger or equal to min queue
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>( (a,b) -> (b-a) );
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }
};
