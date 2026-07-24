import Button from "../common/Button";
import { useNavigate } from "react-router-dom";

function CTASection() {

    const navigate = useNavigate();

    return (

        <section className="py-28 bg-gradient-to-r from-blue-600 to-indigo-700 text-white">

            <div className="max-w-5xl mx-auto text-center px-6">

                <h2 className="text-5xl font-bold">

                    Ready to Land Your Dream Job?

                </h2>

                <p className="mt-6 text-xl text-blue-100">

                    Let AI analyze your resume, prepare interview questions,
                    and optimize your profile in minutes.

                </p>

                <div className="mt-10">

                    <Button

                        className="bg-white !text-blue-700 hover:bg-gray-100 px-10 py-4"

                        onClick={() => navigate("/dashboard")}

                    >

                        Start Now

                    </Button>

                </div>

            </div>

        </section>

    );

}

export default CTASection;