class Queue {
  constructor() {
    this.dataStore = [];
  }

  enqueue(element) {
    this.dataStore.push(element);
  }

  //Dequeue for priority queue
  // dequeue() {
  //   let priority = this.dataStore[0].code;
  //   for (let i = 0; i < this.dataStore.length; i++) {
  //     if (this.dataStore[i].code < priority) {
  //       priority = i;
  //     }
  //   }
  //   return this.dataStore.splice(priority, 1);
  // }
  dequeue(element) {
    return this.dataStore.shift();
  }
  front() {
    return this.dataStore[0];
  }
  back() {
    return this.dataStore[this.dataStore.length - 1];
  }
  toString() {
    let retStr = '';
    for (const element of this.dataStore) {
      retStr += element.name + ' code: ' + element.code + '\n';
    }
    return retStr;
  }
  empty() {
    return this.dataStore.length === 0;
  }
}

//Testing the class
// const q = new Queue();
// q.enqueue('Meredith');
// q.enqueue('Cynthia');
// q.enqueue('Jennifer');
// console.log(q.toString());
// q.dequeue();
// console.log(q.toString());
// console.log('Front of queue: ' + q.front());
// console.log('Back of queue: ' + q.back());

//Sorting data with queues

// The radix sort works by making two passes over a data set, in this case the set of integers from 0 to 99.
// The first pass sorts the numbers based on the 1s digit, and the second pass sorts the numbers based on the 10s digit.
// Each number is placed in a bin based on the digit in each of these two places. Given these numbers:

/* the first pass of the radix sort results in the following bin configuration:
    Bin 0:
    Bin 1: 91, 31
    Bin 2: 92, 22
    Bin 3:
    Bin 4:
    Bin 5: 85, 15, 35
    Bin 6: 46
    Bin 7:
    Bin 8:
    Bin 9:
Now the numbers are sorted based on which bin they are in:
91, 31, 92, 22, 85, 15, 35, 46
Next, the numbers are sorted by the 10s digit into the appropriate bins:
    Bin 0:
    Bin 1: 15
    Bin 2: 22
    Bin 3: 31, 35
    Bin 4: 46
    Bin 5:
    Bin 6:
    Bin 7:
    Bin 8: 85
    Bin 9: 91, 92
Finally, take the numbers out of the bins and put them back into a list, and you get the following sorted list of integers:
    15, 22, 31, 35, 46, 85, 91, 92 */

// function distribute(nums, queues, n, digit) {
//   for (let i = 0; i < n; i++) {
//     if (digit === 1) {
//       queues[nums[i] % 10].enqueue(nums[i]);
//     } else {
//       queues[Math.floor(nums[i] / 10)].enqueue(nums[i]);
//     }
//   }
// }

// function collect(queues, nums) {
//   let i = 0;
//   for (let digit = 0; digit < 10; digit++) {
//     while (!queues[digit].empty()) {
//       nums[i++] = queues[digit].dequeue();
//     }
//   }
// }

// function dispArray(arr) {
//   for (let i = 0; i < arr.length; i++) {
//     const element = arr[i];
//     console.log(element + ' ');
//   }
// }

//Main program
// var queues = [];
// for (let i = 0; i < 10; ++i) {
//   queues[i] = new Queue();
// }
// var nums = [];
// for (let i = 0; i < 10; ++i) {
//   nums[i] = Math.floor(Math.floor(Math.random() * 101));
// }

// console.log('Before radix sort: ');
// dispArray(nums);
// distribute(nums, queues, 10, 1);
// collect(queues, nums);
// distribute(nums, queues, 10, 10);
// collect(queues, nums);
// console.log('\n\nAfter radix sort: ');
// dispArray(nums);

//Priority queue

// class Patient {
//   constructor(name, code) {
//     this.name = name;
//     this.code = code;
//   }
// }

//Demostrating priority queue

// var p = new Patient('Smith', 5);
// var ed = new Queue();
// ed.enqueue(p);
// p = new Patient('Jones', 4);
// ed.enqueue(p);
// p = new Patient('Fehrenbach', 6);
// ed.enqueue(p);
// p = new Patient('Brown', 1);
// ed.enqueue(p);
// p = new Patient('Ingram', 1);
// ed.enqueue(p);
// console.log(ed.toString());
// var seen = ed.dequeue();
// console.log('Patient being treated: ' + seen[0].name);
// console.log('Patients waiting to be seen: ');
// console.log(ed.toString());
// // another round
// var seen = ed.dequeue();
// console.log('Patient being treated: ' + seen[0].name);
// console.log('Patients waiting to be seen: ');
// console.log(ed.toString());
// var seen = ed.dequeue();
// console.log('Patient being treated: ' + seen[0].name);
// console.log('Patients waiting to be seen: ');
// console.log(ed.toString());

// 2. Use the Deque class you created in Example 5-1 to determine if a given word is a palindrome.

function isPalidrome(word) {
  let queue = new Queue();
  for (let i = word.length - 1; i >= 0; i--) {
    const char = word[i];
    queue.enqueue(char);
  }
  let reversedString = '';
  while (!queue.empty()) {
    reversedString += queue.dequeue();
  }

  return reversedString === word;
}

console.log(isPalidrome('eye'));
