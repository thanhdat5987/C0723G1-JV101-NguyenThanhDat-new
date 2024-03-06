import './App.css';
import MedicalForm from "./components/MedicalForm";
import {ToastContainer} from "react-toastify";

function App() {
    return (
        <div className="App">
            <MedicalForm></MedicalForm>
            <ToastContainer></ToastContainer>
        </div>
    );
}

export default App;
