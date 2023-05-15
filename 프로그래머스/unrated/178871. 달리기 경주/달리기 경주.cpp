#include <string>
#include <vector>
#include <map>
using namespace std;

vector<string> solution(vector<string> players, vector<string> callings)
{
    vector<string> answer;
    map<int, string> m1;
    map<string, int> m2;
    for(int i=0;i<players.size();i++)
    {
        m1[i] = players[i];
        m2[players[i]] = i;
    }
    for(int i=0;i<callings.size();i++)
    {
        int cur_idx = m2[callings[i]];//호출 선수 이름, 순위
        string change = m1[cur_idx - 1];//앞선 선수 이름, 순위
        m1[cur_idx - 1] = callings[i];
        m1[cur_idx] = change;
        m2[callings[i]] = cur_idx - 1;
        m2[change] = cur_idx;
    }
    for(auto c : m1) answer.push_back(c.second);
    return answer;
}