import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Calculator from './Calculator';
import Results from './Results';

function App() {
  return (
    <Router>
      <div className="App">
      <h3>Calculator Lab14 Part4</h3>
        <Routes>
          <Route path="/results/:result" element={<Results />} />
          <Route path="/" element={<Calculator />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
