

def solution(scoville, K):
    answer = 0
    for n in range(len(scoville)):
        
        scoville.sort()
        if scoville[0] < K :
            if len(scoville) == 1 :
                return -1
            scoville.append(scoville[0] + scoville[1]*2)
            scoville=scoville[2:]
            answer += 1
        

    return answer
    
    
def heapify(unsorted, index, heap_size) :
  rigth_node = 2 * index + 1
  left_node = 2 * index + 2
  
  if rigth_node < heap_size : 
    if unsorted[index] < unsorted[rigth_node]  :     #오른쪽 자식 노드보다 작을 경우
      unsorted[index] , unsorted[rigth_node] = unsorted[rigth_node], unsorted[index]
      heapify(unsorted,rigth_node,heap_size)

  if left_node < heap_size :
    if unsorted[index] < unsorted[left_node] and left_node <= heap_size :     #왼쪽 자식 노드보다 작을 경우
      unsorted[index] , unsorted[left_node] = unsorted[left_node], unsorted[index]
      heapify(unsorted,left_node,heap_size)

def heap_sort(unsorted):
    n = len(unsorted)
    # BUILD-MAX-HEAP (A) : 위의 1단계
    # 인덱스 : (n을 2로 나눈 몫-1)~0
    # 최초 힙 구성시 배열의 중간부터 시작하면 
    # 이진트리 성질에 의해 모든 요소값을 
    # 서로 한번씩 비교할 수 있게 됨 : O(n)
    for i in range(n // 2 - 1, -1, -1):
        heapify(unsorted, i, n)
    # Recurrent (B) : 2~4단계
    # 한번 힙이 구성되면 개별 노드는
    # 최악의 경우에도 트리의 높이(logn)
    # 만큼의 자리 이동을 하게 됨
    # 이런 노드들이 n개 있으므로 : O(nlogn)
    for i in range(n - 1, 0, -1):
        unsorted[0], unsorted[i] = unsorted[i], unsorted[0]
        heapify(unsorted, 0, i)
    return unsorted
