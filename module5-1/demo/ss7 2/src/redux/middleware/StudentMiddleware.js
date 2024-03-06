import * as studentService from "../../services/StudentService"
import {ADD_NEW_STUDENT, GET_ALL_STUDENT} from "../CONST_TYPE";

export const getAllStudentByMiddleware = () => async (dispatch) => {
    const result = await studentService.getAllStudent();
    dispatch({
        type: GET_ALL_STUDENT,
        payload: result
    })
}

export const addNewStudentByMiddleware = (value) => async(dispatch) => {
    const result = await studentService.addNewStudent(value);
    dispatch({
        type: ADD_NEW_STUDENT,
        payload: value
    })
}