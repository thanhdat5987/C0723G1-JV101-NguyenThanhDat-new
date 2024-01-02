import React, {useState} from "react";
import * as events from "events";
function ToDoList(){
    const [job, setJob]=useState("");
    const [jobList, setJobList]=useState([]);
    const handleChange = (event)=>{
        setJob(event.target.value);
    }
    const handleAddItem = ()=>{
        if(job.trim()!==''){
            setJobList(prevJobList =>[...prevJobList,job]);
            setJob('');
        }
    }
    return(
        <div>
            <input value={job} onChange={handleChange}/>
            <button onClick={handleAddItem}>Add</button>
            {
                jobList.map((job) =>(<p>{job}</p>
                    )
                )
            }
        </div>
    )
}
export default ToDoList;