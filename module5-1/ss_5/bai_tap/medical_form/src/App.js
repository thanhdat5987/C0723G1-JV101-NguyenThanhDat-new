import './App.css';
import MedicalForm from "./components/MedicalForm";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import React from "react";

function App() {
    return (
        <>
            <MedicalForm/>
            <ToastContainer></ToastContainer>
        </>
    );
}

export default App;