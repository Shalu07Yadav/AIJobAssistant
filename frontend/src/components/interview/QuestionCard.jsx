import DifficultyBadge from "./DifficultyBadge";

function QuestionCard({ question }) {

    return (

        <div className="bg-white rounded-xl shadow-sm border p-6 hover:shadow-md transition">

            <p className="text-lg font-medium leading-8">

                {question.question}

            </p>

            <div className="flex items-center justify-between mt-6">

                <DifficultyBadge
                    difficulty={question.difficulty}
                />

                <span className="text-sm bg-blue-100 text-blue-700 px-3 py-1 rounded-full">

                    {question.relatedSkill}

                </span>

            </div>

        </div>

    );

}

export default QuestionCard;