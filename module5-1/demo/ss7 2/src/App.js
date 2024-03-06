
import './App.css';
import StudentListFunc from "./components/student/StudentListFunc";
import StudentCreate from "./components/student/StudentCreate";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import 'react-toastify/dist/ReactToastify.css';
import {ToastContainer} from "react-toastify";
import StudentUpdate from "./components/student/StudentUpdate";
import {useEffect} from "react";
import {useDispatch, useSelector} from "react-redux";
import {getAllStudentByMiddleware} from "./redux/middleware/StudentMiddleware";

function App() {
    const dispatch = useDispatch();
    const students = useSelector(store => store.students)
    // componentDidMount
    useEffect(() => {
        dispatch(getAllStudentByMiddleware());
    }, [])

    return (
        <>
            Tổng số học sinh của lớp là {students.length}
            <BrowserRouter>
                <Routes>
                    <Route path="/students" element={<StudentListFunc/>}></Route>
                    <Route path="/students/create" element={<StudentCreate/>}></Route>
                    <Route path="/students/:id/update" element={<StudentUpdate/>}></Route>
                </Routes>
            </BrowserRouter>
            <ToastContainer></ToastContainer>
            {/*<StudentListFunc></StudentListFunc>*/}
        </>
    );
}

export default App;
