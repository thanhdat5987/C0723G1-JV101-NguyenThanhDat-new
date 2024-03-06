import axios from "axios";

export const getAllStudent = async () =>{
    try {
        const res = await axios.get("http://localhost:8080/students");
        return res.data;
    } catch (err) {
        return []
    }

}

export const addNewStudent = async (student) => {
    try {
        await axios.post("http://localhost:8080/students", student)
    } catch (err) {
        console.log(err)
    }

}