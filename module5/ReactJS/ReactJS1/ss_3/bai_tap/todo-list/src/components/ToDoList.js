import {Component} from "react";

class ToDo extends Component {
    constructor(props) {
        super(props);
        this.state = {
            list: [
                {
                    id: 1,
                    name: "giặt đồ"
                },
            ],
            item: "",
        }
    }

    handleChange = (event) => {
        this.setState({
            item: {name: event.target.value}
        })
    }

    handleAddItem = () => {
        if (this.state.item.name.trim() !== "") {
            const newId = this.state.list[this.state.list.length-1].id +1;
            this.setState((prevState) =>
                ({
                    ...prevState,
                    list: [...prevState.list, {
                        ...prevState.item, id: newId
                    }]
                }));
        } else {
            alert("Vui lòng nhập nhiệm vụ")
        }

    }

    render() {
        return <>
            <div>
                <h2>TO DO LIST</h2>
                <div>
                    <input onChange={this.handleChange}/>
                </div>
                <button onClick={this.handleAddItem}>Thêm nhiệm vụ</button>
            </div>
            <div>
                <table>
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Nhiệm vụ</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.list.map((job, index) => (
                        <tr key={job.id}>
                            <td>{index + 1}</td>
                            <td>{job.name}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </>
    }
}

export default ToDo;