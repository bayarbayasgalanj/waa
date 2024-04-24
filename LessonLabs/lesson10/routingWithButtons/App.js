import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Pageone, Pagetwo, Pagethree } from './pages';
import './App.css';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<Pageone />} />
          <Route path="/pagetwo" element={<Pagetwo />} />
          <Route path="/pagethree" element={<Pagethree />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
