import { HiOutlineDocumentText } from "react-icons/hi";
import { LuBot } from "react-icons/lu";
import { FaRocket } from "react-icons/fa";
import { HiOutlineSparkles } from "react-icons/hi2";
import HeroBackground from "../common/HeroBackground";

function WhyChooseUs() {

    const items = [

        {
            icon: <HiOutlineDocumentText className="text-blue-600 text-5xl" />,
            title: "Upload Once",
            description:
                "Upload your resume only once and use it across all AI tools."
        },

        {
            icon: <LuBot className="text-purple-600 text-5xl" />,
            title: "Gemini AI Powered",
            description:
                "Leverages Google's Gemini AI for intelligent resume analysis."
        },

        {
            icon: <FaRocket className="text-green-600 text-5xl" />,
            title: "Instant Results",
            description:
                "Generate ATS reports, interview questions, and optimization suggestions in seconds."
        },

        {
            icon: <HiOutlineSparkles className="text-yellow-500 text-5xl" />,
            title: "One Platform",
            description:
                "Everything you need to prepare for your dream job in one place."
        }

    ];

    return (

        <section className="relative py-24 overflow-hidden">

            {/* Background */}
            <HeroBackground />

            <div className="relative z-10 max-w-7xl mx-auto px-6">

                <h2 className="text-4xl font-bold text-center">

                    Why Choose AI Job Assistant?

                </h2>

                <div className="grid md:grid-cols-2 lg:grid-cols-4 gap-8 mt-16">

                    {items.map((item) => (

                        <div
                            key={item.title}
                            className="
                                bg-white
                                rounded-2xl
                                p-8
                                text-center
                                shadow-sm
                                hover:shadow-xl
                                hover:-translate-y-2
                                transition-all
                                duration-500
                            "
                        >

                            <div className="flex justify-center">

                                {item.icon}

                            </div>

                            <h3 className="mt-6 text-2xl font-semibold">

                                {item.title}

                            </h3>

                            <p className="mt-4 text-gray-600 leading-7">

                                {item.description}

                            </p>

                        </div>

                    ))}

                </div>

            </div>

        </section>

    );

}

export default WhyChooseUs;