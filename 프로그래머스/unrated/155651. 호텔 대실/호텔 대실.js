function solution(book_time) {
    book_time.sort((a,b)=>changeTime(a[0])-changeTime(b[0]));
    let rooms = [];
    
    book_time.forEach((booking)=>{
        const bookingTime = changeTime(booking[0]);
        
        if(rooms.length === 0){
            rooms.push(changeTime(booking[1]) + 10);
        }
        else{
            let needNewRoom = true
            for(i in rooms){
                if(bookingTime >= rooms[i]){
                    needNewRoom = false;
                    rooms[i] = changeTime(booking[1]) + 10;
                    break;
                }
            }
            if(needNewRoom){
                rooms.push(changeTime(booking[1]) + 10);
            }
        }
    })
    return rooms.length
}

const changeTime = (string) =>{
    const [hh,mm] = string.split(':');
    return Number(hh) * 60 + Number(mm);
}