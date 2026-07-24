import QuestionCard from "./QuestionCard";

function QuestionCategory({

    title,
    questions,

}) {

    if (!questions || questions.length === 0)
        return null;

    return (

        <section className="mt-12">

            <h2 className="text-3xl font-bold mb-6">

                {title}

            </h2>

            <div className="space-y-5">

                {

                    questions.map((question, index) => (

                        <QuestionCard
                            key={index}
                            question={question}
                        />

                    ))

                }

            </div>

        </section>

    );

}

export default QuestionCategory;