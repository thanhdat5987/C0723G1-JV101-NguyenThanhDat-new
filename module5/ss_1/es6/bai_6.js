// 6. Sử dụng destructuring với rest parameter để trích xuất phần tử đầu tiên vào biến "first" và các phần tử còn lại vào một mảng mới "rest".
let numbers = [-1, -2, 6, 17, 14, 0, 1, 8, 9, 10, 11, 7, 3, 4];
let [x, ...args] = numbers;
console.log("Phan tu dau tien: " + x);
console.log("Cac phan tu con lai tao thanh mang: " + args);
