import QuestionCategory from "./QuestionCategory";

function InterviewResult({ result }) {

    return (

        <div className="mt-12">

            <QuestionCategory
                title="📁 Project Questions"
                questions={result.projectQuestions}
            />

            <QuestionCategory
                title="💼 Experience Questions"
                questions={result.experienceQuestions}
            />

            <QuestionCategory
                title="💻 Technical Questions"
                questions={result.technicalQuestions}
            />

            <QuestionCategory
                title="🤝 Behavioral Questions"
                questions={result.behavioralQuestions}
            />

        </div>

    );

}

export default InterviewResult;