function FeedbackCard({ feedback }) {

    return (

        <div className="bg-blue-50 border border-blue-200 rounded-2xl p-8 shadow-sm">

            <h2 className="text-2xl font-bold text-blue-700 mb-4">

                📋 Overall Feedback

            </h2>

            <p className="text-gray-700 leading-8">

                {feedback}

            </p>

        </div>

    );

}

export default FeedbackCard;