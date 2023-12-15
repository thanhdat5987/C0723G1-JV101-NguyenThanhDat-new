// 7. Sử dụng destructuring để trích xuất các giá trị "name" và "age" từ một mảng chứa các đối tượng "person".
let persons = [{name: "Dat", age: 18}, {name: "Thuan", age: 19}, {name: "An", age: 17}];
let [person1, person2, person3] = persons;
console.log(person1.name);
console.log(person1.age);
console.log(person2.name);
console.log(person2.age);
console.log(person3.name);
console.log(person3.age);
