#include "000LCHeader.h"

using namespace std;

class Solution {
public:
    static int compareVersion(string version1, string version2) {
        // create stringstreams for versions
        stringstream ss1(version1); 
        stringstream ss2(version2);
        // variables to store version values
        int v1 =0;
        int v2 =0;
        char c; // character to get . from versions
        while(ss1 || ss2){
            ss1 >> v1; // try to get int value from version1
           
            ss2 >> v2; // try to get int value from version2

            // if ss1 and ss2 both are invalid now, it means we did not get any valid value 
            // for v1 and v2. It means we are done comparing versions and till this point versions were same. 
            // Return 0. 
            if(!ss1 && !ss2) return 0; 
            // if ss1 was not valid, it means we failed to get v1. Make v1 = 0 , to be able to compare version like 1.2 and 1.2.0
            if(!ss1) v1=0;
            // if ss2 was not valid, it means we failed to get v2. Make v2 = 0 , to be able to compare version like 1.2.0 and 1.2
            if(!ss2) v2=0;
            cout << "v1 = " << v1 << '\n';
            cout << "v2 = " << v2 << '\n';
            // Now compare v1 and v2 according to given rules and give result if they are different.
            if(v1 > v2) return 1;
            if(v2 > v1) return -1;
            // Reaching here means v1 and v2 are same. In that case we need to loop again to be able to compare next version numbers. Get . char from valid stringstreams so that we can extract integer version numbers in next loop iteration.
            if(ss1) ss1 >> c;
            if(ss2) ss2 >> c;
        }
        return 0;
    }
};

int main(){
    string version1, version2;
    // case 1
    version1 = ".23";  // v1 = 0, v2 = 12, return -1
    version2 = "12.13";
    cout << Solution::compareVersion(version1,version2) << '\n';

    // case 2
    version1 = "12";  // v1 = 12, v2 = 12, then v1=0, v2= 11, return -1
    version2 = "12.11";
    cout << Solution::compareVersion(version1,version2) << '\n';

    stringstream ss("12.31");
    int v1, v2, v3;
    char c;
    ss >> v1 >> c >> v2;
    cout<<  std::boolalpha <<(ss.fail()) << '\n'; // false
    cout<< v1 << "  " << c  << "  " << v2 << '\n'; // 12 . 31
    cout<<  std::boolalpha <<(!ss) << '\n'; // false

    cout<<  std::boolalpha <<(ss.eof()) << '\n'; // true

    stringstream ss2(".");
    ss2 >> v3; 
    cout<<  v3 << '\n'; // 0
    cout<<  std::boolalpha <<(ss2.fail()) << '\n'; // true

    ss2 >> c; 
    cout<<  c  << '\n'; // .
    cout<<  std::boolalpha <<(ss2.fail()) << '\n'; // true

    // std::basic_ios::fail
    // Returns true if an error has occurred on the associated stream.
}

// g++ -std=c++14 165.\ Compare\ Version\ Numbers.cpp -o out.o
// ./out.o