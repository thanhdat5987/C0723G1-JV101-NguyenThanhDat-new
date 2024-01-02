import React, {useState} from "react";
function StudentList(){
const studentList =[
    {id:1, name:'Dat'},
    {id:2, name:'Ti'}
];
return(
    <div>
        <table>
            <tr>
                <th>TT</th>
                <th>Ten</th>
            </tr>
            {studentList.map(student =>(<tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
            </tr>))}
        </table>
    </div>
)
}
export default StudentList;