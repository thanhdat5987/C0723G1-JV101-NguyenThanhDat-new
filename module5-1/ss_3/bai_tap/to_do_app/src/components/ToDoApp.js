import React, {useState} from "react";

function ToDoApp() {
    const [job, setJob] = useState("");
    const [jobList, setJobList] = useState([]);
    const handleChange = (event) => {
        setJob(event.target.value);
    }
    const handleAddItem = () => {
        if (job.trim() !== '') {
            setJobList(prevJobList => [...prevJobList, job]);
            setJob('');
        }
    }
    return (
        <div>
            <div>
                <h2>TO DO LIST</h2>
                <div>
                    <input value={job} onChange={handleChange}/>
                </div>
                <button onClick={handleAddItem}>Add Mission</button>
            </div>
            <div>
                <table>
                    <thead>
                    <tr>
                        <th scope="col">No.</th>
                        <th scope="col">Mission</th>
                    </tr>
                    </thead>
                    <tbody>
                    {jobList.map((job, index) => (
                        <tr key={index}>
                            <td>{index + 1}</td>
                            <td>{job}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default ToDoApp;