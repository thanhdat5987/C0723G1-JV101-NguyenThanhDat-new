// hello()
// function hello() {
//     var a = 6;
//     console.log(a)
// }


// const hello = () => {
//     console.log("C09")
// }
//
// hello();
chao = (name)=>{
    console.log("hello" + name);
}
chao("dog");
// function Dog(name) {
//     this.name = name;
// }
// const Dog = (name) => {
//     this.name = name
//
// }
//
// let dog = new Dog("abc");
// console.log(dog.name)

class Dog {
    constructor(name) {
        this.name = name
    }

    c() {
        console.log(this.name, this)
    }

    d = () => {
        console.log(this.name, this)
    }
}

let dog = new Dog("abc")
dog.c();
dog.d();


