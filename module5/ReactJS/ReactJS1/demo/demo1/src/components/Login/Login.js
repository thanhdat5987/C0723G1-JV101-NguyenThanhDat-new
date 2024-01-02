import {useState} from "react";

function Login(){
    const [data,setData]= useState({
        email:"",
        password:"",
    })
    const [error,setError] =useState("");
    const changeInput =(evt)=>{
        const name = evt.target.name;
        if(name==="email"){
            setData({...data,email:evt.target.value});
        }else {
            setData({...data, password: evt.target.value});
        }
        console.log(data.email, data.password)
    }
    const submitLogin=(evt)=>{
        //ngan viec submit len server
        evt.preventDefault();
        if(data.email === "admin@gmail.com" && data.password ==="1234"){
            alert("Login successfully")
            setError("");
        }else {
            setError("Account not exits!")
        }
    }

    return(
        <>
        {error && (<p>{error}</p>)}
            <form onSubmit={submitLogin}>
                Email:
                <input type="email" name="email" onChange={changeInput}/>
                Password:
                <input type ="password" name="password" onChange={changeInput}/>
                <button type="submit">Login</button>
            </form>
        </>
    )
}
export default Login;