import React, {useState} from 'react';

function Calculate() {
    // Khai báo 1 biến trạng thái mới đặt tên là "count"
    const [number1, setNumber1] = useState(0);
    const [number2, setNumber2] = useState(0);
    const [result, setResult] = useState(0);
    const number1Int = parseInt(number1);
    const number2Int = parseInt(number2);
    const sum = () => {
        setResult(number2Int+number1Int );
    }
    const divi = () =>{
        if(number2Int !==0){
            setResult(number1Int/number2Int);
        }else {alert("number 2 must not be 0")}
    }
    return (
        <div>
            <input type={"text"} value={number1} onChange={(e) => setNumber1(e.target.value)}/>
            <input type={"text"} value={number2} onChange={(e) => setNumber2(e.target.value)}/>
            <button onClick={()=>setResult(number1 - number2)}>-</button>
            <button onClick={sum}>+</button>
            <button onClick={()=>setResult(number1Int * number2Int)}>x</button>
            <button onClick={divi}>/</button>
            <h1>Result {result}</h1>
        </div>
    );
}

export default Calculate;