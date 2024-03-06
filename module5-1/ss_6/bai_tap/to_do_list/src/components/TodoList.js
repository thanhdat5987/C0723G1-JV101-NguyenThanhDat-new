import React, {useEffect, useState} from "react";
import "../data/db"
import "../service/TodoListService"
import {addTodo, getAllToDo} from "../service/TodoListService";
import {Field, Form, Formik} from 'formik';

function TodoList() {
    const [todoList, setTodo] = useState([])
    const createTodo = async (task) => {
        await addTodo(task)
        setTodo("")
    }

    const getAll = async () => {
        let data = await getAllToDo();
        setTodo(data);
    }

    useEffect(() => {
        getAll()
    }, [])

    return (
        <>
            <Formik initialValues={
                {
                    name: ''
                }
            }
                    onSubmit={createTodo}>
                <Form>
                    <h1> Todo List</h1>
                    <Field name="name"/>
                    <button>Submit</button>

                    <table className="table">
                        <thead>
                        <tr>
                            <th>Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            todoList.map((todo) => (
                                <tr key={todo.id}>
                                    <td>{todo.name}</td>
                                </tr>
                            ))
                        }
                        </tbody>
                    </table>
                </Form>
            </Formik>
        </>
    )
}

export default TodoList;