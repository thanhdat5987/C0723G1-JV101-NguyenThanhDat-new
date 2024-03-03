import {useState} from "react";
function Counter2 (){
    const [count, setCount]=useState(0);
    const handleClick = ()=>{
        const newCount = count +2;
        setCount(newCount);
    }
    return (
        <>
            <h3>Count: {count}</h3>
            <button onClick={handleClick}>Add 2</button>
        </>
    )
}
export default Counter2;