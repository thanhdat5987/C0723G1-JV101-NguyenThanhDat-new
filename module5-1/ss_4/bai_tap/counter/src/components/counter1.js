import {useState} from "react";
function Counter1 (){
    const [count, setCount] = useState(0);
    const handleClick = ()=>{
        const newCount = count +1;
        setCount(newCount);
    }
    return(
        <>
            <h3>Count: {count}</h3>
            <button onClick={handleClick}>Add1</button>
        </>
    );
}

export default Counter1;