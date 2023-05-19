#include <string>
#include <vector>
#include <iostream>
using namespace std;

int emoticonSize;
vector<int> discount = {10,20,30,40};
vector<vector<int>> discountCase = {};

void DFS (vector<int> p){
    if(p.size() == emoticonSize){
        discountCase.push_back(p);
        return;
    }
    for(int rate : discount){
        p.push_back(rate);
        DFS(p);
        p.pop_back();
    }
}


vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> answer = {0,0};
    emoticonSize = emoticons.size();
    
    DFS({});
    for(vector<int> discountRate : discountCase){
        int plusCount = 0;
        int sales = 0;
        
        for(vector<int> user : users){
            
            int minDiscount = user[0];
            int plusLine = user[1];
            int buy = 0;
        
            for(int i = 0; i < emoticonSize; i++){
                if(discountRate[i] < minDiscount)   continue;
                buy += emoticons[i] * (100 - discountRate[i]) / 100;
            }
            
            
            
            if(buy >= plusLine){
                plusCount++;
            }else{
                sales += buy;
            }
        }
        if(answer[0] < plusCount){
            answer[0] = plusCount;
            answer[1] = sales;
        }else{
            if(answer[0] == plusCount && answer[1] < sales){
                answer[1] = sales;
            }
        }
    }
    
    
    return answer;
}