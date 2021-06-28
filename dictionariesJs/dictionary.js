class Dictionary {
  constructor() {
    this.dataStore = new Array();
    this.size = 0;
  }

  add(key, value) {
    this.dataStore[key] = value;
    this.size++;
  }

  find(key) {
    return this.dataStore[key];
  }

  remove(key) {
    delete this.dataStore[key];
    this.size--;
  }

  clear() {
    for (const key in this.dataStore) {
      if (Object.hasOwnProperty.call(this.dataStore, key)) {
        delete this.dataStore[key];
        this.size--;
      }
    }
  }

  count() {
    return this.size;
  }

  showAll() {
    for (const key in this.dataStore) {
      if (Object.hasOwnProperty.call(this.dataStore, key)) {
        const element = this.dataStore[key];
        console.log(key + '-> ', element);
      }
    }
  }
}

let pbook = new Dictionary();
pbook.add('Raymond', '123');
pbook.add('David', '345');
pbook.add('Cynthia', '456');
console.log('Number of entries: ' + pbook.count());
console.log("David's extension: " + pbook.find('David'));
pbook.showAll();
pbook.showAll();
pbook.clear();
console.log('Number of entries: ' + pbook.count());

//Excercises

let text = 'the brown fox jumped over the blue fox';
let words = text.split(' ');
let dic = new Dictionary();

for (const word of words) {
  // if (dic.find(word) === undefined) {
  //   dic.add(word, 1);
  // } else {
  //   let value = dic.find(word);
  //   dic.add(word, ++value);
  // }
  dic.add(word, (dic.find(word) || 0) + 1);
}

dic.showAll();
