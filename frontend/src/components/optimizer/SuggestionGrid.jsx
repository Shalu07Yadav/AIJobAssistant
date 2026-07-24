import SuggestionCard from "./SuggestionCard";

function SuggestionGrid({ result }) {

    return (

        <div className="grid md:grid-cols-2 gap-6">

            <SuggestionCard
                title="📝 Summary Suggestions"
                suggestions={result.summarySuggestions}
            />

            <SuggestionCard
                title="💼 Experience Suggestions"
                suggestions={result.experienceSuggestions}
            />

            <SuggestionCard
                title="🚀 Project Suggestions"
                suggestions={result.projectSuggestions}
            />

            <SuggestionCard
                title="🛠 Technical Skill Suggestions"
                suggestions={result.technicalSkillSuggestions}
            />

        </div>

    );

}

export default SuggestionGrid;