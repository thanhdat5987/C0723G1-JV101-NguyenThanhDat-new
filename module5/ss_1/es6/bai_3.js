// 3. Kiểm tra 1 mảng có chứa số V hay không nếu có trả về V không thì trả về "không tìm thấy" (some).
let numbers = [-1, -2, 6, 17, 14, 0, 1, 8, 9, 10, 11, 7, 3, 4];
function checkV(number, array){
    if (array.some(item => item === number)) {
        console.log(number);
    } else {
        console.log("Khong tim thay");
    }
}
checkV(-1,numbers)
