import { useState } from "react";
import Button from "../common/Button";

import { uploadResume } from "../../services/resumeService";
import { useResume } from "../../context/ResumeContext";

console.log("ResumeUploadCard Rendered");

function ResumeUploadCard() {

    const [selectedFile, setSelectedFile] = useState(null);

    const { resume, setResume } = useResume();

    const handleUpload = async () => {

        if (!selectedFile) {

            alert("Please select a PDF first.");

            return;
        }

        try {

            setResume(prev => ({
                ...prev,
                uploading: true,
            }));

            const response = await uploadResume(selectedFile);

            setResume({
                resumeId: response.resumeId,
                uploaded: true,
                uploading: false,
            });

        }

        catch (error) {

            console.error(error);

            alert("Upload Failed");

            setResume(prev => ({
                ...prev,
                uploading: false,
            }));

        }

    };

    return (

        <section className="bg-white rounded-2xl shadow-sm p-8">

            <h2 className="text-3xl font-bold">
                📄 Upload Resume
            </h2>

            <p className="mt-2 text-gray-500">
                Upload your latest resume in PDF format.
            </p>

            <div className="mt-6 p-6 border-2 border-dashed border-gray-300 rounded-xl bg-gray-50">

                <input
                    type="file"
                    accept=".pdf,application/pdf"
                    onChange={(e) => {

                        const file = e.target.files[0];

                        if (!file) return;

                        setSelectedFile(file);

                    }}
                />

                {
                    selectedFile && (

                        <p className="mt-4 text-green-600 font-medium">

                            ✅ {selectedFile.name}

                        </p>

                    )
                }

            </div>

            <div className="mt-6">

                <Button
                    onClick={handleUpload}
                    disabled={resume.uploading}
                >

                    {
                        resume.uploading
                            ? "Uploading..."
                            : "Upload Resume"
                    }

                </Button>

            </div>

        </section>

    );

}

export default ResumeUploadCard;