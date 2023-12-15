// 3. Kiểm tra 1 mảng có chứa số V hay không nếu có trả về V không thì trả về "không tìm thấy" (some).
let numbers = [-1, -2, 6, 17, 14, 0, 1, 8, 9, 10, 11, 7, 3, 4];
if (numbers.some(number => number === -1)) {
    console.log(-1);
} else {
    console.log("Khong tim thay");
}