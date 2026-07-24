function SuggestionCard({

    title,
    suggestions,

}) {

    if (!suggestions || suggestions.length === 0)
        return null;

    return (

        <div className="bg-white rounded-2xl shadow-sm border p-6">

            <h3 className="text-xl font-bold mb-5">

                {title}

            </h3>

            <div className="space-y-4">

                {

                    suggestions.map((item, index) => (

                        <div
                            key={index}
                            className="flex gap-3 items-start"
                        >

                            <span className="text-green-600 text-lg">

                                ✔

                            </span>

                            <p className="text-gray-700 leading-7">

                                {item}

                            </p>

                        </div>

                    ))

                }

            </div>

        </div>

    );

}

export default SuggestionCard;