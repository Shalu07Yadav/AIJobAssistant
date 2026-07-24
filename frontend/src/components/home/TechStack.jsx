function TechStack() {

    const tech = [

        "React",
        "Spring Boot",
        "Java",
        "PostgreSQL",
        "Gemini AI",
        "Tailwind CSS",
        "REST APIs",
        "JWT",
        "Docker",
        "Git"

    ];

    return (

        <section className="py-24 bg-slate-50">

            <div className="max-w-6xl mx-auto text-center px-6">

                <h2 className="text-4xl font-bold">

                    Built With Modern Technologies

                </h2>

                <p className="mt-4 text-gray-500">

                    A modern full-stack AI application built using industry-standard technologies.

                </p>

                <div className="flex flex-wrap justify-center gap-5 mt-12">

                    {

                        tech.map((item) => (

                            <span
                                key={item}
                                className="bg-white shadow-sm rounded-full px-6 py-3 font-semibold"
                            >

                                {item}

                            </span>

                        ))

                    }

                </div>

            </div>

        </section>

    );

}

export default TechStack;