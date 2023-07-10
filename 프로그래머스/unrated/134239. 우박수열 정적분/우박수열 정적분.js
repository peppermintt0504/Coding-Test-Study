function solution(k, ranges) {
    // k 값에 따른 값 생성
    const point = []
    // 넓이를 저장할 배열 생성
    const area = [0]
    // k가 1이 될 때까지 순회
    while(k !== 1) {
        if(k%2) {
            // 각 구간의 넓이는 사다리꼴의 넓이 (윗변+아랫변)/2, ([idx+1]+[idx])/2 를 기록함
            area.push((k + k * 3 + 1) / 2 + area.at(-1))
            k = k * 3 + 1
        } else {
            area.push((k + k / 2) / 2 + area.at(-1))
            k /= 2
        }
    } 
    // 범위 순회
    return ranges.map(([s,e]) => {
        // 범위가 끝나는 지점이 시작 지점보다 뒤에 있는 경우 -1 반환
        if(area.length - 1 + e < s) return -1
        // 끝 범위 - 시작 범위를 통해 범위 사이의 넓이를 확인
        return area.at(e-1) - area[s]
    })
}