import { useState } from "react";
import { useResume } from "../context/ResumeContext";
import Button from "../components/common/Button";
import { analyzeResume } from "../services/atsService";
import ATSResult from "../components/ats/ATSResult";


function ATSPage() {

    const { resume } = useResume();

    const [jobDescription, setJobDescription] = useState("");

    const [loading, setLoading] = useState(false);
    const [result, setResult] = useState(null);



    const handleAnalyze = async () => {

        try {

            setLoading(true);

            const response = await analyzeResume({

                resumeId: resume.resumeId,
                jobDescription,

            });

            console.log(response);

            setResult(response);

        }

        catch (error) {

            console.error(error);

            alert("Analysis Failed");

        }

        finally {

            setLoading(false);

        }

    };

    return (

        <main className="max-w-6xl mx-auto px-6 py-10">

            <h1 className="text-4xl font-bold">
                ATS Resume Analyzer
            </h1>

            <p className="mt-3 text-gray-600">
                Paste the Job Description below and let AI analyze your resume.
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

                <Button onClick={handleAnalyze}>

                    Analyze Resume

                </Button>

                {

                    result && (

                        <ATSResult result={result} />

                    )

                }

            </div>

        </main>

    );

}

export default ATSPage;