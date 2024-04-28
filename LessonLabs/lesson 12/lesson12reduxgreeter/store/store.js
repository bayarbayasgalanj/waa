import { configureStore } from "@reduxjs/toolkit";

const reducer = (state = {greeting : 'Hello' }, action ) => {
  if (action.type === 'getgreeting'){
      return { greeting : "Hello "+action.name};
  }
  return state;
}

const store = configureStore({
  reducer: reducer
});

export default store;