// const sum = (a, b, ...arr) => {
//     console.log(arr)
// }
//
// sum(1, 2, 3, 4, 5, 6, 7, 8, 9)

// Gộp 2 mảng.
// const arr1 = [1,2,3];
// const arr2 = [4,5,6];
// let arr3 = arr1.concat(arr2);
// console.log(arr3);
// console.log(arr1);
//
// let result = [...arr1, ...arr2];
// let arr4 = [...arr1];

// console.log(result)
// Object literal
let obj = {
    name: "haiTT",
    age: 18
}
let obj3 = {
    address: "Quảng Nam",
    name: "C09"
}
// Spread operator
// const name = "C10"
let obj1 = {...obj, ...obj3}
console.log(obj1)

//Destructuring
const arr4 = [1,2,3,4,5,6]
// State trong ReactJS
let [a,b,c,...d] = arr4;
console.log(a,b,c,d)

let {address, name: nameStudent, age } = obj1;
console.log(nameStudent, age, address)
