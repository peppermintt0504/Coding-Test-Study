

export const Get = (url,headers,body)=>{
    let data =null;

    fetch(url, {
    method: "GET",
    headers: {
        "Content-Type": "application/json",
        ...headers
    },
    body: JSON.stringify({
        ...body
    }),
    }).then((response) => data = response);
    return data;
}

export const Delete = (url,headers,body)=>{
    let data =null;

    fetch(url, {
    method: "GET",
    headers: {
        "Content-Type": "application/json",
        ...headers
    },
    body: JSON.stringify({
        ...body
    }),
    }).then((response) => data = response);
    return data;
}

/** headers와 body를 object형식으로 넣으시오*/
export const Post = (url,path,headers,body)=>{
    let data =null;
    let pathUrl = url + path;
    fetch(pathUrl, {
    method: "POST",
    headers: {
        "Content-Type": "application/json",
        ...headers
    },
    body: JSON.stringify({
        ...body
    }),
    }).then((response) => data = response);
    return data;
}

export const Put = (url,headers,body)=>{
    let data =null;

    fetch(url, {
    method: "PUT",
    headers: {
        "Content-Type": "application/json",
        ...headers
    },
    body: JSON.stringify({
        ...body
    }),
    }).then((response) => data = response);
    return data;
}
