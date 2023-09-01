/**
 * Edited by datnt on 8/21/2023.
 */
function Hero(image, top, left, size, speed, direction) {
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;
    this.speed = speed;
    this.direction = direction
    this.getHeroElement = function () {
        return '<img width="' + this.size + '"' +
            ' height="' + this.size + '"' +
            ' src="' + this.image + '"' +
            ' style="top: ' + this.top + 'px; left:' + this.left + 'px;position:absolute;" />';
    }
    this.moveRight = function () {
        this.left += this.speed;
        console.log('ok: ' + this.left);
    }
    this.moveBottom = function () {
        this.top += this.speed;
        console.log('ok: ' + this.top)
    }
    this.moveLeft = function () {
        this.left -= this.speed;
    }
    this.moveTop = function () {
        this.top -= this.speed;
    }
}
var hero = new Hero('anime.jpg', 20, 20, 200, 100, "right");
function start() {
    if (hero.direction === "right") {
        if (hero.left < window.innerWidth - hero.size) {
            hero.moveRight();
        } else {
            hero.direction = "bottom"
        }
    }
    if (hero.direction === "bottom") {
        if (hero.top < window.innerHeight - hero.size - 100) {
            hero.moveBottom();
        } else {
            hero.direction = "left"
        }
    }
    if (hero.direction === "left") {
        if (hero.left > 20) {
            hero.moveLeft()
        } else {
            hero.direction = "top"
        }
    }
    if (hero.direction === "top") {
        if (hero.top > 20) {
            hero.moveTop()
        } else {
            hero.direction = "right"
        }
    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 500)
}
start()






