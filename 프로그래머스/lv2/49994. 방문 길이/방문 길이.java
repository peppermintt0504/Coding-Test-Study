import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int posX = 0;
        int posY = 0;
        String[] arrDirs = dirs.split("");
        Map<String,ArrayList<String>> visited = new HashMap<String,ArrayList<String>>();
        
        for(int i = 0 ; i < dirs.length(); i++){
            String pos = Integer.toString(posX) + '=' + Integer.toString(posY);
            // System.out.println(arrDirs[i] + "   " + pos);
            
            switch (arrDirs[i]){
                case "U" :{
                    if(posY < 5) posY++;
                    break;
                }
                case "D" :{
                    if(posY > -5) posY--;
                    break;
                }
                case "R" :{
                    if(posX < 5) posX++;
                    break;
                }
                case "L" :{
                    if(posX > -5) posX--;
                    break;
                }
            }
            
            String newPos = Integer.toString(posX) + '=' + Integer.toString(posY);
            if(pos.equals(newPos))continue;
            if(visited.containsKey(pos)){
                if(!visited.get(pos).contains(newPos)){
                    visited.get(pos).add(newPos);
                    answer++;
                }
            }else{
                ArrayList<String> t = new ArrayList<String>();
                t.add(newPos);
                visited.put(pos,t);
                answer++;
            }
            
            if(visited.containsKey(newPos)){
                if(!visited.get(newPos).contains(pos)){
                    visited.get(newPos).add(pos);
                }
            }else{
                ArrayList<String> t = new ArrayList<String>();
                t.add(pos);
                visited.put(newPos,t);
            }
            
        }
        // System.out.println(visited.keySet());
        // System.out.println(visited.values());
        return answer;
    }
}