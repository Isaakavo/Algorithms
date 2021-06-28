// This code excercise was made from Data structures and algorithms with javascript
// Chapter 3

class List {
  constructor() {
    this.listSize = 0;
    this.pos = 0;
    this.dataStore = [];
  }

  append(element) {
    this.dataStore[this.listSize++] = element;
  }

  find(element) {
    for (let i = 0; i < this.dataStore.length; i++) {
      if (this.dataStore[i] == element) {
        return i;
      }
    }
    return -1;
  }

  remove(element) {
    let foundAt = this.find(element);
    if (foundAt > -1) {
      this.dataStore.splice(foundAt, 1);
      this.listSize--;
      return true;
    }
    return false;
  }

  insert(element, after) {
    let insertPos = this.find(after);
    if (insertPos > -1) {
      this.dataStore.splice(insertPos + 1, 0, element);
      this.listSize++;
      return true;
    }
    return false;
  }

  clear() {
    delete this.dataStore;
    this.dataStore = [];
    this.listSize = this.pos = 0;
  }

  contains(element) {
    for (let i = 0; i < this.dataStore.length; i++) {
      if (this.dataStore[i] == element) {
        return true;
      }
    }
    return false;
  }

  front() {
    this.pos = 0;
  }

  end() {
    this.pos = this.listSize - 1;
  }

  prev() {
    if (this.pos > 0) {
      this.pos--;
    }
  }

  next() {
    if (this.pos <= this.listSize - 1) {
      this.pos++;
    }
  }

  currPos() {
    return this.pos;
  }

  moveTo(position) {
    this.pos = position;
  }

  getElement() {
    return this.dataStore[this.pos];
  }

  length() {
    return this.listSize;
  }

  toString() {
    return this.dataStore;
  }
}

class Customer {
  constructor(name, movie) {
    this.name = name;
    this.movie = movie;
  }
}

// var names = new List();
// names.append('Clayton');
// names.append('Raymond');
// names.append('Cynthia');
// names.append('Jennifer');
// names.append('Bryan');
// names.append('Danny');

// names.front();
// console.log(names.getElement());

// names.next();
// console.log(names.getElement());

// names.next();
// names.next();
// names.prev();
// console.log(names.getElement());

// for (names.front(); names.currPos() < names.length(); names.next()) {
//   console.log(names.getElement());
// }
const fs = require('fs');

const moviesList = new List();
const customers = new List();
const rentedMovies = new List();

const movies = (path, opts = 'utf8') =>
  new Promise((resolve, reject) => {
    fs.readFile(path, opts, (err, data) => {
      if (err) reject(err);
      else resolve(data);
    });
  });

const run = async () => {
  const res = await movies('./films.txt');
  let movieTemp = res.toString().split('\n');
  for (let i = 0; i < movieTemp.length; i++) {
    const movieSlice = movieTemp[i].slice(3).trim();
    moviesList.append(movieSlice);
  }
  console.log('Available movies: \n');
  displayList(moviesList);
  checkout('Jane Doe', 'The Godfather', moviesList, customers);
  checkout('Isaak Haas', 'Fight Club', moviesList, customers);
  checkout('Isaak Haas', 'Star Wars', moviesList, customers);

  console.log('\nCustomer Rentals: \n');
  displayList(customers);

  console.log('\nList of rented movies: \n');
  displayList(rentedMovies);

  console.log('\nCheking in movies\n');
  checkIn('Jane Doe', 'The Godfather', moviesList, customers);

  console.log('\nThe new movie list is: \n');
  displayList(moviesList);

  console.log('\nAnd the customers are: \n');
  displayList(customers);
};

run();

function displayList(list) {
  for (list.front(); list.currPos() < list.length(); list.next()) {
    if (list.getElement() instanceof Customer) {
      console.log(
        list.getElement()['name'] + ', ' + list.getElement()['movie']
      );
    } else {
      console.log(list.getElement());
    }
  }
}

function checkout(name, movie, filmList, customerList) {
  if (filmList.contains(movie)) {
    let c = new Customer(name, movie);
    customerList.append(c);
    rentedMovies.append(movie);
    filmList.remove(movie);
  } else {
    console.log(movie + ' is not available');
  }
}

function checkIn(name, movie, filmList, customerList) {
  for (
    customerList.front();
    customerList.currPos() < customerList.length();
    customerList.next()
  ) {
    const currentCustomer = customerList.getElement();
    if (currentCustomer.name === name && currentCustomer.movie === movie) {
      filmList.append(movie);
      customerList.remove(currentCustomer);
    } else {
      console.log('Customer or movie dont exist');
    }
  }
}

// console.log(movies);
// fs.readFile('films.txt', (err, data) => {
//   if (err) throw err;

//   // console.log(data.toString());
//   let movies = data.toString().split('\n');
//   console.log(movies);
//   // for (let i = 0; i < movies.length; i++) {
//   //   movies[i] = movies[i].trim();
//   // }
//   // console.log(movies);
//   for (let i = 0; i < movies.length; i++) {
//     moviesList.append(movies[i]);
//   }
// });

// console.log(moviesList.getElement());
