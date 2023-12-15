// 8. Sử dụng Rest parameter và Spread operator để tạo một hàm nhận vào danh sách các số và trả về tổng của chúng.
function myFunction(...numbers) {
    return numbers.reduce((sum, item) => sum + item, 0);
}

console.log(myFunction(1, 5, 8));