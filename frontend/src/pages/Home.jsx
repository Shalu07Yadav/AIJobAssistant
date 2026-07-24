import MainLayout from "../layouts/MainLayout";
import Hero from "../components/home/Hero";
import Workflow from "../components/home/Workflow";
import WhyChooseUs from "../components/home/WhyChooseUs";
import TechStack from "../components/home/TechStack";
import CTASection from "../components/home/CTASection";


function Home() {
    return (
        <MainLayout>


            <Hero />

            <Workflow />

             <WhyChooseUs />

                <TechStack />

                <CTASection />

        </MainLayout>
    );
}

export default Home;