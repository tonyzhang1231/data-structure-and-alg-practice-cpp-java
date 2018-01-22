/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

// O(n^3) time O(1) space
public class Solution {
    public int maxPoints(Point[] points) {
        if (points==null || points.length==0) return 0;
        if (points.length<=2) return points.length;
        
        int res = 0;
        int n=points.length;
        for (int i=0;i<n;i++){
            if (i>0 && points[i].x == points[i-1].x && points[i].y == points[i-1].y) continue;
            Point p = points[i];
            int dup = 1; // p itself
            int count = 0;
            
            for (int j=i+1;j<n;j++){
                Point q = points[j];
                if (p.x==q.x && p.y==q.y) {
                    dup++;
                    res = Math.max(res, dup);
                    continue;
                }
                
                count = 1; //count point q
                for (int k=j+1;k<n;k++){
                    Point r = points[k];
                    if (isCoLinear(p,q,r)) {
                        count += 1;
                    }
                }
                res = Math.max(res, dup  + count); // p + q + r
            }
        }
        return res;
    }
    
    boolean isCoLinear(Point p, Point q, Point r){
        return  (p.x - q.x )*(p.y - r.y) == (p.y-q.y)*(p.x - r.x);
    }
}



// O(n^2) time O(n) space
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points.length==0) return 0;
        int max = 0;
        Map<String, Integer> map = new HashMap<>(); // slope -> number

        // do not necessarily sort first
        Arrays.sort(points, new Comparator<Point>(){
            public int compare(Point a, Point b){
                if (a.x == b.x) return a.y - b.y;
                return a.x - b.x;
            }
        });
            
        int n = points.length;
        for (int i = 0;i < n; i++){
            if (i>0 && points[i].x == points[i-1].x && points[i].y == points[i-1].y ) continue;
            map.clear();
            int thisPoint = 1;
            for (int j=i+1;j<n;j++){
                if (points[i].x == points[j].x && points[i].y == points[j].y) thisPoint++;
                else{
                    String key = getKey(points[i],points[j]);
                    map.put(key, map.getOrDefault(key,0)+1);
                }
            }
            max = Math.max(max, thisPoint);
            for (int v:map.values()){
                max = Math.max(max, thisPoint + v);
            }
        }
        return max;
    }
    
    public String getKey(Point p1, Point p2){
        int x = p1.x - p2.x;
        int y = p1.y - p2.y;
        if (x==0) return "INF";
        if (y==0) return "0";
        boolean isPos = x*y>0;
        x = Math.abs(x);
        y = Math.abs(y);
        int gcd = getGCD(x,y);
        x = x/gcd;
        y = y/gcd;
        String res = isPos?"":"-";
        return res + x + "/" + y;
    }
    
    public int getGCD(int x, int y){
        if (x==0) return y;
        return getGCD(y%x, x);
    }

    
    public static void main(String[] args) {
        Point[] pp = new Point[10];
        for (int i = 10; i >= 1; i--) {
            pp[i - 1] = new Point(i, i);
        }
        //Point center = new Point(0, 0);
        //System.out.println(findPoints(5, center, pp));
        //System.out.println(quickFindPoints(5, center, pp));
        Point[] points = {new Point(0, 0), new Point(-1, -1), new Point(2, 2)};
        System.out.println(maxPoints(points));
    }
}