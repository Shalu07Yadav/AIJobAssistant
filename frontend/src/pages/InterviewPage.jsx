import { useState } from "react";
import Button from "../components/common/Button";
import { useResume } from "../context/ResumeContext";
import { generateInterviewQuestions } from "../services/interviewService";
import InterviewResult from "../components/interview/InterviewResult";

function InterviewPage() {

    const { resume } = useResume();

    const [loading, setLoading] = useState(false);
    const [result, setResult] = useState(null);

    const handleGenerate = async () => {

        try {

            setLoading(true);

            const response = await generateInterviewQuestions({
                resumeId: resume.resumeId,
            });

            console.log(response);

            setResult(response);

        } catch (error) {

            console.error(error);
            alert("Failed to generate interview questions.");

        } finally {

            setLoading(false);

        }

    };

    return (

        <main className="max-w-7xl mx-auto px-6 py-10">

            <h1 className="text-4xl font-bold">
                Interview Question Generator
            </h1>

            <p className="mt-3 text-gray-600">
                Generate AI-powered interview questions based on your uploaded resume.
            </p>

            <div className="mt-8">

                <Button onClick={handleGenerate}>

                    {loading
                        ? "Generating..."
                        : "Generate Questions"}

                </Button>

                 {
                                result && (

                                    <InterviewResult result={result} />

                                )
                            }

            </div>



        </main>

    );

}

export default InterviewPage;