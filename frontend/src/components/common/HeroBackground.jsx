import { motion } from "framer-motion";

function HeroBackground() {
    return (
        <motion.div
            className="absolute top-0 right-0 h-full w-[45%] pointer-events-none"
            animate={{
                scale: [1, 1.08, 1],
            }}
            transition={{
                duration: 18,
                repeat: Infinity,
                ease: "easeInOut",
            }}
        >
            {/* Blue */}
            <div className="absolute top-10 right-20 w-[420px] h-[420px] rounded-full bg-blue-300 opacity-30 blur-[120px]" />

            {/* Cyan */}
            <div className="absolute top-60 right-0 w-[350px] h-[350px] rounded-full bg-cyan-300 opacity-30 blur-[120px]" />

            {/* Purple */}
            <div className="absolute bottom-10 right-32 w-[400px] h-[400px] rounded-full bg-violet-300 opacity-30 blur-[130px]" />
        </motion.div>
    );
}

export default HeroBackground;