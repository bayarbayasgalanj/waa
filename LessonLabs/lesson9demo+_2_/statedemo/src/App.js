import './App.css';
import React, {useState} from 'react';
import { TopComponent } from './pages/TopComponent';
import { BottomComponent } from './pages/BottomComponent';

function App() {
  const [message, setMessage] = useState("");

  return (
    <div>
      <TopComponent setMessageFunction={ setMessage} />
      <BottomComponent message={message} />
    </div>
  );
}

export default App;
