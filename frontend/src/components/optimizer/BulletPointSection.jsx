function BulletPointSection({ bulletPoints }) {

    if (!bulletPoints || bulletPoints.length === 0)
        return null;

    return (

        <div className="space-y-6">

            <h2 className="text-3xl font-bold">

                ✨ Optimized Bullet Points

            </h2>

            {

                bulletPoints.map((item, index) => (

                    <div
                        key={index}
                        className="bg-white rounded-2xl shadow-sm border p-6"
                    >

                        <div>

                            <h3 className="font-bold text-red-600 mb-2">

                                Original

                            </h3>

                            <p className="text-gray-700 leading-7">

                                {item.original}

                            </p>

                        </div>

{/*                         <div className="text-center text-3xl my-6"> */}

{/*                             ↓ */}

{/*                         </div> */}

                        <div>

                            <h3 className="font-bold text-green-600 mb-2">

                                Optimized

                            </h3>

                            <p className="text-gray-700 leading-7">

                                {item.optimized}

                            </p>

                        </div>

                    </div>

                ))

            }

        </div>

    );

}

export default BulletPointSection;