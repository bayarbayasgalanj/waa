import './App.css';
import { TopComponent } from './pages/TopComponent';
import { BottomComponent } from './pages/BottomComponent';

function App() {

  const sayHello = () => {
    console.log('Hello was clicked.'); 
 }

const sayGoodbye = () => {
   console.log('Good bye was clicked.'); 
}

  return (
    <div>
      <TopComponent sayHelloFunction={sayHello} sayGoodbyeFunction={sayGoodbye} />
      <BottomComponent/>
    </div>
  );
}

export default App;
