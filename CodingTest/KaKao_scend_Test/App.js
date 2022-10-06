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
      );
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
      );
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
      );
    const data = res.data;
    return data;
}

const BaseUrl = 'huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod';
const token = 'e12cea7b63f37977eb3d9ab5d77dbe07';

const test = async ()=>{
    const startData = await post(BaseUrl,'start',{'problem' : 1},{'X-Auth-Token':token})
    const startKey = {Authorization : startData.auth_key};

    const userInfo = await get(BaseUrl,'user_info',startKey)
    let match = await put(BaseUrl,'match',{'pairs' : []},startKey)
    const waitingList = await get(BaseUrl,'waiting_line',startKey)
    let gameResult = await get(BaseUrl,'game_result',startKey)


    console.log(startKey);
    console.log(waitingList);
    // console.log(userInfo);
    console.log(match);
    
}

test();