function KeywordSection({ keywords }) {

    if (!keywords || keywords.length === 0)
        return null;

    return (

        <div className="bg-white rounded-2xl shadow-sm border p-6">

            <h2 className="text-2xl font-bold mb-6">

                🏷 Missing Keywords

            </h2>

            <div className="flex flex-wrap gap-4">

                {

                    keywords.map((keyword, index) => (

                        <span
                            key={index}
                            className="px-4 py-2 rounded-full bg-red-100 text-red-700 font-semibold"
                        >

                            {keyword}

                        </span>

                    ))

                }

            </div>

        </div>

    );

}

export default KeywordSection;