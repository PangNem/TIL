function Node() {
  this.name = [];
  this.nextNode = [];

  this.createNode = (node, next) => {
    const nodeIdx = this.name.indexOf(node);
    if (nodeIdx === -1) {
      this.name.push(node);
      this.nextNode.push([next]);
    } else {
      this.nextNode[nodeIdx].push(next);
    }

    const nextIdx = this.name.indexOf(next);
    if (nextIdx === -1) {
      this.name.push(next);
      this.nextNode.push([node]);
    } else {
      this.nextNode[nextIdx].push(node);
    }
  }
}

const node = new Node();
node.createNode(1, 2);
node.createNode(2, 3);
node.createNode(1, 3);

console.log(node);