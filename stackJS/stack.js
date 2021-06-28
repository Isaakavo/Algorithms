const { Console } = require("console");

class Stack {
  constructor(){
    this.dataStore = [];
    this.top = 0;
  }

  push(element){
    this.dataStore[this.top++] = element;
  }
  pop(){
    return this.dataStore[--this.top];
  }
  peek(){
    return this.dataStore[this.top - 1];
  }
  length(){
    return this.top;
  }
  clear(){
    this.top = 0;
  }
}


//Testing the implementation of stack class

var s = new Stack(); 
s.push("David"); 
s.push("Raymond"); s.push("Bryan"); 
console.log("length: " + s.length()); 
console.log(s.peek());
var popped = s.pop();
console.log("The popped element is: " + popped);
console.log(s.peek());
s.push("Cynthia");
console.log(s.peek());
s.clear();
console.log("length: " + s.length()); 
console.log(s.peek());
s.push("Clayton");
console.log(s.peek());

const multiBaseConverter = (number, base ) => {
  const s = new Stack();
  while(number !== 0){
    s.push(number % base);
    number = Math.floor(number / base)
  }
  let converted = '';
  while(s.length() > 0){
    converted += s.pop();
  }
  return converted;
}

console.log(multiBaseConverter(32, 2));

const isPalidrome = (word) => {
  const wordStack = new Stack();
  for (let i = 0; i < word.length; i++) {
    wordStack.push(word[i]);
  }
  let palindrome = '';
  while(wordStack.length() > 0){
    palindrome += wordStack.pop();
  }

  return palindrome === word ;
}

console.log(isPalidrome('pito'))


//Excercises
// 1. A stack can be used to ensure that an arithmetic expression has balanced paren‐ theses. 
// Write a function that takes an arithmetic expression as an argument and returns the postion in 
// the expression where a parenthesis is missing. An example of an arithmetic expression with unbalanced 
// parentheses is 2.3 + 23 / 12 + (3.14159 * .24.

let pairs = { '(': ')', '{': '}', '[': ']' };

function validateExpression(expression) {
  const expressionStack = new Stack();
  for (const char of expression.split('')) {
    if (['(', '[', '{'].includes(char)) {
      expressionStack.push(char);
    }else{
      const topChar = expressionStack.pop();
      if ((pairs[topChar] !== char)) {
        return false;
      }
    }
  }
  return expressionStack.length() === 0;
}


console.log(validateExpression('({}'));
