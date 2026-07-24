import FeedbackCard from "./FeedbackCard";
import SuggestionGrid from "./SuggestionGrid";
import KeywordSection from "./KeywordSection";
import BulletPointSection from "./BulletPointSection";

function OptimizerResult({ result }) {

    return (

        <div className="mt-12 space-y-10">

            <FeedbackCard
                feedback={result.overallFeedback}
            />

            <SuggestionGrid
                result={result}
            />

            <KeywordSection
                keywords={result.missingKeywords}
            />

            <BulletPointSection
                bulletPoints={result.optimizedBulletPoints}
            />

        </div>

    );

}

export default OptimizerResult;