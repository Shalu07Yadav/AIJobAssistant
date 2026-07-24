import Button from "../common/Button";
//import { useNavigate } from "react-router-dom";

function FeatureCard({

    icon,
    title,
    description,
    buttonText,
    onClick,

}) {


 // const navigate = useNavigate();

    return (

        <div className="bg-white rounded-2xl shadow-sm p-8 hover:shadow-lg transition-all">

            <div className="text-5xl text-center">
                {icon}
            </div>

            <h3 className="mt-5 text-2xl font-bold text-center">
                {title}
            </h3>

            <p className="mt-4 text-center text-gray-600 min-h-[60px]">
                {description}
            </p>

            <div className="mt-8 flex justify-center">

                <Button onClick={onClick}>
                    {buttonText}
                </Button>




            </div>

        </div>

    );

}

export default FeatureCard;