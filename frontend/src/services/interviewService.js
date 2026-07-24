import api from "../api/axiosConfig";


export async function generateInterviewQuestions(data) {

    const response = await api.post(

        "http://localhost:8080/api/interview/generate",
        data

    );

    return response.data;

}