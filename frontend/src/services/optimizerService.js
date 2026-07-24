import api from "../api/axiosConfig";

export async function optimizeResume(data) {

    const response = await api.post(
        "/api/optimizer/optimize",
        data
    );

    return response.data;

}