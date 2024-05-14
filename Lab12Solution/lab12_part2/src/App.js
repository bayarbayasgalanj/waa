import React from 'react';
import { connect } from 'react-redux';
import Calculator from './Calculator';

const App = ({ calculatorValue }) => {
  return (
    <div className="app">
      <h1>Redux Calculator</h1>
      <Calculator calculatorValue={calculatorValue} />
    </div>
  );
};

const mapStateToProps = (state) => {
  return {
    calculatorValue: state.calculatorValue,
  };
};

export default connect(mapStateToProps)(App);
