function solution(skill, skill_trees) {
    var answer = 0; 
    
    skill_trees.forEach((tree)=>{
        let count = 0;
        let possible = true;
        
        for(let i = 0; i <tree.length; i++){
            console.log(tree[i]);
            if(skill.includes(tree[i])){
                if(skill.indexOf(tree[i]) === count){
                    count++;
                }else{
                    possible = false;
                    break;
                }
            }
        }
        
        if(possible){
            answer++;
        }
        
    })
    return answer;
}