async function post(host, path, body, headers = {}) {
    const url = `https://${host}/${path}`;
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            ...headers,
        },
        body: JSON.stringify(body),
    };
    const res = await fetch(url, options);
    const data = await res.json();
    if (res.ok) {
        console.log(data);
        return data;
    } else {
        throw Error(data);
    }
}

const BaseUrl = 'huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod';
const token = 'e12cea7b63f37977eb3d9ab5d77dbe07';

const test = async ()=>{

    const data = post(BaseUrl,'start',{'problem' : 1},{'X-Auth-Token':token})

    console.log(data);
}

test();