#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<string> dic = {"A","E","I","O","U"};
string target;
int count = 0;
int result = 0;

void search (string str){
    if(str.length() == 5)   return;
    for(int i = 0; i < 5; i++){
        count++;
        if(str+dic[i] == target){
            result = count;
        }
        search(str + dic[i]);
    }
}

int solution(string word) {
    int answer = 0;
    target = word;
    
    search("");
    
    return result;
}