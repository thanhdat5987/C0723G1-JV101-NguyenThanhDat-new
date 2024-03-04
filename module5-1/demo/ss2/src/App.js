import logo from './logo.svg';
import './App.css';
import React from "react";

function App() {
    const students = [
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
    ]
    return (
        //   JSX = JavaScript + XML
        <>
            {/*<h1 id="C09" name="C09" className="C09">Xin chào</h1>*/}
            {/*<h2>123</h2>*/}
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
        </>

        //  createElement
        //     React.createElement("h1", {id: "C09", name: "C09", className: "c09"}, "Xin chào")
    )
        ;
}

export default App;
