import {useParams} from "react-router-dom";

function StudentUpdate() {
    const param = useParams();

    return (
        <>
            <p>Id là {param.id}</p>
        </>
    )
}

export default StudentUpdate;