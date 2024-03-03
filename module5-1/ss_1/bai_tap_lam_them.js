//Bài1	Sử dụng ES6 ( arrow function, fitter)
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

let arr = [-5, 4, 2, 7, 8, 9]
const newArr = arr.filter(number => checkPrime(number))
console.log(newArr)

// Bài 2	Sử dụng  Destructuring, rest, spread
//Hãy tạo ra 1 đối tượng student gồm các thuộc tính và giá trị lấy từ đối tượng person và hiển thị ra thông tin của student vừa tạo
const person = {
    firstName: 'John',
    lastName: 'Doe',
    age: 30,
    gender: 'male',
    occupation: 'developer',
    nationality: 'American',
    city: 'New York',
    hobbies: ['reading', 'traveling', 'photography'],
    languages: ['English', 'Spanish'],
    education: {
        degree: 'Bachelor',
        major: 'Computer Science',
        university: 'Harvard University'
    }
};

const {firstName, gender, education, languages} = person;
const {degree} = education;
const english = languages.at(0);
const student = {
    firstName,
    gender,
    education: degree,
    english,
};

console.log(student);

// Bai 3: Viết một function có tham số là một đối tượng bất kỳ .
//     Function sẽ hiển thi ra 2 thuộc tính firstName và degree
// + Nếu đối tượng truyền vào không có thuộc tính firstName thì firstNam có giá trị mặc định là "Quân", tương tự với degree là "NA"
function displayInfo({firstName = "Quân", degree = "N/A"}) {
    console.log(`firstName: ${firstName}, degree: ${degree}`);
}

//test
const person1 = {firstName: 'Dat', degree: 'Dai Hoc'};
displayInfo(person1);
const person2 = {};
displayInfo(person2)