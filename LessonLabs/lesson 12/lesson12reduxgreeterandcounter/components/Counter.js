import { useSelector, useDispatch } from 'react-redux';

export const Counter = () => {
  const dispatch = useDispatch();
  const counter = useSelector(state => state.counter);
  const greeting = useSelector(state => state.greeting);
  
  const incrementHandler = () => {
    dispatch({ type : 'increment'});
  }

  const decrementHandler = () => {
    dispatch({ type : 'decrement'});
  }

  return (
    <div>
      <h1>Redux Counter</h1>
      <div>The current greeting = {greeting}</div>
      <div>{counter}</div>
      <div>
        <button onClick={incrementHandler}>Increment</button>
        <button onClick={decrementHandler}>Decrement</button>
      </div>
    </div>
  );
};

