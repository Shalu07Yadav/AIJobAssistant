function FeatureCard({
  icon,
  title,
  description,
  buttonText,
  onClick,
}) {
  return (
    <div className="bg-white rounded-2xl shadow-md p-6 text-center hover:shadow-xl transition">

      <div className="text-5xl mb-4">
        {icon}
      </div>

      <h2 className="text-2xl font-bold mb-3">
        {title}
      </h2>

      <p className="text-gray-600 mb-6">
        {description}
      </p>

      <button
        onClick={onClick}
        className="bg-blue-600 text-white px-5 py-2 rounded-lg hover:bg-blue-700 transition"
      >
        {buttonText}
      </button>

    </div>
  );
}

export default FeatureCard;