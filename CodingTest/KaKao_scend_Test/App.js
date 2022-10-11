import axios from "axios"

async function post(host, path, body, headers = {}) {
    const url = `https://${host}/${path}`;
    try{
        const res = await axios.post(
            url,
            body,
            {
                headers: {
                    "Content-Type": "application/json",
                    ...headers,
                },
            }
        )
        const data = res.data;
        return data;
    }catch(err){
        console.log('post Error ',path);
    }

    
}

async function get(host, path, headers = {}) {
    const url = `https://${host}/${path}`;
    try{
        const res = await axios.get(
            url,
            {
                headers: {
                    "Content-Type": "application/json",
                    ...headers,
                },
            }
        )
        const data = res.data;
        return data;
    }catch(err){
        console.log('get Error ',path);
    }
    
}

async function put(host, path, body, headers = {}) {
    const url = `https://${host}/${path}`;
    try{
    const res = await axios.put(
        url,
        body,
        {
            headers: {
                "Content-Type": "application/json",
                ...headers,
            },
        }
    )
    const data = res.data;
    return data;
    }catch(err){
        console.log('put Error ',path);
    }
}

const BaseUrl = '68ecj67379.execute-api.ap-northeast-2.amazonaws.com/api';
const token = 'dcbe349ee8c84e39f1a82f409fa9c185';

const problemOne = async ()=>{
    const testCase = 1;
    const floor = testCase === 1 ? 3 : 10;
    const roomCount = testCase === 1 ? 20 : 200;
    const day = testCase === 1 ? 200 : 1000;

    const startData = await post(BaseUrl,'start',{'problem' : testCase},{'X-Auth-Token':token})
    const startKey = {Authorization : startData.auth_key};

    let hotel1 = Array.from({length : floor}, (v,i)=> Array.from({length : roomCount},(v,i)=>Array(200).fill(0)));
    let bookList = [];
    let requestList = [];
    let roomAssignList = {};

    for(let t = 1; t <= day; t++){
        let requests = await get(BaseUrl,'new_requests',startKey);
        requests = requests.reservations_info;

        let AssignList = [];

        /** 객실 비우기 */
        for(let a = 0; a < floor; a++){
            for(let b = 0; b < roomCount; b++){
                hotel1[a][b].shift();
                hotel1[a][b].push(0);
            }
        }

        // console.table(hotel1[0][0]);
        requests.map((v,i)=>{
            requestList.push({
                ...v,
                rejectDate : Math.min(t + 14,v.check_in_date - 1)
            })
        })

        requestList = requestList.sort((a,b)=>{
            const aLength = a.check_out_date - a.check_in_date;
            const bLength = b.check_out_date - b.check_in_date;



            if(a.amount === b.amount){
                return (aLength - bLength);
            }
            return a.amount - b.amount

            // if(aLength === bLength){
            //     return a.amount - b.amount;
            // }
            // return (aLength - bLength)            
        })
        // console.log(requestList);
        const replyList =  []


        requestList.map((v,i)=>{
            let ok = false;
            let count =[];
            if(v.check_out_date-v.check_in_date > 10){
                for(let a = 0 ; a <floor;a++){
                    count.push({index:a});
                }
            }
            else{
                for(let a = 0 ; a <floor;a++){
                    count.push({index:floor - a - 1});
                }
            }



            for(let a = 0; a < floor; a++){
                for(let b = 0; b < roomCount - v.amount; b++){
                    for(let n = 0; n < v.amount; n++){
                        const booking = hotel1[count[a].index][b + n].slice(v.check_in_date - t, v.check_out_date - t).join('')
                        let str = ''
                        for(let q = 0;q < v.check_out_date - v.check_in_date;q++)    str += '0';

                        if(booking !== str){
                            break;
                        }
                        if(n === v.amount-1)    {
                            ok = true;
                        };
                    }

                    if(ok)  {
                        
                        for(let n = 0; n < v.amount; n++){
                            for(let q = v.check_in_date - t; q < v.check_out_date - t;q++){
                                hotel1[count[a].index][b+n][q] = v.check_out_date;
                            }
                            if(n === 0){
                                let temp = b+n+1;
                                let roomNumber = (count[a].index+1).toString();
                                if(temp >= 100)  roomNumber += temp.toString();
                                else if(temp < 100 && temp >= 10)    roomNumber += '0'+ temp.toString();
                                else roomNumber += '00'+temp.toString();
                                roomAssignList[v.id] = roomNumber;
                            }
                        }
                        break;
                    }
                }
                if(ok)  break;
            }
            if(ok){
                bookList.push(v);
                requestList[i].rejectDate = t;
                replyList.push({id:v.id,reply : "accepted",})
            }
        })
        
        
        let reply = await post(BaseUrl,'reply',{'replies' : replyList},startKey);

        const checkIn = bookList.filter((v,i)=>{
            return v.check_in_date === t
        })
        // console.log(bookList);
        checkIn.map((v,i)=>{
            if(roomAssignList[v.id]){
                AssignList.push({id : v.id, room_number : roomAssignList[v.id]})
            }
        })
        let simulate = await put(BaseUrl,'simulate',{'room_assign' : AssignList},startKey)
        console.log('simulate :: ',simulate);
        bookList = bookList.filter((v,i)=>v.check_out_date !== t)
        requestList = requestList.filter((v,i)=>v.rejectDate !== t)
    }
    let score = await get(BaseUrl,'score',startKey)
    console.log("score ::",score);
    
}



