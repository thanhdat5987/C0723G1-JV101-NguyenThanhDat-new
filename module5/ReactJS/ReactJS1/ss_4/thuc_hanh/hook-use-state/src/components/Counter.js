import {useState} from "react";
function Counter(){
    const [count, setCount] =useState(0);
    const handleClick = ()=>{
        const newCount = count +2;
        setCount(newCount);
    }
    return(
        <>
        <p>Value {count}</p>
        <button onClick={handleClick}>Click me</button>
        </>
    )
}
export default Counter;