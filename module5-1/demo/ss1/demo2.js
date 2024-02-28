let arr = [-1, -2, -3, -4, -5, -7];

// Duyệt
// Cú pháp trước ES6
// arr.forEach(function (num) {
//     console.log(num)
// })
//
// // Cú pháp sau ES6
// arr.forEach((num) => {
//     console.log(num)
// })

// Lọc
// let result = arr.filter((num) => num%2==0);

// console.log(result)

// Thay đổi phần tử của mảng
// let result = arr.map((num) => num * 2);
//
// // Nhân đôi các phần tử số chẵn có trong mảng
// let newArr = arr.map(num => (num % 2 === 0 ? num * 2 : num));
// console.log(newArr)

// Tính tổng các phâần tử có trong mảng
let sum = arr.reduce((previousValue, currentValue) =>
    currentValue + previousValue)
console.log('Sum:' + sum)

// Tìm max trong mảng sử dụng reduce
let maxNum = arr.reduce((a, b) => a > b ? a : b);

console.log(maxNum)


const maxValue = arr.reduce((accumulator, currentValue) => Math.max(accumulator, currentValue), 0);
console.log(maxValue)