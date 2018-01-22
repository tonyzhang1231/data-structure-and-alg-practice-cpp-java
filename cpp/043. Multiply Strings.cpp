#include "000LCHeader.h"

using namespace std;

class Solution {
public:
    static string multiply(string a, string b) {
        if (a=="0" or b=="0") return "0";
        vector<int> res(a.size()+b.size(),0);
        for (int i=0;i<a.size();i++){
            for (int j=0;j<b.size();j++){
                res[i+j+1] += (a[i]-'0') * (b[j]-'0');
            }
        }
        
        for (int i=res.size()-1;i>=1;i--){
            res[i-1]+= res[i]/10;
            res[i] = res[i]%10;
        }
        
        string str = "";
        if (res[0]>0) str += to_string(res[0]);
        for (int i=1;i<res.size();i++){
            str += to_string(res[i]);
        }
        return str;
    }
};

int main(){
    string a {"123"};
    string b {"234"};
    cout << Solution::multiply(a,b) << endl;

    a = "0";
    b = "100";
    cout << Solution::multiply(a,b) << endl;
}

// g++ -std=c++14 043.\ Multiply\ Strings.cpp -o out.o
// ./out.o