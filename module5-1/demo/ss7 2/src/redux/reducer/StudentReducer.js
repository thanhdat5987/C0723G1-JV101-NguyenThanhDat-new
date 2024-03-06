import {ADD_NEW_STUDENT, GET_ALL_STUDENT} from "../CONST_TYPE";

const studentReducer= (students = [], action) => {
    const {type, payload} = action;
    switch (type) {
        case GET_ALL_STUDENT:
            return payload;
        case ADD_NEW_STUDENT:
           return [...students, payload];

        default:
            return students;
    }

}

export default studentReducer;