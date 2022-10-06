

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

export const Post = (url,headers,body)=>{
    let data =null;

    fetch(url, {
    method: "DELETE",
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
