import { motion } from "framer-motion";
import preview from "../../assets/heroImg.png";

function HeroPreview() {
  return (
    <div className="relative flex justify-center">

      {/* Background Glow */}
      <div className="absolute w-[520px] h-[520px] rounded-full bg-blue-100 blur-3xl opacity-60"></div>

      {/* Animated Preview */}
      <motion.img
        src={preview}
        alt="AI Job Assistant Preview"
        className="relative w-[650px] rounded-3xl shadow-2xl border border-gray-200"
        animate={{
          scale: [1, 1.03, 1],
          y: [0, -20, 0],
        }}
        transition={{
          duration: 5,
          repeat: Infinity,
          ease: "easeInOut",
        }}
      />

    </div>
  );
}

export default HeroPreview;