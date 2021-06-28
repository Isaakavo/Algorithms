function weekTemps() {
  this.dataStore = [];
  this.add = add;
  this.average = average;
}
function add(temp) {
  this.dataStore.push(temp);
}
function average() {
  var total = 0;
  for (var i = 0; i < this.dataStore.length; ++i) {
    total += this.dataStore[i];
  }
  return total / this.dataStore.length;
}
var thisWeek = new weekTemps();
thisWeek.add(52);
thisWeek.add(55);
thisWeek.add(61);
thisWeek.add(65);
thisWeek.add(55);
thisWeek.add(50);
thisWeek.add(52);
thisWeek.add(49);
console.log(thisWeek.average()); // displays 54.875

// Excercises

// Create a grades object that stores a set of student grades in an object. Provide a
// function for adding a grade and a function for displaying the student’s grade average.

class Student {
  constructor() {
    this.grades = [];
  }

  addGrade(grade) {
    this.grades.push(grade);
  }

  get average() {
    let total = 0;
    for (let i = 0; i < this.grades.length; i++) {
      total += this.grades[i];
    }
    return total / this.grades.length;
  }
}

let Joe = new Student();
let Mari = new Student();

Joe.addGrade(98);
Joe.addGrade(75);
Joe.addGrade(85);

console.log(Joe.average());
