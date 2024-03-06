
import './App.css';
import StudentListFunc from "./components/student/StudentListFunc";
import StudentCreate from "./components/student/StudentCreate";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import 'react-toastify/dist/ReactToastify.css';
import {ToastContainer} from "react-toastify";
import StudentUpdate from "./components/student/StudentUpdate";

function App() {

    return (
        <>
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
