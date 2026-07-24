function DifficultyBadge({ difficulty }) {

    let style = "bg-gray-100 text-gray-700";

    switch (difficulty?.toLowerCase()) {

        case "easy":
            style = "bg-green-100 text-green-700";
            break;

        case "medium":
            style = "bg-yellow-100 text-yellow-700";
            break;

        case "hard":
            style = "bg-red-100 text-red-700";
            break;

        default:
            style = "bg-gray-100 text-gray-700";
    }

    return (

        <span
            className={`px-3 py-1 rounded-full text-sm font-semibold ${style}`}
        >
            {difficulty}
        </span>

    );

}

export default DifficultyBadge;