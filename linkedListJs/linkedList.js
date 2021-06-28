class Node {
  constructor(element) {
    this.element = element;
    this.next = null;
    this.prev = null;
  }
}

class LinkedList {
  constructor() {
    this.head = new Node('head');
  }

  find(item) {
    let currNode = this.head;
    while (
      currNode.element !== item &&
      currNode.next !== null &&
      currNode.next.element !== 'head'
    ) {
      currNode = currNode.next;
    }
    return currNode;
  }
  findPrevious(item) {
    let currNode = this.head;
    while (currNode.next !== null && currNode.next.element !== item) {
      currNode = currNode.next;
    }
    return currNode;
  }
  insert(newElement, item) {
    let newNode = new Node(newElement);
    let currNode = this.find(item);
    newNode.next = currNode.next;
    currNode.next = newNode;
  }
  remove(item) {
    let prevNode = this.findPrevious(item);
    if (prevNode !== null) {
      prevNode.next = prevNode.next.next;
    }
  }
  display() {
    let currNode = this.head;
    while (currNode.next !== null) {
      console.log(currNode.next.element);
      currNode = currNode.next;
    }
  }
}

let cities = new LinkedList();
cities.insert('Conway', 'head');
cities.insert('Russelville', 'Conway');
cities.insert('Carlisle', 'Russellville');
cities.insert('Alma', 'Carlisle');
cities.display();
console.log('Removing element...');
cities.remove('Carlisle');
cities.display();

class DoublyLinkedList extends LinkedList {
  constructor() {
    super();
  }

  insert(newElement, item) {
    let newNode = new Node(newElement);
    let curr = this.find(item);
    newNode.next = curr.next;
    newNode.prev = curr;
    curr.next = newNode;
  }

  remove(item) {
    let currNode = this.find(item);
    if (currNode.next !== null) {
      currNode.prev.next = currNode.next;
      currNode.next.prev = currNode.prev;
      currNode.next = null;
      currNode.prev = null;
    }
  }

  findLast() {
    let currNode = this.head;
    while (currNode.next !== null) {
      currNode = currNode.next;
    }
    return currNode;
  }

  displayReversed() {
    let currNode = this.findLast();
    while (currNode.prev !== null) {
      console.log(currNode.element);
      currNode = currNode.prev;
    }
  }
}

cities = new DoublyLinkedList();
cities.insert('Conway', 'head');
cities.insert('Russelville', 'Conway');
cities.insert('Carlisle', 'Russellville');
cities.insert('Alma', 'Carlisle');
console.log('Doubly linked list');
cities.display();
console.log('Removing element...');
cities.remove('Carlisle');
cities.display();
console.log('Displaying reversed');
cities.displayReversed();

class CircularLinkedList extends LinkedList {
  constructor() {
    super();
    this.head = new Node('head');
    this.head.next = this.head;
  }
  display() {
    let currNode = this.head;
    while (currNode.next !== null && currNode.next.element !== 'head') {
      console.log(currNode.next.element);
      currNode = currNode.next;
    }
  }
}

cities = new CircularLinkedList();
cities.insert('Conway', 'head');
cities.insert('Russelville', 'Conway');
cities.insert('Carlisle', 'Russellville');
cities.insert('Alma', 'Carlisle');
console.log('Doubly linked list');
cities.display();
console.log('Removing element...');
cities.remove('Carlisle');
cities.display();
