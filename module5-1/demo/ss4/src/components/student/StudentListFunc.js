import {useEffect, useState} from "react";

function StudentListFunc() {
    const [students, setStudents] = useState([]);
    const [student, setStudent] = useState({});
    const [name, setName] = useState("")

    useEffect(() => {
        console.log(1)
        //Call DB
        setStudents([
            {
                id: 1,
                name: "HaiTT",
                address: "Quảng Nam"
            },
            {
                id: 2,
                name: "HaiTT1",
                address: "Quảng Nam1"
            }
        ])
    }, [])

    // Chỉ chạy khi name bị thay đổi giá tri
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