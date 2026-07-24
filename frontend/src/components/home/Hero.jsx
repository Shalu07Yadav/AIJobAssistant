import HeroPreview from "./HeroPreview";
import Button from "../common/Button";
import { useNavigate } from "react-router-dom";

function Hero() {

    const navigate = useNavigate();

    return (

        <section className="max-w-7xl mx-auto px-6 py-24">

            <div className="grid lg:grid-cols-2 gap-16 items-center">

                {/* Left */}

                <div>

                    <span className="inline-flex items-center bg-blue-100 text-blue-700 px-4 py-2 rounded-full text-sm font-semibold">

                        🤖 Powered by Gemini AI

                    </span>

                    <h1 className="mt-8 text-6xl font-extrabold leading-tight text-slate-900">

                        AI Career
                        <br />
                        Assistant

                    </h1>

                    <p className="mt-8 text-xl text-gray-600 leading-9">

                        Upload your resume once and unlock AI-powered ATS
                        analysis, interview preparation, and resume optimization —
                        all in one intelligent platform.

                    </p>

                    <div className="mt-10 flex gap-5">

                        <Button
                            onClick={() => navigate("/dashboard")}
                            className="px-8 py-4"
                        >
                            Get Started
                        </Button>

                        <Button
                            variant="secondary"
                            onClick={() => navigate("/dashboard")}
                            className="px-8 py-4"
                        >
                            View Dashboard
                        </Button>

                    </div>

                </div>

                {/* Right */}

                <HeroPreview />

            </div>

        </section>

    );
}

export default Hero;