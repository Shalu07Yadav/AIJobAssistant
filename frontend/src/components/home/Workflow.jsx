
function Workflow() {


    const steps = [
        {
            number: "01",
            title: "Upload Resume",
            description:
                "Upload your latest resume securely in PDF format."
        },
        {
            number: "02",
            title: "AI Analysis",
            description:
                "Gemini AI analyzes your resume, skills, and experience."
        },
        {
            number: "03",
            title: "Improve & Prepare",
            description:
                "Receive ATS insights, interview questions, and resume improvements."
        }
    ];

    return (
        <section className="py-24 bg-white">


            <div className="max-w-7xl mx-auto px-6">

                <h2 className="text-4xl font-bold text-center">

                    How It Works

                </h2>

                <p className="mt-4 text-center text-gray-500 text-lg">

                    Three simple steps to prepare for your dream job.

                </p>

                <div className="grid md:grid-cols-3 gap-10 mt-16">

                    {steps.map((step) => (

                        <div
                            key={step.number}
                            className="bg-slate-50 rounded-2xl p-8 text-center shadow-sm hover:shadow-lg transition"
                        >

                            <div className="w-16 h-16 rounded-full bg-blue-600 text-white flex items-center justify-center text-2xl font-bold mx-auto">

                                {step.number}

                            </div>

                            <h3 className="mt-6 text-2xl font-bold">

                                {step.title}

                            </h3>

                            <p className="mt-4 text-gray-600 leading-7">

                                {step.description}

                            </p>

                        </div>

                    ))}

                </div>

            </div>



        </section>
    );
}

export default Workflow;