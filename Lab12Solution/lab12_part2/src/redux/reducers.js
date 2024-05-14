import { UPDATE_CALCULATOR_VALUE } from './actions';

const initialState = {
    calculatorValue: 0,
};

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case UPDATE_CALCULATOR_VALUE:
            return {
                ...state,
                calculatorValue: action.payload,
            };
        default:
            return state;
    }
};

export default reducer;