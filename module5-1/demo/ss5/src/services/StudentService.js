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

export const getAllStudent = () =>{
    return students;
}

export const addNewStudent = (student) => {
    students.push(student);
}