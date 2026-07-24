import api from "../api/axiosConfig";

export async function analyzeResume(data) {

    const response = await api.post("/analyze", data);

    return response.data;

}