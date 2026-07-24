import { createContext, useContext, useState } from "react";

const ResumeContext = createContext();

export function ResumeProvider({ children }) {

    const [resume, setResume] = useState({
        resumeId: null,
        uploaded: false,
        uploading: false,
    });

    return (
        <ResumeContext.Provider value={{ resume, setResume }}>
            {children}
        </ResumeContext.Provider>
    );
}

export function useResume() {
    return useContext(ResumeContext);
}