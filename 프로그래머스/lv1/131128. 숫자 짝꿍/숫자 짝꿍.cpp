#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string X, string Y) {
    string answer = "";
    int checkZero = 0;
    int length = 10;
    int* arrayX = new int[length]{};
    int* arrayY = new int[length]{};
    
    for(int i = 0; i <= 9; i++){
        int temp = 0;
        
        while(1){
            if(X.find(to_string(i),temp) != string::npos){
                arrayX[i]++;
                temp = X.find(to_string(i),temp) + 1;
            }else{
                 break;
            }
        }
        
        temp = 0;
        while(1){
            if(Y.find(to_string(i),temp) != string::npos){
                arrayY[i]++;
                temp = Y.find(to_string(i),temp) + 1;
            }else{
                 break;
            }
        }
        
        if(i != 0){
            checkZero += min(arrayX[i], arrayY[i]);
        }
    }
    
    
    
    for(int i = 9; i >= 0; i--){
        if(arrayX[i] == 0 || arrayY[i] == 0) continue;
        for(int j = 0; j < min(arrayX[i],arrayY[i]);j++){
            answer.append(to_string(i));
        }
    }
    
    delete[] arrayX;
    delete[] arrayY;
    
    if(answer.length() == 0){
        return "-1";
    }
    if(checkZero == 0){
        return "0";
    }
    return answer;
}