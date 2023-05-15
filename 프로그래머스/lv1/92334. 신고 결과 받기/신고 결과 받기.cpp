#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>


using namespace std;




vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    for(int i = 0 ; i < id_list.size();i++) answer.push_back(0);
    map<string, vector<string>> reportMap;
    map<string, vector<string>>::iterator p;
    
    for(string rpt: report){
        // cout << rpt << endl;
        
        string str = rpt;
        vector<string> temp;
        
        // cout << str.substr(0,str.find(" ")) << endl;
        // cout << str.substr(str.find(" ")+1) << endl;
        
        p = reportMap.find(str.substr(str.find(" ")+1));
        if( p != reportMap.end()){
            // cout << "exists" << endl;
            bool isNew = true;
            
            for(string x : reportMap[str.substr(str.find(" ")+1)]){
                if(x == str.substr(0,str.find(" "))){
                    isNew = false;
                }
            }
            
            if(isNew){
                reportMap[str.substr(str.find(" ")+1)].push_back(str.substr(0,str.find(" ")));
            }
            
        }else{
            // cout << "not exists" << endl;
            temp.push_back(str.substr(0,str.find(" ")));
            reportMap[str.substr(str.find(" ")+1)] = temp;
        }
        
    }
    for(p = reportMap.begin(); p != reportMap.end(); p++){
        if(p->second.size() >= k){
            for(string user : p->second){
                answer[find(id_list.begin(), id_list.end(), user) - id_list.begin()]++;
            }
        }
    }
    
    return answer;
}