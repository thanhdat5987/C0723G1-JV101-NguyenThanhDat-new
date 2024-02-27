// 1. Viết hàm kiểm tra 1 số có phải là số nguyên tố
checkPrime = (number) => {
    let check = true;
    if (number > 1) {
        for (let i = 2; i <= Math.sqrt(number); i++) {
            if (number % 2 === 0) {
                check = false;
                break;
            }
        }
        if (check) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

// 2. Cho 1 mảng số nguyên. Sử dụng filter để lọc ra các số là số nguyên tố

let arr =[-5,4,2,7,8,9]
const newArr = arr.filter(number =>checkPrime(number))
console.log(newArr)

