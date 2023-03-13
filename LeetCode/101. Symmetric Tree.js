/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */

var isSymmetric = function(root) {
    return isSameTree(root, root); 
};

function isSameTree(t1, t2) {
    if (t1 === null && t2 === null) return true;
    if (t1 === null || t2 === null) return false;
    return t1.val === t2.val && isSameTree(t1.left, t2.right) && isSameTree(t1.right, t2.left); 
}