function RecommendationCard({

    title,
    items,

}) {

    return (

        <div className="bg-white rounded-2xl shadow-md p-6">

            <h2 className="text-2xl font-bold mb-5">

                {title}

            </h2>

            <ul className="space-y-4">

                {

                    items.map((item, index) => (

                        <li key={index}>

                            • {item}

                        </li>

                    ))

                }

            </ul>

        </div>

    );

}

export default RecommendationCard;