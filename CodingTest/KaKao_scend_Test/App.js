import axios from "axios"

async function post(host, path, body, headers = {}) {
    const url = `https://${host}/${path}`;
    const res = await axios.post(
        url,
        body,
        {
            headers: {
                "Content-Type": "application/json",
                ...headers,
            },
        }
      ).catch((res)=>{console.log(res);
        return;
    });
    const data = res.data;
    return data;
}

async function get(host, path, headers = {}) {
    const url = `https://${host}/${path}`;

    const res = await axios.get(
        url,
        {
            headers: {
                "Content-Type": "application/json",
                ...headers,
            },
        }
      ).catch((res)=>{console.log(res);
        return ;
    });
    const data = res.data;
    return data;
}

async function put(host, path, body, headers = {}) {
    const url = `https://${host}/${path}`;
    const res = await axios.put(
        url,
        body,
        {
            headers: {
                "Content-Type": "application/json",
                ...headers,
            },
        }
      ).catch((res)=>{
        console.log(res);
        return;
    });
    const data = res.data;
    return data;
}

const BaseUrl = 'huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod';
const token = '3cc00163fa8d08712a0dd4ee84b8cd22';

const test = async ()=>{
    const startData = await post(BaseUrl,'start',{'problem' : 1},{'X-Auth-Token':token})
    const startKey = {Authorization : startData.auth_key};

    let userInfo = await get(BaseUrl,'user_info',startKey)
    let userList = {}
    userInfo.user_info.map((v)=>{userList[v.id] = {grade : v.grade, from : 1, rank : 40000}});
    let firstMatch = Array.from({length : 15},(v,i)=>[2*i+1,2*i+2])
    let match = await put(BaseUrl,'match',{'pairs' : []},startKey)
    match = await put(BaseUrl,'match',{'pairs' : firstMatch},startKey)


    for(let t = 2; t < 595 ; t++){
        let {game_result} = await get(BaseUrl,'game_result',startKey);
        let {waiting_line} = await get(BaseUrl,'waiting_line',startKey);
        let matchList =[];
        
        // console.log('game_result : ',game_result);

        game_result.map((v,i)=>{
            userList[v.win].rank = userList[v.win].rank + (40-v.taken) * 100;
            userList[v.lose].rank = userList[v.lose].rank - (40-v.taken) * 100;
        })


        // console.log('waiting_line : ',waiting_line);
        waiting_line.map((v,i)=>{
            if(!(i%2) && waiting_line.length-1 !== i){
                matchList.push([v.id,waiting_line[i+1].id]);
            }
        })
        // console.log('matchList : ',matchList)
        console.log( await put(BaseUrl,'match',{'pairs' : matchList},startKey));
    }
    console.log( await put(BaseUrl,'match',{'pairs' : []},startKey));
    let finalScore = Array.from({length:30},(v,i)=>{return {id : i+1,grade : 0,rank:userList[i+1].rank}}).sort((a,b)=>a.rank - b.rank);
    const highScore = finalScore[29].rank;
    const lowScore = finalScore[0].rank;
    const per = Math.floor(9999 / (highScore-lowScore))
    finalScore.map((v,i)=>{
        finalScore[i].grade = (finalScore[i].rank - lowScore) * per;
    })
    finalScore[0].grade = parseInt(finalScore[1].grade / 2)
    await put(BaseUrl,'change_grade',{'commands' : finalScore},startKey)
    
    console.log(await get(BaseUrl,'score',startKey));
}

test();