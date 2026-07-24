import FeatureCard from "./FeatureCard";
import { useNavigate } from "react-router-dom";

function ToolSection() {

const navigate = useNavigate();
    return (

        <section className="mt-12">

            <h2 className="text-4xl font-bold mb-8">
                Choose Your AI Tool
            </h2>

            <div className="grid grid-cols-1 md:grid-cols-3 gap-8">

                                <FeatureCard
                                icon="📊"
                                title="ATS Analyzer"
                                description="Analyze your resume against any Job Description."
                                buttonText="Analyze Resume"
                                onClick={() => navigate("/ats")}
                            />

                            <FeatureCard
                                icon="🤖"
                                title="Interview Generator"
                                description="Generate personalized interview questions."
                                buttonText="Generate Questions"
                                onClick={() => navigate("/interview")}
                            />

                            <FeatureCard
                                icon="✨"
                                title="Resume Optimizer"
                                description="Improve your resume using AI."
                                buttonText="Optimize Resume"
                                onClick={() => navigate("/optimizer")}
                            />

            </div>

        </section>

    );

}

export default ToolSection;