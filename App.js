import './App.css';
import * as Pages from './pages';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path="/" element={<Pages.Home />} />
          <Route path="/dashboard-examinateur" element={<Pages.DBExaminateur />} />
          <Route path="/ajouter-passe-examen" element={<Pages.AjouterPasseExamen />} />
          <Route path="/dashboard-examine" element={<Pages.DashboardEtudiant />} />
          <Route path="/dashboard-admin" element={<Pages.DBAdmin />} />
          <Route path="/signup" element={<Pages.Register />} />
          <Route path="/login" element={<Pages.Login />} />
          <Route path="/gestion-groupes" element={<Pages.GestionGroupes />} />
          <Route path="/activate-account" element={<Pages.Activate />} />
          <Route path="/gestion-examens" element={<Pages.GestionExamen />} />
          <Route path="/modification-examen/:examenId" element={<Pages.ModificationExamen />} />
          <Route path="/passe-examen/:id" element={<Pages.PasseExamen />} /> {/* Passage de examenId ici */}
          <Route path="/corriger-examen/:userId/:examenId" element={<Pages.CorrectionExamen/>}/>
          <Route path="/consulter-examen/:examenId/:userId" element={<Pages.ConsulterExamen/>}/>  
        </Routes>    
      </Router>
    </div>
  );
}

export default App;
