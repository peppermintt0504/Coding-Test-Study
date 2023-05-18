#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

int solution(vector<int> topping) {
    int answer = 0;
    
    map<int ,int> mapA;
    map<int ,int> mapB;
    
    int countA = 0;
    int countB = 0;
    
    for(int x : topping){
        if(mapB.find(x) != mapB.end()){
            mapB[x]++;
        }else{
            mapB[x] = 1;
            countB++;
        }
    }
    for(int i = 0; i < topping.size(); i++){
        
        if(mapB[topping[i]] == 1){
            mapB.erase(topping[i]);
            countB--;
        }else{
            mapB[topping[i]]--;
        }
        
        if(mapA.find(topping[i]) != mapA.end()){
            mapA[topping[i]]++;
        }else{
            mapA[topping[i]] = 1;
            countA++;
        }
        
        if(countA == countB)answer++;
    }
    
    return answer;
}