const problemV1 = async ()=>{
    const testCase = 2;
    const floor = testCase === 1 ? 3 : 10;
    const roomCount = testCase === 1 ? 20 : 200;
    const day = testCase === 1 ? 200 : 1000;

    const startData = await post(BaseUrl,'start',{'problem' : testCase},{'X-Auth-Token':token})
    const startKey = {Authorization : startData.auth_key};

    let hotel1 = Array.from({length : floor}, (v,i)=>Array(roomCount).fill(0));
    let bookList = [];
    let requestList = [];
    let roomAssignList = {};

    for(let t = 1; t <= day; t++){
        let requests = await get(BaseUrl,'new_requests',startKey);
        requests = requests.reservations_info;

        let AssignList = [];

        /** 객실 비우기 */
        for(let a = 0; a < floor; a++){
            for(let b = 0; b < roomCount; b++){
                if(hotel1[a][b] === t){
                    hotel1[a][b] = 0;
                } 
            }
        }


        requests.map((v,i)=>{
            if(v.check_out_date - v.check_in_date > 18){
                return
            }
            requestList.push({
                ...v,
                rejectDate : Math.min(t + 14,v.check_in_date - 1)
            })
        })

        requestList = requestList.sort((a,b)=>{
            const aLength = a.check_out_date - a.check_in_date;
            const bLength = b.check_out_date - b.check_in_date;

            if(a.amount === b.amount){
                return (aLength - bLength);
            }
            return a.amount - b.amount

            // if(aLength === bLength){
            //     return a.amount - b.amount;
            // }
            // return (aLength - bLength)            
        })

        const replyList =  []
        requestList.map((v,i)=>{
            let ok = false;
            for(let a = 0; a < floor; a++){
                for(let b = 0; b < roomCount - v.amount; b++){
                    for(let n = 0; n < v.amount; n++){
                        if(hotel1[a][b+n] - v.check_in_date > 0){
                            break;
                        }
                        if(n === v.amount-1)    ok = true;
                    }

                    if(ok)  {
                        for(let n = 0; n < v.amount; n++){
                            hotel1[a][b+n] = v.check_out_date;
                            if(n === 0){
                                let temp = b+n+1;
                                let roomNumber = (a+1).toString();
                                if(temp >= 100)  roomNumber += temp.toString();
                                else if(temp < 100 && temp >= 10)    roomNumber += '0'+ temp.toString();
                                else roomNumber += '00'+temp.toString();
                                roomAssignList[v.id] = roomNumber;
                            }
                            
                        }
                        break;
                    }
                }
                if(ok)  break;
            }
            if(ok){
                bookList.push(v);
                requestList[i].rejectDate = t;
                replyList.push({id:v.id,reply : "accepted",})
            }
        })

        
        let reply = await post(BaseUrl,'reply',{'replies' : replyList},startKey);

        requests.map((v,i)=>{
            if(v.check_out_date - v.check_in_date > 18){
                requestList.push({
                    ...v,
                    rejectDate : Math.min(t + 14,v.check_in_date - 1)
                })
            }
        })

        const checkIn = bookList.filter((v,i)=>{
            return v.check_in_date === t
        })
        checkIn.map((v,i)=>{
            if(roomAssignList[v.id]){
                AssignList.push({id : v.id, room_number : roomAssignList[v.id]})
            }
        })
        let simulate = await put(BaseUrl,'simulate',{'room_assign' : AssignList},startKey)
        console.log('simulate :: ',simulate);
        bookList = bookList.filter((v,i)=>v.check_out_date !== t)
        requestList = requestList.filter((v,i)=>v.rejectDate !== t)
    }
    let score = await get(BaseUrl,'score',startKey)
    console.log("score ::",score);
    
}
problemOne();
// problemV1();

