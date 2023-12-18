// 7. Sử dụng destructuring để trích xuất các giá trị "name" và "age" từ một mảng chứa các đối tượng "person".
let persons = [{name: "Dat", age: 18}, {name: "Thuan", age: 19}, {name: "An", age: 17}];
for (const { name, age } of persons) {
    console.log(`Name: ${name}, Age: ${age}`);
}
