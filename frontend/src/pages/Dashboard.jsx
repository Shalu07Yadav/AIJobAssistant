import WelcomeBanner from "../components/dashboard/WelcomeBanner";
import ResumeUploadCard from "../components/dashboard/ResumeUploadCard";
import UploadSuccessCard from "../components/dashboard/UploadSuccessCard";
import ToolSection from "../components/dashboard/ToolSection";

import { useResume } from "../context/ResumeContext";
import HeroBackground from "../components/common/HeroBackground";

function Dashboard() {

    const { resume } = useResume();

    return (

        <div className="relative min-h-screen overflow-hidden">

            {/* Background */}
            <HeroBackground />

            {/* Page Content */}
            <main className="relative z-10 max-w-7xl mx-auto px-6 py-10">

                <WelcomeBanner />

                <div className="mt-10">
                    <ResumeUploadCard />
                </div>

                {
                    resume.uploaded ? (
                        <>
                            <UploadSuccessCard />
                            <ToolSection />
                        </>
                    ) : (
                        <div className="mt-10 bg-white border border-blue-200 rounded-2xl p-8 text-center shadow-sm">

                            <h2 className="text-2xl font-bold text-blue-700">

                                🚀 Unlock AI Features

                            </h2>

                            <p className="mt-3 text-gray-600">

                                Upload your resume to start using ATS Analysis,
                                Interview Question Generation,
                                and Resume Optimization.

                            </p>

                        </div>
                    )
                }

            </main>

        </div>

    );

}

export default Dashboard;