import logo from './logo.svg';
import './App.css';
import {Route, Routes} from "react-router-dom";
import {CreateBook} from "./components/CreateBook";
import {UpdateBook} from "./components/EditBook";
import {ToastContainer} from "react-toastify";
import {BookList} from "./components/BookList";
import {Error} from "./components/Error";

function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<BookList/>}></Route>
                <Route path="/create" element={<CreateBook/>}></Route>
                <Route path="/update/:id" element={<UpdateBook/>}></Route>
                <Route path="/error" element={<Error/>}></Route>
            </Routes>
            <ToastContainer/>
        </>
    );
}

export default App;
