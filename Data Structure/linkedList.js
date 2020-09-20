const LinkedList = (function () {
  function LinkedList() {
    this.length = 0;
    this.head = null;
  }
  function Node(data) {
    this.data = data;
    this.next = null;
  }
  LinkedList.prototype.add = function (value) {
    var node = new Node(value);
    var current = this.head;
    if (!current) {
      this.head = node;
      this.length++;

      return node;
    } else {
      while (current.next) { // 마지막 노드를 찾고.
        current = current.next;
      }
      current.next = node; // 마지막 위치에 노드 추가
      this.length++;
      return node;
    }

  };
  LinkedList.prototype.search = function (position) {
    var current = this.head;
    var count = 0;
    while (count < position) {
      current = current.next;
      count++;
    }
    return current.data;
  };
  LinkedList.prototype.remove = function (position) {
    var current = this.head;
    var before, remove, count = 0;
    if (position === 0) {
      remove = this.head;
      this.head = this.head.next;
      this.length--;
      return remove;
    }

    while (count < position) {
      before = current;
      count++;
      current = current.next;
    }
    remove = current;
    before.next = remove.next;
    this.length--;
    return remove;
  };
  return LinkedList;
})();

const list = new LinkedList();
list.add(1);
list.add(2);
list.add(3);
console.log(list.length);
console.log(list.search(0));
console.log(list.search(2));

list.remove(1);
console.log(list.length);
console.log(list.search(1));
