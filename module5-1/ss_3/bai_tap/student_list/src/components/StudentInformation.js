import {Component} from "react";

class Student extends Component {
    constructor(props) {
        super(props);
        this.state = {
            students: [
                {
                    id: 1,
                    name: 'Nguyen Thanh Dat',
                    age: 25,
                    address: 'Quang Nam'
                },
                {
                    id: 2,
                    name: 'Vo Quoc Giau',
                    age: 27,
                    address: 'Ha Tinh'
                },
                {
                    id: 3,
                    name: 'Tran Linh Giang',
                    age: 19,
                    address: 'Quang Binh'
                },
                {
                    id: 4,
                    name: 'Nguyen Tat Quyen',
                    age: 17,
                    address: 'Quang Ngai'
                }
            ]
        }
    }

    render() {
        return (
            <>
                <div>
                    <h2>Danh sách sinh viên</h2>
                    <table>
                        <thead>
                        <tr>
                            <th>STT</th>
                            <th>Họ và Tên</th>
                            <th>Tuổi</th>
                            <th>Địa chỉ</th>
                        </tr>
                        </thead>
                        <tbody>
                        {this.state.students.map((student, index) => (
                            <tr key={student.id}>
                                <th>{index + 1}</th>
                                <td>{student.name}</td>
                                <td>{student.age}</td>
                                <td>{student.address}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </>
        )
    }
}

export default Student;