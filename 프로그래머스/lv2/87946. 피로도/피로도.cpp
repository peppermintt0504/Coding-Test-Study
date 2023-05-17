#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<bool> visited;
vector<int> minEnergy;
vector<int> useEnergy;
int maxEnter = 0;
int dungeonSize = 0;

void enterTheDungeon (int count, int energy){
   
    for(int i = 0; i < dungeonSize; i++){
        if(!visited[i] && energy >= minEnergy[i]){
            visited[i] = true;
            enterTheDungeon(count+1,energy-useEnergy[i]);
            visited[i] = false;
        }
    }
    if(maxEnter < count){
        maxEnter = count;
    }
}


int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    dungeonSize = dungeons.size();
    for(vector<int> x : dungeons){
        visited.push_back(false);
        minEnergy.push_back(x[0]);
        useEnergy.push_back(x[1]);
    }
    // for(bool a:visited){
    //     cout << a << ' ';
    // }
    // cout << endl;
    // for(int a:minEnergy){
    //     cout << a << ' ';
    // }
    // cout << endl;
    // for(int a:useEnergy){
    //     cout << a << ' ';
    // }
    cout << endl;
    enterTheDungeon(0,k);
    
    return maxEnter;
}