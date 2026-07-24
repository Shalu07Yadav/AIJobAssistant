function UploadSuccessCard() {
    return (
        <div className="mt-8 bg-green-50 border border-green-300 rounded-2xl p-6 shadow-sm">

            <div className="flex items-start gap-4">

                <div className="text-4xl">
                    ✅
                </div>

                <div>

                    <h3 className="text-xl font-bold text-green-700">
                        Resume Uploaded Successfully
                    </h3>

                    <p className="mt-2 text-gray-600">
                        Your resume is now ready for AI analysis.
                        Choose one of the tools below to continue.
                    </p>

                </div>

            </div>

        </div>
    );
}

export default UploadSuccessCard;