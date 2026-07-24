function SkillsCard({

    title,
    skills,
    positive = true,

}) {

    return (

        <div className="bg-white rounded-2xl shadow-md p-6">

            <h2 className="text-2xl font-bold mb-5">

                {title}

            </h2>

            <ul className="space-y-3">

                {

                    skills.map((skill) => (

                        <li
                            key={skill}
                            className="flex items-center gap-3"
                        >

                            <span>

                                {positive ? "✅" : "❌"}

                            </span>

                            {skill}

                        </li>

                    ))

                }

            </ul>

        </div>

    );

}

export default SkillsCard;