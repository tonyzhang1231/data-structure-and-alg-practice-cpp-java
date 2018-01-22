public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i=0;i<n;i++){
            int num = i+1;
            if (num%15==0) res.add("FizzBuzz");
            else if(num%3==0){
                res.add("Fizz");
            }else if(num%5==0){
                res.add("Buzz");
            }else{
                res.add(String.valueOf(num));
            }
            
        }
        return res;
    }
}



public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        } 
        return ret;
    }
}