/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
 var mergeKLists = function(lists) {
    const numberList = [];
    for(target of lists) {
        while(target){
            numberList.push(target.val);
            target = target.next;
        };
    }
        
    numberList.sort((a,b) => a-b);
    
    let answer = new ListNode(0);
    let temp = answer;

    numberList.forEach((num)=>{
        temp.next = new ListNode(num);
        temp = temp.next;
    })

    return answer.next;
};

