import { useSelector, useDispatch } from 'react-redux';

const Counter = () => {
  const dispatch = useDispatch();
  const counter = useSelector(state => state.counter);

  const incrementHandler = () => {
    dispatch({ type : 'increment'});
  }

  const increaseHandler = () => {
    dispatch({ type : 'increase', amount : 5});
  }

  const decrementHandler = () => {
    dispatch({ type : 'decrement'});
  }

  const decreaseHandler = () => {
    dispatch({ type : 'decrease', amount : 5});
  }

  return (
    <div>
      <h1>Redux Counter</h1>
      <div>{counter}</div>
      <div>
        <button onClick={incrementHandler}>Increment by 1</button>
        <button onClick={increaseHandler}>Increment by 5</button>
        <button onClick={decreaseHandler}>Decrement by 5</button>
        <button onClick={decrementHandler}>Decrement by 1</button>
      </div>
    </div>
  );
};

export default Counter;
