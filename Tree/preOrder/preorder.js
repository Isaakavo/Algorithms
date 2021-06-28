 function TreeNode(val, left, right) {
      this.val = (val===undefined ? 0 : val)
      this.left = (left===undefined ? null : left)
      this.right = (right===undefined ? null : right)
}

var treeRoot = [];

for (let i = 0; i < 3; i++) {
  treeRoot.push( TreeNode(i + 1, undefined, 2) )
}

console.log('====================================');
console.log(treeRoot);
console.log('====================================');