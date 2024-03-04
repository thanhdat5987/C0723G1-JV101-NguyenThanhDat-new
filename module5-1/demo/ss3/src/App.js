import logo from './logo.svg';
import './App.css';
import StudentList from "./components/student/StudentList";
import DemoState from "./components/DemoState";

function App() {

    return (
        <>
            <StudentList nameClass="C10" school="CodeGym"></StudentList>
            <DemoState></DemoState>
        </>
    );
}

export default App;
