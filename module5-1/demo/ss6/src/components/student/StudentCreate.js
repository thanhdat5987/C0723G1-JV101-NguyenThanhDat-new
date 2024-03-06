import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import * as studentService from "../../services/StudentService"
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";

function StudentCreate() {
    const navigate = useNavigate();
    const initValue = {
        id: "",
        name: "",
        address: ""
    }

    const validateStudent = {
        id: Yup.number().min(0, "Id không được nhỏ hơn 0")
            .max(100000000, "Id không được lớn hơn 100000000")
            .required("Id không được để trống"),
        name: Yup.string().min(3, "Tên không được ít hơn 3 ký tự")
            .max(100, "Tên không được quá 100 ký tự")
            .matches(/^[a-zA-Z ]{3,100}$/, "Ten không đúng định dạng")
    }

    const addNewStudent = async (value) => {
        console.log(value);
        value.id = +value.id;
        await studentService.addNewStudent(value);
        toast.success("Thêm mới thành công")
        navigate("/students")

    }
    return (
        <>
            <Formik validationSchema={Yup.object(validateStudent)} initialValues={initValue} onSubmit={addNewStudent}>
                <Form>
                    ID: <Field name="id"/>
                    <ErrorMessage name="id" component="span"></ErrorMessage>

                    Name: <Field name="name"/>
                    <ErrorMessage name="name" component="span"></ErrorMessage>
                    Address: <Field name="address"/>
                    <button type="submit">Thêm mới</button>
                </Form>
            </Formik>
        </>
    )
}

export default StudentCreate;
