import { useState } from "react";
import Button from "../components/common/Button";
import { useResume } from "../context/ResumeContext";
import { optimizeResume } from "../services/optimizerService";
import OptimizerResult from "../components/optimizer/OptimizerResult";

function OptimizerPage() {

    const { resume } = useResume();

    const [jobDescription, setJobDescription] = useState("");
    const [loading, setLoading] = useState(false);
    const [result, setResult] = useState(null);

    const handleOptimize = async () => {

        if (!jobDescription.trim()) {
            alert("Please enter a Job Description.");
            return;
        }

        try {

            setLoading(true);

            const response = await optimizeResume({

                resumeId: resume.resumeId,
                jobDescription,

            });

            console.log(response);

            setResult(response);

        }

        catch (error) {

            console.error(error);

            alert("Resume Optimization Failed");

        }

        finally {

            setLoading(false);

        }

    };

    return (

        <main className="max-w-7xl mx-auto px-6 py-10">

            <h1 className="text-4xl font-bold">
                Resume Optimizer
            </h1>

            <p className="mt-3 text-gray-600">
                Paste the Job Description below and get AI-powered suggestions to improve your resume.
            </p>

            <div className="mt-8">

                <label className="block font-semibold mb-3">
                    Job Description
                </label>

                <textarea
                    rows={12}
                    value={jobDescription}
                    onChange={(e) => setJobDescription(e.target.value)}
                    placeholder="Paste the complete Job Description here..."
                    className="w-full border rounded-xl p-4 resize-none focus:outline-none focus:ring-2 focus:ring-blue-500"
                />

            </div>

            <div className="mt-6">

                <Button onClick={handleOptimize}>

                    {
                        loading
                            ? "Optimizing..."
                            : "Optimize Resume"
                    }

                </Button>

            </div>

            {
                result && (

                    <OptimizerResult result={result} />

                )
            }

        </main>

    );

}

export default OptimizerPage;