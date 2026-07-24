import { Link } from "react-router-dom";

import Button from "./Button";

import { LuBrainCircuit } from "../../constants/icons";

function Navbar() {

    return (

        <header className="sticky top-0 z-50 bg-white/80 backdrop-blur-md border-b border-gray-200">

            <div className="max-w-7xl mx-auto h-20 px-6 flex items-center justify-between">

                {/* Logo */}

                <Link
                    to="/"
                    className="flex items-center gap-3"
                >

                    <div className="bg-blue-600 text-white p-3 rounded-xl">

                        <LuBrainCircuit size={24} />

                    </div>

                    <div>

                        <h1 className="text-xl font-bold text-gray-900">

                            AI Job Assistant

                        </h1>

                        <p className="text-sm text-gray-500">

                            Powered by Gemini AI

                        </p>

                    </div>

                </Link>

                {/* Navigation */}

                <nav className="flex items-center gap-8">

                    <Link
                        to="/"
                        className="hover:text-blue-600 transition-colors"
                    >
                        Home
                    </Link>

                    <a
                        href="#features"
                        className="hover:text-blue-600 transition-colors"
                    >
                        Features
                    </a>

                    <Link
                        to="/dashboard"
                        className="hover:text-blue-600 transition-colors"
                    >
                        Dashboard
                    </Link>

                </nav>

                {/* CTA */}

                <Link to="/dashboard">

                    <Button>

                        Get Started

                    </Button>

                </Link>

            </div>

        </header>

    );

}

export default Navbar;