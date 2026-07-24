import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./pages/Home";
import Dashboard from "./pages/Dashboard";
import ATSPage from "./pages/ATSPage";
import OptimizerPage from "./pages/OptimizerPage";
import InterviewPage from "./pages/InterviewPage";

function App() {
  return (

      <Routes>
        <Route path="/" element={<Home />} />

        <Route path="/dashboard" element={<Dashboard />} />

        <Route path="/ats" element={<ATSPage />} />

<Route
    path="/interview"
    element={<InterviewPage />}
/>

        <Route path="/optimizer" element={<OptimizerPage />} />
      </Routes>

  );
}

export default App;