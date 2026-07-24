function ATSScoreCard({ score }) {

    const color =
        score >= 80
            ? "text-green-600"
            : score >= 60
            ? "text-yellow-500"
            : "text-red-500";

    return (

        <div className="bg-white rounded-2xl shadow-md p-8 text-center">

            <h2 className="text-2xl font-bold text-gray-700">
                ATS Score
            </h2>

            <p className={`mt-5 text-6xl font-bold ${color}`}>
                {score}%
            </p>

        </div>

    );

}

export default ATSScoreCard;