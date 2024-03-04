import {Component} from "react";

class StudentList extends Component {
    constructor(props) {
        super(props);
        // Không call DB đươợc vì không thẻ xử lý bất đồng bộ
        this.state = {
           students: [],
            nameSearch: ""

        }

    }
    componentDidMount() {
        // Call DB để lấy dữ liệu
        this.setState({
            students: [
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
            ] ,
            nameSearch: ""
        })
    }

    changeNameSearch = (event) => {
        console.log(event)
        this.setState({nameSearch: event.target.value})
    }

    render() {

        return (
            <>
                <h1>Danh sách học sinh của lớp {this.props.nameClass}, trường {this.props.school}</h1>
                <input value={this.state.nameSearch} onChange={(event) => this.changeNameSearch(event)}/>
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
                        this.state.students.map(student => (
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
        )
    }
}

export default StudentList
