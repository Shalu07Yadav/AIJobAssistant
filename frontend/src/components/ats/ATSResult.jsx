import ATSScoreCard from "./ATSScoreCard";
import SkillsCard from "./SkillsCard";
import RecommendationCard from "./RecommendationCard";

function ATSResult({ result }) {

    return (

        <section className="mt-12 space-y-8">

            <ATSScoreCard score={result.score} />

            <div className="grid md:grid-cols-2 gap-8">

                <SkillsCard
                    title="Matched Skills"
                    skills={result.matchedSkills}
                />

                <SkillsCard
                    title="Missing Skills"
                    skills={result.missingSkills}
                    positive={false}
                />

            </div>

            <div className="grid md:grid-cols-2 gap-8">

                <RecommendationCard
                    title="Strong Points"
                    items={result.strongPoints}
                />

                <RecommendationCard
                    title="Recommendations"
                    items={result.recommendations}
                />

            </div>

        </section>

    );

}

export default ATSResult;