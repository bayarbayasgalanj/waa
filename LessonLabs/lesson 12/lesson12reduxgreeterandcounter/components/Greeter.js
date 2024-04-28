import { useSelector, useDispatch } from 'react-redux';
import { useState } from 'react';

export const Greeter = () => {
  const [name, setName] = useState('');
  const dispatch = useDispatch();
  const greetingMessage = useSelector(state => state.greeting);
  const counter = useSelector(state => state.counter);
  
  const greetingHandler = () => {
    dispatch({ type : 'getgreeting', name : name });
  }

  return (
    <div>
      <h1>Redux Greeter</h1>
      <div>The current counter = {counter}</div>
      <div>{greetingMessage}</div>
      <div>
      <div>
          Name
          <input
            type="text"
            placeholder="Your name"
            name="name"
            value={name}
            onChange={e => setName(e.target.value)} />
        </div>
        <button onClick={greetingHandler}>Show greeting</button>
      </div>
    </div>
  );
};

