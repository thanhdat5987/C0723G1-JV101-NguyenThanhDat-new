import {useState, useEffect} from "react";
function Selector (){
    let [selected, setSelected] = useState("O");
    let [valueSelected, setValueSelected]=useState("");
    const choice = (e) =>{
        setSelected(e.target.value)
    }
    useEffect(() => {
        switch (selected) {
            case "0":
                setValueSelected("Java");
                break;
            case "1":
                setValueSelected("Angular");
                break;
            case "2":
                setValueSelected("Javascript");
                break;
            case "3":
                setValueSelected("Php");
                break;
            default:
        }
    }, [selected]);
    return(
        <>
        <select onChange={
            e =>{choice(e)}
        }>
            <option value="0">Java</option>
            <option value="1">Angular</option>
            <option value="2">Java Script</option>
            <option value="3">PHP</option>
        </select>
            <p>Your choose: {valueSelected}</p>
        </>
    )
}
export default Selector;