// 2. Sử dụng arrow function và reduce để tính tổng các phần tử trong mảng.
let numbers = [-1, -2, 6, 17, 14, 0, 1, 8, 9, 10, 11, 7, 3, 4];
let sum = numbers.reduce((sum, item) => sum + item, 0);
console.log("Tổng số phần tử trong mảng:" + sum);