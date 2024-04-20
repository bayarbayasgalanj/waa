import './App.css';
import React, { useState } from 'react';
import CountersContainer from './CountersContainer';

function App() {
  const [mainCounter, setMainCounter] = useState(14);

  const updateMainCounter = (value) => {
    setMainCounter(mainCounter + value);
  };

  return (
    <table>
      <tr>
        <th><h2>{mainCounter}</h2></th>
      </tr>
      <tr>
        <CountersContainer count={mainCounter} updateMainCounter={updateMainCounter} />
      </tr>
    </table>
  );
}

export default App;
