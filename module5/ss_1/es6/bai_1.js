// 1. Tạo một mảng mới chứa các số lớn hơn 5 từ mảng ban đầu (map).
let numbers = [-1, -2, 6, 17, 14, 0, 1, 8, 9, 10, 11, 7, 3, 4];
let newNumbers = numbers.map(number => {
    if (number > 5) {
        return number;
    }
})
console.log(newNumbers)
let newNumbers2 = newNumbers.filter(number => {
    if (number > 5) {
        return number;
    }
})
console.log(newNumbers2);
