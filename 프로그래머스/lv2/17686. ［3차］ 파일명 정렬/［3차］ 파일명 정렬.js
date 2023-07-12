function solution(files) {
    var arr = [];
    
   for(let i = 0; i < files.length; i++){
       for(let j = 0; j < files[i].length; j++){
           if(j===0){
               arr.push({"HEAD":files[i][0], "NUMBER":"", "TAIL": ""});
           }else if((files[i][j].charCodeAt() < 48 || files[i][j].charCodeAt() > 57) && arr[i]["NUMBER"] === "" ){
               arr[i]["HEAD"] += files[i][j]; 
           }else if(files[i][j].charCodeAt() >= 48 && files[i][j].charCodeAt() <= 57 && arr[i]["TAIL"]===""){
               arr[i]["NUMBER"] += files[i][j];
           }else{
               arr[i]["TAIL"] += files[i][j];
           }
       }
   }
  
    arr.sort(function (a, b) {
    let x = a.HEAD.toLowerCase();
    let y = b.HEAD.toLowerCase();
    let x2 = Number(a.NUMBER);
    let y2 = Number(b.NUMBER);
    if (x < y) {
        return -1;
    }
    if (x > y) {
        return 1;
    } else{
        if( x2 < y2 ){
            return -1;
        } if( x2 > y2 ){
            return 1;
        }
    }
    return 0;
});
    
   return arr.map(v=>v.HEAD+v.NUMBER+v.TAIL);
};
