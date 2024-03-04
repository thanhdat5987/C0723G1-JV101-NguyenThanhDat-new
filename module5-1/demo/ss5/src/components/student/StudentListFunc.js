import {useEffect, useState} from "react";
import * as studentService from "../../services/StudentService"
import {Link, NavLink} from "react-router-dom";

function StudentListFunc() {
    const [students, setStudents] = useState([]);
    const [student, setStudent] = useState({});
    const [name, setName] = useState("")

    useEffect(() => {
        console.log(1)
        const result = studentService.getAllStudent();
        //Call DB
        setStudents(result)
    }, [])

    // Chỉ chạy khi name bị thay đổi giá tr
    useEffect(() => {
        console.log(1)
        // Call DB để search
    }, [name])

    const changeStudent = (event, key) => {
        let value = event.target.value;
        // Có thể dùng nhưng có thể xảy ra bất đồng bộ
        // setStudent({
        //     ...student,
        //     id: value
        // })

        setStudent(prevState => {
            return {
                ...prevState,
                // key động ES6
                [key]: value
            }
        })
    }

    const addStudent = () => {
        setStudents(prevState => {
            return [
                ...prevState,
                student
            ]
        })
        setStudent({id: "", name: "", address: ""})
    }


    return (
        <>
            <Link to="/students/create">
                Thêm mới
            </Link>
            <NavLink to="/students/create">
                Thêm mới
            </NavLink>
            Search name: <input value={name} onChange={(event) => setName(event.target.value)}/>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                </tr>
                </thead>
                <tbody>
                {
                    students.map(student => (
                        // Key prop
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.name}</td>
                            <td>{student.address}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>

            ID: <input value={student.id} onChange={(event) => changeStudent(event, "id")}/>
            Name: <input value={student.name} onChange={(event) => changeStudent(event, "name")}/>
            Address: <input value={student.address} onChange={(event) => changeStudent(event, "address")}/>
            <button type="button" onClick={addStudent}>Thêm mới</button>
        </>
    )
}

export default StudentListFunc;