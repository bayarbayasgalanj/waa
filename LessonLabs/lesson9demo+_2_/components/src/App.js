import {Component1} from './pages/Component1';
import {Component2} from './pages/Component2';
import {Component3} from './pages/Component3';
import {Component4} from './pages/Component4';
import './App.css';

function App() {
  return (
    <table>
    <tr>
      <td><Component1 /></td>
      <td><Component2 /></td>
    </tr>
    <tr>
      <td><Component3 /></td>
      <td><Component4 /></td>
    </tr>
  </table>
  );
}

export default App;
