#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    map<string,int> scoreboard;
    map<string,int>::iterator iter;
    
    scoreboard["R"] = 0;
    scoreboard["T"] = 0;
    scoreboard["C"] = 0;
    scoreboard["F"] = 0;
    scoreboard["J"] = 0;
    scoreboard["M"] = 0;
    scoreboard["A"] = 0;
    scoreboard["N"] = 0;
    
    string answer = "";
    
    for(int i = 0; i < survey.size(); i++){
        string a = survey[i].substr(0,1);
        string b = survey[i].substr(1);
        if(choices[i] < 4){
            scoreboard[a] += 4 - choices[i];
        }else{
            scoreboard[b] += choices[i] - 4;
        }
    }
    for(iter = scoreboard.begin(); iter!=scoreboard.end(); iter++){
    }
    if(scoreboard["R"] >= scoreboard["T"])answer+="R";
    else   answer+= "T";
    
    if(scoreboard["C"] >= scoreboard["F"])answer+="C";
    else   answer+= "F";
    
    if(scoreboard["J"] >= scoreboard["M"])answer+="J";
    else   answer+= "M";
    
    if(scoreboard["A"] >= scoreboard["N"])answer+="A";
    else   answer+= "N";
    
    return answer;
}