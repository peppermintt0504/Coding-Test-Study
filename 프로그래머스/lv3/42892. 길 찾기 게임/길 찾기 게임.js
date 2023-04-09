class BinaryTree {
    constructor(val,pos){
        this.value = val;
        this.pos = pos;
        this.right = null;
        this.left = null;
    }
    
    insert(val,pos){
        this.pos >= pos
        ? this._toLeft(val, pos)
    	: this._toRight(val, pos);
    }
    
    _toLeft(val,pos){
        this.left
        ? this.left.insert(val,pos)
        : this.left = new BinaryTree(val, pos);
    }
    
    _toRight(val,pos){
        this.right
        ? this.right.insert(val,pos)
        : this.right = new BinaryTree(val, pos);
    }
}

const preorder = (bTree, arr) => {
  if(bTree !== null) {
    arr.push(bTree.value);
    preorder(bTree.left, arr);
    preorder(bTree.right, arr);
  }
}

const postorder = (bTree, arr) => {
  if(bTree !== null) {
    postorder(bTree.left, arr);
    postorder(bTree.right, arr);
    arr.push(bTree.value);
  }
}

function solution(nodeinfo) {
    const preorderArr = [];
    const postorderArr = [];
    
    const nodeList = nodeinfo.map((v,i)=>[i+1,v[0],v[1]]).sort((a, b) => b[2] - a[2]);
    
    const mainTree = new BinaryTree(nodeList[0][0],nodeList[0][1]);
    
    for(let i = 1; i < nodeList.length; i++) {
        mainTree.insert(nodeList[i][0], nodeList[i][1]);
    }
    
    preorder(mainTree,preorderArr);
    postorder(mainTree,postorderArr);
    
    
    
    return [preorderArr,postorderArr];
}