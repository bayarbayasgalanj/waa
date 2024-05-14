export const UPDATE_CALCULATOR_VALUE = 'UPDATE_CALCULATOR_VALUE';

export const updateCalculatorValue = (newValue) => ({
    type: UPDATE_CALCULATOR_VALUE,
    payload: newValue,
});