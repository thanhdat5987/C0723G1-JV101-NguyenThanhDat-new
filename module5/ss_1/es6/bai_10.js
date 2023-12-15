// 10. Tạo một đối tượng "book" với thuộc tính "title", "author" và "pages" bằng cách sử dụng Enhanced object literals.
// Đối tượng "book" cũng có phương thức "displayInfo" để in ra thông tin về sách.
let book = {
    title: "Doi ngan dung ngu dai",
    author: "Robin Sharma",
    pages: 89,
    displayInfo() {
        console.log(this.title);
        console.log(this.author);
        console.log(this.pages);
    }
}
book.displayInfo();